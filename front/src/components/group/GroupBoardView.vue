<template>
    <div v-if="!isMember">
        <NeedJoinView/>
    </div>
    <div v-else>
        <h3>모임 멤버 모두가 이용 가능한 <span>자유게시판</span>입니다.</h3>
        <RouterView/>
    </div>
</template>

<script setup>
import NeedJoinView from '@/components/common/NeedJoinView.vue';

defineProps({
    isMember: Boolean
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