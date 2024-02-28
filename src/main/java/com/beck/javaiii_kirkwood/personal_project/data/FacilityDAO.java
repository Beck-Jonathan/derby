package com.beck.javaiii_kirkwood.personal_project.data;

import com.beck.javaiii_kirkwood.personal_project.models.Facility;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.beck.javaiii_kirkwood.personal_project.data.Database.getConnection;

/// <summary>
///AUTHOR: Jonathan Beck
///<br />
///CREATED: 23/2/2024
///< br />
///An example class to show how code is expected to be written and documented.
///This is where a description of what your file is supposed to contain goes.
///e.g., "Class with helper methods for input validation.",
///Class that defines FacilityDAO Objects.
///</summary>
///< remarks>
///UPDATER: updater_name
///< br />
/// UPDATED: yyyy-MM-dd
/// < br />
/// Update comments go here, include method or methods were changed or added
/// A new remark should be added for each update.
///</remarks>
public class FacilityDAO {

  public static int add(Facility _facility) {
    int numRowsAffected=0;try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_Facility( ?, ?, ?, ?, ?)}")){
          statement.setString(1,_facility.getName());
          statement.setString(2,_facility.getAddresss());
          statement.setString(3,_facility.getCity());
          statement.setString(4,_facility.getState());
          statement.setString(5,_facility.getZip());
          numRowsAffected = statement.executeUpdate();
          if (numRowsAffected == 0) {
            throw new RuntimeException("Could not add Facility. Try again later");
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not add Facility. Try again later");
    }
    return numRowsAffected;
  }
  public static Facility getFacilityByPrimaryKey(Facility _facility) throws SQLException{
    Facility result = null;
    try(Connection connection = getConnection()) {
      try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_pk_Facility(?)}")) {
        statement.setString(1, _facility.getFacility_ID().toString());

        try (ResultSet resultSet = statement.executeQuery()){
          if(resultSet.next()){Integer Facility_ID = resultSet.getInt("Facility_ID");
            String Name = resultSet.getString("Name");
            String Addresss = resultSet.getString("Addresss");
            String City = resultSet.getString("City");
            String State = resultSet.getString("State");
            String Zip = resultSet.getString("Zip");
            result = new Facility( Facility_ID, Name, Addresss, City, State, Zip);}
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return result;
  }
  public static List<Facility> getAllFacility() {
    List<Facility> result = new ArrayList<>();
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_all_Facility()}")) {try(ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {Integer Facility_ID = resultSet.getInt("Facility_ID");
            String Name = resultSet.getString("Name");
            String Addresss = resultSet.getString("Addresss");
            String City = resultSet.getString("City");
            String State = resultSet.getString("State");
            String Zip = resultSet.getString("Zip");
            Facility _facility = new Facility( Facility_ID, Name, Addresss, City, State, Zip);
            result.add(_facility);
          }
        }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not retrieve Facilitys. Try again later");
    }
    return result;}

}
