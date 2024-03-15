package com.beck.javaiii_kirkwood.personal_project.controllers;

import com.beck.javaiii_kirkwood.personal_project.data.FacilityDAO;
import com.beck.javaiii_kirkwood.personal_project.models.Facility;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/all-Facilitys")
public class AllFacilitysServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.setAttribute("currentPage",req.getRequestURL());
    List<Facility> facilitys = null;
    facilitys = FacilityDAO.getAllFacility();
    req.setAttribute("Facilitys", facilitys);
    req.setAttribute("pageTitle", "All Facilitys");
    req.getRequestDispatcher("WEB-INF/personal-project/all-Facilitys.jsp").forward(req,resp);
  }
}
