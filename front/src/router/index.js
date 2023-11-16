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
          path: 'myGroup',
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
          component: GroupNoticeView
        },
        {
          path: 'board',
          name: 'GroupBoard',
          component: GroupBoardView
        },
        {
          path: 'gallery',
          name: 'GroupGallery',
          component: GroupGalleryView
        },
        {
          path: 'video',
          name: 'GroupVideo',
          component: GroupVideoView
        },
        {
          path: 'special',
          name: 'GroupSpecial',
          component: GroupSpecialView
        },
        
      ]
    }
  ]
})

export default router
