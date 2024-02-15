package com.beck.javaiii_kirkwood.learnx.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
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
    String[] termsOfService = req.getParameterValues("termsOfService");
    Map<String, String> results = new HashMap<>();
    results.clear();
    results.put("email", email);
    results.put("password1", password1);
    results.put("password2", password2);
    if(termsOfService != null && termsOfService[0].equals("agree")) {
      results.put("termsOfService", termsOfService[0]);
    }  else {
      results.put("termsOfService", "");
    }

    req.setAttribute("results", results);
    req.setAttribute("pageTitle", "Sign up for an account");
    req.getRequestDispatcher("WEB-INF/learnx/signup.jsp").forward(req, resp);
  }

}