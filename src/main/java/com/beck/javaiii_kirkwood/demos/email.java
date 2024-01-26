package com.beck.javaiii_kirkwood.demos;

import com.beck.javaiii_kirkwood.demos.data.JsonReader;
import com.beck.javaiii_kirkwood.models.Artist;
import com.beck.javaiii_kirkwood.models.ArtistFromJson;
import com.beck.javaiii_kirkwood.shared.EmailService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/email")
public class email extends HttpServlet {



  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    req.getRequestDispatcher("WEB-INF/demos/email.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    String to=req.getParameter("email");
    String Subject=req.getParameter("subject");
    String message=req.getParameter("message");
    EmailService.sendemail(to,Subject,message);

  }

  @Override
  public void init() throws ServletException {

  }
}