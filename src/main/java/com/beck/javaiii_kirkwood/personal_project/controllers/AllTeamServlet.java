package com.beck.javaiii_kirkwood.personal_project.controllers;

import com.beck.javaiii_kirkwood.personal_project.data.TeamDAO;
import com.beck.javaiii_kirkwood.personal_project.models.Team;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
/******************
 Create the Servlet  For Viewing all of the  Team table
 Created By Jonathan Beck3/3/2024

 ***************/
@WebServlet("/all-Teams")
public class AllTeamServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Team> teams = null;
    teams = TeamDAO.getAllTeam();
    req.setAttribute("Teams", teams);
    req.setAttribute("pageTitle", "All Teams");
    req.getRequestDispatcher("WEB-INF/personal-project/all-Teams.jsp").forward(req, resp);
  }
}
