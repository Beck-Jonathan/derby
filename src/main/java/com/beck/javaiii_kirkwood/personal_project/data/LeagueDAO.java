package com.beck.javaiii_kirkwood.personal_project.data;

import com.beck.javaiii_kirkwood.personal_project.models.League;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.beck.javaiii_kirkwood.personal_project.data.Database.getConnection;

public class LeagueDAO {

  public static int add(League _league) {
    int numRowsAffected=0;try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_League( ?, ?)}")){
          statement.setString(1,_league.getLeague_Name());
          statement.setString(2,_league.getLeague_Level());
          numRowsAffected = statement.executeUpdate();
          if (numRowsAffected == 0) {
            throw new RuntimeException("Could not add League. Try again later");
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not add League. Try again later");
    }
    return numRowsAffected;
  }
  public static League getLeagueByPrimaryKey(League _league) throws SQLException{
    League result = null;
    try(Connection connection = getConnection()) {
      try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_pk_League(?)}")) {
        statement.setString(1, _league.getLeague_ID().toString());

        try (ResultSet resultSet = statement.executeQuery()){
          if(resultSet.next()){Integer League_ID = resultSet.getInt("League_ID");
            String League_Name = resultSet.getString("League_Name");
            String League_Level = resultSet.getString("League_Level");
            result = new League( League_ID, League_Name, League_Level);}
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return result;
  }
  public static List<League> getAllLeague() {
    List<League> result = new ArrayList<>();
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_all_League()}")) {try(ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {Integer League_ID = resultSet.getInt("League_ID");
            String League_Name = resultSet.getString("League_Name");
            String League_Level = resultSet.getString("League_Level");
            League _league = new League( League_ID, League_Name, League_Level);
            result.add(_league);
          }
        }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not retrieve Leagues. Try again later");
    }
    return result;}

}

