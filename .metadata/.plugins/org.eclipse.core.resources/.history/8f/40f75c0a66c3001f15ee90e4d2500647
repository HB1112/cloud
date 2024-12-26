<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>정책 검색</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://kit.fontawesome.com/70c60afc84.js" crossorigin="anonymous"></script>
<link rel="stylesheet" href="resources/css/policy.css" />
<script>
    $(document).ready(function() {
        var selectedBizTypes = []; // 선택된 정책 분야
        var selectedRegions = [];   // 선택된 지역
        var currentPageIndex = 1;   // 현재 페이지 인덱스
        var itemsPerPage = 10;      // 페이지당 항목 수
        var totalPageCount;         // 전체 페이지 수

        // 전체 정책 목록 로드 함수
        function loadAllPolicies(pageIndex = 1) {
            $.ajax({
                url: '/Solocare/policy/search',
                type: 'GET',
                data: {
                    query: '', // 빈 쿼리로 전체 목록 요청
                    srchPolyBizSecd: '',
                    bizTycdSel: '',
                    pageIndex: pageIndex // 페이지 인덱스 추가
                },
                contentType: 'application/json;charset=UTF-8',
                success: function(response) {
                    try {
                        var data = (typeof response === 'string') ? JSON.parse(response) : response;
                        console.log('Received all policies:', data);
                        displayPolicies(data); // 전체 정책 목록 표시
                        totalPageCount = Math.ceil(data.youthPolicyList.totalCnt / itemsPerPage);
                        setupPagination(); // 페이지네이션 설정
                    } catch (e) {
                        console.error('Error:', e);
                        $('#result').html('<p>데이터 처리 중 오류가 발생했습니다: ' + e.message + '</p>');
                    }
                },
                error: function(xhr, status, error) {
                    $('#result').html('<p>오류가 발생했습니다. 상태: ' + status + ', 메시지: ' + error + '</p>');
                }
            });
        }

        // 페이지네이션 설정 함수
        function setupPagination() {
		    var paginationHtml = '';
		    var pageGroupSize = 10; // 한 번에 표시할 페이지 수
		    var startPage = Math.floor((currentPageIndex - 1) / pageGroupSize) * pageGroupSize + 1; // 시작 페이지
		    var endPage = Math.min(startPage + pageGroupSize - 1, totalPageCount); // 끝 페이지
		
		    // 이전 버튼
		    if (startPage > 1) {
		        paginationHtml += '<button class="page-button" data-page="' + (startPage - 1) + '">이전</button>';
		    }
		
		    // 페이지 번호 버튼
		    for (var i = startPage; i <= endPage; i++) {
		        paginationHtml += '<button class="page-button" data-page="' + i + '"' + 
		                          (i === currentPageIndex ? ' style="font-weight:bold;"' : '') + '>' + 
		                          i + '</button>';
		    }
		
		    // 다음 버튼
		    if (endPage < totalPageCount) {
		        paginationHtml += '<button class="page-button" data-page="' + (endPage + 1) + '">다음</button>';
		    }
		
		    $('#pagination').html(paginationHtml); // 페이지 버튼 추가
		}


        // 페이지 버튼 클릭 시 해당 페이지 데이터 요청
        $(document).on('click', '.page-button', function() {
            currentPageIndex = $(this).data('page'); // 현재 페이지 인덱스 업데이트
            loadAllPolicies(currentPageIndex); // 현재 페이지 인덱스를 사용하여 정책 목록 로드
        });


        $('#searchButton').click(function() {
            var query = $('#searchInput').val();

            // API 요청 파라미터 준비
            var params = {
                query: query,
                srchPolyBizSecd: selectedRegions.length > 0 ? selectedRegions.join(',') : '',
                bizTycdSel: selectedBizTypes.length > 0 ? selectedBizTypes.join(',') : '',
                pageIndex: currentPageIndex // 현재 페이지 인덱스 포함
            };

            // 파라미터를 콘솔에 출력
            console.log('AJAX 요청 파라미터:', params);

            $.ajax({
                url: '/Solocare/policy/search',
                type: 'GET',
                data: params,
                contentType: 'application/json;charset=UTF-8',
                success: function(response) {
                    try {
                        var data = (typeof response === 'string') ? JSON.parse(response) : response;
                        console.log('Received data:', data);

                        if (!data || !data.youthPolicyList || !data.youthPolicyList.youthPolicy) {
                            $('#result').html('<p>검색 결과가 없습니다.</p>');
                            return;
                        }

                        displayPolicies(data); // 결과 표시 함수 호출
                        totalPageCount = Math.ceil(data.youthPolicyList.totalCnt / itemsPerPage);
                        setupPagination(); // 페이지네이션 설정
                    } catch (e) {
                        console.error('Error:', e);
                        $('#result').html('<p>데이터 처리 중 오류가 발생했습니다: ' + e.message + '</p>');
                    }
                },
                error: function(xhr, status, error) {
                    $('#result').html('<p>오류가 발생했습니다. 상태: ' + status + ', 메시지: ' + error + '</p>');
                }
            });
        });


        // 정책 목록 표시 함수
        function displayPolicies(data) {
            var policies = data.youthPolicyList.youthPolicy;
            if (!policies) {
                $('#result').html('<p>검색 결과가 없습니다.</p>');
                return;
            }

            // 단일 결과일 경우 배열로 변환
            if (!Array.isArray(policies)) {
                policies = [policies];
            }

            var html = '<table class="policy-board">';
            html += '<thead><tr>';
            html += '<th>번호</th>';
            html += '<th>정책명</th>';
            html += '<th>지역</th>';
            html += '<th>신청기간</th>';
            html += '<th>정원</th>';
            html += '</tr></thead><tbody>';

            policies.forEach(function(policy) {
                html += '<tr>';
                html += '<td>' + policy.rnum + '</td>';
                html += '<td><div class="policy-title" onclick="toggleDetail(' + policy.rnum + ')">' + 
                        policy.polyBizSjnm + '</div>';
                html += '<div id="detail-' + policy.rnum + '" class="policy-detail" style="display:none;">';
                html += '<div class="detail-grid">';
                html += createDetailItem('정책 소개', policy.polyItcnCn);
                html += createDetailItem('지원 내용', policy.sporCn);
                html += createDetailItem('지원 규모', policy.sporScvl);
                html += createDetailItem('신청 자격', policy.prcpCn);
                html += createDetailItem('연령', policy.ageInfo);
                html += createDetailItem('전공', policy.majrRqisCn);
                html += createDetailItem('취업상태', policy.empmSttsCn);
                html += createDetailItem('신청 방법', policy.rqutProcCn);
                if (policy.rqutUrla && policy.rqutUrla !== 'null') {
                     html += createDetailItem('신청 링크', '<a href="' + policy.rqutUrla + '" target="_blank">바로가기</a>');
                }
                html += createDetailItem('문의처', policy.cherCtpcCn);
                html += '</div></div></td>';
                html += '<td>' + getRegionName(policy.polyBizSecd) + '</td>';
                html += '<td>' + formatPeriod(policy.rqutPrdCn) + '</td>';
                html += '<td>' + policy.sporScvl + '</td>';
                html += '</tr>';
            });

            html += '</tbody></table>';
            $('#result').html(html);
        }

        // 상세 정보 표시 함수
        function createDetailItem(label, value) {
            if (!value || value === 'null') return '';
            return '<div class="detail-item"><strong>' + label + ':</strong> ' + value + '</div>';
        }
    	 // 지역 코드 변환 함수
        function getRegionName(code) {
            const regionCodes = {
                '003002001': '서울', 
                '003002002': '부산', 
                '003002003': '대구',
                '003002004': '인천', 
                '003002005': '광주', 
                '003002006': '대전',
                '003002007': '울산', 
                '003002008': '경기', 
                '003002009': '강원',
                '003002010': '충북', 
                '003002011': '충남', 
                '003002012': '전북',
                '003002013': '전남', 
                '003002014': '경북', 
                '003002015': '경남',
                '003002016': '제주', 
                '003002017': '세종'
            };
            return regionCodes[code.substring(0, 9)] || '기타';
        }
     	// 신청기간 포맷팅 함수
        function formatPeriod(period) {
            if (!period || period === 'null') return '-';
            return period.split('\r')[0];
        }

        // 페이지 로딩 시 전체 정책 목록 요청
        loadAllPolicies();
        
        
        $('.selection-button').click(function() {
            var value = $(this).data('value');

            // 버튼의 선택 상태를 토글
            $(this).toggleClass('selected');

            // 선택된 값 관리
            if ($(this).hasClass('selected')) {
                // 선택된 값 추가
                if ($(this).closest('div').index() === 1) { // 정책 분야
                    selectedBizTypes.push(value);
                } else { // 지역
                    selectedRegions.push(value);
                }
            } else {
                // 선택 해제된 값 제거
                if ($(this).closest('div').index() === 1) { // 정책 분야
                    selectedBizTypes = selectedBizTypes.filter(function(v) { return v !== value; });
                } else { // 지역
                    selectedRegions = selectedRegions.filter(function(v) { return v !== value; });
                }
            }
        });
    });
</script>

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light fixed-top">
         <%@ include file="/WEB-INF/views/menu.jsp" %>
    </nav>
    <div class="search-container">
        <h1>청년 정책 검색</h1>
        <div class="search-controls">
		    <div class="search-input-container">
		        <h3><i class="fa-solid fa-magnifying-glass"></i> 정책 이름 및 내용 </h3>
		        <input type="text" id="searchInput" placeholder="정책 이름 및 내용 검색">
		    </div>
            <div>
                <h3><i class="fa-solid fa-magnifying-glass"></i> 정책 분야 </h3>
                <button class="selection-button" data-value="023010">일자리 분야</button>
                <button class="selection-button" data-value="023020">주거 분야</button>
                <button class="selection-button" data-value="023030">교육 분야</button>
                <button class="selection-button" data-value="023040">복지.문화 분야</button>
                <button class="selection-button" data-value="023050">참여.권리 분야</button>
            </div>
        
            <div>
                <div>
                	<h3><i class="fa-solid fa-magnifying-glass"></i> 지역</h3>
                </div>
                <button class="selection-button" data-value="003002001">서울</button>
                <button class="selection-button" data-value="003002002">부산</button>
                <button class="selection-button" data-value="003002003">대구</button>
                <button class="selection-button" data-value="003002004">인천</button>
                <button class="selection-button" data-value="003002005">광주</button>
                <button class="selection-button" data-value="003002006">대전</button>
                <button class="selection-button" data-value="003002007">울산</button>
                <button class="selection-button" data-value="003002008">경기</button>
                <button class="selection-button" data-value="003002009">강원</button>
                <button class="selection-button" data-value="003002010">충북</button>
                <button class="selection-button" data-value="003002011">충남</button>
                <button class="selection-button" data-value="003002012">전북</button>
                <button class="selection-button" data-value="003002013">전남</button>
                <button class="selection-button" data-value="003002014">경북</button>
                <button class="selection-button" data-value="003002015">경남</button>
                <button class="selection-button" data-value="003002016">제주</button>
                <button class="selection-button" data-value="003002017">세종</button>
            </div>
        
            <button id="searchButton">검색</button>
        </div>
        
    </div>
    <div id="result"></div>
    <div id="pagination" class="pagination-controls"></div> <!-- 페이지네이션 추가 -->
</body>

</html>