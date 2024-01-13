
package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.LoginAuthenticator;

/**
 *
 * @author DELL
 */
public class RegistrationChecker extends HttpServlet {

      protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           response.sendRedirect("registration.html");
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         String city = request.getParameter("city");
         String number = request.getParameter("number");
         String id = request.getParameter("id");
         LoginAuthenticator la = new LoginAuthenticator();
          if(la.isRegister(username,password ,city ,number,id)){
                     HttpSession session = request.getSession(true);
                     session.setAttribute("username",username);
                     session.setAttribute("password",password);
                     session.setAttribute("city",city);
                     session.setAttribute("number",number);
                     session.setAttribute("id",id);
                     
                     
                     
                     
                     response.sendRedirect("reistrater.jsp");
                 }else{
                          response.sendRedirect("registration.html");
                 }
             }   
    }

  
