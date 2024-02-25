package com.beck.javaiii_kirkwood.learnx.controllers;

import com.beck.javaiii_kirkwood.learnx.data.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.beck.javaiii_kirkwood.learnx.Models.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/all-users")
public class AllUsersServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<User> users = null;
    try {
      users = UserDAO.getAllUsers();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    req.setAttribute("users", users);
    req.setAttribute("pageTitle", "All Users");
    req.getRequestDispatcher("WEB-INF/learnx/all-users.jsp").forward(req,resp);
  }
}