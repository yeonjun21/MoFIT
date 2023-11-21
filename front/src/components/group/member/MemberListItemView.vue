<template>
    <div class="container">
        <div>
            <h6>{{ member.nickname }} 
                <span v-if="member.grade == '운영진'">👑</span>
            </h6>
        </div>
        <button v-if="isFollow" 
            type="button" class="btn" style="color: gray">이미 팔로우하는 회원</button>    
        <button v-else-if="userId != member.userId" @click="follow" 
            type="button" class="btn btn-primary">팔로우</button>
        <button v-else type="button" class="btn btn-light">나 ^-^</button>
    </div>
</template>

<script setup>
import { useUserStore } from '@/stores/user.js';
import { ref, onMounted } from 'vue';
import axios from 'axios';

const props = defineProps({
    member: Object
})

const store = useUserStore();

const userId = ref(sessionStorage.getItem('loginUser'));
const isFollow = ref(false);

const follow = function() {
    const result = confirm('해당 멤버를 팔로우하시겠어요?');

    if (result) {
        store.follow(sessionStorage.getItem('loginUser'), props.member.userId);
        window.location.reload();
    }
}

const followCheck = function(id, other) {
    axios({
        url: 'http://localhost:8080/user/follow-check',
        method: 'GET',
        params: {
            id: id,
            other: other
        }
    })
        .then((res) => {
            isFollow.value = res.data;
        })
        .catch(() => {
            console.log('followCheck 에러');
        })
}

onMounted(() => {
    followCheck(userId.value, props.member.userId);
})

</script>

<style scoped>
.container {
    display: flex;
    width: 300px;
    justify-content: space-between;
    align-items: center;
    border-radius: 30px;
    box-shadow: 0px 0px 2px rgb(180, 180, 180);
    padding: 10px 20px;
}

h6 {
    margin: 8px 0 0;
}

</style>