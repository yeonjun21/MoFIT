<template>
    <div>
        <h3>축구 모임을 위한 <span>근처 축구장 찾기</span> 기능입니다.</h3>
        <p>모임의 활동 지역 안에 있는 축구장을 알아보세요.</p>
        <SoccerMap/>
    </div>
</template>

<script setup>
import SoccerMap from './SoccerMap.vue';



</script>

<style scoped>
h3 {
    margin-bottom: 20px;
}

p {
    margin-bottom: 70px;
}

span {
    font-weight: 700;
    color: #007bff
}

</style>