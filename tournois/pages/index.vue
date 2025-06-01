<template>
    <Acceuil/>
</template>

<script setup lang="ts">
const appConfig = useAppConfig()
const user = useAuth()

const userStore = useUserStore()
const router = useRouter()
if(userStore.id===null){
    router.push('/login')
}
</script>