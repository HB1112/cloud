<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700&display=swap" rel="stylesheet">

<meta charset="UTF-8">
<title>내 클럽</title>
    <style>
        body {
		    background-color: #f8f9fa; /* 배경 색상 */
		    margin: 0;
		    padding: 0;
		    font-family: 'Noto Sans', sans-serif; /* 폰트 설정 */
		}
		
		.content {
		    max-width: 800px; /* 최대 너비 설정 */
		    margin: 30px auto; /* 중앙 정렬 */
		    padding: 0 20px; /* 좌우 패딩 */
		}
		
		.club-detail-card {
		    background: white; /* 카드 배경 색상 */
		    border-radius: 8px; /* 모서리 둥글게 */
		    padding: 25px; /* 카드 패딩 */
		    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05); /* 그림자 효과 */
		}
		
		.club-header {
		    border-bottom: 1px solid #f0f0f0; /* 하단 테두리 */
		    padding-bottom: 15px; /* 아래쪽 패딩 */
		    margin-bottom: 20px; /* 아래쪽 여백 */
		}
		
		.club-title {
		    font-size: 1.5rem; /* 제목 크기 */
		    font-weight: 700; /* 제목 두께 */
		    color: #333; /* 제목 색상 */
		    margin-bottom: 8px; /* 아래쪽 여백 */
		}
		
		.club-leader {
		    font-size: 1rem; /* 회장 글씨 크기 */
		    color: #666; /* 회장 색상 */
		    margin-bottom: 5px; /* 아래쪽 여백 */
		}
		
		.club-info {
		    margin-bottom: 25px; /* 아래쪽 여백 */
		}
		
		.info-item {
		    margin-bottom: 12px; /* 아래쪽 여백 */
		    padding: 8px; /* 패딩 */
		    background: #f8f9fa; /* 배경 색상 */
		    border-radius: 6px; /* 모서리 둥글게 */
		    display: flex; /* 플렉스 박스 */
		    align-items: center; /* 아이템 중앙 정렬 */
		}
		
		.info-label {
		    font-weight: 500; /* 글씨 두께 */
		    color: #555; /* 색상 */
		    width: 80px; /* 고정 너비 */
		    flex-shrink: 0; /* 너비 고정 */
		}
		
		.info-value {
		    color: #333; /* 값 색상 */
		}
		
		.button-group {
		    display: flex; /* 플렉스 박스 */
		    gap: 10px; /* 버튼 간격 */
		    margin-bottom: 15px; /* 아래쪽 여백 */
		}
		
		.admin-buttons {
		    display: flex; /* 플렉스 박스 */
		    gap: 8px; /* 버튼 간격 */
		    margin-top: 15px; /* 위쪽 여백 */
		    padding-top: 15px; /* 위쪽 패딩 */
		    border-top: 1px solid #eee; /* 상단 테두리 */
		}
		
		.btn {
		    padding: 6px 12px; /* 버튼 패딩 */
		    border-radius: 4px; /* 모서리 둥글게 */
		    font-size: 0.9rem; /* 글씨 크기 */
		    font-weight: 500; /* 글씨 두께 */
		    transition: all 0.2s; /* 전환 효과 */
		    border: none; /* 테두리 없음 */
		    min-width: 80px; /* 최소 너비 */
		}
		
		.btn:hover {
		    transform: translateY(-1px); /* 호버 시 이동 효과 */
		    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 호버 시 그림자 효과 */
		}
		
		.btn-primary { background-color: #007bff; color: white; } /* 기본 버튼 색상 */
		.btn-danger { background-color: #dc3545; color: white; } /* 삭제 버튼 색상 */
		.btn-secondary { background-color: #6c757d; color: white; } /* 보조 버튼 색상 */
		.btn-info { background-color: #17a2b8; color: white; } /* 정보 버튼 색상 */
		
		.back-link {
		    display: inline-block; /* 인라인 블록 */
		    margin-top: 15px; /* 위쪽 여백 */
		    color: #666; /* 색상 */
		    text-decoration: none; /* 밑줄 없음 */
		    font-size: 0.9rem; /* 글씨 크기 */
		}
		
		.back-link:hover {
		    color: #333; /* 호버 시 색상 변경 */
		    text-decoration: none; /* 밑줄 없음 */
		}
		
		@media (max-width: 768px) {
		    .content {
		        padding: 0 15px; /* 모바일 패딩 조정 */
		    }
		    
		    .button-group, .admin-buttons {
		        flex-wrap: wrap; /* 버튼 줄 바꿈 */
		    }
		    
		    .btn {
		        flex: 1; /* 버튼 너비 조정 */
		        min-width: 120px; /* 최소 너비 */
		    }
		}

    </style>

</head>
<body>
	<div id="menuWrapper">
        <%@ include file="/WEB-INF/views/navbar.jsp" %>
    </div>
    
    
    <div class="content">
        <div class="club-detail-card">
            <div class="club-header">
                <h2 class="club-title">${club.clubName}</h2>
                <p class="club-leader">회장: ${club.clubLeader}</p>
            </div>

            <div class="club-info">
                <div class="info-item">
                    <span class="info-label">소개</span>
                    <span class="info-value">${club.clubDescription}</span>
                </div>
                <div class="info-item">
                    <span class="info-label">카테고리</span>
                    <span class="info-value">${club.clubCategory}</span>
                </div>
                <div class="info-item">
                    <span class="info-label">위치</span>
                    <span class="info-value">${club.region} ${club.district}</span>
                </div>
                <div class="info-item">
                    <span class="info-label">회원 수</span>
                    <span class="info-value">${club.count} 명</span>
                </div>
            </div>

           <div class="button-group" style="display: flex; justify-content: space-between;">
			    <div>
			        <form action="${pageContext.request.contextPath}/club/community" method="get" style="display: inline;">
			            <input type="hidden" name="clubNum" value="${club.clubNum}">
			            <button type="submit" class="btn btn-success">동호회 커뮤니티</button>
			        </form>
			
			        <form action="${pageContext.request.contextPath}/club/clubcalendar/search/${club.clubNum}" method="get" style="display: inline;">
			            <input type="hidden" name="clubNum" value="${club.clubNum}"/>
			            <input type="submit" value="동호회 일정" class="btn btn-primary"/>
			        </form>
			    </div>
			
			    <div style="margin-left: auto;">
			        <form action="${pageContext.request.contextPath}/club/cancelMember" method="post" style="display: inline;">
			            <input type="hidden" name="memberId" value="${mem.id}">
			            <input type="hidden" name="clubNum" value="${club.clubNum}">
			            <button type="submit" style="background: none; border: none; color: #666; padding: 0;">탈퇴</button>
			        </form>
			    </div>
			</div>

            <div class="admin-buttons">
            	
                <c:if test="${mem.id == club.clubLeader}"> <!-- 클럽 리더의 ID와 비교 -->
			        <form action="${pageContext.request.contextPath}/club/update/${club.clubNum}" method="get">
			            <input type="submit" value="수정" class="btn btn-info"/>
			        </form>
			        <form action="${pageContext.request.contextPath}/club/delete" method="post" 
                      onsubmit="return confirm('정말로 삭제하시겠습니까?');">
	                    <input type="hidden" name="clubNum" value="${club.clubNum}"/>
	                    <input type="hidden" name="memberId" value="${mem.id}"/>
	                    <button type="submit" class="btn btn-danger">삭제</button>
	                </form>
			        
			        <form action="${pageContext.request.contextPath}/club/membercheck" method="get">
			            <input type="hidden" name="clubNum" value="${club.clubNum}"/>
			            <input type="submit" value="멤버관리" class="btn btn-primary"/>
			        </form>
			    </c:if>
            </div>
        </div>

        <a href="${pageContext.request.contextPath}/club/myclub?id=${mem.id}" class="back-link">← 목록으로 돌아가기</a>
    </div>
		
</body>
</html>
