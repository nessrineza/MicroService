# Utilisez une image de base Java 8
FROM openjdk:8

# Copiez le fichier JAR de votre application dans le conteneur
COPY target/gestionAnnonce-0.0.1-SNAPSHOT.jar /app.jar

# Exposez le port sur lequel votre application Spring Boot écoute
EXPOSE 8099

# Commande pour exécuter votre application Spring Boot
CMD ["java", "-jar", "/app.jar"]
