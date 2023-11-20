<template>
    <div>
        <iframe
            width="650"
            height="365"
            :src="videoURL"
            title="YouTube video player"
            frameborder="0"
            allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
            allowfullscreen>
        </iframe>
    </div>
</template>

<script setup>
defineProps({
    videoURL: String,
})
</script>

<style scoped>
iframe {
  margin: 20px 0;
}
</style>