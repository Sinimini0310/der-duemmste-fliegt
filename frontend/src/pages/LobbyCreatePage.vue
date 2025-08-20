<template>
  <q-page padding class="column q-gutter-md">
    <q-input v-model="name" label="Host name" />
    <q-input v-model.number="hearts" type="number" label="Hearts" />
    <q-input v-model.number="roundSeconds" type="number" label="Round seconds" />
    <q-toggle v-model="spectatorVoting" label="Spectator voting" />
    <q-btn label="Create Lobby" color="primary" @click="createLobby" />
  </q-page>
</template>

<script setup>
import { ref } from 'vue'
import { api } from 'boot/axios'
import { useRouter } from 'vue-router'

const router = useRouter()
const name = ref('')
const hearts = ref(3)
const roundSeconds = ref(120)
const spectatorVoting = ref(true)

const createLobby = async () => {
  const { data } = await api.post('/lobbies', {
    hostName: name.value,
    settings: {
      hearts: hearts.value,
      roundSeconds: roundSeconds.value,
      spectatorVoting: spectatorVoting.value,
    },
  })
  router.push({ name: 'lobby', params: { id: data.id } })
}
</script>

