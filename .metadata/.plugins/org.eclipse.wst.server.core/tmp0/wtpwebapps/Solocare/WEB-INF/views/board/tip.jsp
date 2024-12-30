<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.springmvc.domain.member" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.springmvc.domain.board" %>

<% 
    ArrayList<board> boardList = (ArrayList<board>) request.getAttribute("boardlist");
    int startNumber = (Integer) request.getAttribute("startNumber");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700&display=swap" rel="stylesheet">
    <title>팁 정보 공유 게시판</title>
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

        /* 게시판 카드 스타일 */
        .board-card {
            background: white;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.05);
        }

        /* 테이블 스타일 */
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

        /* 제목 링크 스타일 */
        .board-table a {
            color: #495057;
            text-decoration: none;
        }

        .board-table a:hover {
            color: #007bff;
        }

        /* 검색 폼 스타일 */
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

        /* 버튼 스타일 */
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

        /* 페이지네이션 스타일 */
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
    <%@ include file="../navbar.jsp"%>
    
    <div class="content">
        <h2 class="board-title">팁 정보 공유 게시판</h2>
        
        <div class="board-card">
            <div class="search-container">
                <form action="searchboard" method="get" class="search-form">
                    <input type="hidden" name="category" value="tip">
                    <input type="hidden" name="page" value="1">
                    <select name="items" class="form-select">
                        <option value="subject">제목</option>
                        <option value="content">내용</option>
                    </select>
                    <input type="text" name="text" placeholder="검색어를 입력하세요" required>
                    <button type="submit" class="btn btn-search">검색</button>
                </form>
                <a href="writeboard?category=tip" onclick="return checkLogin();" class="btn btn-write">글쓰기</a>
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
                    <c:forEach var="board" items="${boardlist}">
                        <tr>
                            <td><%= startNumber-- %></td>
                            <td class="text-left"><a href="detail?num=${board.num}">${board.subject}</a></td>
                            <td>${board.regist_date.split(' ')[0]}</td>
                            <td>${board.hit}</td>
                            <td>${board.id}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            
            <!-- 페이지네이션 -->
            <div class="pagination">
                <c:if test="${currentPage > 1}">
                    <c:choose>
                        <c:when test="${not empty items and not empty text}">
                            <a href="searchboard?category=tip&page=${currentPage - 1}&items=${items}&text=${text}">이전</a>
                        </c:when>
                        <c:otherwise>
                            <a href="board?category=tip&page=${currentPage - 1}">이전</a>
                        </c:otherwise>
                    </c:choose>
                </c:if>
                
                <c:forEach begin="1" end="${totalPages}" var="i">
                    <c:choose>
                        <c:when test="${i == currentPage}">
                            <a class="active">${i}</a>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${not empty items and not empty text}">
                                    <a href="searchboard?category=tip&page=${i}&items=${items}&text=${text}">${i}</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="board?category=tip&page=${i}">${i}</a>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${currentPage < totalPages}">
                    <c:choose>
                        <c:when test="${not empty items and not empty text}">
                            <a href="searchboard?category=tip&page=${currentPage + 1}&items=${items}&text=${text}">다음</a>
                        </c:when>
                        <c:otherwise>
                            <a href="board?category=tip&page=${currentPage + 1}">다음</a>
                        </c:otherwise>
                    </c:choose>
                </c:if>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
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