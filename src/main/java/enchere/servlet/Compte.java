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
import enchere.entity.Article;
import enchere.entity.Categorie;
import enchere.service.ArticleService;
import enchere.spring.AutowireServlet;

/**
 *
 * @author admin
 */
@WebServlet(name = "Compte", urlPatterns = {"/Compte"})
public class Compte extends AutowireServlet {

    @Autowired
    private ArticleService articleService;
 
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
//        String idArticle=(String)req.getParameter("id");
//        System.out.println(idArticle);
//        Article article = articleService.findOne(Long.parseLong(idArticle));
//        System.out.println(article);
//        Integer prixActuel=article.getPrixActuel();
//        Integer prixDepart=article.getPrixDepart();
//        prixActuel=prixActuel+1;
//        
//        article.setPrixActuel(prixActuel);
//        articleService.save(article);
//        
//        req.setAttribute("monArticle", article);
//        req.setAttribute("prixDepart", prixDepart);
//        req.setAttribute("prixActuel", prixActuel);
        req.getRequestDispatcher("compte.jsp").include(req, resp);
        
    }
    
    
}
