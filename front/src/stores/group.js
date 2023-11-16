import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { useRouter } from 'vue-router';
import axios from 'axios';

export const useGroupStore = defineStore('group', () => {
    const API_URL = 'http://localhost:8080/group/';

    const router = useRouter();

    const group = ref({});
    const groupList = ref([]);

    const regionList = ref([]);
    const typeList = ref([]);

    const getAllRegion = function() {
        axios.get(API_URL + 'regions')
            .then((res) => {
                regionList.value = res.data;
            })
            .catch(() => {
                console.log('getAllRegion 에러');
            })
    }

    const getTypes = function() {
        axios.get(API_URL + 'types')
            .then((res) => {
                typeList.value = res.data;
                console.log(typeList.value);
            })
            .catch(() => {
                console.log('getTypes 에러');
            })
    }

    const getGroupList = function(region) {
        axios({
            url: API_URL + 'list',
            method: 'GET',
            params: {
                region: region,
            }
        })
            .then((res) => {
                groupList.value = res.data;
            })
            .catch(() => {
                console.log('getGroupList 에러');
            })
    }

    const getGroup = function(groupId) {
        axios.get(API_URL + groupId)
            .then((res) => {
                group.value = res.data;
                console.log(res.data);
            })
            .catch(() => {
                console.log('getGroup 에러');
            })
    }


    return { group, groupList, regionList, typeList,
            getAllRegion, getTypes, getGroupList, getGroup }
})
