FROM openjdk:17-jdk-slim

MAINTAINER Easy To Bank

COPY target/Accounts-Service-0.0.1-SNAPSHOT.jar Accounts-Service-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","Accounts-Service-0.0.1-SNAPSHOT.jar"]