<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated class="palenight-header">
      <q-toolbar>
        <q-toolbar-title class="text-white">Der dümmste fliegt</q-toolbar-title>
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
