<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>All Students</title>
</head>
<body>
<h2>All Students</h2>
<table border="1">
  <thead>
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Date of Birth</th>
    <th>Gender</th>
    <th>Quota</th>
    <th>Country</th>
    <th>Actions</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="student" items="${students}">
    <tr>
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.email}</td>
      <td>${student.dateOfBirth}</td>
      <td>${student.gender}</td>
      <td>${student.quota}</td>
      <td>${student.country}</td>
      <td>
        <a href="<c:url value='/students/${student.id}'/>">Details</a> |
        <a href="<c:url value='/students/${student.id}/edit' />">Edit</a> |
        <a href="<c:url value='/students/${student.id}/delete' />">Delete</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
