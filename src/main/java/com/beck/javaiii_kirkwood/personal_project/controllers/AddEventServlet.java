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
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/addEvent")
public class AddEventServlet extends HttpServlet{
static List<Facility> allfacilitys = FacilityDAO.getAllFacility();
static List<Type> alltypes = TypeDAO.getAllType();

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  HttpSession session = req.getSession();
  session.setAttribute("currentPage",req.getRequestURL());
  req.setAttribute("pageTitle", "Add Event");
  allfacilitys = FacilityDAO.getAllFacility();
  alltypes = TypeDAO.getAllType();
  req.setAttribute("facilitys", allfacilitys);
  req.setAttribute("types", alltypes);
  req.getRequestDispatcher("WEB-INF/personal-project/AddEvent.jsp").forward(req, resp);
}
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("facilitys", allfacilitys);
    req.setAttribute("types", alltypes);
    String _Facility_ID = req.getParameter("inputeventFacility_ID");
    String _Date = req.getParameter("inputeventDate");
    String _Type = req.getParameter("inputeventType");
    Map<String, String> results = new HashMap<>();
    results.put("Facility_ID", _Facility_ID);
    results.put("Date", _Date);
    results.put("Type", _Type);
    Event event = new Event();
    int errors = 0;
    try {
      event.setFacility_ID(Integer.valueOf(_Facility_ID));
    } catch (IllegalArgumentException e) {
      results.put("eventFacility_IDerror", e.getMessage());
      errors++;
    }
    try {
      event.setDate(LocalDate.parse(_Date));
    } catch (IllegalArgumentException e) {
      results.put("eventDateerror", e.getMessage());
      errors++;
    }
    try {
      event.setType_ID(Integer.valueOf(_Type));
    } catch (IllegalArgumentException e) {
      results.put("eventTypeerror", e.getMessage());
      errors++;
    }
    int result = 0;
    if (errors == 0) {
      try {
        result = EventDAO.add(event);
      } catch (Exception ex) {
        results.put("dbStatus", "Database Error");
      }
      if (result > 0) {
        results.put("dbStatus", "Event Added");
      } else {
        results.put("dbStatus", "Event Not Added");

      }
    }
    req.setAttribute("results", results);
    req.setAttribute("pageTitle", "Create a Event ");
    req.getRequestDispatcher("WEB-INF/personal-project/AddEvent.jsp").forward(req, resp);
  }
}