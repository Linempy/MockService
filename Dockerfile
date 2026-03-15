FROM gradle:7.6.6-jdk17 AS build

COPY build/libs/service.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]