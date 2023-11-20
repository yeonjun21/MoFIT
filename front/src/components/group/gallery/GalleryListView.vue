<template>
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <RouterLink :to="{ name: 'GalleryRegist' }" class="btn btn-primary" style="color: aliceblue;"> 등록 </RouterLink>
    </div>
    <div>
        <div v-for="gallery in galleryStore.galleryList" :key="gallery.index">
            <RouterLink :to="{ name: 'GalleryCommentList', params: { index: gallery.index } }">
                <div class="post">
                    <div class="post-header">
                        <div class="profile"></div>
                        <span class="profile-name">{{ gallery.nickname }}</span>
                    </div>
                    <div class="post-body">
                        <img :src="gallery.img" alt="Gallery Image" />
                    </div>
                    <div class="post-content">
                        <p><strong>{{ gallery.nickname }}</strong> {{ gallery.content }}</p>
                        <p class="date">{{ gallery.date }}</p>
                    </div>
                </div>
            </RouterLink>
        </div>
        <hr>
    </div>
</template>

<script setup>
import { useGalleryStore } from '@/stores/gallery.js';
import { onMounted } from 'vue';
import { useRoute } from 'vue-router';

const galleryStore = useGalleryStore();
const route = useRoute();

onMounted(() => {
    galleryStore.clear();
    galleryStore.getGalleryList(route.params.groupId);
})
</script>

<style scoped>
.post {
    width: 100%;
}

.profile {
    background-image: url("https://picsum.photos/100?random=0");
    width: 30px;
    height: 30px;
    background-size: 100%;
    border-radius: 50%;
    float: left;
}

.profile-name {
    display: block;
    float: left;
    padding-left: 10px;
    padding-top: 7px;
    font-size: 14px;
}

.post-header {
    height: 30px;
    padding: 10px;
}

.post-body>img {
    height: 300px;
    width: 350px;
    background-position: center;
    background-size: cover;
}

.post-content {
    padding-left: 15px;
    padding-right: 15px;
    font-size: 14px;
}

.date {
    font-size: 11px;
    color: grey;
    margin-top: -8px;
}

a {
    text-decoration: none;
    color: black;
}
img {
    width: 300px;
    height: 150px;
    object-fit: scale-down;
    object-position: left;
}

</style>

