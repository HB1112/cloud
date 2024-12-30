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

    /* 필터 버튼 그룹 */
    .filter-buttons {
        display: flex;
        gap: 10px;
        margin-bottom: 20px;
        justify-content: center;
    }

    .filter-btn {
        padding: 8px 20px;
        background-color: white;
        border: 1px solid #dee2e6;
        border-radius: 4px;
        cursor: pointer;
        transition: all 0.2s;
    }

    .filter-btn:hover {
        background-color: #f8f9fa;
    }

    .filter-btn.active {
        background-color: #007bff;
        color: white;
        border-color: #007bff;
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
        gap: 10px;
        margin-top: 15px;
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

    @media (max-width: 768px) {
        .content {
            width: 90% !important;
        }
        .club-container {
            grid-template-columns: 1fr;
        }
        .club-actions {
            flex-direction: column;
        }
    }
    </style>
</head>
<body>
    <div id="menuWrapper">
        <%@ include file="../navbar.jsp" %>
    </div>

    <div class="content">
        <div class="club-banner">
            <h1>내가 속한 클럽</h1>
            <div class="filter-buttons">
                <button class="filter-btn active" onclick="filterClubs('all')">전체보기</button>
                <button class="filter-btn" onclick="filterClubs('leader')">내가 운영하는 클럽</button>
                <button class="filter-btn" onclick="filterClubs('member')">참여중인 클럽</button>
            </div>
        </div>

        <div class="club-container">
            <c:forEach var="club" items="${clubs}">
                <div class="club-box">
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
                        <a href="clubcalendar/search/${club.clubNum}" class="btn btn-info">일정보기</a>
                        <a href="detail/${club.clubNum}" class="btn btn-primary">상세정보</a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
        function filterClubs(type) {
            // 필터 버튼 활성화 상태 변경
            const buttons = document.querySelectorAll('.filter-btn');
            buttons.forEach(btn => btn.classList.remove('active'));
            event.target.classList.add('active');
            
            // TODO: 실제 필터링 로직 구현
            // 서버에 AJAX 요청을 보내거나 클라이언트 측에서 필터링
        }
    </script>
</body>
</html>