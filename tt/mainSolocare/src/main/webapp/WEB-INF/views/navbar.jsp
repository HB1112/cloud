<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>솔로케어</title>

<!-- 폰트 추가 -->
<link rel="stylesheet" as="style" crossorigin href="https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css" />
<link href="https://webfontworld.github.io/gmarket/GmarketSans.css" rel="stylesheet">

<style>
	:root {
	  --font-pretendard: 'Pretendard', -apple-system, BlinkMacSystemFont, system-ui, Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo', 'Noto Sans KR', 'Malgun Gothic', sans-serif;
	  --font-gmarket: 'GmarketSans', sans-serif;
	}
	
	body {
	  margin: 0;
	  font-family: var(--font-pretendard);
	  letter-spacing: -0.01em;
	}
	
	.nav {
	  background-color: #fff;
	  padding: 17px 19px;
	  display: flex;
	  align-items: center;
	  justify-content: center; 
	  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	  position: sticky;
	  top: 0;
	  z-index: 1000;
	}
	
	.nav .logo {
	  margin-right: auto;
	  font-family: var(--font-gmarket);
	  font-weight: bold;
	  font-size: 35px;
	  letter-spacing: -0.02em;
	  position: absolute;
	  left: 20px;
	}
	
	.nav .logo a {
	  text-decoration: none;
	  color: #3b82f6;
	}
	
	.nav .menu {
	  display: flex;
	  gap: 50px;
	  align-items: center;
	  justify-content: center;
	  font-size: 20px;
	  flex-grow: 1;
	}
	
	.nav .menu a {
	  text-decoration: none;
	  color: #000;
	}
	
	
	.nav .menu-item {
	  position: relative;
	}
	
	.nav .menu-item > a {
	  text-decoration: none;
	  color: #333;
	  font-size: 20px;
	  font-weight: 500;
	  padding: 8px 16px;
	  display: block;
	  transition: color 0.2s ease;
	}
	
	.nav .menu-item > a:hover {
	  color: #3b82f6;
	}
	
	.nav .menu-item .dropdown {
	  position: absolute;
	  top: 100%;
	  left: 50%;
	  transform: translateX(-50%);
	  background-color: #fff;
	  box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
	  border: 1px solid #eee;
	  border-radius: 8px;
	  z-index: 1000;
	  padding: 8px 0;
	  min-width: 200px;
	  visibility: hidden;
	  opacity: 0;
	  transition: all 0.2s ease;
	  display: flex;
	  flex-direction: column;
	  white-space: nowrap;
	}
	
	.nav .menu-item .dropdown a {
	  padding: 12px 20px;
	  color: #333;
	  text-decoration: none;
	  font-size: 14px;
	  line-height: 1.5;
	  transition: all 0.2s ease;
	  display: block;
	  width: 100%;
	}
	
	.nav .menu-item .dropdown a span {
	  display: block;
	  font-size: 12px;
	  color: #777;
	  margin-top: 4px;
	}
	
	.nav .menu-item .dropdown a:hover {
	  background-color: #f8f9fa;
	  color: #3b82f6;
	}
	
	.nav .menu-item:hover .dropdown {
	  visibility: visible;
	  opacity: 1;
	  transform: translateX(-50%) translateY(0);
	}
	
	.nav .menu-item .submenu {
	  position: relative; 
	}
	
	.nav .menu-item .submenu .dropdown {
	  position: absolute;
	  top: 0; 
	  left: 140%; /* 오른쪽으로 이동시키기 위해 값을 증가시킴 */
	  transform: translateX(0); 
	  visibility: hidden; 
	  opacity: 0; 
	  transition: all 0.2s ease;
	  background-color: #fff;
	  box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);
	  border: 1px solid #eee;
	  border-radius: 8px;
	  z-index: 1000;
	  padding: 8px 0;
	}
	
	.nav .menu-item .submenu .dropdown a {
	  padding: 12px 20px;
	  color: #333;
	  text-decoration: none;
	  font-size: 14px;
	  line-height: 1.5;
	  transition: all 0.2s ease;
	}
	
	.nav .menu-item .submenu:hover .dropdown {
	  visibility: visible;
	  opacity: 1;
	  transform: translateX(0);
	}
	
	.nav .menu-item .submenu-item a {
	  margin-right: 10px;
	}
	
	@keyframes fadeInDown {
	  from {
	    opacity: 0;
	    transform: translateX(-50%) translateY(-10px);
	  }
	  to {
	    opacity: 1;
	    transform: translateX(-50%) translateY(0);
	  }
	}
	
	.nav .menu-item:hover .dropdown {
	  animation: fadeInDown 0.2s ease forwards;
	}
	
	.nav .menu-item .dropdown a:not(:last-child) {
	  border-bottom: 1px solid #f0f0f0;
	}
	
	.user-actions {
	  display: flex;
	  align-items: center;
	  position: absolute;
	  right: 20px;
	  gap: 15px;
	}
	
	.user-actions .welcome {
	  font-size: 16px;
	  font-weight: 500;
	}
	
	.user-actions a {
	  text-decoration: none;
	  color: #3b82f6;
	  font-weight: 600;
	  font-size: 15px;
	  padding: 8px 16px;
	  border: 1px solid #3b82f6;
	  border-radius: 6px;
	  transition: all 0.2s ease;
	}
	
	.user-actions a:hover {
	  background-color: #3b82f6;
	  color: #fff;
	}
	
	@keyframes fadeIn {
	  from {
	    opacity: 0;
	    transform: translateY(-10px);
	  }
	  to {
	    opacity: 1;
	    transform: translateY(0);
	  }
	}
</style>
</head>
<body>
	<%
	boolean isLoggedIn = request.getSession().getAttribute("mem") != null;
	%>
	<div class="nav">
	  <div class="logo">
	  <a href="home">Solocare</a>
	  </div>
	  <div class="menu">
	    <a href="search">쇼핑</a>
	    <div class="menu-item">
		  <a href="#">동호회</a>
		  <div class="dropdown">
		    <a href="/Solocare/club/list">동호회 목록<br><span>다양한 동호회를 한눈에 확인</span></a>
		    <a href="/Solocare/club/myclub?id=${mem.id}">내 동호회<br><span>내가 속한 동호회 확인</span></a>
		  </div>
		</div>
	    <div class="menu-item">
		  <a href="#">커뮤니티</a>
		  <div class="dropdown">
		    <a href="board?category=tip&page=1">정보공유<br><span>생활 팁과 유용한 정보 공유</span></a>
		    <a href="#">자유 게시판<br><span>자유롭게 의견과 경험을 나누는 공간</span></a>
		    <div class="submenu">
		      <a href="#">중고 거래<br><span>필요 없는 물품을 거래하는 공간</span></a>
		      <div class="dropdown">
		        <a href="board?category=sell">판매</a>
		        <a href="board?category=buy">구매</a>
		      </div>
		    </div>
		  </div>
		</div>
	    <a href="#">정책</a>
	  </div>
	  <div class="user-actions">
	    <% if (isLoggedIn) { %>
	      <div class="welcome">${mem.name}님</div>
	      <a href="infocheck">내정보</a>
	      <a href="logout">로그아웃</a>
	      <a href="list">일정관리</a>
	    <% } else { %>
	      <a href="/Solocare/login" class="nav-link">로그인</a>
	    <% } %>
	  </div>
	</div>
</body>
</html>