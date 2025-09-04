import express from 'express';
import { createServer } from 'http';
import { Server } from 'socket.io';

const app = express();
const httpServer = createServer(app);
const io = new Server(httpServer, {
  cors: { origin: process.env.CORS_ORIGIN || '*' }
});

app.get('/health', (req, res) => {
  res.json({ status: 'ok' });
});

io.on('connection', (socket) => {
  socket.on('join', ({ name }) => {
    socket.data.name = name;
    socket.emit('lobby_state', { players: [name] });
  });
  socket.on('chat', ({ message }) => {
    io.emit('chat_message', { playerId: socket.id, message, ts: Date.now() });
  });
});

const port = process.env.PORT || 8081;
httpServer.listen(port, () => {
  console.log(`Realtime server listening on ${port}`);
});
