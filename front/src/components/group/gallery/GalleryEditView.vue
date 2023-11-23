<template>
    <div>
        <fieldset>
            <legend style="font-size: medium;">갤러리를 수정해보세요 😊</legend>        
            <div class="mb-3"> 
                <label for="writerName" class="form-label">작성자</label> 
                <input class="form-control" type="text" id="writerName" :value="galleryStore.gallery.nickname" readonly>
            </div>
            <div class="mb-3"> 
                <label for="content">내용</label>
                <textarea class="form-control" rows="3" id="content" v-model="content"></textarea>
                <p v-if="contentError" class="input-error">내용을 입력해 주세요.</p>
            </div>
            <div class="mb-3"> 
                <input  type="file" @change="handleFileChange" class="form-control"/>
            </div>
            <p style="font-size: 13px;"> 확장자가 jpeg, jpg인 파일만 업로드 가능합니다.</p>
            <p v-if="imgError" class="input-error">이미지를 첨부해 주세요.</p>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end">
                <button class="btn btn-primary me-md-2" @click="editGallery">수정</button>
            </div>
            <div v-if="base64Data">
                <img :src="base64Data" alt="Uploaded Image" />
            </div>
        </fieldset>
    </div>
</template>

<script setup>
import { useGalleryStore } from '@/stores/gallery';
import { ref } from 'vue';

const galleryStore = useGalleryStore();
const content = ref(galleryStore.gallery.content);
const selectedFile = ref(null);
const base64Data = ref(null);
const contentError = ref(false)
const imgError = ref(false)

const contentCheck = function() {
    if (!content.value) {
        contentError.value = true;
        return false;
    } else {
        contentError.value = false;
        return true;
    }
}

const imgCheck = function() {
    if (selectedFile.value == null) {
        imgError.value = true;
        return false;
    } else {
        imgError.value = false;
        return true;
    }
}

const handleFileChange = (event) => {
  selectedFile.value = event.target.files[0];
  const reader = new FileReader();
    reader.onload = () => {
    base64Data.value = reader.result;
  };
  reader.readAsDataURL(selectedFile.value);
};

const editGallery = function(){
    if(contentCheck() & imgCheck()){
    const gallery = { 
        content: content.value,
        index: galleryStore.gallery.index,
        base64Data: base64Data.value,
    }
    galleryStore.editGallery(gallery);
    }
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

img {
    width: 300px;
    object-fit: scale-down;
    object-position: center;
}

.input-error {
    font-size: 13px;
    color: red;
}
</style>