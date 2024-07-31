package com.beck.javaiii_kirkwood.budget_app.controllers;

import com.beck.javaiii_kirkwood.budget_app.data.CategoryDAO;
import com.beck.javaiii_kirkwood.budget_app.data.TransactionDAO;
import com.beck.javaiii_kirkwood.budget_app.models.Category;
import com.beck.javaiii_kirkwood.budget_app.models.Transaction;
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

@WebServlet("/search_transaction")
public class SearchAndCategorizeServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession session = req.getSession();
    User user = (User)session.getAttribute("User_B");
    List<Category> allCategories = CategoryDAO.getCategoryByUser(user.getUser_ID());
    req.setAttribute("Categories", allCategories);
    if (user==null){
      resp.sendError(HttpServletResponse.SC_FORBIDDEN);
      return;
    }
    session.setAttribute("currentPage",req.getRequestURL());
    List<Transaction> transactions = null;
    int transaction_count=0;
    String query = req.getParameter("query");
    req.setAttribute("search",query);
    if (query!=null && !query.equals("")) {
      try {
        transactions = TransactionDAO.searchTransactionByUser(user.getUser_ID(), query);
      } catch (SQLException e) {
        throw new RuntimeException(e);
      }
    }

    req.setAttribute("Transactions", transactions);

    session.setAttribute("currentPage",req.getRequestURL());
    req.setAttribute("pageTitle", "Search Transactions");
    req.getRequestDispatcher("WEB-INF/Budget_App/search_categorize_transaction.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    HttpSession session = req.getSession();
    User user = (User)session.getAttribute("User_B");
    if (user==null){
     resp.sendError(HttpServletResponse.SC_FORBIDDEN);
     return;
     }
    session.setAttribute("currentPage",req.getRequestURL());
    int update = 0;
    int transaction_count=0;
    String query = req.getParameter("s_id");
    String category = req.getParameter("category");
    try {
      update = TransactionDAO.bulkUpdate(user.getUser_ID(),category,query);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    req.setAttribute("updates", update);

    session.setAttribute("currentPage",req.getRequestURL());
    req.setAttribute("pageTitle", "Search Transactions");
    resp.sendRedirect("all-Transactions");


  }
}