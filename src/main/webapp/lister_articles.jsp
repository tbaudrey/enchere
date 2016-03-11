<%-- 
    Document   : lister_films
    Created on : 8 mars 2016, 15:14:00
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <c:import url="_CSS.jsp"/>
        <c:import url="_TITRE.jsp"/>
        <title>Page Lister articles</title>
    </head>
    <body>
        <c:import url="_MENU.jsp"/>
        <br>
        <div class="contenu">
            <br>
            <c:forEach items="${mesArticles}" var="monArticleActuel">
                        - ${monArticleActuel.nom} Prix de depart : ${monArticleActuel.prixDepart}, Prix Actuel : ${monArticleActuel.prixActuel}
                        <a href="EnchereServlet?id=${monArticleActuel.id}">ENCHERIR</a>
                       <br>
            </c:forEach>
            
            <br>
        </div>
        <br>    
        <c:import url="_PIED.jsp"/>
    </body>
</html>
