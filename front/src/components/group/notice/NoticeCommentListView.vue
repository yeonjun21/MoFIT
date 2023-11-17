<template>
    <div>
        <div v-for="comment in noticeStore.commentList" :key=comment.commentIdx >
            <div>
                <div class="first-container">
                        <p>{{ comment.content }}</p>
                    <div class="second-container">
                        <p>{{ comment.nickname }}</p>
                        <p class="blank"> | </p>
                        <p>{{ comment.date }}</p>
                    </div>
                    <div v-if="comment.writer == userId" class="d-grid gap-2 d-md-flex justify-content-md-end">
                        <button @click="editComment(comment.commentIdx)" class="btn btn-primary me-md-2">수정</button>
                        <button @click="deleteComment(comment.commentIdx)" class="btn btn-primary me-md-2 btn-danger">삭제</button>
                    </div>
                </div>
            </div>
        </div>
        <hr>
        
    </div>
</template>

<script setup>
import {useNoticeStore} from '@/stores/notice.js';
import { onMounted, ref } from 'vue';  
import { useRoute, useRouter } from 'vue-router';

const noticeStore = useNoticeStore();
const route = useRoute();
const router = useRouter();

const userId = ref(sessionStorage.getItem('loginUser'));

const editComment = function(commentIdx){
    router.push({name:'NoticeCommentEdit', params:{commentIdx: commentIdx}});
}
const deleteComment = function(commentIdx){
    noticeStore.deleteComment(commentIdx);
}


onMounted(() => {
    noticeStore.getCommentList(route.params.index);
})
</script>

<style scoped>
.first-container {
    width: 100%;
    border-radius: 10px;
    padding: 13px;
    box-shadow: 0px 0px 5px rgb(170, 170, 170);
    margin: 20px 0px;
}

.first-container>p{
    margin-top : 10px;
    margin-left: 20px;
}

.second-container{
    display: flex;
    margin-left: 20px;
    padding-bottom: 0;
}

.second-container>p.blank{
    padding-left: 10px;
    padding-right: 10px;
}

</style>