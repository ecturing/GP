FROM openjdk:8u302-jdk

MAINTAINER ecturing

EXPOSE 8080

ADD target/QBotServer-0.0.1-SNAPSHOT.jar QBotServer.jar

ENTRYPOINT["java","-jar","QBotServer.jar"]