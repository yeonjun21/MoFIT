<template>
  <div style="font-family: 'Noto Sans KR', 'sans-serif'">
    <HeaderNav/>
    <div @click="goMain" class="main">
      <img src="@/assets/logo3.png">
    </div>
    <Router-view/>
  </div>
</template>

<script setup>
import HeaderNav from './components/common/HeaderNav.vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const goMain = function() {
  router.push('/');
}

</script>

<style scoped>
.main {
  font-size: 72px;
  font-weight: 700;
  color: rgb(0, 50, 210);
  text-align: center;
  padding: 120px 0 70px;
}

img {
  width: 450px;
}
</style>