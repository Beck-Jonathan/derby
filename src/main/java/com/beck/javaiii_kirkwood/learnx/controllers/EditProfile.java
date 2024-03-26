package com.beck.javaiii_kirkwood.learnx.controllers;




import com.beck.javaiii_kirkwood.learnx.Models.User;
import com.beck.javaiii_kirkwood.learnx.data.UserDAO;
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
    User userFromSession = (User) session.getAttribute("activeUser");
    if (userFromSession == null) {
      session.setAttribute("flashMessageWarning", "You must be logged in to edit your profile");
      resp.sendRedirect("login?redirect=edit-profile");
      return;
    }
    req.setAttribute("pageTitle", "Edit Profile");
    req.getRequestDispatcher("WEB-INF/learnx/editprofile.jsp").forward(req, resp);
  }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String firstName = req.getParameter("firstNameInput");
      String lastName = req.getParameter("lastNameInput");
      String email = req.getParameter("emailInput");
      String phone = req.getParameter("phoneInput");
      String language = req.getParameter("languageInput");

      HttpSession session = req.getSession();
      User userFromSession = (User)session.getAttribute("activeUser");
      if (userFromSession!=null){
        userFromSession.setFirst_name(firstName);
        userFromSession.setLast_name(lastName);
        userFromSession.setEmail(email);
        userFromSession.setPhone(phone);
        userFromSession.setLanguage(language);
        int result=UserDAO.update(userFromSession);
        if(result==1) {
          session.setAttribute("activeUser", userFromSession);
        }


      }


      req.setAttribute("pageTitle", "Edit Profile");
      req.getRequestDispatcher("WEB-INF/learnx/editprofile.jsp").forward(req, resp);

    }
  }