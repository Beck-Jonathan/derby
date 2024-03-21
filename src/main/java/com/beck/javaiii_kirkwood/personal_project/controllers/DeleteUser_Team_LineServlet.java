package com.beck.javaiii_kirkwood.personal_project.controllers;

/******************
 Create the Servlet For Deleteing from the User_Team_Line table
 Created By Jonathan Beck3/19/2024
 ***************/

import com.beck.javaiii_kirkwood.personal_project.data.User_Team_LineDAO;
import com.beck.javaiii_kirkwood.personal_project.models.User_Team_Line;
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
@WebServlet("/deleteuser_team_line")public class DeleteUser_Team_LineServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Map<String, String> results = new HashMap<>();
    HttpSession session = req.getSession();
    session.setAttribute("currentPage",req.getRequestURL());
    req.setAttribute("pageTitle", "Delete User_Team_Line");
    int User_Team_LineID = Integer.valueOf(req.getParameter("user_team_lineid"));
    int mode = Integer.valueOf(req.getParameter("mode"));
    int result = 0;
    if (mode==0){
      try{
        result = User_Team_LineDAO.deleteUser_Team_Line(User_Team_LineID);
      }
      catch(Exception ex){
        results.put("dbStatus",ex.getMessage());
      }
    }
    else {
      try{
        result = User_Team_LineDAO.undeleteUser_Team_Line(User_Team_LineID);
      }
      catch(Exception ex){
        results.put("dbStatus",ex.getMessage());
      }
    }
    List<User_Team_Line> user_team_lines = null;
    user_team_lines = User_Team_LineDAO.getAllUser_Team_Line();
    req.setAttribute("results",results);
    req.setAttribute("User_Team_Lines", user_team_lines);
    req.setAttribute("pageTitle", "All User_Team_Line");
    req.getRequestDispatcher("WEB-INF/personal-project/all-User_Team_Line.jsp").forward(req, resp);
  }
}

