const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/IndexPage.vue'), name: 'home' },
      { path: 'create', component: () => import('pages/LobbyCreatePage.vue'), name: 'create' },
      { path: 'lobby/:id', component: () => import('pages/LobbyViewPage.vue'), name: 'lobby' },
      { path: 'game/:id', component: () => import('pages/GamePage.vue'), name: 'game' },
      { path: 'vote/:id', component: () => import('pages/VotingPage.vue'), name: 'vote' },
      { path: 'results/:id', component: () => import('pages/ResultsPage.vue'), name: 'results' },
      { path: 'settings', component: () => import('pages/SettingsPage.vue'), name: 'settings' },
      { path: 'analytics', component: () => import('pages/AnalyticsPage.vue'), name: 'analytics' },
    ],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/ErrorNotFound.vue'),
  },
]

export default routes
