<template>
    <div>
        <fieldset>
            <legend>등록</legend>        
            <div>
                <label for="content">내용</label>
                <input type="text" id="content" v-model="content">
            </div>
            <div>
                <button @click="registBoard">등록</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { useBoardStore } from '@/stores/board';
import { useRoute,useRouter } from 'vue-router';

const boardStore = useBoardStore()
const router = useRouter()
const content = ref()

const registBoard = function(){
    const board = {
        groupId : 1, //group store에서 꺼내와야 할듯???
        content : content.value,
        writer : 1, //user store에서 꺼내오기 or 로컬 스토리지
    }
    boardStore.registBoard(board)
}

</script>

<style scoped>

</style>