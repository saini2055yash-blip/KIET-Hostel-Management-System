# KIET Hostel Management System

## About the Project
The KIET Hostel Management System is a Java-based web application developed using Spring Boot. It helps manage hostel student records through REST APIs.

The application supports adding, viewing, updating, and deleting student information using a MySQL database.

## Technologies Used
- Java 17
- Spring Boot 3.5.6
- Spring Data JPA
- MySQL
- Maven
- Postman
- IntelliJ IDEA

## Features
- Add new hostel students
- View all registered students
- Search students by ID
- Update student details
- Delete student records
- Store student information in MySQL database

## Student Details
The system manages the following information:
- Student ID
- Student Name
- Roll Number
- Hostel Name
- Room Number
- Hostel Fee

## REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/students` | Add a student |
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get student by ID |
| PUT | `/api/students/{id}` | Update student |
| DELETE | `/api/students/{id}` | Delete student |

## Database Configuration
Database: `host_db`

The application uses MySQL and Spring Data JPA for database connectivity and Hibernate for table management.

Configure your own MySQL username and password in `application.properties` before running the application.

## How to Run the Project

1. Clone this repository.
2. Open the project in IntelliJ IDEA.
3. Configure MySQL credentials in `application.properties`.
4. Make sure MySQL is running.
5. Open the Maven project and load dependencies.
6. Run `HostelManagementApplication.java`.
7. The application starts at:

`http://localhost:8080`

## API Testing
All REST API endpoints can be tested using Postman.

## Developer
KIET Hostel Management System

Developed as a Java Spring Boot project.
