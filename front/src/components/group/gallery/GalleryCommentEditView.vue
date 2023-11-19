<template>
    <div>
        <fieldset>
            <legend style="font-size: medium;">💙 댓글 수정 💙</legend>   
            <br>     
            <div class="mb-3">
                <label for="writerName">작성자</label> 
                <input type="text" class="form-control" id="writerName" :value="nickname" readonly>
            </div>
            <div class="mb-3"> 
                <label for="content">내용</label>
                <textarea class="form-control" id="content" rows="3" v-model="content"></textarea>
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
const content = ref();
const route = useRoute();
const nickname = ref(sessionStorage.getItem('userNickname'));

const editComment = function(){
    const commentGallery = { 
        content: content.value,
        commentIdx: route.params.commentIdx
    }
    galleryStore.editComment(commentGallery);
}

</script>

<style scoped>

</style>