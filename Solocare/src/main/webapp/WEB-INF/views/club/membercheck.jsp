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
       body {
            background-color: #f8f9fa; /* 배경 색상 */
            font-family: 'Noto Sans', sans-serif; /* 폰트 설정 */
        }

        .table-container {
            margin-top: 20px; /* 테이블 간격 */
        }

        h1 {
            font-size: 2rem; /* 제목 크기 */
            color: #333; /* 제목 색상 */
            margin-bottom: 20px; /* 아래쪽 여백 */
            text-align: center; /* 중앙 정렬 */
        }

        h3 {
            font-size: 1.5rem; /* 소제목 크기 */
            color: #333; /* 소제목 색상 */
            margin-bottom: 15px; /* 아래쪽 여백 */
        }

        .table {
            width: 100%; /* 테이블 너비 100% */
            border-collapse: collapse; /* 테이블 경계 합치기 */
        }

        .table th, .table td {
            text-align: center; /* 텍스트 중앙 정렬 */
            padding: 12px; /* 패딩 */
            border: 1px solid #dee2e6; /* 테두리 색상 */
        }

        .table th {
            background-color: #007bff; /* 헤더 배경 색상 */
            color: white; /* 헤더 글씨 색상 */
        }

        .table tbody tr:nth-child(even) {
            background-color: #f2f2f2; /* 짝수 행 배경 색상 */
        }

        .table tbody tr:hover {
            background-color: #e9ecef; /* 행 호버 시 배경 색상 */
        }

        .btn {
            padding: 6px 12px; /* 버튼 패딩 */
            border-radius: 4px; /* 모서리 둥글게 */
            font-size: 0.9rem; /* 글씨 크기 */
            font-weight: 500; /* 글씨 두께 */
        }

        .btn-success {
            background-color: #28a745; /* 승인 버튼 색상 */
            color: white; /* 글씨 색상 */
        }

        .btn-danger {
            background-color: #dc3545; /* 취소 버튼 색상 */
            color: white; /* 글씨 색상 */
        }

        .btn-sm {
            font-size: 0.8rem; /* 작은 버튼 글씨 크기 */
            padding: 4px 8px; /* 작은 버튼 패딩 */
        }

        .btn:hover {
            opacity: 0.9; /* 버튼 호버 시 투명도 변경 */
        }
    </style>
</head>
<body>
	<%@ include file="/WEB-INF/views/navbar.jsp" %>
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
