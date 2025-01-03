<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ page import="com.springmvc.domain.member" %>
<%@ page import="com.springmvc.domain.board" %>
<%@ page import="com.springmvc.domain.comment" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세보기</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f5f5f5;
    }

    .post-container {
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        padding: 20px;
        margin-bottom: 20px;
        width: 70%; /* 본문 영역 70% 차지 */
    }

    .title {
        font-size: 24px;
        color: #333;
        margin-bottom: 10px;
    }

    .meta-info {
        font-size: 14px;
        color: #999;
        margin-bottom: 15px;
    }

    .meta-info span {
        margin-right: 15px;
    }

    .content {
        font-size: 16px;
        color: #555;
        line-height: 1.6;
    }

    .actions {
        margin-top: 20px;
    }

    .actions a {
        display: inline-block;
        margin-right: 10px;
        padding: 10px 15px;
        background-color: #007bff;
        color: white;
        text-decoration: none;
        border-radius: 5px;
        transition: background-color 0.3s;
    }

    .actions a:hover {
        background-color: #0056b3;
    }

    .delete-link {
        background-color: #dc3545; /* Red for delete */
    }

    .delete-link:hover {
        background-color: #c82333;
    }

    /* 댓글 스타일 */
    .comments-section {
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        padding: 20px;
        width: 70%; /* 댓글 영역 70% 차지 */
        margin-top: 20px; /* 본문과의 간격 */
        display: none; /* 기본적으로 댓글 영역 숨김 */
    }

    .comment {
        border-bottom: 1px solid #eee;
        padding: 10px 0;
    }

    .comment:last-child {
        border-bottom: none;
    }

    .comment-author {
        font-weight: bold;
    }

    .comment-date {
        font-size: 12px;
        color: #999;
    }

    .comment-form {
        margin-top: 20px;
        display: flex;
        flex-direction: column;
    }

    .comment-form textarea {
        width: 100%;
        height: 60px;
        margin-bottom: 10px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
        resize: none; /* 텍스트 영역 크기 조절 비활성화 */
    }

    .comment-form button {
        align-self: flex-end;
        padding: 10px 15px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }

    .comment-form button:hover {
        background-color: #0056b3;
    }
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light fixed-top">
         <%@ include file="/WEB-INF/views/menu.jsp" %>
    </nav>
    <div class="post-container">
        <% 
            board board = (board) request.getAttribute("board"); // Model에서 board 객체 가져오기
            member mem = (member) request.getSession().getAttribute("mem");
            boolean isMatch = (mem != null) && mem.getId().equals(board.getId()); // 작성자 아이디 비교
        %>

        <h2 class="title">${board.subject}</h2>
        <div class="meta-info">
            <span>작성자: ${board.id}</span>
            <span>작성일: ${board.regist_date}</span>
            <span>조회수: ${board.hit}</span>
        </div>
        <div class="content" id="content">
            <p>${board.content}</p>
        </div>

        <% if (isMatch) { %>
            <div class="actions">         
                <a href="updateboard?num=${board.num}">게시글 수정</a>
                <a href="deleteboard?num=${board.num}&category=${board.category}" 
                   class="delete-link" 
                   onclick="return confirm('정말 삭제하시겠습니까?');">게시글 삭제</a>
            </div>
        <% } %>
        <div>
            <button onclick="toggleComments()">댓글 ▼</button>
        </div>
    </div>
    
 	<div class="comments-section" id="comments-section">
	    <input type="hidden" id="num" name="num" value="${board.num}"> <!-- 항상 게시물 번호를 포함 -->
	    
	    <div id="comments">
	        
	    </div>
	
	    <div class="comment-form">
	        <% if (mem != null) { %> <!-- 로그인한 경우에만 댓글 추가 가능 -->
	            <form id="commentForm">
	                <input type="hidden" id="authorid" name="authorid" value="${mem.id}">
	                <textarea id="commentcontent" name="commentcontent" required placeholder="댓글을 입력하세요"></textarea>
	                <button type="submit">댓글 추가</button>
	            </form>
	        <% } else { %>
	            <p>댓글을 추가하려면 <a href="login">로그인</a> 하세요.</p>
	        <% } %>
	    </div>
	</div>




</body>
<script>
	const contentElement = document.getElementById('content');
	const content = contentElement.innerHTML.replace(/\n/g, '<br/>');
	contentElement.innerHTML = content;
	// 댓글 토글
	function toggleComments() {
	    const commentsSection = document.getElementById('comments-section');
	    if (commentsSection.style.display === "none" || commentsSection.style.display === "") {
	        commentsSection.style.display = "block"; // 댓글 영역 보이기
	    } else {
	        commentsSection.style.display = "none"; // 댓글 영역 숨기기
	    }
	}
	
	// 댓글 로딩
	document.addEventListener('DOMContentLoaded', function() {
	    loadComments(); // 페이지가 로드될 때 댓글 불러오기
	});
	// 댓글 로딩
    function loadComments() {
	    const boardnum = document.getElementById('num').value; 
	
	    fetch('/Solocare/comments', {
	        method: 'POST',
	        headers: {
	            'Content-Type': 'application/json'
	        },
	        body: JSON.stringify({ boardnum: boardnum })
	    })
	    .then(response => response.json())
	    .then(comments => {
	        const commentsDiv = document.getElementById('comments');
	        commentsDiv.innerHTML = ''; // 기존 댓글 초기화
	
	        if (comments.length > 0) {
	            comments.forEach(comment => {
	                const newComment = document.createElement('div');
	                newComment.className = 'comment';
	                newComment.setAttribute('data-commentnum', comment.commentnum); // 댓글 번호 추가
	                console.log('댓글 번호:', comment.commentnum); // 콘솔로 댓글 번호 출력
	                // 댓글 내용 추가
	                const authorSpan = document.createElement('span');
	                authorSpan.className = 'comment-author';
	                authorSpan.textContent = comment.authorid;
	
	                const contentParagraph = document.createElement('p');
	                contentParagraph.textContent = comment.commentcontent;
	
	                const dateSpan = document.createElement('span');
	                dateSpan.className = 'comment-date';
	                dateSpan.textContent = comment.createdDate;
	
	                newComment.appendChild(authorSpan);
	                newComment.appendChild(contentParagraph);
	                newComment.appendChild(dateSpan);
	
	                // 수정 및 삭제 버튼 추가
	                <% if (mem != null) { %>
	                    const currentUserId = '<%= mem.getId() %>';
	                    if (currentUserId === comment.authorid) {
	                        const editButton = document.createElement('button');
	                        editButton.textContent = '수정';
	                        
	                        editButton.onclick = () => {
	                            editComment(comment.commentnum, comment.commentcontent); // 댓글 번호 사용
	                        };
	
	                        const deleteButton = document.createElement('button');
	                        deleteButton.textContent = '삭제';
	                        deleteButton.onclick = () => {
	                            if (confirm('정말 삭제하시겠습니까?')) {
	                                deleteComment(comment.commentnum); // 댓글 삭제 호출
	                            }
	                        };
	
	                        newComment.appendChild(editButton);
	                        newComment.appendChild(deleteButton);
	                    }
	                <% } %>
	
	                commentsDiv.appendChild(newComment);
	            });
	        } else {
	            commentsDiv.innerHTML = '<p>댓글이 없습니다.</p>';
	        }
	    })
	    .catch(err => {
	        console.error('Error:', err);
	        alert('댓글을 불러오는 중 오류가 발생했습니다.');
	    });
	}

	// 댓글 추가 
	document.getElementById('commentForm').addEventListener('submit', function(event) {
	    event.preventDefault();
	
	    const boardnum = document.getElementById('num').value;
	    const authorid = document.getElementById('authorid').value;
	    const commentcontent = document.getElementById('commentcontent').value;
	
	    fetch('addComment', {
	        method: 'POST',
	        headers: {
	            'Content-Type': 'application/json'
	        },
	        body: JSON.stringify({
	            boardnum: boardnum,
	            authorid: authorid,
	            commentcontent: commentcontent
	        })
	    })
	    .then(response => response.json())
	    .then(data => {
	        if (data.success) {
	            loadComments(); // 댓글 추가 후 댓글 목록 다시 불러오기
	            document.getElementById('commentcontent').value = ''; // 텍스트 영역 초기화
	        } else {
	            alert('댓글 추가에 실패했습니다. 다시 시도해 주세요.');
	        }
	    })
	    .catch(err => {
	        console.error('Error:', err);
	        alert('댓글 추가 중 오류가 발생했습니다.');
	    });
	});
	
	// 댓글 수정
  	function editComment(commentnum, currentContent) {
	    // 댓글 요소 찾기
	    const commentElements = Array.from(document.querySelectorAll('.comment'));
	    const commentElement = commentElements.find(element => 
	        element.getAttribute('data-commentnum') === String(commentnum)
	    );
	
	    if (!commentElement) {
	        console.error('Comment element not found for comment number:', commentnum);
	        return; // 댓글 요소가 없으면 함수 종료
	    }
	
	    const editForm = document.createElement('form');
	    editForm.className = 'edit-comment-form';
	
	    const editTextarea = document.createElement('textarea');
	    editTextarea.value = currentContent;
	    editTextarea.required = true;
	
	    const saveButton = document.createElement('button');
	    saveButton.textContent = '저장';
	    saveButton.type = 'submit';
	
	    const cancelButton = document.createElement('button');
	    cancelButton.textContent = '취소';
	    cancelButton.type = 'button';
	
	    // 원래의 자식 요소를 저장
	    const originalChildren = Array.from(commentElement.children);
	
	    // 폼에 요소 추가
	    editForm.appendChild(editTextarea);
	    editForm.appendChild(saveButton);
	    editForm.appendChild(cancelButton);
	
	    // 댓글 요소의 내용을 초기화하고 수정 폼 추가
	    commentElement.innerHTML = '';
	    commentElement.appendChild(editForm);
	
	    // 취소 버튼 클릭 이벤트 처리
	    cancelButton.addEventListener('click', () => {
	        commentElement.innerHTML = ''; // 수정 폼 제거
	        originalChildren.forEach(child => commentElement.appendChild(child)); // 원래의 자식 요소 복원
	    });
	
	    // 폼 제출 이벤트 처리
	    editForm.addEventListener('submit', function(event) {
	        event.preventDefault(); // 기본 제출 동작 방지
	
	        const updatedContent = editTextarea.value.trim();
	
	        fetch('updateComment', {
	            method: 'POST',
	            headers: {
	                'Content-Type': 'application/json'
	            },
	            body: JSON.stringify({
	                commentnum: commentnum,
	                commentcontent: updatedContent
	            })
	        })
	        .then(response => response.json())
	        .then(data => {
	            if (data.success) {
	                loadComments(); // 댓글 목록 갱신
	            } else {
	                alert(data.message || '댓글 수정에 실패했습니다. 다시 시도해 주세요.');
	            }
	        })
	        .catch(err => {
	            console.error('Error:', err);
	            alert('댓글 수정 중 오류가 발생했습니다.');
	        });
	    });
	}
 	// 댓글 삭제
  	function deleteComment(commentnum) {
  	    fetch('/Solocare/deleteComment', {
  	        method: 'POST',
  	        headers: {
  	            'Content-Type': 'application/json'
  	        },
  	        body: JSON.stringify({ commentnum: commentnum }) // 댓글 번호를 요청 본문에 포함
  	    })
  	    .then(response => response.json())
  	    .then(data => {
  	        if (data.success) {
  	            loadComments(); // 댓글 삭제 후 댓글 목록 다시 불러오기
  	        } else {
  	            alert(data.message || '댓글 삭제에 실패했습니다. 다시 시도해 주세요.');
  	        }
  	    })
  	    .catch(err => {
  	        console.error('Error:', err);
  	        alert('댓글 삭제 중 오류가 발생했습니다.');
  	    });
  	}


	
</script>
</html>
