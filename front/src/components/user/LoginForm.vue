<template>
    <div class="container">
        <p class="fs-4 fw-bold text-center">💙 로그인하기 💙</p>
        <div class="form">
            <div class="mb-3">
                <label for="email" class="form-label">이메일</label>
                <input type="email" class="form-control" id="email"
                    v-model="email">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="password"
                    v-model="password">
            </div>
            <p v-if="loginError" class="login-error">이메일 또는 비밀번호가 정확하지 않습니다.</p>
        </div>
        <button @click="login" class="btn btn-primary">로그인</button>
    </div>
</template>

<script setup>
import { useUserStore } from '@/stores/user';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const store = useUserStore();
const router = useRouter();

const email = ref('');
const password = ref('');
const loginError = ref(false);

const login = function() {
    const user = {
        email: email.value,
        password: password.value
    }

    store.login(user)
        .then(() => {
            router.push({name: 'Main'});
        })
        .catch(() => {
            loginError.value = true;
        })
}

</script>

<style scoped>
.container {
    width: 400px;
}

.form {
    margin: 50px 0;
}

.login-error {
    color: red;
}

.btn {
    width: 100%;
}
</style>