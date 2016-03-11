/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import enchere.entity.Categorie;
import enchere.service.CategorieService;
import enchere.spring.AutowireServlet;

/**
 *
 * @author admin
 */
@WebServlet(name = "ListerCategories", urlPatterns = {"/ListerCategories"})
public class ListerCategories extends AutowireServlet {

    @Autowired
    private CategorieService categorieService;
 
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Categorie> listeCategories = new ArrayList<>();
        
        Categorie c1 = new Categorie(1L, "Vehicule");
        Categorie c2 = new Categorie(2L, "Immobilier");
        Categorie c3 = new Categorie(3L, "Multimedia");
        Categorie c4 = new Categorie(4L, "Maison");
        Categorie c5 = new Categorie(5L, "Autres");
        categorieService.save(c1);
        categorieService.save(c2);
        categorieService.save(c3);
        categorieService.save(c4);
        categorieService.save(c5);
        
        listeCategories=(List<Categorie>) categorieService.findAll();
        
        
        req.setAttribute("mesCategories", listeCategories);
        req.getRequestDispatcher("lister_categories.jsp").include(req, resp);
        
    }
    
    
}
