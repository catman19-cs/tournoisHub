<template>
    <CustomForm titre="S'incrire" :columns="columns"/>
</template>

<script setup>
import { ref } from "vue";
const columns=ref([
    {
        nom:"coucou",
        id:"coucou",
        value:""
    },
])
</script>