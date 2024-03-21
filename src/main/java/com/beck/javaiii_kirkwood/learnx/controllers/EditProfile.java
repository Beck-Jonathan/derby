package com.beck.javaiii_kirkwood.learnx.controllers;




import com.beck.javaiii_kirkwood.learnx.Models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/edit-profile")
public class EditProfile extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    User userFromSession = (User)session.getAttribute("activeUser");
    if(userFromSession == null) {
      session.setAttribute("flashMessageWarning", "You must be logged in to edit your profile");
      resp.sendRedirect("login");
      return;
    }
    req.setAttribute("pageTitle", "Edit Profile");
    req.getRequestDispatcher("WEB-INF/learnx/editprofile.jsp").forward(req, resp);
  }
}
