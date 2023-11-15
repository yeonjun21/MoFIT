<template>
  <div>
    <HeaderNav/>
    <div class="main">
      MoFIT
    </div>
    <Router-view/>
  </div>
</template>

<script setup>
import HeaderNav from './components/common/HeaderNav.vue';


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