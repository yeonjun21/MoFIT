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
            })
            .catch(() => {
                console.log('getGroup 에러');
            })
    }

    const addGroup = function(group) {
        console.log(group);
        
        axios.post(API_URL, group)
            .then((res) => {
                console.log('addGroup 성공!');
            })
            .catch(() => {
                console.log('addGroup 에러')
            })

    }

    const groupNameDuplicationCheck = function(groupName) {
        return new Promise((resolve, reject) => {
            axios({
                url: API_URL + 'groupNameCheck',
                method: 'GET',
                params: {
                    groupName: groupName
                }
            })
                .then(() => {
                    resolve(true);
                })
                .catch(() => {
                    reject(false);
                })
        })
    }


    return { group, groupList, regionList, typeList,
            getAllRegion, getTypes, getGroupList, getGroup,
            addGroup, groupNameDuplicationCheck }
})
