<template>
    <FormConnect/>
</template>
<script setup>
import { ref } from 'vue'
import InputText from 'primevue/inputtext'
import Password from 'primevue/password'
import Button from 'primevue/button'
import Message from 'primevue/message'
import { useUserStore } from '@/stores/user'

definePageMeta({
  layout: false
})

const email=ref('')
const mdp=ref('')
const userStore = useUserStore()

const login=async()=>{
  const url =`http://localhost:8080/webresources/tournois/joueur/${email.value}/${mdp.value}`
  console.log(url)
  const {data}=await useFetch(url)
  console.log(data.value)
  const router = useRouter()
  
    userStore.setUser(data.value.id_joueur[0])
    console.log(userStore.id)
    router.push('/')
  
}
</script>
<!-- <template>
    <div class="login">
        <Toast />

    <Form  @submit.prevent="login" >
        <div class="flex flex-col gap-1">
            <InputText name="pseudo" type="text" placeholder="Pseudo" fluid v-model="pseudo"/>
            <InputText name="mdp" type="text" placeholder="Mot De Passe" fluid v-model="mdp"/>
        </div>
        <Button type="submit" severity="secondary" label="connection" />
    </Form>
      <p v-if="error">{{ error }}</p>
    </div>
  </template>
  
  <script setup>
import { ref } from 'vue'
import InputText from 'primevue/inputtext'
import Password from 'primevue/password'
import Button from 'primevue/button'
import Message from 'primevue/message'
import { useUserStore } from '@/stores/user'

const email = ref('')
const password = ref('')
const error = ref('')
const userStore = useUserStore()

const handleLogin = async () => {
  const res = await $fetch('/api/login', {
    method: 'POST',
    body: { email: email.value, password: password.value }
  })

  if (res.success) {
    userStore.setUser(res.user)
    await navigateTo('/') // Redirige vers l'accueil ou dashboard
  } else {
    error.value = res.message
  }
}
</script> -->