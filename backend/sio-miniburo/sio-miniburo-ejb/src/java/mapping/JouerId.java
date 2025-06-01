/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapping;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 *
 * @author chalo
 */
@Embeddable
@Table(name="jouer")
public class JouerId {
    @Column(name = "id_match")
    private int id_match;
    
    @Column(name="id_inscription")
    private int id_inscription;
}
