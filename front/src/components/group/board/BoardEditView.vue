<template>
    <div>
        <fieldset>
            <legend>수정</legend>        
            <div>
                <label for="writerName">작성자</label> 
                <input type="text" id="writerName" :value="boardStore.board.writer" readonly>
            </div>
            <div> 
                <label for="content">내용</label>
                <input type="text" id="content" v-model="content">
            </div>
            <div> 
                <button @click="editBoard">수정</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useBoardStore } from '@/stores/board';
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';


const boardStore = useBoardStore();
const content = ref(boardStore.board.content);

const editBoard = function(){
    const board = { 
        content: content.value,
        index: boardStore.board.index
    }
    boardStore.editBoard(board);
}
</script>

<style scoped>

</style>