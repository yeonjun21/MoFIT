<template>
    <div>
        <fieldset>
            <legend style="font-size: medium;">게시글을 수정해보세요 😊</legend>        
            <div class="mb-3">
                <label for="writerName" class="form-label">작성자</label> 
                <input class="form-control" type="text" id="writerName" :value="boardStore.board.nickname" readonly>
            </div>
            <div class="mb-3"> 
                <label for="content">내용</label>
                <textarea class="form-control" rows="3" id="content" v-model="content"></textarea>
                <p v-if="contentError" class="input-error">내용을 입력해 주세요.</p>
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end"> 
                <button class="btn btn-primary me-md-1" @click="editBoard">수정</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useBoardStore } from '@/stores/board';
import { ref } from 'vue';

const boardStore = useBoardStore();
const content = ref(boardStore.board.content);
const contentError = ref(false)

const contentCheck = function() {
    if (!content.value) {
        contentError.value = true;
        return false;
    } else {
        contentError.value = false;
        return true;
    }
}
const editBoard = function(){
    if(contentCheck()){
        const board = { 
        content: content.value,
        index: boardStore.board.index
    }
    boardStore.editBoard(board);
    }
}
</script>

<style scoped>
legend {
    margin: 10px 0 30px;
}

.input-error {
    font-size: 13px;
    color: red;
}
</style>