<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System - Search</title>
<link rel="stylesheet" href="web1.css">
<script>
function validateForm() {
    var criterion = document.getElementById('criterion').value;
    var value = document.getElementById('value').value;

    if (value === "") {
        alert("Please enter a value to search");
        return false;
    }

    if (criterion === "age" && isNaN(value)) {
        alert("Please enter a valid number for age");
        return false;
    }
    if (criterion === "id" && isNaN(value)) {
        alert("Please enter a valid number for id");
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
        <h1>Search Student</h1>
        <form action="search" onsubmit="return validateForm()">
            <label for="criterion">Search by:</label>
            <select name="criterion" id="criterion">
                <option value="id">ID</option>
                <option value="name">Name</option>
                <option value="email">Email</option>
                <option value="age">Age</option>
            </select><br>
            <label for="value">Value:</label>
            <input type="text" name="value" id="value" placeholder="Enter search value"><br>
            <input type="submit" value="Submit">
        </form>
    </div>
    <footer>
        <p>&copy; 2024 Student Management System. All rights reserved.</p>
    </footer>
</body>
</html>
