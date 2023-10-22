FROM openjdk:8
COPY target/Project2MSA-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8099
CMD ["java","-jar","/app.jar"]