package com.beck.javaiii_kirkwood.personal_project.controllers;

/******************
 Create the Servlet For Deleteing from the Team table
 Created By Jonathan Beck3/19/2024
 ***************/

import com.beck.javaiii_kirkwood.personal_project.data.TeamDAO;
import com.beck.javaiii_kirkwood.personal_project.models.Team;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/deleteteam")public class DeleteTeamServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Map<String, String> results = new HashMap<>();
    HttpSession session = req.getSession();
    session.setAttribute("currentPage",req.getRequestURL());
    req.setAttribute("pageTitle", "Delete Team");
    int TeamID = Integer.valueOf(req.getParameter("teamid"));
    int mode = Integer.valueOf(req.getParameter("mode"));
    int result = 0;
    if (mode==0){
      try{
        result = TeamDAO.deleteTeam(TeamID);
      }
      catch(Exception ex){
        results.put("dbStatus",ex.getMessage());
      }
    }
    else {
      try{
        result = TeamDAO.undeleteTeam(TeamID);
      }
      catch(Exception ex){
        results.put("dbStatus",ex.getMessage());
      }
    }
    List<Team> teams = null;
    teams = TeamDAO.getAllTeam();
    req.setAttribute("results",results);
    req.setAttribute("Teams", teams);
    req.setAttribute("pageTitle", "All Team");
    req.getRequestDispatcher("WEB-INF/personal-project/all-Teams.jsp").forward(req, resp);
  }
}

