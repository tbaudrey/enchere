<%-- 
    Document   : ajouter_film
    Created on : 9 mars 2016, 10:35:30
    Author     : admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ajouter_article</title>
    </head>
    <body>
        <form action="Ajouter" method="post">
            <label>Nom de l'article</label>
            <input type="text" name="nom"/>
            <br>
            <label>Prix de départ</label>
            <input type="text" name="prixDepart"/>
            <br>
            <!--<form action="choix_categorie" method="post">-->
            <label>choix de la categorie</label>
                <select name="choixCategorie">
                    <option value="1">Véhicule</option>
                    <option value="2">Immobilier</option>
                    <option value="3">Multimedia</option>
                    <option value="4">Maison</option>
                    <option value="5">Autres</option>
                </select>
                <input type="submit"/>
        <!--</form>-->
        <br>
        </form>
    </body>
</html>
