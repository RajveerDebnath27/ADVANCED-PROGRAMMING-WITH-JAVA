<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leave Calculator Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 20px;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h2 {
            color: #333;
        }

        p {
            margin: 10px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Leave Calculator Result</h2>
    <p><strong>Employee Type:</strong> ${employeeType}</p>
    <p><strong>Joining Date:</strong> ${joiningDate}</p>
    <p><strong>Vacation Leave:</strong> ${vacationLeave}</p>
    <p><strong>Sick Leave:</strong> ${sickLeave}</p>
</div>
</body>
</html>
