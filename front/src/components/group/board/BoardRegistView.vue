<template>
    <div>
        <fieldset>        
            <div>
                <label for="content">게시글을 등록해보세요 😊</label>
                <textarea class="form-control" id="content" cols='50' v-model="content"></textarea>
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

const registBoard = function(){
    const board = {
        groupId : route.params.groupId, //group store에서 꺼내와야 할듯???
        content : content.value,
        writer : sessionStorage.getItem("loginUser"), //user store에서 꺼내오기 or 로컬 스토리지
    }
    boardStore.registBoard(board)
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
</style>