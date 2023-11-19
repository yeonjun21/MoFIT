<template>
    <div>
        <h5>댓글</h5>
        <hr>
        <div v-for="comment in boardStore.commentList" :key=comment.commentIdx >
            <div class="first-container">
                <div>
                        <p>{{ comment.content }}</p>
                    <div class="second-container">
                        <p>{{ comment.nickname }}</p>
                        <p class="blank"> | </p>
                        <p>{{ comment.date }}</p>
                    </div>
                </div>
                <div v-if="comment.writer == userId">
                        <button @click="editComment(comment.commentIdx)" class="btn btn-primary">수정</button>
                        <button @click="deleteComment(comment.commentIdx)" class="btn btn-danger">삭제</button>
                </div>
            </div>
            <hr>
        </div>        
    </div>
</template>

<script setup>
import {useBoardStore} from '@/stores/board.js';
import { onMounted, ref, watch } from 'vue';  
import { useRoute, useRouter } from 'vue-router';

const boardStore = useBoardStore();
const route = useRoute();
const router = useRouter();

const userId = ref(sessionStorage.getItem('loginUser'));

const editComment = function(commentIdx){
    router.push({name:'CommentEdit', params:{commentIdx: commentIdx}});
}
const deleteComment = function(commentIdx){
    boardStore.deleteComment(commentIdx);
}


onMounted(() => {
    boardStore.getCommentList(route.params.index);
})
</script>

<style scoped>
h5 {
    margin: 30px 0;
}
.first-container {
    width: 100%;
    margin: 20px 0 0;
    display: flex;
    align-items: center;
    justify-content: space-between;
}

.second-container{
    display: flex;
}

.second-container>p.blank{
    padding-left: 10px;
    padding-right: 10px;
}

.btn-primary {
    background-color: white;
    border: none;
    color: #007bff;
}

.btn {
    padding: 10px;
}

.btn-danger {
    background-color: white;
    border: none;
    color: #dc3545;
}

</style>