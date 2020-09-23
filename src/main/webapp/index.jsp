<%-- 
    Document   : index
    Created on : 20/09/2020, 21:30:56
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
            <form action="http://localhost:8080/LoginRequest" method="post">
                <label style="font-size: 32px;">Usuario </label>
                <input type="text" name="username" required style="border: 2px solid white;border-radius: 4px;background-color: black;width: 430px;height: 30px;font-size: 18px;color:white" value="Usuario">
                <br>
                <label style="font-size: 32px;">Senha </label>
                <input type="password" name="password" required style="border: 2px solid white;border-radius: 4px;background-color: black;width: 430px;height: 30px;font-size: 18px;color:white;" value="Senha">
                <br><br>
                <label for="saveLogin">Manter conectado</label>
                <input type="checkbox" id="saveLogin" name="saveLogin" value="saveLogin">
                <br><br>
                <%
                    try{
                        Object obj = request.getAttribute("login");
                        boolean login = (boolean)obj;
                        if(login == false){%>
                        <label style="font-size: 18px;color: red">Usuario ou Senha incorretos </label><br>
                        <%}
                    }catch(Exception e){
                        
                    }
                %>
                <button type="submit" style="border: none;width: 430px;height: 30px;font-size: 18px;">Login</button>
            </form>
        </div>
    </body>
</html>

<%
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

if(username != null && password != null){
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/LoginRequest");
    dispatcher.forward(request, response);
}

%>

