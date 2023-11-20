<template>
  <div @click="clickVideo">
    <img :src="video.snippet.thumbnails.medium.url">
    <!-- <p>{{ video.snippet.title }}</p> -->
  </div>
</template>

<script setup>
import { useVideoStore } from '@/stores/video.js';
import { useRouter } from 'vue-router';

const store = useVideoStore();
const router = useRouter();

const props = defineProps({
  video: {
    type: Object,
    required: true,
  }
})

const clickVideo = function () {
  store.getVideo(props.video);
  router.push({name: 'VideoDetail'});
}

</script>

<style scoped>
img {
  width: 200px;
}
</style>