<template>
    <customForm titre="S'inscrire" :columns="columns">
        
    </customForm>
</template>
<script setup>
    const columns=ref([
        {
            id:"nom",
            nom:"Nom",
            value:""
        },
        {
            id:"prenom",
            nom:"Prenom",
            value:""
        },{
            id:"adresse",
            nom:"Adresse",
            value:""
        },{
            id:"email",
            nom:"Email",
            value:""
        },{
            id:"cp",
            nom:"Code Postal",
            value:""
        },{
            id:"pseudo",
            nom:"Pseudo",
            value:""
        },{
            id:"mdp",
            nom:"Mot de passe",
            value:""
        },{
            id:"anectode",
            nom:"Anectode(non obligatoire)",
            value:"",
            obliger:false
        }
    ])
//     const login=async(columns)=>{
//         const verifie=ref(true)
//         const donne=ref({})
//         columns.forEach(column => {
//             if(column.value==null&&column.obliger!=false){
//                 verifie.value=false
//             }
//         });
//         if(columns[6].value==columns.value[7]){
//             verifie.value=false
//         }
//         if(verifie.value){
//             strHash(columns[6].value).then(function(hash) {
                
//             mdpHash = hash
//             }).then(function(){
//                 columns.forEach(column => {
//                     donne.value[column.id]=column.value
//                 });
//                 const url =`http://localhost:8080/webresources/tournois/joueur/${speudo}/${anectode}/${nom}/${prenom}/${adresse}/${cp}/${mdp}/${email}`
//                 const {data}= useFetch(url)
                
//             })
//         }
// }
    // const login=async()=>{
    //     strHash(mdp.value).then(function(hash) {
            
    //         mdpHash = hash
    //     }).then(function(){
    //         const url =`http://localhost:8080/webresources/tournois/joueur/${email.value}/${mdpHash}`
    //         const {data}= useFetch(url)
            
    //         if(data.value[0]===undefined){
    //             toast.add({ severity: 'error', summary: 'Erreur de connexion', detail: 'votre email ou mot de passe est incorrecte', life: 3000 });
    //         }else{
    //             const router = useRouter()
    //             userStore.setUser(data.value)
    //             router.push('/')
    //         }
    //     })
    // }
// async function strHash(a, b) {
//   b = b || 'SHA-256';
//   var c = new TextEncoder().encode(a),
//       d = await crypto.subtle.digest(b, c),
//       e = Array.from(new Uint8Array(d)),
//       f = e.map(function(c) {
//         return c.toString(16).padStart(2, '0');
//       }).join('');
//   return f;
// }
</script>