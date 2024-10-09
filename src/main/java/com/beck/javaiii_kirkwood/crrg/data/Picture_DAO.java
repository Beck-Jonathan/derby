package com.beck.javaiii_kirkwood.crrg.data;
import com.beck.javaiii_kirkwood.crrg.data_interfaces.iPicture_DAO;
import com.beck.javaiii_kirkwood.crrg.models.Picture;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import java.sql.SQLException;
import java.util.List;
import static com.beck.javaiii_kirkwood.crrg.data.Database.getConnection;

public class Picture_DAO implements iPicture_DAO{

  /**
   * DAO Method to add Picture objects
   * @param _picture the Picture to be added
   * @return number of records added
   * @author Jonathan Beck
   */
  @Override
  public int add(Picture _picture) {
    int numRowsAffected=0;try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_Picture( ?, ?, ?)}")){
          statement.setInt(1,_picture.getAlbum_ID());
          statement.setInt(2,_picture.getContributor_ID());
          statement.setString(3,_picture.getdescription());
          numRowsAffected = statement.executeUpdate();
          if (numRowsAffected == 0) {
            throw new RuntimeException("Could not add Picture. Try again later");
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not add Picture. Try again later");
    }
    return numRowsAffected;
  }

  /**
   * DAO Method to retreive by Foreign Key Picture objects
   * @return List of Picture
   * @author Jonathan Beck
   */
  @Override
  public  List<Picture> getPicturebyAlbum(Integer Album_ID,int pagesize,int offset) {
    List<Picture> result = new ArrayList<>();
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_Picture_byAlbum(?,?,?)}")) {
          statement.setInt(1,Album_ID);
          statement.setInt(2,pagesize);
          statement.setInt(3,offset);
          try(ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {Integer Picture_ID = resultSet.getInt("Picture_Picture_ID");
              Integer _Album_ID = resultSet.getInt("Picture_Album_ID");
              Integer Contributor_ID = resultSet.getInt("Picture_Contributor_ID");
              String description = resultSet.getString("Picture_description");
              Picture _picture = new Picture( Picture_ID, _Album_ID, Contributor_ID, description);
              result.add(_picture);
            }
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not retrieve Pictures. Try again later");
    }
    return result;
  }

  @Override
  public  List<Picture> getPicturebyContributor(Integer Contributor_ID,int pagesize,int offset) {
    List<Picture> result = new ArrayList<>();
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_retreive_Picture_byContributor(?,?,?)}")) {
          statement.setInt(1, Contributor_ID);
          statement.setInt(2, pagesize);
          statement.setInt(3, offset);
          try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
              Integer Picture_ID = resultSet.getInt("Picture_Picture_ID");

              Integer Album_ID = resultSet.getInt("Picture_Album_ID");
              Integer _Contributor_ID = resultSet.getInt("Picture_Contributor_ID");
              String description = resultSet.getString("Picture_description");
              Picture _picture = new Picture(Picture_ID, Album_ID, _Contributor_ID, description);
              result.add(_picture);
            }
          }
        }
      }

    } catch (SQLException e) {
      throw new RuntimeException("Could not retrieve Pictures. Try again later");
    }
    return result;
  }

  /**
   * DAO Method to update Picture objects
   * @param oldPicture the Picture to be updated
   * @param newPicture the updated version of the Picture
   * @return number of records updated
   * @author Jonathan Beck
   */
  @Override
  public int update(Picture oldPicture, Picture newPicture) throws SQLException{
    int result = 0;
    try (Connection connection = getConnection()) {
      if (connection !=null){
        try(CallableStatement statement = connection.prepareCall("{CALL sp_update_Picture(? ,?,?,?,?,?,?)}"))
        {
          statement.setInt(1,oldPicture.getPicture_ID());
          statement.setInt(2,oldPicture.getAlbum_ID());
          statement.setInt(3,newPicture.getAlbum_ID());
          statement.setInt(4,oldPicture.getContributor_ID());
          statement.setInt(5,newPicture.getContributor_ID());
          statement.setString(6,oldPicture.getdescription());
          statement.setString(7,newPicture.getdescription());
          result=statement.executeUpdate();
        } catch (SQLException e) {
          throw new RuntimeException("Could not update Picture . Try again later");
        }
      }
    }
    return result;
  }

  /**
   * DAO Method to retreive all Picture objects
   * @return List of Picture
   * @author Jonathan Beck
   */
  @Override
  public  List<Picture> getAllPicture(int limit, int offset) {
    List<Picture> result = new ArrayList<>();
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_all_Picture(?,?)}")) {
          statement.setInt(1,limit)
          ;statement.setInt(2,offset);
          try(ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {Integer Picture_ID = resultSet.getInt("Picture_Picture_ID");
              Integer Album_ID = resultSet.getInt("Picture_Album_ID");
              Integer Contributor_ID = resultSet.getInt("Picture_Contributor_ID");
              String description = resultSet.getString("Picture_description");
              Picture _picture = new Picture( Picture_ID, Album_ID, Contributor_ID, description);
              result.add(_picture);
            }
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not retrieve Pictures. Try again later");
    }
    return result;}
}
