package com.beck.javaiii_kirkwood.shared;
import io.github.cdimascio.dotenv.Dotenv;

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
    if (!req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString().equals("404")) {
      String errorCode = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE) + "";
      String exceptionType = req.getAttribute(RequestDispatcher.ERROR_EXCEPTION_TYPE) + "";
      String errorMsg = req.getAttribute(RequestDispatcher.ERROR_MESSAGE) + "";
      String servlet = req.getAttribute(RequestDispatcher.ERROR_SERVLET_NAME) + "";

      String result = "Error code: " + errorCode;
      if (!exceptionType.isEmpty()) {
        result += "\n<br>Exception: " + exceptionType;
      }
      result += "\n<br>Message: " + errorMsg;
      result += "\n<br>Servlet: " + servlet;

      System.err.println(result);

      EmailService.sendemail(Dotenv.load().get("ADMIN_EMAIL"), "Error!", result);

      req.setAttribute("pageTitle", "Error");

    }
  }
}