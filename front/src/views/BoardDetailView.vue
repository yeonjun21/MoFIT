<template>
    <div>
        <table>
            <td>{{ boardStore.board.content }}</td>
            <td>{{ boardStore.board.writer }}</td>
            <td>{{ boardStore.board.date }}</td>
       </table>
    </div>
    <button @click="toBoardList">목록</button>
    <button @click="editBoard">수정</button>
    <button @click="deleteBoard">삭제</button>
    <br>
    <hr>
    <CommentRegistView/>
    <hr>
    <CommentListView/>
</template>

<script setup>
import {useBoardStore} from '@/stores/board.js';
import { onMounted } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import CommentListView from '../components/board/CommentListView.vue';
import CommentRegistView from '../components/board/CommentRegistView.vue';

const boardStore = useBoardStore();
const route = useRoute();
const router = useRouter();


const toBoardList = function(){
    router.push({name:'board-list'})
}

const editBoard = function(){
    router.push({name:'board-edit'})
}

const deleteBoard = function(){
    boardStore.deleteBoard(boardStore.board.index)  
}

onMounted(()=>{
    boardStore.getBoard(route.params.index)
})
</script>

<style scoped>

</style>