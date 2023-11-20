<template>
    <div>
        <div class="container">
            <div v-for="member in store.memberList" :key="member.userId" class="member">
                <MemberListItemView :member="member" class="member"/>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useGroupStore } from '@/stores/group.js'
import MemberListItemView from '@/components/group/member/MemberListItemView.vue'
import { onMounted } from 'vue';

const store = useGroupStore();

onMounted(() => {
    store.getMemberList(store.group.groupId);
})

</script>

<style scoped>
.container {
    width: 700px;
    display: flex;
    align-items: flex-start;
    flex-wrap: wrap;
}

.member {
    width: 300px;
    margin-bottom: 7px;
    margin-right: 10px;
}
</style>