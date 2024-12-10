<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
</head>
<body>
		<h1>글 작성</h1>
		<form action="write" method="post">
		<label for="clubName">동호회 이름:</label>
		<input type="text" id="clubName" name="clubName" required><br><br>

		<label for="clubDescription">동호회 설명:</label><br>
		<textarea id="clubDescription" name="clubDescription" rows="4" cols="50" required></textarea><br><br>

		<label for="clubCategory">동호회 카테고리:</label>
		<input type="text" id="clubCategory" name="clubCategory" required><br><br>

		<label for="clubLocation">동호회 위치:</label>
		<input type="text" id="clubLocation" name="clubLocation" required><br><br>

		<input type="submit" value="작성하기">
	</form>
</body>
</html>