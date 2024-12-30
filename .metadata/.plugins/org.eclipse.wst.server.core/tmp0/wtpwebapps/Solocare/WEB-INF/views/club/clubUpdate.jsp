<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 정보 수정</title>
<style>
        /* CSS 코드 여기 삽입 */
        body {
            background-color: #f8f9fa; /* 배경 색상 */
            margin: 0;
            padding: 0;
            font-family: 'Noto Sans', sans-serif; /* 폰트 설정 */
        }

        h2 {
            text-align: center; /* 중앙 정렬 */
            margin: 20px 0; /* 여백 */
            color: #333; /* 색상 */
        }

        form {
            max-width: 600px; /* 최대 너비 설정 */
            margin: 30px auto; /* 중앙 정렬 */
            padding: 20px; /* 패딩 */
            background-color: white; /* 배경 색상 */
            border-radius: 8px; /* 모서리 둥글게 */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
        }

        label {
            display: block; /* 라벨을 블록으로 설정 */
            margin-bottom: 5px; /* 아래쪽 여백 */
            font-weight: bold; /* 글씨 굵게 */
            color: #555; /* 글씨 색상 */
        }

        input[type="text"],
        textarea {
            width: 100%; /* 너비 100% */
            padding: 10px; /* 패딩 */
            border: 1px solid #ccc; /* 테두리 */
            border-radius: 4px; /* 모서리 둥글게 */
            box-sizing: border-box; /* 박스 사이징 */
            margin-bottom: 15px; /* 아래쪽 여백 */
        }

        input[type="submit"] {
            padding: 10px 15px; /* 버튼 패딩 */
            border: none; /* 테두리 없음 */
            border-radius: 4px; /* 모서리 둥글게 */
            cursor: pointer; /* 커서 포인터 */
            font-size: 16px; /* 글씨 크기 */
            transition: background-color 0.3s ease; /* 배경색 변화 효과 */
        }

        input[type="submit"]:nth-of-type(1) {
            background-color: #007bff; /* 수정 완료 버튼 색상 */
            color: white; /* 글씨 색상 */
        }

        input[type="submit"]:nth-of-type(2) {
            background-color: #dc3545; /* 삭제 버튼 색상 */
            color: white; /* 글씨 색상 */
        }

        input[type="submit"]:nth-of-type(1):hover {
            background-color: #0056b3; /* 수정 버튼 호버 색상 */
        }

        input[type="submit"]:nth-of-type(2):hover {
            background-color: #c82333; /* 삭제 버튼 호버 색상 */
        }
    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/navbar.jsp" %>
	<h2>동호회 정보 수정</h2>
	<form action="${pageContext.request.contextPath}/club/update/submit" method="post">
	    <input type="hidden" name="clubNum" value="${club.clubNum}"/>
	    <label for="clubName">클럽 이름:</label>
	    <input type="text" id="clubName" name="clubName" value="${club.clubName}" required/><br/>
	    
	    <label for="clubLeader">회장:</label>
	    <input type="text" id="clubLeader" name="clubLeader" value="${club.clubLeader}" readonly/><br/>
	    
	    <label for="clubDescription">설명:</label>
	    <textarea id="clubDescription" name="clubDescription" required>${club.clubDescription}</textarea><br/>
	    
	    <input type="hidden" id="clubCategory" name="clubCategory" value="${club.clubCategory}" required/><br/>
	    <input type="submit" value="수정"/>
	</form>
</body>
</html>