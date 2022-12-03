FROM adoptopenjdk/openjdk17
EXPOSE 88
ADD target/shostenerurl.jar shortenerurl.jar
ENTRYPOINT ["java", "-jar", "/shortenerurl.jar"]