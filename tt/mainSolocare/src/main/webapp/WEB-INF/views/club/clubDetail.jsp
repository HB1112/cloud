<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700&display=swap" rel="stylesheet">
    <title>동호회 상세 페이지</title>
    <style>
        body {
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            font-family: 'Noto Sans', sans-serif;
        }

        .content {
            max-width: 800px;
            margin: 30px auto;
            padding: 0 20px;
        }

        .club-detail-card {
            background: white;
            border-radius: 8px;
            padding: 25px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.05);
        }

        .club-header {
            border-bottom: 1px solid #f0f0f0;
            padding-bottom: 15px;
            margin-bottom: 20px;
        }

        .club-title {
            font-size: 1.5rem;
            font-weight: 700;
            color: #333;
            margin-bottom: 8px;
        }

        .club-leader {
            font-size: 1rem;
            color: #666;
            margin-bottom: 5px;
        }

        .club-info {
            margin-bottom: 25px;
        }

        .info-item {
            margin-bottom: 12px;
            padding: 8px;
            background: #f8f9fa;
            border-radius: 6px;
            display: flex;
            align-items: center;
        }

        .info-label {
            font-weight: 500;
            color: #555;
            width: 80px;
            flex-shrink: 0;
        }

        .info-value {
            color: #333;
        }

        .button-group {
            display: flex;
            gap: 10px;
            margin-bottom: 15px;
        }

        .admin-buttons {
            display: flex;
            gap: 8px;
            margin-top: 15px;
            padding-top: 15px;
            border-top: 1px solid #eee;
        }

        .btn {
            padding: 6px 12px;
            border-radius: 4px;
            font-size: 0.9rem;
            font-weight: 500;
            transition: all 0.2s;
            border: none;
            min-width: 80px;
        }

        .btn:hover {
            transform: translateY(-1px);
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }

        .btn-primary { background-color: #007bff; color: white; }
        .btn-danger { background-color: #dc3545; color: white; }
        .btn-secondary { background-color: #6c757d; color: white; }
        .btn-info { background-color: #17a2b8; color: white; }

        .back-link {
            display: inline-block;
            margin-top: 15px;
            color: #666;
            text-decoration: none;
            font-size: 0.9rem;
        }

        .back-link:hover {
            color: #333;
            text-decoration: none;
        }

        @media (max-width: 768px) {
            .content {
                padding: 0 15px;
            }
            
            .button-group, .admin-buttons {
                flex-wrap: wrap;
            }
            
            .btn {
                flex: 1;
                min-width: 120px;
            }
        }
    </style>
</head>
<body>
    <div id="menuWrapper">
        <%@ include file="../navbar.jsp" %>
    </div>

    <div class="content">
        <div class="club-detail-card">
            <div class="club-header">
                <h2 class="club-title">${club.clubName}</h2>
                <p class="club-leader">회장: ${club.clubLeader}</p>
            </div>

            <div class="club-info">
                <div class="info-item">
                    <span class="info-label">소개</span>
                    <span class="info-value">${club.clubDescription}</span>
                </div>
                <div class="info-item">
                    <span class="info-label">카테고리</span>
                    <span class="info-value">${club.clubCategory}</span>
                </div>
                <div class="info-item">
                    <span class="info-label">위치</span>
                    <span class="info-value">${club.region} ${club.district}</span>
                </div>
                <div class="info-item">
                    <span class="info-label">회원 수</span>
                    <span class="info-value">${club.count} 명</span>
                </div>
            </div>

            <div class="button-group">
                <button type="button" onclick="joinClub(${club.clubNum})" class="btn btn-primary">가입하기</button>
                <form action="cancelMember" method="post" style="display: contents;">
                    <input type="hidden" name="memberId" value="${clubMember.memberId}">
                    <input type="hidden" name="clubNum" value="${clubMember.clubNum}">
                    <button type="submit" class="btn btn-danger">탈퇴하기</button>
                </form>
            </div>

            <div class="admin-buttons">
                <form action="${pageContext.request.contextPath}/club/update/${club.clubNum}" method="get">
                    <input type="hidden" name="clubNum" value="${club.clubNum}"/>
                    <button type="submit" class="btn btn-info">수정</button>
                </form>
                
                <form action="${pageContext.request.contextPath}/club/cancelMember" method="post" 
                      onsubmit="return confirm('정말로 삭제하시겠습니까?');">
                    <input type="hidden" name="clubNum" value="${club.clubNum}"/>
                    <button type="submit" class="btn btn-danger">삭제</button>
                </form>
                
                <form action="${pageContext.request.contextPath}/club/membercheck" method="get">
                    <input type="hidden" name="clubNum" value="${club.clubNum}"/>
                    <button type="submit" class="btn btn-secondary">멤버조회</button>
                </form>
            </div>
        </div>

        <a href="${pageContext.request.contextPath}/club/list" class="back-link">← 목록으로 돌아가기</a>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
    function joinClub(clubNum) {
        fetch(`${pageContext.request.contextPath}/club/checkMembership?clubNum=${clubNum}`, {
            method: 'GET'
        })
        .then(response => response.json())
        .then(data => {
            if (data.isMember) {
                alert('이미 가입된 멤버입니다.');
            } else {
                window.location.href = `${pageContext.request.contextPath}/club/join?clubNum=${clubNum}`;
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('가입 확인 중 오류가 발생했습니다.');
        });
    }
    </script>
</body>
</html>