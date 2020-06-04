FROM openjdk:8-jdk-alpine

ADD target/product-catalogue-1.0-SNAPSHOT.jar product-catalogue-1.0-SNAPSHOT.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/product-catalogue-1.0-SNAPSHOT.jar"]