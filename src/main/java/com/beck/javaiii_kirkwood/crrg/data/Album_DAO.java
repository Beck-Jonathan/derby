package com.beck.javaiii_kirkwood.crrg.data;

import com.beck.javaiii_kirkwood.crrg.data_interfaces.iAlbum_DAO;
import com.beck.javaiii_kirkwood.crrg.models.Album;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.beck.javaiii_kirkwood.crrg.data.Database.getConnection;

public class Album_DAO implements iAlbum_DAO{
  @Override
  /**
   * DAO Method to add Album objects
   * @param Album the Album to be added
   * @return number of records added
   * @author Jonathan Beck
   */
  public int add(Album _album) {
    int numRowsAffected=0;try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_Album( ?)}")){
          statement.setString(1,_album.getAlbum_Name());
          numRowsAffected = statement.executeUpdate();
          if (numRowsAffected == 0) {
            throw new RuntimeException("Could not add Album. Try again later");
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not add Album. Try again later");
    }
    return numRowsAffected;
  }

  /**
   * DAO Method to update Album objects
   * @param oldAlbum the Album to be updated
   * @param newAlbum the updated version of the Album
   * @return number of records updated
   * @author Jonathan Beck
   */
@Override
  public int update(Album oldAlbum, Album newAlbum) throws SQLException{
    int result = 0;
    try (Connection connection = getConnection()) {
      if (connection !=null){
        try(CallableStatement statement = connection.prepareCall("{CALL sp_update_Album(? ,?,?)}"))
        {
          statement.setInt(1,oldAlbum.getAlbum_ID());
          statement.setString(2,oldAlbum.getAlbum_Name());
          statement.setString(3,newAlbum.getAlbum_Name());
          result=statement.executeUpdate();
        } catch (SQLException e) {
          throw new RuntimeException("Could not update Album . Try again later");
        }
      }
    }
    return result;
  }

  @Override
  public  List<Album> getAllAlbum(int limit, int offset) {
    List<Album> result = new ArrayList<>();
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_all_Album(?,?)}")) {
          statement.setInt(1,limit)
          ;statement.setInt(2,offset);
          try(ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {Integer Album_ID = resultSet.getInt("Album_Album_ID");
              String Album_Name = resultSet.getString("Album_Album_Name");
              Album _album = new Album( Album_ID, Album_Name);
              result.add(_album);
            }
          }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not retrieve Albums. Try again later");
    }
    return result;
  }

}

