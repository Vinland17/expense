# 💰 Expense Tracker

An intermediate-level Spring Boot application to help users efficiently **track, categorize, and analyze expenses**, with enhanced features like **Swagger UI**, **global exception handling**, and **custom API responses**. Built with **basic Spring Security** for user protection.

---

## 🔑 Features

- **CRUD for Expenses & Categories**  
  Create, read, update, and delete expense records and categories.

- **Secure Authentication**  
  Basic **Spring Security** for login and protecting endpoints.

- **Interactive Swagger UI**  
  Explore and test APIs via the integrated Swagger documentation:
  `http://<host>:<port>/swagger-ui.html`

- **Global Exception Handling**  
  Unified `@ControllerAdvice` for clean error handling and consistent API responses.

- **Custom API Response Wrapper**  
  All endpoints return structured JSON with `status`, `message`, and `data`.

- **API-Driven Logic**  
  Well-structured service layers separating business logic from controllers.

---

## ⚙️ Tech Stack

- **Java 11+**, **Spring Boot**
- **Spring Web**, **Spring Data JPA**, **Spring Security**
- **MongoDB**
- **Maven** for build and dependency management

---

## 🚀 Getting Started

### Prerequisites
- Java 11+ installed  
- Database: MongoDB
- Maven

### Installation & Running

1. **Clone**
   ```bash
   git clone https://github.com/Vinland17/expense.git
   cd expense
