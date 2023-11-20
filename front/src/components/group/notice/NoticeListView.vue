<template>
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <RouterLink :to="{name:'NoticeRegist'}" class="btn btn-primary" style="color: aliceblue;"
            v-if="leaderId == groupDetail.leaderId"> 등록 </RouterLink>
    </div>
    <div class="notice-list">   
        <div v-for="notice in noticeStore.noticeList" :key = "notice.index" class="content">
            <RouterLink :to="{name:'NoticeCommentList', params:{index: notice.index}}"
                class="notice-detail">
                <div class="first-container">
                    <p class="title">{{ notice.title }}</p>
                    <p>{{ notice.content }}</p>
                    <div class="second-container">
                        <p>{{ notice.nickname }}</p>
                        <p class="blank"> | </p>
                        <p>{{ notice.date }}</p>
                    </div>
                </div>
            </RouterLink>
        </div>
    </div>
</template>

<script setup>
import {useNoticeStore} from '@/stores/notice.js';
import { onMounted, ref } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';  

const noticeStore = useNoticeStore();
const route = useRoute();

const leaderId = ref(sessionStorage.getItem('loginUser'));
const groupDetail = ref({});

const getGroupDetail = function(groupId) {
    axios({
        url: 'http://localhost:8080/group/' + groupId +'/detail',
        method: 'GET',
    })
        .then((res) => {
            groupDetail.value = res.data;
        })
        .catch(() => {
        })
}

onMounted(()=>{
    noticeStore.clear();
    noticeStore.getNoticeList(route.params.groupId);
    getGroupDetail(route.params.groupId);
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

.title {
    font-weight: 600;
    font-size: 18px;
}

.content {
    margin-bottom: 30px;
}

.notice-list {
    margin: 30px 0;
}

</style>