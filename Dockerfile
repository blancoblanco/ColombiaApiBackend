FROM openjdk:21-ea-1-jdk-slim

ARG JAR_FILE=target/jumatabaCo-0.0.1.jar
COPY ${JAR_FILE} app_apiColombia.jar
EXPOSE 8080
ENTRYPOINT ["java"  ,"-jar","app_apiColombia.jar"]