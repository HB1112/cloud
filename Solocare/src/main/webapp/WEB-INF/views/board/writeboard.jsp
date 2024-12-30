<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            font-family: 'Noto Sans', sans-serif;
        }

        .content {
            max-width: 900px;
            margin: 30px auto;
            padding: 0 20px;
        }

        .form-title {
            text-align: center;
            font-size: 1.8rem;
            font-weight: 700;
            color: #333;
            margin-bottom: 25px;
        }

        .form-container {
            background: white;
            border-radius: 8px;
            padding: 20px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.05);
        }

        .form-group {
            margin-bottom: 15px;
        }
        
        select.form-control {
		    height: 40px !important; 
		    line-height: normal !important; 
		    padding: 5px !important; 
		    font-size: 1rem !important;
		}

        label {
            font-weight: 500;
            margin-bottom: 5px;
            display: block;
            color: #495057;
        }

        .form-control {
            width: 100%;
            padding: 10px;
            border: 1px solid #dee2e6;
            border-radius: 4px;
            font-size: 1rem;
            color: #495057;
        }

        .form-control:focus {
            border-color: #007bff;
            box-shadow: 0 0 5px rgba(0,123,255,0.25);
        }

        .btn {
            padding: 10px 15px;
            border-radius: 4px;
            font-size: 0.9rem;
            font-weight: 500;
            transition: all 0.2s;
        }

        .btn-primary {
            background-color: #007bff;
            color: white;
            border: none;
        }

        .btn-primary:hover {
            background-color: #0056b3;
        }

        .btn-reset {
            background-color: #6c757d;
            color: white;
            border: none;
        }

        .btn-reset:hover {
            background-color: #5a6268;
        }
    </style>
    <script type="text/javascript">
        function checkForm() {
            if (!document.newWrite.subject.value.trim()) {
                alert("제목을 입력하세요.");
                document.newWrite.subject.focus();
                return false;
            }
            if (!document.newWrite.content.value.trim()) {
                alert("내용을 입력하세요.");
                document.newWrite.content.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <%@ include file="../navbar.jsp" %>

    <div class="content">
        <h2 class="form-title">게시글 작성</h2>
        <div class="form-container">
            <form name="newWrite" action="writeboard" method="post" onsubmit="return checkForm();">
                <div class="form-group">
                    <label for="category">카테고리</label>
                    <select id="category" name="category" class="form-control">
					    <option value="tip" ${category == 'tip' ? 'selected' : ''}>생활팁/정보</option>
					    <option value="free" ${category == 'free' ? 'selected' : ''}>자유</option>
					    <option value="sell" ${category == 'sell' ? 'selected' : ''}>판매</option>
					    <option value="buy" ${category == 'buy' ? 'selected' : ''}>구매</option>
					</select>
                </div>

                <div class="form-group">
                    <label for="id">아이디</label>
                    <input type="text" id="id" name="id" class="form-control" value="${mem.id}" readonly>
                </div>

                <div class="form-group">
                    <label for="subject">제목</label>
                    <input type="text" id="subject" name="subject" class="form-control" placeholder="제목을 입력하세요">
                </div>

                <div class="form-group">
                    <label for="content">내용</label>
                    <textarea id="content" name="content" class="form-control" rows="6" placeholder="내용을 입력하세요"></textarea>
                </div>

                <div class="form-group text-center">
                    <button type="submit" class="btn btn-primary">등록</button>
                    <button type="reset" class="btn btn-reset">취소</button>
                </div>
            </form>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
