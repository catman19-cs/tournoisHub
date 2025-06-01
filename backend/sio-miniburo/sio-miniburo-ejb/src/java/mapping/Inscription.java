/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author chalo
 */
@Entity
@Table(name="inscription")
public class Inscription {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_inscription")
    private Integer id_inscription;
    
    @Column(name="abandon" ,insertable = false)
    private Boolean abandon;
    
    
    @Column(name="en_lice" ,insertable = false)
    private Boolean en_lice;
    
    @ManyToOne
    @JoinColumn(name = "id_tournois")
    private Tournois tournois;
    
    @ManyToOne
    @JoinColumn(name = "id_joueur")
    private Joueur joueur;

    public Integer getId_inscription() {
        return id_inscription;
    }

    public void setId_inscription(Integer id_inscription) {
        this.id_inscription = id_inscription;
    }
    
    

    public Boolean getAbandon() {
        return abandon;
    }

    public void setAbandon(Boolean abandon) {
        this.abandon = abandon;
    }

    
    public Boolean getEn_lice() {
        return en_lice;
    }

    public void setEn_lice(Boolean en_lice) {
        this.en_lice = en_lice;
    }

    public Tournois getTournois() {
        return tournois;
    }

    public void setTournois(Tournois tournois) {
        this.tournois = tournois;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    
    
}
