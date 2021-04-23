# Dockerfile
FROM openjdk:15
WORKDIR /app
ADD  target/springmvcrestapi-0.0.1-SNAPSHOT.jar  springmvcrestapi-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","-Dspring.profiles.active=docker","springmvcrestapi-0.0.1-SNAPSHOT.jar"]

