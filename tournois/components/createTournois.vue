<template>
    <Toast/>
    <div style="display: flex;justify-content: center;text-align: center;" >
        <Card  style="margin-top: 30vh;">
            <template #title>
                <h1>Création de tournois</h1>
            </template>
            <template #content>
                <Form>
                    <div>
                        <FloatLabel variant="on" v-for="column in columns" style="margin-top: 5px;" >
                            <InputText :id="column.id" v-model="column.value" v-if="column.type=='text'" :placeholder="column.name"/>
                            <InputNumber :id="column.id" v-model="column.value" v-if="column.type=='number'"/>
                            <label :for="column.id" v-if="column.type!='select'">{{column.nom}}</label>
                            <Select v-model="column.value" :options="column.data" :optionLabel="column.name" :placeholder="column.nom" v-if="column.type=='select'"/>
                        </FloatLabel>
                    </div>
                    <div style="display: flex;justify-content: end;margin: 10px;">
                        <Button label="Crée" @click="cree(columns)"/>
                    </div>
                    <Button @click="console.log(style)">test</Button>

                </Form>
            </template> 
        </Card>
    </div>
</template>
<script setup>

import Select from 'primevue/select';
import { useUserStore } from '@/stores/user'
    const userStore = useUserStore()
    const router=useRouter()
    const {data:style }= await useFetch(`http://localhost:8080/webresources/tournois/Style`)
    const {data:type }= await useFetch(`http://localhost:8080/webresources/tournois/Type`)


    const columns=ref([
        {
          id:"nom",
          nom:"Nom du tournois"  ,
          value:"",
          type:'text'
        },
        {
          id:"periode",
          nom:"durre du tournois par jour "  ,
          value:0,
          type:'number'
        },
        {
          id:"date_debut",
          nom:"date de commencement"  ,
          value:"",
          type:'text'
        },
        {
          id:"regle",
          nom:"Regle tu tournois" ,
          value:"",
          type:'text'
        },
        {
          id:"prix",
          nom:"prix a remporter"  ,
          value:0,
          type:'text'
        },
        {
            id:"privee",
            nom:"le tournois est il professionel"  ,
            value:null,
            type:'select',
            name:"name",
            data:ref([
                {
                    name:"NON",
                    value:0
                },
                {
                    name:"OUI",
                    value:1
                }
            ])
        },
        {
          id:"lieu",
          nom:"lieu oû se deroule le tournois"  ,
          value:"",
          type:'text'
        },
        {
          id:"id_style",
          nom:"style d'elimination"  ,
          value:null,
          type:'select',
          name:"libelle_style",
          data:ref(style)
        },
        {
          id:"id_type",
          nom:"sujet du tournois(ex lol,football,etc)"  ,
          value:null,
          type:'select',
          name:"libelle",
          data:ref(type)
        },
    ])
    const cree=async(columns)=>{
        let donne={}
        // donne ressoit id comme nom et value comme valeur
        columns.forEach(column => {
            donne[column.id]=column.value
        });
        const date=donne.date_debut.split("-")
        console.log(date)
        const url =`http://localhost:8080/webresources/tournois/tournois/${donne.nom}/${donne.periode}/${date[0]}/${date[1]}/${date[2]}/${donne.regle}/${donne.prix}/${donne.privee.value}/${donne.lieu}/${donne.id_style.id_type}/${userStore.id}/${donne.id_type.id_type}`
        console.log(url)
        const {data}=await useFetch(url,{
            method:"POST"
        })
        router.push('/')
    }
</script>