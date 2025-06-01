// stores/user.js
import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', {
  state: () => ({
    id: null,
    
  }),
  actions: {
    setUser(id) {
      this.id = id
      
    },
    logout() {
      this.id = null
      
    },
  },
  persist: true,  
})
