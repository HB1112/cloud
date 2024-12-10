<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>일정 수정</title>
</head>
<body>

<h2>일정 수정</h2>

<form action="update" method="post">
    <div>
        <label for="id">ID:</label>
        <input type="text" id="id" name="id" value="${calendar.id}" readonly>
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
        <button type="submit">수정</button>
    </div>
</form>

<a href="../list">목록으로 돌아가기</a>

</body>
</html>