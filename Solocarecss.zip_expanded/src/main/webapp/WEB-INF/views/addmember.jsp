<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
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
            overflow: hidden; /* 스크롤 숨기기 */
        }
        .form-container {
            background: #fff;
            padding: 30px; /* 패딩 줄임 */
            border-radius: 15px;
            box-shadow: 0 8px 12px rgba(0, 0, 0, 0.1);
            width: 600px;
            box-sizing: border-box;
        }
        .form-container h1 {
            font-size: 28px; /* 제목 크기 줄임 */
            margin-bottom: 20px; /* 마진 줄임 */
            text-align: center;
            color: #333;
        }
        .form-group {
            margin-bottom: 20px; /* 마진 줄임 */
        }
        .form-group label {
            display: block;
            margin-bottom: 6px; /* 마진 줄임 */
            font-weight: bold;
            font-size: 16px;
            color: #555;
        }
        .form-group input {
            width: 100%;
            padding: 12px; /* 패딩 줄임 */
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 16px;
            box-sizing: border-box;
        }
        .form-group input:focus {
            border-color: #007bff;
            outline: none;
        }
        .email-input-container {
            display: flex;
            align-items: center;
            gap: 10px;
        }
        .email-input-container input,
        .email-input-container select {
            flex: 1;
            padding: 12px; /* 패딩 줄임 */
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 16px;
            box-sizing: border-box;
        }
        .email-input-container input:focus,
        .email-input-container select:focus {
            border-color: #007bff;
            outline: none;
        }
        .form-actions {
            display: flex;
            justify-content: space-between;
            gap: 15px;
        }
        .form-actions button {
            flex: 1;
            padding: 12px; /* 패딩 줄임 */
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
        }
        .form-actions .submit-btn {
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
    </style>
</head>
<body>
    <div class="form-container">
        <h1>회원가입</h1>
        <form action="addmember" method="post">
            <div class="form-group">
                <label for="username">아이디</label>
                <input type="text" id="id" name="id" placeholder="아이디 입력 (6-20자)" required>
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input type="password" id="pw" name="pw" placeholder="비밀번호 입력 (8-20자)" required>
            </div>
            <div class="form-group">
                <label for="name">이름</label>
                <input type="text" id="name" name="name" placeholder="이름을 입력하세요" required>
            </div>
            <div class="form-group">
                <label for="phone">전화번호</label>
                <input type="text" id="phone" name="phone" placeholder="휴대폰 번호 (11자리 입력)" required>
            </div>
            <div class="form-group">
                <label for="email">이메일 주소</label>
                <div class="email-input-container">
                    <input type="text" id="email" name="email" placeholder="이메일 입력" required>
                    <span>@</span>
                    <select name="mailDomain">
                        <option value="naver.com">naver.com</option>
                        <option value="gmail.com">gmail.com</option>
                        <option value="daum.net">daum.net</option>
                        <option value="yahoo.com">yahoo.com</option>
                        <option value="custom">직접 입력</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label for="birth">생년월일</label>
                <input type="date" id="birth" name="birth" required>
            </div>
            <div class="form-group">
                <label for="confirm-password">주소</label>
                <input type="text" id="address" name="address" placeholder="주소를 입력해주세요" required>
            </div>
            <div class="form-actions">
                <button type="submit" class="submit-btn">가입하기</button>
            </div>
        </form>
    </div>
</body>
</html>