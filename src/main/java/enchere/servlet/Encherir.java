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
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.EnchereService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;

/**
 *
 * @author admin
 */
@WebServlet(name = "Encherir", urlPatterns = {"/Encherir"})
public class Encherir extends AutowireServlet {

    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private EnchereService enchereService;
    
    @Autowired
    private UtilisateurService utilisateurService;
 
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String idArticle=(String)req.getParameter("id");
        System.out.println(idArticle);
        Article article = articleService.findOne(Long.parseLong(idArticle));
        Integer prixActuel=article.getPrixActuel();
        Integer prixDepart=article.getPrixDepart();
        Integer prixFinal=article.getPrixFinal();
        if(prixActuel<prixFinal-1){
            prixActuel=prixActuel+1;
            
            String login = (String) req.getSession().getAttribute("login");
            Utilisateur utilisateur = new Utilisateur();
            utilisateur=utilisateurService.findByLogin(login);
            Enchere enchere = new Enchere();
            enchere.setUtilisateur(utilisateur);
            utilisateur.getEncheres().add(enchere);
            enchere.setArticle(article);
            article.getEncheres().add(enchere);

            article.setPrixActuel(prixActuel);
            articleService.save(article);
            
            Utilisateur vendeur = new Utilisateur();
            vendeur=article.getUtilisateur();

            req.setAttribute("monVendeur", vendeur.getLogin());
            req.setAttribute("monArticle", article);
            req.setAttribute("prixDepart", prixDepart);
            req.setAttribute("prixActuel", prixActuel);
            req.getRequestDispatcher("encherir.jsp").include(req, resp);
        }
        else{
            prixActuel=prixFinal;
            article.setPaye(true);
            article.setPrixActuel(prixActuel);
            articleService.save(article);
            req.setAttribute("monArticle", article);
            req.setAttribute("prixFinal", prixFinal);
            req.getRequestDispatcher("article_remporte.jsp").include(req, resp);
        }
            
        
        
        
        
    }
    
    
}
