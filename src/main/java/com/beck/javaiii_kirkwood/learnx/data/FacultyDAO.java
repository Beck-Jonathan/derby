//package com.beck.DataAccess;
//
//import com.beck.model.Facility;
//
//import java.security.NoSuchAlgorithmException;
//import java.security.spec.InvalidKeySpecException;
//import java.sql.CallableStatement;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import static com.beck.DataAccess.DBConnection.getConnection;
//
//public class FacilityDAO extends DBConnection {
//
//  public static Facility getFacilityByPrimaryKey(Facility _facility) throws SQLException {
//    Facility result = null;
//    try (Connection connection = getConnection()) {
//      try (CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_pk_Facility(?)}")) {
//        statement.setString(1, _facility.getFacility_ID().toString());
//
//        try (ResultSet resultSet = statement.executeQuery()) {
//          if (resultSet.next()) {
//            Integer Facility_ID = resultSet.getInt("Facility_ID");
//            String City = resultSet.getString("City");
//            String Sttate = resultSet.getString("Sttate");
//            String Zip = resultSet.getString("Zip");
//            String Facility_Name = resultSet.getString("Facility_Name");
//            result = new Facility(Facility_ID, City, Sttate, Zip, Facility_Name);
//          }
//        }
//      }
//    } catch (SQLException e) {
//      throw new RuntimeException(e);
//    }
//    return result;
//  }
//
//  public static List<Facility> getAllFacility() {
//    List<Facility> result = new ArrayList<>();
//    try (Connection connection = getConnection()) {
//      if (connection != null) {
//        try (CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_all_Facility()}")) {
//          try (ResultSet resultSet = statement.executeQuery()) {
//            while (resultSet.next()) {
//              Integer Facility_ID = resultSet.getInt("Facility_ID");
//              if(resultSet.wasNull()) { Facility_ID=0;}
//              String City = resultSet.getString("City");
//              if(resultSet.wasNull()){City="";}
//              String Sttate = resultSet.getString("Sttate");
//              String Zip = resultSet.getString("Zip");
//              String Facility_Name = resultSet.getString("Facility_Name");
//              Facility _facility = new Facility(Facility_ID, City, Sttate, Zip, Facility_Name);
//              result.add(_facility);
//            }
//          }
//        }
//      }
//    } catch (SQLException e) {
//      throw new RuntimeException("Could not retrieve Facilitys. Try again later");
//    }
//    return result;
//  }
//
//  public static int add(Facility _facility) throws SQLException {
//    int numRowsAffected = 0;
//    try (Connection connection = getConnection()) {
//      if (connection != null) {
//        try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_Facility( ?, ?, ?, ?, ?)}")) {
//          statement.setInt(1, _facility.getFacility_ID());
//          statement.setString(2, _facility.getCity());
//          statement.setString(3, _facility.getSttate());
//          statement.setString(4, _facility.getZip());
//          statement.setString(5, _facility.getFacility_Name());
//          numRowsAffected = statement.executeUpdate();
//          if (numRowsAffected == 0) {
//            throw new RuntimeException("Could not update user. Try again later");
//          }
//        }
//      }
//    } catch (SQLException e) {
//      throw new RuntimeException("Could not update user. Try again later");
//    }
//    return numRowsAffected;
//  }
//
//}
