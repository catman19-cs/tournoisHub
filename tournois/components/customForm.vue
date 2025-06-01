<template>
    <Toast/>
    <div style="display: flex;justify-content: center;text-align: center;" >
        <Card class="flex flex-col gap-1 min-h-screen flex items-center justify-center" style="margin-top: 30vh;">
            <template #title>
                <h1>{{ titre }}</h1>
            </template>
            <template #content>
                <Form>
                    <div>
                        <FloatLabel variant="on" v-for="column in columns" style="margin-top: 5px;">
                            <InputText :id="column.id" v-model="column.value" />
                            <label :for="column.id">{{column.nom}}</label>
                        </FloatLabel>
                    </div>
                    <div style="display: flex;justify-content: end;margin: 10px;">
                        <Button label="S'inscrire" @click="inscrire(columns)"/>
                    </div>
                </Form>
            </template> 
        </Card>
    </div>
</template>

<script setup>
import { useToast } from "primevue/usetoast";
import { useUserStore } from '@/stores/user'
    const userStore = useUserStore()
    const toast = useToast();
    defineProps({
        columns:{
            type:Array,
            required:true
        },
        titre:{
            type:String,
            required:true
        }
    })
    const inscrire=async(columns)=>{
        const verifie=ref(true)
        let donne={}
        let mdpHash=""
        
        
        if(verifie.value){
            strHash(columns[6].value).then(function(hash) {
                
            mdpHash = hash
            }).then(function(){
                columns.forEach(column => {
                    donne[column.id]=column.value
                });
                donne.mdp=mdpHash
                if(donne.anectode===""){
                    donne.anectode="null"
                }
                console.log(donne)
                const url =`http://localhost:8080/webresources/tournois/joueur/${donne.pseudo}/${donne.anectode}/${donne.nom}/${donne.prenom}/${donne.adresse}/${donne.cp}/${donne.mdp}/${donne.email}`
                console.log(url)
                const {data}= useFetch(url,{method:"POST"})
                
                userStore.setUser(data.value.id_joueur)
                
                const router = useRouter()
                router.push('/')
            })
        }
}
async function strHash(a, b) {
  b = b || 'SHA-256';
  var c = new TextEncoder().encode(a),
      d = await crypto.subtle.digest(b, c),
      e = Array.from(new Uint8Array(d)),
      f = e.map(function(c) {
        return c.toString(16).padStart(2, '0');
      }).join('');
  return f;
}
</script>