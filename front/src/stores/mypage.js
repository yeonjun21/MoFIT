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
    const bookmarkList = ref([]);
    const followBookmarkList = ref([]);
    const boardList = ref([]);

    const getUser = function(id) {
        axios.get(API_URL + 'user/' + id)
            .then((res) => {
                user.value = res.data;
            })
            .catch(() => {
                console.log('getUser 에러');
            })
    }

    const bookmark = function(userId, videoId, thumbnails) {
        axios({
            url: API_URL + 'bookmark',
            method: 'GET',
            params: {
                userId: userId,
                videoId: videoId,
                thumbnails: thumbnails
            }
        })
            .then(() => {
                alert('영상을 찜했습니다.');
            })
            .catch(() => {
                console.log('bookmark 에러');
            })
    }

    const deleteBookmark = function(userId, videoId) {
        axios({
            url: API_URL + 'bookmark',
            method: 'DELETE',
            data: {
                userId: userId,
                videoId: videoId,
            }
        })
            .then(() => {
                alert('해당 영상을 찜한 영상에서 삭제했습니다.');
                getBookmark(sessionStorage.getItem('loginUser'));
            })
            .catch(() => {
                console.log('deleteBookmark 에러');
            })
    }

    const getBookmark = function(userId) {
        axios({
            url: API_URL + 'bookmark',
            method: 'POST',
            params: {
                userId: userId
            }
        })
            .then((res) => {
                bookmarkList.value = res.data;
            })
            .catch(() => {
                console.log('getBookmark 에러');
            })
    }

    const getFollowBookmark = function(userId) {
        axios({
            url: API_URL + 'bookmark',
            method: 'POST',
            params: {
                userId: userId
            }
        })
            .then((res) => {
                followBookmarkList.value = res.data;
            })
            .catch(() => {
                console.log('getFollowBookmark 에러');
            })
    }
    
    const getBoardList = function(userId) {
        axios({
            url: API_URL + 'user/' + userId + '/board',
            method: 'GET',
        })
            .then((res) => {
                boardList.value = res.data;
            })
            .catch(() => {
                console.log('getBoardList 에러');
            })
    }

    const getFollowingList = function(userId) {
        axios({
            url: API_URL + 'user/' + userId + '/following',
            method: 'GET',
            params: {
                id: userId
            }
        })
            .then((res) => {
                followingList.value = res.data;
            })
            .catch(() => {
                console.log('getFollowingList 에러');
            })
    }

    const getFollowerList = function(userId) {
        axios({
            url: API_URL + 'user/' + userId + '/follower',
            method: 'GET',
            params: {
                id: userId
            }
        })
            .then((res) => {
                followerList.value = res.data;
            })
            .catch(() => {
                console.log('getFollowerList 에러');
            })
    }


    return { user, bookmarkList, followBookmarkList, boardList, followingList, followerList,
            getUser, bookmark, deleteBookmark, getBookmark, getFollowBookmark, getBoardList,
            getFollowingList, getFollowerList }
})
