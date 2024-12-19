<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>클럽 게시판</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700&family=Noto+Serif:wght@400;700&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        body {
            font-family: 'Noto Sans', sans-serif;
            margin-top: 80px;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        } 
    </style>
</head>
<body>
    <%@ include file="../menu.jsp"%>
    <div class="container">
        <h1 class="mt-4">클럽 게시판</h1>
        <h2>모집 정보</h2>
        <p>이곳에서 동호회에 대한 모집 정보를 확인하세요.</p>
        
        <!-- 게시글 작성 버튼 추가 -->
        <div class="mb-3">
            <a href="writeclub?clubNum=${clubNum}" class="btn btn-primary">게시글 작성</a>
        </div>
        
        <h2>게시글 목록</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>등록일</th>
                    <th>조회 수</th>
                </tr>
            </thead>
            <tbody>
                <!-- 게시글 리스트를 출력 -->
                <c:forEach var="board" items="${clubboards}">
                    <tr>
                        <td>${board.boardnum}</td>
                        <td><a href="detailboard?boardnum=${board.boardnum}">${board.subject}</a></td>
                        <td>${board.memberid}</td>
                        <td>${board.regist_date}</td>
                        <td>${board.hit}</td>
                    </tr>
                </c:forEach>
                <c:if test="${empty clubboards}">
                    <tr>
                        <td colspan="5" class="text-center">게시글이 없습니다.</td>
                    </tr>
                </c:if>
            </tbody>
        </table>
    </div>
</body>
</html>
