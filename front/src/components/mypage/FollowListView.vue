<template>
    <div class="row-container">
        <div class="box" style="margin-bottom: 20px;">
            <p class="info">✔ 내가 팔로우하는 회원을 클릭하면 그 회원이 찜한 영상을 볼 수 있습니다.</p>
            <div class="row-container">
                <div class="col-container">
                    <h5>나를 팔로우하는 회원</h5>
                    <div class="list">
                        <div v-for="user in store.followerList" :key="user.id" class="item">
                            <p class="user-nickname">{{ user.nickname }}</p>
                            <button @click="$emit('deleteFollower', user.id)" type="button" 
                                class="btn btn-outline-warning">삭제</button>
                        </div>
                    </div>
                </div>
                <div class="col-container">
                    <h5>내가 팔로우하는 회원</h5>
                    <div class="list">
                        <div v-for="user in store.followingList" :key="user.id" class="item">
                            <p class="user-nickname" @click="followBookmark(user.id, user.nickname)">{{ user.nickname }}</p>
                            <button @click="$emit('unfollow', user.id)" type="button" 
                                class="btn btn-outline-danger">언팔</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div v-if="showFollowBookmark" class="follow-video-box">
            <button class="follow-video-button btn btn-primary"
                @click="showFollowBookmark = false">닫기</button>
            <FollowBookmarkView :nickname="following" class="video"/>
        </div>
    </div>
</template>

<script setup>
import { useMypageStore } from '@/stores/mypage.js';
import { ref } from 'vue';
import FollowBookmarkView from './FollowBookmarkView.vue';

const store = useMypageStore();

const showFollowBookmark = ref(false);
const following = ref('');

const followBookmark = function(userId, nickname) {
    store.getFollowBookmark(userId);
    showFollowBookmark.value = true;
    following.value = nickname;
}

</script>

<style scoped>
.box {
    box-shadow: 0px 0px 3px rgb(180, 180, 180);
    border-radius: 20px;
    padding: 10px;
}

.info {
    text-align: center;
    margin-top: 20px;
    font-size: 13px;
}
.row-container {
    display: flex;
    margin: 50px 0;
}

.col-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 0 40px;
}

.list {
    display: flex;
    flex-wrap: wrap;
    width: 160px;
    justify-content: space-between;
}

.item {
    display: flex;
    align-items: center;
    margin-bottom: 6px;
}

h5 {
    margin-bottom: 30px;
}

h6 {
    margin-bottom: 0;
}

.user-nickname {
    margin-bottom: 0;
    font-size: 15px;
}

.btn {
    font-size: 12px;
    padding: 2px;
    margin-left: 7px;
}

.follow-video-box {
    position: relative;
    margin: 30px;
}

.follow-video-button {
    position: absolute;
}

</style>