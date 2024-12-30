<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>검색</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style type="text/css">
	body {
    background-color: #fafafa;
    color: #333;
    font-family: 'Noto Sans KR', sans-serif;
    margin: 0;
    padding: 0;
}

.container-fluid.main-container {
    padding: 20px;
}

/* 사이드바 카테고리 영역 */
.category-sidebar {
    background: #fff;
    border: 1px solid #ddd;
    border-radius: 4px;
    padding: 20px;
    margin-bottom: 20px;
}

.category-sidebar h4 {
    font-size: 1.2rem;
    font-weight: 700;
    margin-bottom: 20px;
}

.category-list {
    list-style-type: none;
    padding: 0;
    margin: 0;
}

.category-list li {
    margin: 10px 0;
    position: relative;
}

.category-list input[type="radio"] {
    margin-right: 5px;
}

.category-list label {
    cursor: pointer;
    font-size: 0.95rem;
}

/* 서브카테고리 표시 */
.subcategory {
    display: none;
    margin-left: 20px;
    border-left: 1px solid #ddd;
    padding-left: 10px;
}

.subcategory.visible {
    display: block;
}

/* 카테고리 검색 버튼 */
.btn-category-search {
    background: #fff;
    border: 1px solid #333;
    color: #333;
    border-radius: 4px;
    font-size: 0.9rem;
    padding: 5px 10px;
    margin-top: 10px;
}
.btn-category-search:hover {
    background: #333;
    color: #fff;
}

/* 검색바 */
.search-bar, .sticky-search-bar {
    margin-bottom: 20px;
}

.search-bar .form-control,
.sticky-search-bar .form-control {
    background: #fff;
    color: #333;
    border: 1px solid #ccc;
}

/* 검색창 크기 줄이기 */
.search-bar .form-control,
.sticky-search-bar .form-control {
    max-width: 200px; /* 검색창 폭 줄임 */
    display: inline-block;
}
.search-bar .input-group-append .btn-primary,
.sticky-search-bar .input-group-append .btn-primary {
    background: #333;
    border: none;
    color: #fff;
    font-size: 0.9rem;
    padding: 5px 10px;
}
.search-bar .input-group-append .btn-primary:hover,
.sticky-search-bar .input-group-append .btn-primary:hover {
    background: #555;
}

/* 정렬 옵션 */
.sort-options {
    margin-bottom: 20px;
}
.sort-options label {
    margin-right: 10px;
}
.sort-options select {
    background: #fff;
    color: #333;
    border: 1px solid #ccc;
    padding: 5px;
    border-radius: 4px;
    font-size: 0.9rem;
}

/* 상품 카드 영역 */
.card {
    background: #fff;
    border: 1px solid #eee;
    border-radius: 4px;
    display: flex;
    flex-direction: column;
    height: 100%;
    transition: box-shadow 0.3s ease;
}
.card:hover {
    box-shadow: 0 2px 8px rgba(0,0,0,0.1);
}

.card-img-top {
    height: 180px; /* 이미지 높이 일정하게 */
    object-fit: cover;
    border-bottom: 1px solid #eee;
}

.card-body {
    padding: 10px;
    display: flex;
    flex-direction: column;
    justify-content: space-between; /* 버튼을 아래로 밀기 */
}

.card-title {
    font-size: 0.9rem;
    font-weight: 700;
    margin-bottom: 5px;
}

.brand-or-mall {
    font-size: 0.8rem;
    color: #666;
    margin-bottom: 5px;
}

.card-text {
    font-size: 0.9rem;
    font-weight: 700;
    margin-bottom: 10px;
}

.card .btn-primary {
    background: #fff;
    border: 1px solid #333;
    color: #333;
    font-size: 0.8rem;
    padding: 5px 10px;
    border-radius: 4px;
}
.card .btn-primary:hover {
    background: #333;
    color: #fff;
}

</style>
</head>
<body>
<div id="menuWrapper">
    <%@ include file="menu.jsp" %>
</div>

<div class="container-fluid main-container">
    <div class="row">
        <!-- 사이드바: 카테고리 필터 -->
        <div class="category-sidebar col-md-3">
            <h4>카테고리</h4>
            <!-- <form id="categoryForm" action="${pageContext.request.contextPath}/results" method="get"> -->
			<form id="categoryForm" action="<c:url value='/results' />" method="get">
			    <ul class="category-list">
			        <c:forEach var="category1" items="${categories.keySet()}">
			            <li>
			                <input type="radio" name="category1" value="${category1}" ${param.category1 == category1 ? 'checked' : ''} id="res_cat1_${category1}"/>
			                <label for="res_cat1_${category1}">${category1}</label>
			                <ul class="subcategory ${param.category1 == category1 ? 'visible' : ''}">
			                    <c:forEach var="category2" items="${categories[category1].keySet()}">
			                        <li>
			                            <input type="radio" name="category2" value="${category2}" ${param.category2 == category2 ? 'checked' : ''} id="res_cat2_${category2}"/>
			                            <label for="res_cat2_${category2}">${category2}</label>
			                            <ul class="subcategory ${param.category2 == category2 ? 'visible' : ''}">
			                                <c:forEach var="category3" items="${categories[category1][category2]}">
			                                    <li>
			                                        <input type="radio" name="category3" value="${category3}" ${param.category3 == category3 ? 'checked' : ''} id="res_cat3_${category3}"/>
			                                        <label for="res_cat3_${category3}">${category3}</label>
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
			
			<script>
			document.addEventListener('DOMContentLoaded', () => {
			    const category1Inputs = document.querySelectorAll('input[name="category1"]');
			    const category2Inputs = document.querySelectorAll('input[name="category2"]');
			    const category3Inputs = document.querySelectorAll('input[name="category3"]');
			
			    category1Inputs.forEach(input => {
			        input.addEventListener('change', () => {
			            // category2 및 category3 초기화
			            category2Inputs.forEach(cat2 => {
			                if (cat2.checked) {
			                    cat2.checked = false;
			                }
			            });
			            category3Inputs.forEach(cat3 => {
			                if (cat3.checked) {
			                    cat3.checked = false;
			                }
			            });
			        });
			    });
			
			    category2Inputs.forEach(input => {
			        input.addEventListener('change', () => {
			            // category3 초기화
			            category3Inputs.forEach(cat3 => {
			                if (cat3.checked) {
			                    cat3.checked = false;
			                }
			            });
			        });
			    });
			});
			</script>
        </div>

        <!-- 메인 콘텐츠: 검색창과 추천 상품 -->
        <div class="col-md-9">
            <div class="search-bar">
                <!-- <form id="searchForm" action="${pageContext.request.contextPath}/results" method="get"> -->
                <form id="searchForm" action="<c:url value='/results' />" method="get">
                    <div class="input-group">
                        <input type="text" id="searchQuery" name="query" value="${param.query}" class="form-control" placeholder="검색어를 입력하세요">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-primary">검색</button>
                        </div>
                    </div>
                </form>
            </div>

            <!-- 추천 상품 섹션 동일하게 흰색 바탕에 카드스타일 적용 -->
            <h4>추천 상품</h4>
            <div class="row">
                <h5 class="col-12">가구/인테리어</h5>
                <c:forEach var="product" items="${interiorProducts}">
                    <div class="col-md-4 mb-4 d-flex">
                        <div class="card w-100">
                            <img src="${product.image}" class="card-img-top" alt="${product.name}">
                            <div class="card-body">
                                <h5 class="card-title">${product.name}</h5>
                                <c:choose>
                                    <c:when test="${product.brand != '알 수 없음'}">
                                        <p class="brand-or-mall">${product.brand}</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p class="brand-or-mall">${product.mallName}</p>
                                    </c:otherwise>
                                </c:choose>
                                <p class="card-text">${product.price}</p>
                                <a href="${product.link}" class="btn btn-primary mt-auto" target="_blank" rel="noopener noreferrer">구매하기</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <h5 class="col-12">식품</h5>
                <c:forEach var="product" items="${foodProducts}">
                    <div class="col-md-4 mb-4 d-flex">
                        <div class="card w-100">
                            <img src="${product.image}" class="card-img-top" alt="${product.name}">
                            <div class="card-body">
                                <h5 class="card-title">${product.name}</h5>
                                <c:choose>
                                    <c:when test="${product.brand != '알 수 없음'}">
                                        <p class="brand-or-mall">${product.brand}</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p class="brand-or-mall">${product.mallName}</p>
                                    </c:otherwise>
                                </c:choose>
                                <p class="card-text">${product.price}</p>
                                <a href="${product.link}" class="btn btn-primary mt-auto" target="_blank" rel="noopener noreferrer">구매하기</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<div id="footerWrapper" class="mt-4">
    <%@ include file="footer.jsp" %>
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
});
</script>
</body>
</html>
