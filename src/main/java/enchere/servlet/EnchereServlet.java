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
@WebServlet(name = "EnchereServlet", urlPatterns = {"/EnchereServlet"})
public class EnchereServlet extends AutowireServlet {

    @Autowired
    private ArticleService articleService;
 
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String idArticle=(String)req.getParameter("id");
        Article article = articleService.findOne(Long.parseLong(idArticle));
        Integer prixDepart=article.getPrixDepart();
        Integer prixActuel=article.getPrixActuel();
        
        article.setPrixActuel(prixActuel);
        articleService.save(article);
        
        req.setAttribute("monArticle", article);
        req.setAttribute("prixDepart", prixDepart);
        req.setAttribute("prixActuel", prixActuel);
        req.getRequestDispatcher("encherir.jsp").include(req, resp);
        
    }
    
    
}
