FROM node:20
WORKDIR /app

# Install dependencies without running any scripts. Include the Quasar
# configuration so that dependency installation has access to the required
# metadata.
COPY package*.json quasar.config.js ./
RUN npm install --ignore-scripts

# Copy the rest of the frontend source and prepare the Quasar project.
COPY . .
RUN npx quasar prepare

EXPOSE 9000
CMD ["npm","run","dev"]

