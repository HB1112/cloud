<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
    function checkForm() {
        if (!document.newWrite.id.value) {
            alert("아이디를 입력하세요.");
            return false;
        }
        if (!document.newWrite.subject.value) {
            alert("제목을 입력하세요.");
            return false;
        }
        if (!document.newWrite.content.value) {
            alert("내용을 입력하세요.");
            return false;
        }		
       
    }
    function goToDetail() {
        // 상세 페이지 URL로 이동
        window.location.href = 'detail?boardnum=' + document.newWrite.num.value; // 게시글 번호에 맞게 URL 수정
    }
</script>
<body>
	<%@ include file="/WEB-INF/views/navbar.jsp" %>
	<div class="form-container">
        <h2>게시글 수정하기</h2>
        <form name="newWrite" action="updateclubboard" method="post" onsubmit="return checkForm()">
            <input type="hidden" name="boardnum" value="${clubboard.boardnum}"/> <!-- 게시글 번호 -->
            <input type="hidden" name="regist_date" value="${clubboard.regist_date}"/> <!-- 등록 날짜 -->
            <input type="hidden" name="hit" value="${clubboard.hit}"/> <!-- 조회수 -->
			<input type="hidden" name="clubNum" value="${clubboard.clubNum}"/> <!-- 조회수 -->
            

            <div class="mb-3">
                <label>아이디</label>
                <input name="id" type="text" class="form-control" value="${clubboard.memberid}" readonly>
            </div>

            <div class="mb-3">
                <label>제목</label>
                <input name="subject" type="text" class="form-control" value="${clubboard.subject}">
            </div>

            <div class="mb-3">
                <label>내용</label>
    			<textarea name="content" class="form-control textarea-large">${clubboard.content}</textarea>
            </div>

            <div class="mb-3">
                <input type="submit" class="btn btn-primary" value="수정">				
                <button type="button" class="btn btn-primary" onclick="goToDetail()">취소</button>
            </div>
        </form>
    </div>
</body>
</html>