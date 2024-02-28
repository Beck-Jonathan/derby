package com.beck.javaiii_kirkwood.personal_project.data;

import com.beck.javaiii_kirkwood.personal_project.models.Type;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.beck.javaiii_kirkwood.personal_project.data.Database.getConnection;

public class TypeDAO {

  public static int add(Type _type) {
    int numRowsAffected=0;
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try (CallableStatement statement = connection.prepareCall("{CALL sp_insert_Type( ?)}")) {
          statement.setString(1, _type.getName());
          numRowsAffected = statement.executeUpdate();
          if (numRowsAffected == 0) {
            throw new RuntimeException("Could not add Type. Try again later");
          }
        }
      }



    } catch (SQLException e) {
      throw new RuntimeException("Could not add Type. Try again later");
    }
    return numRowsAffected;
  }
    public static Type getTypeByPrimaryKey(Type _type) throws SQLException{
    Type result = null;
    try(Connection connection = getConnection()) {
      try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_pk_Type(?)}")) {
        statement.setString(1, _type.getType_ID().toString());

        try (ResultSet resultSet = statement.executeQuery()){
          if(resultSet.next()){Integer Type_ID = resultSet.getInt("Type_ID");
            String Name = resultSet.getString("Name");
            result = new Type( Type_ID, Name);}
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return result;
  }
  public static List<Type> getAllType() {
    List<Type> result = new ArrayList<>();
    try (Connection connection = getConnection()) {
      if (connection != null) {
        try(CallableStatement statement = connection.prepareCall("{CALL sp_retreive_by_all_Type()}")) {try(ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {Integer Type_ID = resultSet.getInt("Type_ID");
            String Name = resultSet.getString("Name");
            Type _type = new Type( Type_ID, Name);
            result.add(_type);
          }
        }
        }
      }
    } catch (SQLException e) {
      throw new RuntimeException("Could not retrieve Types. Try again later");
    }
    return result;}

}

