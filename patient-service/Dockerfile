FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /patient-service
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

FROM amazoncorretto:21
WORKDIR /patient-service
COPY --from=build /patient-service/target/patient-service-0.0.1-SNAPSHOT.jar patient-service.jar
EXPOSE 4000
ENTRYPOINT ["java", "-jar", "patient-service.jar"]