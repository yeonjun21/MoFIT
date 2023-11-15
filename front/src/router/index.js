import { createRouter, createWebHistory } from 'vue-router'
import MainView from '@/views/MainView.vue'
import LoginForm from '@/components/user/LoginForm.vue'
import SignupForm from '@/components/user/SignupForm.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Main',
      component: MainView
    },
    {
      path: '/user/login',
      name: 'LoginForm',
      component: LoginForm
    },
    {
      path: '/user/signup',
      name: 'SignupForm',
      component: SignupForm
    },
  ]
})

export default router
