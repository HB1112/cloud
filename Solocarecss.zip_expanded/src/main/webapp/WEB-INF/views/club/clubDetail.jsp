<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 상세 페이지</title>
</head>
<body>

	<h2>${club.clubName}</h2>
	<p>회장: ${club.clubLeader}</p>
    <p>설명: ${club.clubDescription}</p>
    <p>카테고리: ${club.clubCategory}</p>
    <p>위치: ${club.clubLocation}</p>
    
    <a href="${pageContext.request.contextPath}/club/join?clubNum=${club.clubNum}">동호회 가입</a>
    
    <a href="${pageContext.request.contextPath}/club/list">목록으로 돌아가기</a>
        
    <a href="${pageContext.request.contextPath}/club/${club.clubNum}/clubcalendar">동호회 일정</a>
    
	<form action="${pageContext.request.contextPath}/club/update/${club.clubNum}" method="get">
	    <input type="hidden" name="clubNum" value="${club.clubNum}"/>
	    <input type="submit" value="수정"/>
	</form>

    <form action="${pageContext.request.contextPath}/club/delete" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
    	<input type="hidden" name="clubNum" value="${club.clubNum}"/>
    	<input type="submit" value="삭제"/>
	</form>
    
</body>
</html>