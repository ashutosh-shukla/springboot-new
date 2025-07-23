FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY target/spring-database.war app.war

EXPOSE 9091

CMD ["java","-jar","app.war"]