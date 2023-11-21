<template>
    <div class="container">
        <h2>{{ store.group.groupName }}</h2>
        <GroupMenuNav/>
        <RouterView class="view" :isMember="isMember" @join="join"/>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useGroupStore } from '@/stores/group.js';
import { useRoute } from 'vue-router';
import GroupMenuNav from '@/components/common/GroupMenuNav.vue'

const store = useGroupStore();
const route = useRoute();

const isMember = ref(false);

const memberCheck = function () {
    store.getMyGroupList(sessionStorage.getItem('loginUser'))
        .then(()=>{
            for (let group of store.myGroupList) {
                if (group.groupId == route.params.groupId) {
                    isMember.value = true;
                }
            }
        })
        .catch(() => {
        });
}

const join = function() {
    const result = confirm('모임에 가입하시겠어요?');
    
    if (result) {
        store.join(store.group.groupId, sessionStorage.getItem('loginUser'));
        isMember.value = true;
    }
}

onMounted(() => {
    store.getGroup(route.params.groupId);
    memberCheck();
})


</script>

<style scoped>
.container {
    width: 1000px;
}

h2 {
    font-size: 40px;
    font-weight: 700;
    margin: 50px 10px 50px 50px;
}

.view {
    margin: 70px 40px;
}
</style>