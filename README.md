# Task Manager API

Task Manager API is a backend REST API built with Java and Spring Boot that allows users to create and manage tasks associated with different users.

This project was developed as a learning and practice exercise to deepen my understanding of backend development concepts and technologies such as Spring Boot, Lombok, JPA, DTO patterns, MapStruct, and REST API design.

The goal of this project was to practice building a clean and structured backend architecture using modern Java tools and frameworks commonly used in real-world backend systems.

---

## Tech Stack

This project uses the following technologies:

- Java 21
- Spring Boot
- Spring Web (REST API)
- Spring Data JPA
- Hibernate ORM
- MySQL
- Lombok
- MapStruct
- Maven
- JUnit (basic testing)

---

## Architecture

The application follows a layered architecture commonly used in Spring Boot applications.

```
Controller → Service → Repository → Database
```

### Project structure:

```
controller  
service  
repository  
model  
dto  
mapper  
exception  
```

---

## Layer responsibilities

### Controller
Handles HTTP requests and responses.

### Service
Contains the business logic of the application.

### Repository
Responsible for database communication using Spring Data JPA.

### DTO
Used to separate API input/output models from database entities.

### Mapper
Converts DTOs into entities and vice versa using MapStruct.

### Exception
Handles global exceptions and custom error responses.

---

## Domain Model

The application is composed of two main entities:

```
User
 └── Tasks
```

### Relationships

- A User can have multiple Tasks
- Each Task belongs to a single User

This structure allows users to organize and manage their tasks efficiently.

---

## API Endpoints

### Users

Create a user

```
POST /users
```

Retrieve all users

```
GET /users
```

---

### Tasks

Create a task for a specific user

```
POST /tasks
```

Example body:

```json
{
  "title": "Finish project",
  "description": "Complete the Spring Boot API",
  "userId": 1
}
```

Retrieve all tasks

```
GET /tasks
```

---

## Running the Project

Clone the repository

```bash
git clone https://github.com/your-username/task-api.git
```

Navigate to the project

```bash
cd task-api
```

Configure the database (MySQL)

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_db
spring.datasource.username=your_user
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Run the application

```bash
mvn spring-boot:run
```

The API will start on:

```
http://localhost:8080
```

---

## Database

The project uses MySQL as the main database.

Make sure you have a database created, for example:

```
task_db
```

Hibernate will automatically generate the tables based on your entities.

---

## Testing

Basic unit tests are included using JUnit.

Run tests with:

```bash
mvn test
```

---

## Learning Objectives

This project was created to practice and better understand:

- Building REST APIs using Spring Boot
- Designing backend layered architecture
- Working with JPA/Hibernate entity relationships
- Implementing DTO patterns
- Using Lombok to reduce boilerplate code
- Using MapStruct for DTO ↔ Entity mapping
- Validation and exception handling
- Basic backend unit testing

---

## Future Improvements

Possible improvements for this project include:

- Authentication and authorization (JWT)
- Pagination and filtering for tasks
- Task status (completed, pending, etc.)
- Deadlines and reminders
- Docker containerization
- Integration tests
- API documentation with Swagger

---

## Author

Software Engineering student exploring backend development with Java and Spring Boot, focused on building clean and scalable backend systems.