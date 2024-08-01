package com.beck.javaiii_kirkwood.budget_app.controllers;

import com.beck.javaiii_kirkwood.budget_app.data.CategoryDAO;
import com.beck.javaiii_kirkwood.budget_app.data.TransactionDAO;
import com.beck.javaiii_kirkwood.budget_app.data.UserDAO;
import com.beck.javaiii_kirkwood.budget_app.models.Category;
import com.beck.javaiii_kirkwood.budget_app.models.Category_VM;
import com.beck.javaiii_kirkwood.budget_app.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/MoneyBreakdown")
public class MoneyBreakdownServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();


    User user = (User)session.getAttribute("User_B");

    List<Category> allCategories = CategoryDAO.getCategoryByUser(user.getUser_ID());

    int year_range=0;
    // new approach
    try {
       year_range = UserDAO.yearRange(user.getUser_ID());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    List<List<Category_VM>> years = new ArrayList<>(year_range);
    for (int i=0;i<year_range;i++){
      years.add(i, new ArrayList<>(allCategories.size()));
      for (int k=0;k< allCategories.size();k++){
        Category_VM c = new Category_VM(allCategories.get(k).getCategory_ID(),0);

        years.get(i).add(k,c);
      }
    }
    try {
      int size = TransactionDAO.getAnalysis(years, user.getUser_ID());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    int x=0;

    session.setAttribute("categories",years);
    session.setAttribute("currentPage",req.getRequestURL());
    req.setAttribute("pageTitle", "Money Breakdown");

    req.getRequestDispatcher("WEB-INF/Budget_App/moneyBreakdown.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession session = req.getSession();
    session.setAttribute("currentPage",req.getRequestURL());
    req.setAttribute("pageTitle", "Budget Home");
    req.getRequestDispatcher("WEB-INF/Budget_App/home.jsp").forward(req, resp);

  }
}

