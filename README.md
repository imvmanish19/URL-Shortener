# URL Shortener (Spring Boot 4 + DDD)

A URL shortener built with **Java 21**, following Domain-Driven Design (DDD).

---

## 🛠 Tech Stack
* **Java 21** | **Spring Boot 4**
* **MySQL** (Persistence) | **Redis** (Cache)
* **Docker** | **Testcontainers**
* **JUnit 5** | **MockMvc**

---

## 🚀 Getting Started

### 1. Spin up Infrastructure
```bash
docker compose up -d
# MySQL: 3307 | Redis: 6379
```

### 2. Run Application

```bash
./gradlew bootRun
# Base URL: http://localhost:8080
