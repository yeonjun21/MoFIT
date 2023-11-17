<template>
    <div class="container">
        <span v-if="group.leaderId == userId" class="leader-badge">
            운영진
        </span>
        <span v-else class="basic-badge">
            일반회원
        </span>
    </div>
</template>

<script setup>
import { useUserStore } from '@/stores/user.js';
import { ref } from 'vue';

const store = useUserStore();

const userId = ref(sessionStorage.getItem('loginUser'));

defineProps({
    group: Object
})
</script>

<style scoped>
span {
    border-radius: 20px;
    padding: 4px 8px;
    color: white;
    font-family: 'Nanum Pen Script', cursive;
    font-size: 25px;
}

.leader-badge {
    background-color: #f36e6e;
}

.basic-badge {
    background-color: #64B5F6;
}
</style>