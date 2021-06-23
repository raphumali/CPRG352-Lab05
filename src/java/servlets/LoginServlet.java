
package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import models.User;
import services.AccountService;



public class LoginServlet extends HttpServlet {

    

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        HttpSession sess = request.getSession();
        String username = request.getParameter("username");
     request.setAttribute("username", username);
     
     
     if(sess.getAttribute("username") != null){
         response.sendRedirect("home");
         return;
     }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        AccountService as = new AccountService();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        HttpSession sess = request.getSession();
        
        if(username == null || "".equals(username) || password == null || "".equals(password)){
             request.setAttribute("message", "Please enter username and password.");
        }else if (as.login(username, password) == null){
         request.setAttribute("message", "Incorrect info, please try again.");
        } else if(as.login(username, password) != null) {
         sess.setAttribute("username", username);
             getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
             return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
    }

   

}
