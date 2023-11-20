<template>
    <div class="board-list">
        <div v-for="board in store.boardList" :key="board.index" class="board">
            <p class="content">{{ board.content }}</p>
            <p class="group-name">{{ board.groupName }}</p>
        </div>
    </div>
</template>

<script setup>
import { useMypageStore } from '@/stores/mypage.js'
import { ref, onMounted } from 'vue';

const store = useMypageStore();

onMounted(() => {
    store.getBoardList(sessionStorage.getItem('loginUser'));
})
</script>

<style scoped>

.board {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    width: 360px;
    box-shadow: 0px 0px 3px rgb(180, 180, 180);
    border-radius: 10px;
    margin-bottom: 15px;
    padding: 6px 10px;
}
.content {
    margin-bottom: 10px;
}

.group-name {
    color: gray;
    font-size: 13px;
}

p {
    margin-bottom: 1px;
}
</style>