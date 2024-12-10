<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.springmvc.domain.Product" %>
<%@ page import="com.springmvc.domain.SearchResult" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>검색 결과</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700&family=Noto+Serif:wght@400;700&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        body {
            font-family: 'Noto Sans', 'Noto Serif', Arial, sans-serif;
            background-color: #f8f9fa; /* 연한 배경색 */
        }
        .container {
            max-width: 1200px; /* 최대 너비 설정 */
            margin: auto; /* 가운데 정렬 */
        }
        h1 {
            color: #333; /* 제목 색상 */
        }
        .product-card {
            border: 1px solid #ddd;
            border-radius: 5px;
            padding: 20px; /* 패딩 증가 */
            margin-bottom: 30px; /* 카드 간격 증가 */
            text-align: center;
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1);
            background-color: #fff; /* 카드 배경색 */
            height: 360px; /* 카드 높이 조정 */
            display: flex; /* Flexbox 사용 */
            flex-direction: column; /* 세로 방향 정렬 */
            justify-content: space-between; /* 요소 간격 조정 */
        }
        .product-card img {
            max-width: 100%;
            height: auto;
            margin-bottom: 15px; /* 이미지와 텍스트 간격 증가 */
            max-height: 220px; /* 이미지 최대 높이 설정 (키움) */
            cursor: pointer; /* 포인터 커서 추가 */
        }
        .product-card h3 {
            font-size: 18px; /* 제목 크기 조정 */
            font-weight: 500;
            margin: 10px 0; /* 제목과 다른 요소 간격 */
            overflow: hidden; /* overflow 숨기기 */
            text-overflow: ellipsis; /* 텍스트가 넘칠 경우 "..." 표시 */
            white-space: nowrap; /* 텍스트가 한 줄로 표시되도록 설정 */
        }
        .product-card p {
            margin: 5px 0; /* 가격 마진 조정 */
            font-size: 16px; /* 가격 폰트 크기 조정 */
            color: #333; /* 가격 색상 */
        }
        .pagination {
            justify-content: center; /* 중앙 정렬 */
            margin-top: 20px; /* 페이지네이션과 카드 간격 */
        }
        .pagination a, .pagination strong {
            padding: 5px 10px;
            margin: 0 2px;
            text-decoration: none;
            border: 1px solid #ddd;
            border-radius: 5px;
            color: #333; /* 기본 색상 */
            background-color: #fff; /* 기본 배경색: 하얀색 */
        }
        .pagination a:hover, .pagination strong {
            background-color: #222; /* 더 진한 검은색 */
            color: #fff; /* 클릭 시 텍스트 색상: 흰색 */
        }
        .sort-select {
            width: auto; /* 드롭다운 너비 자동 조정 */
        }
        .search-form {
            margin-bottom: 20px; /* 카드와의 간격 조정 */
            padding: 15px; /* 패딩 추가 */
            background-color: #fff; /* 배경색 */
            box-shadow: 0px 2px 4px rgba(0, 0, 0, 0.1); /* 그림자 추가 */
        }
        .btn-primary {
            background-color: #222; /* 버튼 배경색: 더 진한 검은색 */
            border: none; /* 경계선 없애기 */
        }
        .btn-primary:hover {
            background-color: #444; /* 버튼 호버 색상: 검은색 */
        }
    </style>
</head>
<body>
<%@ include file="menu.jsp"%>

<div class="container mt-4">
    <h1 class="mb-4">검색 결과</h1>

    <c:choose>
        <c:when test="${not empty searchResult.products}">
            <!-- Bootstrap Grid for Product Cards -->
            <div class="row">
                <c:forEach var="product" items="${searchResult.products}">
                    <div class="col-sm-6 col-md-3 mb-4"> <!-- 한 줄에 4개, 아래 간격 추가 -->
                        <div class="product-card">
                            <a href="${product.link}" target="_blank"> <!-- 이미지 클릭 시 링크로 이동 -->
                                <img src="${product.image}" alt="${product.name}">
                            </a>
                            <h3>${product.name}</h3> <!-- 제목만 표시 -->
                            <p>가격: ${product.price}</p> <!-- 가격 표시 -->
                        </div>
                    </div>
                </c:forEach>
            </div>

            <!-- 검색 폼 고정 -->
            <div class="search-form">
                <form action="${pageContext.request.contextPath}/search" method="GET">
                    <input type="hidden" name="page" value="${currentPage}" />
                    <label for="query">검색어:</label>
                    <input type="text" name="query" id="query" value="${query}" class="form-control d-inline w-auto" required />
                    <label for="sort" class="ml-2">정렬 기준:</label>
                    <select name="sort" id="sort" class="form-control d-inline sort-select ml-2" onchange="this.form.submit()">
                        <option value="sim" ${sort == 'sim' ? 'selected' : ''}>관련도 높은 순</option>
                        <option value="price_low" ${sort == 'price_low' ? 'selected' : ''}>가격 낮은 순</option>
                        <option value="price_high" ${sort == 'price_high' ? 'selected' : ''}>가격 높은 순</option>
                        <option value="date" ${sort == 'date' ? 'selected' : ''}>날짜 순</option>
                    </select>
                    <button type="submit" class="btn btn-primary ml-2">검색</button>
                </form>
            </div>

            <!-- Pagination -->
            <div class="pagination d-flex justify-content-center">
                <c:if test="${currentPage > 1}">
                    <a href="${pageContext.request.contextPath}/search?query=${query}&page=${currentPage - 1}&sort=${sort}">이전</a>
                </c:if>

                <c:forEach begin="${startPage}" end="${endPage}" var="pageNum">
                    <c:choose>
                        <c:when test="${pageNum == currentPage}">
                            <strong>${pageNum}</strong>
                        </c:when>
                        <c:otherwise>
                            <a href="${pageContext.request.contextPath}/search?query=${query}&page=${pageNum}&sort=${sort}">${pageNum}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${currentPage < totalPages}">
                    <a href="${pageContext.request.contextPath}/search?query=${query}&page=${currentPage + 1}&sort=${sort}">다음</a>
                </c:if>
            </div>
        </c:when>
        <c:otherwise>
            <p class="text-center text-muted">검색 결과가 없습니다.</p>
        </c:otherwise>
    </c:choose>
</div>

<%@ include file="footer.jsp"%>
</body>
</html>
