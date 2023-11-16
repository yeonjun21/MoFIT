<template>
    <div class="container">
        <h3>운동 모임을 만들어보세요 😃</h3>

        <div class="form">
            <div class="mb-3">
                <label for="groupName" class="form-label">모임 이름</label>
                <div class="input-container">
                    <input type="text" class="form-control" id="groupName" 
                        v-model="groupName" placeholder="예) 모핏과 즐겁게 운동하기">
                    <button @click="groupNameDuplicationCheck" class="check-button">중복확인</button>
                </div>
                <p v-if="groupNameError" class="input-error">이메일 형식을 다시 확인해주세요.</p>
            </div>

            <label for="type" class="form-label">운동 종목</label>
            <select class="form-select" aria-label="Default select example" id="type" 
                v-model="type">
                <option selected>모임의 운동 종목을 선택해주세요.</option>
                <option v-for="type in store.typeList" :value="type">{{ type }}</option>
            </select>

            <label for="region" class="form-label">활동 지역</label>
            <div class="form-container" id="region">
                <div class="form-check" v-for="region in store.regionList">
                    <input class="form-check-input" type="checkbox" :value="region" id="flexCheckDefault">
                    <label class="form-check-label" for="flexCheckDefault">
                        {{ region }}
                    </label>
                </div>
            </div>

            <div class="mb-3">
                <label for="info" class="form-label">모임 소개글</label>
                <textarea class="form-control" id="info" rows="3" placeholder="최대 300자 입력 가능"></textarea>
            </div>
        </div>
        <button @click="signup" class="btn btn-primary">모임 만들기</button>

    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useGroupStore } from '@/stores/group';

const store = useGroupStore();

const groupName = ref('');
const type = ref('');
const region = ref([]);
const info = ref('');


onMounted(() => {
    store.getTypes();
    store.getAllRegions();
})

</script>

<style scoped>



.form-container {
    display: flex;
    flex-direction: row;

}

.form-check {
    display: inline;
}
</style>