import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { useRouter } from 'vue-router';
import axios from 'axios';

export const useVideoStore = defineStore('video', () => {
  const API_URL = 'https://www.googleapis.com/youtube/v3/search';
  const API_KEY = 'AIzaSyAXyzdf91y0ELR8iWB27kXY-N2-Py2Z3xY';

  const router = useRouter();

  const video = ref({});
  const videoList = ref([]);
  const thumbnails = ref();

  const getVideoList = function(type) {
    axios({
      url: API_URL,
      method: 'GET',
      params: {
        key: API_KEY,
        part: "snippet",
        q: type,
        type: "video",
        maxResults: 20,
        chart: 'mostPopular',
        videoCategoryId: 17,
        // videoDuration: 'medium'
      }
    })
    .then((res) => {
      videoList.value = res.data.items;
    })
    .catch(() => {
      console.log('getVideoList 에러');
    })
  }

  const getVideo = function(v) {
    video.value = v;
  }

  const getThumbnails = function(url) {
    thumbnails.value = url;
  }
  
  return { video, videoList, thumbnails, getVideoList, getVideo, getThumbnails }
})
