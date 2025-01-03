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
        .table-container {
            margin-top: 20px;
        }
    </style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light fixed-top">
         <%@ include file="/WEB-INF/views/menu.jsp" %>
    </nav>
    <div class="container mt-4">
        <h1>클럽 멤버 리스트</h1>
		
		<!-- 승인 대기자 테이블 -->
        <div class="table-container">
            <h3>승인 대기자</h3>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>멤버 아이디</th>
                        <th>가입 날짜</th>
                        <th>전화번호</th>
                        <th>이메일</th>
                        <th>액션</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="clubMember" items="${clubmembers}">
                        <c:if test="${clubMember.memberjoin == 0}">
                            <tr>
                                <td>${clubMember.memberId}</td>
                                <td>${clubMember.joinDate}</td>
                                <td>${clubMember.memberphone}</td>
                                <td>${clubMember.memberemail}</td>
                                <td>
                                    <form action="approveMember" method="post" style="display:inline;">
                                        <input type="hidden" name="memberId" value="${clubMember.memberId}">
                                        <input type="hidden" name="clubNum" value="${clubMember.clubNum}">
                                        <button type="submit" class="btn btn-success btn-sm">승인</button>
                                    </form>
                                    <form action="cancelMember" method="post" style="display:inline;">
                                        <input type="hidden" name="memberId" value="${clubMember.memberId}">
                                        <input type="hidden" name="clubNum" value="${clubMember.clubNum}">
                                        <button type="submit" class="btn btn-danger btn-sm">취소</button>
                                    </form>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!-- 클럽 회원 테이블 -->
        <div class="table-container">
            <h3>${clubName} 회원</h3>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>멤버 아이디</th>
                        <th>가입 날짜</th>
                        <th>전화번호</th>
                        <th>이메일</th>
                        <th>액션</th> <!-- 액션 열 추가 -->
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="clubMember" items="${clubmembers}">
                        <c:if test="${clubMember.memberjoin == 1}">
                            <tr>
                                <td>${clubMember.memberId}</td>
                                <td>${clubMember.joinDate}</td>
                                <td>${clubMember.memberphone}</td>
                                <td>${clubMember.memberemail}</td>
                                <td>
                                    <form action="cancelMember" method="post" style="display:inline;">
                                        <input type="hidden" name="memberId" value="${clubMember.memberId}">
                                        <input type="hidden" name="clubNum" value="${clubMember.clubNum}">
                                        <button type="submit" class="btn btn-danger btn-sm">탈퇴</button>
                                    </form>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        

    </div>
</body>
</html>
