package com.beck.javaiii_kirkwood.personal_project.controllers;

import com.beck.javaiii_kirkwood.personal_project.data.UserDAO;

import com.beck.javaiii_kirkwood.personal_project.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/all-skaters")
public class AllUserServlet extends HttpServlet {@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  List<User> users = null;
  users = UserDAO.getAllUser();
  req.setAttribute("Users", users);
  req.setAttribute("pageTitle", "All Users");
  req.getRequestDispatcher("WEB-INF/personal-project/all-Users.jsp").forward(req, resp);
}
}