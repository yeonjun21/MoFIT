<template>
    <div class="item-container">
        <a :href="item.link" target="_blank"><img :src="item.image"></a>
        <div class="info">
            <p class="title"><span v-html="item.title"></span></p>
            <p class="price badge text-bg-light">최저가<span v-html="'₩ ' + item.lprice"></span></p>
        </div>
    </div>
</template>

<script setup>
defineProps({
    item: Object
})
</script>

<style scoped>
.item-container {
    width: 180px;
    box-shadow: 0px 0px 3px rgb(180, 180, 180);
    padding: 10px;
    border-radius: 10px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: center;
}

img {
    width: 150px;
    height: 150px;
    margin-bottom: 10px;
}

.info {
    width: 150px;
}

.title {
    font-size: 13px;
}

.price {
    display: flex;
    justify-content: space-between;
    margin-bottom: 0;
    font-size: 14px;
}

</style>