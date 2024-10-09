package com.beck.javaiii_kirkwood.crrg.data_interfaces;

import com.beck.javaiii_kirkwood.crrg.models.Album;

import java.sql.SQLException;
import java.util.List;

/**
 * @ author Jonathan Beck
 * @ version 1.0
 * @ since 1.0
 */
public interface iAlbum_DAO{
  /**
   * DAO Method to add Album objects
   * @param _album the Album to be added
   * @return number of records added
   * @author Jonathan Beck
   */
  int add (Album _album) throws SQLException;

  /**
   * DAO Method to update Album objects
   * @param oldAlbum the Album to be updated
   * @param newAlbum the updated version of the Album
   * @return number of records updated
   * @author Jonathan Beck
   */
  int update(Album oldAlbum, Album newAlbum) throws SQLException;

  /**
   * DAO Method to retreive all Album objects
   * @return List of Album
   * @author Jonathan Beck
   */
  List<Album> getAllAlbum(int limit, int offset) throws SQLException;

}

