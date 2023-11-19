<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Welcome</title>
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

    .welcome-container {
      text-align: center;
      background-color: #fff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
      color: #333;
    }

    p {
      color: #555;
    }

    ul {
      list-style-type: none;
      padding: 0;
      margin: 10px 0;
    }

    li {
      display: inline-block;
      margin-right: 10px;
    }

    a {
      text-decoration: none;
      color: #007bff;
    }

    a:hover {
      text-decoration: underline;
    }

    .logout-btn {
      display: inline-block;
      padding: 8px 15px;
      background-color: #dc3545;
      color: #fff;
      border: none;
      border-radius: 3px;
      cursor: pointer;
    }

    .logout-btn:hover {
      background-color: #c82333;
    }
  </style>
</head>
<body>
<div class="welcome-container">
  <h2>Welcome, ${fullName}!</h2>
  <p>
    Thank you for using our application.
  </p>
  <ul>
    <li><a href="LogoutServlet" class="logout-btn">Logout</a></li>
  </ul>
</div>
</body>
</html>
