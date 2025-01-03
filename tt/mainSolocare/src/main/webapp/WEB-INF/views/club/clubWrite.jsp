<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성</title>
</head>
<body>
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