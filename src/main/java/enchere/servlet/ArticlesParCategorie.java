/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import enchere.entity.Article;
import enchere.entity.Categorie;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.CategorieService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "ArticlesParCategorie", urlPatterns = {"/ArticlesParCategorie"})
public class ArticlesParCategorie extends AutowireServlet {

    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private CategorieService categorieService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Article> listeArticles = new ArrayList<>();
        String idCategorie=(String)req.getParameter("id");
        Categorie categorie = categorieService.findOne(Long.parseLong(idCategorie));
        listeArticles=articleService.findByCategorie(categorie);
        
        for( int i=0; i<listeArticles.size();i++){
            if(listeArticles.get(i).isPaye()==true){
                listeArticles.remove(i);
            }
        }
        String login = (String) req.getSession().getAttribute("login");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur=utilisateurService.findByLogin(login);
        
        req.setAttribute("monVendeur", utilisateur.getLogin());
        
        req.setAttribute("mesArticles", listeArticles);
        req.getRequestDispatcher("lister_articles.jsp").include(req, resp);
    }

}
