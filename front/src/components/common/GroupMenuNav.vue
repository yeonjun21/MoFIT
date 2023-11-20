<template>
    <div class="container">
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <RouterLink :to="{ name: 'GroupHome' }" @click="selected = 1" class="nav-link" 
                    :class="{active: route.path === path}">Home</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'NoticeList' }" @click="selected = 2" class="nav-link" 
                    :class="{active: route.path === path + '/notice'}">공지사항</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'BoardList' }" @click="selected = 3" class="nav-link" 
                    :class="{active: route.path === path + '/board'}">자유게시판</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'GalleryList' }" @click="selected = 4" class="nav-link" 
                    :class="{active: route.path === path + '/gallery'}">갤러리</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'VideoList' }" @click="selected = 5" class="nav-link" 
                    :class="{active: route.path === path + '/video'}">관련 영상</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'GroupSpecial' }" @click="selected = 6" class="nav-link" 
                    :class="{active: route.path === path + '/notice'}">특별한 기능💙</RouterLink>
            </li>
        </ul>
    </div>
</template>

<script setup>
import { useRoute } from 'vue-router';
import { ref } from 'vue';

const route = useRoute();
const path = `/group/${route.params.groupId}`;
const selected = ref(1);

</script>

<style scoped>

a {
    color: gray;
}
.active {
    color: #007bff;
}

</style>