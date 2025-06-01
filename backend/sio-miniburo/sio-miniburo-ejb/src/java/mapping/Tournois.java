/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author chalo
 */
@Entity
@Table(name="tournois")
public class Tournois {

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_tournois")
    private Integer id_tournois;

    @Column(name="nom")
    private String nom;
    
    @Column(name="periode")
    private Integer periode;
    
    @Column(name="date_debut")
    private LocalDate date_debut;
    
    @Column(name="regle")
    private String regle;
    
    @Column(name="prix")
    private String prix;
    
    @Column(name="privée")
    private Integer privee;
    
    @Column(name="lieu")
    private String lieu;
    
    
    @ManyToOne
    @JoinColumn(name = "id_type")
    private Type type;
    
    @ManyToOne
    @JoinColumn(name = "id_style")
    private StyleElimination styleElimination;
    
    @ManyToOne
    @JoinColumn(name = "id_joueur")
    private Joueur joueur;
    
    @OneToMany(mappedBy = "tournois")
    private List<Inscription> inscriptions;


    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public StyleElimination getStyleElimination() {
        return styleElimination;
    }

    public void setStyleElimination(StyleElimination styleElimination) {
        this.styleElimination = styleElimination;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public Integer getId_tournois() {
        return id_tournois;
    }

    public void setId_tournois(Integer id_tournois) {
        this.id_tournois = id_tournois;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getPeriode() {
        return periode;
    }

    public void setPeriode(Integer periode) {
        this.periode = periode;
    }

    public LocalDate getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(LocalDate date_debut) {
        this.date_debut = date_debut;
    }

    public String getRegle() {
        return regle;
    }

    public void setRegle(String regle) {
        this.regle = regle;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public Integer getPrivee() {
        return privee;
    }

    public void setPrivee(Integer privee) {
        this.privee = privee;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id_tournois;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tournois other = (Tournois) obj;
        return this.id_tournois.equals(other.id_tournois);
    }
}
