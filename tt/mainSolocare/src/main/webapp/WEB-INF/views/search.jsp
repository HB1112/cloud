<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>검색</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<style type="text/css">
/* Reset 기본 스타일 */
* Reset 기본 스타일 */
body, h1, h2, h3, h4, h5, h6, p, ul, li, a, img {
    margin: 0;
    padding: 0;
    list-style: none;
    text-decoration: none;
    box-sizing: border-box;
}

/* body 기본 스타일 */
/* Reset 기본 스타일 */
body, h1, h2, h3, h4, h5, h6, p, ul, li, a, img {
    margin: 0;
    padding: 0;
    list-style: none;
    text-decoration: none;
    box-sizing: border-box;
}

/* body 기본 스타일 */
body {
    font-family: 'Arial', sans-serif;
    font-size: 14px;
    line-height: 1.5;
    background-color: #f9f9f9;
    color: #333;
}

.container-fluid {
    padding: 20px;
}

/* 카테고리 사이드바 스타일 */
.category-sidebar {
        background-color: #f8f9fa; /* 밝은 회색 배경 */
        padding: 10px; /* 내부 여백 */
        margin-top : 100px;
        border-radius: 8px; /* 모서리 둥글게 */
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1); /* 그림자 효과 */
        max-width: 300px; /* 최대 너비 조정 */
        position: sticky; /* 스크롤 시 따라오도록 */
        top: 20px; /* 상단 여백 */
        height: 100%; /* 전체 높이 */
        overflow-y: auto; /* 세로 스크롤 가능 */
    }

    .category-list {
        list-style-type: none; /* 기본 리스트 스타일 제거 */
        padding: 0; /* 패딩 제거 */
        margin: 0; /* 마진 제거 */
    }

    .category-list > li {
        margin-bottom: 5px; /* 각 카테고리 간 간격 */
    }

    .category-list label {
        cursor: pointer; /* 포인터 커서 */
        font-weight: bold; /* 굵은 글씨 */
        color: #333; /* 텍스트 컬러 */
        display: flex; /* Flexbox 사용 */
        align-items: center; /* 세로 정렬 */
        transition: color 0.2s; /* 색상 변화 애니메이션 */
    }

    .category-list label:hover {
        color: #007bff; /* 호버 시 색상 변화 */
    }

    .subcategory {
        list-style-type: none; /* 기본 리스트 스타일 제거 */
        padding-left: 20px; /* 서브 카테고리 왼쪽 여백 */
        margin-top: 5px; /* 서브 카테고리 위 간격 */
        display: none; /* 기본적으로 숨김 */
    }

    .subcategory.visible {
        display: block; /* visible 클래스가 있을 때 보이기 */
    }

    .btn-category-search {
        background-color: #007bff; /* 버튼 배경색 */
        color: #fff; /* 버튼 텍스트 색상 */
        border: none; /* 기본 테두리 제거 */
        border-radius: 5px; /* 둥근 모서리 */
        padding: 8px; /* 내부 여백 */
        width: 100%; /* 전체 너비 */
        transition: background-color 0.2s; /* 배경색 변화 애니메이션 */
    }

    .btn-category-search:hover {
        background-color: #0056b3; /* 호버 시 배경색 변화 */
    }

    /* 검색 바 스타일 */
    .search-bar {
        margin-top: 20px; /* 상단 여백 */
        text-align: left; /* 왼쪽 정렬 */
    }

    .input-group {
        width: 100%; /* 전체 너비 */
    }

     /* 기본 라디오 버튼 숨기기 */
    input[type="radio"] {
        display: none; /* 기본 라디오 버튼 숨김 */
    }

    /* 기본 라벨 스타일 */
    label {
        display: flex;
        align-items: center;
        margin-bottom: 5px;
        padding: 5px; /* 여백 추가 */
        cursor: pointer; /* 포인터 커서 */
    }

    /* 활성화된 카테고리 스타일 */
    input[type="radio"]:checked + span {
        background-color: #e0e0e0; /* 활성화된 카테고리 배경색 */
        border-radius: 4px; /* 모서리 둥글게 */
    }
/* 메인 콘텐츠 섹션 */
.col-md-9 {
    padding-left: 15px;
}
.search-bar {
    margin-bottom: 15px;
}
.search-bar .form-control {
    font-size: 13px;
}

/* 상품 섹션 */
.product-section {
    margin-top: 15px;
}
.category-title {
    font-size: 14px;
    font-weight: bold;
    margin-bottom: 10px;
}
.product-card {
    border: 1px solid #ddd;
    border-radius: 5px;
    overflow: hidden;
    font-size: 12px;
    max-width: 180px;
    margin: 10px auto;
}
.product-card .product-image {
    height: 100px;
    object-fit: cover;
}
.product-card .card-body {
    padding: 8px;
}
.product-card .product-name {
    font-size: 12px;
    font-weight: bold;
    margin-bottom: 3px;
}
.product-card .brand-or-mall {
    font-size: 10px;
    color: #777;
    margin-bottom: 3px;
}
.product-card .product-price {
    font-size: 12px;
    font-weight: bold;
    color: #e74c3c;
    margin-bottom: 5px;
}
.product-card .product-link {
    font-size: 10px;
}

/* 버튼 스타일 */
.btn-category-search {
    font-size: 12px;
    padding: 6px 10px;
}
.btn-primary {
    font-size: 12px;
    padding: 6px 10px;
}

/* 반응형 스타일 */
@media (max-width: 768px) {
    .category-sidebar {
        margin-bottom: 15px;
    }
    .product-card {
        max-width: 150px;
    }
    .product-card .product-image {
        height: 80px;
    }
}

</style>
</head>
<body>
<div id="menuWrapper">
    <%@ include file="navbar.jsp" %>
</div>

<div class="container-fluid main-container">
    <div class="row"> <!-- 전체 높이를 100vh로 설정 -->
        <!-- 사이드바: 카테고리 필터 -->
        <div class="category-sidebar col-md-3 d-flex align-items-center justify-content-center"> <!-- 중앙 배치 -->
            <div class="w-100" style="max-width: 250px;"> <!-- 내부 요소의 너비를 250px로 설정 -->
                <h4>카테고리</h4>
                <form id="categoryForm" action="${pageContext.request.contextPath}/results" method="get">
                    <ul class="category-list">
                        <c:forEach var="category1" items="${categories.keySet()}">
                            <li>
                                <label style="display: flex; align-items: center; margin-bottom: 5px;"> <!-- 라벨을 플렉스로 설정하여 라디오 버튼과 텍스트를 수평으로 정렬 -->
								    <input type="radio" name="category1" value="${category1}" ${param.category1 == category1 ? 'checked' : ''} style="width: 16px; height: 16px; margin-right: 8px; appearance: none; border: 1px solid #000; border-radius: 4px;"> <!-- 네모 형태의 라디오 버튼 스타일 -->
								    <span>${category1}</span> <!-- 텍스트와 라디오 버튼 사이 간격 추가 -->
								</label>
                                <ul class="subcategory ${param.category1 == category1 ? 'visible' : ''}">
                                    <c:forEach var="category2" items="${categories[category1].keySet()}">
                                        <li>
                                            <label style="display: flex; align-items: center; margin-bottom: 5px;"> <!-- 라벨을 플렉스로 설정하여 라디오 버튼과 텍스트를 수평으로 정렬 -->
											    <input type="radio" name="category2" value="${category2}" ${param.category2 == category2 ? 'checked' : ''} style="width: 16px; height: 16px; margin-right: 8px; appearance: none; border: 1px solid #000; border-radius: 4px;"> <!-- 네모 형태의 라디오 버튼 스타일 -->
											    <span>${category2}</span> <!-- 텍스트와 라디오 버튼 사이 간격 추가 -->
											</label>
                                            <ul class="subcategory ${param.category2 == category2 ? 'visible' : ''}">
                                                <c:forEach var="category3" items="${categories[category1][category2]}">
                                                    <li>
                                                        <label style="display: flex; align-items: center; margin-bottom: 5px;"> <!-- 라벨을 플렉스로 설정하여 라디오 버튼과 텍스트를 수평으로 정렬 -->
											                <input type="radio" name="category3" value="${category3}" ${param.category3 == category3 ? 'checked' : ''} style="width: 16px; height: 16px; margin-right: 8px; appearance: none; border: 1px solid #000; border-radius: 4px;"> <!-- 네모 형태의 라디오 버튼 스타일 -->
											                <span>${category3}</span> <!-- 텍스트와 라디오 버튼 사이 간격 추가 -->
											            </label>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </li>
                        </c:forEach>
                    </ul>
                    <button type="submit" class="btn btn-category-search mt-3">카테고리 검색</button>
                </form>
            </div>
        </div>


        <!-- 메인 콘텐츠: 검색창과 추천 상품 -->
        <div class="col-md-9">
            <div class="d-flex align-items-center mb-3"> <!-- 왼쪽 정렬 -->
                <form id="searchForm" action="${pageContext.request.contextPath}/results" method="get" class="w-100">
                    <div class="input-group" style="max-width: 300px;"> <!-- 최대 너비 설정 -->
                        <input type="text" id="searchQuery" name="query" class="form-control" placeholder="상품 명 또는 브랜드 검색">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-primary">검색</button>
                        </div>
                    </div>
                </form>
            </div>

            <h4>추천 상품</h4>
            <div class="row">
                <c:forEach var="product" items="${interiorProducts}">
                    <div class="col-md-3 mb-4 d-flex"> <!-- 4개 가로 배치 -->
                        <div class="card w-100 d-flex flex-column"> <!-- 카드 내부를 플렉스 컬럼으로 설정 -->
                            <img src="${product.image}" class="card-img-top" alt="${product.name}" style="height: 150px; object-fit: cover;">
                            <div class="card-body d-flex flex-column flex-grow-1"> <!-- 카드 바디 플렉스 컬럼으로 설정 -->
                                <h5 class="card-title" style="margin: 0; font-size: 1rem; text-align: left;">${product.name}</h5>
                                <div class="brand-price" style="text-align: left; margin: 5px 0;"> <!-- 브랜드 및 가격 영역 -->
                                    <c:choose>
                                        <c:when test="${product.brand != '알 수 없음'}">
                                            <p class="brand-or-mall" style="margin: 0; font-size: 0.9rem;">${product.brand}</p>
                                        </c:when>
                                        <c:otherwise>
                                            <p class="brand-or-mall" style="margin: 0; font-size: 0.9rem;">&nbsp;</p> <!-- 빈 줄 유지 -->
                                        </c:otherwise>
                                    </c:choose>
                                    <p class="card-text" style="margin: 0; font-size: 0.9rem;">${product.price}</p>
                                </div>
                                <div class="mt-auto"> <!-- 버튼을 아래로 정렬 -->
                                    <a href="${product.link}" class="btn btn-primary" style="width: auto; padding: 3px 8px; text-align: center; font-size: 0.8rem;" target="_blank" rel="noopener noreferrer">구매하기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <h4>추천 식품</h4>
            <div class="row">
                <c:forEach var="product" items="${foodProducts}">
                    <div class="col-md-3 mb-4 d-flex"> <!-- 4개 가로 배치 -->
                        <div class="card w-100 d-flex flex-column"> <!-- 카드 내부를 플렉스 컬럼으로 설정 -->
                            <img src="${product.image}" class="card-img-top" alt="${product.name}" style="height: 150px; object-fit: cover;">
                            <div class="card-body d-flex flex-column flex-grow-1"> <!-- 카드 바디 플렉스 컬럼으로 설정 -->
                                <h5 class="card-title" style="margin: 0; font-size: 1rem; text-align: left;">${product.name}</h5>
                                <div class="brand-price" style="text-align: left; margin: 5px 0;"> <!-- 브랜드 및 가격 영역 -->
                                    <c:choose>
                                        <c:when test="${product.brand != '알 수 없음'}">
                                            <p class="brand-or-mall" style="margin: 0; font-size: 0.9rem;">${product.brand}</p>
                                        </c:when>
                                        <c:otherwise>
                                            <p class="brand-or-mall" style="margin: 0; font-size: 0.9rem;">&nbsp;</p> <!-- 빈 줄 유지 -->
                                        </c:otherwise>
                                    </c:choose>
                                    <p class="card-text" style="margin: 0; font-size: 0.9rem;">${product.price}</p>
                                </div>
                                <div class="mt-auto"> <!-- 버튼을 아래로 정렬 -->
                                    <a href="${product.link}" class="btn btn-primary" style="width: auto; padding: 3px 8px; text-align: center; font-size: 0.8rem;" target="_blank" rel="noopener noreferrer">구매하기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>


<script>
// 기존 JS 로직 그대로 유지 - 카테고리 토글 기능
document.querySelectorAll('.category-list input[type="radio"]').forEach(input => {
    let lastClicked = null;
    input.addEventListener('click', (e) => {
        if (lastClicked === input) {
            input.checked = false;
            lastClicked = null;
            const event = new Event('change', { bubbles: true });
            input.dispatchEvent(event);
        } else {
            lastClicked = input;
        }
    });

    input.addEventListener('change', () => {
        const listItem = input.closest('li');
        if (!listItem) return;
        const subcategory = listItem.querySelector('.subcategory');
        if (subcategory && input.checked) {
            subcategory.classList.add('visible');
        } else if (subcategory && !input.checked) {
            subcategory.classList.remove('visible');
        }

        document.querySelectorAll('.category-list .subcategory').forEach(sub => {
            const parent = sub.closest('li');
            if (sub !== subcategory && !parent.contains(input)) {
                sub.classList.remove('visible');
            }
        });

        const currentLevel = input.name.replace('category', '');
        const nextLevel = parseInt(currentLevel) + 1;
        document.querySelectorAll(`input[name="category${nextLevel}"]`).forEach(nextInput => {
            const nextListItem = nextInput.closest('li');
            const nextSubcategory = nextListItem ? nextListItem.querySelector('.subcategory') : null;
            if (nextInput.checked && nextSubcategory) {
                nextSubcategory.classList.add('visible');
            }
        });
    });
    
    function toggleRadio(element) {
        const radio = element.querySelector('input');
        const allRadios = document.querySelectorAll('.custom-radio');

        // 모든 커스텀 라디오를 초기화
        allRadios.forEach(r => {
            r.classList.remove('checked');
        });

        // 현재 클릭된 라디오 버튼 체크
        radio.checked = true;
        element.classList.add('checked');
    }
});
</script>
</body>
</html>
