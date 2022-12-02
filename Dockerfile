FROM adoptopenjdk/openjdk11
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
copy build/libs/*.jar app.jar
EXPOSE 88
CMD ["java", "--jar", "app.jar"]