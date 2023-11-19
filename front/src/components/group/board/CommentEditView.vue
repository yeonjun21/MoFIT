<template>
    <div>
        <fieldset>
            <!-- <legend style="font-size: medium;">💙 댓글 수정 💙</legend>    -->
            <br>     
            <div class="mb-3">
                <label for="writerName">작성자</label> 
                <input type="text" class="form-control" id="writerName" :value="nickname" readonly>
            </div>
            <div class="mb-3"> 
                <label for="content">댓글 내용</label>
                <textarea class="form-control" id="content" rows="3" v-model="content"></textarea>
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end"> 
                <button class="btn btn-primary me-md-2" @click="editComment">수정</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useBoardStore } from '@/stores/board';
import { ref } from 'vue';
import { useRoute } from 'vue-router';

const boardStore = useBoardStore();
const content = ref();
const route = useRoute();
const nickname = ref(sessionStorage.getItem('userNickname'));

const editComment = function(){
    const commentBoard = { 
        content: content.value,
        commentIdx: route.params.commentIdx
    }
    boardStore.editComment(commentBoard);
}

</script>

<style scoped>

</style>