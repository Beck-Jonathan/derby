package com.beck.javaiii_kirkwood.personal_project.controllers;

import com.beck.javaiii_kirkwood.personal_project.data.EventDAO;
import com.beck.javaiii_kirkwood.personal_project.data.FacilityDAO;
import com.beck.javaiii_kirkwood.personal_project.data.TypeDAO;
import com.beck.javaiii_kirkwood.personal_project.models.Event;
import com.beck.javaiii_kirkwood.personal_project.models.Facility;
import com.beck.javaiii_kirkwood.personal_project.models.Type;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/editevent")
public class EditEventServlet extends HttpServlet {
  static List<Facility> allFacilitys = FacilityDAO.getActiveFacility();
  static List<Type> allTypes = TypeDAO.getActiveType();
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String mode = req.getParameter("mode");
    int primaryKey = Integer.parseInt(req.getParameter("eventid"));
        Event event= new Event();
        event.setEvent_ID(primaryKey);
    try{
      event=EventDAO.getEventByPrimaryKey(event);
    } catch (SQLException e) {
      req.setAttribute("dbStatus",e.getMessage());
    }
    HttpSession session = req.getSession();
    session.setAttribute("event",event);
    req.setAttribute("mode",mode);
    session.setAttribute("currentPage",req.getRequestURL());
    req.setAttribute("pageTitle", "Add Event");
    allFacilitys = FacilityDAO.getAllFacility();
    req.setAttribute("Facilitys", allFacilitys);
    allTypes = TypeDAO.getAllType();
    req.setAttribute("Types", allTypes);
    req.getRequestDispatcher("WEB-INF/personal-project/EditEvent.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    super.doPost(req, resp);
  }
}
