<template>
    <div class="container">
        <div>
            <h6>{{ member.nickname }} 
                <span v-if="member.grade == '운영진'">👑</span>
            </h6>
        </div>
        <button @click="follow" type="button" class="btn btn-primary">팔로우</button>
    </div>
</template>

<script setup>
import { useUserStore } from '@/stores/user.js';

const props = defineProps({
    member: Object
})

const store = useUserStore();

const follow = function() {
    const result = confirm('해당 멤버를 팔로우하시겠어요?');

    if (result) {
        store.follow(sessionStorage.getItem('loginUser'), props.member.userId);
    }
}

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