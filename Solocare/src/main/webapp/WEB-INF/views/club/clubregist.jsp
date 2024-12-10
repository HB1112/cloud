<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 등록</title>
</head>
<body>
	    <h1>동호회 등록</h1>
    <form name="newClub" action="regist" method="post">
        <div>
            <label>회원 아이디:</label>
            <input name="clubLeader" type="text" required>
        </div>
        <div>
            <label>동호회 번호:</label>
            <input name="clubNum" type="number" required>
        </div>
        <div>
            <label>동호회명:</label>
            <input name="clubName" type="text" required>
        </div>
        <div>
            <label>동호회 설명:</label>
            <textarea name="clubDescription" required></textarea>
        </div>
        <div>
            <label>동호회 카테고리:</label>
            <input name="clubCategory" type="text" required>
        </div>
        <div>
            <label>동호회 위치:</label>
            <input name="clubLocation" type="text" required>
        </div>
        <div>
            <button type="submit">등록</button>
        </div>
    </form>
</body>
</html>