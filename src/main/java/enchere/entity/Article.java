/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enchere.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author admin
 */
@Entity
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Integer prixActuel;
    private Integer prixDepart;
    private Integer prixFinal;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVente;
    private boolean paye;
    private String nom;
    
    @ManyToOne
    @JoinColumn(name = "utilisateur")
    private Utilisateur utilisateur;
    
    @ManyToOne
    @JoinColumn(name = "categorie")
    private Categorie categorie;
    
    @OneToMany(mappedBy = "article")
    private List<Enchere> encheres;

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Enchere> getEncheres() {
        return encheres;
    }

    public void setEncheres(List<Enchere> encheres) {
        this.encheres = encheres;
    }
    

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Integer getPrixFinal() {
        return prixFinal;
    }

    public void setPrixFinal(Integer prixFinal) {
        this.prixFinal = prixFinal;
    }
    

    public Integer getPrixActuel() {
        return prixActuel;
    }

    public void setPrixActuel(Integer prixActuel) {
        this.prixActuel = prixActuel;
    }

    public Integer getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(Integer prixDepart) {
        this.prixDepart = prixDepart;
    }

    public Date getDateVente() {
        return dateVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }

    public boolean isPaye() {
        return paye;
    }

    public void setPaye(boolean paye) {
        this.paye = paye;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "enchere.entity.Article[ id=" + id + " ]";
    }
    
}
