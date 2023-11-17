<template>
    <div>
        <NeedLoginView v-if="!userStore.loginUser"/>
        <div v-else class="container">
        <h2>
            💙 <span>{{ mypageStore.user.nickname }}</span>님의
            마이페이지 💙
        </h2>
        <div class="sub-container">
            <div class="profile-image cotent"></div>
            <UserInfoView :user="mypageStore.user" class="content"/>
        </div>
        <div class="sub-container">
            <h3>내가 가입한 모임</h3>
        </div>
        <div class="sub-container">
            <div class="content">
                <h3>내가 쓴 글</h3>
            </div>
            <div class="content">
                <h3>찜한 영상</h3>
            </div>
        </div>
    </div>
    </div>
</template>

<script setup>
import { useMypageStore } from '@/stores/mypage.js';
import { useUserStore } from '@/stores/user.js';
import { onMounted } from 'vue';
import UserInfoView from '@/components/mypage/UserInfoView.vue'
import NeedLoginView from '../components/common/NeedLoginView.vue';

const mypageStore = useMypageStore();
const userStore = useUserStore();

onMounted(() => {
    mypageStore.getUser(sessionStorage.getItem('loginUser'));
})

</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 30px;
}

h2 {
    margin-bottom: 20px;
}

span {
    color: #007bff;
    font-weight: 700;
}

.profile-image {
    width: 250px;
    height: 250px;
    background-color: rgb(196, 231, 255);
    border-radius: 30px;
}

.sub-container {
    margin: 50px;
    display: flex;
}

.content {
    margin: 20px;
}

</style>