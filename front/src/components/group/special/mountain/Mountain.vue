<template>
    <div>
        <h3>등산 모임을 위한 <span>등산 장비 쇼핑</span> 기능입니다.</h3>
        <p>상품의 사진을 누르면 네이버 쇼핑의 해당 상품 페이지로 이동합니다.</p>
        <div class="button-container">
            <div class="btn-group" role="group" aria-label="Basic outlined example">
                <button type="button" class="btn btn-outline-primary" 
                    @click="getItems('등산복')">등산복</button>
                <button type="button" class="btn btn-outline-primary"
                    @click="getItems('등산화')">등산화</button>
                <button type="button" class="btn btn-outline-primary"
                    @click="getItems('등산가방')">등산양말</button>
                <button type="button" class="btn btn-outline-primary"
                    @click="getItems('등산가방')">등산가방</button>
                <button type="button" class="btn btn-outline-primary"
                    @click="getItems('등산스틱')">등산스틱</button>
                <button type="button" class="btn btn-outline-primary"
                    @click="getItems('무릎보호대')">무릎 보호대</button>
                <button type="button" class="btn btn-outline-primary"
                    @click="getItems('등산장갑')">등산장갑</button>
                <button type="button" class="btn btn-outline-primary"
                    @click="getItems('에너지바')">에너지바</button>
            </div>
        </div>

        <div class="item-container">
            <MountainItem v-for="item in items" :item="item" class="item"/>
        </div>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';
import MountainItem from '@/components/group/special/mountain/MountainItem.vue'

// const API_URL = 'https://openapi.naver.com/v1/search/shop.json';
const Client_ID = 'SQ3_PcAVIiyYvlWRo2pi';
const Client_Secret = '9TSEscR667';

const items = ref([]);

const getItems = function(keyword) {
    axios({
        url: '/api/v1/search/shop.json',
        method: 'GET',
        params: {
            query: keyword,
            display: 40,
        },
        headers: {
            'X-Naver-Client-Id': Client_ID,
            'X-Naver-Client-Secret': Client_Secret
        }
    })
        .then((res) => {
            console.log(res.data);
            items.value = res.data.items;
        })
        .catch(() => {
            'getItems 에러';
        })
}

onMounted(() => {
    // getItems('등산복');
})

</script>

<style scoped>
h3 {
    margin-bottom: 20px;
}
p {
    margin-bottom: 70px;
}

span {
    font-weight: 700;
    color: #007bff
}

.button-container {
    display: flex;
    justify-content: center;
    margin: 50px;
}

.item-container {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
}

.item {
    margin: 10px;
}

</style>