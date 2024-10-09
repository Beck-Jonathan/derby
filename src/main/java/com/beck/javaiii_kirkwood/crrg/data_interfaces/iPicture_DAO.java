package com.beck.javaiii_kirkwood.crrg.data_interfaces;

import com.beck.javaiii_kirkwood.crrg.models.Picture;

import java.sql.SQLException;
import java.util.List;

public interface iPicture_DAO {
  /**
   * DAO Method to add Picture objects
   * @param _picture the Picture to be added
   * @return number of records added
   * @author Jonathan Beck
   */
  int add (Picture _picture) throws SQLException;

  /**
   * DAO Method to retreive by album_ID Picture objects
   *  @param Album_ID album_id we want all the pictures from
   * @return List of Picture
   * @author Jonathan Beck
   */
  List<Picture> getPicturebyAlbum(Integer Album_ID,int pagesize,int offset) throws SQLException;

  /**
   * DAO Method to retreive by contributor Picture objects
   *  @param Contributor_ID the contributor we want all the pictures from
   * @return List of Picture
   * @author Jonathan Beck
   */
  public List<Picture> getPicturebyContributor(Integer Contributor_ID,int pagesize,int offset) throws SQLException;

  /**
   * DAO Method to update Picture objects
   * @param oldPicture the Picture to be updated
   * @param newPicture the updated version of the Picture
   * @return number of records updated
   * @author Jonathan Beck
   */
  int update(Picture oldPicture, Picture newPicture) throws SQLException;

  /**
   * DAO Method to retreive all Picture objects
   * @return List of Picture
   * @author Jonathan Beck
   */
  List<Picture> getAllPicture(int limit, int offset) throws SQLException;
}
