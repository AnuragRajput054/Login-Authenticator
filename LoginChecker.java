
package controller;

import dto.UserDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.LoginAuthenticator;


public class LoginChecker extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
                     response.sendRedirect("login.html");
        
    }

   
   
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException 
    {
                            
        
         
         String username = request.getParameter("username");
         String password = request.getParameter("password");
         
         UserDTO user  = new UserDTO();
         user.setUsername(username);
         user.setPassword(password);
         LoginAuthenticator la = new LoginAuthenticator();
             String id = la.getId(password);
             String city = la.getcity(password);
             String number = la.getNumber(password);
             
                   if(la.islogin(user)){
                 
                     HttpSession session = request.getSession(true);
                      session.setAttribute("username",username);
                      session.setAttribute("password",password);
                       session.setAttribute("id",id);
                        session.setAttribute("city",city);
                        session.setAttribute("number",number);
             
                       response.sendRedirect("welcome.jsp");
                     
                 }else{
                     response.sendRedirect("login.html");
                   }  
        
    }
}
    
   
        
   
