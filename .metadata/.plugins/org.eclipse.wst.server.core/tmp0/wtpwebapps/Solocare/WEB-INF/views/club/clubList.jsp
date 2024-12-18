<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.springmvc.domain.club" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700&family=Noto+Serif:wght@400;700&display=swap" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
            background-color: #f8f9fa; /* 클럽 박스 배경색 */
        }
        .club-box:hover {
            background-color: #e2e6ea; /* 호버 시 배경색 */
        }
        .category-link {
            display: inline-block; /* 블록 요소로 설정 */
            width: 150px; /* 고정 너비 */
            height: 50px; /* 고정 높이 */
            margin: 5px;
            border: 1px solid #ccc; /* 기존 리스트와 동일한 테두리 색상 */
            background-color: #f8f9fa; /* 클럽 박스와 동일한 배경색 */
            color: #333; /* 텍스트 색상 */
            text-decoration: none;
            text-align: center; /* 텍스트 중앙 정렬 */
            line-height: 50px; /* 세로 중앙 정렬 */
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .category-link:hover {
            background-color: #e2e6ea; /* 호버 시 배경색 유지 */
        }
        .region-list {
            margin-top: 10px;
            width: 50%;
            display: flex; /* Flexbox로 정렬 */
            flex-wrap: wrap; /* 여러 줄로 나열 */
        }
        .region-item {
            cursor: pointer;
            color: #333; /* 텍스트 색상 */
            text-decoration: none;
            margin: 3px; /* 간격 줄이기 */
            padding: 8px; /* 패딩 줄이기 */
            border: 1px solid #ccc; /* 테두리 추가 */
            border-radius: 5px; /* 모서리 둥글게 */
            background-color: #f8f9fa; /* 배경색 */
            width: calc(20% - 6px); /* 너비 조정 */
            box-sizing: border-box; /* 박스 사이징 설정 */
            text-align: center; /* 중앙 정렬 */
        }
        .region-item:hover {
            color: darkblue;
            background-color: #e2e6ea; /* 호버 시 배경색 변경 */
        }
    </style>
</head>
<body>
    <h1>동호회 목록</h1>
    <p><a href="${pageContext.request.contextPath}/club/board">동호회 홈으로 이동</a></p>
    <div>
        <a class="category-link" href="list">전체</a>
        <span class="category-link" id="categoryToggle">카테고리</span>
        <span class="category-link" id="regionToggle">지역</span>

        <!-- 지역 선택 리스트 -->
        <div id="regionDropdown" class="dropdown" style="display: none;">
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
        <div class="dropdown" id="categoryDropdown" style="display: none;">
            <a class="category-link" href="list?category=스포츠 및 e스포츠">스포츠 및 e스포츠</a>
            <a class="category-link" href="list?category=자기개발">자기개발</a>
            <a class="category-link" href="list?category=봉사 및 사회적 활동">봉사 및 사회적 활동</a>
            <a class="category-link" href="list?category=문화 및 예술">문화 및 예술</a>
            <a class="category-link" href="list?category=여행 및 탐험">여행 및 탐험</a>
        </div>
    </div>
    
    <!-- 검색 폼 수정 -->
    <form method="GET" action="${pageContext.request.contextPath}/club/list">
	    <input type="hidden" name="category" value="${selectedCategory}"/> <!-- 선택한 카테고리 히든 필드 -->
	    <input type="hidden" name="region" value="${region}"/> <!-- 현재 지역 유지 -->

        <select name="searchType" id="searchType">
            <option value="clubName">동호회 이름</option>
            <option value="clubDescription">설명</option>
        </select>
        <input type="text" name="query" placeholder="검색어 입력" required>
        
        <button type="submit">검색</button>
    </form>

    <div class="club-container">
        <c:forEach var="club" items="${clubs}">
            <div class="club-box" onclick="location.href='detail/${club.clubNum}'"> 
                <h3>${club.clubName}</h3>
                <p>회장: ${club.clubLeader}</p>
                <p>설명: ${club.clubDescription}</p>
                <p>카테고리: ${club.clubCategory}</p>
                <p>위치: ${club.region} ${club.district} </p>
                <p>회원 수: ${club.count} 명</p>
            </div>
        </c:forEach>
    </div>
    <a href="regist" class="btn btn-primary">동호회 만들기</a>
    
</body>
<script type="text/javascript">
    document.getElementById("categoryToggle").addEventListener("click", function() {
        var dropdown = document.getElementById("categoryDropdown");
        dropdown.style.display = (dropdown.style.display === "none" || dropdown.style.display === "") ? "block" : "none"; // 드롭다운 보이기/숨기기
    });

    document.getElementById("regionToggle").addEventListener("click", function() {
        var dropdown = document.getElementById("regionDropdown");
        dropdown.style.display = (dropdown.style.display === "none" || dropdown.style.display === "") ? "block" : "none"; // 드롭다운 보이기/숨기기
    });
</script>
</html>
