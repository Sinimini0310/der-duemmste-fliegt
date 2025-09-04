# Der Dümmste fliegt

Monorepo for a minimal implementation of the party game **"Der Dümmste fliegt"**.

## Packages

| Path      | Description |
|-----------|-------------|
| `backend` | Spring Boot REST API providing lobby and question endpoints |
| `realtime`| Node.js + Socket.IO server for realtime gameplay |
| `frontend`| Vue 3 + Quasar web client (scaffold) |
| `shared`  | Shared configuration and question files |
| `ops`     | Dockerfiles and `docker-compose` setup |

## Development

1. Install dependencies and run tests:

   ```bash
   make test
   ```

2. Start all services with Docker:

   ```bash
   make up
   ```

The frontend is available on [http://localhost:9000](http://localhost:9000).

## Environment variables

Each package provides a `.env.example` file:

```
backend/.env.example
realtime/.env.example
frontend/.env.example
```

Copy them to `.env` and adjust as needed.

## Shared assets

Shared configuration lives in `shared/config/default.config.json`. Sample
questions are stored in `shared/questions/questions.json` and
`shared/questions/estimate_questions.json`.

