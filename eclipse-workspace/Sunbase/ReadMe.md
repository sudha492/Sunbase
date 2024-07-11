Sunbase PROJECT:

    Overview :
        The Sunbase Project is a web application that provides functionality for managing student records. It allows users to perform CRUD (Create, Read, Update, Delete) operations on a student database. The application is built using Java EE, Servlets, JDBC, JSP, and JSTL.

    Features :
        Create: Add new students to the database.
        Read: View a list of all students.
        Update: Update details of existing students.
        Delete: Remove students from the database.

    Prerequisites :
        JDK 8 or later
        Apache Tomcat 9 or later
        MySQL database
        IDE with support for Java EE (e.g., Eclipse)
        `jstl.jar` and `standard.jar` for JSTL support

    Database Setup
        1. Create a database named `student_db`:
            CREATE DATABASE student_db;

        2. Create the `students` table:
            CREATE TABLE students (
                id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
                name VARCHAR(50),
                email VARCHAR(50) UNIQUE,
                age INT
                );      

    Project Setup
        1. Clone the repository:
            git clone <your-github-repo-link>

        2. Open the project in your IDE.

        3. Configure the project build path to include the necessary JAR files for JDBC, Servlets, and JSTL (`jstl.jar` and `standard.jar`).

        4. Update the database connection details in `connection.java`:
            private static final String URL = "jdbc:mysql://localhost:3306/student_db";
            private static final String USER = "root";
            private static final String PASSWORD = "yourpassword";

    Running the Application
        1. Deploy the project to your Apache Tomcat server.

        2. Access the application in your web browser:
            Example : http://localhost:8080/Sunbase/

    Project Structure
        src/main/java/com/tap/Connection: Contains the database connection utility class.
            connection.java: Utility class for managing database connections.

        src/main/java/com/tap/Dao: Contains the Data Access Object (DAO) classes.
            StudentDao.java
            StudentDaoImpl.java

        src/main/java/com/tap/Entity: Contains the entity class.
            StudentEntity.java

        src/main/java/com/tap/Servlets: Contains the servlets for CRUD operations.
            CreateServlet.java
            DeleteServlet.java
            ReadServlet.java
            SearchServlet.java
            UpdateServlet.java
            UpdateStudentServlet.java
    
        src/main/webapp: Contains the JSP pages and other web resources.
            index.jsp: Home page.
            add.jsp: Form for adding a new student.
            displayStudents.jsp: Displays the list of students.
            search.jsp: Form for searching students.
            searchResults.jsp: Displays search results.
            updateStudentDetails.jsp: Form for updating student details.
            WEB-INF :
                lib :
                    jstl-1.2.jar
                    mysql-connector-j-8.3.0.jar
                    standard.jar
                web.xml : Servlet configuration file.
            web1.css: Stylesheet for the application.

    CRUD Operations :
        Create
            Form: add.jsp
            Servlet: CreateServlet.java

        Read
            Page: displayStudents.jsp
            Servlet: ReadServlet.java

        Update
            Form: updateStudentDetails.jsp

        Servlet: UpdateServlet.java and UpdateStudentServlet.java

        Delete
            Page: displayStudents.jsp (contains delete links)
            Servlet: DeleteServlet.java

    Contact :
        For any questions or support, please contact [gunisudharani492@example.com].
