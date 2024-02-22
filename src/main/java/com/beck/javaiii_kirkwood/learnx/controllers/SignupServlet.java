package com.beck.javaiii_kirkwood.learnx.controllers;


import com.beck.javaiii_kirkwood.learnx.Models.User;
import com.beck.javaiii_kirkwood.learnx.data.UserDAO;
import com.beck.javaiii_kirkwood.shared.EmailService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("pageTitle", "Sign up for an account");
    req.getRequestDispatcher("WEB-INF/learnx/signup.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String email = req.getParameter("inputEmail1");
    String password1 = req.getParameter("inputPassword1");
    String password2 = req.getParameter("inputPassword2");
    String[] terms = req.getParameterValues("checkbox-1");
    if(terms == null) {
      terms = new String[]{"0"};
    }

    Map<String, String> results = new HashMap<>();
    results.put("email", email);
    results.put("password1", password1);
    results.put("password2", password2);
    results.put("terms", terms[0]);
    User user = new User();
    try {
      user.setEmail(email);
    } catch(IllegalArgumentException e) {
      results.put("emailError", e.getMessage());
    }

    User userFromDatabase = null;
    try {
      userFromDatabase = UserDAO.getUserByPrimaryKey(email);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    if(userFromDatabase != null) {
      results.put("emailError", "A user with that email address already exists.");
    }
    try {
      user.setPassword(password1.toCharArray());
    } catch(IllegalArgumentException e) {
      results.put("password1Error", e.getMessage());
    }
    if(password2.equals("")) {
      results.put("password2Error", "This input is required");
    }
    if(!password1.equals(password2)) {
      results.put("password2Error", "Passwords don't match");
    }
    if(terms == null || !terms[0].equals("agree")){
      results.put("termsOfServiceError", "You must agree to our terms of service");
    }

    if (!results.containsKey("emailError") && !results.containsKey("password1Error")
        && !results.containsKey("password2Error") && !results.containsKey("termsOfServiceError")
    ) {
      List<String> twoFactorInfo = UserDAO.addUSer(user);
      if (!twoFactorInfo.isEmpty()) {
        // Send user an email
        String subject = "LearnX auth code";
        String twoFactorCode = twoFactorInfo.get(0);
        String message = "<h2> Welcome to LearnX </h2>";
        message = message + "Your code is" + twoFactorCode;
        EmailService.sendemail(email, subject, message);

      }
      // To do: Display error saying "Could not add user" if twoFactorInfo is empty


      //todo, display error saying unable to add user
    }



    req.setAttribute("results", results);
    req.setAttribute("pageTitle", "Sign up for an account");
    req.getRequestDispatcher("WEB-INF/learnx/signup.jsp").forward(req, resp);
  }
}
