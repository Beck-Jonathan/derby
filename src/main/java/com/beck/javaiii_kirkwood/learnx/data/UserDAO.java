package com.beck.javaiii_kirkwood.learnx.data;

import com.beck.javaiii_kirkwood.learnx.Models.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

public class UserDAO {
  public static void main(String[] args) throws SQLException {
    Database.getConnection();
    try {
      System.out.println(getUserByPrimaryKey("fizzle@aol.com"));
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    ArrayList Users = (ArrayList) getAllUsers();
    Users.forEach(System.out::println);
  }

  public static User getUserByPrimaryKey(String __email) throws SQLException {
    User result = null;
    try (Connection connection = Database.getConnection()) {
      try (CallableStatement statement = connection.prepareCall("{CALL sp_get_user(?)}")) {
        statement.setString(1, __email);

        try (ResultSet resultSet = statement.executeQuery()) {
          if (resultSet.next()) {

            int ID = resultSet.getInt("id");
            String first_name= resultSet.getString("first_name");
            String last_name= resultSet.getString("last_name");
            String email= resultSet.getString("email");
            String phone= resultSet.getString("phone");
            byte[] password= resultSet.getBytes("password");
            String status= resultSet.getString("status");
            String privileges= resultSet.getString("privileges");
            Instant created_at= resultSet.getTimestamp("created_at").toInstant();
            Instant last_logged_in= resultSet.getTimestamp("last_logged_in").toInstant();
            Instant updated_at= resultSet.getTimestamp("updated_at").toInstant();
            String language= resultSet.getString("language");
            result = new User(ID,first_name,last_name,email,phone,password,status,privileges,created_at,last_logged_in,updated_at,language);
          }
        }
      }
    } catch (SQLException e) {
      System.out.println(e.getSQLState());
    }
    return result;
  }

  public static List<User> getAllUsers() throws SQLException {
    List<User> results = new ArrayList<>();
    try (Connection connection = Database.getConnection()) {
      try (CallableStatement statement = connection.prepareCall("{CALL sp_get_all_users()}")) {


        try (ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {

            int ID = resultSet.getInt("id");
            String first_name= resultSet.getString("first_name");
            if(resultSet.wasNull()){first_name="";}
            String last_name= resultSet.getString("last_name");
            if(resultSet.wasNull()){last_name="";}
            String email= resultSet.getString("email");
            if(resultSet.wasNull()){email="";}
            String phone= resultSet.getString("phone");
            if(resultSet.wasNull()){phone="";}
            byte[] password= resultSet.getBytes("password");
            //if(resultSet.wasNull()){password="";}
            String status= resultSet.getString("status");
            if(resultSet.wasNull()){status="";}
            String privileges= resultSet.getString("privileges");
            if(resultSet.wasNull()){privileges="";}
            Instant created_at= resultSet.getTimestamp("created_at").toInstant();
            if(resultSet.wasNull()){created_at=new Date().toInstant();}
            Instant last_logged_in= resultSet.getTimestamp("last_logged_in").toInstant();
            if(resultSet.wasNull()){last_logged_in=new Date().toInstant();;}
            Instant updated_at= resultSet.getTimestamp("updated_at").toInstant();
            if(resultSet.wasNull()){updated_at=new Date().toInstant();;}
            String language= resultSet.getString("language");
            if(resultSet.wasNull()){language="";}
            User result = new User(ID,first_name,last_name,email,phone,password,status,privileges,created_at,last_logged_in,updated_at,language);
            results.add(result);
          }
        }
      }
    } catch (SQLException e) {
      System.out.println(e.getSQLState());
    }
    return results;
  }
}
