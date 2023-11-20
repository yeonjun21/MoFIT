<template>
    <div>
        <div class="video-player">
            <videoPlayer v-if="videoPlayer" :videoURL="videoURL"/>
        </div>
        <img v-for="bookmark in store.bookmarkList" :key="bookmark.videoId"
            :src="bookmark.thumbnails" @click="videoDetail(bookmark.videoId)">
    </div>
</template>

<script setup>
import { useMypageStore } from '@/stores/mypage.js'
import { ref, onMounted } from 'vue';
import VideoPlayer from '@/components/group/video/VideoPlayer.vue';

const store = useMypageStore();

const videoPlayer = ref(false);
const videoURL = ref('');

const videoDetail = function(videoId) {
    videoPlayer.value = !videoPlayer.value;
    videoURL.value = 'https://www.youtube.com/embed/' + videoId;
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
}

</style>