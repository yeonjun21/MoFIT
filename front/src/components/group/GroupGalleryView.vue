<template>
    <div v-if="!isMember">
        <NeedJoinView/>
    </div>
    <div v-else class="gallery">
      <h3>우리 모임의 <span>갤러리</span>입니다.</h3>
        <div>
            <RouterView/>
        </div>
    </div>
</template>

<script setup>
import NeedJoinView from '@/components/common/NeedJoinView.vue';

defineProps({
    isMember: Boolean
})
</script>

<style scoped>
h3 {
    margin-bottom: 50px;
}

span {
    font-weight: 700;
    color: #007bff
}

#app {
  box-sizing: border-box;
  font-family: "consolas";
  margin-top: 60px;
  width: 100%;
  max-width: 460px;
  margin: auto;
  position: relative;
  border-right: 1px solid #eee;
  border-left: 1px solid #eee;
}
</style>