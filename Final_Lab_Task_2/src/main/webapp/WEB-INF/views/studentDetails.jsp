<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Details</title>
</head>
<body>
<h2>Student Details</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Date of Birth</th>
        <th>Gender</th>
        <th>Quota</th>
        <th>Country</th>
    </tr>
    <tr>
        <td>${student.id}</td>
        <td>${student.name}</td>
        <td>${student.email}</td>
        <td>${student.dateOfBirth}</td>
        <td>${student.gender}</td>
        <td>${student.quota}</td>
        <td>${student.country}</td>
    </tr>
</table>
<br>
<a href="<c:url value='/students'/>">Back to All Students</a>
</body>
</html>
