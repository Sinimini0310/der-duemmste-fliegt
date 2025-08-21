<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated class="header-gradient text-white">
      <q-toolbar>
        <q-toolbar-title class="text-h5">Der dümmste fliegt</q-toolbar-title>
      </q-toolbar>
    </q-header>
    <q-page-container>
      <router-view />
      <EmoteOverlay ref="emotes" />
    </q-page-container>
  </q-layout>
</template>

<script setup>
import EmoteOverlay from 'components/EmoteOverlay.vue'
</script>

<style scoped lang="scss">
.header-gradient {
  background: linear-gradient(135deg, #292d3e 0%, #1b1e2b 100%);
}
</style>
