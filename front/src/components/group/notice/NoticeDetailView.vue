<template>
    <div>
        <div class="first-container">
            <p class="title">{{ noticeStore.notice.title }}</p>
            <p>{{ noticeStore.notice.content }}</p>
            <div class="second-container">
                <p>{{ noticeStore.notice.nickname }}</p>
                <p class="blank"> | </p>
                <p>{{ noticeStore.notice.date }}</p>  
            </div>
        </div>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
            <div v-if="noticeStore.notice.writer == userId">
                <button class="btn btn-outline-primary me-md-2" @click="editNotice">수정</button>
                <button class="btn btn-outline-danger" @click="deleteNotice">삭제</button>
            </div>
            <button class="btn btn-outline-secondary" @click="toNoticeList">목록</button>
            <RouterLink class="btn btn-primary" :to="{name:'NoticeCommentRegist'}">댓글 쓰기</RouterLink>
        </div>
    </div>

    <!--여기에 커멘트 라우터뷰-->
    <RouterView/>
</template>

<script setup>
import {useNoticeStore} from '@/stores/notice.js';
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';


const noticeStore = useNoticeStore();
const route = useRoute();
const router = useRouter();

const userId = ref(sessionStorage.getItem('loginUser'));

const toNoticeList = function(){
    router.push({name:'NoticeList'});
}

const editNotice = function(){
    router.push({name:'NoticeEdit'});
}

const deleteNotice = function(){
    noticeStore.deleteNotice(route.params.index);  
}

onMounted(()=>{
    noticeStore.getNotice(route.params.index);
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

.title {
    font-weight: 600;
    font-size: 18px;
}

</style>