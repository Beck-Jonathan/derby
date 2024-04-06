package com.beck.javaiii_kirkwood.personal_project.controllers;

import com.beck.javaiii_kirkwood.personal_project.data.TeamDAO;
import com.beck.javaiii_kirkwood.personal_project.data.UserDAO;
import com.beck.javaiii_kirkwood.personal_project.data.User_Team_LineDAO;
import com.beck.javaiii_kirkwood.personal_project.models.Team;
import com.beck.javaiii_kirkwood.personal_project.models.TeamVM;
import com.beck.javaiii_kirkwood.personal_project.models.User;
import com.beck.javaiii_kirkwood.personal_project.models.User_Team_Line;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/******************
 Create the Servlet  For adding to The  User_Team_Line table
 Created By Jonathan Beck3/18/2024
 ***************/

@WebServlet("/addUser_Team_Line")
public class AddUser_Team_LineServlet extends HttpServlet{
  static List<User> allUsers = UserDAO.getAllUser();
  static List<TeamVM> allTeams = TeamDAO.getActiveTeam();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.setAttribute("currentPage",req.getRequestURL());
    req.setAttribute("pageTitle", "Add User_Team_Line");
    allUsers = UserDAO.getAllUser();
    req.setAttribute("Users", allUsers);
    allTeams = TeamDAO.getAllTeam();
    req.setAttribute("Teams", allTeams);
    req.getRequestDispatcher("WEB-INF/personal-project/AddUser_Team_Line.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    allUsers = UserDAO.getAllUser();
    req.setAttribute("Users", allUsers);
    allTeams = TeamDAO.getAllTeam();
    req.setAttribute("Teams", allTeams);
    String _User_ID = req.getParameter("inputuser_team_lineUser_ID");
    String _Team_ID = req.getParameter("inputuser_team_lineTeam_ID");
    String _Date_assgined = req.getParameter("inputuser_team_lineDate_assgined");
    String _is_active = req.getParameter("inputuser_team_lineis_active");
    Map<String, String> results = new HashMap<>();
    results.put("User_ID",_User_ID);
    results.put("Team_ID",_Team_ID);
    results.put("Date_assgined",_Date_assgined);
    results.put("is_active",_is_active);
    User_Team_Line user_team_line = new User_Team_Line();
    int errors =0;
    try {
      user_team_line.setUser_ID(Integer.valueOf(_User_ID));
    } catch(IllegalArgumentException e) {results.put("user_team_lineUser_IDerror", e.getMessage());
      errors++;
    }
    try {
      user_team_line.setTeam_ID(Integer.valueOf(_Team_ID));
    } catch(IllegalArgumentException e) {results.put("user_team_lineTeam_IDerror", e.getMessage());
      errors++;
    }
    try {
      user_team_line.setDate_assgined(LocalDate.parse(_Date_assgined));
    } catch(IllegalArgumentException e) {results.put("user_team_lineDate_assginederror", e.getMessage());
      errors++;
    }
    try {
      user_team_line.setis_active(Boolean.parseBoolean(_is_active));
    } catch(IllegalArgumentException e) {results.put("user_team_lineis_activeerror", e.getMessage());
      errors++;
    }
    int result=0;
    if (errors==0){
      try{
        result=User_Team_LineDAO.add(user_team_line);
      }catch(Exception ex){
        results.put("dbStatus","Database Error");
      }
      if (result>0){
        results.put("dbStatus","User_Team_Line Added");
        resp.sendRedirect("all-User_Team_Lines");
        return;
      } else {
        results.put("dbStatus","User_Team_Line Not Added");

      }
    }
    req.setAttribute("results", results);
    req.setAttribute("pageTitle", "Create a User_Team_Line ");
    req.getRequestDispatcher("WEB-INF/personal-project/AddUser_Team_Line.jsp").forward(req, resp);

  }
}


