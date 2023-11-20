<template>
    <div v-if="!isMember">
        <NeedJoinView/>
    </div>
    <div v-else>
        <h3>Special</h3>
    </div>
</template>

<script setup>
import NeedJoinView from '@/components/common/NeedJoinView.vue';

defineProps({
    isMember: Boolean
})
</script>

<style scoped>

</style>