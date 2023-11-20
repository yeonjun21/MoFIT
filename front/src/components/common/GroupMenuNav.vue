<template>
    <div class="container">
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <RouterLink :to="{ name: 'GroupHome' }" class="nav-link" 
                    :class="{active: route.path === path}">Home</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'NoticeList' }" class="nav-link" 
                    :class="{active: route.path === path + '/notice'}">공지사항</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'BoardList' }" class="nav-link" 
                    :class="{active: route.path === path + '/board'}">자유게시판</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'GalleryList' }" class="nav-link"
                    :class="{active: route.path === path + '/gallery'}">갤러리</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'VideoList' }" class="nav-link" 
                    :class="{active: route.path === path + '/video'}">관련 영상</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'GroupSpecial' }" class="nav-link" 
                    :class="{active: route.path === path + '/special'}">💙특별한 기능💙</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'GroupMember' }" class="nav-link" 
                    :class="{active: route.path === path + '/member'}">👨모임 멤버 보기👩</RouterLink>
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