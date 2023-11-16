<template>
    <div>
        <MenuNav/>
        <RouterView/>
    </div>
</template>

<script setup>
import MenuNav from '../components/common/MenuNav.vue';
import { onMounted } from 'vue';
import { useGroupStore } from '@/stores/group.js'

const store = useGroupStore();

onMounted(() => {
    store.groupList = null;
})

</script>

<style lang="scss" scoped>

</style>