<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 상세 페이지</title>
<script>
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
	
	<h2>${club.clubName}</h2>
	<p>회장: ${club.clubLeader}</p>
	<p>설명: ${club.clubDescription}</p>
	<p>카테고리: ${club.clubCategory}</p>
	<p>위치: ${club.region} ${club.district}</p>
	<p>회원 수: ${club.count} 명</p>
	
	<!-- 가입 버튼을 클릭하면 joinClub 함수가 호출됩니다. -->
	<button type="button" onclick="joinClub(${club.clubNum})" class="btn btn-primary btn-sm">가입</button>
	<form action="cancelMember" method="post" style="display:inline;">
        <input type="hidden" name="memberId" value="${clubMember.memberId}">
        <input type="hidden" name="clubNum" value="${clubMember.clubNum}">
        <button type="submit" class="btn btn-danger btn-sm">탈퇴</button>
    </form>
	

	
	<form action="${pageContext.request.contextPath}/club/update/${club.clubNum}" method="get">
	    <input type="hidden" name="clubNum" value="${club.clubNum}"/>
	    <input type="submit" value="수정"/>
	</form>
	
	<form action="${pageContext.request.contextPath}/club/delete" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
	    <input type="hidden" name="clubNum" value="${club.clubNum}"/>
	    <input type="submit" value="삭제"/>
	</form>
	
	<form action="${pageContext.request.contextPath}/club/membercheck" method="get">
	    <input type="hidden" name="clubNum" value="${club.clubNum}"/>
	    <input type="submit" value="멤버조회"/>
	</form>


	<a href="${pageContext.request.contextPath}/club/list">목록으로 돌아가기</a>
		
		
</body>
</html>
