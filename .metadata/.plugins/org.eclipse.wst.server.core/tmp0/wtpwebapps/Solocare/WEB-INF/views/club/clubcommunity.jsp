<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700&display=swap" rel="stylesheet">
    <title>클럽 게시판</title>
    <style>
    body {
        background-color: #f8f9fa;
        margin: 0;
        padding: 0;
        font-family: 'Noto Sans', sans-serif;
    }

    .content {
        max-width: 1400px;
        margin: 30px auto;
        padding: 0 40px;
    }

    .board-title {
        text-align: center;
        font-size: 1.8rem;
        font-weight: 700;
        color: #333;
        margin-bottom: 25px;
    }

    .board-card {
        background: white;
        border-radius: 8px;
        padding: 20px;
        box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
    }

    .board-table {
        width: 100%;
        border-collapse: separate;
        border-spacing: 0;
    }

    .board-table th {
        background-color: #f8f9fa;
        color: #495057;
        font-weight: 600;
        padding: 12px;
        border-bottom: 2px solid #dee2e6;
        text-align: center;
    }

    .board-table td {
        padding: 12px;
        border-bottom: 1px solid #eee;
        color: #495057;
        text-align: center;
    }

    .board-table tr:hover {
        background-color: #f8f9fa;
    }

    .board-table a {
        color: #495057;
        text-decoration: none;
    }

    .board-table a:hover {
        color: #007bff;
    }

    .search-container {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin: 20px 0;
        gap: 10px;
    }

    .search-form {
        display: flex;
        gap: 8px;
    }

    .search-form select,
    .search-form input {
        padding: 6px 12px;
        border: 1px solid #dee2e6;
        border-radius: 4px;
        font-size: 0.9rem;
    }

    .search-form input {
        width: 200px;
    }

    .btn {
        padding: 6px 16px;
        border-radius: 4px;
        font-size: 0.9rem;
        font-weight: 500;
        transition: all 0.2s;
    }

    .btn-search {
        background-color: #007bff;
        color: white;
        border: none;
    }

    .btn-write {
        background-color: #28a745;
        color: white;
        text-decoration: none;
        border: none;
    }

    .btn:hover {
        opacity: 0.9;
        transform: translateY(-1px);
    }

    .pagination {
        display: flex;
        justify-content: center;
        gap: 5px;
        margin-top: 20px;
    }

    .pagination a {
        padding: 6px 12px;
        border: 1px solid #dee2e6;
        color: #007bff;
        text-decoration: none;
        border-radius: 4px;
        font-size: 0.9rem;
    }

    .pagination a.active {
        background-color: #007bff;
        color: white;
        border-color: #007bff;
    }

    .pagination a:hover:not(.active) {
        background-color: #f8f9fa;
    }

    @media (max-width: 768px) {
        .search-container {
            flex-direction: column-reverse;
            align-items: stretch;
        }

        .search-form {
            flex-wrap: wrap;
        }

        .search-form input {
            width: 100%;
        }

        .board-table th:nth-child(3),
        .board-table th:nth-child(4),
        .board-table td:nth-child(3),
        .board-table td:nth-child(4) {
            display: none;
        }
    }
</style>

</head>
<body>
	<%
	  int startNumber = (Integer) request.getAttribute("startNumber"); // 시작 번호
	%>
    <%@ include file="/WEB-INF/views/navbar.jsp" %>
    <div class="content">
        <h2 class="board-title">클럽 게시판</h2>
        
        <div class="board-card">
            <div class="search-container">
                <form action="searchclubboard" method="get" class="search-form">
                    <input type="hidden" name="clubNum" value="${clubNum}">
                    <input type="hidden" name="page" value="1">
                    <select name="items" class="form-select">
                        <option value="subject">제목</option>
                        <option value="content">내용</option>
                    </select>
                    <input type="text" name="text" placeholder="검색어를 입력하세요" required>
                    <button type="submit" class="btn btn-search">검색</button>
                </form>
                <a href="writeclub?clubNum=${clubNum}" class="btn btn-write">게시글 작성</a>
            </div>
        
        <table class="board-table">
            <thead>
                <tr>
                    <th width="10%">번호</th>
                    <th width="45%">제목</th>
                    <th width="15%">작성일</th>
                    <th width="10%">조회</th>
                    <th width="20%">글쓴이</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="board" items="${clubboards}">
                    <tr>
                        <td><%= startNumber-- %></td> <!-- 번호 -->
                        <td><a href="detailboard?boardnum=${board.boardnum}">${board.subject}</a></td>
                        <td>${board.regist_date}</td>
                        <td>${board.hit}</td>
                        <td>${board.memberid}</td>
                    </tr>
                </c:forEach>
                <c:if test="${empty clubboards}">
                    <tr>
                        <td colspan="5" class="text-center">게시글이 없습니다.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>

        <!-- 페이지네이션 -->
		<div class="pagination">
		    <c:if test="${currentPage > 1}">
		       <c:choose>
		           <c:when test="${not empty items and not empty text}">
		               <a href="searchclubboard?clubNum=${clubNum}&page=${currentPage - 1}&items=${items}&text=${text}" class="btn btn-secondary">이전</a>
		           </c:when>
		           <c:otherwise>
		               <a href="community?clubNum=${clubNum}&page=${currentPage - 1}" class="btn btn-secondary">이전</a>
		           </c:otherwise>
		       </c:choose>
		   </c:if>
		
		   <c:forEach begin="1" end="${totalPages}" var="i">
		       <c:choose>
		           <c:when test="${i == currentPage}">
		               <span class="btn btn-primary">${i}</span> <!-- 현재 페이지 강조 -->
		           </c:when>
		           <c:otherwise>
		               <c:choose>
		                   <c:when test="${not empty items and not empty text}">
		                       <a href="searchclubboard?clubNum=${clubNum}&page=${i}&items=${items}&text=${text}" class="btn btn-light">${i}</a>
		                   </c:when>
		                   <c:otherwise>
		                       <a href="community?clubNum=${clubNum}&page=${i}" class="btn btn-light">${i}</a>
		                   </c:otherwise>
		               </c:choose>
		           </c:otherwise>
		       </c:choose>
		   </c:forEach>
		
		   <c:if test="${currentPage < totalPages}">
			    <c:choose>
			        <c:when test="${not empty items and not empty text}">
			            <a href="searchclubboard?clubNum=${clubNum}&page=${currentPage + 1}&items=${items}&text=${text}" class="btn btn-secondary">다음</a>
			        </c:when>
			        <c:otherwise>
			            <a href="community?clubNum=${clubNum}&page=${currentPage + 1}" class="btn btn-secondary">다음</a>
			        </c:otherwise>
			    </c:choose>
			</c:if>
			</div>
	</div>
   </div>
</body>
</html>