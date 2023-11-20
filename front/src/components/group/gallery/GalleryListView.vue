<template>
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <RouterLink :to="{ name: 'GalleryRegist' }" class="btn btn-primary" style="color: aliceblue;"> 등록 </RouterLink>
    </div>
    <div class="gallery-container">
        <div v-for="gallery in galleryStore.galleryList" :key="gallery.index">
            <RouterLink :to="{ name: 'GalleryCommentList', params: { index: gallery.index } }">
                <div>
                    <img :src="gallery.img" alt="Gallery Image" />
                </div>
            </RouterLink>
        </div>
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

a {
    text-decoration: none;
    color: black;
}

img {
    width: 250px;
    height: 250px;
    background-position: center;
    background-size: cover;
    object-fit: cover;
    margin: 10px;
}

.gallery-container {
    width: 100%;
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    margin-top: 30px;
}

</style>

