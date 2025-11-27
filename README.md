# Pojistovna - Insurance Application

A Spring Boot web application for managing an insurance company's clients.

## Features

*   **User Authentication:** Users can register and log in to the application.
*   **Role-Based Authorization:** The application supports both regular users and administrators, with different levels of access.
*   **Insured Person Management (CRUD):** Administrators can create, read, update, and delete records of insured persons (Pojistenci).

## Technologies Used

*   **Backend:**
    *   Java 18
    *   Spring Boot 3
    *   Spring Security (for authentication and authorization)
    *   Spring Data JPA (for database interaction)
    *   MapStruct (for object mapping)
*   **Frontend:**
    *   Thymeleaf
*   **Database:**
    *   MariaDB or PostgreSQL (requires configuration)
*   **Build Tool:**
    *   Maven

## Setup and Installation

### Prerequisites

*   JDK 18 or later
*   Apache Maven
*   A running instance of MariaDB or PostgreSQL

### 1. Database Configuration

This project does not ship with a pre-configured database connection. You will need to create an `application.properties` file in the `src/main/resources` directory.

Add the following properties to the file, adjusting the values for your local database setup.

**Example for MariaDB:**
```properties
# Database Connection Settings
spring.datasource.url=jdbc:mariadb://localhost:3306/pojistovna_db
spring.datasource.username=root
spring.datasource.password=your_password

# Specify the driver
spring.datasource.driver-class-name=org.mariadb.jdbc.Driver

# Hibernate settings
spring.jpa.hibernate.ddl-auto=update
```

**Example for PostgreSQL:**
```properties
# Database Connection Settings
spring.datasource.url=jdbc:postgresql://localhost:5432/pojistovna_db
spring.datasource.username=postgres
spring.datasource.password=your_password

# Specify the driver
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate settings
spring.jpa.hibernate.ddl-auto=update
```

### 2. Build and Run

Once the database is configured, you can run the application using Maven:

```bash
mvn spring-boot:run
```

The application will start and be accessible at [http://localhost:8080](http://localhost:8080).

## Usage

*   **Register and Login:** Navigate to the application and register a new user account or log in with existing credentials.
*   **Admin Access:** To gain administrative privileges, you must manually update a user's record in the database. In the `user_entity` table, set the `role` column for your user to `ROLE_ADMIN`.
