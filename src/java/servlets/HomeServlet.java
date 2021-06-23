
package servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class HomeServlet extends HttpServlet {

    

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      HttpSession sess = request.getSession();
    
        if(sess.getAttribute("username") == null){
            response.sendRedirect("login");
            sess.invalidate();
            return;
        } 
        getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession sess = request.getSession();
        String logout = request.getParameter("logout");
        
        request.setAttribute("logout", "logout");
        
        if(logout!=null){
            sess.invalidate();
            request.setAttribute("message", "You have logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            
        }
        
    }

}
