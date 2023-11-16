<template>
  <div style="font-family: 'Noto Sans KR', 'sans-serif'">
    <HeaderNav/>
    <div @click="goMain" class="main">
      MoFIT
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
  color: rgb(0, 54, 202);
  text-align: center;
  padding: 150px 0 50px;
}
</style>