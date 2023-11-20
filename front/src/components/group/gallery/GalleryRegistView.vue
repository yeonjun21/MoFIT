<template>
    <div>
        <fieldset>        
            <div>
                <label for="content">💙 갤러리 등록 💙</label>
                <textarea class="form-control" id="content" cols='50' v-model="content"></textarea>
            </div>
            
            <input type="file" @change="handleFileChange" />
            <button class="btn btn-primary me-md-2" @click="registGallery">등록</button>
            <div v-if="base64Data">
                <img :src="base64Data" alt="Uploaded Image" />
            </div>
            
        </fieldset>
    </div>
</template> 

<script setup>
import { ref } from 'vue';
import { useGalleryStore } from '@/stores/gallery';
import { useRoute, useRouter } from 'vue-router';

const galleryStore = useGalleryStore()
const route = useRoute()
const content = ref()
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

const registGallery = function(){
    const gallery = {
        groupId : route.params.groupId, //group store에서 꺼내와야 할듯???
        content : content.value,
        writer : sessionStorage.getItem("loginUser"), //user store에서 꺼내오기 or 로컬 스토리지
        base64Data: base64Data.value,
    }
    galleryStore.registGallery(gallery)
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