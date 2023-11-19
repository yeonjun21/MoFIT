import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { useRouter } from 'vue-router';
import axios from 'axios';

export const useVideoStore = defineStore('video', () => {
  const API_URL = 'https://www.googleapis.com/youtube/v3/search';
  const API_KEY = 'AIzaSyDVY3BxSGL9YcJLpH5FP-e_Q4fPYJplsvo';

  const router = useRouter();

  const video = ref({});
  const videoList = ref([]);

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
      console.log(type);
      videoList.value = res.data.items;
    })
    .catch(() => {
      console.log('getVideoList 에러');
    })
  }

  const getVideo = function(video) {
    video.value = video;
  }
  
  return { video, videoList, getVideoList, getVideo }
})
