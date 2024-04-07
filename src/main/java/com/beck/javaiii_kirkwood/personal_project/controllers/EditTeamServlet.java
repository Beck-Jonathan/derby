package com.beck.javaiii_kirkwood.personal_project.controllers;

import com.beck.javaiii_kirkwood.personal_project.data.LeagueDAO;
import com.beck.javaiii_kirkwood.personal_project.data.TeamDAO;
import com.beck.javaiii_kirkwood.personal_project.models.League;
import com.beck.javaiii_kirkwood.personal_project.models.Team;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/editteam")
public class EditTeamServlet extends HttpServlet {
  private static final String UPLOAD_DIR = "uploads";


  static List<League> allLeagues = LeagueDAO.getActiveLeague();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String mode = req.getParameter("mode");
    int primaryKey = Integer.parseInt(req.getParameter("teamid"));
    Team team = new Team();
    team.setTeam_ID(primaryKey);
    try {
      team = TeamDAO.getTeamByPrimaryKey(team);
    } catch (SQLException e) {
      req.setAttribute("dbStatus", e.getMessage());
    }
    HttpSession session = req.getSession();
    session.setAttribute("team", team);
    String applicationPath = req.getServletContext().getRealPath("");
    String uploadFilePath = ""+UPLOAD_DIR;
    session.setAttribute("displayTeamLogo",uploadFilePath+"//"+team.getLogo());
    req.setAttribute("mode", mode);
    session.setAttribute("currentPage", req.getRequestURL());
    req.setAttribute("pageTitle", "Add Team");
    allLeagues = LeagueDAO.getAllLeague();
    req.setAttribute("Leagues", allLeagues);
    req.getRequestDispatcher("WEB-INF/personal-project/EditTeam.jsp").forward(req, resp);
  }
}


