<template>
    <div>
        <div v-if="videoPlayer" class="video-player">
            <VideoPlayer :videoURL="videoURL"/>
            <button @click="deleteBookmark" type="button" 
                class="btn btn-outline-danger">이 영상을 찜한 영상에서 삭제하기</button>
        </div>
        <img v-for="bookmark in store.bookmarkList" :key="bookmark.videoId"
            :src="bookmark.thumbnails" @click="videoDetail(bookmark.videoId)">
    </div>
</template>

<script setup>
import { useMypageStore } from '@/stores/mypage.js';
import { ref, onMounted } from 'vue';
import VideoPlayer from '@/components/group/video/VideoPlayer.vue';

const store = useMypageStore();

const videoPlayer = ref(false);
const videoURL = ref('');
const videoId = ref('');

const videoDetail = function(v) {
    videoPlayer.value = !videoPlayer.value;
    videoURL.value = 'https://www.youtube.com/embed/' + v;
    videoId.value = v;
}

const deleteBookmark = function() {
    store.deleteBookmark(sessionStorage.getItem('loginUser'), videoId.value);
}

onMounted(() => {
    store.getBookmark(sessionStorage.getItem('loginUser'));
})
</script>

<style scoped>
img {
    width: 120px;
    margin: 3px;
}

.video-player {
    width: 300px;
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 30px;
}

</style>