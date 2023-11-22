<template>
    <div>
        <fieldset>
            <legend style="font-size: medium;">공지사항을 수정해보세요 😊</legend>        
            <div class="mb-3">
                <label for="writerName" class="form-label">작성자</label> 
                <input class="form-control" type="text" id="writerName" :value="noticeStore.notice.nickname" readonly>
            </div>
            <div class="mb-3">
                <label for="title" class="form-label">제목</label> 
                <input class="form-control" type="text" id="title" v-model="title">
            </div>
            <div class="mb-3"> 
                <label for="content">내용</label>
                <textarea class="form-control" rows="3" id="content" v-model="content"></textarea>
                <p v-if="error" class="input-error">제목 또는 내용이 비어있습니다.</p>
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end"> 
                <button class="btn btn-primary me-md-1" @click="editNotice">수정</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useNoticeStore } from '@/stores/notice';
import { ref } from 'vue';



const noticeStore = useNoticeStore();
const title = ref(noticeStore.notice.title);
const content = ref(noticeStore.notice.content);

const titleError = ref(false)
const contentError = ref(false)
const error = ref(false)

const titleCheck = function() {
    if (!title.value) {
        titleError.value = true;
        return false;
    } else {
        titleError.value = false;
        return true;
    }
}

const contentCheck = function() {
    if (!content.value) {
        contentError.value = true;
        return false;
    } else {
        contentError.value = false;
        return true;
    }
}

const editNotice = function(){
    error.value = !(titleCheck() && contentCheck())
    if(!error.value){
        const notice = { 
        title: title.value,
        content: content.value,
        index: noticeStore.notice.index
    }
    noticeStore.editNotice(notice);
    }
}
</script>

<style scoped>
legend {
    margin: 10px 0 30px;
}

.input-error {
    font-size: 13px;
    color: red;
}
</style>