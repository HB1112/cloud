<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>일정 수정</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            padding: 20px;
            background-color: #f4f4f4;
            border-radius: 8px;
        }
        h2 {
            color: #333;
        }
        label {
            display: block;
            margin: 10px 0 5px;
        }
        input, textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            padding: 10px 15px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        button:hover {
            background-color: #2980b9;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            color: #3498db;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light fixed-top">
         <%@ include file="/WEB-INF/views/menu.jsp" %>
    </nav>

<h2>일정 수정</h2>

<form action="update" method="post">
    <div>
    	<input type="hidden" id="calendarNum" name="calendarNum" value="${calendarNum}">
    </div>
    <div>
        <label for="userId">사용자 ID:</label>
        <input type="text" id="userId" name="userId" value="${calendar.userId}" readonly>
    </div>
    <div>
        <label for="title">제목:</label>
        <input type="text" id="title" name="title" value="${calendar.title}" required>
    </div>
    <div>
        <label for="start">시작:</label>
        <input type="datetime-local" id="start" name="start" value="${calendar.start}" required>
    </div>
    <div>
        <label for="end">종료:</label>
        <input type="datetime-local" id="end" name="end" value="${calendar.end}" required>
    </div>
    <div>
        <label for="description">내용:</label>
        <textarea id="description" name="description" rows="4" cols="50" required>${calendar.description}</textarea>
    </div>
    <div>
        <button type="submit">수정</button>
    </div>
</form>

<a href="../list">목록으로 돌아가기</a>

</body>
</html>
