<template>
    <div>
        <fieldset>        
            <div>
                <label for="title">💙 공지사항 등록 💙</label>
                <input type="text" id="title" v-model="title"> 
                <textarea class="form-control" id="content" cols='50' v-model="content"></textarea>
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
div>label{
    margin: 15px 0px;
}

div>textarea{
    height: 180px;
    margin-bottom: 20px;
    resize: none;
}
</style>