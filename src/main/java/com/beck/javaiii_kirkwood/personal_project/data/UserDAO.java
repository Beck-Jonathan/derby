package com.beck.javaiii_kirkwood.personal_project.data;

import com.beck.javaiii_kirkwood.personal_project.models.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.beck.javaiii_kirkwood.personal_project.data.Database.getConnection;
public class UserDAO {

  public static int add(User _user) {
    int numRowsAffected=0;try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_User( ?, ?, ?, ?, ?)}")) {
          statement.setString(1, _user.getUser_Name());
          statement.setString(2, _user.getUser_PW());
          statement.setString(3, _user.getStatus());
          statement.setString(4, _user.getEmail());
          statement.setString(5, _user.getprivileges());
          numRowsAffected = statement.executeUpdate();
          if (numRowsAffected == 0) {
            throw new RuntimeException("Could not add User. Try again later");
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not add User. Try again later");
    }
    return numRowsAffected;
  }
  public static User getUserByPrimaryKey(User _user) throws SQLException{
    User result = null;
    try(Connection connection = getConnection()) {
      try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_pk_User(?)}")) {
        statement.setString(1, _user.getUser_ID().toString());

        try (ResultSet resultSet = statement.executeQuery()){
          if(resultSet.next()){Integer User_ID = resultSet.getInt("User_ID");
            String User_Name = resultSet.getString("User_Name");
            String User_PW = resultSet.getString("User_PW");
            String Status = resultSet.getString("Status");
            String Email = resultSet.getString("Email");
            String privileges = resultSet.getString("privileges");
            result = new User( User_ID, User_Name, User_PW, Status, Email, privileges);}
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return result;
  }
  public static List<User> getAllUser() {
    List<User> result = new ArrayList<>();
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_all_User()}")) {try(ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {Integer User_ID = resultSet.getInt("User_ID");
            String User_Name = resultSet.getString("User_Name");
            String User_PW = resultSet.getString("User_PW");
            String Status = resultSet.getString("Status");
            String Email = resultSet.getString("Email");
            String privileges = resultSet.getString("privileges");
            User _user = new User( User_ID, User_Name, User_PW, Status, Email, privileges);
            result.add(_user);
          }
        }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not retrieve Users. Try again later");
    }
    return result;}

}

