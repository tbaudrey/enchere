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
            <h3>Vous avez selectionnez l'article suivant : ${monArticle.nom}</h3>
            <br>
            <h4>Prix de depart de l'article : ${prixDepart}</h4>
            <h4>Prix actuel de l'article : ${prixActuel}</h4>
            <a href="Encherir?id=${monArticle.id}">ENCHERIR   (+1 euro)</a>
            <br>
        </div>
        <br>    
        <c:import url="_PIED.jsp"/>
    </body>
</html>
