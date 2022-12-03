FROM adoptopenjdk/openjdk11
EXPOSE 88
ADD target/shostenerurl.jar shortenerurl.jar
ENTRYPOINT ["java", "-jar", "/shortenerurl.jar"]