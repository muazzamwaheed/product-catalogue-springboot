FROM openjdk:8-jdk-alpine
VOLUME /temp
ARG JAR_FILE
COPY ${JAR_FILE} product-catalogue-1.0-SNAPSHOT.jar

RUN mkdir -p /test
WORKDIR /test

COPY /target/product-catalogue-1.0-SNAPSHOT.jar /test/product-catalogue-1.0-SNAPSHOT.jar

USER root

ENTRYPOINT ["java", "-jar", "/test/product-catalogue-1.0-SNAPSHOT.jar"]