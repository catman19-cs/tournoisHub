<template style="height:100vh;">
    
    <div style="display: flex;flex-flow: row wrap;width: 100%;justify-content: center;"  >
        
        <CustomCard v-for= "tournoi in tournois"
         :nom="tournoi.nom" 
         :type="tournoi.type.libelle" 
         class="flex flex-col gap-1" 
         style="display: flex;justify-content: center;" 
         :id="tournoi.id_tournois"
         :inscription="inscrire()"
        >
            <template #content>
                catégorie: {{ tournoi.type.categorie.libelle_categorie }} <br> 
                date :{{ tournoi.date_debut.replace(/T.*/,'') }} <br>
                periode:{{ tournoi.periode }} <br>
                prix :{{ tournoi.prix }} <br>
                lieu : {{ tournoi.lieu }} <br>
                
            </template>
            <template #detail>
                regle: {{ tournoi.regle }} <br>
                professionel: {{ tournoi.privee?"Oui":"Non" }} <br>
                organisateur: {{ tournoi.joueur.prenom }} {{ tournoi.joueur.nom }} 
            </template>
        </CustomCard>
   
    </div>
</template>

<script setup>

import { ref } from "vue";

const {data:tournois ,pending}= await useFetch('http://localhost:8080/webresources/tournois/tournois')


const inscrire=async(id_joueur,id_tournois)=>{
    const post=ref({
        joueur:{id_joueur:id_joueur},
        id:{
            id_tournois:id_tournois
        },
        tournois:{
            id_tournois:id_tournois
        }
    })
    const {data ,pending}= await useFetch('http://localhost:8080/webresources/tournois/inscription/',{
        method:'post',
        body:post,
        headers: {
            'Content-Type': 'application/json'
        }
    })
}
</script>

<style scope>
    .page {
  page-break-after: always; 
  break-after: page;
  break-inside: avoid; 
  box-sizing: border-box;
}
</style>