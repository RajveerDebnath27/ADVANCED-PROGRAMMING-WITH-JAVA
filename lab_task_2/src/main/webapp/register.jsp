<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>User Registration</title>
  <style>
    body {
      font-family: 'Arial', sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
    }

    .registration-container {
      text-align: center;
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
      color: #333;
    }

    form {
      display: flex;
      flex-direction: column;
      max-width: 300px;
      margin: auto;
    }

    label {
      margin-bottom: 5px;
    }

    input {
      margin-bottom: 15px;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 3px;
      box-sizing: border-box;
    }

    input[type="submit"] {
      background-color: #007bff;
      color: #fff;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
<div class="registration-container">
  <h2>User Registration</h2>
  <form action="RegisterServlet" method="post">
    <label>Email:</label>
    <input type="email" name="email" required>

    <label>Full Name:</label>
    <input type="text" name="fullName" required>

    <label>Password:</label>
    <input type="password" name="password" required>

    <input type="submit" value="Register">
  </form>
</div>
</body>
</html>
