<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.springmvc.domain.club" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700&display=swap" rel="stylesheet">
    <title>동호회 목록</title>
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

/* 검색 폼 컨테이너 스타일 */
.search-bar {
    display: flex;
    justify-content: flex-end;
    align-items: center;
    gap: 10px;
    margin-bottom: 20px;
    background: white;
    padding: 15px;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0,0,0,0.05);
}

/* 검색 입력 요소들 스타일 */
.search-bar select,
.search-bar input {
    height: 35px;
    border: 1px solid #ddd;
    border-radius: 4px;
}

.search-bar select {
    width: 120px;
}

.search-bar input {
    width: 200px;
}

/* 검색 버튼 스타일 */
.btn-category-search {
    height: 35px;
    padding: 0 15px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 4px;
}

/* 필터 버튼 그룹 스타일 */
.filter-buttons {
    margin-left: auto;
    display: flex;
    gap: 10px;
}

.filter-btn {
    height: 35px;
    padding: 0 15px;
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

/* 드롭다운 메뉴 스타일 */
.dropdown {
    position: absolute;
    background: white;
    border-radius: 4px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
    z-index: 1000;
    padding: 10px;
    display: none;
    transform: translateX(-50%) translateY(-10px);
}

#regionDropdown .region-list {
    display: grid;
    grid-template-columns: repeat(5, 1fr);
    gap: 10px;
    min-width: 500px;
}

.region-item {
    padding: 8px 12px;
    text-decoration: none;
    color: #333;
    text-align: center;
    border-radius: 4px;
}

.region-item:hover {
    background-color: #f8f9fa;
    color: #007bff;
}

.category-link {
    display: block;
    padding: 8px 15px;
    text-decoration: none;
    color: #333;
}

.category-link:hover {
    background-color: #f8f9fa;
    color: #007bff;
}

/* 동호회 카드 컨테이너 */
.club-container {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 20px;
    padding-top: 20px;
    padding-bottom: 20px;
    width: 100% !important;
    margin: 0 !important;
}

/* 동호회 카드 */
.club-card {
    background: white;
    border-radius: 8px;
    overflow: hidden;
    transition: transform 0.2s, box-shadow 0.2s;
    border: 1px solid #eee;
}

.club-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}

.club-card-body {
    padding: 15px;
    display: flex;
    flex-direction: column;
}

.club-name {
    font-size: 16px;
    font-weight: bold;
    margin-bottom: 10px;
    color: #333;
}

.club-leader, 
.club-description, 
.club-category, 
.club-location, 
.club-member-count {
    margin: 5px 0;
    font-size: 13px;
    color: #666;
}

/* 버튼 스타일 */
.btn-primary {
    background-color: #007bff;
    border-color: #007bff;
    color: white;
    padding: 8px 16px;
    font-size: 14px;
    border-radius: 4px;
    transition: all 0.2s;
    margin-top: auto;
    width: 100%;
}

.btn-primary:hover {
    background-color: #0056b3;
    border-color: #0056b3;
}

/* 반응형 디자인 */
@media (max-width: 1400px) {
    .content {
        width: 85% !important;
    }
    .club-container {
        grid-template-columns: repeat(3, 1fr);
    }
}

@media (max-width: 992px) {
    .content {
        width: 95% !important;
    }
    .club-container {
        grid-template-columns: repeat(2, 1fr);
    }
    .search-bar {
        flex-wrap: wrap;
    }
    .filter-buttons {
        margin-left: 0;
        width: 100%;
        justify-content: flex-start;
        margin-top: 10px;
    }
}

@media (max-width: 768px) {
    .club-container {
        grid-template-columns: 1fr;
    }
    #regionDropdown .region-list {
        grid-template-columns: repeat(3, 1fr);
        min-width: 300px;
    }
}
    </style>
</head>
<body>

<div id="menuWrapper">
    <%@ include file="/WEB-INF/views/navbar.jsp" %>
</div>
<!-- 지역 선택 리스트 -->
<div id="regionDropdown" class="dropdown">
    <div class="region-list">
        <a class="region-item" href="list?region=서울특별시">서울</a>
        <a class="region-item" href="list?region=인천광역시">인천</a>
        <a class="region-item" href="list?region=대구광역시">대구</a>
        <a class="region-item" href="list?region=대전광역시">대전</a>
        <a class="region-item" href="list?region=광주광역시">광주</a>
        <a class="region-item" href="list?region=울산광역시">울산</a>
        <a class="region-item" href="list?region=경기도">경기</a>
        <a class="region-item" href="list?region=부산광역시">부산</a>
        <a class="region-item" href="list?region=강원도">강원</a>
        <a class="region-item" href="list?region=충청북도">충북</a>
        <a class="region-item" href="list?region=충청남도">충남</a>
        <a class="region-item" href="list?region=전라북도">전북</a>
        <a class="region-item" href="list?region=전라남도">전남</a>
        <a class="region-item" href="list?region=경상북도">경북</a>
        <a class="region-item" href="list?region=경상남도">경남</a>
        <a class="region-item" href="list?region=제주특별자치도">제주</a>
    </div>
</div>
            
<!-- 카테고리 드롭다운 -->
<div class="dropdown" id="categoryDropdown">
    <a class="category-link" href="list?category=스포츠 및 e스포츠">스포츠 및 e스포츠</a>
    <a class="category-link" href="list?category=자기개발">자기개발</a>
    <a class="category-link" href="list?category=봉사 및 사회적 활동">봉사 및 사회적 활동</a>
    <a class="category-link" href="list?category=문화 및 예술">문화 및 예술</a>
    <a class="category-link" href="list?category=여행 및 탐험">여행 및 탐험</a>
</div>
        
<div class="content col-md-9" style="width: 100%; padding: 20px;"> <!-- 전체 너비와 패딩 조정 -->
    <h1 style="text-align: center; margin-bottom: 20px;">동호회 목록</h1>

    <!-- 검색 폼 수정 -->
    <form method="GET" action="/Solocare/club/list" class="mb-4 search-bar">
        <input type="hidden" name="category" value=""> <!-- 선택한 카테고리 히든 필드 -->
        <input type="hidden" name="region" value=""> <!-- 현재 지역 유지 -->

        <select name="searchType" id="searchType" class="form-control d-inline-block" style="width: auto;">
            <option value="clubName">동호회 이름</option>
            <option value="clubDescription">설명</option>
        </select>
        <input type="text" name="query" placeholder="검색어 입력" required class="form-control d-inline-block" style="width: 200px; display: inline-block; margin-left: 10px;">
        <button type="submit" class="btn btn-category-search">검색</button>
       
        <div class="filter-buttons">
	        <button class="filter-btn active" onclick="location.href='list'">전체</button>
	        <button class="filter-btn" id="categoryToggle">카테고리</button>
	        <button class="filter-btn" id="regionToggle">지역</button>
   		</div>
    </form>

    <div>
    	<a href="regist" onclick="return checkLogin();" class="btn">동호회 만들기</a>
    </div>

    <div class="club-container" style="width: 100%; max-width: 1400px; margin: auto;"> <!-- 컨테이너 크기 조정 -->
        <c:forEach var="club" items="${clubs}">
            <div class="club-card">
                <div class="club-card-body">
                    <h5 class="club-name">${club.clubName}</h5>
                    <p class="club-leader">회장: ${club.clubLeader}</p>
                    <p class="club-description">${club.clubDescription}</p>
                    <p class="club-category">카테고리: ${club.clubCategory}</p>
                    <p class="club-location">위치: ${club.region} ${club.district}</p>
                    <p class="club-member-count">회원 수: ${club.count} 명</p>
                    <a href="detail/${club.clubNum}" class="btn btn-primary">상세보기</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    document.addEventListener('DOMContentLoaded', function() {
        const categoryToggle = document.getElementById('categoryToggle');
        const regionToggle = document.getElementById('regionToggle');
        const categoryDropdown = document.getElementById('categoryDropdown');
        const regionDropdown = document.getElementById('regionDropdown');

        // 카테고리 드롭다운
        categoryToggle.addEventListener('click', function(e) {
            e.preventDefault(); // 기본 동작 막기
            e.stopPropagation();
            categoryDropdown.style.display = categoryDropdown.style.display === 'block' ? 'none' : 'block';
            regionDropdown.style.display = 'none';
            
            // 드롭다운 위치 조정
            const rect = categoryToggle.getBoundingClientRect();
            categoryDropdown.style.top = rect.bottom + 5 + 'px';
            categoryDropdown.style.left = rect.left + 'px';
        });

        // 지역 드롭다운
        regionToggle.addEventListener('click', function(e) {
            e.preventDefault(); // 기본 동작 막기
            e.stopPropagation();
            regionDropdown.style.display = regionDropdown.style.display === 'block' ? 'none' : 'block';
            categoryDropdown.style.display = 'none';
            
            // 드롭다운 위치 조정
            const rect = regionToggle.getBoundingClientRect();
            regionDropdown.style.top = rect.bottom + 5 + 'px';
            regionDropdown.style.left = rect.left + 'px';
        });

        // 드롭다운 외부 클릭시 닫기
        document.addEventListener('click', function() {
            categoryDropdown.style.display = 'none';
            regionDropdown.style.display = 'none';
        });
    });
    function checkLogin() {
        <% if (request.getSession().getAttribute("mem") == null) { %>
            alert('로그인 해주세요.');
            return false;
        <% } else { %>
            return true;
        <% } %>
    }
    </script>
</body>
</html>
