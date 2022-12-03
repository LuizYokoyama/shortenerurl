FROM adoptopenjdk/openjdk11
EXPOSE 88

ENTRYPOINT ["java", "-jar", "/shortenerurl.jar"]