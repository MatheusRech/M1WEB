<%-- 
    Document   : home
    Created on : 20/09/2020, 22:39:30
    Author     : Matheus Evandro Rech
--%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lag Switch Marketplace</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body style="background-color:#034485;font-family:Roboto">
        <p style="color: white;font-size: 41px;text-align: center">Sejá bem vindo ao <b>Lag Switch Marketplace</b></p>
        <div style="text-align:center;color:white">
                <%
                    try{
                        Object obj = request.getAttribute("login");
                        boolean login = (boolean)obj;
                        if(login){
                        %>
                        <label style="font-size: 18px;color: white"><%=(String)request.getAttribute("username")%></label><br>
                        <%}else{
                            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                            dispatcher.forward(request, response);
                          }
                    }catch(Exception e){
                        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                        dispatcher.forward(request, response);
                    }
                %>
                <br><br>
                <form action="DesconnectRequest" method="GET">
                    <button type="submit" style="border: none;width: 430px;height: 30px;font-size: 18px;">Desconectar</button>    
                </form>
                
        </div>
    </body>
</html>
