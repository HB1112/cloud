<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 성공</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #eaf8ff;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .message-container {
            background: #fff;
            padding: 50px;
            border-radius: 15px;
            box-shadow: 0 8px 12px rgba(0, 0, 0, 0.1);
            width: 600px;
            box-sizing: border-box;
            text-align: center;
        }
        .message-container h1 {
            font-size: 32px;
            margin-bottom: 20px;
            color: #333;
        }
        .message-container p {
            font-size: 18px;
            margin-bottom: 30px;
            color: #555;
        }
        .message-container a {
            display: inline-block;
            padding: 15px 30px;
            background-color: #00bfff;
            color: white;
            border-radius: 8px;
            text-decoration: none;
            font-size: 16px;
            transition: opacity 0.3s;
        }
        .message-container a:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>
    <div class="message-container">
        <h1>회원가입이 완료되었습니다.</h1>
        <p>솔로케어에 오신걸 환영합니다.</p>
        <a href="login">로그인</a>
    </div>
</body>
</html>