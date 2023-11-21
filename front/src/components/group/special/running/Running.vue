<template>
    <div>
        <h3>러닝 모임을 위한 <span>러닝 코스 그리기</span> 기능입니다.</h3>
        <p>지도에 러닝 코스를 그려 거리와 소요 시간을 알아보세요.</p>
        <RunningMap/>
    </div>
</template>

<script setup>
import RunningMap from './RunningMap.vue';


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