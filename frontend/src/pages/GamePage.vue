<template>
  <q-page padding class="column q-gutter-md">
    <div v-if="question">{{ question }}</div>
    <q-input v-model="answer" label="Answer" />
    <q-btn label="Submit" color="primary" @click="submit" />
  </q-page>
</template>

<script setup>
import { ref, onMounted, getCurrentInstance } from 'vue'
import axios from 'axios'
import { useRoute } from 'vue-router'
import { useGameStore } from 'stores/game'

const store = useGameStore()
const route = useRoute()
const question = ref('')
const answer = ref('')

onMounted(async () => {
  const { data } = await axios.get('/api/questions/random', {
    params: { lobbyId: route.params.id },
  })
  question.value = data.text
  store.setQuestion(data.text)
})

const submit = () => {
  // send answer through socket
  const socket = getCurrentInstance().appContext.app.config.globalProperties.$socket
  socket.emit('submitAnswer', { lobbyId: route.params.id, answer: answer.value })
}
</script>

