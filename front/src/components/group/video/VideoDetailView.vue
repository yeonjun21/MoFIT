<template>
  <div>
    <div class="info">
      <h5>영상 상세보기 🎞️</h5>
      <p>영상을 찜하면 마이페이지에서 다시 볼 수 있어요.</p>
    </div>
    <div class="video-container">
      <!-- <iframe
      width="650"
      height="365"
      :src="videoURL"
      title="YouTube video player"
      frameborder="0"
      allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
      allowfullscreen>
    </iframe> -->
    <VideoPlayer :videoURL="videoURL"/>
    <div class="d-grid gap-2 d-md-flex justify-content-md-end btn-container">
      <button @click="bookmark" class="btn btn-primary">찜하기</button>
      <button @click="goVideoList" class="btn btn-outline-dark">목록</button>
    </div>
  </div>
    </div>
</template>

<script setup>
import { useVideoStore } from '@/stores/video.js'
import { useMypageStore } from '@/stores/mypage.js'
import { computed } from 'vue';
import { useRouter } from 'vue-router';
import VideoPlayer from './VideoPlayer.vue';

const store = useVideoStore();
const mypageStore = useMypageStore();

const router = useRouter();

const videoURL = computed(() => {
  const videoId = store.video.id.videoId;
  return `https://www.youtube.com/embed/${videoId}`;
})

const goVideoList = function() {
  router.push({name: 'VideoList'});
}

const bookmark = function() {
  mypageStore.bookmark(sessionStorage.getItem('loginUser'), store.video.id.videoId, store.thumbnails);
}

</script>

<style scoped>

iframe {
  margin: 20px 0;
}

.video-container {
  /* margin: 0 auto; */
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>