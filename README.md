# Spring Boot WebFlux CRUD Application

A reactive CRUD application built with Spring Boot WebFlux and MongoDB Reactive, demonstrating non-blocking,
asynchronous data operations.

## Technologies Used

- Java 21
- Spring Boot 3.5.7
- Spring WebFlux (Reactive Web)
- Spring Data MongoDB Reactive
- MongoDB (via Docker)
- Lombok
- Maven

## Features

- Fully reactive REST API using Spring WebFlux
- CRUD operations for Article entities
- Non-blocking database operations with MongoDB Reactive
- Reactive programming with Project Reactor (Mono and Flux)
- Docker Compose for easy MongoDB setup
- Spring Boot DevTools for development

## Prerequisites

- Java 21 or higher
- Maven 3.8+
- Docker and Docker Compose

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/hendisantika/spring-boot-webflux-crud.git
cd spring-boot-webflux-crud
```

### 2. Start MongoDB

Start MongoDB using Docker Compose:

```bash
docker-compose up -d
```

This will start MongoDB on port 27017 with database name `reactivedb`.

### 3. Build the application

```bash
./mvnw clean package
```

### 4. Run the application

```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`.

## API Endpoints

### Create an Article

```bash
POST /api/articles/save
Content-Type: application/json

{
  "title": "Spring WebFlux Tutorial",
  "content": "This is a tutorial about Spring WebFlux",
  "author": "John Doe",
  "publishedAt": "2025-11-02T00:00:00.000Z"
}
```

### Get All Articles

```bash
GET /api/articles/findAll
```

### Get Article by ID

```bash
GET /api/articles/{id}
```

### Get Articles by Author

```bash
GET /api/articles/author/{author}
```

### Update an Article

```bash
PUT /api/articles/update/{id}
Content-Type: application/json

{
  "title": "Updated Title",
  "content": "Updated content",
  "author": "John Doe",
  "publishedAt": "2025-11-02T00:00:00.000Z"
}
```

### Delete an Article

```bash
DELETE /api/articles/delete/{id}
```

## Example cURL Commands

### Create an article:

```bash
curl -X POST http://localhost:8080/api/articles/save \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Spring WebFlux Tutorial",
    "content": "This is a tutorial about Spring WebFlux and reactive programming",
    "author": "John Doe",
    "publishedAt": "2025-11-02T00:00:00.000Z"
  }'
```

### Get all articles:

```bash
curl http://localhost:8080/api/articles/findAll
```

### Get article by author:

```bash
curl http://localhost:8080/api/articles/author/John%20Doe
```

## Project Structure

```
src/main/java/com/hendisantika/springbootwebfluxcrud/
├── controller/
│   └── ArticleController.java      # REST API endpoints
├── entity/
│   └── Article.java                # Article entity model
├── repository/
│   └── ArticleRepository.java      # Reactive MongoDB repository
├── service/
│   ├── ArticleService.java         # Service interface
│   └── ArticleServiceImpl.java     # Service implementation
└── SpringBootWebfluxCrudApplication.java  # Main application class
```

## Configuration

Database configuration is located in `src/main/resources/application.properties`:

```properties
spring.data.mongodb.port=27017
spring.data.mongodb.database=reactivedb
```

## Stop MongoDB

To stop the MongoDB container:

```bash
docker-compose down
```

To stop MongoDB and remove volumes:

```bash
docker-compose down -v
```

## Author

Hendi Santika

- Email: hendisantika@gmail.com
- Telegram: @hendisantika34

## License

This project is open source and available for educational purposes.
