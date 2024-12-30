<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.springmvc.domain.member" %>
    <%@ page import="com.springmvc.domain.clubboard" %>
    <%@ page import="com.springmvc.domain.clubboardcomment" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${clubboard.subject} - 클럽 게시판</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            line-height: 1.6;
        }
        .title {
            font-size: 24px;
            font-weight: bold;
        }
        .meta-info {
            color: #555;
            font-size: 14px;
        }
        .content {
            margin-top: 20px;
        }
        .actions {
            margin-top: 20px;
        }
        .actions a {
            margin-right: 10px;
            text-decoration: none;
            color: #007BFF;
        }
        .actions a:hover {
            text-decoration: underline;
        }
        .comments-section {
            display: none; /* 기본적으로 댓글 영역 숨김 */
            margin-top: 20px;
            border-top: 1px solid #ccc;
            padding-top: 10px;
        }
    </style>
</head>
<body>
	<% 
	    clubboard clubboard = (clubboard) request.getAttribute("clubboard"); // Model에서 board 객체 가져오기
	    member mem = (member) request.getSession().getAttribute("mem");
	    boolean isMatch = (mem != null) && mem.getId().equals(clubboard.getMemberid()); // 작성자 아이디 비교
    %>
    <h2 class="title">${clubboard.subject}</h2>
    <div class="meta-info">
        <span>작성자: ${clubboard.memberid}</span>
        <span> | 작성일: ${clubboard.regist_date}</span>
        <span> | 조회수: ${clubboard.hit}</span>
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
    <div>
        <button onclick="toggleComments()">댓글 ▼</button>
    </div>
    
    <div class="comments-section" id="comments-section">
    <input type="hidden" id="boardnum" name="boardnum" value="${clubboard.boardnum}"> <!-- 항상 게시물 번호를 포함 -->
    <input type="hidden" id="clubNum" name="clubNum" value="${clubboard.clubNum}"> <!-- 항상 클럽 번호를 포함 -->
    <div id="comments">
        <!-- 댓글이 여기에 로드됩니다. -->
    </div>

    <div class="comment-form">
	        <% if (mem != null) { %> <!-- 로그인한 경우에만 댓글 추가 가능 -->
	            <form id="commentForm">
	                <input type="hidden" id="authorid" name="authorid" value="${mem.id}">
	                <textarea id="commentcontent" name="commentcontent" required placeholder="댓글을 입력하세요"></textarea>
	                <button type="submit">댓글 추가</button>
	            </form>
	        <% } else { %>
	            <p>댓글을 추가하려면 <a href="/Solocare/login">로그인</a> 하세요.</p>
	        <% } %>
	    </div>
	</div>

</body>
<script>
	// 댓글 창 보이기
	function toggleComments() {
	    const commentsSection = document.getElementById('comments-section');
	    if (commentsSection.style.display === "none" || commentsSection.style.display === "") {
	        commentsSection.style.display = "block"; // 댓글 영역 보이기
	    } else {
	        commentsSection.style.display = "none"; // 댓글 영역 숨기기
	    }
	}
	// 댓글 추가
    document.getElementById('commentForm').addEventListener('submit', function(event) {
        event.preventDefault(); // 기본 제출 동작 방지
        
        const authorid = document.getElementById('authorid').value;
        const commentcontent = document.getElementById('commentcontent').value;
        const boardnum = document.getElementById('boardnum').value; // 게시글 번호
        const clubNum = document.getElementById('clubNum').value; // 클럽 번호

        fetch('/Solocare/club/addComment', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ 
                authorid: authorid, 
                commentcontent: commentcontent, 
                boardnum: boardnum, 
                clubNum: clubNum // 클럽 번호 추가
            })
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
            	loadComments(); // 댓글 추가 후 목록 갱신
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
 	// 댓글 로딩 함수
    // 댓글 로딩
	function loadComments() {
	    const boardnum = document.getElementById('boardnum').value; // 게시글 번호 가져오기
	
	    fetch('/Solocare/club/comments', {
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
	                           editComment(comment.commentnum, comment.commentcontent); // 댓글 수정 호출
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
	
	                commentsDiv.appendChild(newComment); // 새 댓글 추가
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


    // 페이지가 로드될 때 댓글 목록을 불러옵니다.
    document.addEventListener('DOMContentLoaded', loadComments);
    
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

            fetch('/Solocare/club/updateComment', {
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
        fetch('/Solocare/club/deleteComment', {
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
