package com.beck.javaiii_kirkwood.personal_project.data;

/// <summary>
///AUTHOR: Jonathan Beck
///<br />
///CREATED: 18/3/2024
///< br />
///An example class to show how code is expected to be written and documented.
///This is where a description of what your file is supposed to contain goes.
///e.g., "Class with helper methods for input validation.",
///Class that defines TeamDAO Objects.
///</summary>
///< remarks>
///UPDATER: updater_name
///< br />
/// UPDATED: yyyy-MM-dd
/// < br />
/// Update comments go here, include method or methods were changed or added
/// A new remark should be added for each update.
///</remarks>
import com.beck.javaiii_kirkwood.personal_project.models.Team;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static com.beck.javaiii_kirkwood.personal_project.data.Database.getConnection;
public class TeamDAO {

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
            boolean is_active = resultSet.getBoolean("is_active");
            result = new Team( Team_ID, League_ID, Team_Name, Team_Primary_Color, Team_City, Team_State, Logo, is_active);}
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
            boolean is_active = resultSet.getBoolean("is_active");
            Team _team = new Team( Team_ID, League_ID, Team_Name, Team_Primary_Color, Team_City, Team_State, Logo, is_active);
            result.add(_team);
          }
        }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not retrieve Teams. Try again later");
    }
    return result;}
  public static List<Team> getActiveTeam() {
    List<Team> result = new ArrayList<>();
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_active_Team()}")) {try(ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {Integer Team_ID = resultSet.getInt("Team_ID");
            Integer League_ID = resultSet.getInt("League_ID");
            String Team_Name = resultSet.getString("Team_Name");
            String Team_Primary_Color = resultSet.getString("Team_Primary_Color");
            String Team_City = resultSet.getString("Team_City");
            String Team_State = resultSet.getString("Team_State");
            String Logo = resultSet.getString("Logo");
            boolean is_active = resultSet.getBoolean("is_active");
            Team _team = new Team( Team_ID, League_ID, Team_Name, Team_Primary_Color, Team_City, Team_State, Logo, is_active);
            result.add(_team);
          }
        }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not retrieve Teams. Try again later");
    }
    return result;}

  public static int update(Team oldTeam, Team newTeam) throws SQLException{
    int result = 0;
    try (Connection connection = getConnection()) {
      if (connection !=null){
        try(CallableStatement statement = connection.prepareCall("{CALL sp_update_Team(? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"))
        {
          statement.setInt(1,oldTeam.getTeam_ID());
          statement.setInt(2,oldTeam.getLeague_ID());
          statement.setInt(3,newTeam.getLeague_ID());
          statement.setString(4,oldTeam.getTeam_Name());
          statement.setString(5,newTeam.getTeam_Name());
          statement.setString(6,oldTeam.getTeam_Primary_Color());
          statement.setString(7,newTeam.getTeam_Primary_Color());
          statement.setString(8,oldTeam.getTeam_City());
          statement.setString(9,newTeam.getTeam_City());
          statement.setString(10,oldTeam.getTeam_State());
          statement.setString(11,newTeam.getTeam_State());
          statement.setString(12,oldTeam.getLogo());
          statement.setString(13,newTeam.getLogo());
          statement.setBoolean(14,oldTeam.getis_active());
          statement.setBoolean(15,newTeam.getis_active());
          statement.executeUpdate();
        } catch (SQLException e) {
          throw new RuntimeException("Could not update Team . Try again later");
        }
      }
    }
    return result;
  }
  public static int deleteTeam(int teamID) {
    int rowsAffected=0;
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_Delete_Team( ?)}")){
          statement.setInt(1,teamID);
          rowsAffected = statement.executeUpdate();
          if (rowsAffected == 0) {
            throw new RuntimeException("Could not Delete Team. Try again later");
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not Delete Team. Try again later");
    }
    return rowsAffected;
  }
  public static int undeleteTeam(int teamID) {
    int rowsAffected=0;
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_unDelete_Team( ?)}")){
          statement.setInt(1,teamID);
          rowsAffected = statement.executeUpdate();
          if (rowsAffected == 0) {
            throw new RuntimeException("Could not Restore Team. Try again later");
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not Restore Team. Try again later");
    }
    return rowsAffected;
  }

}

