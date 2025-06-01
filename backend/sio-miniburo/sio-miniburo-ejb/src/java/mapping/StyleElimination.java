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
import jakarta.persistence.Table;

/**
 *
 * @author chalo
 */
@Entity
@Table(name="style_elimination")
public class StyleElimination {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_style")
    private int id_style;

    @Column(name="libelle_style")
    private String libelle_style;

    public int getId_type() {
        return id_style;
    }

    public void setId_type(int id_style) {
        this.id_style = id_style;
    }

    public String getLibelle_style() {
        return libelle_style;
    }

    public void setLibelle_style(String libelle_style) {
        this.libelle_style = libelle_style;
    }
}
