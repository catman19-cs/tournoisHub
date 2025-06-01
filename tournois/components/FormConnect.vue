<template>
    <Toast/>
    <div style="display: flex;justify-content: center;text-align: center;" >
        <Card class="flex flex-col gap-1 min-h-screen flex items-center justify-center" style="margin-top: 30vh;">
            <template #title>
                Connexion
            </template>
            <template #content>
                <Form>
                    <div class="flex flex-col gap-1" style="display: flex;justify-content: center;">
                        <div style="display: block;">
                        <FloatLabel variant="on" >
                            <InputText id="email" v-model="email" />
                            <label for="email">Email</label>
                        </FloatLabel>
                        <FloatLabel variant="on" style="margin-top: 5px;">
                            <InputText id="mdp" v-model="mdp" />
                            <label for="mdp">Mot De passe</label>
                        </FloatLabel>
                        </div>
                    </div>
                    <div style="display: flex;justify-content: end;margin: 10px;">
                        <Button label="Se Connecter" @click="login"/>
                    </div>
                </Form>
            </template>
        </Card>
    </div>
</template>

<script setup>
    import { useToast } from "primevue/usetoast";
    const toast = useToast();
    const email =ref('')
    const mdp =ref('')
    let mdpHash= ''
    const userStore = useUserStore()
    const login=async()=>{
        strHash(mdp.value).then(function(hash) {
            console.log(hash)
            mdpHash = hash
        }).then(function(){
            const url =`http://localhost:8080/webresources/tournois/joueur/${email.value}/${mdpHash}`
            const {data}= useFetch(url)
            console.log(data.value[0])
            if(data.value[0]===undefined){
                toast.add({ severity: 'error', summary: 'Erreur de connexion', detail: 'votre email ou mot de passe est incorrecte', life: 3000 });
            }else{
                const router = useRouter()
                userStore.setUser(data.value)
                router.push('/')
            }
        })
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