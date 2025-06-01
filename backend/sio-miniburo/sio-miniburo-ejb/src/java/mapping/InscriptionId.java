/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

/**
 *
 * @author chalo
 */
@Embeddable
@Table(name="inscription")
public class InscriptionId {
    @Column(name = "id_inscription")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_inscription;
    
    @Column(name="id_tournois")
    private int id_tournois;

    public int getId_inscription() {
        return id_inscription;
    }

    public void setId_inscription(int id_inscription) {
        this.id_inscription = id_inscription;
    }

    public int getId_tournois() {
        return id_tournois;
    }

    public void setId_tournois(int id_tournois) {
        this.id_tournois = id_tournois;
    }
}
