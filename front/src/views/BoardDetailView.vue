<template>
    <div v-if="!editPage">
        <table>
            <td>{{ boardStore.board.content }}</td>
            <td>{{ boardStore.board.writer }}</td>
            <td>{{ boardStore.board.date }}</td>
       </table>
       <button @click="toBoardList">목록</button>
       <button @click="editBoard">수정</button>
       <button @click="deleteBoard">삭제</button>
    </div>
    <div v-else>
        <BoardEditView/>
    </div>
    <br>
    <hr>
    <CommentRegistView/>
    <hr>
    <CommentListView/>
</template>

<script setup>
import {useBoardStore} from '@/stores/board.js';
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import BoardEditView from '../components/group/board/BoardEditView.vue';
import CommentListView from '../components/group/board/CommentListView.vue';
import CommentRegistView from '../components/group/board/CommentRegistView.vue';

const boardStore = useBoardStore();
const route = useRoute();
const router = useRouter();


const editPage = ref();

const toBoardList = function(){
    router.push({name:'GroupBoard', params:{groupId:boardStore.board.groupId}})
}

const editBoard = function(){
    editPage.value = true
}

const deleteBoard = function(){
    boardStore.deleteBoard(boardStore.board.index)  
}

onMounted(()=>{
    editPage.value = false
    boardStore.getBoard(route.params.index)
})
</script>

<style scoped>
/* Board Table Styling */
table {
    width: 100%;
    border-collapse: collapse;
}

td {
    padding: 0.5rem;
    border: 1px solid #dee2e6;
    text-align: left;
}

/* Buttons Styling */
button {
    margin-right: 0.5rem;
    padding: 0.5rem 1rem;
    border: none;
    border-radius: 0.25rem;
    color: white;
    background-color: #007bff; /* Bootstrap primary color */
    cursor: pointer;
}

button:hover {
    background-color: #0056b3; /* Darker shade for hover effect */
}

/* Responsive adjustments */
@media (max-width: 768px) {
    td {
        font-size: 0.8rem;
    }
    button {
        padding: 0.25rem 0.5rem;
        font-size: 0.8rem;
    }
}
</style>