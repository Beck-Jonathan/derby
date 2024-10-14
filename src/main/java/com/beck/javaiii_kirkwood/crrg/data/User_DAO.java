package com.beck.javaiii_kirkwood.crrg.data;

import com.beck.javaiii_kirkwood.crrg.data_interfaces.iUser_DAO;
import com.beck.javaiii_kirkwood.crrg.models.User;

import java.sql.SQLException;
import java.util.List;

public class User_DAO implements iUser_DAO {
  @Override
  public int add(User _user) {
    return 0;
  }

  @Override
  public int getUserID(String email) throws SQLException {
    return 0;
  }

  @Override
  public User getUserByPrimaryKey(User _user) throws SQLException {
    return null;
  }

  @Override
  public List<User> getAllUser() {
    return null;
  }

  @Override
  public int activate(int _userID) {
    return 0;
  }

  @Override
  public String get_pw(String username) {
    return null;
  }

  @Override
  public int getUserIDByUserName(String username) {
    return 0;
  }

  @Override
  public boolean usernameFree(String username) throws SQLException {
    return false;
  }

  @Override
  public boolean emailFree(String email) throws SQLException {
    return false;
  }

  @Override
  public boolean deleteUser(int userID) throws SQLException {
    return false;
  }

  @Override
  public boolean resetPW(User user) throws SQLException {
    return false;
  }
}
