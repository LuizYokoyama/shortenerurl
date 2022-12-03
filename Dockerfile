FROM openjdk:17-oracle
EXPOSE 88
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]