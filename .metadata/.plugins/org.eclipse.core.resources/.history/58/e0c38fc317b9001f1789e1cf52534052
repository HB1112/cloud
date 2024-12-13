<%@ page contentType="text/html; charset=UTF-8" language="java" %>
   <style>
        body {
            font-family: 'Noto Sans', sans-serif;
        }
        .navbar {
            background-color: white; 
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .navbar-brand {
            font-family: 'Noto Serif', serif;
            font-size: 1.8rem;
            font-weight: bold;
            color: #005B96;
            transition: transform 0.3s ease;
        }
        .navbar-brand:hover {
            transform: scale(1.1);
        }
        .navbar-nav .nav-link {
            margin: 0 15px;
            color: #005B96; 
            font-weight: 500;
            transition: all 0.3s ease;
        }
        .navbar-nav .nav-link:hover {
            color: #FFD700; 
            transform: translateY(-3px);
        }
        .dropdown-menu {
            background: #f8f9fa; 
            border: none;
            border-radius: 5px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .dropdown-item {
            color: #005B96; 
            font-weight: 500;
        }
        .dropdown-item:hover {
            background: #005B96; 
            color: white; 
        }
        .search {
            display: flex;
            align-items: center;
            margin-left: auto; /* 오른쪽 끝으로 붙이기 */
        }
        .search input {
            border-radius: 30px;
            border: 2px solid #005B96; 
            margin-right: 10px; /* 검색창과 버튼 사이 간격 */
        }
        .search button {
            color: white;
            background: #005B96; 
            border-radius: 50%;
            border: none;
            padding: 5px 10px;
        }
        .user-links {
        	display : flex;
            margin-left: 20px; /* 로그인/회원가입 간격 */
        }
        .main-content {
            margin-top: 80px; /* 내비게이션 바 높이에 맞춰 여백 추가 */
        }
        .navbar-collapse {
		    display: flex;
		    justify-content: space-between; /* 양쪽 끝으로 배치 */
		    width: 100%; /* 전체 너비 사용 */
		}
    </style>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
<nav class="navbar navbar-expand-lg navbar-light fixed-top" style="font-family: 'Montserrat', sans-serif;">
    <a class="navbar-brand" href="home">Solo Care</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="shoppingDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    쇼핑 
                </a>
                <div class="dropdown-menu" aria-labelledby="shoppingDropdown">
                    <a class="dropdown-item" href="search">1인 가구 맞춤 가전 제품</a>
                    <a class="dropdown-item" href="#">1인 가구 맞춤 식자재</a>
                    <a class="dropdown-item" href="#">보안 제품 추천</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="homeCareDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    커뮤니티 
                </a>
                <div class="dropdown-menu" aria-labelledby="homeCareDropdown">
                    <a class="dropdown-item" href="board?category=tip&page=1">정보 공유 (집 꾸미기, 생활 팁)</a>
                    <a class="dropdown-item" href="tradeboard">중고거래</a>
                    <a class="dropdown-item" href="club/board">동호회 관리 및 모집 / 필요시 대관 정보</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="safetyHealthDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    건강 케어 
                </a>
                <div class="dropdown-menu" aria-labelledby="safetyHealthDropdown">
                    <a class="dropdown-item" href="#">간단한 홈트레이닝 영상 제공</a>
                    <a class="dropdown-item" href="#">건강 데이터 통합 관리</a>
                    <a class="dropdown-item" href="#">집 주변 약국 운영시간, 야간운영? 정보</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="policyDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    정책 지원 
                </a>
                <div class="dropdown-menu" aria-labelledby="policyDropdown">
                    <a class="dropdown-item" href="#">사회성 증진 프로그램</a>
                    <a class="dropdown-item" href="#">지원 혜택</a>
                    <a class="dropdown-item" href="#">응급 대처 가이드</a>
                </div>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="serviceDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    편의 서비스 
                </a>
                <div class="dropdown-menu" aria-labelledby="serviceDropdown">
                    <a class="dropdown-item" href="#">정기 구독 식품, 청소, 심부름</a>
                    <a class="dropdown-item" href="#">안심 귀가 루트 추천</a>
                </div>
            </li>
        </ul>

        <%
            if (request.getSession().getAttribute("mem") != null) {
        %>
            <div class="user-links">
                <p>${mem.name}님 환영합니다</p>
                <a href="infocheck" class="nav-link">내 정보</a>
                <a href="logout" class="nav-link">로그아웃</a>
                <a href="list" class="nav-link">일정관리</a>
            </div>
        <%
            } else {
        %>
            <div class="user-links">
                <a href="login" class="nav-link">로그인</a>
            </div>
        <%
            }
        %>
    </div>
</nav>
