package com.beck.javaiii_kirkwood.personal_project.data;/// <summary>
///AUTHOR: Jonathan Beck
///<br />
///CREATED: 3/3/2024
///< br />
///An example class to show how code is expected to be written and documented.
///This is where a description of what your file is supposed to contain goes.
///e.g., "Class with helper methods for input validation.",
///Class that defines UserDAO Objects.
///</summary>
///< remarks>
///UPDATER: updater_name
///< br />
/// UPDATED: yyyy-MM-dd
/// < br />
/// Update comments go here, include method or methods were changed or added
/// A new remark should be added for each update.
///</remarks>

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
        try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_User( ?, ?, ?, ?, ?, ?)}")){
          statement.setString(1,_user.getUser_Name());
          statement.setString(2,_user.getUser_PW());
          statement.setInt(3,_user.getStatus_ID());
          statement.setString(4,_user.getEmail());
          statement.setInt(5,_user.getLanguage_ID());
          statement.setInt(6,_user.getPrivilege_ID());
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
            Integer Status_ID = resultSet.getInt("Status_ID");
            String Email = resultSet.getString("Email");
            Integer Language_ID = resultSet.getInt("Language_ID");
            Integer Privilege_ID = resultSet.getInt("Privilege_ID");
            result = new User( User_ID, User_Name, User_PW, Status_ID, Email, Language_ID, Privilege_ID);}
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
            Integer Status_ID = resultSet.getInt("Status_ID");
            String Email = resultSet.getString("Email");
            Integer Language_ID = resultSet.getInt("Language_ID");
            Integer Privilege_ID = resultSet.getInt("Privilege_ID");
            User _user = new User( User_ID, User_Name, User_PW, Status_ID, Email, Language_ID, Privilege_ID);
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
