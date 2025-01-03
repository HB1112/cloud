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
    <a class="navbar-brand" href="/Solocare/home">Solo Care</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/Solocare/search">쇼핑</a>
            </li>
             <li class="nav-item">
                <a class="nav-link" href="/Solocare/club/board">동호회</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link" href="/Solocare/community">커뮤니티</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link" href="/Solocare/policy">정책</a>
            </li>
        </ul>

        <%
            if (request.getSession().getAttribute("mem") != null) {
        %>
            <div class="user-links">
                <p>${mem.name}님 환영합니다</p>
                <a href="/Solocare/infocheck" class="nav-link">내 정보</a>
                <a href="/Solocare/logout" class="nav-link">로그아웃</a>
                <a href="/Solocare/list" class="nav-link">일정관리</a>
            </div>
        <%
            } else {
        %>
            <div class="user-links">
                <a href="/Solocare/login" class="nav-link">로그인</a>
            </div>
        <%
            }
        %>
    </div>
</nav>
