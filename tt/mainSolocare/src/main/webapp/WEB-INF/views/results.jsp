<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>검색 결과</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;700&display=swap">
    <style>
.main-container {
            padding: 20px;
        }
        .category-sidebar {
            background-color: #f7f7f7;
            padding: 15px;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }
        .product-card {
            border: 1px solid #e0e0e0;
            border-radius: 10px;
            transition: transform 0.3s;
        }
        .product-card:hover {
            transform: scale(1.05);
        }
        .pagination {
            margin-top: 20px;
            display: flex;
            justify-content: center;
        }
        .pagination a, .pagination span.active {
            margin: 0 5px;
            padding: 5px 10px;
            border-radius: 5px;
        }
        .pagination .active {
            background-color: #007bff;
            color: white;
        }
    </style>
</head>
<body>

<div id="menuWrapper">
    <%@ include file="navbar.jsp" %>
</div>

<div class="container-fluid main-container">
    <div class="top-bar">
        <div class="top-bar-left">
            <span>검색 결과</span>
        </div>
        <div class="top-bar-right">
            <form id="searchForm" action="${pageContext.request.contextPath}/results" method="get" class="d-flex">
                <div class="input-group">
                    <input type="text" id="searchQuery" name="query" value="${param.query}" class="form-control" placeholder="검색...">
                    <div class="input-group-append">
                        <button type="submit" class="btn btn-primary">검색</button>
                    </div>
                </div>
            </form>
            <select id="sort" onchange="applySort()" class="ml-2">
                <option value="sim" ${param.sort == 'sim' ? 'selected' : ''}>관련도순</option>
                <option value="price_low" ${param.sort == 'price_low' ? 'selected' : ''}>가격 낮은 순</option>
                <option value="price_high" ${param.sort == 'price_high' ? 'selected' : ''}>가격 높은 순</option>
                <option value="date" ${param.sort == 'date' ? 'selected' : ''}>최신순</option>
            </select>
        </div>
    </div>

    <div class="row">
        <!-- 사이드바: 카테고리 -->
        <div class="category-sidebar col-md-3">
            <h4>카테고리</h4>
            <form id="categoryForm" action="${pageContext.request.contextPath}/results" method="get">
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
        </div>

        <!-- 메인 콘텐츠: 상품 결과 -->
        <div class="col-md-9">
            <h4>검색 결과</h4>
            <div class="row">
                <c:choose>
                    <c:when test="${not empty searchResult.products}">
                        <c:forEach var="product" items="${searchResult.products}">
                            <div class="col-md-4 mb-4 d-flex">
                                <div class="card w-100" style="border: 1px solid #e0e0e0; border-radius: 10px;">
                                    <img src="${product.image}" class="card-img-top" alt="${product.name}" style="height: 150px; object-fit: cover; border-top-left-radius: 10px; border-top-right-radius: 10px;">
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
                    </c:when>
                    <c:otherwise>
                        <p>검색 결과가 없습니다.</p>
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="pagination">
                <!-- 이전 버튼 -->
                <c:if test="${startPage > 1}">
                    <c:url var="prevPageUrl" value="results">
                        <c:param name="query" value="${query}" />
                        <c:param name="category1" value="${category1}" />
                        <c:param name="category2" value="${category2}" />
                        <c:param name="category3" value="${category3}" />
                        <c:param name="sort" value="${sort}" />
                        <c:param name="page" value="${startPage - 1}" />
                    </c:url>
                    <a href="${prevPageUrl}" class="btn btn-outline-secondary">이전</a>
                </c:if>

                <!-- 페이지 번호 -->
                <c:forEach var="pageNum" begin="${startPage}" end="${startPage + 9 > totalPages ? totalPages : startPage + 9}">
                    <c:choose>
                        <c:when test="${pageNum == currentPage}">
                            <span class="active">${pageNum}</span>
                        </c:when>
                        <c:otherwise>
                            <c:url var="pageUrl" value="results">
                                <c:param name="query" value="${query}" />
                                <c:param name="category1" value="${category1}" />
                                <c:param name="category2" value="${category2}" />
                                <c:param name="category3" value="${category3}" />
                                <c:param name="sort" value="${sort}" />
                                <c:param name="page" value="${pageNum}" />
                            </c:url>
                            <a href="${pageUrl}" class="btn btn-outline-secondary">${pageNum}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <!-- 다음 버튼 -->
                <c:if test="${endPage < totalPages}">
                    <c:url var="nextPageUrl" value="results">
                        <c:param name="query" value="${query}" />
                        <c:param name="category1" value="${category1}" />
                        <c:param name="category2" value="${category2}" />
                        <c:param name="category3" value="${category3}" />
                        <c:param name="sort" value="${sort}" />
                        <c:param name="page" value="${endPage + 1}" />
                    </c:url>
                    <a href="${nextPageUrl}" class="btn btn-outline-secondary">다음</a>
                </c:if>
            </div>
        </div>
    </div>
</div>
<div id="footerWrapper" class="mt-4">
    <%@ include file="footer.jsp" %>
</div>

<script>
function applySort() {
    const sort = document.getElementById('sort').value;
    const params = new URLSearchParams(window.location.search);
    params.set('sort', sort);
    params.set('page', '1');
    window.location.search = params.toString();
}

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
