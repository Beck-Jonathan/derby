package com.beck.javaiii_kirkwood.crrg.data_interfaces;

import com.beck.javaiii_kirkwood.crrg.models.*;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.beck.javaiii_kirkwood.personal_project.data.Database.getConnection;

public interface iUser_DAO {

     int add(User _user);

     int getUserID(String email) throws SQLException;

     User getUserByPrimaryKey(User _user) throws SQLException;
    List<User> getAllUser() ;

      int activate(int _userID) ;

      String get_pw(String username);

     int getUserIDByUserName(String username);


     boolean usernameFree(String username) throws SQLException;
     boolean emailFree(String email) throws SQLException;



     boolean deleteUser(int userID) throws SQLException;
     boolean resetPW(User user) throws SQLException;



}
