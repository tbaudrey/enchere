<%-- 
    Document   : encherir
    Created on : 11 mars 2016, 13:54:34
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="_CSS.jsp"/>
        <c:import url="_TITRE.jsp"/>
        <title>Mon Compte</title>
    </head>
    <body>
        <c:import url="_MENU.jsp"/>
        <br>
        <div class="contenu">
            <br>
            <a href="articles_mev.jsp">Mes articles mis en vente   /</a>
            <a href="encheres_en_cours.jsp">Mes encheres en cours   /</a>
            <a href="encheres_remportees.jsp">Encheres remportees</a>
            <br>
            <br>
        </div>
        <br>    
        <c:import url="_PIED.jsp"/>
    </body>
</html>
