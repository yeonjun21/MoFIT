<template>
    <fieldset>
        <div>
                <label for="content">댓글을 남겨보세요 😊</label>
                <textarea class="form-control" id="content" cols='50' v-model="content"></textarea>
                <p v-if="contentError" class="input-error">내용을 입력해 주세요.</p>
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
const contentError = ref(false)

const contentCheck = function() {
    if (!content.value) {
        contentError.value = true;
        return false;
    } else {
        contentError.value = false;
        return true;
    }
}

const registComment = function(){
    if(contentCheck()){
    const commentNotice = {
        noticeIdx : route.params.index,
        content : content.value,
        writer : sessionStorage.getItem("loginUser"), //user store에서 꺼내오기 or 로컬 스토리지
    }
    noticeStore.registComment(commentNotice)
    }   
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

.input-error {
    font-size: 13px;
    color: red;
}
</style>