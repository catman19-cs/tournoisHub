<template>

</template>
<script setup>
import { useUserStore } from '@/stores/user'

const router = useRouter()
const userStore = useUserStore()
userStore.logout()
router.push('/login')
</script>