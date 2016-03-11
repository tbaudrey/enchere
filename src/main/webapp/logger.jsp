<%-- 
    Document   : logger
    Created on : 9 mars 2016, 16:28:11
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>logger page</title>
        <c:import url="_CSS.jsp"/>
        <c:import url="_TITRE.jsp"/>
    </head>
    <body>
        <c:import url="_MENU.jsp"/>
        <div>
            Bonjour ${sessionScope.login}
        </div>
        <a href="ListerArticles">Home</a>
        <c:import url="_PIED.jsp"/>
    </body>
</html>
