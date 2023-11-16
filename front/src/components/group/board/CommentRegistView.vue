<template>
    <fieldset>
            <legend>등록</legend>        
            <div>
                <label for="content">내용</label>
                <input type="text" id="content" v-model="content">
            </div>
            <div>
                <button @click="registComment">등록</button>
            </div>
    </fieldset>
</template>

<script setup>
import { ref } from 'vue';
import { useBoardStore } from '@/stores/board';
import { useRoute,useRouter } from 'vue-router';

const boardStore = useBoardStore()
const content = ref()

const registComment = function(){
    console.log(boardStore.board.index)
    const commentBoard = {
        boardIdx : boardStore.board.index,
        content : content.value,
        writer : 1, //user store에서 꺼내오기 or 로컬 스토리지
    }
    boardStore.registComment(commentBoard)
}

</script>

<style lang="scss" scoped>

</style>