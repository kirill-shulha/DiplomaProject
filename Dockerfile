FROM openjdk:17

RUN mkdir /usr/app

COPY target/JVTExample-0.0.1-SNAPSHOT.jar /usr/app/app.jar
WORKDIR /usr/app

EXPOSE 8080

#аналог - java jar app.jar
CMD ["java", "-jar", "app.jar"]