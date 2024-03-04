package com.beck.javaiii_kirkwood.personal_project.controllers;

/******************
 Create the Servlet  For Viewing all of the  League table
 Created By Jonathan Beck3/3/2024

 ***************/
import com.beck.javaiii_kirkwood.personal_project.data.LeagueDAO;
import com.beck.javaiii_kirkwood.personal_project.models.League;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/all-Leagues")
public class AllLeagueServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<League> leagues = null;
    leagues = LeagueDAO.getAllLeague();
    req.setAttribute("Leagues", leagues);
    req.setAttribute("pageTitle", "All Leagues");
    req.getRequestDispatcher("WEB-INF/personal-project/all-League.jsp").forward(req, resp);

  }
}