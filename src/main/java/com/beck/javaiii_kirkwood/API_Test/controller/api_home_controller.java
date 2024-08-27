package com.beck.javaiii_kirkwood.API_Test.controller;

import com.beck.javaiii_kirkwood.API_Test.data.PlayerJSON;
import com.beck.javaiii_kirkwood.API_Test.model.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


  /******************
   Create the Servlet  For  signing in
   Created By Jonathan Beck3/11/2024

   ***************/
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.io.IOException;
import com.beck.javaiii_kirkwood.budget_app.data.*;
import com.beck.javaiii_kirkwood.budget_app.models.*;
import com.beck.javaiii_kirkwood.shared.EmailService;
import com.mysql.cj.Session;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

  @WebServlet("/api_home")
  public class api_home_controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      List <Player> players = PlayerJSON.getAll();
      HttpSession session = req.getSession();
      session.setAttribute("Players",players);
      session.setAttribute("currentPage",req.getRequestURL());
      req.setAttribute("pageTitle", "API Home");

      req.getRequestDispatcher("WEB-INF/api_experiment/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String _Player_ID = req.getParameter("inputplayerPlayer_ID");
      _Player_ID=_Player_ID.trim();
      Map<String, String> results = new HashMap<>();
      List <Player> players = new ArrayList<>();
      results.put("Player_ID",_Player_ID);
      try {
        Integer id = (Integer.valueOf(_Player_ID));
        players = PlayerJSON.getPlayerByID(id);

        if (players.isEmpty()){
          throw new IllegalArgumentException("Player Not Found");
        }
      } catch(Exception e) {
        results.put("playerPlayer_IDerror", e.getMessage());

      }

      HttpSession session = req.getSession();
      session.setAttribute("Players",players);
      session.setAttribute("results",results);
      session.setAttribute("currentPage",req.getRequestURL());
      req.setAttribute("pageTitle", "API Home");

      req.getRequestDispatcher("WEB-INF/api_experiment/home.jsp").forward(req, resp);

    }
  }

