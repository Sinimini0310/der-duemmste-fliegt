import express from 'express'
import { createServer } from 'http'
import { Server } from 'socket.io'

const app = express()
const httpServer = createServer(app)
const io = new Server(httpServer, { cors: { origin: '*' } })

io.on('connection', socket => {
  socket.on('joinLobby', data => {
    socket.join(data.lobbyId)
    socket.to(data.lobbyId).emit('playerJoined', data)
  })

  socket.on('submitAnswer', data => {
    io.to(data.lobbyId).emit('answerSubmitted', data)
  })

  socket.on('vote', data => {
    io.to(data.lobbyId).emit('voteUpdate', data)
  })

  socket.on('heartUpdate', data => {
    io.to(data.lobbyId).emit('heartUpdate', data)
  })

  socket.on('roundEnd', data => {
    io.to(data.lobbyId).emit('roundEnd', data)
  })
})

const port = process.env.PORT || 3000
httpServer.listen(port, () => console.log(`express listening on ${port}`))

