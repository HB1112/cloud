<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
<style> 
        /* CSS 코드 여기 삽입 */
        body {
            background-color: #f8f9fa; /* 배경 색상 */
            margin: 0;
            padding: 0;
            font-family: 'Noto Sans', sans-serif; /* 폰트 설정 */
        }

        .form-container {
            max-width: 600px; /* 최대 너비 설정 */
            margin: 50px auto; /* 중앙 정렬 */
            padding: 20px; /* 패딩 */
            background-color: white; /* 배경 색상 */
            border-radius: 8px; /* 모서리 둥글게 */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
        }

        h2 {
            font-size: 1.5rem; /* 제목 크기 */
            margin-bottom: 20px; /* 아래쪽 여백 */
            color: #333; /* 제목 색상 */
            text-align: center; /* 중앙 정렬 */
        }

        .mb-3 {
            margin-bottom: 15px; /* 각 입력 필드 간 간격 */
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
        }

        input[type="submit"],
        input[type="reset"] {
            padding: 10px 15px; /* 버튼 패딩 */
            border: none; /* 테두리 없음 */
            border-radius: 4px; /* 모서리 둥글게 */
            cursor: pointer; /* 커서 포인터 */
            font-size: 16px; /* 글씨 크기 */
            transition: background-color 0.3s ease; /* 배경색 변화 효과 */
        }

        input[type="submit"] {
            background-color: #007bff; /* 제출 버튼 색상 */
            color: white; /* 글씨 색상 */
        }

        input[type="reset"] {
            background-color: #6c757d; /* 취소 버튼 색상 */
            color: white; /* 글씨 색상 */
        }

        input[type="submit"]:hover {
            background-color: #0056b3; /* 버튼 호버 색상 */
        }

        input[type="reset"]:hover {
            background-color: #5a6268; /* 버튼 호버 색상 */
        }
    </style>
</head>
      
<body>
	<%@ include file="/WEB-INF/views/navbar.jsp" %>
<div class="form-container">
    <h2>게시글 작성</h2>
    <form name="newWrite" action="writeclub" method="post" >

        <div class="mb-3">
            <label>아이디</label>
            <input name="memberid" type="text" class="form-control" value="${mem.id}" readonly>
        </div>

        <div class="mb-3">
            <label>제목</label>
            <input name="subject" type="text" class="form-control" placeholder="제목을 입력하세요" required>
        </div>

        <div class="mb-3">
            <label>내용</label>
            <textarea name="content" cols="50" rows="5" class="form-control" placeholder="내용을 입력하세요" required></textarea>
        </div>

        <!-- 클럽 번호 입력 필드 추가 (맨 아래로 이동) -->
        <input type="hidden" name="clubNum" value="${clubNum}">

        <div class="mb-3">
            <input type="submit" class="btn btn-primary" value="등록">				
            <input type="reset" class="btn btn-secondary" value="취소">
        </div>
    </form>
</div>
</body>
</html>