package com.mycompany.m1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *
 * @author Matheus Evandro Rech
 *
 */
@WebServlet(name = "LoginRequest", urlPatterns = {"/LoginRequest"})
public class LoginRequest extends HttpServlet {
    
    private List<Usuario> users = new ArrayList<Usuario>();
    
    private void verificaLogin(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        users.add(new Usuario("Juvenau","euamoaamaerica"));
        users.add(new Usuario("Trevor","euamobeber"));
        users.add(new Usuario("Amanda","hellovietnam"));
        users.add(new Usuario("ProgramadorTops","eusouprogramador"));
        users.add(new Usuario("Univali","euamoestudar"));
        
        Cookie ck[] = request.getCookies();
        
        String username = null;
        String password = null;
        for(int i = 0;i<ck.length;i++){
            if(ck[i].getName().equals("username")){
                username = ck[i].getValue();
            }
            if(ck[i].getName().equals("password")){
                password = ck[i].getValue();
            }
        }
        
        
        if(username == null){
            username = request.getParameter("username");
        }
        if(password == null){
            password = request.getParameter("password");
        }

        String[] checkbox = request.getParameterValues("saveLogin");
        
        boolean login = false;
        
        for(Usuario loginUser : users){
            if(loginUser.checkUser(username, password)){
                login = true;
                
                if(checkbox != null){
                    Cookie savePassword = new Cookie("password",password);
                    Cookie saveUsername = new Cookie("username",username);
                    
                    savePassword.setHttpOnly(true);
                    savePassword.setMaxAge(604800);
                    saveUsername.setHttpOnly(true);
                    saveUsername.setMaxAge(604800);
                    
                    response.addCookie(savePassword);
                    response.addCookie(saveUsername);
                }
                
                request.setAttribute("login", login);
                request.setAttribute("username", username);
        
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home.jsp");
                dispatcher.forward(request, response);  
            }
        }
        
        
        request.setAttribute("login", login);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        verificaLogin(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        verificaLogin(request, response);   
    }
}
