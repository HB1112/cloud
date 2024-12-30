<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>솔로케어</title>


  <link
    rel="stylesheet"
    href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css"
  />
  <link
    href="https://webfontworld.github.io/gmarket/GmarketSans.css"
    rel="stylesheet"
  />

  <link
    href="https://fonts.googleapis.com/css2?family=Montserrat:wght@700&display=swap"
    rel="stylesheet"
  />

  <style>
    :root {
      --font-pretendard: 'Pretendard', -apple-system, BlinkMacSystemFont, system-ui,
        Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo',
        'Noto Sans KR', 'Malgun Gothic', sans-serif;
      --font-gmarket: 'GmarketSans', sans-serif;
      --font-montserrat: 'Montserrat', sans-serif; 
    }

    body {
      margin: 0;
      font-family: var(--font-pretendard);
      letter-spacing: -0.01em;
      padding-top: 70px;
    }

    .custom-nav {
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      z-index: 1000;
      display: flex;
      align-items: center;
      justify-content: space-between;
      background-color: rgba(255, 255, 255, 0.8);
      backdrop-filter: saturate(180%) blur(10px);
      border-bottom: none;
      box-shadow: none;
      padding: 10px 20px;
    }

    /* 로고 */
    .custom-nav .logo {
      flex: 0 0 auto; 
    }
    .custom-nav .logo a {
      font-family: var(--font-montserrat);
      font-weight: 700;
      font-size: 32px;
      color: #000;
      text-decoration: none;
      letter-spacing: -0.02em;
      transition: opacity 0.3s ease;
    }
    .custom-nav .logo a:hover {
      opacity: 0.7;
    }

    .custom-nav .menu {
      margin: 0 auto; 
      display: flex;
      align-items: center;
      gap: 60px;
    }

    .custom-nav .menu a {
      text-decoration: none;
      color: #333;
      font-size: 16px;
      font-weight: 500;
      transition: color 0.2s ease, opacity 0.2s ease;
      opacity: 0.9;
    }
    .custom-nav .menu a:hover {
      color: #000;
      opacity: 1;
    }

    /* 드롭다운 (서브메뉴) 공통 */
    .custom-nav .menu-item {
      position: relative;
    }
    .custom-nav .menu-item .dropdown {
      position: absolute;
      top: calc(100% + 10px);
      left: 50%;
      transform: translateX(-50%);
      min-width: 220px;

      background-color: rgba(255, 255, 255, 0.95);
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.08);
      border-radius: 10px;
      border: 1px solid rgba(0, 0, 0, 0.05);

      visibility: hidden;
      opacity: 0;
      transition: visibility 0s, opacity 0.4s ease, transform 0.4s ease;
      transform: translate(-50%, 20px);

      display: flex;
      flex-direction: column;
      padding: 8px 0;
      white-space: nowrap;
      z-index: 9999;
    }
    .custom-nav .menu-item:hover .dropdown {
      visibility: visible;
      opacity: 1;
      transform: translate(-50%, 0);
    }
    .custom-nav .menu-item .dropdown a {
      display: block;
      padding: 12px 20px;
      font-size: 14px;
      color: #333;
      text-decoration: none;
      transition: background-color 0.2s ease;
      border-radius: 6px;
    }
    .custom-nav .menu-item .dropdown a:hover {
      background-color: rgba(0, 0, 0, 0.04);
    }

    .custom-nav .submenu {
      position: relative;
    }
    .custom-nav .submenu .dropdown {
      top: 0;
      left: 100%;
      transform: translateX(10px);
      min-width: 130px;
      margin-left: 2px;
    }

    .custom-nav .user-actions {
      flex: 0 0 auto;
      display: flex;
      align-items: center;
      gap: 15px;
    }
    .custom-nav .user-actions .welcome {
      margin-right: 10px;
      font-size: 15px;
      font-weight: 500;
      color: #333;
      opacity: 0.9;
    }
    .custom-nav .user-actions a {
      text-decoration: none;
      color: #000;
      font-weight: 600;
      font-size: 14px;
      padding: 8px 16px;
      border: none;
      border-radius: 8px;
      background-color: #f1f1f1;
      transition: background-color 0.2s ease, color 0.2s ease;
    }
    .custom-nav .user-actions a:hover {
      background-color: #ddd;
      color: #000;
    }
  </style>
</head>
<body>
<%
    
    boolean isLoggedIn = request.getSession().getAttribute("mem") != null;
%>

<div class="custom-nav">
  <!-- 로고 -->
  <div class="logo">
    <a href="/Solocare/home">SoloCare</a>
  </div>

  <!-- 메뉴 -->
  <div class="menu">
    <a href="/Solocare/search">쇼핑</a>

    <div class="menu-item">
      <a href="#">동호회</a>
      <div class="dropdown">
        <a href="/Solocare/club/list">
          동호회 목록<br><span>다양한 동호회를 한눈에 확인</span>
        </a>
        <a href="/Solocare/club/myclub?id=${mem.id}">
          내 동호회<br><span>내가 속한 동호회 확인</span>
        </a>
      </div>
    </div>

    <div class="menu-item">
      <a href="#">커뮤니티</a>
      <div class="dropdown">
        <a href="/Solocare/board?category=tip&page=1">
          정보공유<br><span>생활 팁과 유용한 정보 공유</span>
        </a>
        <a href="/Solocare/board?category=free">
          자유 게시판<br><span>자유롭게 의견과 경험을 나누는 공간</span>
        </a>
        <div class="submenu">
          <a href="#">
            중고 거래<br><span>필요 없는 물품을 거래하는 공간</span>
          </a>
          <div class="dropdown">
            <a href="/Solocare/board?category=sell">판매</a>
		        <a href="/Solocare/board?category=buy">구매</a>
          </div>
        </div>
      </div>
    </div>

    <a href="/Solocare/policy">정책</a>
  </div>

  <!-- 사용자 액션 -->
  <div class="user-actions">
    <% if (isLoggedIn) { %>
      <div class="welcome">
        ${mem.name}님
      </div>
      <a href="/Solocare/infocheck">내정보</a>
	    <a href="/Solocare/logout">로그아웃</a>
	    <a href="/Solocare/list">일정관리</a>
    <% } else { %>
      <a href="/Solocare/login" class="nav-link">로그인</a>
    <% } %>
  </div>
</div>

</body>
</html>
