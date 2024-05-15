FROM openjdk:17
COPY ./target/CodeForce-0.0.1-SNAPSHOT.war /app.war
WORKDIR /src/main/java/ru/vstu/CodeForce
#CMD ["java", "CodeForceApplication"]
CMD ["java", "-jar", "/app.war"]
#ENTRYPOINT ["java", "-jar", "CodeForce-0.0.1-SNAPSHOT.jar"]