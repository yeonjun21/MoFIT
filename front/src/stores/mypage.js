import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { useRouter } from 'vue-router';
import axios from 'axios';

export const useMypageStore = defineStore('mypage', () => {
    const API_URL = 'http://localhost:8080/';

    const router = useRouter();

    const user = ref({});
    const followerList = ref([]);
    const followingList = ref([]);
    const board = ref({});
    const video = ref({});

    const getUser = function(id) {
        axios.get(API_URL + 'user/' + id)
            .then((res) => {
                user.value = res.data;
            })
            .catch(() => {
                console.log('getUser 에러');
            })
    }


    return { user,
            getUser }
})
