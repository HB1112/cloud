<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 정보 수정</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light fixed-top">
         <%@ include file="/WEB-INF/views/menu.jsp" %>
    </nav>
	<h2>동호회 정보 수정</h2>
	<form action="${pageContext.request.contextPath}/club/update/submit" method="post">
	    <input type="hidden" name="clubNum" value="${club.clubNum}"/>
	    <label for="clubName">클럽 이름:</label>
	    <input type="text" id="clubName" name="clubName" value="${club.clubName}" required/><br/>
	    
	    <label for="clubLeader">회장:</label>
	    <input type="text" id="clubLeader" name="clubLeader" value="${club.clubLeader}" readonly/><br/>
	    
	    <label for="clubDescription">설명:</label>
	    <textarea id="clubDescription" name="clubDescription" required>${club.clubDescription}</textarea><br/>
	    
	    <label for="clubCategory">카테고리:</label>
	    <input type="text" id="clubCategory" name="clubCategory" value="${club.clubCategory}" required/><br/>
	    <input type="submit" value="수정 완료"/>
	</form>
	<form action="${pageContext.request.contextPath}/club/delete" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
	    <input type="hidden" name="clubNum" value="${club.clubNum}"/>
	    <input type="submit" value="삭제"/>
	</form>


</body>
</html>