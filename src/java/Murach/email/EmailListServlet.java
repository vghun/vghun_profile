/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Murach.email;

/**
 *
 * @author Admin
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import Murach.business.User;


public class EmailListServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, 
                         HttpServletResponse response)
                         throws ServletException, IOException{
        String url = "/index.html";
        // get current action
        String action = request.getParameter("action");
        if (action==null){
            action = "join"; //default action
        }
        if(action.equals("join")){
            url="/index.html";// the "join" page
        }
        else if (action.equals("add")){
            //get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email= request.getParameter("email");
            
          // store data in User object and save User object in db
            User user = new User(firstName, lastName, email);

            // set User object in request object and set URL
            request.setAttribute("user", user);
            url = "/thanks.jsp";   // the "thanks" page
        }
        // forward request and response object to specificed URL 
        getServletContext()
               .getRequestDispatcher(url)
               .forward(request, response);
                              
    }
    @Override
     protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response)
                         throws ServletException, IOException{
                      doPost(request,response) ;
    }
}
