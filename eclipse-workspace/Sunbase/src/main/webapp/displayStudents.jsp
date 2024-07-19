<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Students</title>
<link rel="stylesheet" href="web1.css">
<style>
td{
color:black;}</style>
<script>
function confirmDelete(studentId) {
    if (confirm("Are you sure you want to delete this student?")) {
        window.location.href = "delete?id=" + studentId;
    }
}
</script>
</head>
<body>
    <header>
        <h1>Student Management System</h1>
         <a href="${pageContext.request.contextPath}/index.jsp" class="home-button">Home</a>
      
    </header>
    <div class="container">
        <h1>Student List</h1>
       <c:if test="${not empty message}">
            <p class="message">${message}</p>
        </c:if> 
        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="student" items="${students}">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>${student.email}</td>
                    <td>${student.age}</td>
                    <td><a href="update?id=${student.id}" class="edit-link">Update</a></td>
                    <td><a href="#" onclick="confirmDelete(${student.id})" class="delete-link">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <footer>
        <p>&copy; 2024 Student Management System. All rights reserved.</p>
    </footer>
</body>
</html>
