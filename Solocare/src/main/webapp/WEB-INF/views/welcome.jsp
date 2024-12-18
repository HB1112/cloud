<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>솔로케어(SoloCare)</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700&family=Noto+Serif:wght@400;700&display=swap" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
    <%@ include file="menu.jsp"%>

    <!-- 메인 콘텐츠 -->
<div class="main-content">
    <div>
        <h1>솔로 라이프의 모든 것</h1>
        <a href="${pageContext.request.contextPath}/login">솔로케어 시작하기</a> <!-- 로그인 폼으로 연결 -->
    </div>

    <div>
        <div>
            <h5>쇼핑</h5>
            <p>1인가구 맞춤 제품(냉장고, 가전 등) 및 식자재 정보.</p>
        </div>
        <div>
            <h5>커뮤니티</h5>
            <p>정보 공유, 공동구매 및 동호회 관리.</p>
        </div>
        <div>
            <h5>건강 케어</h5>
            <p>홈트레이닝 영상 및 건강 데이터 관리.</p>
        </div>
        <div>
            <h5>정책 지원</h5>
            <p>사회성 증진 프로그램 및 지원 혜택 정보.</p>
        </div>
        <div>
            <h5>편의 서비스</h5>
            <p>정기 구독 서비스 및 루트 추천.</p>
        </div>
    </div>
</div>

    <!-- 푸터 -->
    <%@ include file="footer.jsp"%>

    <script>
        // 드롭다운 메뉴 토글 기능
        document.getElementById('shoppingDropdown').onclick = function() {
            var dropdown = document.getElementById('dropdownMenu');
            dropdown.style.display = dropdown.style.display === 'none' || dropdown.style.display === '' ? 'block' : 'none';
        };

        document.getElementById('communityDropdown').onclick = function() {
            var communityDropdown = document.getElementById('communityMenu');
            communityDropdown.style.display = communityDropdown.style.display === 'none' || communityDropdown.style.display === '' ? 'block' : 'none';
        };

        document.getElementById('healthDropdown').onclick = function() {
            var healthDropdown = document.getElementById('healthMenu');
            healthDropdown.style.display = healthDropdown.style.display === 'none' || healthDropdown.style.display === '' ? 'block' : 'none';
        };

        document.getElementById('policyDropdown').onclick = function() {
            var policyDropdown = document.getElementById('policyMenu');
            policyDropdown.style.display = policyDropdown.style.display === 'none' || policyDropdown.style.display === '' ? 'block' : 'none';
        };

        document.getElementById('serviceDropdown').onclick = function() {
            var serviceDropdown = document.getElementById('serviceMenu');
            serviceDropdown.style.display = serviceDropdown.style.display === 'none' || serviceDropdown.style.display === '' ? 'block' : 'none';
        };
    </script>
</body>
</html>
