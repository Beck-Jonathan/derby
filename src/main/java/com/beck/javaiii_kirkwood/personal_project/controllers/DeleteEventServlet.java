package com.beck.javaiii_kirkwood.personal_project.controllers;

/******************
 Create the Servlet For Deleteing from the Event table
 Created By Jonathan Beck3/19/2024
 ***************/

import com.beck.javaiii_kirkwood.personal_project.data.EventDAO;
import com.beck.javaiii_kirkwood.personal_project.models.Event;
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
@WebServlet("/deleteevent")public class DeleteEventServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Map<String, String> results = new HashMap<>();
    HttpSession session = req.getSession();
    session.setAttribute("currentPage",req.getRequestURL());
    req.setAttribute("pageTitle", "Delete Event");
    int EventID = Integer.valueOf(req.getParameter("eventid"));
    int mode = Integer.valueOf(req.getParameter("mode"));
    int result = 0;
    if (mode==0){
      try{
        result = EventDAO.deleteEvent(EventID);
      }
      catch(Exception ex){
        results.put("dbStatus",ex.getMessage());
      }
    }
    else {
      try{
        result = EventDAO.undeleteEvent(EventID);
      }
      catch(Exception ex){
        results.put("dbStatus",ex.getMessage());
      }
    }
    List<Event> events = null;
    events = EventDAO.getAllEvent();
    req.setAttribute("results",results);
    req.setAttribute("Events", events);
    req.setAttribute("pageTitle", "All Event");
    req.getRequestDispatcher("WEB-INF/personal-project/all-Events.jsp").forward(req, resp);
  }
}


