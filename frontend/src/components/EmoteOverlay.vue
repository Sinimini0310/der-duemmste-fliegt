<template>
  <div class="emote-container">
    <transition-group name="emote" tag="div">
      <div v-for="(e, i) in emotes" :key="i" class="emote">{{ e }}</div>
    </transition-group>
  </div>
</template>

<script setup>
import { ref } from 'vue'
const emotes = ref([])
function addEmote(e) {
  emotes.value.push(e)
  setTimeout(() => emotes.value.shift(), 1000)
}
defineExpose({ addEmote })
</script>

<style scoped>
.emote-container {
  position: fixed;
  bottom: 10px;
  right: 10px;
}
.emote-enter-active,
.emote-leave-active {
  transition: all 1s;
}
.emote-enter-from,
.emote-leave-to {
  opacity: 0;
  transform: translateY(20px);
}
.emote {
  font-size: 2rem;
}
</style>

