<template>
    <div class="box" style="margin-bottom: 20px;">
        <div class="row-container">
            <div class="col-container">
                <h5>나를 팔로우하는 회원</h5>
                <h6 v-for="user in store.followerList" :key="user.id">
                    {{ user.nickname }} 💛</h6>
            </div>
            <div class="col-container">
                <h5>내가 팔로우하는 회원</h5>
                <h6 v-for="user in store.followingList" :key="user.id">
                    {{ user.nickname }}
                    <button @click="$emit('unfollow', user.id)" type="button" class="btn btn-danger">언팔로우</button>
                </h6>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useMypageStore } from '@/stores/mypage.js';
import { useUserStore } from '@/stores/user.js';

const store = useMypageStore();
const userStore = useUserStore();

// const unfollow = function(id) {
//     userStore.unfollow(sessionStorage.getItem('loginUser'), id);
//     router.push({name: 'MyPage'});
// }

</script>

<style scoped>
.box {
    box-shadow: 0px 0px 3px rgb(180, 180, 180);
    border-radius: 20px;
}
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
    margin-bottom: 30px;
}

h6 {
    width: 80%;
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 5px;
}

.btn {
    font-size: 12px;
    padding: 2px;
}

</style>