package com.beck.javaiii_kirkwood.personal_project.controllers;

import com.beck.javaiii_kirkwood.personal_project.data.PrivilegeDAO;
import com.beck.javaiii_kirkwood.personal_project.models.Privilege;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/deleteprivilege")
public class DeletePrivilegeServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("pageTitle", "Privacy Policy");
    Integer PrivilegeID = Integer.valueOf(req.getParameter("privilegeid"));
    int result = PrivilegeDAO.deletePrivilege(PrivilegeID);
    List<Privilege> privileges = null;
    privileges = PrivilegeDAO.getAllPrivilege();
    req.setAttribute("Privileges", privileges);
    req.setAttribute("pageTitle", "All Privileges");
    int x = 0;
    req.getRequestDispatcher("WEB-INF/personal-project/all-Privileges.jsp").forward(req, resp);
  }
}