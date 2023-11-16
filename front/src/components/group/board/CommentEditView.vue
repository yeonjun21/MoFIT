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
                <button @click="editComment">수정</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useBoardStore } from '@/stores/board';
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';

const props = defineProps({
    commentIdx : Number
})

const boardStore = useBoardStore();
const content = ref();
const route = useRoute();

const editComment = function(){
    console.log(55555)
    console.log(props.commentIdx)
    const commentBoard = { 
        content: content.value,
        commentIdx: props.commentIdx
    }
    boardStore.editComment(commentBoard);
}

</script>

<style scoped>

</style>