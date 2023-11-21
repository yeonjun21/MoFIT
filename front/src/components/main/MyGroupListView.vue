<template>
    <div>
        <NeedLoginView v-if="!userStore.loginUser"/>
        <div v-else class="container">
            <h3>내가 가입한 모임입니다 😊</h3>
            <div class="group-container">
                <GroupListItemView class="group"
                    v-for="group in groupStore.myGroupList" :group="group"/>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useGroupStore } from '@/stores/group.js'
import { useUserStore } from '@/stores/user.js'
import { onMounted } from 'vue';
import GroupListItemView from '@/components/main/GroupListItemView.vue'
import { useRouter } from 'vue-router';
import NeedLoginView from '@/components/common/NeedLoginView.vue';;

const groupStore = useGroupStore();
const userStore = useUserStore();
const router = useRouter();

onMounted(() => {
    groupStore.clearGroupList();
    groupStore.getMyGroupList(sessionStorage.getItem('loginUser'));
})
</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.group-container {
    margin-top: 30px;
}

.group {
    margin: 40px;
}
</style>