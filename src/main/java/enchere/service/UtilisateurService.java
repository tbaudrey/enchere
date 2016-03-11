/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import enchere.entity.Utilisateur;

/**
 *
 * @author admin
 */
@Service
public interface UtilisateurService extends CrudRepository<Utilisateur, Long>{
    
    public Utilisateur findByLogin (String login);
}
