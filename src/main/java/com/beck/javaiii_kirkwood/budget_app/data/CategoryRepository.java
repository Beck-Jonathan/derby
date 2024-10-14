package com.beck.javaiii_kirkwood.budget_app.data;
import com.beck.javaiii_kirkwood.budget_app.models.Category;
import com.beck.javaiii_kirkwood.budget_app.models.Category_VM;
import com.beck.javaiii_kirkwood.budget_app.models.Category_VM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.beck.javaiii_kirkwood.budget_app.data.Database.getConnection;

public interface CategoryRepository  extends JpaRepository<Category_VM, Integer>{
  List<Category_VM> getOneYearAnalysis(int year, int user_ID) throws SQLException;
  List<Category_VM> getOneCategoryAnalysis(String Category, int user_ID) throws SQLException;
}
