FROM openjdk:24-ea-23-jdk

WORKDIR /app

COPY target/Products-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]