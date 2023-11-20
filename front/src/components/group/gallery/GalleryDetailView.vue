<template>
    <div>
        <div class="first-container">
            <p>{{ galleryStore.gallery.content }}</p>
            <div class="second-container">
                <p>{{ galleryStore.gallery.writer }}</p>
                <p class="blank"> | </p>
                <p>{{ galleryStore.gallery.date }}</p>
            </div>
            <img :src="galleryStore.gallery.img" alt="Gallery Image" />
        </div>

        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <div v-if="galleryStore.gallery.writer == userId">
                <button class="btn btn-primary me-md-2" @click="editGallery">수정</button>
                <button class="btn btn-primary me-md-1" @click="deleteGallery">삭제</button>
            </div>
            <button class="btn btn-primary me-md-2" @click="toGalleryList">목록</button>
            <RouterLink class="btn btn-primary" :to="{ name: 'GalleryCommentRegist' }">댓글 쓰기</RouterLink>
        </div>
    </div>
    <!-- 커멘트 라우터뷰 -->
    <RouterView />
</template>

<script setup>
import { useGalleryStore } from '@/stores/gallery.js';
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';


const galleryStore = useGalleryStore();
const route = useRoute();
const router = useRouter();

const userId = ref(sessionStorage.getItem('loginUser'));

const toGalleryList = function () {
    router.push({ name: 'GalleryList' });
}

const editGallery = function () {
    router.push({ name: 'GalleryEdit' });
}

const deleteGallery = function () {
    galleryStore.deleteGallery(route.params.index);
}

onMounted(() => {
    galleryStore.getGallery(route.params.index);
})
</script>

<style scoped>
.first-container {
    width: 100%;
    border-radius: 10px;
    padding: 13px;
    box-shadow: 0px 0px 5px rgb(170, 170, 170);
    margin: 20px 0px;
}

.first-container>p {
    margin-top: 10px;
    margin-left: 20px;
}

.second-container {
    display: flex;
    margin-left: 20px;
    padding-bottom: 0;
}

.second-container>p.blank {
    padding-left: 10px;
    padding-right: 10px;
}

img {
    width: 300px;
    height: 150px;
    object-fit: scale-down;
    object-position: left;
}
</style>