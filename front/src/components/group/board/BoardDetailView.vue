<template>
    <div>
        <div class="first-container">
            <p>{{ boardStore.board.content }}</p>
            <div class="second-container">
                <p>{{ boardStore.board.nickname }}</p>
                <p class="blank"> | </p>
                <p>{{ boardStore.board.date }}</p>  
            </div>
        </div>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <div v-if="boardStore.board.writer == userId">
                <button class="btn btn-primary me-md-2" @click="editBoard">수정</button>
                <button class="btn btn-primary me-md-1" @click="deleteBoard">삭제</button>
            </div>
            <button class="btn btn-primary me-md-2" @click="toBoardList">목록</button>
            <RouterLink class="btn btn-primary" :to="{name:'CommentRegist'}">댓글 쓰기</RouterLink>
        </div>
    </div>

    <!--여기에 커멘트 라우터뷰-->
    <RouterView/>
</template>

<script setup>
import {useBoardStore} from '@/stores/board.js';
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';


const boardStore = useBoardStore();
const route = useRoute();
const router = useRouter();

const userId = ref(sessionStorage.getItem('loginUser'));

const toBoardList = function(){
    router.push({name:'BoardList'});
}

const editBoard = function(){
    router.push({name:'BoardEdit'});
}

const deleteBoard = function(){
    boardStore.deleteBoard(route.params.index);  
}

onMounted(()=>{
    boardStore.getBoard(route.params.index);
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