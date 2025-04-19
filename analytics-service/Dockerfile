FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /analytics-service
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:21
WORKDIR /analytics-service
COPY --from=build /analytics-service/target/analytics-service-0.0.1-SNAPSHOT.jar analytics-service.jar
EXPOSE 4002
ENTRYPOINT ["java", "-jar", "analytics-service.jar"]