/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Article;
import enchere.entity.Article_;
import enchere.entity.Categorie;
import enchere.entity.Utilisateur;
import enchere.service.ArticleService;
import enchere.service.CategorieService;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author admin
 */
@WebServlet(name = "Ajouter", urlPatterns = {"/Ajouter"})
public class Ajouter extends AutowireServlet {

    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private CategorieService categorieService;
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Article a = new Article();
        Categorie categorie = new Categorie();
        Utilisateur utilisateur = new Utilisateur();
        
        String nom=req.getParameter("nom");
        a.setNom(nom);
        
        Integer prixDepart = Integer.parseInt(req.getParameter("prixDepart"));
        Integer prixActuel = Integer.parseInt(req.getParameter("prixDepart"));
        Integer prixFinal = Integer.parseInt(req.getParameter("prixFinal"));
        a.setPrixDepart(prixDepart);
        a.setPrixActuel(prixActuel);
        a.setPrixFinal(prixFinal);
        
        String login = (String) req.getSession().getAttribute("login");
        utilisateur=utilisateurService.findByLogin(login);
        utilisateur.getArticles().add(a);
        a.setUtilisateur(utilisateur);
        String choixCategorie=req.getParameter("choixCategorie");
        if(choixCategorie.equals("1")){
            categorie=categorieService.findOne(1L);
            categorie.getArticles().add(a);
            a.setCategorie(categorie);
        }
        if(choixCategorie.equals("2")){
            categorie=categorieService.findOne(2L);
            categorie.getArticles().add(a);
            a.setCategorie(categorie);
        }
        if(choixCategorie.equals("3")){
            categorie=categorieService.findOne(3L);
            categorie.getArticles().add(a);
            a.setCategorie(categorie);
        }
        if(choixCategorie.equals("4")){
            categorie=categorieService.findOne(4L);
            categorie.getArticles().add(a);
            a.setCategorie(categorie);
        }
        if(choixCategorie.equals("5")){
            categorie=categorieService.findOne(1L);
            categorie.getArticles().add(a);
            a.setCategorie(categorie);
        }
        
//        String dateV = req.getParameter("dateVente");
//        
//        DateFormat formater = DateFormat.getDateInstance(DateFormat.SHORT,Locale.FRANCE); 
//        Date date = null;
//        try {
//            date = formater.parse(dateV);
//        } catch (ParseException ex) {
//            Logger.getLogger(Ajouter.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        System.out.println(date);
        
        System.out.println(a);
        articleService.save(a);
        
        req.setAttribute("monVendeur", utilisateur);
        resp.sendRedirect("ListerArticles");
//        req.setAttribute("prixDepart", prixDepart);
//        req.setAttribute("prixActuel", prixActuel);
//        req.getRequestDispatcher("ListerArticles").include(req, resp);
    }

    
}
