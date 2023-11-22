<template>
    <div>
        <fieldset>
            <!-- <legend style="font-size: medium;">댓글을 수정해보세요 😊</legend>    -->
            <br>     
            <div class="mb-3">
                <label for="writerName">작성자</label> 
                <input type="text" class="form-control" id="writerName" :value="nickname" readonly>
            </div>
            <div class="mb-3"> 
                <label for="content">내용</label>
                <textarea class="form-control" id="content" rows="3" v-model="content"></textarea>
                <p v-if="contentError" class="input-error">내용을 입력해 주세요.</p>
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end"> 
                <button class="btn btn-primary me-md-2" @click="editComment">수정</button>
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useGalleryStore } from '@/stores/gallery';
import { ref } from 'vue';
import { useRoute } from 'vue-router';

const galleryStore = useGalleryStore();
const content = ref(galleryStore.comment.content);
const route = useRoute();
const nickname = ref(sessionStorage.getItem('userNickname'));
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

const editComment = function(){
    if(contentCheck()){
    const commentGallery = { 
        content: content.value,
        commentIdx: route.params.commentIdx
    }
    galleryStore.editComment(commentGallery);
    }
}

</script>

<style scoped>
legend {
    margin: 20px 0;
}

.input-error {
    font-size: 13px;
    color: red;
}
</style>