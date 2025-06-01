<template>
    <Card>
        <template #title>
            <h1>{{ titre }}</h1>
        </template>
        <template #content>
            <Form>
                <div>
                    <FloatLabel variant="on" v-for="column in columns" >
                        <InputText :id="column.id" v-model="column.value" />
                        <label :for="column.id">{{column.nom}}</label>
                    </FloatLabel>
                </div>
            </Form>
        </template> 
    </Card>
</template>

<script setup>
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
</script>