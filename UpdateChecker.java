/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
public class UpdateChecker extends HttpServlet {

   
    

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           response.sendRedirect("login.html");
     
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");
              String id = request.getParameter("id");
            String city = request.getParameter("city");
            String number = request.getParameter("number");
          
            
            System.out.println(username+" "+id+" "+city+" "+password);
           
            LoginAuthenticator la = new LoginAuthenticator();
             
            
              System.out.println(id);
            
            if(la.dataUpdata(username,city,number,id,password) )
            {
                HttpSession session = request.getSession(true);
                response.sendRedirect("updatedata.jsp");
            }  else{
                    response.sendRedirect("failed.jsp");
            }        
           
    }

}

