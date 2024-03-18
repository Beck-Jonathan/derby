package com.beck.javaiii_kirkwood.personal_project.controllers;

;
import com.beck.javaiii_kirkwood.personal_project.data.UserDAO;
import com.beck.javaiii_kirkwood.personal_project.data.EventDAO;
import com.beck.javaiii_kirkwood.personal_project.data.User_Event_LineDAO;
import com.beck.javaiii_kirkwood.personal_project.models.Event;
import com.beck.javaiii_kirkwood.personal_project.models.User;
import com.beck.javaiii_kirkwood.personal_project.models.User_Event_Line;
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
 Create the Servlet  For adding to The  User_Event_Line table
 Created By Jonathan Beck3/18/2024
 ***************/

@WebServlet("/addUser_Event_Line")
public class AddUser_Event_LineServlet extends HttpServlet{
  static List<User> allUsers = UserDAO.getAllUser();
  static List<Event> allEvents = EventDAO.getActiveEvent();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.setAttribute("currentPage",req.getRequestURL());
    req.setAttribute("pageTitle", "Add User_Event_Line");
    allUsers = UserDAO.getAllUser();
    req.setAttribute("Users", allUsers);
    allEvents = EventDAO.getAllEvent();
    req.setAttribute("Events", allEvents);
    req.getRequestDispatcher("WEB-INF/personal-project/AddUser_Event_Line.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    allUsers = UserDAO.getAllUser();
    req.setAttribute("Users", allUsers);
    allEvents = EventDAO.getAllEvent();
    req.setAttribute("Events", allEvents);
    String _User_ID = req.getParameter("inputuser_event_lineUser_ID");
    String _Event_ID = req.getParameter("inputuser_event_lineEvent_ID");
    String _Date_assgined = req.getParameter("inputuser_event_lineDate_assgined");
    String _is_active = req.getParameter("inputuser_event_lineis_active");
    Map<String, String> results = new HashMap<>();
    results.put("User_ID",_User_ID);
    results.put("Event_ID",_Event_ID);
    results.put("Date_assgined",_Date_assgined);
    results.put("is_active",_is_active);
    User_Event_Line user_event_line = new User_Event_Line();
    int errors =0;
    try {
      user_event_line.setUser_ID(Integer.valueOf(_User_ID));
    } catch(IllegalArgumentException e) {results.put("user_event_lineUser_IDerror", e.getMessage());
      errors++;
    }
    try {
      user_event_line.setEvent_ID(Integer.valueOf(_Event_ID));
    } catch(IllegalArgumentException e) {results.put("user_event_lineEvent_IDerror", e.getMessage());
      errors++;
    }
    try {
      user_event_line.setDate_assgined(LocalDate.parse(_Date_assgined));
    } catch(IllegalArgumentException e) {results.put("user_event_lineDate_assginederror", e.getMessage());
      errors++;
    }
    try {
      user_event_line.setis_active(Boolean.parseBoolean(_is_active));
    } catch(IllegalArgumentException e) {results.put("user_event_lineis_activeerror", e.getMessage());
      errors++;
    }
    int result=0;
    if (errors==0){
      try{
        result=User_Event_LineDAO.add(user_event_line);
      }catch(Exception ex){
        results.put("dbStatus","Database Error");
      }
      if (result>0){
        results.put("dbStatus","User_Event_Line Added");
        resp.sendRedirect("all-User_Event_Lines");
        return;
      } else {
        results.put("dbStatus","User_Event_Line Not Added");

      }
    }
    req.setAttribute("results", results);
    req.setAttribute("pageTitle", "Create a User_Event_Line ");
    req.getRequestDispatcher("WEB-INF/personal-project/AddUser_Event_Line.jsp").forward(req, resp);

  }
}


