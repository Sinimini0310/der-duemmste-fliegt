import { defineStore } from 'pinia'

export const useGameStore = defineStore('game', {
  state: () => ({
    lobby: null,
    player: null,
    question: null,
    votes: {},
    stats: {},
  }),
  actions: {
    setLobby(lobby) {
      this.lobby = lobby
    },
    setPlayer(player) {
      this.player = player
    },
    setQuestion(question) {
      this.question = question
    },
    recordVote(playerId, answerId) {
      this.votes[playerId] = answerId
    },
  },
})

