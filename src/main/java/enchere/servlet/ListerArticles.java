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
import enchere.service.ArticleService;
import enchere.spring.AutowireServlet;

/**
 *
 * @author admin
 */
@WebServlet(name = "ListerArticles", urlPatterns = {"/ListerArticles"})
public class ListerArticles extends AutowireServlet {

    @Autowired
    private ArticleService articleService;
 
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Article> listeArticles = new ArrayList<>();
        listeArticles=(List<Article>) articleService.findAll();
        
        req.setAttribute("mesArticles", listeArticles);
        req.getRequestDispatcher("lister_articles.jsp").include(req, resp);
        
    }
    
    
}
