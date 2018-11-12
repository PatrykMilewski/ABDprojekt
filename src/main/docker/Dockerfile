FROM openjdk:11-jdk-slim

ENV ARTIFACT_FILE abdprojekt-0.1-SNAPSHOT

ADD maven/$ARTIFACT_FILE.jar $ARTIFACT_FILE.jar

ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /$ARTIFACT_FILE.jar