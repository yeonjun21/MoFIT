<template>
    <div>
        <p>닉네임 <span>{{ user.nickname }}</span>으로 활동 중 :)</p>
        <p>{{ user.name }} ({{ user.email }})</p>
    </div>
</template>

<script setup>
defineProps({
    user: Object
})
</script>

<style scoped>
span {
    font-weight: 600;
}

</style>