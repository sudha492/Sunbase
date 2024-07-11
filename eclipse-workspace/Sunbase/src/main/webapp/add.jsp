<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System - Add Data</title>
<link rel="stylesheet" href="web1.css">
<script>
function validateForm() {
   var id = document.getElementById('id').value;
   var name = document.getElementById('name').value;
   var email = document.getElementById('email').value;
   var age = document.getElementById('age').value;
   var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

   if (id === "" || name === "" || email === "" || age === "") {
       alert("All fields must be filled out");
       return false;
   }

   if (!emailPattern.test(email)) {
       alert("Please enter a valid email address");
       return false;
   }

   return true;
}
</script>
</head>
<body>
    <header>
        <h1>Student Management System</h1>
         <a href="${pageContext.request.contextPath}/index.jsp" class="home-button">Home</a>
      
    </header>
    <div class="container">
        <h1>Add Student Data</h1>
        <form action="create" onsubmit="return validateForm()">
            <label for="id">Student ID:</label>
            <input type="number" id="id" name="id" placeholder="Enter student ID"><br>
            <label for="name">Student Name:</label>
            <input type="text" id="name" name="name" placeholder="Enter student name"><br>
            <label for="email">Student Email:</label>
            <input type="text" id="email" name="email" placeholder="Enter student email"><br>
            <label for="age">Student Age:</label>
            <input type="number" id="age" name="age" placeholder="Enter student age"><br>
            <input type="submit" value="Submit">
        </form>
    </div>
    <footer>
        <p>&copy; 2024 Student Management System. All rights reserved.</p>
    </footer>
</body>
</html>
