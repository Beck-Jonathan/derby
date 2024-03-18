package com.beck.javaiii_kirkwood.personal_project.controllers;
import com.beck.javaiii_kirkwood.personal_project.data.LeagueDAO;
import com.beck.javaiii_kirkwood.personal_project.models.League;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/******************
 Create the Servlet  For adding to The  League table
 Created By Jonathan Beck3/18/2024
 ***************/

@WebServlet("/addLeague")
public class AddLeagueServlet extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.setAttribute("currentPage",req.getRequestURL());
    req.setAttribute("pageTitle", "Add League");
    req.getRequestDispatcher("WEB-INF/personal-project/AddLeague.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String _League_Name = req.getParameter("inputleagueLeague_Name");
    String _League_Level = req.getParameter("inputleagueLeague_Level");
    String _is_active = req.getParameter("inputleagueis_active");
    Map<String, String> results = new HashMap<>();
    results.put("League_Name",_League_Name);
    results.put("League_Level",_League_Level);
    results.put("is_active",_is_active);
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
        resp.sendRedirect("all-Leagues");
        return;
      } else {
        results.put("dbStatus","League Not Added");

      }
    }
    req.setAttribute("results", results);
    req.setAttribute("pageTitle", "Create a League ");
    req.getRequestDispatcher("WEB-INF/personal-project/AddLeague.jsp").forward(req, resp);

  }
}

