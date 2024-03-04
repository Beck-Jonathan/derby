package com.beck.javaiii_kirkwood.personal_project.controllers;

/******************
 Create the Servlet  For adding to The  League table
 Created By Jonathan Beck3/3/2024

 ***************/
import com.beck.javaiii_kirkwood.personal_project.models.League;
import com.beck.javaiii_kirkwood.personal_project.data.LeagueDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/addLeague")
public class AddLeagueServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("pageTitle", "Add League");
    req.getRequestDispatcher("WEB-INF/personal-project/addLeague.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String _League_Name = req.getParameter("inputleagueLeague_Name");
    String _League_Level = req.getParameter("inputleagueLeague_Level");
    Map<String, String> results = new HashMap<>();
    results.put("League_Name",_League_Name);
    results.put("League_Level",_League_Level);
    League league = new League();
    int errors =0;
    try {
      league.setLeague_Name(_League_Name);
    } catch(IllegalArgumentException e) {results.put("leagueLeague_Nameerror", e.getMessage());
      errors++;
    }
    try {
      league.setLeague_Level(_League_Level);
    } catch(IllegalArgumentException e) {results.put("leagueLeague_Levelerror", e.getMessage());
      errors++;
    }
    int result=0;
    if (errors==0){
      try{
        result=LeagueDAO.add(league);
      }catch(Exception ex){
        results.put("dbStatus","Database Error");
      }
      if (result>0){
        results.put("dbStatus","League Added");
      } else {
        results.put("dbStatus","League Not Added");

      }
    }
    req.setAttribute("results", results);
    req.setAttribute("pageTitle", "Create a League ");
    req.getRequestDispatcher("WEB-INF/personal-project/addLeague.jsp").forward(req, resp);

  }
}

