<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>My 클럽</h1>
    <p><a href="${pageContext.request.contextPath}/club/board">동호회 홈으로 이동</a></p>
    <div class="club-container">
        <c:forEach var="club" items="${club}">
            <div class="club-box" onclick="location.href='detail/${club.clubNum}'"> 
                <h3>${club.clubName}</h3>
                <p>회장: ${club.clubLeader}</p>
                <p>설명: ${club.clubDescription}</p>
                <p>카테고리: ${club.clubCategory}</p>
                <p>위치: ${club.clubLocation}</p>
            </div>
        </c:forEach>
    </div>
</body>
</html>