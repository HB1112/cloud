<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일정 추가</title>
<style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .form-group {
            margin-bottom: 15px;
        }
        label {
            display: block;
            margin-bottom: 5px;
        }
        input[type="text"], input[type="datetime-local"] {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }
        button {
            padding: 10px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light fixed-top">
         <%@ include file="/WEB-INF/views/menu.jsp" %>
    </nav>
<form action="calendar" method="post">
    <div>
        <label for="userId">아이디:</label>
        <input type="text" id="userId" name="userId" value="${userId}" readonly>
    </div>
    <div>
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" required>
    </div>
    <div>
        <label for="description">내용:</label>
        <input type="text" id="description" name="description" required>
    </div>
    <div>
        <label for="start">시작:</label>
        <input type="datetime-local" id="start" name="start" required>
    </div>
    <div>
        <label for="end">종료:</label>
        <input type="datetime-local" id="end" name="end" required>
    </div>
    <div>
        <input type="submit" value="추가" />
    </div>
</form>
</body>
</html>