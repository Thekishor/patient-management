FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /api-gateway
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:21
WORKDIR /api-gateway
COPY --from=build /api-gateway/target/api-gateway-0.0.1-SNAPSHOT.jar api-gateway.jar
EXPOSE 4004
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]