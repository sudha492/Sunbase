<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Student</title>
<link rel="stylesheet" href="web1.css">
</head>
<body>
    <header>
        <h1>Student Management System</h1>
         <a href="${pageContext.request.contextPath}/index.jsp" class="home-button">Home</a>
      
    </header>
    <div class="container">
        <h1>Update Student</h1>
        <form action="${pageContext.request.contextPath}/updateStudent" method="post">
            <input type="hidden" name="id" value="${student.id}">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${student.name}"><br>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" value="${student.email}"><br>
            <label for="age">Age:</label>
            <input type="number" id="age" name="age" value="${student.age}"><br>
            <input type="submit" value="Update">
        </form>
    </div>
    <footer>
        <p>&copy; 2024 Student Management System. All rights reserved.</p>
    </footer>
</body>
</html>
