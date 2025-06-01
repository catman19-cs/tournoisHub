export const tournoisStore = defineStore('tournoisStore', {
    state: () => ({
        nom: '',
        periode: 0,
        date_debut:"",
        regle:"",
        prix:0,
        privée:null,
        lieu:""
      }),
      action:{
        async getTournois(){
            const infos = await useFetch('')
        }
      }
})