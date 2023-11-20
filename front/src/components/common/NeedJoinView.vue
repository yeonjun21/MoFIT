<template>
    <div class="container">
        <h3>모임 멤버만 이용 가능한 기능입니다.</h3>
        <h1>😥</h1>
        <button type="button" class="btn btn-outline-primary btn-lg"
            @click="goGroupHome">모임 홈으로 가기</button>
    </div>
</template>

<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();

const goGroupHome = function() {
    router.push({name: 'GroupHome'});
}

</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-top: 100px;
}

.btn {
    margin-top: 30px;
}

h1 {
    font-size: 120px;
    margin: 10px;
}
</style>