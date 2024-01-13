
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modal.LoginAuthenticator;


public class delete extends HttpServlet {

   
   
  

  
    

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             response.sendRedirect("failed.jsp");
    }

  
   
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
              String username = request.getParameter("username");
              String password = request.getParameter("password");
              String id = request.getParameter("id");
              
              
              LoginAuthenticator la = new LoginAuthenticator();
              String id2 = la.getId(password);
              if((id.equals(id2))){
               if(la.deleteData(id) )
                {    
                HttpSession session = request.getSession(true);
                response.sendRedirect("updatedata.jsp");
            }  else{
                    response.sendRedirect("failed.jsp");
            }        
              
          }else{
                  response.sendRedirect("failed.jsp");
              }     
        
        
    }

  
}
