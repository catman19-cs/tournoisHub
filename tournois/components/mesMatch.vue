<template>
    <CustomTable titre="mesMatch" :data="matchs" :columns="columns"/>
</template>

<script setup>
    const userStore=useUserStore()
    const{data:matchs}=await useFetch(`http://localhost:8080/webresources/tournois/mesMatchs/${userStore.id}`)
    const columns=ref([
        {
            nom:"tournois",
            field:"tournois.nom"
        },
        {
            nom:"date",
            field:"date_match"
        },
        {
            nom:"Lieu",
            field:"lieu_match"
        },
        {
            nom:"Résultat",
            field:"resultat_match"
        },
    ])
</script>