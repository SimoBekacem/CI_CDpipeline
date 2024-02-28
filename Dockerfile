# Stage 1: Build
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install

# Stage 2: Final Image
FROM openjdk:8
EXPOSE 8080
COPY --from=build /app/target/springboot-images-new.jar /springboot-images-new.jar
ENTRYPOINT ["java", "-jar", "/springboot-images-new.jar"]
