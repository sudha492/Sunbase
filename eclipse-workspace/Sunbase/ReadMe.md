# Sunbase Project

Sunbase Project is a web application that provides functionality for managing student records. It allows users to perform CRUD (Create, Read, Update, Delete) operations on a student database. The application is built using Java EE, Servlets, JDBC, JSP, and JSTL.

## Features

- **Create**: Add new students to the database.
- **Read**: View a list of all students.
- **Update**: Update details of existing students.
- **Delete**: Remove students from the database.

## Prerequisites

- JDK 8 or later
- Apache Tomcat 9 or later
- MySQL database
- IDE with support for Java EE (e.g., Eclipse)
- `jstl.jar` and `standard.jar` for JSTL support

## Database Setup

1. Create a database named `student_db`:

    ```sql
    CREATE DATABASE student_db;
    ```

2. Create the `students` table:

    ```sql
    CREATE TABLE students (
        id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
        name VARCHAR(50),
        email VARCHAR(50) UNIQUE,
        age INT
    );
    ```
## Sample Data Insertion

Insert sample data into the `students` table:

```sql
INSERT INTO students (name, email, age) VALUES ('John Doe', 'john.doe@example.com', 20);
INSERT INTO students (name, email, age) VALUES ('Jane Smith', 'jane.smith@example.com', 22);
INSERT INTO students (name, email, age) VALUES ('Michael Johnson', 'michael.johnson@example.com', 19);
INSERT INTO students (name, email, age) VALUES ('Emily Davis', 'emily.davis@example.com', 21);
INSERT INTO students (name, email, age) VALUES ('David Brown', 'david.brown@example.com', 23);
INSERT INTO students (name, email, age) VALUES ('Linda Williams', 'linda.williams@example.com', 20);
INSERT INTO students (name, email, age) VALUES ('Chris Wilson', 'chris.wilson@example.com', 22);
INSERT INTO students (name, email, age) VALUES ('Jessica Garcia', 'jessica.garcia@example.com', 19);
INSERT INTO students (name, email, age) VALUES ('Daniel Martinez', 'daniel.martinez@example.com', 21);
INSERT INTO students (name, email, age) VALUES ('Sarah Robinson', 'sarah.robinson@example.com', 23);
```
## Project Setup

1. Clone the repository.

2. Open the project in your IDE.

3. Configure the project build path to include the necessary JAR files for JDBC, Servlets, and JSTL (`jstl.jar` and `standard.jar`).

4. Update the database connection details in `connection.java`:

    ```java
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USER = "root";
    private static final String PASSWORD = "yourpassword";
    ```

## Running the Application

1. Deploy the project to your Apache Tomcat server.

2. Access the application in your web browser:

    Example: `http://localhost:8085/Sunbase/`

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── tap/
│   │           ├── Connection/
│   │           │   └── connection.java
│   │           ├── Dao/
│   │           │   ├── StudentDao.java
│   │           │   └── StudentDaoImpl.java
│   │           ├── Entity/
│   │           │   └── StudentEntity.java
│   │           └── Servlets/
│   │               ├── CreateServlet.java
│   │               ├── DeleteServlet.java
│   │               ├── ReadServlet.java
│   │               ├── SearchServlet.java
│   │               ├── UpdateServlet.java
│   │               └── UpdateStudentServlet.java
│   └── webapp/
│       ├── index.jsp
│       ├── add.jsp
│       ├── displayStudents.jsp
│       ├── search.jsp
│       ├── searchResults.jsp
│       ├── updateStudentDetails.jsp
│       ├── WEB-INF/
│       │   ├── lib/
│       │   │   ├── jstl-1.2.jar
│       │   │   ├── mysql-connector-j-8.3.0.jar
│       │   │   └── standard.jar
│       │   └── web.xml
│       └── web1.css
```

## CRUD Operations

### Create

- **Form**: `add.jsp`
- **Servlet**: `CreateServlet.java`

### Read

- **Page**: `displayStudents.jsp`
- **Servlet**: `ReadServlet.java`

### Update

- **Form**: `updateStudentDetails.jsp`
- **Servlet**: `UpdateServlet.java` and `UpdateStudentServlet.java`

### Delete

- **Page**: `displayStudents.jsp` (contains delete links)
- **Servlet**: `DeleteServlet.java`

## Screenshots

Here are some screenshots of the project:

## index.jsp
![Screenshot 2024-07-19 151431](https://github.com/user-attachments/assets/25af170a-74e4-4078-b7b2-8a47ce466744)

## add.jsp
![Screenshot 2024-07-19 151448](https://github.com/user-attachments/assets/f6a63a6f-2ec0-4be3-aef6-0e85bf6ee83c)

## search.jsp
![Screenshot 2024-07-19 151503](https://github.com/user-attachments/assets/b85a4ded-a618-4f7b-a6eb-b8d817ff0574)

## displayStudents.jsp
![Screenshot 2024-07-19 151517](https://github.com/user-attachments/assets/4b6cef61-4967-4d0f-beb5-dd610568828c)

## searchResults.jsp
![Screenshot 2024-07-19 160556](https://github.com/user-attachments/assets/8c82ba29-aed0-453e-bdd9-bc21d29add56)

## UpdateStudentDetails.jsp
![Screenshot 2024-07-19 160618](https://github.com/user-attachments/assets/7fc39f94-1648-4ae0-b9f8-1a4755c9c3af)


## Contact

For any questions or support, please contact [gunisudharani492@example.com].
