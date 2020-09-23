package com.mycompany.m1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Matheus
 */
public class DesconnectRequest extends HttpServlet {

    protected void desconectar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie ck[] = request.getCookies();
        

        Cookie password = null, username = null;
        
        for(int i = 0;i<ck.length;i++){
            if(ck[i].getName().equals("username")){
                username = ck[i];
            }
            if(ck[i].getName().equals("password")){
                password = ck[i];
            }
        }
        
        if(password != null){
            password.setMaxAge(0);
            response.addCookie(password);
        }
        if(username != null){
            username.setMaxAge(0);
            response.addCookie(username);
        }
       
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
        
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        desconectar(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        desconectar(request, response);
    }


}
