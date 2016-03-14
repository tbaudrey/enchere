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
        <title>Encherir</title>
    </head>
    <body>
        <c:import url="_MENU.jsp"/>
        <br>
        <div class="contenu">
            <br>
            <h3>FELICITATIONS ! Vous avez remportes l'article suivant : ${monArticle.nom}</h3>
            <br>
            <h4>Prix final de l'article : ${prixFinal}</h4>
            
                <a href="EnchereRemportees">PAYER ICI</a>
                
            
            <br>
        </div>
        <br>    
        <c:import url="_PIED.jsp"/>
    </body>
</html>
