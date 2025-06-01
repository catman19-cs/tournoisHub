<template>
    <Card>
        <template #title>
            <h1>{{ titre }}</h1>
        </template>
        <template #content>
            <DataTable :value="data">
                <div v-for="column in columns">
                    <Column :field="column.field" :header="column.nom"/>
                </div>
            </DataTable>
        </template>
    </Card>

</template>

<script setup>
    defineProps({
        titre:{
            type:String,
            required:true
        },
        data:{
            type:Array,
            required:true
        },
        columns:{
            type:Array
        }
    })
</script>
