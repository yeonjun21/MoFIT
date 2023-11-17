<template>
    <div class="container">
        <div v-if="!store.loginUser">
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <RouterLink :to="{ name: 'LoginForm' }" class="nav-link"  aria-current="page">로그인</RouterLink>
                </li>
                <li class="nav-item">
                    <RouterLink :to="{ name: 'SignupForm' }" class="nav-link" aria-current="page">회원가입</RouterLink>
                </li>
            </ul>
        </div>
        <div v-else>
            <ul class="nav justify-content-end">
                <li class="nav-item">
                    <RouterLink :to="{ name: 'MyPage', params: {id: store.loginUser}}" class="nav-link" aria-current="page">마이페이지</RouterLink>
                </li>
                <li class="nav-item">
                    <a href="#" @click="logout" class="nav-link" aria-current="page">로그아웃</a>
                </li>
            </ul>
        </div>
        
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { useUserStore } from '@/stores/user';
import { useRouter } from 'vue-router';

const store = useUserStore();
const router = useRouter();

const logout = function() {
    store.logout();
}


</script>

<style scoped>
.container {
    margin-top: 10px;
}

.nav-link {
    color: black;
}

a.router-link-exact-active {
    color: #007bff;
}
</style>