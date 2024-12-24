<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>청년정책 데이터 AJAX 요청</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        .pagination {
            margin-top: 20px;
        }
        .pagination button {
            margin: 0 5px;
        }
    </style>
</head>
<body>
    <h1>청년정책 데이터</h1>
    <div id="dataContainer"></div>
    <div class="pagination" id="paginationContainer"></div> <!-- 페이징 버튼 컨테이너 -->
    
    <script>
        var currentPage = 1; // 현재 페이지 변수 초기화
        var totalPages = 0; // 전체 페이지 수

        $(document).ready(function() {
            loadData(currentPage); // 페이지 로드 시 데이터 요청

            function loadData(page) {
                $.ajax({
                    url: 'https://api.odcloud.kr/api/15117002/v1/uddi:989ab5fe-3649-4d45-8c1e-ed392f2080f9?page=' + page + '&perPage=10&serviceKey=2HBVdwEZTtGnvTZdf6lb%2B4iUIsEdlrxSXhxYwdikwp1HL3VaUR2swjsfFP3qaJiijEn2NeWFX9gXIlnWRVR8AQ%3D%3D', // 요청 URL
                    method: 'GET',
                    dataType: 'json', // 응답 데이터 타입
                    success: function(data) {
                        $('#dataContainer').empty(); // 데이터 컨테이너 초기화
                        
                        // 데이터가 존재할 경우
                        if (data.data.length > 0) {
                            $.each(data.data, function(index, item) {
                                $('#dataContainer').append('<p>' + item.사업명 + ': ' + item.사업내용 + '</p>'); // 데이터 출력
                            });
                            
                            // 전체 페이지 수 계산 (예시로 전체 데이터 수에 기반하여 계산)
                            totalPages = Math.ceil(data.totalCount / 10); // totalCount는 API에서 제공하는 전체 데이터 수
                            renderPagination(); // 페이지 번호 렌더링
                        } else {
                            $('#dataContainer').html('<p>데이터가 없습니다.</p>');
                            $('#paginationContainer').empty(); // 페이지 버튼 초기화
                        }
                    },
                    error: function(xhr, status, error) {
                        $('#dataContainer').html('<p>데이터를 불러오는 데 실패했습니다.</p>');
                    }
                });
            }

            function renderPagination() {
                $('#paginationContainer').empty(); // 기존 페이지 버튼 초기화
                for (var i = 1; i <= totalPages; i++) {
                    $('#paginationContainer').append('<button class="page-button" data-page="' + i + '">' + i + '</button>');
                }

                // 페이지 버튼 클릭 이벤트
                $('.page-button').click(function() {
                    currentPage = $(this).data('page'); // 클릭한 페이지 번호 저장
                    loadData(currentPage); // 해당 페이지 데이터 요청
                });
            }
        });
    </script>
</body>
</html>
