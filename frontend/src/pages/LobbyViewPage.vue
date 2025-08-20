<template>
  <q-page padding>
    <div class="column q-gutter-sm">
      <div>Lobby {{ lobby?.id }}</div>
      <div>Players</div>
      <ul>
        <li v-for="p in lobby.players" :key="p.id">{{ p.name }} ({{ p.hearts }})</li>
      </ul>
      <q-btn v-if="isHost" label="Start Game" color="primary" @click="startGame" />
    </div>
  </q-page>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { api } from 'boot/axios'
import { useRoute, useRouter } from 'vue-router'
import { useGameStore } from 'stores/game'

const store = useGameStore()
const route = useRoute()
const router = useRouter()
const lobby = ref({ players: [] })
const isHost = ref(false)

onMounted(async () => {
  const { data } = await api.get(`/lobbies/${route.params.id}`)
  lobby.value = data
  store.setLobby(data)
  isHost.value = data.players[0]?.id === store.player?.id
})

const startGame = () => {
  router.push({ name: 'game', params: { id: lobby.value.id } })
}
</script>

