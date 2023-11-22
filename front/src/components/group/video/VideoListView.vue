<template>
  <div class="video-list">
      <VideoListItemView v-for="video in videoStore.videoList"
        :key="video.id.videoId" :video="video" class="video"/>
  </div>
</template>

<script setup>
import { useGroupStore } from '@/stores/group.js';
import { useVideoStore } from '@/stores/video.js';
import { useRoute } from 'vue-router';
import { onMounted, ref } from 'vue';
import VideoListItemView from './VideoListItemView.vue';

const groupStore = useGroupStore();
const videoStore = useVideoStore();
const route = useRoute();

onMounted(() => {
  const promise = new Promise((resolve, reject) => {
    groupStore.getGroup(route.params.groupId);

      if (groupStore.group.type) {
        resolve(groupStore.group.type);
      } else {
        reject();
      }
  })
    .then((type) => {
      videoStore.videoList = videoStore.getVideoList(type);
    })
    .catch(() => {
      console.log('promise catch');
    })
})
</script>

<style scoped>
.video-list {
  display: flex;
  flex-wrap: wrap;
}

.video {
  margin-right: 15px;
  margin-bottom: 15px;
}
</style>