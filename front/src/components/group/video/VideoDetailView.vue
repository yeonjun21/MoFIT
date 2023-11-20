<template>
  <div>
    <h4>영상 상세보기</h4>
  </div>q
</template>

<script setup>
import { useVideoStore } from '@/stores/video.js'
import { computed } from 'vue';

const store = useVideoStore();

const videoURL = computed(() => {
  const videoId = store.video.id.videoId;
  return `https://www.youtube.com/embed/${videoId}`;
})

</script>

<style scoped>

</style>