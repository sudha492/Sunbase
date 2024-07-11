<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<link rel="stylesheet" href="web1.css">
</head>
<body>
    <header>
        <h1>Student Management System</h1>
          <a href="${pageContext.request.contextPath}/index.jsp" class="home-button">Home</a>
      
    </header>
    <div class="container">
        <h1>Welcome to the Student Management System</h1>
        <div class="links">
            <div class="box"><a href="add.jsp">Add Student</a></div>
            <div class="box"><a href="search.jsp">Search Students</a></div>
            <div class="box"><a href="displayStudents">View All Students</a></div>
            <div class="box"><a href="displayStudents">Update Student</a></div>
            <div class="box"><a href="displayStudents">Delete Student</a></div>
        </div>
    </div>
    <footer>
        <p>&copy; 2024 Student Management System. All rights reserved.</p>
    </footer>
</body>
</html>
