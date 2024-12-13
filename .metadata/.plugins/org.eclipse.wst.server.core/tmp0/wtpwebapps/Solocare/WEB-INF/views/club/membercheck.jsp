<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>클럽 멤버 리스트</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .member-box {
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 15px;
            margin: 10px 0;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container mt-4">
        <h1>클럽 멤버 리스트</h1>
        
        <c:forEach var="clubMember" items="${clubmembers}">
            <div class="member-box" onclick="location.href='memberDetail/${clubMember.memberId}'">
                <p>멤버 아이디: ${clubMember.memberId}</p>
                <p>클럽 이름: ${clubMember.clubName}</p>
                <p>가입 날짜: ${clubMember.joinDate}</p>
                <p>전화번호: ${clubMember.memberphone}</p>
                <p>이메일: ${clubMember.memberemail}</p>
            </div>
        </c:forEach>
        
    </div>
</body>
</html>
