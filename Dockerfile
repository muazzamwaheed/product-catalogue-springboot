FROM openjdk:8-jdk-alpine

ADD target/product-catalogue.jar product-catalogue.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "/product-catalogue.jar"]