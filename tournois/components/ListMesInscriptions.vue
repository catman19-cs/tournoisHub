<template>
    <CustomTable titre="Toutes mes inscription" :data="data" :columns="columns"/>
    <Button @click="console.log(`http://localhost:8080/webresources/tournois/inscription/${userStore.id}`)">test</Button>
</template>

<script setup>
import { useUserStore } from '@/stores/user';


const userStore=ref(useUserStore())
    const {data }= await useFetch(`http://localhost:8080/webresources/tournois/inscription/${userStore.id}`)
    const columns=ref([
        {
            nom:"nom",
            field:"nom"
        },
        {
            nom:"type",
            field:"type.libelle"
        },
        {
            nom:"nom équipe",
            field:"nom_equipe"
        },
        {
            nom:"date debut",
            field:"date_debut"
        },
        {
            nom:"professionelle",
            field:"privee"
        },
        
    ])
</script>