package com.beck.javaiii_kirkwood.personal_project.data;

import com.beck.javaiii_kirkwood.personal_project.models.User_Event_Line;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.beck.javaiii_kirkwood.personal_project.data.Database.getConnection;

public class User_Event_LineDAO {

  public static int add(User_Event_Line _user_event_line) {
    int numRowsAffected=0;try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_User_Event_Line( ?, ?, ?, ?)}")){
          statement.setInt(1,_user_event_line.getUser_ID());
          statement.setInt(2,_user_event_line.getEvent_ID());
          statement.setDate(3, Date.valueOf(_user_event_line.getDate_assgined()));
          statement.setBoolean(4,_user_event_line.getis_active());
          numRowsAffected = statement.executeUpdate();
          if (numRowsAffected == 0) {
            throw new RuntimeException("Could not add User_Event_Line. Try again later");
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not add User_Event_Line. Try again later");
    }
    return numRowsAffected;
  }
  public static User_Event_Line getUser_Event_LineByPrimaryKey(User_Event_Line _user_event_line) throws SQLException{
    User_Event_Line result = null;
    try(Connection connection = getConnection()) {
      try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_pk_User_Event_Line(?)}")) {
        statement.setString(1, _user_event_line.getUser_ID().toString());
        statement.setString(1, _user_event_line.getEvent_ID().toString());

        try (ResultSet resultSet = statement.executeQuery()){
          if(resultSet.next()){Integer User_ID = resultSet.getInt("User_ID");
            Integer Event_ID = resultSet.getInt("Event_ID");
            LocalDate Date_assgined = resultSet.getDate("Date_assgined").toLocalDate();
            boolean is_active = resultSet.getBoolean("is_active");
            result = new User_Event_Line( User_ID, Event_ID, Date_assgined, is_active);}
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return result;
  }
  public static List<User_Event_Line> getAllUser_Event_Line() {
    List<User_Event_Line> result = new ArrayList<>();
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_all_User_Event_Line()}")) {try(ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {Integer User_ID = resultSet.getInt("User_ID");
            Integer Event_ID = resultSet.getInt("Event_ID");
            LocalDate Date_assgined = resultSet.getDate("Date_assgined").toLocalDate();
            boolean is_active = resultSet.getBoolean("is_active");
            User_Event_Line _user_event_line = new User_Event_Line( User_ID, Event_ID, Date_assgined, is_active);
            result.add(_user_event_line);
          }
        }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not retrieve User_Event_Lines. Try again later");
    }
    return result;}

}

