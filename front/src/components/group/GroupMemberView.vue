<template>
    <div>
        <h3>우리 모임 멤버를 <span>팔로우</span>해보세요.</h3>
        <MemberListView/>
    </div>
</template>

<script setup>
import MemberListView from './member/MemberListView.vue';


</script>

<style scoped>
h3 {
    margin-bottom: 80px;
}

span {
    font-weight: 700;
    color: #007bff
}
</style>