<template>
    <div>
        <fieldset>        
            <div>
                <label for="content">게시글을 등록해보세요 😊</label>
                <textarea class="form-control" id="content" cols='50' v-model="content"></textarea>
                <p v-if="contentError" class="input-error">내용을 입력해 주세요.</p>
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-primary me-md-2" @click="registBoard">등록</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { useBoardStore } from '@/stores/board';
import { useRoute, useRouter } from 'vue-router';

const boardStore = useBoardStore()
const route = useRoute()
const content = ref()
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

const registBoard = function(){
    if(contentCheck()){
        const board = {
        groupId : route.params.groupId, //group store에서 꺼내와야 할듯???
        content : content.value,
        writer : sessionStorage.getItem("loginUser"), //user store에서 꺼내오기 or 로컬 스토리지
    }
    boardStore.registBoard(board)
    }
}

</script>

<style scoped>
div>label{
    margin: 15px 0px;
}

div>textarea{
    height: 180px;
    margin-bottom: 20px;
    resize: none;
}

.input-error {
    font-size: 13px;
    color: red;
}
</style>