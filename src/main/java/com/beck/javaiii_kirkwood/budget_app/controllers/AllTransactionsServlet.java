package com.beck.javaiii_kirkwood.budget_app.controllers; /******************
 Create the Servlet  For Viewing all of the  Transaction table
 Created By Jonathan Beck 7/22/2024
 ***************/

import com.beck.javaiii_kirkwood.budget_app.data.TransactionDAO;
import com.beck.javaiii_kirkwood.budget_app.data.CategoryDAO;
import com.beck.javaiii_kirkwood.budget_app.models.Category;
import com.beck.javaiii_kirkwood.budget_app.models.Transaction;
import com.beck.javaiii_kirkwood.budget_app.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@WebServlet("/all-Transactions")
public class AllTransactionsServlet extends HttpServlet {

  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//To restrict this page based on privilege level
  int PRIVILEGE_NEEDED = 0;
  HttpSession session = req.getSession();
  User user = (User)session.getAttribute("User_B");
  //if (user==null||user.getPrivilege_ID()<PRIVILEGE_NEEDED){
   // resp.sendError(HttpServletResponse.SC_FORBIDDEN);
   // return;
 // }

  session.setAttribute("currentPage",req.getRequestURL());
  List<Transaction> transactions = null;
  int transaction_count=0;

  int page_size=20;

    int page_number = 1;
    int recordsPerPage = 5;
    if(req.getParameter("page") != null) {
      page_number = Integer.parseInt(req.getParameter("page"));
    }

    // page_size = req.get

    int offset=(page_number-1)*(page_size);


    try {
      transaction_count = TransactionDAO.getTransactionCountByUser(user.getUser_ID());

      transactions = TransactionDAO.getTransactionByUser(user.getUser_ID(),page_size,offset);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    int total_pages = 1+(transaction_count/page_size);

    //https://stackoverflow.com/questions/31410007/how-to-do-pagination-in-jsp

    req.setAttribute("noOfPages", total_pages);
    //fix current page
    req.setAttribute("currentPage", page_number);
    List <Category> allCategories = CategoryDAO.getCategoryByUser(user.getUser_ID());
    req.setAttribute("Categories", allCategories);


    req.setAttribute("Transactions", transactions);
  req.setAttribute("pageTitle", "All Transactions");
  req.getRequestDispatcher("WEB-INF/Budget_App/ViewAllTransactions.jsp").forward(req,resp);

}
}
