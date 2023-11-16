<template>
    <div class="container">
        <ul class="nav nav-tabs">
            <li class="nav-item">
                <RouterLink :to="{ name: 'GroupHome' }" @click="selected = 1" class="nav-link" 
                    :class="{active: selected === 1}">Home</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'GroupNotice' }" @click="selected = 2" class="nav-link" 
                    :class="{active: selected === 2}">공지사항</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'GroupBoard' }" @click="selected = 3" class="nav-link" 
                    :class="{active: selected === 3}">자유게시판</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'GroupGallery' }" @click="selected = 4" class="nav-link" 
                    :class="{active: selected === 4}">갤러리</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'GroupVideo' }" @click="selected = 5" class="nav-link" 
                    :class="{active: selected === 5}">관련 영상</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'GroupSpecial' }" @click="selected = 6" class="nav-link" 
                    :class="{active: selected === 6}">특별한 기능💙</RouterLink>
            </li>
        </ul>
    </div>
</template>

<script setup>
import { useRoute } from 'vue-router';
import { ref } from 'vue';

const route = useRoute();
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