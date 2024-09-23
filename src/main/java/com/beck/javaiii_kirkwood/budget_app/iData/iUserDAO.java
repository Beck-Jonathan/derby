package com.beck.javaiii_kirkwood.budget_app.iData;

import com.beck.javaiii_kirkwood.budget_app.models.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.beck.javaiii_kirkwood.budget_app.data.Database.getConnection;

/**
 * @author Jonathan
 * @version 1.5
 * @since 1.2
 */

public interface iUserDAO {
  public int add(User _user);
  public  int getUserID(String email) throws SQLException;

  public  User getUserByPrimaryKey(User _user) throws SQLException ;

  public  String get_pw(String username) ;

  public  int getUserIDByUserName(String username);

  public  boolean usernameFree(String username) throws SQLException;

  public  boolean addDefaultCategories(int userID) throws SQLException;

  public  boolean emailFree(String email) throws SQLException ;

  public  boolean deleteUser(int userID) throws SQLException;
  public  boolean resetPW(User user) throws SQLException;
  public List<String> getUser_Roles(User _user) throws SQLException;
  public  int addRole(String role, int userID );

  public  int yearRange(int user_ID) throws SQLException ;

}
