package mapping;

import jakarta.persistence.*;


@Entity
@Table(name="type")
public class Type {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_type")
    private int id_type;

    @Column(name="libelle")
    private String libelle;
    
    @ManyToOne
    @JoinColumn(name = "id_categorie", insertable = false, updatable = false)
    private Categorie categorie;
    
    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

  
    
    
}
