<template>
    <div class="container">
        <ul class="nav nav-underline">
            <li class="nav-item">
                <RouterLink :to="{ name: 'GroupAdd' }" class="nav-link" 
                    :class="{active: route.path === '/add'}">모임 만들기</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'GroupList' }" class="nav-link" 
                    :class="{active: route.path === '/'}">우리동네 모임 찾기</RouterLink>
            </li>
            <li class="nav-item">
                <RouterLink :to="{ name: 'MyGroup' }" class="nav-link" 
                    :class="{active: route.path === '/my-group'}">내 모임 보기</RouterLink>
            </li>
        </ul>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRoute } from 'vue-router';

const selected = ref(0);
const route = useRoute();

</script>

<style scoped>
.container {
    display: flex;
    justify-content: space-around;
    margin-bottom: 80px;
}

.nav {
    display: flex;
    flex-wrap: nowrap;
}

.nav-item {
    margin: 0 70px;
}

a {
    text-decoration: none;
}

</style>