# Der dümmste fliegt

Monorepo für das Multiplayer-Spiel.

## Ordner

- **frontend** – Vue 3 mit Quasar
- **backend** – Spring Boot REST API
- **express** – Socket.IO Server

## Docker

```
docker-compose up --build
```

## Lokaler Start

Backend:

```
cd backend/backend
./mvnw spring-boot:run
```

Express:

```
cd express
npm install
node server.js
```

Frontend:

```
cd frontend
npm install
npm run dev
```

## Express auf eigener Domain

1. Domain auf die IP des Rechners zeigen lassen.
2. Einen Reverse-Proxy wie Nginx verwenden und auf Port 3000 weiterleiten.
3. Optional TLS-Zertifikat mit Let's Encrypt einrichten.

