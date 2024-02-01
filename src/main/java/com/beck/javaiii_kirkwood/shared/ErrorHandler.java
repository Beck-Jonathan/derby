package com.beck.javaiii_kirkwood.shared;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/errorHandler")
public class ErrorHandler extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.getRequestDispatcher("WEB-INF/Shared/error.jsp").forward(req, resp);
    String errorCode = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE) + "";
    String exceptionType = req.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE) + "";
    String errorMsg = req.getAttribute(RequestDispatcher.ERROR_MESSAGE) + "";

    String result = "Error code: " + errorCode;
    if(!exceptionType.equals("")) {
      result += "\nException: " + exceptionType;
    }
    result += "\nMessage: " + errorMsg;
    System.err.println(result);

    EmailService.sendemail("JJBeck7@gmail.com","Error!",result);


    req.setAttribute("pageTitle", "Error");

  }
}
