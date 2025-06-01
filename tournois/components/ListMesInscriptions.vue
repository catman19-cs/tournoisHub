<template>
    <CustomTable titre="Toutes mes inscription" :data="inscriptions" :columns="columns"/>
    
</template>

<script setup>
import { useUserStore } from '@/stores/user';


const userStore=useUserStore()
    const {data:inscriptions }= await useFetch(`http://localhost:8080/webresources/tournois/inscription/${userStore.id}`)
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
            nom:"date debut",
            field:"date_debut"
        },
        {
            nom:"professionelle",
            field:"privee"
        },
        
    ])
    
</script>