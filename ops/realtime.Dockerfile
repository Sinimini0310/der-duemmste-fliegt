FROM node:20
WORKDIR /app
COPY realtime/package.json ./
RUN npm install --production
COPY realtime/src ./src
EXPOSE 8081
CMD ["node","src/server.js"]
