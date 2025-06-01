package modele;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.List;
import mapping.Inscription;
import mapping.InscriptionId;
import mapping.Type;

import mapping.Joueur;
import mapping.Matchs;
import mapping.MesMatchs;
import mapping.StyleElimination;
import mapping.Tournois;


@Stateless
public class monEJB1 {
    @PersistenceContext(unitName = "sio-miniburo-ejb")
    private EntityManager em;
    

public List<Object[]> getJoueurByConnect(String email,String mdp) {
    String query = """
SELECT j.id 
        FROM Joueur j 
        WHERE j.email = :email
        AND j.mdp = :mdp
    """;
    return em.createQuery(query, Object[].class).setParameter("email", email).setParameter("mdp", mdp).getResultList();
}
public Joueur getJoueurById(int id) {
   
    return em.find(Joueur.class, id);
    
}
public List<Tournois> getTournois() {
   
    String query = """
SELECT t
        FROM Tournois t
        WHERE date_debut>:date
        
    """;
    LocalDate date=LocalDate.now();
    return em.createQuery(query, Tournois.class).setParameter("date", date).getResultList();
    
}
public List<Tournois> getMesTournois(int id){
    String query = """
SELECT t
        FROM Tournois t 
        WHERE t.joueur.id_joueur = :id
        AND date_debut>:date
        
    """;
    LocalDate date=LocalDate.now();
    return em.createQuery(query, Tournois.class).setParameter("id", id).setParameter("date", date).getResultList();
}
public List<Tournois> getMesInscription(int id){
    String query = """
        SELECT t
        FROM Tournois t,Inscription i ,Joueur j
        WHERE t.id_tournois=i.tournois.id_tournois
        AND i.joueur.id_joueur= :id
        
    """;
    return em.createQuery(query, Tournois.class).setParameter("id", id).getResultList();
}
public Response createInscription(Integer id_joueur,Integer id_tournois){
    Joueur joueur=em.find(Joueur.class, id_joueur);
    Tournois tournois=em.find(Tournois.class, id_tournois);
    Inscription ins=new Inscription();
    
    ins.setTournois(tournois);
    ins.setJoueur(joueur);
    
    em.persist(ins);
    return Response.status(Response.Status.CREATED).entity("inscription").build();
}
public Response createJoueur(String speudo,String anectode,String nom,String prenom,String adresse,String cp,String mdp,String email){
    
    Joueur joueur = new Joueur();
    joueur.setAdresse(adresse);
    joueur.setAnecdote(anectode);
    joueur.setCp(cp);
    joueur.setEmail(email);
    joueur.setMdp(mdp);
    joueur.setNom(nom);
    joueur.setPrenom(prenom);
    joueur.setPseudo(speudo);
    
    em.persist(joueur);
    return Response.status(Response.Status.CREATED).entity(joueur).build();
}
public Response createTournois(String nom,Integer periode,LocalDate date_debut,String regle,String prix,Integer privee,String lieu,Integer id_style,Integer id_joueur,Integer id_type){
    Tournois tournois=new Tournois();
    tournois.setDate_debut(date_debut);
    tournois.setJoueur(em.find(Joueur.class,id_joueur));
    tournois.setLieu(lieu);
    tournois.setNom(nom);
    tournois.setPeriode(periode);
    tournois.setPrivee(privee);
    tournois.setPrix(prix);
    tournois.setRegle(regle);
    tournois.setStyleElimination(em.find(StyleElimination.class, id_style));
    tournois.setType(em.find(Type.class, id_type));
    
    em.persist(tournois);
        return Response.status(Response.Status.CREATED).entity(tournois).build();

}

public List<StyleElimination> getStyle(){
    String query = """
        SELECT s
        FROM StyleElimination s
        
    """;
    return em.createQuery(query, StyleElimination.class).getResultList();
}
public List<Type> getType(){
    String query = """
        SELECT t
        FROM Type t
        
    """;
    return em.createQuery(query, Type.class).getResultList();
}
public List<Matchs> getMesMatch(Integer id_joueur){
    String query = """
        SELECT m 
        FROM Matchs m,Jouer j ,Inscription i
        WHERE m.id_match=j.id.id_match
        AND i.id_inscription=j.id.id_inscription
        AND i.joueur.id_joueur=:id_joueur
        AND m.date_match>=:date
        
        
    """;
    LocalDate date=LocalDate.now();
    return em.createQuery(query, Matchs.class).setParameter("id_joueur", id_joueur).setParameter("date", date).getResultList();
}
/*public List<Object[]> getAttaquesByPokemonId(int id) {
    String query = """
        SELECT p.nom_pokemon, a.nom_attaque, ap.niveau, ap.methode
        FROM Pokemon p
        JOIN p.apprendreList ap
        JOIN ap.attaque a
        WHERE p.id_pokemon = :id
    """;
    return em.createQuery(query, Object[].class).setParameter("id", id).getResultList();
}
public List<Attaque>getAttaquesById(int id) {
    String query = "SELECT a FROM Attaque a WHERE a.id_attaque= :id ";
    return em.createQuery(query, Attaque.class).setParameter("id", id).getResultList();
}
public List<Pokemon>getPokemonInfo(int id){
    String query="""
                 SELECT p.nom_pokemon, ap.attaque.nom_attaque, ap.niveau, ap.methode,e.niveau, m.nom
                 FROM Pokemon p
                 JOIN p.types t
                 JOIN p.apprendreList ap
                 JOIN p.evoluer e
                 JOIN e.methode_evol m
                 JOIN ap.attaque a
                 WHERE p.id_pokemon = :id
                 """;
    
    return em.createQuery(query).setParameter("id", id).getResultList();
}
public List<Dresseur>getDresseurInfo(int id){
    String query="""
                 SELECT d.nom
                 FROM Dresseur d
                 WHERE d.id = :id
                 """;
    
    return em.createQuery(query).setParameter("id", id).getResultList();
}
public void ajouterDresseur(String nom,int id){
    String query="""
                 SELECT l
                 FROM Lieu l
                 WHERE l.id= :id
                 """;
    
    Lieu lieu= em.createQuery(query,Lieu.class).setParameter("id", id).getSingleResult();
    Dresseur dresseur=new Dresseur();
    em.persist(dresseur);
    dresseur.setLieu(lieu);
    dresseur.setNom(nom);
    
}
public void ajouterPokeADresseur(Integer idPoke,Integer idDresseur,Integer niveau,Integer ordre){
    
    
    PossederPoke possederpoke=new PossederPoke();
    
    possederpoke.getId().setId_dresseur(idDresseur);
    possederpoke.getId().setId_pokemon(idPoke);
    //possederpoke.setId(possederpokeId);
    possederpoke.setNiveau(niveau);
    possederpoke.setOrdre(ordre);
    em.persist(possederpoke);
}

*/
}
