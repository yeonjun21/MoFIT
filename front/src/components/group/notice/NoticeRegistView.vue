<template>
    <div>
        <fieldset>        
            <div>
                <p>공지사항을 등록해보세요 😊</p>
                <div class="mb-3">
                    <label for="title" class="form-label">작성자</label> 
                    <input class="form-control" type="text" id="title" v-model="title">
                </div>
                <div class="mb-3">
                    <label for="cotent">내용</label>
                    <textarea class="form-control" id="content" cols='50' v-model="content"></textarea>
                </div>
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-primary me-md-2" @click="registNotice">등록</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import { useNoticeStore } from '@/stores/notice';
import { useRoute, useRouter } from 'vue-router';

const noticeStore = useNoticeStore()
const route = useRoute()
const title = ref()
const content = ref()

const registNotice = function(){
    const notice = {
        title : title.value,
        groupId : route.params.groupId, 
        content : content.value,
        writer : sessionStorage.getItem("loginUser"),
    }
    noticeStore.registNotice(notice)
}

</script>

<style scoped>
p {
    margin: 10px 0 30px;
}

</style>