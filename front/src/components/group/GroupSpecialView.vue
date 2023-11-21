<template>
    <div v-if="!isMember">
        <NeedJoinView/>
    </div>
    <div v-else>
        <div v-if="store.group.type === '등산'">
            <Mountain/>
        </div>
        <div v-else-if="store.group.type == '러닝'">
            <KakaoMap1/>
        </div>
        <div v-else-if="store.group.type == '축구'">
            <KakaoMap/>
        </div>
        <div v-else>
            <h3>우리 모임에는 아직 지원되지 않는 기능입니다 😳</h3>
        </div>
    </div>
</template>
<script setup>
import NeedJoinView from '@/components/common/NeedJoinView.vue';
import Mountain from '@/components/group/special/mountain/Mountain.vue';
import KakaoMap1 from './kakao/KakaoMap1.vue';
import KakaoMap from './kakao/KakaoMap.vue';
import { useGroupStore } from '@/stores/group.js';

defineProps({
    isMember: Boolean
})

const store = useGroupStore();

</script>

<style scoped>
h3 {
    margin-bottom: 50px;
}
</style>