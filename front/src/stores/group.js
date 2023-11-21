import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import { useRouter } from 'vue-router';
import axios from 'axios';

export const useGroupStore = defineStore('group', () => {
    const API_URL = 'http://localhost:8080/group';

    const router = useRouter();

    const group = ref({});
    const groupList = ref([]);
    const myGroupList = ref([]);

    const regionList = ref([]);
    const typeList = ref([]);

    const memberList = ref([]);

    const getAllRegion = function() {
        axios.get(API_URL + '/regions')
            .then((res) => {
                regionList.value = res.data;
            })
            .catch(() => {
                console.log('getAllRegion 에러');
            })
    }

    const getTypes = function() {
        axios.get(API_URL + '/types')
            .then((res) => {
                typeList.value = res.data;
            })
            .catch(() => {
                console.log('getTypes 에러');
            })
    }

    const getGroupList = function(region) {
        axios({
            url: API_URL + '/list',
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

    const getMyGroupList = function(id) {
        axios({
            url: 'http://localhost:8080/user/' + id + '/group',
            method: 'GET',
        })
            .then((res) => {
                myGroupList.value = res.data;
            })
            .catch(() => {
                console.log('getMyGroupList 에러');
            })
    }

    const getGroup = function(groupId) {
        axios.get(API_URL + '/' + groupId)
            .then((res) => {
                group.value = res.data;
            })
            .catch(() => {
                console.log('getGroup 에러');
            })
    }

    const addGroup = function(group) {
        axios.post(API_URL, group)
            .then((res) => {
                console.log('addGroup 성공!');
                alert('운동 모임이 성공적으로 만들어졌습니다!');
            })
            .catch((err) => {
                console.log(err.data);
                console.log('addGroup 에러')
            })

    }

    const groupNameDuplicationCheck = function(groupName) {
        return new Promise((resolve, reject) => {
            axios({
                url: API_URL + '/groupNameCheck',
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

    const clearGroupList = function() {
        this.groupList = null;
    }

    const getMemberList = function(groupId) {
        axios({
            url: API_URL + '/' + groupId +'/member',
            method: 'GET',
            params: {
                groupId: groupId
            }
        })
            .then((res) => {
                memberList.value = res.data;
            })
            .catch(() => {
                console.log('getMemberList 에러');
            })
    }

    const join = function(groupId, userId) {
        axios({
            url: API_URL + '/' + groupId + '/member',
            method: 'POST',
            params: {
                userId: userId
            }
        })
            .then(() => {
                alert('모임에 가입되었습니다.');
            })
            .catch(() => {
                console.log('join 에러');
            })
    }


    return { group, groupList, myGroupList,regionList, typeList, memberList,
            getAllRegion, getTypes, getGroupList, getMyGroupList, getGroup,
            addGroup, groupNameDuplicationCheck, clearGroupList, getMemberList, join }
})
