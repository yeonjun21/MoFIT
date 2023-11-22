<template>
    <div class="container">
        <div class="sub-container profile-container">
            <div class="group-image">
                <img class="profile" :src="store.group.img" alt="img">
            </div>
            <div class="profile-sub-container">
                <div class="profile-core">
                    <span v-for="region in store.group.regions" 
                        class="badge rounded-pill text-bg-light">{{ region }}</span>
                    에서 활동하는
                    <span class="badge rounded-pill text-bg-primary">{{ store.group.type }}</span>
                    모임
                    <div class="group-name">{{ store.group.groupName }}</div>
                </div>
                <div class="profile-information">
                    <p>멤버 <span>{{ groupDetail.member }}</span>명</p>
                    <p>게시글 <span>{{ groupDetail.board }}</span>개</p>
                    <p>모임 리더 <span>{{ groupDetail.leaderNickname }}</span> 👑</p>
                </div>
            </div>
        </div>
        <div class="sub-container">
            <h3>모임 소개</h3>
            <div class="content">
                {{ store.group.info }}
            </div>
        </div>
        <div class="sub-container">
            <h3>갤러리</h3>
            <div class="gallery-container">
                <div v-for="gallery in galleryList" :key="gallery.index">
                    <RouterLink :to="{ name: 'GalleryCommentList', params: { index: gallery.index } }">
                        <div>
                            <img :src="gallery.img" alt="Gallery Image" />
                        </div>
                    </RouterLink>
                </div>
            </div>
        </div>
        <GroupJoinButton v-if="!isMember" @click="$emit('join')"/>
    </div>
</template>

<script setup>
import { useGroupStore } from '@/stores/group.js';
import { useGalleryStore } from '@/stores/gallery.js';
import { useRoute } from 'vue-router';
import { ref, onMounted } from 'vue';
import axios from 'axios';
import GroupJoinButton from '@/components/group/home/GroupJoinButton.vue';

defineProps({
    isMember: Boolean
})

const store = useGroupStore();
const galleryStore = useGalleryStore();
const route = useRoute();

const groupDetail = ref({});
let galleryList;

const getGroupDetail = function(groupId) {
    axios({
        url: 'http://localhost:8080/group/' + groupId +'/detail',
        method: 'GET',
    })
        .then((res) => {
            groupDetail.value = res.data;
        })
        .catch(() => {
        })
}

onMounted(() => {
    getGroupDetail(route.params.groupId);
    galleryStore.clear();
    galleryStore.getGalleryList(route.params.groupId);

    if (galleryStore.galleryList != null) {
        galleryList.value = galleryStore.galleryList.slice(0,9);
    }
})

</script>

<style scoped>
.sub-container {
    margin-bottom: 80px;
}
.group-image {
    width: 300px;
    height: 300px;
    flex-shrink: 0;
}

.profile-container {
    display: flex;
}

.profile-sub-container {
    padding: 20px 50px;
    display: flex;
    flex-direction: column;
    justify-content: center;
}

.group-name {
    font-family: 'Nanum Pen Script', cursive;
    font-size: 60px;
    margin-left: 20px;
}

.profile-core {
    font-size: 16px;
}

.profile-information {
    margin-top: 20px;
}

.content {
    margin-top: 20px;
}

.badge {
    font-size: 18px;
}

h3 {
    margin-bottom: 30px;
}

span {
    font-weight: 600;
}

.profile {
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 10px;
}

a {
    text-decoration: none;
    color: black;
}

img {
    width: 200px;
    height: 200px;
    background-position: center;
    background-size: cover;
    object-fit: cover;
    margin: 8px;
}

.gallery-container {
    width: 650px;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
    margin-top: 80px;
    margin: 0 auto;
}
</style>