package com.beck.javaiii_kirkwood.budget_app.controllers;

import com.beck.javaiii_kirkwood.budget_app.data.CategoryDAO;
import com.beck.javaiii_kirkwood.budget_app.data.TransactionDAO;
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
    List<Category> categories = CategoryDAO.getAllCategory();

    User user = (User)session.getAttribute("User_B");
    List<Category_VM> results =  new ArrayList<>();
    for (Category c : categories){
      try {
        double amount = TransactionDAO.getTransactionCategoryTotal(user.getUser_ID(),c.getCategory_ID());
        Category_VM partial = new Category_VM(c.getCategory_ID(),amount);
        results.add(partial);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }
    session.setAttribute("categories",results);
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

