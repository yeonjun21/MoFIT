<template>
    <div>
        <NeedLoginView v-if="!userStore.loginUser"/>
        <div v-else class="container">
        <h2>
            💙 <span>{{ mypageStore.user.nickname }}</span>님의
            마이페이지 💙
        </h2>
        <div class="row-container center">
            <img src="https://i.pinimg.com/originals/36/31/cc/3631ccead0d5c40b256c2d743c638ba1.png">
            <div class="col-container">
                <UserInfoView :user="mypageStore.user" class="content"/>
                <FollowView @click="followList = !followList"/>
            </div>
        </div>
        <FollowListView v-if="followList" @unfollow="unfollow"/>
        <div class="col-container">
            <h3>내가 가입한 모임</h3>
            <div class="my-group-list" @click="goMyGroupList">
                <MyGroupView v-for="group in groupStore.myGroupList" :key="group.groupId"
                    :group="group" class="my-group"/>
            </div>
        </div>
        <div class="row-container">
            <div class="col-container">
                <h3>내가 쓴 글</h3>
                <MyBoardView class="sub-container"/>
            </div>
            <div class="col-container">
                <h3>찜한 영상</h3>
                <BookmarkView class="sub-container"/>
            </div>
        </div>
    </div>
    </div>
</template>

<script setup>
import { useMypageStore } from '@/stores/mypage.js';
import { useUserStore } from '@/stores/user.js';
import { useGroupStore } from '@/stores/group.js'
import { onMounted, ref } from 'vue';
import { useRouter } from 'vue-router';
import UserInfoView from '@/components/mypage/UserInfoView.vue'
import NeedLoginView from '../components/common/NeedLoginView.vue';
import BookmarkView from '../components/mypage/BookmarkView.vue';
import MyGroupView from '../components/mypage/MyGroupView.vue';
import MyBoardView from '../components/mypage/MyBoardView.vue';
import FollowView from '../components/mypage/FollowView.vue';
import FollowListView from '../components/mypage/FollowListView.vue';

const mypageStore = useMypageStore();
const userStore = useUserStore();
const groupStore = useGroupStore();
const router = useRouter();

const followList = ref(false);

const goMyGroupList = function() {
    router.push({name: 'MyGroup'});
}

const unfollow = function(id) {
    userStore.unfollow(sessionStorage.getItem('loginUser'), id);
    // 강제로 새로고침!
    window.location.reload();
}

onMounted(() => {
    mypageStore.getUser(sessionStorage.getItem('loginUser'));
    groupStore.clearGroupList();
    groupStore.getMyGroupList(sessionStorage.getItem('loginUser'));
})
</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 30px;
}

h3 {
    margin-bottom: 30px;
}

span {
    color: #007bff;
    font-weight: 700;
}

img {
    width: 300px;
    border-radius: 30px;
}

.sub-container {
    width: 400px;
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
}

.row-container {
    display: flex;
}

.col-container {
    margin: 50px 10px;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.center {
    align-items: center;
}

.content {
    margin: 20px;
}

.my-group-list {
    display: flex;
    flex-wrap: wrap;
    width: 600px;
}

.my-group {
    /* border: 1px solid rgb(180, 180, 180); */
    box-shadow: 0px 0px 3px rgb(170, 170, 170);
    border-radius: 10px;
    width: 46%;
    padding: 10px;
    margin: 10px;
}

</style>