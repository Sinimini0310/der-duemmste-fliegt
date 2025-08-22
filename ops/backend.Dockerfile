FROM eclipse-temurin:21-jdk AS build
WORKDIR /app
COPY backend/backend/ ./
RUN ./mvnw -q -e -DskipTests package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]
