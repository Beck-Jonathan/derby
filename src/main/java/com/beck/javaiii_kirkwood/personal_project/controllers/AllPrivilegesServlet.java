package com.beck.javaiii_kirkwood.personal_project.controllers;

/******************
 Create the Servlet  For Viewing all of the  Privilege table
 Created By Jonathan Beck3/3/2024

 ***************/
import com.beck.javaiii_kirkwood.personal_project.data.PrivilegeDAO;

import com.beck.javaiii_kirkwood.personal_project.models.Privilege;

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
@WebServlet("/all-Privileges")
public class AllPrivilegesServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Privilege> privileges = null;
    privileges = PrivilegeDAO.getAllPrivilege();
    req.setAttribute("Privileges", privileges);
    req.setAttribute("pageTitle", "All Privileges");
    req.getRequestDispatcher("WEB-INF/personal-project/all-Privileges.jsp").forward(req, resp);
  }
}

