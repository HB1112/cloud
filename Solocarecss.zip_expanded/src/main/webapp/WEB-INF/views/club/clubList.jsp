<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>동호회 목록</title>
    <style>
        .club-container {
            display: flex;
            flex-wrap: wrap; 
            gap: 10px;
        }
        .club-box {
            border: 1px solid #ccc; 
            padding: 10px; 
            width: calc(25% - 10px); 
            box-sizing: border-box; 
            cursor: pointer; 
            transition: background-color 0.3s; 
        }
        .club-box:hover {
            background-color: #f0f0f0; 
        }
    </style>
</head>
<body>
    <h1>동호회 목록</h1>
    <p><a href="${pageContext.request.contextPath}/club/board">동호회 홈으로 이동</a></p>
    <div class="club-container">
        <c:forEach var="club" items="${clubs}">
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