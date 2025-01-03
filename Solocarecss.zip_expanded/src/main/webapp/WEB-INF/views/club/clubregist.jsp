<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동호회 등록</title>
</head>
<body>
	    <h1>동호회 등록</h1>
    <form name="newClub" action="regist" method="post">
        <div>
            <label>회원 아이디:</label>
            <input name="clubLeader" type="text"  value="${mem.id}" readonly>
        </div>
        <div>
            <label>동호회명:</label>
            <input name="clubName" type="text" required>
        </div>
        <div>
            <label>동호회 설명:</label>
            <textarea name="clubDescription" required></textarea>
        </div>
        <div>
		    <label for="clubCategory">동호회 카테고리:</label>
		    <select name="clubCategory" id="clubCategory" required>
		        <option value="">선택하세요</option>
		        <option value="스포츠 및 e스포츠">스포츠 및 e스포츠</option>
		        <option value="자기개발">자기개발</option>
		        <option value="봉사 및 사회적 활동">봉사 및 사회적 활동</option>
		        <option value="문화 및 예술">문화 및 예술</option>
		        <option value="여행 및 탐험">여행 및 탐험</option>
		    </select>
		</div>
        <div>
            <label>동호회 활동 지역:</label>
            <input name="clubLocation" type="text" required>
        </div>
        <div>
            <button type="submit">등록</button>
        </div>
    </form>
</body>
</html>