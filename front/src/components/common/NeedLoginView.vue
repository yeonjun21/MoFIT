<template>
    <div class="container">
        <h3>로그인이 필요한 기능입니다.</h3>
        <h1>😥</h1>
        <button type="button" class="btn btn-outline-primary btn-lg"
            @click="goLoginForm">로그인하러 가기</button>
    </div>
</template>

<script setup>
import { useRouter } from 'vue-router';

const router = useRouter();

const goLoginForm = function() {
    router.push({name: 'LoginForm'});
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