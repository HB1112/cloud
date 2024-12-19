<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 class="title">${clubboard.subject}</h2>
        <div class="meta-info">
            <span>작성자: ${clubboard.memberid}</span>
            <span>작성일: ${clubboard.regist_date}</span>
            <span>조회수: ${clubboard.hit}</span>
        </div>
        <div class="content" id="content">
            <p>${clubboard.content}</p>
        </div>
		<div class="actions">         
            <a href="updateclubboard?boardnum=${clubboard.boardnum}">게시글 수정</a>
            <a href="deleteclubboard?boardnum=${clubboard.boardnum}&clubNum=${clubboard.clubNum}" 
               class="delete-link" 
               onclick="return confirm('정말 삭제하시겠습니까?');">게시글 삭제</a>
        </div>
	
</body>
</html>