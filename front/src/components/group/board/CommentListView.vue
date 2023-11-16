<template>
    <div>
        <table>
        <tr>
            <th>내용</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        <tr v-for="comment in boardStore.commentList" :key=comment.commentIdx >
            <div v-if="currCmt !== comment.commentIdx">
                <td>{{ comment.content }}</td>
                <td>{{ comment.writer }}</td>
                <td>{{ comment.date }}</td>
                <button @click="currCmt=comment.commentIdx">수정</button>
                <button @click="commentIdx=comment.commentIdx">삭제</button>
            </div>
            <div v-else>
                <CommentEditView :comment-idx="currCmt"/>
            </div>
        </tr>
       </table>
       

    </div>
</template>

<script setup>
import {useBoardStore} from '@/stores/board.js';
import { onMounted, ref, watch } from 'vue';  
import { useRoute, useRouter } from 'vue-router';
import CommentEditView from './CommentEditView.vue';

const boardStore = useBoardStore();
const route = useRoute();
const router = useRouter();

const currCmt = ref()
const commentIdx = ref()

const cmtWatch = watch(commentIdx, (newValue, oldValue) => {
    console.log('watch 실행')
    deleteComment(newValue)
})

const deleteComment = function(commentIdx){
    console.log("게시글 삭제 버튼 정상")
    boardStore.deleteComment(commentIdx)
}


onMounted(() => {
    console.log(route.params.index)
    boardStore.getCommentList(route.params.index)
})
</script>

<style scoped>

</style>