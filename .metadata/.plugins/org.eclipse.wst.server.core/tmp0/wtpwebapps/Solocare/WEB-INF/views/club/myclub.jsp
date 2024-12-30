<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700&display=swap" rel="stylesheet">
    <title>My 클럽</title>
    <style>
    body {
        background-color: #f8f9fa;
        margin: 0;
        padding: 0;
    }

    .content {
        width: 70% !important;
        margin: 0 auto !important;
        padding: 20px 0 !important;
    }

    .main-container {
        max-width: 1400px;
        margin: 0 auto;
        padding: 20px;
    }

    /* 내 클럽 상단 배너 */
    .club-banner {
        background: white;
        padding: 20px;
        border-radius: 8px;
        margin-bottom: 20px;
        box-shadow: 0 2px 4px rgba(0,0,0,0.05);
        text-align: center;
    }

    .club-banner h1 {
        color: #333;
        margin-bottom: 15px;
    }

    

    /* 클럽 카드 컨테이너 */
    .club-container {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        gap: 20px;
        padding: 20px;
    }

    /* 클럽 카드 */
    .club-box {
        background: white;
        border-radius: 8px;
        padding: 20px;
        transition: transform 0.2s, box-shadow 0.2s;
        border: 1px solid #eee;
        cursor: pointer;
    }

    .club-box:hover {
        transform: translateY(-5px);
        box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
    }

    .club-info {
        margin-bottom: 15px;
    }

    .club-name {
        font-size: 1.25rem;
        font-weight: bold;
        color: #333;
        margin-bottom: 10px;
    }

    .club-description {
        color: #666;
        margin-bottom: 8px;
    }

    /* 버튼 컨테이너 */
    .club-actions {
    display: flex;
    justify-content: space-between;
    margin-top: 15px;
    gap: 10px;
	}
	
	.club-actions form {
	    margin: 0;
	    padding: 0;
	    width: 48%; /* 약간의 간격을 위해 50%보다 작게 설정 */
	}
	
	.club-actions a {
	    width: 48%; /* form과 동일한 너비 */
	}
	
	.club-actions .btn {
	    padding: 8px 16px;
	    border-radius: 4px;
	    font-size: 14px;
	    transition: all 0.2s;
	    text-decoration: none;
	    text-align: center;
	    width: 100%;
	    display: block;
	}

    .btn {
        padding: 8px 16px;
        border-radius: 4px;
        font-size: 14px;
        transition: all 0.2s;
        text-decoration: none;
        text-align: center;
        flex: 1;
    }

    .btn-primary {
        background-color: #007bff;
        color: white;
        border: none;
    }

    .btn-success {
        background-color: #28a745;
        color: white;
        border: none;
    }

    .btn-info {
        background-color: #17a2b8;
        color: white;
        border: none;
    }

    .btn:hover {
        opacity: 0.9;
        transform: translateY(-2px);
    }

    /* 반응형 디자인 */
    @media (max-width: 1200px) {
        .club-container {
            grid-template-columns: repeat(2, 1fr);
        }
    }

    /* 모바일 반응형일 때는 세로로 배치 */
	@media (max-width: 768px) {
	    .club-actions {
	        flex-direction: column;
	    }
	    
	    .club-actions form,
	    .club-actions a {
	        width: 100%;
	    }
	}
	h2 {
	    font-size: 1.5rem; /* 글씨 크기 */
	    font-weight: 500; /* 글씨 두께 */
	    color: #333; /* 글씨 색상 */
	    margin-top: 30px; /* 위쪽 여백 */
	    margin-bottom: 15px; /* 아래쪽 여백 */
	    text-align: left; /* 텍스트 정렬 */
	    border-bottom: 2px solid #007bff; /* 하단 테두리 */
	    padding : 5px;
	    padding-bottom: 10px; /* 하단 패딩 */
	    background-color: #f1f1f1; /* 배경 색상 */
	    border-radius: 5px; /* 모서리 둥글게 */
	}
    </style>
</head>
<body>
    <div id="menuWrapper">
        <%@ include file="/WEB-INF/views/navbar.jsp" %>
    </div>

    <div class="content">
        
        <h1 style="text-align: center; margin-bottom: 20px;">내 동호회 목록</h1>
        
		<h2>내가 속한 동호회</h2>
        <div class="club-container">
        	
            <c:forEach var="club" items="${joinedClubs}">
                <div class="club-box" onclick="location.href='myclubdetail/${club.clubNum}'">
                    <div class="club-info">
                        <h3 class="club-name">${club.clubName}</h3>
                        <p class="club-description">${club.clubDescription}</p>
                        <p>카테고리: ${club.clubCategory}</p>
                        <p>위치: ${club.region} ${club.district}</p>
                        <p>회원 수: ${club.count} 명</p>
                    </div>
                    
                    <div class="club-actions">
                        <form action="community" method="get" style="flex: 1;">
                            <input type="hidden" name="clubNum" value="${club.clubNum}">
                            <button type="submit" class="btn btn-success">커뮤니티</button>
                        </form>
                        <a href="clubcalendar/search/${club.clubNum}" class="btn btn-info">동호회 일정</a>
                    </div>
                </div>
            </c:forEach>
        </div>
        <h2>승인 대기중 동호회</h2>
        <div class="club-container">
        	
            <c:forEach var="club" items="${notjoinedClubs}">
                <div class="club-box">
                    <div class="club-info">
                        <h3 class="club-name">${club.clubName}</h3>
                        <p class="club-description">${club.clubDescription}</p>
                        <p>카테고리: ${club.clubCategory}</p>
                        <p>위치: ${club.region} ${club.district}</p>
                        <p>회원 수: ${club.count} 명</p>
                    </div>
                    
                    <div class="club-actions">
                        <a href="#" class="btn btn-info">승인 대기중</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        
    </script>
</body>
</html>