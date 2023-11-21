import { createRouter, createWebHistory } from 'vue-router'
import MainView from '@/views/MainView.vue'
import LoginForm from '@/components/user/LoginForm.vue'
import SignupForm from '@/components/user/SignupForm.vue'
import GroupListView from '@/components/main/GroupListView.vue'
import GroupAddForm from '@/components/main/GroupAddForm.vue'
import MyGroupListView from '@/components/main/MyGroupListView.vue'
import GroupView from '@/views/GroupView.vue'
import GroupHomeView from '@/components/group/GroupHomeView.vue'
import GroupNoticeView from '@/components/group/GroupNoticeView.vue'
import GroupBoardView from '@/components/group/GroupBoardView.vue'
import GroupGalleryView from '@/components/group/GroupGalleryView.vue'
import GroupVideoView from '@/components/group/GroupVideoView.vue'
import GroupSpecialView from '@/components/group/GroupSpecialView.vue'
import BoardDetailView from '@/components/group/board/BoardDetailView.vue'
import BoardListView from '@/components/group/board/BoardListView.vue'
import BoardEditView from '@/components/group/board/BoardEditView.vue'
import BoardRegistView from '@/components/group/board/BoardRegistView.vue'
import CommentListView from '@/components/group/board/CommentListView.vue'
import CommentRegistView from '@/components/group/board/CommentRegistView.vue'
import CommentEditView from '@/components/group/board/CommentEditView.vue'

import NoticeDetailView from '@/components/group/notice/NoticeDetailView.vue'
import NoticeListView from '@/components/group/notice/NoticeListView.vue'
import NoticeEditView from '@/components/group/notice/NoticeEditView.vue'
import NoticeRegistView from '@/components/group/notice/NoticeRegistView.vue'
import NoticeCommentListView from '@/components/group/notice/NoticeCommentListView.vue'
import NoticeCommentRegistView from '@/components/group/notice/NoticeCommentRegistView.vue'
import NoticeCommentEditView from '@/components/group/notice/NoticeCommentEditView.vue'

import VideoListView from '@/components/group/video/VideoListView.vue';
import VideoDetailView from '@/components/group/video/VideoDetailView.vue';

import GroupMemberView from '@/components/group/GroupMemberView.vue'
import MemberListView from '@/components/group/member/MemberListView.vue';

import GalleryDetailView from '@/components/group/gallery/GalleryDetailView.vue'
import GalleryListView from '@/components/group/gallery/GalleryListView.vue'
import GalleryEditView from '@/components/group/gallery/GalleryEditView.vue'
import GalleryRegistView from '@/components/group/gallery/GalleryRegistView.vue'
import GalleryCommentListView from '@/components/group/gallery/GalleryCommentListView.vue'
import GalleryCommentRegistView from '@/components/group/gallery/GalleryCommentRegistView.vue'
import GalleryCommentEditView from '@/components/group/gallery/GalleryCommentEditView.vue'

import MyPageView from '@/views/MyPageView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Main',
      component: MainView,
      children: [
        {
          path: '',
          name: 'GroupList',
          component: GroupListView
        },
        {
          path: 'add',
          name: 'GroupAdd',
          component: GroupAddForm
        },
        {
          path: 'my-group',
          name: 'MyGroup',
          component: MyGroupListView
        },
      ]
    },
    {
      path: '/user',
      children: [
        {
          path: 'login',
          name: 'LoginForm',
          component: LoginForm
        },
        {
          path: 'signup',
          name: 'SignupForm',
          component: SignupForm
        },
      ]
    },
    {
      path: '/group/:groupId',
      name: 'Group',
      component: GroupView,
      children: [
        {
          path: '',
          name: 'GroupHome',
          component: GroupHomeView
        },
        {
          path: 'notice',
          name: 'GroupNotice',
          component: GroupNoticeView,
          children: [
            {
              path: '',
              name: 'NoticeList',
              component: NoticeListView,
            },
            {
              path: 'detail/:index',
              name: 'NoticeDetail',
              component: NoticeDetailView,
              children: [
                {
                  path: '',
                  name: 'NoticeCommentList',
                  component: NoticeCommentListView,
                },
                {
                  path: 'cmtRegist',
                  name: 'NoticeCommentRegist',
                  component: NoticeCommentRegistView,
                },
                {
                  path: 'cmtEdit/:commentIdx',
                  name: 'NoticeCommentEdit',
                  component: NoticeCommentEditView,
                },
              ]
            },
            {
              path: 'edit',
              name: 'NoticeEdit',
              component: NoticeEditView,
            },
            {
              path: 'regist',
              name: 'NoticeRegist',
              component: NoticeRegistView,
            }
          ]
        },
        {
          path: 'board',
          name: 'GroupBoard',
          component: GroupBoardView,
          children: [
            {
              path: '',
              name: 'BoardList',
              component: BoardListView,
            },
            {
              path: 'detail/:index',
              name: 'BoardDetail',
              component: BoardDetailView,
              children: [
                {
                  path: '',
                  name: 'CommentList',
                  component: CommentListView,
                },
                {
                  path: 'cmtRegist',
                  name: 'CommentRegist',
                  component: CommentRegistView,
                },
                {
                  path: 'cmtEdit/:commentIdx',
                  name: 'CommentEdit',
                  component: CommentEditView,
                },
              ]
            },
            {
              path: 'edit',
              name: 'BoardEdit',
              component: BoardEditView,
            },
            {
              path: 'regist',
              name: 'BoardRegist',
              component: BoardRegistView,
            }
          ]
        },
        {
          path: 'gallery',
          name: 'GroupGallery',
          component: GroupGalleryView,
          children: [
            {
              path: '',
              name: 'GalleryList',
              component: GalleryListView,
            },
            {
              path: 'detail/:index',
              name: 'GalleryDetail',
              component: GalleryDetailView,
              children: [
                {
                  path: '',
                  name: 'GalleryCommentList',
                  component: GalleryCommentListView,
                },
                {
                  path: 'cmtRegist',
                  name: 'GalleryCommentRegist',
                  component: GalleryCommentRegistView,
                },
                {
                  path: 'cmtEdit/:commentIdx',
                  name: 'GalleryCommentEdit',
                  component: GalleryCommentEditView,
                },
              ]
            },
            {
              path: 'edit',
              name: 'GalleryEdit',
              component: GalleryEditView,
            },
            {
              path: 'regist',
              name: 'GalleryRegist',
              component: GalleryRegistView,
            }
          ]
        },
        {
          path: 'video',
          name: 'GroupVideo',
          component: GroupVideoView,
          children: [
            {
              path: '',
              name: 'VideoList',
              component: VideoListView
            },
            {
              path: 'detail',
              name: 'VideoDetail',
              component: VideoDetailView
            }
          ]
        },
        {
          path: 'special',
          name: 'GroupSpecial',
          component: GroupSpecialView
        },
        {
          path: 'member',
          name: 'GroupMember',
          component: GroupMemberView,
        }
      ]
    },
    {
      path: '/my-page',
      name: 'MyPage',
      component: MyPageView
    }
  ]
})

export default router
