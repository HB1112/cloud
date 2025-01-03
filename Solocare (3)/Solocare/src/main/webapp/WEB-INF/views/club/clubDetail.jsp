<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>동호회 상세 페이지</title>
    <script>
    function checkLoginAndJoinClub(clubNum) {
        <% if (request.getSession().getAttribute("mem") == null) { %>
            alert('로그인 해주세요.');
            // 로그인 페이지로 리다이렉트
            window.location.href = "${pageContext.request.contextPath}/login";
            return; // 함수 종료
        <% } %>
        
        // 로그인한 경우 가입 처리
        joinClub(clubNum);
    }

    function joinClub(clubNum) {
        // 현재 세션의 멤버 ID를 가져오기 위해 AJAX 요청
        fetch(`${pageContext.request.contextPath}/club/checkMembership?clubNum=${clubNum}`, {
            method: 'GET'
        })
        .then(response => response.json())
        .then(data => {
            if (data.isMember) {
                alert('이미 가입된 멤버입니다.');
            } else {
                // 가입 처리
                window.location.href = `${pageContext.request.contextPath}/club/join?clubNum=${clubNum}`;
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('가입 확인 중 오류가 발생했습니다.');
        });
    }
    </script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light fixed-top">
         <%@ include file="/WEB-INF/views/menu.jsp" %>
    </nav>
    <h2>${club.clubName}</h2>
    <p>회장: ${club.clubLeader}</p>
    <p>설명: ${club.clubDescription}</p>
    <p>카테고리: ${club.clubCategory}</p>
    <p>위치: ${club.region} ${club.district}</p>
    <p>회원 수: ${club.count} 명</p>
    
    <!-- 가입 버튼을 클릭하면 checkLoginAndJoinClub 함수가 호출됩니다. -->
    <button type="button" onclick="checkLoginAndJoinClub(${club.clubNum})" class="btn btn-primary btn-sm">가입신청</button>

    <a href="${pageContext.request.contextPath}/club/list">목록으로 돌아가기</a>
</body>
</html>
