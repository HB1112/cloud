<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f5f5f5;
    }

    .form-container {
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        padding: 20px;
        margin-bottom: 20px;
    }

    h2 {
        text-align: center;
        color: #333;
        margin-bottom: 20px;
    }

    .mb-3 {
        margin-bottom: 15px;
    }

    label {
        font-weight: bold;
        display: block;
        margin-bottom: 5px;
    }

    .form-control {
        width: 100%;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    .btn {
        padding: 10px 15px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    .btn:hover {
        background-color: #0056b3;
    }

    .btn-primary {
        margin-right: 10px;
    }

    #content {
        height: 100px;
        overflow-y: auto;
        border: 1px solid #ccc;
        border-radius: 4px;
        padding: 10px;
    }
</style>
<script type="text/javascript">
    function checkForm() {
        if (!document.newWrite.id.value) {
            alert("아이디를 입력하세요.");
            return false;
        }
        if (!document.newWrite.subject.value) {
            alert("제목을 입력하세요.");
            return false;
        }
        if (!document.getElementById('content').innerHTML.trim()) {
            alert("내용을 입력하세요.");
            return false;
        }
    }

    document.addEventListener('DOMContentLoaded', function () {
        document.getElementById('content').addEventListener('paste', function (e) {
            const items = e.clipboardData.items;

            for (let i = 0; i < items.length; i++) {
                const item = items[i];

                if (item.type.indexOf('image') !== -1) {
                    const file = item.getAsFile();
                    const reader = new FileReader();

                    reader.onload = function (event) {
                        const img = document.createElement('img');
                        img.src = event.target.result;
                        img.style.maxWidth = '100%'; // 이미지 크기 조정
                        img.style.height = 'auto';
                        document.getElementById('content').appendChild(img);
                    };

                    reader.readAsDataURL(file);
                }
            }

            // 기본 붙여넣기 동작 방지
            e.preventDefault();
        });
    });
</script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light fixed-top">
         <%@ include file="/WEB-INF/views/menu.jsp" %>
    </nav>
    <div class="form-container">
        <h2>게시글 작성</h2>
        <form name="newWrite" action="writeboard" method="post" onsubmit="return checkForm()">
            <div class="mb-3">
                <label>카테고리</label>
                <select name="category" class="form-control">
                    <option value="tip" ${category == 'tip' ? 'selected' : ''}>생활팁/정보</option>
                    <option value="free" ${category == 'free' ? 'selected' : ''}>자유</option>
                    <option value="sell" ${category == 'sell' ? 'selected' : ''}>판매</option>
                    <option value="buy" ${category == 'buy' ? 'selected' : ''}>구매</option>
                </select>
            </div>

            <div class="mb-3">
                <label>아이디</label>
                <input name="id" type="text" class="form-control" value="${mem.id}" readonly>
            </div>

            <div class="mb-3">
                <label>제목</label>
                <input name="subject" type="text" class="form-control" placeholder="제목을 입력하세요">
            </div>

            <div class="mb-3">
                <label>내용</label>
                <div id="content" contenteditable="true" class="form-control" placeholder="내용을 입력하세요"></div>
                <input type="hidden" name="content" id="hiddenContent">
            </div>

            <div class="mb-3">
                <input type="submit" class="btn btn-primary" value="등록">				
                <input type="reset" class="btn btn-primary" value="취소">
            </div>
        </form>
    </div>

    <script>
        // 폼 전송 시 내용 처리
        document.forms['newWrite'].onsubmit = function() {
            document.getElementById('hiddenContent').value = document.getElementById('content').innerHTML;
        };
    </script>
</body>
</html>
