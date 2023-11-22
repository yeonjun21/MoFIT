<template>
    <div class="container">
        <h6>ㅤㅤ<span>{{ nickname }}</span>님이 찜한 영상</h6>
        <div v-if="videoPlayer" class="video-player">
            <VideoPlayer :videoURL="videoURL"/>
        </div>
        <img v-if="store.followBookmarkList.length > 0" 
            v-for="bookmark in store.followBookmarkList" :key="bookmark.videoId"
            :src="bookmark.thumbnails" @click="videoDetail(bookmark.videoId)">
        <p v-else>{{ nickname }}님이 찜한 영상이 없습니다 ㅠ_ㅠ</p>
    </div>
</template>

<script setup>
import { useMypageStore } from '@/stores/mypage.js';
import { ref } from 'vue';
import VideoPlayer from '@/components/group/video/VideoPlayer.vue';

defineProps({
    nickname: String
})

const store = useMypageStore();

const videoPlayer = ref(false);
const videoURL = ref('');
const videoId = ref('');

const videoDetail = function(v) {
    videoPlayer.value = !videoPlayer.value;
    videoURL.value = 'https://www.youtube.com/embed/' + v;
    videoId.value = v;
}

</script>

<style scoped>
.container {
    width: 420px;
}

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

span {
    font-weight: 600;
    color: #007bff;
}

p {
    margin-top: 20px;
}

h6 {
    margin-top: 2px;
}
</style>