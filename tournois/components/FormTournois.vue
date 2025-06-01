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
                        <Button label="Crée" @click="inscrire(columns)"/>
                    </div>
                    <Button @click="console.log(style)">test</Button>

                </Form>
            </template> 
        </Card>
        </div>
</template>
<script setup>
    defineProps({
        titre:{
            type:String
        },
        columns:{
            type:Array
        }
    })
</script>