<template>
    <div class="container">
        <p class="fs-4 fw-bold text-center">💙 회원가입하기 💙</p>
        <div class="form">
            <div class="mb-3">
                <label for="email" class="form-label">이메일</label>
                <div class="input-container">
                    <input type="email" class="form-control" id="email" 
                    v-model="email" placeholder="예) mofit@mofit.co.kr">
                    <button @click="emailDuplicationCheck" class="check-button">중복확인</button>
                </div>
                <p v-if="emailError" class="input-error">이메일 형식을 다시 확인해주세요.</p>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="password" 
                    v-model="password" placeholder="영문, 숫자 조합하여 8-20자">
                    <p v-if="passwordError" class="input-error">비밀번호는 영문과 숫자를 조합하여 8자 이상, 20자 이하여야 합니다.</p>
                </div>
            <div class="mb-3">
                <label for="name" class="form-label">이름</label>
                <input type="text" class="form-control" id="name" 
                    v-model="name" placeholder="2자 이상의 한글">
                    <p v-if="nameError" class="input-error">이름은 2자 이상, 10자 이하의 한글이어야 합니다.</p>
                </div>
            <div class="mb-3">
                <label for="nickname" class="form-label">닉네임</label>
                <div class="input-container">
                    <input type="text" class="form-control" id="nickname" 
                    v-model="nickname" placeholder="2자 이상, 10자 이하의 한글">
                    <button @click="nicknameDuplicationCheck" class="check-button">중복확인</button>
                </div>
                <p v-if="nicknameError" class="input-error">닉네임은 2자 이상, 10자 이하의 한글이어야 합니다.</p>
            </div>
        </div>
        <button @click="signup" class="btn btn-primary">회원가입</button>
    </div>
</template>

<script setup>
import { ref, watch } from 'vue';
import { useUserStore } from '@/stores/user.js';

const store = useUserStore();

const email = ref('');
const password = ref('');
const name = ref('');
const nickname = ref('');

const emailError = ref(false);
const passwordError = ref(false);
const nameError = ref(false);
const nicknameError = ref(false);

const emailUnique = ref(false);
const nicknameUnique = ref(false);

const signup = function() {
    if (!emailUnique.value || !nicknameUnique.value) {
        alert("이메일 및 닉네임 중복확인이 필요합니다.");
        return;
    }

    if (emailCheck() && passwordCheck() &&
            nameCheck() && nicknameCheck()) {
        const user = {
            email: email.value,
            password: password.value,
            name: name.value,
            nickname: nickname.value
        }

        store.signup(user);
    } 
}

const emailCheck = function() {
    const pattern = /^[A-Za-z0-9_\\.\\-]+@[A-Za-z0-9\\-]+\.[A-Za-z0-9\\-]+/;

    if (!email || !pattern.test(email.value)) {
        emailError.value = true;
        return false;
    } else {
        emailError.value = false;
        return true;
    }
};

const passwordCheck = function() {
    const pattern = /^(?=.*[a-zA-z])(?=.*[0-9]).{8,20}$/;

    if (!password || !pattern.test(password.value)) {
        passwordError.value = true;
        return false;
    } else {
        passwordError.value = false;
        return true;
    }
};

const nameCheck = function() {
    if (!/^[가-힣]{2,10}$/.test(name.value)) {
        nameError.value = true;
        return false;
    } else {
        nameError.value = false;
        return true;
    }
}

const nicknameCheck = function() {
    if (!/^[가-힣]{2,10}$/.test(nickname.value)) {
        nicknameError.value = true;
        return false;
    } else {
        nicknameError.value = false;
        return true;
    }
}

const emailDuplicationCheck = function() {
    if (!emailCheck()) {
        emailError.value = true;
        return;
    }

    store.emailDuplicationCheck(email.value)
        .then(() => {
            emailUnique.value = true;
            alert("사용 가능한 이메일입니다.");
        })
        .catch(()=>{
            emailUnique.value = false;
            alert("이미 사용 중인 이메일입니다.");
        })
}

const nicknameDuplicationCheck = function() {
    if (!nicknameCheck()) {
        nicknameError.value = true;
        return;
    }

    store.nicknameDuplicationCheck(nickname.value)
        .then(() => {
            nicknameUnique.value = true;
            alert("사용 가능한 닉네임입니다.");
        })
        .catch(() => {
            nicknameUnique.value = false;
            alert("이미 사용 중인 닉네임입니다.");
        })
}

const emailWatch = watch(email, (newValue, oldValue) => {
    emailUnique.value = false;
})

const nicknameWatch = watch(nickname, (newValue, oldValue) => {
    nicknameUnique.value = false;
})

</script>

<style scoped>
.container {
    width: 500px;
}

.form {
    margin: 50px 0;
}

input {
    width: 400px;
}

.input-container {
    display: flex;
}

.check-button {
    font-size: 13px;
    margin-left: 10px;
    border-radius: 10px;
    border: transparent;
    background-color: rgb(222, 236, 255);
}

.input-error {
    font-size: 13px;
    color: red;
}

.btn {
    display: block;
    width: 100%;
    margin: 0 auto;
}

</style>