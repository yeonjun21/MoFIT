<template>
    <div v-if="!isMember">
        <NeedJoinView/>
    </div>
    <div v-else>
        <h3>모핏의 <span>{{ store.group.type }}</span> 추천 영상입니다.</h3>
        <RouterView/>
    </div>
</template>

<script setup>
import { useGroupStore } from '@/stores/group.js';
import { onMounted } from 'vue';
import { useRoute } from 'vue-router';
import VideoDetailView from './video/VideoDetailView.vue';
import NeedJoinView from '@/components/common/NeedJoinView.vue';

defineProps({
    isMember: Boolean
})

const store = useGroupStore();
const route = useRoute();

onMounted(() => {
    store.group = store.getGroup(route.params.groupId);
})

</script>

<style scoped>
h3 {
    margin-bottom: 50px;
}

span {
    font-weight: 700;
    color: #007bff
}
</style>