<template>
    <div>
        <div class="row-container">
            <div class="col-container">
                <p>팔로워</p>
                <h5>{{ store.followerList.length }}</h5>
            </div>
            <div class="col-container">
                <p>팔로잉</p>
                <h5>{{ store.followingList.length }}</h5>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useMypageStore } from '@/stores/mypage.js';
import { ref, onMounted } from 'vue';

const store = useMypageStore();



onMounted(() => {
    store.getFollowingList(sessionStorage.getItem('loginUser'));
    store.getFollowerList(sessionStorage.getItem('loginUser'));
})

</script>

<style scoped>

p {
    margin-bottom: 7px;
}
.row-container {
    display: flex;
}

.col-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-right: 20px;
    box-shadow: 0px 0px 3px skyblue;
    border-radius: 20px;
    padding: 10px 20px;
}
</style>