<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/navbar.jsp" %>
	<form action="update" method="POST">
    <input type="hidden" name="oldTitle" value="${event.title}">
    
    <label for="newTitle">제목:</label>
    <input type="text" id="newTitle" name="newTitle" value="${event.title}" required>

    <label for="start">시작 시간:</label>
    <input type="datetime-local" id="start" name="start" value="${event.start}" required>

    <label for="end">종료 시간:</label>
    <input type="datetime-local" id="end" name="end" value="${event.end}" required>

    <label for="description">설명:</label>
    <textarea id="description" name="description">${event.description}</textarea>

    <button type="submit">수정 완료</button>
    <button type="button" onclick="window.history.back();">취소</button>
</form>
</body>
</html>