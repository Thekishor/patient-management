# Patient Management System - Microservices Architecture

This is a full-stack, production-grade **Microservices-based Patient Management System** designed for scalable healthcare operations. It leverages Java Spring Boot, Docker, Kafka, gRPC, and LocalStack for AWS emulation.

---

## Features Overview

- ✅ **Microservices Architecture** with Spring Boot
- ✅ **API Gateway** for central entry point
- ✅ **gRPC Communication** between services
- ✅ **Kafka** integration for real-time event streaming
- ✅ **LocalStack** to emulate AWS (S3, SNS, etc.)
- ✅ **Dockerized** for local development
- ✅ **Security with Auth Service (JWT based)**
- ✅ **Scalable & Modular** codebase

---

## Project Structure

```
patient-management/
│
├── api-gateway/             # Central API Gateway
├── analytics-service/       # Kafka consumer for analytical insights
├── auth-service/            # Handles login, JWT, and authorization
├── billing-service/         # Handles billing via gRPC server
├── infrastructure/          # LocalStack infra using AWS CDK
│   ├── cdk.out/             # Synthesized CloudFormation templates
│   └── src/                 # CDK code (Java)
├── integration-test/        # Integration tests
├── patient-service/         # Core business logic + Kafka producer + gRPC client
├── docker-compose.yaml      # Starts all services
└── README.md
```

---

##  Microservice Interaction

![Development Architecture]

### Communication Flow:

| Source             | Target              | Protocol   | Description                            |
|--------------------|---------------------|------------|----------------------------------------|
| Postman            | API Gateway         | HTTP       | Entry point for all requests           |
| API Gateway        | Auth/Patient Service| HTTP       | Routes requests                        |
| Patient Service    | Billing Service     | gRPC       | Service-to-service remote calls        |
| Patient Service    | Kafka               | Kafka      | Publishes patient events               |
| Analytics Service  | Kafka               | Kafka      | Consumes and processes analytics data  |
| Notification Service| Kafka              | Kafka      | Consumes for alerts or updates         |

---

## Technologies Used

| Category         | Tech Stack                                    |
|------------------|-----------------------------------------------|
| Language         | Java (Spring Boot), Bash                      |
| Inter-service    | gRPC, Kafka                                    |
| Messaging Queue  | Apache Kafka (KRaft Mode)                      |
| Security         | JWT Token, Role-based access                  |
| Cloud Emulation  | LocalStack (AWS S3, SNS)                       |
| DevOps Tools     | Docker, Docker Compose                         |
| Infra as Code    | AWS CDK                                        |

---

## Getting Started

### Prerequisites

- JDK 21
- Maven 3.9.9
- Docker & Docker Compose
- Kafka (via Docker)
- LocalStack

---

### Running the Project

#### 1. Clone the repo
```bash
git clone https://github.com/Thekishor/patient-management.git
cd patient-management
```

#### 2. Start Kafka and Services
```bash
docker-compose up --build
```

#### 3. Deploy AWS Infra (LocalStack)
```bash
cd infrastructure
bash localstack-deploy.sh
```

---

### 🔪 Testing Strategy

| Type               | Status        | Tools          |
|--------------------|---------------|----------------|
| Unit Tests         | Implemented in services |
| Integration Tests  | (`integration-test` module) |
| Load Testing       |  Pending      |
| Contract Testing   | Pending      |

---

## 📦 Docker Images

| Service              | Dockerized | Port  |
|----------------------|------------|-------|
| api-gateway          | ✅          | 4004  |
| auth-service         | ✅          | 4003  |
| billing-service      | ✅          | 4001, 9001  |
| patient-service      | ✅          | 4000 |
| analytics-service    | ✅          | 4002 |
| infrastructure       | ❌ (Not required) |
| integration-test     | ❌ (Planned) |

---

---

## Future Improvements

- OAuth2
- 
---

Ensure the following are installed on your local machine:

- [Docker](https://www.docker.com/get-started)
- [Docker Compose](https://docs.docker.com/compose/)
- [Java 21 or higher](https://openjdk.java.net/)
- [Maven](https://maven.apache.org/) for building Spring Boot applications
- [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/getting-started-install.html)
- [Local Stack](https://app.localstack.cloud)

