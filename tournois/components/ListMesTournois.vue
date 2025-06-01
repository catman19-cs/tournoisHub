<template>
    <Button label="Création de tournois" @click="router.push('/tournois/createTournois')"></Button>
    <div style="display: flex;flex-flow: row wrap;width: 100%;justify-content: center;"  >

        <CustomCard v-for= "tournoi in tournois" :nom="tournoi.nom" :type="tournoi.libelle" class="flex flex-col gap-1" style="display: flex;justify-content: center;" :existeInscrire="false" >
            <template #content>
                date :{{ tournoi.date_debut.replace(/T.*/,'') }} <br>
                periode:{{ tournoi.periode }} <br>
                prix :{{ tournoi.prix }} <br>
                lieu : {{ tournoi.lieu }} <br>
                <Button @click="router.push('/tournois/match')">Matchs</Button>
            </template>
            <template #detail>
                regle: {{ tournoi.regle }} <br>
                professionel: {{ tournoi.privee?"Oui":"Non" }} <br>
                organisateur: {{ tournoi.joueur.nom }}
            </template>
        </CustomCard>
        
    </div>
</template>

<script setup>
import { ref } from "vue";
import { routerKey } from "vue-router";
const router = useRouter()
const userStore = useUserStore()
const {data:tournois ,pending}= await useFetch(`http://localhost:8080/webresources/tournois/tournois/${userStore.id}`)

</script>

<style scope>
    .page {
  page-break-after: always; /* saut de page */
  break-after: page;
  break-inside: avoid; /* évite que le composant soit coupé */
  width: 100%;
  box-sizing: border-box;
}
</style>