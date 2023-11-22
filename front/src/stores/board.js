import { ref } from 'vue'
import { defineStore } from 'pinia'
import { useRoute,useRouter } from 'vue-router';
import axios from 'axios';

export const useBoardStore = defineStore('board', () => {

   const API_URL_BOARD = 'http://localhost:8080/board';
   const API_URL_COMMENT = 'http://localhost:8080/board/comment';

   const route = useRoute();
   const router = useRouter();

   const boardList = ref([]);
   const board = ref({});

   const commentList = ref([]);
   const comment = ref({});

   const getBoardList = function (groupId) {
       axios({
           url: API_URL_BOARD,
           method: 'GET',
           params:{
            groupId: groupId,
           }
       })
       .then((res) => {
            boardList.value = res.data;
       })
       .catch(() => {
           console.log('getBoardList 에러 발생')
       })
   };

   const getBoard = function (index) {
       axios({
           url: API_URL_BOARD + '/' + index,
           method: 'GET'
       })
       .then((res) => {
            board.value = res.data;
       })
       .catch(() => {
            console.log('getBoard error 발생')
       })
   };

   const registBoard = function (board) {
        axios({
            url: API_URL_BOARD,
            method: 'POST',
            data: {
                groupId : board.groupId,
                content : board.content,
                writer : board.writer,
            }
        })
        .then((res)=>{
            alert("게시글이 등록되었습니다.");
            router.push({name: 'BoardList'})
        })
        .catch((err)=>{
            console.log('registBoard error 발생')
        })
   };

   const editBoard = function (board) {
        axios({
            url: API_URL_BOARD,
            method: 'PUT',
            data: board
        })
        .then((res)=>{
            alert('게시글이 수정되었습니다.');
            router.push({name:'CommentList', params:{index: board.index}})
        })
        .catch((err)=>{
            console.log('edit error 발생')
        })
    };

   const deleteBoard = function (index) {
        axios({
            url: API_URL_BOARD,
            method: 'DELETE',
            params:{
                index : index,
            }
        })
        .then((res)=>{
            alert('게시글이 삭제되었습니다.');
            router.push({name: 'BoardList'})
        })
        .catch((err)=>{
            console.log('deleteBoard error 발생')
        })
   }

   const getCommentList = function (boardIdx) {
        console.log(boardIdx) 
        axios({
            url: API_URL_COMMENT,
            method: 'GET',
            params:{
            boardIdx: boardIdx,
            }
        })
        .then((res) => {
            commentList.value = res.data;
        })
        .catch(() => {
            console.log('getCommentList 에러 발생')
        })
    }

    const registComment = function (commentBoard) {
        axios({
            url: API_URL_COMMENT,
            method: 'POST',
            data: {
                boardIdx : commentBoard.boardIdx,
                content : commentBoard.content,
                writer : commentBoard.writer,
            }
        })
        .then((res)=>{
            alert("댓글이 등록되었습니다.")
            router.push({name:'CommentList'})
        })
        .catch((err)=>{
            console.log('regist-cmt error 발생')
        })
   }

    const editComment = function (commentBoard) {
        axios({
            url: API_URL_COMMENT,
            method: 'PUT',
            data: commentBoard
        })
        .then((res)=>{
            alert('댓글이 수정되었습니다.')
            router.push({name: 'CommentList'})
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
    boardList.value = null;
   }

 
   return {boardList, board, commentList, comment, 
    getBoardList, getBoard, registBoard, editBoard, deleteBoard, 
    getCommentList, registComment, editComment, deleteComment, clear}
})