<template>
    <div>
        <NeedLoginView v-if="!userStore.loginUser"/>
        <div v-else class="container">
            <h3>운동 모임을 만들어보세요 😃</h3>

            <div class="form">
                <div class="mb-3">
                    <label for="groupName" class="form-label">모임 이름</label>
                    <input type="text" class="form-control" id="groupName" 
                        v-model="groupName" placeholder="모임 이름은 20자 이하여야 합니다.">
                    <p v-if="groupNameError" class="input-error">이미 사용 중이거나 잘못된 모임 이름입니다.</p>
                </div>

                <div class="mb-3">
                    <label for="type" class="form-label">운동 종목</label>
                    <select class="form-select" aria-label="Default select example" id="type" 
                        v-model="type">
                        <option selected>모임의 운동 종목을 선택해주세요.</option>
                        <option v-for="t in store.typeList" :value="t">{{ t }}</option>
                    </select>
                    <p v-if="typeError" class="input-error">모임의 운동 종목을 선택해주세요.</p>
                </div>

                <div class="mb-3">
                    <label class="form-label">활동 지역</label>
                    <div class="check-container">
                        <div class="form-check" v-for="(region, index) in store.regionList">
                            <input class="form-check-input" type="checkbox" :id="`checkbox${index}`" 
                                v-model="regions" :value="region">
                            <label class="form-check-label" :for="`checkbox${index}`">
                                {{ region }}
                            </label>
                        </div>
                    </div>
                    <p v-if="regionsError" class="input-error">활동 지역을 1개 이상 선택해주세요.</p>
                </div>

                <div class="mb-3">
                    <label for="info" class="form-label">모임 소개글</label>
                    <textarea class="form-control" id="info" rows="3" 
                        v-model="info" placeholder="최대 300자 입력 가능"></textarea>
                        <p v-if="infoError" class="input-error">모임 소개글은 반드시 입력해야 하며, 최대 300자까지 입력 가능합니다.</p>
                </div>

                <div class="mb-3">
                    <label for="img" class="form-label">모임 대표 사진</label>
                    <input type="file" @change="handleFileChange" id="img" class="form-control"/>
                    <div v-if="base64Data" style="margin-top: 10px;">
                        <img :src="base64Data" alt="Uploaded Image" />
                    </div>
                </div>

            </div>
            <button @click="addGroup" class="btn btn-primary">모임 만들기</button>

        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useGroupStore } from '@/stores/group';
import { useUserStore } from '@/stores/user'
import NeedLoginView from '@/components/common/NeedLoginView.vue';

const store = useGroupStore();
const userStore = useUserStore();

const groupName = ref('');
const type = ref('');
const regions = ref([]);
const info = ref('');
const leaderId = sessionStorage.getItem("loginUser");

const groupNameError = ref(false);
const typeError = ref(false);
const regionsError = ref(false);
const infoError = ref(false);

const selectedFile = ref(null);
const base64Data = ref(null);

const handleFileChange = (event) => {
  selectedFile.value = event.target.files[0];
  const reader = new FileReader();
    reader.onload = () => {
    base64Data.value = reader.result;
  };
  reader.readAsDataURL(selectedFile.value);
};

const groupNameCheck = function() {
    return new Promise((resolve, reject) => {
        const check = new Promise((resolve, reject) => {
            if (!groupName.value || groupName.value.length > 20) {
                groupNameError.value = true;
                reject();
            } else {
                resolve();
            }
        }).then(() => {
                store.groupNameDuplicationCheck(groupName.value)
                .then(() => {
                    groupNameError.value = false;
                    resolve();
                })
                .catch(() => {
                    groupNameError.value = true;
                    reject();
                })
            }).catch(() => {
            })
    })
}

const typeCheck = function() {
    if (!type.value || type.value === '모임의 운동 종목을 선택해주세요.') {
        typeError.value = true;
        return false;
    } else {
        typeError.value = false;
        return true;
    }
}

const regionsCheck = function() {
    if (regions.value.length === 0) {
        regionsError.value = true;
        return false;
    } else {
        regionsError.value = false;
        return true;
    }
}

const infoCheck = function() {
    if (!info.value || info.value.length > 300) {
        infoError.value = true;
        return false;
    } else {
        infoError.value = false;
        return true;
    }
}

const addGroup = function() {
    groupNameCheck().then(() => {
        if (typeCheck() && regionsCheck() && infoCheck()) {
            const group = {
                groupName: groupName.value,
                type: type.value,
                regions: regions.value,
                info: info.value,
                leaderId: leaderId,
                img: base64Data.value
            }
            store.addGroup(group);
        }
    }).catch(() => {
    })
}

onMounted(() => {
    store.getTypes();
    store.getAllRegion();
})
</script>

<style scoped>
.container {
    width: 500px;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.form {
    margin: 50px 0 20px;
}

.check-container {
    display: flex;
    flex-wrap: wrap;
}

.form-check {
    margin-right: 10px;
}

.input-container {
    display: flex;
}

.check-button {
    font-size: 13px;
    margin-left: 10px;
    border-radius: 10px;
    border: transparent;
    background-color: rgb(222, 236, 255);
}

.input-error {
    font-size: 13px;
    color: red;
}

.btn {
    display: block;
    width: 100%;
    margin: 0 auto;
}

img {
    width: 300px;
    height: 150px;
    object-fit: scale-down;
    object-position: left;
}
</style>