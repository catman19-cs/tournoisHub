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
import jakarta.persistence.Table;
import java.time.LocalDate;

/**
 *
 * @author chalo
 */
@Entity
@Table(name="matchs")
public class Matchs {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_match")
    private int id_match;

    @Column(name="resultat_match")
    private String resultat_match;
    
    @Column(name="date_match")
    private LocalDate date_match;
    
    @Column(name="lieu_match")
    private String lieu_match;
    @ManyToOne
    @JoinColumn(name = "id_tournois", insertable = false, updatable = false)
    private Tournois tournois;

    public int getId_match() {
        return id_match;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public String getResultat_match() {
        return resultat_match;
    }

    public void setResultat_match(String resultat_match) {
        this.resultat_match = resultat_match;
    }

    public LocalDate getDate_match() {
        return date_match;
    }

    public void setDate_match(LocalDate date_match) {
        this.date_match = date_match;
    }

    public String getLieu_match() {
        return lieu_match;
    }

    public void setLieu_match(String lieu_match) {
        this.lieu_match = lieu_match;
    }

    public Tournois getTournois() {
        return tournois;
    }

    public void setTournois(Tournois tournois) {
        this.tournois = tournois;
    }
    
    

}
