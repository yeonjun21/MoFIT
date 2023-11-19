<template>
    <fieldset>
        <div>
                <label for="content">댓글을 남겨보세요 😊</label>
                <textarea class="form-control" id="content" cols='50' v-model="content"></textarea>
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-primary me-md-2" @click="registComment">등록</button>
            </div>
    </fieldset>
</template>

<script setup>
import { ref } from 'vue';
import { useBoardStore } from '@/stores/board';
import { useRoute,useRouter } from 'vue-router';

const boardStore = useBoardStore()
const route = useRoute()
const content = ref()

const registComment = function(){
    console.log(boardStore.board.index)
    const commentBoard = {
        boardIdx : route.params.index,
        content : content.value,
        writer : sessionStorage.getItem("loginUser"), //user store에서 꺼내오기 or 로컬 스토리지
    }
    boardStore.registComment(commentBoard)
}

</script>

<style scoped>
div>label{
    margin: 15px 0px;
}

div>textarea{
    height: 100px;
    margin-bottom: 20px;
    resize: none;
}
</style>