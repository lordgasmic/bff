FROM openjdk:11
WORKDIR /app

COPY target/*.jar app.jar
EXPOSE 48080
ENTRYPOINT ["java", "-jar", "app.jar"]