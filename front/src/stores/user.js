import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { useRouter } from 'vue-router';
import axios from 'axios';

export const useUserStore = defineStore('user', () => {
  const API_URL = 'http://localhost:8080/user/';

  const router = useRouter();

  const user = ref({});
  const loginUser = ref(sessionStorage.getItem("loginUser"));

  const signup = function(user) {
    axios.post(API_URL + 'signup', user)
      .then(() => {
        alert("성공적으로 가입되었습니다. 로그인을 해주세요.");
        router.push({name: 'LoginForm'});
      })
      .catch(() => {
        console.log("signup 에러");
      })
  }

  const login = function(user) {
    return new Promise((resolve, reject) => {
      axios.post(API_URL + 'login', user)
      .then((res) => {
        loginUser.value = user;
        sessionStorage.setItem("loginUser", res.data.id);
        alert("로그인 되었습니다.");
        resolve();
      })
      .catch(() => {
        console.log("login 에러");
        reject();
      })
    })
  }

  const logout = function() {
    loginUser.value = null;
    sessionStorage.removeItem("loginUser");
    alert("로그아웃 되었습니다.");
    router.push({name: 'Main'});
  }

  const emailDuplicationCheck = function(email) {
    return new Promise((resolve, reject) => {
      axios({
        url: API_URL + 'signup/' + 'emailCheck',
        method: 'GET',
        params: {
          email: email
        }
      })
        .then(() => {
          resolve(true);
        })
        .catch((err) => {
          reject(false);
        })
    })
  }

  const nicknameDuplicationCheck = function(nickname) {
    return new Promise((resolve, reject) => {
      axios({
        url: API_URL + 'signup/' + 'nicknameCheck',
        method: 'GET',
        params: {
          nickname: nickname
        }
      })
        .then(() => {
          resolve(true);
        })
        .catch(() => {
          reject(false);
        })
    })
  }

  return { user, loginUser, signup, login, logout, 
    emailDuplicationCheck, nicknameDuplicationCheck }
})
