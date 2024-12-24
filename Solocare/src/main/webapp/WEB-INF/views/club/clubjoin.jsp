<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>클럽 가입</title>
    <script>
        // 페이지가 로드될 때 오류 메시지가 있는지 확인
        <c:if test="${not empty errorMessage}">
            alert("${errorMessage}"); // 오류 메시지를 alert로 표시
        </c:if>
    </script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light fixed-top">
         <%@ include file="/WEB-INF/views/menu.jsp" %>
    </nav>
    <form action="${pageContext.request.contextPath}/club/join" method="post">
        <p><label>회원 아이디:</label>
        <input name="memberId" type="text" value="${mem.id}" required>
        <p><label>동호회 이름:</label>
        <input name="clubNum" type="hidden" value="${club.clubNum}">
        <input name="clubName" type="text" value="${club.clubName}" required>
        <p><label>회원 연락처:</label>
        <input name="memberphone" type="text" value="${mem.phone}" required>
        <p><label>회원 이메일:</label>
        <input name="memberemail" type="text" value="${mem.email}" required>
        <p><input type="submit" value="가입신청">
        <input type="reset" value="취소">
    </form>
</body>
</html>
