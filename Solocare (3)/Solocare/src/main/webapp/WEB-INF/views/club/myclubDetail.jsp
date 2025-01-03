<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 클럽</title>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light fixed-top">
         <%@ include file="/WEB-INF/views/menu.jsp" %>
    </nav>
    
    <form action="${pageContext.request.contextPath}/club/myclub" method="post" style="display: inline;">
	    <input type="hidden" name="id" value="${mem.id}"> <!-- 세션에서 가져온 멤버 ID로 설정 -->
	    <button type="submit" class="btn btn-warning">내 동호회</button>
	</form>
	<h2>${club.clubName}</h2>
	<p>회장: ${club.clubLeader}</p>
	<p>설명: ${club.clubDescription}</p>
	<p>카테고리: ${club.clubCategory}</p>
	<p>위치: ${club.region} ${club.district}</p>
	<p>회원 수: ${club.count} 명</p>
		
	<c:if test="${mem.id == club.clubLeader}"> <!-- 클럽 리더의 ID와 비교 -->
        <form action="${pageContext.request.contextPath}/club/update/${club.clubNum}" method="get">
            <input type="hidden" name="clubNum" value="${club.clubNum}"/>
            <input type="submit" value="동호회 수정 및 삭제" class="btn btn-info"/>
        </form>
        
        <form action="${pageContext.request.contextPath}/club/membercheck" method="get">
            <input type="hidden" name="clubNum" value="${club.clubNum}"/>
            <input type="submit" value="멤버관리" class="btn btn-primary"/>
        </form>
    </c:if>
	
	<form action="community" method="get" style="display: inline;">
	    <input type="hidden" name="clubNum" value="${club.clubNum}"> <!-- 세션에서 가져온 멤버 ID로 설정 -->
	    <button type="submit" class="btn btn-success">동호회 커뮤니티</button> <!-- 세션 ID를 포함한 버튼 -->
	</form>
	
	<a href="clubcalendar/search/${club.clubNum}">동호회 일정</a>
	
	
	<form action="${pageContext.request.contextPath}/club/selfcancelMember" method="post" style="display:inline;">
	    <input type="hidden" name="memberId" value="${mem.id}">
	    <input type="hidden" name="clubNum" value="${club.clubNum}">
	    <button type="submit" class="btn btn-danger btn-sm">탈퇴</button>
	</form>


	
		
		
</body>
</html>
