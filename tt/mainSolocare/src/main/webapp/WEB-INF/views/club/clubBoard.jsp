<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700&family=Noto+Serif:wght@400;700&display=swap" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>동호회 커뮤니티</title>
<style>
    body {
        margin-top: 80px; /* 내비게이션 바의 높이에 맞게 여백 추가 */
    }
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light fixed-top">
        <%@ include file="../menu.jsp"%>
    </nav>
	
	<div class="container mt-4"> <!-- 추가적인 여백을 위해 container 사용 -->
		<h1>동호회</h1>
		<nav>
			<a href="list" class="btn btn-secondary">동호회 목록</a>
			<form action="myclub" method="post" style="display: inline;">
			    <input type="hidden" name="id" value="${mem.id}"> <!-- 세션에서 가져온 멤버 ID로 설정 -->
			    <button type="submit" class="btn btn-warning">내 동호회</button>
			</form>
		</nav>
	</div>
</body>
</html>