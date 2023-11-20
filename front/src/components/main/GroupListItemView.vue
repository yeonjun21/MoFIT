<template>
    <div @click="goGroup(group.groupId)">
        <div class="first-container">
            <div v-if="route.path === '/my-group'" class="badge-container">
                <GroupListItemBadge :group="group"/>
            </div>
            <div class="group-profile-img">
                <img class="profile" :src="group.img" alt="img">
            </div>
            <div class="second-container">
                <p class="group-name">{{ group.groupName }}</p>
                <p>운동 종목 : 
                    <span style="font-size: 13px" class="badge rounded-pill text-bg-primary">{{ group.type }}</span>
                </p>
                <p>활동 지역 : 
                    <span v-for="region in group.regions"
                        class="badge rounded-pill text-bg-light">{{ region }}</span>
                </p>
            </div>
        </div>
    </div>
</template>

<script setup>
import { useRouter, useRoute } from 'vue-router';
import GroupListItemBadge from './GroupListItemBadge.vue';

const router = useRouter();
const route = useRoute();

defineProps({
    group: Object
})

const goGroup = function(groupId) {
    router.push('/group/' + groupId);
}
</script>

<style scoped>
.first-container {
    position: relative;
    width: 100%;
    display: flex;
    border-radius: 10px;
    padding: 13px;
    box-shadow: 0px 0px 5px rgb(170, 170, 170);
}

.second-container {
    width: 350px;
    margin-left: 20px;
    display: flex;
    flex-direction: column;
    justify-content: center;
}
.group-profile-img {
    width: 100px;
    height: 100px;
    border-radius: 10px;
}

p {
    margin: 0;
}

.group-name {
    font-size: 19px;
    font-weight: 600;
    margin-bottom: 10px;
}

.badge-container {
    position: absolute;
    right: -30px;
    top: -10px;
    z-index: 1;
}

.profile {
    width: 100%;
    height: 100%;
    object-fit: cover;
    border-radius: 10px;
}
</style>