<template>
  <q-page padding>
    <div v-if="authorized">
      <div>Analytics</div>
      <div>Questions asked: {{ stats.questions || 0 }}</div>
    </div>
    <div v-else class="column q-gutter-md" style="max-width:300px">
      <q-input v-model="password" type="password" label="Admin password" />
      <q-btn label="Login" @click="login" color="primary" />
    </div>
  </q-page>
</template>

<script setup>
import { ref } from 'vue'
const password = ref('')
const authorized = ref(false)
const stats = ref({ questions: 0 })
const login = () => {
  if (password.value === 'admin') authorized.value = true
}
</script>

