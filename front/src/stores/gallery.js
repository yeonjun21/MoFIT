import { ref } from 'vue'
import { defineStore } from 'pinia'
import { useRoute,useRouter } from 'vue-router';
import axios from 'axios';

export const useGalleryStore = defineStore('gallery', () => {

   const API_URL_GALLERY = 'http://localhost:8080/gallery';
   const API_URL_COMMENT = 'http://localhost:8080/gallery/comment';

   const router = useRouter();

   const galleryList = ref([]);
   const gallery = ref({});

   const commentList = ref([]);
   const comment = ref({});

    const getGalleryList = function (groupId) {
        return new Promise((resolve, reject) => {
            axios({
                url: API_URL_GALLERY,
                method: 'GET',
                params:{
                    groupId: groupId,
                }
            })
                .then((res) => {
                     galleryList.value = res.data;
                     resolve();
                })
                .catch(() => {
                    console.log('getGalleryList 에러 발생');
                    reject();
                })
        })
   };

   const getGallery = function (index) {
       axios({
           url: API_URL_GALLERY + '/' + index,
           method: 'GET'
       })
       .then((res) => {
            gallery.value = res.data;
       })
       .catch(() => {
            console.log(gallery.value.groupId);
            console.log('getGallery error 발생')
       })
   };

   const registGallery = function (gallery) {
        axios({
            url: API_URL_GALLERY,
            method: 'POST',
            data: {
                groupId : gallery.groupId,
                content : gallery.content,
                writer : gallery.writer,
                img : gallery.base64Data
            }
        })
        .then((res)=>{
            alert("게시글이 등록되었습니다.")
            router.push({name: 'GalleryList'})
        })
        .catch((err)=>{
            console.log('registGallery error 발생')
        })
   };

   const editGallery = function (gallery) {
        axios({
            url: API_URL_GALLERY,
            method: 'PUT',
            data: {
                content : gallery.content,
                index : gallery.index,
                img : gallery.base64Data
            }
        })
        .then((res)=>{
            alert('게시글이 수정되었습니다.')
            router.push({name:'GalleryList', params:{index: gallery.index}})
        })
        .catch((err)=>{
            console.log('edit error 발생')
        })
    };

   const deleteGallery = function (index) {
        axios({
            url: API_URL_GALLERY,
            method: 'DELETE',
            params:{
                index : index,
            }
        })
        .then((res)=>{
            alert('게시글이 삭제되었습니다.')
            router.push({name: 'GalleryList'})
        })
        .catch((err)=>{
            console.log('deleteGallery error 발생')
        })
   }

   const getCommentList = function (galleryIdx) {
        console.log(galleryIdx) 
        axios({
            url: API_URL_COMMENT,
            method: 'GET',
            params:{
            galleryIdx: galleryIdx,
            }
        })
        .then((res) => {
            commentList.value = res.data;
        })
        .catch(() => {
            console.log('getCommentList 에러 발생')
        })
    }

    const registComment = function (commentGallery) {
        axios({
            url: API_URL_COMMENT,
            method: 'POST',
            data: {
                galleryIdx : commentGallery.galleryIdx,
                content : commentGallery.content,
                writer : commentGallery.writer,
            }
        })
        .then((res)=>{
            alert("댓글이 등록되었습니다.")
            router.push({name:'GalleryCommentList'})
        })
        .catch((err)=>{
            console.log('regist-cmt error 발생')
        })
   }

    const editComment = function (commentGallery) {
        axios({
            url: API_URL_COMMENT,
            method: 'PUT',
            data: commentGallery
        })
        .then((res)=>{
            alert('댓글이 수정되었습니다.')
            router.push({name: 'GalleryCommentList'})
        })
        .catch((err)=>{
            console.log('edit-cmt error 발생')
        })
    }

    const deleteComment = function (commentIdx) {
        console.log(commentIdx)
        axios({
            url: API_URL_COMMENT,
            method: 'DELETE',
            params:{
                commentIdx : commentIdx,
            }
        })
        .then((res)=>{
            alert('댓글이 삭제되었습니다.')  
            window.location.reload();
        })
        .catch((err)=>{
            console.log('delete-cmt error 발생')
        })
   }

   const clear = function () {
    galleryList.value = null;
   }

 
   return {galleryList, gallery, commentList, comment, 
    getGalleryList, getGallery, registGallery, editGallery, deleteGallery, 
    getCommentList, registComment, editComment, deleteComment, clear}
}) 