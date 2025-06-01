<template>
  <div>
    <div class="card" style="margin: 10px 20px;">
        <Menubar :model="items" >
          <template #end>
            <Button label="Déconnexion" @click="()=>router.push( '/logout')"/>
          </template>
        </Menubar>
    </div>
    <slot/>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router';
import { ref,computed } from "vue";
import Menubar from 'primevue/menubar';
import { useUserStore } from '@/stores/user';

const userStore = ref(useUserStore())
const router = useRouter();

if(userStore.id===null){
    router.push('/login')
} 


const items=[
  {
      label: 'Accueil',
      icon: 'pi pi-home',
      command: () => router.push('/') 
  },
  {
    label:'Mes Tournois',
    icon:'pi pi-sign-in',
    command:()=>router.push('/tournois'),
    
  },
  {
      label: 'Mes Inscription',
      icon: 'pi pi-star',
      command: () => router.push('/inscription') ,
      
  },
  {
      label: 'Mes Matchs',
      icon: 'pi pi-star',
      command: () => router.push('/match') ,
      
  },
  
]



</script>