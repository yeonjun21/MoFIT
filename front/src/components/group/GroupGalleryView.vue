<template>
    <div class="gallery">
        <h3>Gallery</h3>
        <div>
            <RouterView/>
        </div>
    </div>
</template>

<script setup>
</script>

<style scoped>
body {
  margin: 0;
}

#app {
  box-sizing: border-box;
  font-family: "consolas";
  margin-top: 60px;
  width: 100%;
  max-width: 460px;
  margin: auto;
  position: relative;
  border-right: 1px solid #eee;
  border-left: 1px solid #eee;
}
</style>