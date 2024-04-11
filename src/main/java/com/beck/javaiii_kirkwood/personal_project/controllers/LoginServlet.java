package com.beck.javaiii_kirkwood.personal_project.controllers;

/******************
 Create the Servlet  For  signing in
 Created By Jonathan Beck3/11/2024

 ***************/
import com.beck.javaiii_kirkwood.personal_project.data.*;
import com.beck.javaiii_kirkwood.personal_project.models.*;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/signin")
public class LoginServlet extends HttpServlet{

  static List<Language> alllanguages = LanguageDAO.getAllLanguage();



  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("pageTitle", "Log in!");

    req.getRequestDispatcher("WEB-INF/personal-project/Login.jsp").forward(req, resp);  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    req.setAttribute("pageTitle", "Log in!");

    String _User_Name = req.getParameter("inputuserUser_Name");
    String _User_PW = req.getParameter("inputuserUser_PW");

    char[] _User_PWChar = _User_PW.toCharArray();


    Map<String, String> results = new HashMap<>();
    results.put("User_Name",_User_Name);
    results.put("User_PW",_User_PW);
    User user = new User();

    int id =0;
    try {
      String hashed = UserDAO.get_pw(_User_Name);
      if(!BCrypt.checkpw(_User_PW,hashed)){

        session.setAttribute("loginFail", "Login Failed, please verify your username and password");
      }
      else{
        session.removeAttribute("loginFail");
        id=UserDAO.getUserIDByUserName(_User_Name);
        user.setUser_ID(id);
        user=UserDAO.getUserByPrimaryKey(user);
        user.setUser_PW(null);
        results.put("dbStatus",user.getEmail());

        session.setAttribute("User",user);
        User XXXX = (User) session.getAttribute("User");
        String currentPage =  session.getAttribute("currentPage").toString();

        resp.sendRedirect(currentPage);


        return;
      }

    }
    catch (Exception ex){
      session.setAttribute("loginFail", "Login Failed, please verify your username and password");
    }

    if (id==0){
      results.put("dbStatus1","Login Failed, please verify your username and password");

    }

    String currentPage =  session.getAttribute("currentPage").toString();


    session.setAttribute("dbStatus","Login Fail!");
    req.setAttribute("results", results);
    req.setAttribute("pageTitle", "Log in! ");
    resp.sendRedirect(currentPage);
    return;
    //req.getRequestDispatcher("WEB-INF/personal-project/Login.jsp").forward(req, resp);

  }
}

