<%-- 
    Document   : login
    Created on : 9 mars 2016, 16:19:43
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <c:import url="_CSS.jsp"/>
        <c:import url="_TITRE.jsp"/>
    </head>
    <body>
        <c:import url="_MENU.jsp"/>
        <form action="LoginServlet" method="post">
            <label>Login</label>
            <input type="text" name="login"/>
            <br>
            <label>Mdp</label>
            <input type="password" name="mdp"/>
            <br>
            UTILISATEUR NON INSCRIT EN BASE !!!
            <br>
            VEUILLEZ VOUS INSCRIRE SVP
            <input type="submit"/>
        <br>
        </form>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
