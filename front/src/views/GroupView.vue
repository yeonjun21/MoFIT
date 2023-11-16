<template>
    <div class="container">
        <h2>{{ store.group.groupName }}</h2>
        <GroupMenuNav/>
        <RouterView/>
    </div>
</template>

<script setup>
import { onMounted } from 'vue';
import { useGroupStore } from '@/stores/group.js';
import { useRoute } from 'vue-router';
import GroupMenuNav from '@/components/common/GroupMenuNav.vue'

const store = useGroupStore();
const route = useRoute();


onMounted(() => {
    store.getGroup(route.params.groupId);
})


</script>

<style scoped>
.container {
    width: 1000px;
}
h2 {
    font-size: 40px;
    font-weight: 700;
    margin: 50px;
}
</style>