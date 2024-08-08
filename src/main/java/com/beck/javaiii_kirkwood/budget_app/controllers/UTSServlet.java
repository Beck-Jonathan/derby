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
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/UTS")
public class UTSServlet extends HttpServlet {



  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    HttpSession session = req.getSession();

    User user = (User)session.getAttribute("User_B");

    String id =req.getParameter("t_id");
    String category = req.getParameter("category");
    Transaction old_t = new Transaction();
    old_t.setUser_ID(user.getUser_ID());
    old_t.setTransaction_ID(Integer.parseInt(id));

    Transaction new_t = new Transaction();
    new_t.setCategory_ID(category);
    String status="";
    int result=0;
    try {
       result = TransactionDAO.update(old_t,new_t);

    } catch (SQLException e) {
      status="error";
    }

    if (result==1){
      status="success";
    }
    else {
      status="error";
    }
    resp.setContentType("text/plain");
    resp.getWriter().write(status);





  }
}