<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Results</title>
<link rel="stylesheet" href="web1.css">
<style>
td{
color:black;}</style>
</head>
<body>
    <header>
        <h1>Student Management System</h1>
         <a href="${pageContext.request.contextPath}/index.jsp" class="home-button">Home</a>
      
    </header>
    <div class="container">
        <h1>Search Results</h1>
        <c:if test="${empty students1}">
            <p class="message">No results found.</p>
        </c:if>
        <c:if test="${not empty students1}">
            <table>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Age</th>
                </tr>
                <c:forEach var="student" items="${students1}">
                    <tr>
                        <td>${student.id}</td>
                        <td>${student.name}</td>
                        <td>${student.email}</td>
                        <td>${student.age}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
    <footer>
        <p>&copy; 2024 Student Management System. All rights reserved.</p>
    </footer>
</body>
</html>
