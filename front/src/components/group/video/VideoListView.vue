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
  // function getType() {
  //   return new Promise((resolve, reject) => {
  //     groupStore.getGroup(route.params.groupId);

  //     if (groupStore.group.type) {
  //       resolve(groupStore.group.type);
  //     } else {
  //       reject();
  //     }
  //   })
  // }

  // function getVideoList(type) {
  //   return new Promise((resolve, reject) => {
  //     videoStore.videoList = videoStore.getVideoList(type);
  //   })
  // }

  // getType()
  //   .then((type) => {
  //     getVideoList(type);
  //   })
  //   .then(() => {

  //   })
  //   .catch(() => {

  //   })

  function promise() {
    return new Promise((resolve, reject) => {
      groupStore.getGroup(route.params.groupId);

      if (groupStore.group.type) {
        resolve(groupStore.group.type);
      } else {
        reject();
      }
    })
  }

  promise()
    .then((type) => {
      videoStore.videoList = videoStore.getVideoList(type);
    })
    .catch(() => {
      console.log('여기서 캐치');
      promise();
    })
    .finally(() => {
      videoStore.videoList = videoStore.getVideoList(groupStore.group.type);
    })
})
</script>

<style scoped>
.video-list {
  display: flex;
  flex-wrap: wrap;
}

.video {
  margin-right: 20px;
  margin-bottom: 20px;
}
</style>