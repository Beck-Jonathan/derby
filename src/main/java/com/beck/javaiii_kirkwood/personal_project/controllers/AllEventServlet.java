package com.beck.javaiii_kirkwood.personal_project.controllers;

import com.beck.javaiii_kirkwood.personal_project.data.EventDAO;
import com.beck.javaiii_kirkwood.personal_project.models.Event;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/all-Events")
public class AllEventServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Event> events = null;

    events = EventDAO.getAllEvent();

    req.setAttribute("Events", events);
    req.setAttribute("pageTitle", "All Events");
    req.getRequestDispatcher("WEB-INF/personal-project/all-Events.jsp").forward(req, resp);
  }
}
