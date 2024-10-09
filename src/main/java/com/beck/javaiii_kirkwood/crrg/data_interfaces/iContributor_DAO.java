package com.beck.javaiii_kirkwood.crrg.data_interfaces;

import com.beck.javaiii_kirkwood.crrg.models.Contributor;

import java.sql.SQLException;
import java.util.List;

public interface iContributor_DAO {
  /**
   * DAO Method to add Contributor objects
   * @param _contributor the Contributor to be added
   * @return number of records added
   * @author Jonathan Beck
   */
  int add (Contributor _contributor) throws SQLException;
  /**
   * DAO Method to retreive all Contributor objects
   * @return List of Contributor
   * @author Jonathan Beck
   */
  List<Contributor> getAllContributor(int limit, int offset) throws SQLException;

}
