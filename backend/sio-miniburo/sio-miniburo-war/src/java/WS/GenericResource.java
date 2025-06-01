package WS;
import modele.monEJB1;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import mapping.Joueur;
import mapping.Tournois;
import java.util.Map ;
import mapping.Inscription;
import mapping.Matchs;
import mapping.StyleElimination;
import mapping.Type;


@Stateless
@Path("/tournois")
public class GenericResource {

@EJB
private monEJB1 tournoisEJB;

public GenericResource() {
}


@GET
@Path("/joueur/{email}/{mdp}")
@Produces(MediaType.APPLICATION_JSON)
public List<Object[]> getPokemonById(@PathParam("email") String email,@PathParam("mdp") String mdp) {

    return tournoisEJB.getJoueurByConnect(email,mdp);
}
@GET
@Path("/joueurById/{id}")
@Produces(MediaType.APPLICATION_JSON)
public Joueur getJoueurById(@PathParam("id") int id) {
    return tournoisEJB.getJoueurById(id);
}
@GET
@Path("/tournois")
@Produces(MediaType.APPLICATION_JSON)
public List<Tournois> getTournois() {
    List<Tournois> lst = tournoisEJB.getTournois();
    return tournoisEJB.getTournois();
}
@GET
@Path("/tournois/{id}")
@Produces(MediaType.APPLICATION_JSON)
public List<Tournois> getMesTournois(@PathParam("id") int id) {
    return tournoisEJB.getMesTournois(id);
}
@GET
@Path("/inscription/{id}")
@Produces(MediaType.APPLICATION_JSON)
public List<Tournois> getMesInscription(@PathParam("id") int id) {
    return tournoisEJB.getMesInscription(id);
}
@POST
@Path("/inscription/{id_joueur}/{id_tournois}")
@Produces(MediaType.APPLICATION_JSON)
public Response createInscription(@PathParam("id_joueur") Integer id_joueur,@PathParam("id_tournois") Integer id_tournois){
    
    return tournoisEJB.createInscription(id_joueur,id_tournois);
    
}
@POST
@Path("/joueur/{speudo}/{anectode}/{nom}/{prenom}/{adresse}/{cp}/{mdp}/{email}")
@Produces(MediaType.APPLICATION_JSON)
public Response createJoueur(@PathParam("speudo") String speudo,@PathParam("anectode") String anectode,@PathParam("nom") String nom,@PathParam("prenom") String prenom,@PathParam("adresse") String adresse,@PathParam("cp") String cp,@PathParam("mdp") String mdp,@PathParam("email") String email){
    String anect=null;
    if(!anectode.equals("null")){
        anect=anectode;
    }
    return tournoisEJB.createJoueur(speudo, anect, nom, prenom, adresse, cp, mdp, email);
}
@POST
@Path("/tournois/{nom}/{periode}/{annee}/{mois}/{jour}/{regle}/{prix}/{privee}/{lieu}/{id_style}/{id_joueur}/{id_type}")
@Produces(MediaType.APPLICATION_JSON)
public Response createTournois(@PathParam("nom") String nom,@PathParam("periode") Integer periode,@PathParam("annee") Integer annee,@PathParam("mois") Integer mois,@PathParam("jour") Integer jour, @PathParam("regle") String regle,@PathParam("prix") String prix,@PathParam("privee") Integer privee,@PathParam("lieu") String lieu,@PathParam("id_style") Integer id_style,@PathParam("id_joueur") Integer id_joueur,@PathParam("id_type") Integer id_type){
    return tournoisEJB.createTournois(nom, periode, LocalDate.of(annee,mois,jour), regle, prix, privee, lieu, id_style, id_joueur, id_type);
}

@GET
@Path("/Style")
@Produces(MediaType.APPLICATION_JSON)
public List<StyleElimination> getStyle(){
    return tournoisEJB.getStyle();
}
@GET
@Path("/Type")
@Produces(MediaType.APPLICATION_JSON)
public List<Type> getType(){
    return tournoisEJB.getType();
}
@GET
@Path("/mesMatchs/{id_joueur}")
@Produces(MediaType.APPLICATION_JSON)
public List<Matchs> getMesMatchs(@PathParam("id_joueur") Integer id_joueur){
    return tournoisEJB.getMesMatch(id_joueur);
}
/*
@GET
@Path("/attaques/{id}")
@Produces(MediaType.APPLICATION_JSON)
public List<Attaque> getAttaquesById(@PathParam("id") int id) {
    return pokemonEJB.getAttaquesById(id);
}
@GET
@Path("/{id}/info")
@Produces(MediaType.APPLICATION_JSON)
public List<Pokemon> getPokemonByInfo(@PathParam("id") int id){
    return pokemonEJB.getPokemonInfo(id);
}
/*@GET
@Path("/{id}/info2")
@Produces(MediaType.APPLICATION_JSON)
public List<InfoPokemon> getPokemonByInfo2(){
    return pokemonEJB.getPokemonInfo2();
}
@GET
@Path("dresseur/{id}/info")
@Produces(MediaType.APPLICATION_JSON)
public List<Dresseur> getDresseurByInfo(@PathParam("id") int id){
    return pokemonEJB.getDresseurInfo(id);
}
@GET
@Path("dresseur/ajout/{nom}/{id}")
@Produces(MediaType.APPLICATION_JSON)
public void ajoutDresseur(@PathParam("nom") String nom,@PathParam("id") Integer id){
    pokemonEJB.ajouterDresseur(nom, id);
}
@GET
@Path("dresseur/ajout/{idPoke}/{iddreseur}/{niveau}/{ordre}")
@Produces(MediaType.APPLICATION_JSON)
public void ajoutPokeADresseur(@PathParam("idPoke") Integer idPoke,@PathParam("iddresseur") Integer idDresseur,@PathParam("niveau") Integer niveau,@PathParam("ordre") Integer ordre){
    pokemonEJB.ajouterPokeADresseur(idPoke, idDresseur,niveau,ordre);
}*/
}
