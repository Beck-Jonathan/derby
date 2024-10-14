package com.beck.javaiii_kirkwood.crrg.controllers;

import com.beck.javaiii_kirkwood.crrg.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/crrg_management")
public class site_management_servlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    User Jonathan  = new User();
    List<String> roles = new ArrayList<>();
    roles.add("Jonathan");
    Jonathan.setRoles(roles);
    session.setAttribute("User",Jonathan);

    session.setAttribute("currentPage",req.getRequestURL());
    req.setAttribute("pageTitle", "Admin Panel");
    req.getRequestDispatcher("WEB-INF/crrg/site_management.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.setAttribute("currentPage",req.getRequestURL());
    req.setAttribute("pageTitle", "Admin Panel");
    req.getRequestDispatcher("WEB-INF/crrg/site_management.jsp").forward(req, resp);
  }
}
