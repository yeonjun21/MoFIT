<template>
    <div v-if="!isMember">
        <NeedJoinView/>
    </div>
    <div v-else>
        <h3>모임 운영진만 작성 가능한 <span>공지사항</span>입니다.</h3>
        <RouterView/>
    </div>
</template>

<script setup>
import NeedJoinView from '../common/NeedJoinView.vue';

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