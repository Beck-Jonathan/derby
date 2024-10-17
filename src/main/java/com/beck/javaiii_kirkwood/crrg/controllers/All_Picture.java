package com.beck.javaiii_kirkwood.crrg.controllers;

import com.beck.javaiii_kirkwood.crrg.data.Picture_DAO;
import com.beck.javaiii_kirkwood.crrg.models.Picture;
import com.beck.javaiii_kirkwood.crrg.models.Picture_VM;
import com.beck.javaiii_kirkwood.crrg.models.User;
import com.beck.javaiii_kirkwood.crrg.data_interfaces.iPicture_DAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/all-Pictures")
public class All_Picture extends HttpServlet {private iPicture_DAO pictureDAO;
  @Override
  public void init() throws ServletException{
    pictureDAO = new Picture_DAO();
  }
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//To restrict this page based on privilege level
    int PRIVILEGE_NEEDED = 0;
    List<String> ROLES_NEEDED = new ArrayList<>();
    ROLES_NEEDED.add("Jonathan");
//add roles here
    HttpSession session = req.getSession();
    User user = (User)session.getAttribute("User");
    String mode = req.getParameter("mode");
    Integer parameter=0;
    try {
       parameter = Integer.parseInt(req.getParameter("filterBy"));
      }
    catch (Exception ex){
      parameter=0;
    }
    if (mode!=null) {
      if (mode.equals("album")) {
        String album = req.getParameter("album");

      }
      if (mode.equals("contributor")) {
        String contributor = req.getParameter("contributor");
      }
    }
    if (user==null||!user.isInRole(ROLES_NEEDED)){
      resp.sendError(HttpServletResponse.SC_FORBIDDEN);
      return;
    }

    session.setAttribute("currentPage",req.getRequestURL());
    List<Picture_VM> pictures = null;

    try {

      if  (mode!=null&& mode.equals("album")) {
        pictures = pictureDAO.getPicturebyAlbum(parameter,20,0);
      } else if (mode!=null && mode.equals("contributor")) {
        pictures = pictureDAO.getPicturebyContributor(parameter,20,0);
      }
      else{
        pictures =pictureDAO.getAllPicture(20,0,0,0);
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    req.setAttribute("Pictures", pictures);
    req.setAttribute("pageTitle", "All Pictures");
    req.getRequestDispatcher("WEB-INF/crrg/all-Pictures.jsp").forward(req,resp);

  }
}
