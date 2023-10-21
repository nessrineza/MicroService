FROM openjdk:17
EXPOSE 8082
ADD target/meuble-0.0.1-SNAPSHOT.jar  meuble-docker.jar
ENTRYPOINT ["java", "-jar", "meuble-docker.jar"]