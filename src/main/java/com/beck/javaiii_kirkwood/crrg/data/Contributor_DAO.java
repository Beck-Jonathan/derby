package com.beck.javaiii_kirkwood.crrg.data;
import com.beck.javaiii_kirkwood.crrg.data_interfaces.iContributor_DAO;
import com.beck.javaiii_kirkwood.crrg.models.Contributor;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.beck.javaiii_kirkwood.crrg.data.Database.getConnection;

public class Contributor_DAO implements  iContributor_DAO{
  /**
   * DAO Method to add Contributor objects
   * @param _contributor the Contributor to be added
   * @return number of records added
   * @author Jonathan Beck
   */
  @Override
  public int add(Contributor _contributor) {
    int numRowsAffected=0;try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_Contributor( ?, ?, ?)}")){
          statement.setString(1,_contributor.getFirst_Name());
          statement.setString(2,_contributor.getLast_Name());
          statement.setString(3,_contributor.getemail());
          numRowsAffected = statement.executeUpdate();
          if (numRowsAffected == 0) {
            throw new RuntimeException("Could not add Contributor. Try again later");
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not add Contributor. Try again later");
    }
    return numRowsAffected;
  }

  /**
   * DAO Method to retreive all Contributor objects
   * @return List of Contributor
   * @author Jonathan Beck
   */
  @Override
    public  List<Contributor> getAllContributor(int limit, int offset) {
    List<Contributor> result = new ArrayList<>();
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_all_Contributor(?,?)}")) {
          statement.setInt(1,limit)
          ;statement.setInt(2,offset);
          try(ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {Integer Contributor_ID = resultSet.getInt("Contributor_Contributor_ID");
              String First_Name = resultSet.getString("Contributor_First_Name");
              String Last_Name = resultSet.getString("Contributor_Last_Name");
              String email = resultSet.getString("Contributor_email");
              Contributor _contributor = new Contributor( Contributor_ID, First_Name, Last_Name, email);
              result.add(_contributor);
            }
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not retrieve Contributors. Try again later");
    }
    return result;}
}
