import { ref } from 'vue'
import { defineStore } from 'pinia'
import { useRoute,useRouter } from 'vue-router';
import axios from 'axios';

export const useNoticeStore = defineStore('notice', () => {

   const API_URL_NOTICE = 'http://localhost:8080/notice';
   const API_URL_COMMENT = 'http://localhost:8080/notice/comment';

   const router = useRouter();

   const noticeList = ref([]);
   const notice = ref({});

   const commentList = ref([]);
   const comment = ref({});

   const getNoticeList = function (groupId) {
       axios({
           url: API_URL_NOTICE,
           method: 'GET',
           params:{
            groupId: groupId,
           }
       })
       .then((res) => {
            noticeList.value = res.data;
       })
       .catch(() => {
           console.log('getNoticeList 에러 발생')
       })
   };

   const getNotice = function (index) {
       axios({
           url: API_URL_NOTICE + '/' + index,
           method: 'GET'
       })
       .then((res) => {
            notice.value = res.data;
       })
       .catch(() => {
            console.log('getNotice error 발생')
       })
   };

   const registNotice = function (notice) {
        axios({
            url: API_URL_NOTICE,
            method: 'POST',
            data: {
                title : notice.title,
                groupId : notice.groupId,
                content : notice.content,
                writer : notice.writer,
            }
        })
        .then((res)=>{
            alert("게시글이 등록되었습니다.")
            router.push({name: 'NoticeList'})
        })
        .catch((err)=>{
            console.log('registNotice error 발생')
        })
   };

   const editNotice = function (notice) {
        axios({
            url: API_URL_NOTICE,
            method: 'PUT',
            data: notice
        })
        .then((res)=>{
            alert('게시글이 수정되었습니다')
            router.push({name:'NoticeCommentList', params:{index: notice.index}})
        })
        .catch((err)=>{
            console.log('edit error 발생')
        })
    };

   const deleteNotice = function (index) {
        axios({
            url: API_URL_NOTICE,
            method: 'DELETE',
            params:{
                index : index,
            }
        })
        .then((res)=>{
            alert('게시글이 삭제되었습니다.')  
            router.push({name: 'NoticeList'})
        })
        .catch((err)=>{
            console.log('deleteNotice error 발생')
        })
   }

   const getCommentList = function (noticeIdx) {
        console.log(noticeIdx) 
        axios({
            url: API_URL_COMMENT,
            method: 'GET',
            params:{
            noticeIdx: noticeIdx,
            }
        })
        .then((res) => {
            commentList.value = res.data;
        })
        .catch(() => {
            console.log('getCommentList 에러 발생')
        })
    }

    const registComment = function (commentNotice) {
        axios({
            url: API_URL_COMMENT,
            method: 'POST',
            data: {
                noticeIdx : commentNotice.noticeIdx,
                content : commentNotice.content,
                writer : commentNotice.writer,
            }
        })
        .then((res)=>{
            alert("댓글이 등록되었습니다.")
            router.push({name:'NoticeCommentList'})
        })
        .catch((err)=>{
            console.log('regist-cmt error 발생')
        })
   }

    const editComment = function (commentNotice) {
        axios({
            url: API_URL_COMMENT,
            method: 'PUT',
            data: commentNotice
        })
        .then((res)=>{
            alert('댓글이 수정되었습니다.')
            router.push({name: 'NoticeCommentList'})
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

   const clear = function() {
    noticeList.value = null;
   }

 
   return {noticeList, notice, commentList, comment, 
    getNoticeList, getNotice, registNotice, editNotice, deleteNotice, 
    getCommentList, registComment, editComment, deleteComment, clear}
})