package com.beck.javaiii_kirkwood.personal_project.data;

import com.beck.javaiii_kirkwood.personal_project.models.Event;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import static com.beck.javaiii_kirkwood.personal_project.data.Database.getConnection;


  public class EventDAO {

    public static int add(Event _event) {
      int numRowsAffected = 0;
      try (Connection connection = getConnection()) {
        if (connection != null) {
          try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_Event( ?, ?, ?)}")) {
            statement.setInt(1, _event.getFacility_ID());
            statement.setDate(2, Date.valueOf(_event.getDate()));

            statement.setInt(3, _event.getType_ID());
            numRowsAffected = statement.executeUpdate();
            if (numRowsAffected == 0) {
              throw new RuntimeException("Could not add Event. Try again later");
            }
          }
        }
      } catch (SQLException e) {
        throw new RuntimeException("Could not add Event. Try again later");
      }
      return numRowsAffected;
    }

    public static Event getEventByPrimaryKey(Event _event) throws SQLException {
      Event result = null;
      try (Connection connection = getConnection()) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_pk_Event(?)}")) {
          statement.setString(1, _event.getEvent_ID().toString());

          try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
              Integer Event_ID = resultSet.getInt("Event_ID");
              Integer Facility_ID = resultSet.getInt("Facility_ID");
              LocalDate Date = resultSet.getDate("Date").toLocalDate();
              Integer Type_ID = resultSet.getInt("Type_ID");
              result = new Event(Event_ID, Facility_ID, Date, Type_ID);
            }
          }
        }
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
      return result;
    }

    public static List<Event> getAllEvent() {
      List<Event> result = new ArrayList<>();
      try (Connection connection = getConnection()) {
        if (connection != null) {
          try (CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_all_Event()}")) {
            try (ResultSet resultSet = statement.executeQuery()) {
              while (resultSet.next()) {
                Integer Event_ID = resultSet.getInt("Event_ID");
                Integer Facility_ID = resultSet.getInt("Facility_ID");
                LocalDate Date = resultSet.getDate("Date").toLocalDate();
                Integer Type_ID = resultSet.getInt("Type_ID");
                Event _event = new Event(Event_ID, Facility_ID, Date, Type_ID);
                result.add(_event);
              }
            }
          }
        }
      } catch (SQLException e) {
        throw new RuntimeException("Could not retrieve Events. Try again later");
      }
      return result;
    }

  }
