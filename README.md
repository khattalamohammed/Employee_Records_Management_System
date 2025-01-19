# Employee Records Management System

## Overview
The Employee Records Management System is an internal application designed to centralize the management of employee data across departments. It provides functionalities for managing employee records, user roles, audit trails, search and filtering, validation rules, and reporting. The system is built using Java 17, Oracle SQL, and Docker, with a RESTful API and a Swing-based desktop UI.

## Features
1. **Employee Data Management**:
    - Manage employee attributes such as Full Name, Employee ID, Job Title, Department, Hire Date, Employment Status, Contact Information, and Address.

2. **User Roles and Permissions**:
    - **HR Personnel**: Perform CRUD operations on all employee data.
    - **Managers**: View and update specific details for employees within their department.
    - **Administrators**: Full system access, including configuration settings and user permissions.

3. **Audit Trail**:
    - Log all changes made to employee records, including who made the change and when.

4. **Search and Filtering**:
    - Search for employees by name, ID, department, or job title.
    - Filter employees based on employment status, department, and hire date.

5. **Validation Rules**:
    - Ensure all employee records comply with predefined validation rules (e.g., valid email format, unique employee ID).

6. **Reporting**:
    - Generate basic reports on employee data.

7. **RESTful API**:
    - Built with Swagger OpenAPI documentation for easy testing and integration.

8. **Desktop UI**:
    - Swing-based desktop UI using MigLayout and GridBagLayout for a user-friendly interface.

## Technologies Used
- **Backend**: Java 17, Spring Boot, Oracle SQL
- **Frontend**: Swing (MigLayout, GridBagLayout)
- **Testing**: JUnit, Mockito, Postman
- **Containerization**: Docker
- **Documentation**: Markdown

## Prerequisites
- Java 17 JDK
- Docker
- Maven

## Setup Instructions

### 1. Clone the Repository
```bash
git clone <repository-url>
cd employee-records-management-system
```
### 2. Build the Application
```bash
mvn clean install
```
### 3. Run the Application Using Docker
```bash
docker-compose up
```