<template>
    <Card style="min-width: calc(100%/4) !important;margin:2px;height: 100%;">
        <template #title>
            {{ nom }}
        </template>
        <template #subtitle>
           {{ type }}
        </template>
        <template #content>
            <slot name="content"/>
        </template>
        <template #footer>
            <div style="display: flex;justify-content: space-between;">
                <Button label="Détail" @click="detail=true" severity="info"/>
                <Button label="S'inscrire" @click="confirmation=true" v-if="existeInscrire" style="margin-left: 3px;" severity="secondary"/>
            </div>
        </template>
    </Card>
    <Dialog v-model:visible="confirmation">
        <template #header>
            Confirmation d'inscription
        </template>
            êtes-vous sur de vous inscrire?
        <template #footer>
            <Button severity="danger" label="Cancel" @click="confirmation=false" />
            <Button severity="sucess" label="S'inscrire" @click="inscrire(id)" style="margin-left: 3px;"/>

        </template>
        
    </Dialog>
    <Dialog v-model:visible="detail" >
        <template #header>
            {{ nom }}
        </template>
        <Card>
            <template #subtitle>
            {{ type }}
            </template>
            <template #content>
                <slot name="content"/>
                <slot name="detail"/>
            </template>
        </Card>
    </Dialog>
    
</template>
<script setup>
const userStore = useUserStore()
const confirmation=ref(false)
const detail=ref(false)
const props = defineProps({
    nom:{
        type:String,
        required:true
    },
    type:{
        type:String,
        required:true
    },
    existeInscrire:{
        type:Boolean,
        default:true
    },
    id:{
        type:Number,
    },
    inscription:{
        type:Function,
    }
})


const inscrire=async(id_tournois)=>{
    // const post={
    //     joueur:{id_joueur:userStore.id},
    //     id:{
    //         id_tournois:id_tournois
    //     },
    //     tournois:{
    //         id_tournois:id_tournois
    //     }
    // }
    
    const {data ,pending}= await useFetch(`http://localhost:8080/webresources/tournois/inscription/${userStore.id}/${id_tournois}`,{
        method:"POST"
    }
    )
}
</script>