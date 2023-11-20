<template>
    <div style="margin-bottom: 20px;">
        <hr>
        <div class="row-container">
            <div class="col-container">
                <h5>나를 팔로우하는 회원</h5>
                <h6 v-for="user in store.followerList" :key="user.id">
                    {{ user.nickname }} 💛</h6>
            </div>
            <div class="col-container">
                <h5>내가 팔로우하는 회원</h5>
                <h6 v-for="user in store.followingList" :key="user.id">
                    {{ user.nickname }} ❤️</h6>
            </div>
        </div>
        <hr>
    </div>
</template>

<script setup>
import { useMypageStore } from '@/stores/mypage.js';

const store = useMypageStore();

</script>

<style scoped>
.row-container {
    display: flex;
    margin: 30px 0;
}

.col-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 0 40px;
}

h5 {
    margin-bottom: 20px;
}

</style>