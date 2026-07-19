# Large-Scale API Monetization & Developer Portal

## Project Overview

The Large-Scale API Monetization & Developer Portal is an enterprise-grade microservices application developed using Java 21 and Spring Boot 3.x. It enables organizations to publish APIs, manage developers, secure access with JWT authentication, and provide scalable API management using Spring Cloud technologies.

---

## Technologies Used

- Java 21
- Spring Boot 3.x
- Spring Security
- JWT Authentication
- Spring Data JPA
- PostgreSQL
- Flyway
- Spring Cloud Gateway
- Eureka Service Registry
- Docker & Docker Compose
- Swagger / OpenAPI
- Maven
- Git & GitHub

---

## Microservices

- Service Registry (Eureka Server)
- API Gateway
- Authentication Service
- Developer Service
- Analytics Service

---

## Features

### Authentication
- User Registration
- User Login
- JWT Token Generation
- Role-Based Access Control (RBAC)

### Developer Portal
- Developer Registration
- Developer Profile Management
- View Developers

### API Management
- API Gateway Routing
- Service Discovery
- Swagger Documentation

### Database
- PostgreSQL Integration
- Flyway Database Migration
- Spring Data JPA

### DevOps
- Dockerized Services
- Docker Compose Setup

---

## Project Structure

```
large-scale-api-monetization-developer-portal
│
├── api-gateway
├── auth-service
├── developer-service
├── analytics-service
├── service-registry
├── docker-compose.yml
├── README.md
└── pom.xml
```

---

## Service Ports

| Service | Port |
|----------|------|
| Eureka Server | 8761 |
| API Gateway | 8080 |
| Auth Service | 8081 |
| Developer Service | 8082 |
| Analytics Service | 8083 |
| PostgreSQL | 5432 |

---

## Swagger URLs

```
http://localhost:8081/swagger-ui/index.html
```

```
http://localhost:8082/swagger-ui/index.html
```

```
http://localhost:8083/swagger-ui/index.html
```

---

## Run the Project

### Clone Repository

```bash
git clone https://github.com/SWATHIPALLA123/large-scale-api-monetization-developer-portal.git
```

### Build

```bash
mvn clean install
```

### Start Docker Containers

```bash
docker compose up --build
```

---

## APIs

### Authentication APIs

- Register User
- Login User

### Developer APIs

- Create Developer
- Get All Developers
- Get Developer By Id
- Update Developer
- Delete Developer

---

## Project Highlights

- Microservices Architecture
- JWT Authentication
- Role-Based Authorization
- Service Discovery using Eureka
- API Gateway Routing
- PostgreSQL Database
- Docker Deployment
- Swagger API Documentation
- Flyway Migration
- RESTful APIs
- Layered Architecture
- Exception Handling
- Validation
- Logging

---

## Future Enhancements

- API Catalog Management
- API Key Generation
- Subscription Plans
- Usage Tracking
- Billing & Invoice Generation
- Redis Integration
- Kafka Event Streaming
- Rate Limiting
- API Analytics Dashboard

---

## Author

**Swathi Palla**

Java Developer

---

## License

This project was developed as part of the **Large-Scale API Monetization & Developer Portal Assignment**.
