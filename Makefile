.RECIPEPREFIX := >
dev: up

test:
>cd backend/backend && ./mvnw -q test
>cd realtime && npm test

lint:
>echo "no lint configured"

up:
>cd ops && docker-compose up -d

down:
>cd ops && docker-compose down
