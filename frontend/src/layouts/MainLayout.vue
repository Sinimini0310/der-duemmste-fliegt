<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated>
      <q-toolbar>
        <q-toolbar-title>Der dümmste fliegt</q-toolbar-title>
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
