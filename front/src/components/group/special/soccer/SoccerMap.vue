<template>
    <div class="outter">
        <div v-for="(region, i) in groupStore.group.regions" :key="region[i]">
            <div class="map">
                <span class="badge rounded-pill bg-light text-dark" >{{ region }}</span>
                <span>근처 축구장 ⚽</span>
                <div :id="mapIndex[i]"></div>
            </div>
        </div>
    </div>
</template>

<script setup>
import { onMounted, ref, toRaw } from 'vue';
import { useGroupStore } from '@/stores/group.js';

const groupStore = useGroupStore();
const mapIndex = ref(['map1', 'map2', 'map3']);

let map1 = null;
let map2 = null;
let map3 = null;
// 작성전에 index.html 헤더에 api-key를 이용해 요청하는 script 작성
const initMap1 = function () {
    console.log('init map 1')
    const region = groupStore.group.regions[0];
    let typeName = '';

    if(groupStore.group.type == '러닝'){
        typeName = ' 공원';
    }else if(groupStore.group.type == '축구'){
        console.log("ggggggg")
        typeName = ' 풋살장';
    }else{
        return;
    }
    
    let myCenter = new kakao.maps.LatLng(33.450701, 126.570667); //카카오본사
    const container1= document.getElementById('map1');
    const options1 = {
        center: myCenter,
        level: 3,
    }; // 지도 객체를 등록합니다.

    map1 = new kakao.maps.Map(container1, options1);

    // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성
    const zoomControl1 = new kakao.maps.ZoomControl();
    map1.addControl(zoomControl1, kakao.maps.ControlPosition.RIGHT);

    //장소 검색 객체를 생성, regionName에 담긴 값을 가져온다.
    const ps1 = new kakao.maps.services.Places();
    ps1.keywordSearch(region+typeName, (...params) => placesSearchCB(...params, map1));
};

const initMap2 = function () {
    const region = groupStore.group.regions[1];
    let typeName = '';
    if(groupStore.group.type == '러닝'){
        typeName = ' 공원';
    }else if(groupStore.group.type == '축구'){
        typeName = ' 풋살장';
    }else{
        return;
    }

    let myCenter = new kakao.maps.LatLng(33.450701, 126.570667); //카카오본사
    const container2= document.getElementById('map2');
    const options2 = {
        center: myCenter,
        level: 3,
    }; // 지도 객체를 등록합니다.

    map2 = new kakao.maps.Map(container2, options2);

    // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성
    const zoomControl2 = new kakao.maps.ZoomControl();
    map2.addControl(zoomControl2, kakao.maps.ControlPosition.RIGHT);

    //장소 검색 객체를 생성, regionName에 담긴 값을 가져온다.
    const ps2 = new kakao.maps.services.Places();
    ps2.keywordSearch(region+typeName, (...params) => placesSearchCB(...params, map2));
};


const initMap3 = function () {
    const region = groupStore.group.regions[2];
    let typeName = '';
    if(groupStore.group.type == '러닝'){
        typeName = ' 공원';
    }else if(groupStore.group.type == '축구'){
        typeName = ' 풋살장';
    }else{
        return;
    }

    let myCenter = new kakao.maps.LatLng(33.450701, 126.570667); //카카오본사
    const container3= document.getElementById('map3');
    const options3 = {
        center: myCenter,
        level: 3,
    }; // 지도 객체를 등록합니다.

    map3 = new kakao.maps.Map(container3, options3);

    // 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성
    const zoomControl3 = new kakao.maps.ZoomControl();
    map3.addControl(zoomControl3, kakao.maps.ControlPosition.RIGHT);

    //장소 검색 객체를 생성, regionName에 담긴 값을 가져온다.
    const ps3 = new kakao.maps.services.Places();
    ps3.keywordSearch(region+typeName, (...params) => placesSearchCB(...params, map3));
};

onMounted(() => {
    console.log(window.kakao);
    console.log(window.kakao.maps);
    initMap1();
    if(groupStore.group.regions.length>1) initMap2();
    if(groupStore.group.regions.length>2) initMap3();
});


const infowindow = new kakao.maps.InfoWindow({ zIndex: 1 }); //마커 클릭시 장소명 표출

const placesSearchCB = function (data, status, pagination, map) {
    console.log(map)
    if (status == kakao.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가
        var bounds = new kakao.maps.LatLngBounds();

        for (var i = 0; i < data.length; i++) {
            displayMarker(data[i], map);
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
        }

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정
        map.setBounds(bounds);
    }
}

const displayMarker = function (place, map) {

    // 마커를 생성하고 지도에 표시
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x)
    });

    // 마커에 클릭이벤트를 등록
    kakao.maps.event.addListener(marker, 'click', function () {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
        infowindow.open(map, marker);
    });
}


</script>
  
<style scoped>


#map1 {
    width: 700px;
    height: 450px;
    box-shadow: 0px 0px 8px rgb(170, 170, 170);
}

#map2 {
    width: 700px;
    height: 450px;
    box-shadow: 0px 0px 8px rgb(170, 170, 170);
}

#map3 {
    width: 700px;
    height: 450px;
    box-shadow: 0px 0px 8px rgb(170, 170, 170);
}

.map{
    text-align: center;
    margin-bottom: 100px;
}

.badge {
    margin-bottom: 20px;
    font-size: 21px;
    margin-right: 5px;
}

.outter {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
</style>
  