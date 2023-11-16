<template>
    <div class="container">
        <h3>우리동네를 선택하세요.</h3>
        <div class="region-list">
            <button type="button" class="btn btn-outline-primary"
            v-for="region in store.regionList"
            @click="selectRegion(region)">{{ region }}</button>
        </div>
        <div class="group-container">
            <GroupListItemView class="group"
                v-for="group in store.groupList" :group="group"/>
        </div>
    </div>
</template>

<script setup>
import { useGroupStore } from '@/stores/group.js'
import { onMounted } from 'vue';
import GroupListItemView from '@/components/main/GroupListItemView.vue'

const store = useGroupStore();

const selectRegion = function(region) {
    store.getGroupList(region);
}

onMounted(() => {
    store.getAllRegion();
})

</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.region-list {
    margin: 20px 0 50px;
    width: 600px;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
}
.btn {
    margin: 3px;
}

.group-container {
    margin: 30px 0 20px;
}

.group {
    margin: 40px;
}
</style>