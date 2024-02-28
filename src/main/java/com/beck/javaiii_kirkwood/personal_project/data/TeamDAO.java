package com.beck.javaiii_kirkwood.personal_project.data;

import com.beck.javaiii_kirkwood.personal_project.models.Team;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.beck.javaiii_kirkwood.personal_project.data.Database.getConnection;

public class TeamDAO  {

  public static int add(Team _team) {
    int numRowsAffected=0;try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_Team( ?, ?, ?, ?, ?, ?)}")){
          statement.setInt(1,_team.getLeague_ID());
          statement.setString(2,_team.getTeam_Name());
          statement.setString(3,_team.getTeam_Primary_Color());
          statement.setString(4,_team.getTeam_City());
          statement.setString(5,_team.getTeam_State());
          statement.setString(6,_team.getLogo());
          numRowsAffected = statement.executeUpdate();
          if (numRowsAffected == 0) {
            throw new RuntimeException("Could not add Team. Try again later");
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not add Team. Try again later");
    }
    return numRowsAffected;
  }
  public static Team getTeamByPrimaryKey(Team _team) throws SQLException{
    Team result = null;
    try(Connection connection = getConnection()) {
      try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_pk_Team(?)}")) {
        statement.setString(1, _team.getTeam_ID().toString());

        try (ResultSet resultSet = statement.executeQuery()){
          if(resultSet.next()){Integer Team_ID = resultSet.getInt("Team_ID");
            Integer League_ID = resultSet.getInt("League_ID");
            String Team_Name = resultSet.getString("Team_Name");
            String Team_Primary_Color = resultSet.getString("Team_Primary_Color");
            String Team_City = resultSet.getString("Team_City");
            String Team_State = resultSet.getString("Team_State");
            String Logo = resultSet.getString("Logo");
            result = new Team( Team_ID, League_ID, Team_Name, Team_Primary_Color, Team_City, Team_State, Logo);}
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return result;
  }
  public static List<Team> getAllTeam() {
    List<Team> result = new ArrayList<>();
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_all_Team()}")) {try(ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {Integer Team_ID = resultSet.getInt("Team_ID");
            Integer League_ID = resultSet.getInt("League_ID");
            String Team_Name = resultSet.getString("Team_Name");
            String Team_Primary_Color = resultSet.getString("Team_Primary_Color");
            String Team_City = resultSet.getString("Team_City");
            String Team_State = resultSet.getString("Team_State");
            String Logo = resultSet.getString("Logo");
            Team _team = new Team( Team_ID, League_ID, Team_Name, Team_Primary_Color, Team_City, Team_State, Logo);
            result.add(_team);
          }
        }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not retrieve Teams. Try again later");
    }
    return result;}

}
