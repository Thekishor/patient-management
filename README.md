# Patient Management System - Microservices Architecture

This is a **production-grade Patient Management System**, built using real-world microservices principles. It uses Spring Boot, Kafka (KRaft), gRPC, Docker, and LocalStack to simulate scalable and secure patient-management backend operations.

Designed for modularity, service communication, infrastructure simulation, and local cloud emulation using LocalStack, this system handles core patient data processing in a realistic cloud-native development environment — without deploying to actual AWS.

---

## Features Overview

- **Microservices Architecture** with Spring Boot
- **API Gateway** for centralized routing
- **gRPC Communication** for inter-service calls
- **Kafka Integration** for real-time event streaming
- **LocalStack** to emulate AWS services (S3, SNS, etc.) locally
- **Dockerized** for isolated, reproducible local development
- **Security with Auth Service (JWT-based)**
- **Scalable & Modular** codebase for enterprise expansion

---

## Project Structure

```
patient-management/
│
├── api-gateway/             # Gateway for routing service requests
├── auth-service/            # Handles authentication (JWT)
├── patient-service/         # Core service managing patient data
├── analytics-service/       # Kafka consumer for insights
├── infrastructure/          # AWS CDK infra (LocalStack)
├── integration-test/        # Tests cross-service functionality
└── docker-compose.yaml      # Brings up the system stack
```

---

## Microservice Interaction

### Communication Flow

| Source              | Target               | Protocol   | Description                            |
|---------------------|----------------------|------------|----------------------------------------|
| Postman             | API Gateway          | HTTP       | Entry point for all requests           |
| API Gateway         | Auth / Patient       | HTTP       | Routes incoming requests               |
| Patient Service     | Analytics Service    | Kafka      | Publishes patient events (Kafka Producer               |
| Analytics Service   | Kafka                | Kafka      | Consumes and processes analytics data  |
| Billing Service     | Kafka                | Kafka      | Kafka-Consumer   |

---

## Technologies Used

| Category         | Tech Stack                                    |
|------------------|-----------------------------------------------|
| Language         | Java (Spring Boot), Bash                      |
| Inter-service    | gRPC, Kafka                                   |
| Messaging Queue  | Apache Kafka (KRaft Mode)                     |
| Security         | JWT Token                                     |
| Cloud Emulation  | LocalStack (AWS S3, SNS)                      |
| DevOps Tools     | Docker, Docker Compose                        |
| Infra as Code    | AWS CDK (Java)                                |

---

## Getting Started

### Prerequisites

Ensure the following are installed:

- [Java 21+](https://openjdk.java.net/)
- [Maven 3.9.9+](https://maven.apache.org/)
- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/)
- [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html)
- [LocalStack](https://app.localstack.cloud)

---

### Running the Project

#### 1. Clone the Repository

```bash
git clone https://github.com/Thekishor/patient-management.git
cd patient-management
```

#### 2. Start Kafka and All Services

```bash
docker-compose up --build
```

#### 3. Deploy AWS Infrastructure via LocalStack

```bash
cd infrastructure
bash localstack-deploy.sh
```

---

## Testing Strategy

| Type               | Status        | Tools                      |
|--------------------|---------------|----------------------------|
| Unit Tests         | Implemented per service |
| Integration Tests  | Via `integration-test` module |
| Load Testing       | Pending      |
| Contract Testing   | Pending      |

---

## Dockerized Services

| Service              | Dockerized | Ports         |
|----------------------|------------|---------------|
| api-gateway          | Yes    | 4004          |
| auth-service         | Yes    | 4003          |
| patient-service      | Yes    | 4000          |
| analytics-service    | Yes    | 4002          |
| billing-service      | Yes    | 4001, 9001    |
| infrastructure       | Not required as a service |
| integration-test     |  Not required   |

---

## Future Improvements

- OAuth2 Authorization Integration
- CI/CD Integration (Jenkins or GitHub Actions)
- Circuit Breaker Implementation (Resilience4j)

---

