<%--
  Created by IntelliJ IDEA.
  User: apurbadebnath
  Date: 12/12/23
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<h2>Edit Student</h2>
<form action="<c:url value='/students/${student.id}/edit' />" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="${student.name}" required><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="${student.email}" required><br>

    <label for="dateOfBirth">Date of Birth:</label>
    <input type="date" id="dateOfBirth" name="dateOfBirth" value="${student.dateOfBirth}" required><br>

    <label for="gender">Gender:</label>
    <select id="gender" name="gender">
        <c:forEach var="gender" items="${genders}">
            <option value="${gender}" ${student.gender == gender ? 'selected' : ''}>${gender}</option>
        </c:forEach>
    </select><br>

    <label for="quota">Quota:</label>
    <input type="text" id="quota" name="quota" value="${student.quota}" required><br>

    <label for="country">Country:</label>
    <input type="text" id="country" name="country" value="${student.country}" required><br>

    <input type="submit" value="Update">
</form>
<br>
<a href="<c:url value='/students'/>">Cancel</a>
</body>
</html>

