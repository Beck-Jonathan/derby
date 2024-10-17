package com.beck.javaiii_kirkwood.crrg.controllers;

import com.beck.javaiii_kirkwood.crrg.data.User_DAO;
import com.beck.javaiii_kirkwood.crrg.data_interfaces.iUser_DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


  @WebServlet("/crrgLogout")
  public class Logout_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session=req.getSession();
      session.invalidate();
      resp.sendRedirect("crrgLogin");
    }
}
