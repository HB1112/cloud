<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Community</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            text-align: center;
        }
        .button {
            display: inline-block;
            padding: 15px 30px;
            margin: 10px;
            font-size: 18px;
            color: white;
            background-color: #007BFF;
            border: none;
            border-radius: 5px;
            text-decoration: none;
        }
        .button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/navbar.jsp" %>
    <div class="container">
        <h1>Solocare 커뮤니티</h1>
        <a class="button" href="board?category=tip">정보 공유</a>
        <a class="button" href="board?category=free">자유 게시판</a>
        <a href="board?category=sell" class="button">판매하기</a>
        <a href="board?category=buy" class="button">구매하기</a>
    </div>
</body>
</html>