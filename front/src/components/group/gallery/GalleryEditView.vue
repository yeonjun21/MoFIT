<template>
    <div>
        <fieldset>
            <legend style="font-size: medium;">💙 공지사항 수정 💙</legend>        
            <div class="mb-3"> 
                <label for="writerName" class="form-label">작성자</label> 
                <input class="form-control" type="text" id="writerName" :value="galleryStore.gallery.nickname" readonly>
            </div>
            <div class="mb-3"> 
                <label for="content">내용</label>
                <textarea class="form-control" rows="3" id="content" v-model="content"></textarea>
            </div>
            <div class="d-grid gap-2 d-md-flex justify-content-md-end"> 
                <input  type="file" @change="handleFileChange" />
                <button class="btn btn-primary me-md-1" @click="editGallery">수정</button>
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

const handleFileChange = (event) => {
  selectedFile.value = event.target.files[0];
  const reader = new FileReader();
    reader.onload = () => {
    base64Data.value = reader.result;
  };
  reader.readAsDataURL(selectedFile.value);
};

const editGallery = function(){
    const gallery = { 
        content: content.value,
        index: galleryStore.gallery.index,
        base64Data: base64Data.value,
    }
    galleryStore.editGallery(gallery);
}
</script>

<style scoped>

</style>