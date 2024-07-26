package com.beck.javaiii_kirkwood.budget_app.data;

/// <summary>
///AUTHOR: Jonathan Beck
///<br />
///CREATED: 22/7/2024
///< br />
///An example class to show how code is expected to be written and documented.
///This is where a description of what your file is supposed to contain goes.
///e.g., "Class with helper methods for input validation.",
///Class that defines TransactionDAO Objects.
///</summary>
///< remarks>
///UPDATER: updater_name
///< br />
/// UPDATED: yyyy-MM-dd
/// < br />
/// Update comments go here, include method or methods were changed or added
/// A new remark should be added for each update.
///</remarks>
import com.beck.javaiii_kirkwood.budget_app.models.Transaction;
import com.beck.javaiii_kirkwood.budget_app.models.User;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Locale;

import static com.beck.javaiii_kirkwood.budget_app.data.Database.getConnection;
public class TransactionDAO {
  public static List<Transaction> getTransactionFromFile(File uploadedFile, String type) {
    List<Transaction> result = new ArrayList<>();
    BufferedReader reader;

    try {
      reader = new BufferedReader(new FileReader(uploadedFile));
      String line = reader.readLine();
      ArrayList partsname= new ArrayList(List.of(line.split("\t")));
      if (partsname.get(0).equals("Account Type: Checking")){
        type = "Altra";
      }
      else {
        type = "GreenState";
      }
      //first line is just heading data
      line = reader.readLine();
      if (type.equals("GreenState")) {
        while (line != null) {
          ArrayList parts = new ArrayList(List.of(line.split("\t")));
          Integer Transaction_ID = 0;
          String Account_Num = (String) parts.get(0);
          Integer userID = 1;
          //Date Post_Date = new Date(2024, 5, 5);
          //Date Post_Date = (Date) parts.get(2);
          String Post_Date_String = ((String) parts.get(1));
          java.util.Date utilDate = new SimpleDateFormat("MM/dd/yyyy").parse(Post_Date_String);

          java.sql.Date Post_Date = new java.sql.Date(utilDate.getTime());
          Integer Check_No = 0;
          if (parts.get(2) != null && !parts.get(2).equals("")) {
            Check_No = Integer.valueOf((String) parts.get(2));
          }

          String Description = (String) parts.get(3);
          Double debitAmount = 0d;
          Double creditAmount = 0d;
          if (parts.get(5).equals("")) {
            creditAmount = 0d;
          } else {
            creditAmount = Double.valueOf((String) parts.get(5));
          }
          if (parts.get(4).equals("")) {
            debitAmount = 0d;
          } else {
            debitAmount = Double.valueOf((String) parts.get(4));
          }
          Double Amount = creditAmount - debitAmount;
          String Type = Amount > 0 ? "Credit" : "Debit";
          String Status = (String) parts.get(6);
          Transaction _transaction = new Transaction(Transaction_ID, userID,"undefined" ,Account_Num, Post_Date, Check_No, Description, Amount, Type, Status);
          result.add(_transaction);
          // read next line
          line = reader.readLine();
        }
      }
      if (type.equals("Altra")) {

        ArrayList AcctNum = new ArrayList(List.of(line.split("\t")));
        ArrayList AcctNum2 = new ArrayList(List.of(((String) AcctNum.get(0)).split(":")));
        String Account_Num = (String) AcctNum2.get(1);
        line = reader.readLine();
        line = reader.readLine();
        line = reader.readLine();
        line = reader.readLine();

        while (line != null) {

          ArrayList parts = new ArrayList(List.of(line.split("\t")));
          Integer userID = 1;
          Integer Transaction_ID = 0;

          String Post_Date_String = ((String) parts.get(1));
          java.util.Date utilDate = new SimpleDateFormat("MM/dd/yyyy").parse(Post_Date_String);

          java.sql.Date Post_Date = new java.sql.Date(utilDate.getTime());

          Integer Check_No = 0;
          if (parts.size() > 6 && parts.get(6) != null && !parts.get(6).equals("")) {
            Check_No = Integer.valueOf((String) parts.get(6));
          }

          String Description = (String) parts.get(3);

          Double Amount = Double.valueOf((String) parts.get(4));
          String Type = Amount > 0 ? "Credit" : "Debit";
          String Status = "Posted";
          Transaction _transaction = new Transaction(Transaction_ID, userID,"undefined" ,Account_Num, Post_Date, Check_No, Description, Amount, Type, Status);
          result.add(_transaction);
          // read next line
          line = reader.readLine();
        }
      }

      reader.close();

    } catch (Exception e) {
      throw new RuntimeException("Could not retrieve Transactions. Try again later");
    }
    return result;
  }
  public static int add(Transaction _transaction) {
    int numRowsAffected=0;
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_Transaction( ?,?, ?, ?, ?, ?, ?, ?, ?)}")){
          statement.setInt(1,_transaction.getUser_ID());
          statement.setString(2,"Uncategorized");
          statement.setString(3,_transaction.getAccount_Num());
          statement.setDate(4,_transaction.getPost_Date());
          statement.setInt(5,_transaction.getCheck_No());
          statement.setString(6,_transaction.getDescription());
          statement.setDouble(7,_transaction.getAmount());
          statement.setString(8,_transaction.getType());
          statement.setString(9,_transaction.getStatus());
          numRowsAffected = statement.executeUpdate();
          if (numRowsAffected == 0) {
            throw new RuntimeException("Could not add Transaction. Try again later");
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not add Transaction. Try again later");
    }
    return numRowsAffected;
  }

  public static int addBatch(List<Transaction> _transactions, List<Boolean> Exists){
    int added=0;
    boolean result=true;
    int index=0;
    try (Connection connection = getConnection()) {
      if (connection != null) {
        for (Transaction _transaction : _transactions){
        try (CallableStatement statement = connection.prepareCall("{CALL sp_transaction_exists( ?, ?, ?, ?, ?)}")) {

          statement.setInt(1, _transaction.getUser_ID());
          statement.setString(2, _transaction.getAccount_Num());
          statement.setDouble(3, _transaction.getAmount());
          statement.setString(4, _transaction.getDescription());
          statement.setDate(5, _transaction.getPost_Date());

          try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
              result = (resultSet.getInt(1) == 1);
            }
            Exists.set(index,result);
            added++;
            index++;
            System.out.println(index);
          }
        }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not add Transaction. Try again later");
    }

    index=0;
    try (Connection connection = getConnection()) {
      if (connection != null) {
        for (Transaction _transaction : _transactions) {
          System.out.println(index);
          if (!Exists.get(index)) {
            try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_Transaction( ?,?, ?, ?, ?, ?, ?, ?, ?)}")) {
              statement.setInt(1, _transaction.getUser_ID());
              statement.setString(2, "Uncategorized");
              statement.setString(3, _transaction.getAccount_Num());
              statement.setDate(4, _transaction.getPost_Date());
              statement.setInt(5, _transaction.getCheck_No());
              statement.setString(6, _transaction.getDescription());
              statement.setDouble(7, _transaction.getAmount());
              statement.setString(8, _transaction.getType());
              statement.setString(9, _transaction.getStatus());
              int numRowsAffected = statement.executeUpdate();

              if (numRowsAffected == 0) {
                throw new RuntimeException("Could not add Transaction. Try again later");
              }
            }
          }
          index++;

        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not add Transaction. Try again later");
    }
    //return numRowsAffected;


    return added;

  }
  public static List<Transaction> getTransactionByUser(User _user) throws SQLException{
    List<Transaction> result = new ArrayList<>();
    try(Connection connection = getConnection()) {
      try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_user_Transaction(?)}")) {
        statement.setInt(1, _user.getUser_ID());

        try (ResultSet resultSet = statement.executeQuery()){
          while (resultSet.next()){
            Integer Transaction_ID = resultSet.getInt("Transaction_Transaction_ID");
            Integer User_ID = resultSet.getInt("Transaction_User_ID");
            String Category_ID = resultSet.getString("Transaction_Category_ID");
            String Account_Num = resultSet.getString("Transaction_Account_Num");
            Date Post_Date = resultSet.getDate("Transaction_Post_Date");
            Integer Check_No = resultSet.getInt("Transaction_Check_No");
            String Description = resultSet.getString("Transaction_Description");
            Double Amount = resultSet.getDouble("Transaction_Amount");
            String Type = resultSet.getString("Transaction_Type");
            String Status = resultSet.getString("Transaction_Status");
            Integer User_User_ID = resultSet.getInt("User_User_ID");
            String User_User_Name = resultSet.getString("User_User_Name");
            //String User_User_PW = resultSet.getString("User_User_PW");
            String User_Email = resultSet.getString("User_Email");
            //String Category_Category_ID = resultSet.getString("Category_Category_ID");
            Transaction _result = new Transaction( Transaction_ID, User_ID, Category_ID, Account_Num, Post_Date, Check_No, Description, Amount, Type, Status);
          result.add(_result);
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return result;
  }

}

