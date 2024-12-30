<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>동호회 등록</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
    <style>
         body {
            background-color: #f8f9fa;
            font-family: 'Noto Sans', sans-serif;
            margin: 0;
            padding: 0;
        }

        .header {
            text-align: center;
            color: #333;
            margin-top: 20px;
            margin-bottom: 20px; /* navbar와의 간격 추가 */
        }

        .form-container {
            background: white;
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 15px; /* 클래스 속성으로 변경 */
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
            color: #333;
        }

        input[type="text"],
        textarea,
        select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ced4da;
            border-radius: 4px;
            font-size: 16px;
            box-sizing: border-box;
        }

        textarea {
            resize: vertical;
            height: 100px; /* 기본 높이 설정 */
        }

        button[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
            transition: background-color 0.3s;
        }

        button[type="submit"]:hover {
            background-color: #0056b3;
        }

        /* 반응형 디자인 */
        @media (max-width: 768px) {
            .form-container {
                padding: 15px;
            }
            button[type="submit"] {
                padding: 8px;
                font-size: 14px;
            }
        }
    </style>
<body>
	<%@ include file="/WEB-INF/views/navbar.jsp" %>
    <h1 class="header">동호회 등록</h1>
    <div class="form-container">
        <form name="newClub" action="regist" method="post">
            <div class="form-group">
                <label>회원 아이디:</label>
                <input name="clubLeader" type="text" value="${mem.id}" readonly>
            </div>
            <div class="form-group">
                <label>동호회명:</label>
                <input name="clubName" type="text" required>
            </div>
            <div class="form-group">
                <label>동호회 설명:</label>
                <textarea name="clubDescription" required></textarea>
            </div>
            <div class="form-group">
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
            <div class="form-group">
                <label>동호회 활동 지역:</label>
                <select name="region" id="sido1"></select>
                <select name="district" id="gugun1"></select>
            </div>
            <div class="form-group">
                <button type="submit">등록</button>
            </div>
        </form>
    </div>
</body>
<script type="text/javascript">
$(function(){
    var area0 = ["시/도 선택", "서울특별시", "인천광역시", "대전광역시", "광주광역시", "대구광역시", "울산광역시", "부산광역시", "경기도", "강원도", "충청북도", "충청남도", "전라북도", "전라남도", "경상북도", "경상남도", "제주특별자치도"];
    var area1 = ["강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구"];
    var area2 = ["계양구", "남구", "남동구", "동구", "부평구", "서구", "연수구", "중구", "강화군", "옹진군"];
    var area3 = ["대덕구", "동구", "서구", "유성구", "중구"];
    var area4 = ["광산구", "남구", "동구", "북구", "서구"];
    var area5 = ["남구", "달서구", "동구", "북구", "서구", "수성구", "중구", "달성군"];
    var area6 = ["남구", "동구", "북구", "중구", "울주군"];
    var area7 = ["강서구", "금정구", "남구", "동구", "동래구", "부산진구", "북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구", "중구", "해운대구", "기장군"];
    var area8 = ["고양시", "과천시", "광명시", "광주시", "구리시", "군포시", "김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시", "시흥시", "안산시", "안성시", "안양시", "양주시", "오산시", "용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시", "포천시", "하남시", "화성시", "가평군", "양평군", "여주군", "연천군"];
    var area9 = ["강릉시", "동해시", "삼척시", "속초시", "원주시", "춘천시", "태백시", "고성군", "양구군", "양양군", "영월군", "인제군", "정선군", "철원군", "평창군", "홍천군", "화천군", "횡성군"];
    var area10 = ["제천시", "청주시 상당구", "청주시 서원구", "청주시 흥덕구", "청주시 청원구", "충주시", "괴산군", "단양군", "보은군", "영동군", "옥천군", "음성군", "증평군", "진천군"];
    var area11 = ["계룡시", "공주시", "논산시", "보령시", "서산시", "아산시", "천안시 동남구", "천안시 서북구", "금산군", "당진시", "부여군", "서천군", "청양군", "태안군", "홍성군"];
    var area12 = ["군산시", "김제시", "남원시", "익산시", "전주시 완산구", "전주시 덕진구", "정읍시", "고창군", "무주군", "부안군", "순창군", "완주군", "임실군", "장수군", "진안군"];
    var area13 = ["광양시", "나주시", "목포시", "순천시", "여수시", "강진군", "고흥군", "곡성군", "구례군", "담양군", "무안군", "보성군", "신안군", "영광군", "영암군", "완도군", "장성군", "장흥군", "진도군", "함평군", "해남군", "화순군"];
    var area14 = ["경산시", "경주시", "구미시", "김천시", "문경시", "상주시", "안동시", "영주시", "영천시", "포항시 남구", "포항시 북구", "고령군", "군위군", "봉화군", "성주군", "영덕군", "영양군", "예천군", "울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군"];
    var area15 = ["거제시", "김해시", "밀양시", "사천시", "양산시", "진주시", "창원시 의창구", "창원시 성산구", "창원시 마산합포구", "창원시 마산회원구", "창원시 진해구", "통영시", "거창군", "고성군", "남해군", "산청군", "의령군", "창녕군", "하동군", "함안군", "함양군", "합천군"];
    var area16 = ["서귀포시", "제주시"];

 // 시/도 선택 박스 초기화 (value를 지역 이름으로 설정)
    $("select[name=region]").append(area0.map(function(item) {
        return "<option value='" + item + "'>" + item + "</option>";
    }));

    // 시/도 선택시 구/군 설정
    $("select[name=region]").change(function() {
        var regionName = $(this).val();
        var $gugun = $("select[name=district]");
        $gugun.empty().append("<option value=''>구/군 선택</option>"); // 초기화

        // 선택된 시/도에 맞는 구/군 배열
        var index = area0.indexOf(regionName); // 지역 이름으로 인덱스 찾기
        var selectedArea = eval("area" + index);
        if (selectedArea) {
            selectedArea.forEach(function(item) {
                $gugun.append("<option value='" + item + "'>" + item + "</option>");
            });
        }
    });
});

</script>
</html>