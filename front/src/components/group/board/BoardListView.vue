<template>
    <div>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <RouterLink :to="{name:'BoardRegist'}" class="btn btn-primary" style="color: aliceblue;"> 등록 </RouterLink>
    </div>
    <div class="board-list">   
        <div v-for="board in boardStore.boardList" :key = "board.index" class="content">
            <RouterLink :to="{name:'CommentList', params:{index: board.index}}"
                class="board-detail">
                <div class="first-container">
                    <p>{{ board.content }}</p>
                    <div class="second-container">
                        <p>{{ board.nickname }}</p>
                        <p class="blank"> | </p>
                        <p>{{ board.date }}</p>
                    </div>
                </div>
            </RouterLink>
        </div>
    </div>
    </div>
</template>

<script setup>
import {useBoardStore} from '@/stores/board.js';
import { onMounted } from 'vue';
import { useRoute } from 'vue-router';   

const boardStore = useBoardStore();
const route = useRoute();

onMounted(()=>{
    console.log(route.params.groupId)
    boardStore.getBoardList(route.params.groupId); 
})
</script>

<style scoped>

.first-container {
    width: 100%;
    border-radius: 10px;
    padding: 13px;
    box-shadow: 0px 0px 3px rgb(170, 170, 170);
    margin: 20px 0px;
}

.first-container > p {
    margin-top : 10px;
    margin-left: 20px;
}

.second-container {
    display: flex;
    margin-top: 20px;
    margin-left: 20px;
    padding-bottom: 0;
}

.second-container>p.blank{
    padding-left: 10px;
    padding-right: 10px;
}

a {
    text-decoration: none;
    color: black;
}

.board-list {
    margin: 30px 0;
}

.content {
    margin-bottom: 30px;
}
</style>