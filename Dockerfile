FROM eclipse-temurin:22-jdk-alpine
VOLUME /tmp
COPY target/*.jar services.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080