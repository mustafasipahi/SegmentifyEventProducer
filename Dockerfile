FROM maven:3.8.6-amazoncorretto-8 AS maven_build
WORKDIR /segmentify_producer
COPY pom.xml .
COPY src ./src
RUN mvn clean package

FROM openjdk:8
WORKDIR /segmentify_producer
COPY --from=maven_build /segmentify_producer/target/Segmentify-Producer-1.0-SNAPSHOT.jar my_producer_app.jar
ENTRYPOINT ["java","-jar","my_producer_app.jar"]
EXPOSE 8080