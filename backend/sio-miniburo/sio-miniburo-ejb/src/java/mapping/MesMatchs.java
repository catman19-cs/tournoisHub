/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 *
 * @author chalo
 */
public class MesMatchs {
    @ManyToOne
    private Matchs match;

    
    private String nomAdversaire;

    public Matchs getMatch() {
        return match;
    }

    public void setMatch(Matchs match) {
        this.match = match;
    }

    public String getNomAdversaire() {
        return nomAdversaire;
    }

    public void setNomAdversaire(String nomAdversaire) {
        this.nomAdversaire = nomAdversaire;
    }
    
    
}
