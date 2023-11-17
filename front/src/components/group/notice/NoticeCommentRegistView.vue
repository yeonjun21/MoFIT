<template>
    <fieldset>
        <div>
                <label for="content">💙 댓글 등록 💙</label>
                <textarea class="form-control" id="content" cols='50' v-model="content"></textarea>
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-primary me-md-2" @click="registComment">등록</button>
            </div>
    </fieldset>
</template>

<script setup>
import { ref } from 'vue';
import { useNoticeStore } from '@/stores/notice';
import { useRoute,useRouter } from 'vue-router';

const noticeStore = useNoticeStore()
const route = useRoute()
const content = ref()

const registComment = function(){
    console.log(noticeStore.notice.index)
    const commentNotice = {
        noticeIdx : route.params.index,
        content : content.value,
        writer : sessionStorage.getItem("loginUser"), //user store에서 꺼내오기 or 로컬 스토리지
    }
    noticeStore.registComment(commentNotice)
}

</script>

<style scoped>
div>label{
    margin: 15px 0px;
}

div>textarea{
    height: 100px;
    margin-bottom: 20px;
    resize: none;
}
</style>