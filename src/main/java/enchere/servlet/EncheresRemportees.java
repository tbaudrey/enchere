/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Enchere;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.EnchereService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "EncheresEnCours", urlPatterns = {"/EncheresEnCours"})
public class EncheresRemportees extends AutowireServlet {

    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private EnchereService enchereService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
      List<Article> listeArticles = new ArrayList<>();
      List<Enchere> listeEncheres = new ArrayList<>();
      
      String login = (String) req.getSession().getAttribute("login");
      Utilisateur utilisateur = new Utilisateur();
      utilisateur=utilisateurService.findByLogin(login);
      
      listeEncheres=enchereService.findByUtilisateur(utilisateur);
      
      Article article = new Article();
      for(Enchere enchere : listeEncheres){
          article=enchere.getArticle();
          if(!listeArticles.contains(article)){
              listeArticles.add(article);
          }
      }
      
      for( int i=0; i<listeArticles.size();i++){
            if(listeArticles.get(i).isPaye()==true){
                listeArticles.remove(i);
            }
        }
      
//        req.setAttribute("monVendeur", utilisateur.getLogin());
        req.setAttribute("mesArticles", listeArticles);
        req.getRequestDispatcher("encheres_en_cours.jsp").include(req, resp);
    }

    
}
