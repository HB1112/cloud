<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>로그인</title>
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
        .form-container {
            background: #fff;
            padding: 50px;
            border-radius: 15px;
            box-shadow: 0 8px 12px rgba(0, 0, 0, 0.1);
            width: 400px;
            box-sizing: border-box;
        }
        .form-container h1 {
            font-size: 32px;
            margin-bottom: 30px;
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 25px;
        }
        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
            font-size: 16px;
            color: #555;
        }
        .form-group input {
            width: 100%;
            padding: 15px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 16px;
            box-sizing: border-box;
        }
        .form-group input:focus {
            border-color: #007bff;
            outline: none;
        }
        .form-actions {
            display: flex;
            justify-content: space-between;
            gap: 20px;
        }
        .form-actions button {
            flex: 1;
            padding: 15px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
        }
        .form-actions .login-btn {
            background-color: #00bfff;
            color: white;
        }
        .form-actions .cancel-btn {
            background-color: #ff6347;
            color: white;
        }
        .form-actions button:hover {
            opacity: 0.9;
        }
        .link {
            text-align: center;
            margin-top: 15px;
        }
        .link a {
            color: #007bff;
            text-decoration: none;
        }
        .link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
	
    <div class="form-container">
        <h1>로그인</h1>
        <%
			String error = (String)request.getAttribute("error");
			System.out.println("로그인 에러 : "+error);
			if (error != null) {
				out.println("<div class='alert alert-danger'>");
				out.println("아이디와 비밀번호를 확인해 주세요");
				out.println("</div>");
			}
			
		%>
		<% 
		    String emailCheckError = (String) request.getAttribute("emailCheckError");
		    System.out.println("이메일 인증 에러 : " + emailCheckError);
		    if (emailCheckError != null) {
		%>
		    <div class='alert alert-warning'>
		        <%= emailCheckError %>
		    </div>
		<% 
		    } 
		%>
        <form action="login" method="post">
            <div class="form-group">
                <label for="username">아이디</label>
                <input type="text" id="id" name="id" placeholder="아이디 입력">
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="pw" name="pw" placeholder="비밀번호 입력">
            </div>
            <div class="form-actions">
                <button type="submit" class="login-btn">로그인</button>
            </div>
        </form>
        <div class="link">
            <p><a href="addmember">회원가입</a></p>
        </div>
    </div>
</body>
</html>