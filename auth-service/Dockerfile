FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /auth-service
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:21
WORKDIR /auth-service
COPY --from=build /auth-service/target/auth-service-0.0.1-SNAPSHOT.jar auth-service.jar
EXPOSE 4005
ENTRYPOINT ["java", "-jar", "auth-service.jar"]