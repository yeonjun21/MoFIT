<template>
    <div>
       <table>
        <tr>
            <th>내용</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        <tr v-for="board in boardStore.boardList" :key = "board.index">
            <td>
                <RouterLink :to="`/board/detail/${board.index}`"> {{ board.content }}</RouterLink>
            </td>
            <td>{{ board.writer }}</td>
            <td>{{ board.date }}</td>
        </tr>
       </table>
       <hr>
       <div> <RouterLink :to="`/board/regist`">게시글 등록</RouterLink></div>

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
    boardStore.getBoardList(1); //나중에 라우터 push로 바꿀 예정 group번호
})
</script>

<style scoped>

</style>