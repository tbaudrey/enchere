/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.servlet;

import enchere.entity.Utilisateur;
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
import enchere.entity.Utilisateur;
import enchere.service.UtilisateurService;
import enchere.spring.AutowireServlet;

/**
 *
 * @author admin
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends AutowireServlet {
    
    @Autowired
    private UtilisateurService utilisateurService;
    
    private boolean trouve;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        Utilisateur u1= new Utilisateur(1L, "thomas1", "mdp1");
        Utilisateur u2= new Utilisateur(2L, "thomas2", "mdp2");
        Utilisateur u3= new Utilisateur(3L, "thomas3", "mdp3");
        Utilisateur u4= new Utilisateur(4L, "thomas4", "mdp4");
        
        utilisateurService.save(u1);
        utilisateurService.save(u2);
        utilisateurService.save(u3);
        utilisateurService.save(u4);
        
        List<Utilisateur> maListeUtilisateur = new ArrayList<>();
        maListeUtilisateur=(List<Utilisateur>) utilisateurService.findAll();
       
        trouve = false;
        for(Utilisateur u : maListeUtilisateur){
            if(u.getLogin().equals(req.getParameter("login"))){
                if(u.getMdp().equals(req.getParameter("mdp"))){
                    trouve=true;
                    req.getSession().setAttribute("login", req.getParameter("login"));
                    req.getSession().setAttribute("mdp", req.getParameter("mdp"));
                    req.getRequestDispatcher("logger.jsp").forward(req, resp);
                }
                req.getRequestDispatcher("loginMdpErreur.jsp").include(req, resp);
            }
        }
        if(trouve==false){
            req.getRequestDispatcher("loginUtilErreur.jsp").include(req, resp);
        }
            
    }
    
}
