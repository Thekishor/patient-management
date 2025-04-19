FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /billing-service
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:21
WORKDIR /billing-service
COPY --from=build /billing-service/target/billing-service-0.0.1-SNAPSHOT.jar billing-service.jar
EXPOSE 4001
EXPOSE 9001
ENTRYPOINT ["java", "-jar", "billing-service.jar"]