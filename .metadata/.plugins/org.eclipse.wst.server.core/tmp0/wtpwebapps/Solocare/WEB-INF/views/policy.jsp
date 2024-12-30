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
        var selectedRegions = []; // 선택된 지역
        var currentPageIndex = 1; // 현재 페이지 인덱스
        var itemsPerPage = 10; // 페이지당 항목 수
        var totalPageCount; // 전체 페이지 수
		
     	// 모달 관련 함수
        function showModal(content) {
            $('#policyModal .modal-body').html(content);
            $('#policyModal').fadeIn(300);
        }
     	// 모달 닫기
        $(document).on('click', '.close-modal', function() {
            $('#policyModal').fadeOut(300);
        });

        // 모달 외부 클릭 시 닫기
        $(window).click(function(event) {
            if (event.target == document.getElementById('policyModal')) {
                $('#policyModal').fadeOut(300);
            }
        });
        
        // 전체 정책 목록 로드 함수
        function loadAllPolicies(pageIndex = 1) {
            var query = $('#searchInput').val();

            var params = {
                query: query,
                srchPolyBizSecd: selectedRegions.length > 0 ? selectedRegions.join(',') : '',
                bizTycdSel: selectedBizTypes.length > 0 ? selectedBizTypes.join(',') : '',
                pageIndex: pageIndex
            };

            console.log('AJAX 요청 파라미터:', params); // 디버깅용

            $.ajax({
                url: '/Solocare/policy/search',
                type: 'GET',
                data: params,
                contentType: 'application/json;charset=UTF-8',
                success: function(response) {
                    try {
                        var data = (typeof response === 'string') ? JSON.parse(response) : response;
                        if (!data || !data.youthPolicyList || !data.youthPolicyList.youthPolicy) {
                            $('#result').html('<p>검색 결과가 없습니다.</p>');
                            return;
                        }
                        displayPolicies(data);
                        totalPageCount = Math.ceil(data.youthPolicyList.totalCnt / itemsPerPage);
                        setupPagination();
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
                paginationHtml += '<button class="page-button' + (i === currentPageIndex ? ' active' : '') + '" data-page="' + i + '">' + i + '</button>';
            }

            // 다음 버튼
            if (endPage < totalPageCount) {
                paginationHtml += '<button class="page-button" data-page="' + (endPage + 1) + '">다음</button>';
            }

            $('#pagination').html(paginationHtml); // 페이지 버튼 추가
        }


        // 페이지 버튼 클릭 시 해당 페이지 데이터 요청
        $(document).on('click', '.page-button', function() {
            currentPageIndex = $(this).data('page'); // 클릭된 페이지 인덱스
            loadAllPolicies(currentPageIndex); // 조건과 함께 호출
        });

        // 검색 버튼 클릭 이벤트
        $('#searchButton').click(function() {
            currentPageIndex = 1; // 검색 시 페이지를 첫 페이지로 초기화
            loadAllPolicies(currentPageIndex); // 검색 조건과 함께 호출
        });

        // 정책 목록 표시 함수
        function displayPolicies(data) {
            var policies = data.youthPolicyList.youthPolicy;
            if (!policies) {
                $('#result').html('<p>검색 결과가 없습니다.</p>');
                return;
            }

            if (!Array.isArray(policies)) {
                policies = [policies];
            }

            var html = '<table class="policy-board">';
            html += '<thead><tr>';
            html += '<th>번호</th>';
            html += '<th>정책명</th>';
            html += '<th>지역</th>';
            html += '<th>신청기간</th>';
            html += '</tr></thead><tbody>';

            policies.forEach(function(policy) {
                html += '<tr>';
                html += '<td>' + policy.rnum + '</td>';
                html += '<td><div class="policy-title" onclick="showPolicyDetail(' + 
                        JSON.stringify(policy).replace(/"/g, '&quot;') + ')">' + 
                        policy.polyBizSjnm + '</div></td>';
                html += '<td>' + getRegionName(policy.polyBizSecd) + '</td>';
                html += '<td>' + formatPeriod(policy.rqutPrdCn) + '</td>';
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
		
    	 // 초기 상태 설정: 전체 버튼 선택
        $('.selection-button-part[data-value=""]').addClass('selected');
        $('.selection-button-region[data-value=""]').addClass('selected');

        // 정책 분야 버튼 클릭 이벤트
        $('.selection-button-part').click(function() {
            var value = $(this).data('value');

            // 전체 버튼 클릭 시
            if (value === "") {
                // 다른 정책 분야 버튼 선택 해제
                $('.selection-button-part').not(this).removeClass('selected');
                selectedBizTypes = []; // 선택된 정책 분야 초기화
                $(this).addClass('selected'); // 전체 버튼 선택 상태 유지
            } else {
                // 전체 버튼 선택 해제
                $('.selection-button-part[data-value=""]').removeClass('selected');

                // 선택 상태 토글
                $(this).toggleClass('selected');
                if ($(this).hasClass('selected')) {
                    selectedBizTypes.push(value);
                } else {
                    selectedBizTypes = selectedBizTypes.filter(function(v) { return v !== value; });
                }
            }
        });

        // 지역 버튼 클릭 이벤트
        $('.selection-button-region').click(function() {
            var value = $(this).data('value');

            // 전체 버튼 클릭 시
            if (value === "") {
                // 다른 지역 버튼 선택 해제
                $('.selection-button-region').not(this).removeClass('selected');
                selectedRegions = []; // 선택된 지역 초기화
                $(this).addClass('selected'); // 전체 버튼 선택 상태 유지
            } else {
                // 전체 버튼 선택 해제
                $('.selection-button-region[data-value=""]').removeClass('selected');

                // 선택 상태 토글
                $(this).toggleClass('selected');
                if ($(this).hasClass('selected')) {
                    selectedRegions.push(value);
                } else {
                    selectedRegions = selectedRegions.filter(function(v) { return v !== value; });
                }
            }
        });

        // 페이지 로딩 시 전체 정책 목록 요청
        loadAllPolicies();
        
    });
 	// 정책 상세 정보 표시 함수
    function showPolicyDetail(policy) {
        var detailHtml = '<div class="detail-grid">';
        detailHtml += createDetailItem('정책 소개', formatText(policy.polyItcnCn));
        detailHtml += createDetailItem('지원 내용', formatText(policy.sporCn));
        detailHtml += createDetailItem('지원 규모', formatText(policy.sporScvl));
        detailHtml += createDetailItem('신청 자격', formatText(policy.prcpCn));
        detailHtml += createDetailItem('연령', formatText(policy.ageInfo));
        detailHtml += createDetailItem('전공', formatText(policy.majrRqisCn));
        detailHtml += createDetailItem('취업상태', formatText(policy.empmSttsCn));
        detailHtml += createDetailItem('신청 방법', formatText(policy.rqutProcCn));
        if (policy.rqutUrla && policy.rqutUrla !== 'null') {
            detailHtml += createDetailItem('신청 링크', '<a href="' + policy.rqutUrla + '" target="_blank">바로가기</a>');
        }
        detailHtml += createDetailItem('문의처', formatText(policy.cherCtpcCn));
        detailHtml += '</div>';
        
        $('#policyModal .modal-body').html(detailHtml);
        $('#policyModal').fadeIn(300);
    }

 	// 상세 정보 아이템 생성 함수
    function createDetailItem(label, value) {
        if (!value || value === 'null') return '';
        return '<div class="detail-item"><strong>' + label + ':</strong><div class="detail-value">' + value + '</div></div>';
    }
 	// 텍스트 포맷팅 함수
    function formatText(text) {
        if (!text || text === 'null') return '';
        return text
            .replace(/\r\n/g, '<br/>') // \r\n을 <br/>로 변환
            .replace(/\n/g, '<br/>') // \n을 <br/>로 변환
            .replace(/\r/g, '<br/>') // \r을 <br/>로 변환
            .replace(/○/g, '<br/>○') // ○ 앞에 줄바꿈 추가
            .replace(/\s{2,}/g, ' '); // 여러 개의 공백을 하나로 통일
    }
</script>
</head>
<body>
    
    <%@ include file="/WEB-INF/views/navbar.jsp" %>
   
    <div class="search-container">
        <h1>청년 정책 검색</h1>
        <div class="search-controls">
            <div class="search-input-container">
                <h3><i class="fa-solid fa-magnifying-glass"></i> 정책 이름 및 내용 </h3>
                <input type="text" id="searchInput" placeholder="정책 이름 및 내용 검색">
            </div>
            
            <div>
                <h3><i class="fa-solid fa-magnifying-glass"></i> 정책 분야 </h3>
                <button class="selection-button-part" data-value="">전체 분야</button> <!-- 전체 분야 추가 -->
                <button class="selection-button-part" data-value="023010">일자리 분야</button>
                <button class="selection-button-part" data-value="023020">주거 분야</button>
                <button class="selection-button-part" data-value="023030">교육 분야</button>
                <button class="selection-button-part" data-value="023040">복지.문화 분야</button>
                <button class="selection-button-part" data-value="023050">참여.권리 분야</button>
            </div>

            <div>
                <div>
                    <h3><i class="fa-solid fa-magnifying-glass"></i> 지역</h3>
                </div>
                <button class="selection-button-region" data-value="">전체 지역</button>
                <button class="selection-button-region" data-value="003002001">서울</button>
                <button class="selection-button-region" data-value="003002002">부산</button>
                <button class="selection-button-region" data-value="003002003">대구</button>
                <button class="selection-button-region" data-value="003002004">인천</button>
                <button class="selection-button-region" data-value="003002005">광주</button>
                <button class="selection-button-region" data-value="003002006">대전</button>
                <button class="selection-button-region" data-value="003002007">울산</button>
                <button class="selection-button-region" data-value="003002008">경기</button><p>
                <button class="selection-button-region" data-value="003002009">강원</button>
                <button class="selection-button-region" data-value="003002010">충북</button>
                <button class="selection-button-region" data-value="003002011">충남</button>
                <button class="selection-button-region" data-value="003002012">전북</button>
                <button class="selection-button-region" data-value="003002013">전남</button>
                <button class="selection-button-region" data-value="003002014">경북</button>
                <button class="selection-button-region" data-value="003002015">경남</button>
                <button class="selection-button-region" data-value="003002016">제주</button>
                <button class="selection-button-region" data-value="003002017">세종</button>
            </div>
            <button id="searchButton">검색</button>
        </div>
    </div>
    <div id="result">
    
    </div>
    <div id="pagination" class="pagination-controls"></div> <!-- 페이지네이션 추가 -->
    <!-- 모달 추가 -->
    <div id="policyModal" class="modal">
        <div class="modal-content">
            <span class="close-modal">&times;</span>
            <div class="modal-body"></div>
        </div>
    </div>
</body>
</html>