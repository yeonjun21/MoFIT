<template>
    <div class="group-container">
        <h6>{{ group.groupName }}</h6>
        <span class="badge rounded-pill text-bg-primary">{{ group.type }}</span>
    </div>
</template>

<script setup>
defineProps({
    group: Object
})
</script>

<style scoped>
.group-container {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    flex-wrap: nowrap;
}

h6 {
    margin-bottom: 1px;
}
</style>