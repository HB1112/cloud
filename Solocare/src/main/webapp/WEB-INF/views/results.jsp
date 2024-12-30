<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>검색 결과 | SoloCare</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://unpkg.com/aos@2.3.1/dist/aos.css" />
<style>
    * {
        box-sizing: border-box;
    }
    body {
        margin: 0;
        padding: 0;
        font-family: 'Spoqa Han Sans Neo', sans-serif;
        background-color: #fefefe;
        color: #333;
        line-height: 1.6;
        scroll-behavior: smooth;
    }

    .menu-logo {
        font-weight: 700;
        font-size: 1.5rem;
        color: #333;
        letter-spacing: -0.5px;
    }

    #heroSection {
        margin-top: 64px;
        height: 60vh; /* 메인과 동일 or 원하는 높이 */
        position: relative;
        display: flex;
        align-items: center;
        justify-content: center;
        text-align: center;
        color: #333;
    }
    .hero-content {
        max-width: 600px;
        margin: 0 auto;
    }
    .hero-content h1 {
        font-size: 2.5rem;
        font-weight: 700;
        margin-bottom: 1rem;
        color: #2c3e50;
        animation: fadeInDown 1s ease-out;
    }
    .hero-content p {
        font-size: 1.2rem;
        margin-bottom: 2rem;
        color: #34495e;
        animation: fadeInUp 1s ease-out;
    }
    .btn-hero {
        display: inline-block;
        padding: 12px 24px;
        background: #000;
        color: #fff;
        text-decoration: none;
        border-radius: 6px;
        font-size: 1rem;
        transition: background 0.3s, transform 0.3s, box-shadow 0.3s, color 0.3s;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }
    .btn-hero:hover {
        background: #333; 
        transform: translateY(-2px);
        box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
    }
    @keyframes fadeInDown {
        from { opacity: 0; transform: translateY(-20px); }
        to   { opacity: 1; transform: translateY(0); }
    }
    @keyframes fadeInUp {
        from { opacity: 0; transform: translateY(20px); }
        to   { opacity: 1; transform: translateY(0); }
    }

    #bodyWrapper {
        padding: 20px 40px;
    }

    .category-sidebar {
        position: -webkit-sticky;
        position: sticky;
        top: 80px;
        
        background: #fff;
        border: 1px solid #eee;
        border-radius: 8px;
        padding: 20px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.05);

        max-height: calc(100vh - 100px);
        overflow-y: auto;
    }
    .category-sidebar h4 {
        font-weight: 600;
        font-size: 1.1rem;
        margin-bottom: 1rem;
    }
    .category-list, .category-list ul, .category-list li {
        list-style: none; 
        margin: 0; 
        padding: 0;
    }
    .category-list input[type="radio"] {
        -webkit-appearance: none; 
        -moz-appearance: none;
        appearance: none;
        width: 0; 
        height: 0; 
        margin: 0; 
        outline: none;
    }
    .category-list input[type="radio"]:checked + label {
        font-weight: 600;
        color: #000;
    }
    .category-list label {
        cursor: pointer;
        font-size: 0.95rem;
        line-height: 1.5;
        display: block;
        padding: 4px 0;
    }
    .subcategory {
        display: none;
        margin-left: 12px;
        border-left: 1px solid #eee;
        padding-left: 10px;
    }
    .subcategory.visible {
        display: block;
    }
    .btn-category-search {
        display: block;
        width: 100%;
        background: #000;
        border: none;
        color: #fff;
        text-align: center;
        padding: 8px 0;
        border-radius: 6px;
        margin-top: 12px;
        font-size: 0.9rem;
        transition: background 0.2s;
    }
    .btn-category-search:hover {
        background: #333;
    }

    .user-search-form {
        margin-top: 24px;
        padding-top: 16px;
        border-top: 1px solid #eee;
    }
    .user-search-form .form-control {
        background: #fff;
        color: #333;
        border: 1px solid #ccc;
        border-radius: 6px;
        margin-bottom: 8px;
    }
    .btn-user-search {
        display: block;
        width: 100%;
        background: #000;
        border: none;
        color: #fff;
        text-align: center;
        padding: 8px 0;
        border-radius: 6px;
        margin-top: 8px;
        font-size: 0.9rem;
        transition: background 0.2s;
    }
    .btn-user-search:hover {
        background: #333;
    }

    .card {
        background: #fff;
        border: 1px solid #eee;
        border-radius: 8px;
        overflow: hidden;
        box-shadow: 0 2px 8px rgba(0,0,0,0.04);
        display: flex;
        flex-direction: column;
        height: 100%;
        transition: transform 0.2s, box-shadow 0.2s;
    }
    .card:hover {
        transform: translateY(-2px);
        box-shadow: 0 6px 16px rgba(0,0,0,0.08);
    }
    .card-img-top {
        width: 100%;
        height: 180px;
        object-fit: cover;
        background-color: #f8f8f8;
    }
    .card-body {
        display: flex;
        flex-direction: column;
        padding: 16px;
        flex: 1;
    }
    .card-title {
        font-size: 1rem;
        font-weight: 600;
        margin-bottom: 6px;
        color: #000;
    }
    .brand-or-mall {
        font-size: 0.85rem;
        color: #666;
        margin-bottom: 6px;
    }
    .card-text {
        font-size: 0.95rem;
        font-weight: 500;
        margin-bottom: 12px;
        color: #444;
    }
    .btn-primary {
        align-self: flex-start;
        background: #000 !important;
        border: none !important;
        color: #fff !important;
        border-radius: 6px !important;
        padding: 6px 12px !important;
        font-size: 0.9rem !important;
        transition: background 0.2s;
    }
    .btn-primary:hover {
        background: #333 !important;
    }

    .section-title {
        font-weight: 700;
        font-size: 1.5rem;
        margin: 24px 0 12px;
        letter-spacing: -0.3px;
        color: #2c3e50;
    }
    .section-subtitle {
        font-weight: 500;
        font-size: 1.1rem;
        margin: 0 0 16px;
        color: #34495e;
    }

    .pagination {
        display: flex;
        justify-content: center;
        margin-top: 20px;
        list-style: none;
        padding-left: 0;
    }
    .pagination a, .pagination span {
        margin: 0 5px;
        padding: 6px 12px;
        border: 1px solid #ccc;
        text-decoration: none;
        color: #333;
        background: #fff;
        border-radius: 6px;
        font-size: 0.9rem;
    }
    .pagination a:hover {
        background: #eee;
    }
    .pagination .active {
        background-color: #000;
        color: #fff;
        border-color: #000;
    }

    @media (max-width: 768px) {
        #menuWrapper {
            padding: 0 20px;
            height: 56px;
        }
        #heroSection {
            height: 40vh; 
        }
        .hero-content h1 {
            font-size: 2rem;
        }
        .hero-content p {
            font-size: 1rem;
        }
    }
</style>
</head>
<body>

<!-- [상단 메뉴] -->
<div>
    <%@ include file="navbar.jsp" %>
</div>

<!-- [본문] -->
<div id="bodyWrapper">
    <div class="container-fluid main-container">
        <div class="row">
            <!-- [왼쪽 사이드바] 카테고리 & 사용자 검색 -->
            <div class="col-md-3 col-lg-2">
                <div class="category-sidebar" data-aos="fade-right">
                    <h4>카테고리</h4>
                    <form id="categoryForm" action="<c:url value='/results' />" method="get">
                        <ul class="category-list">
                            <c:forEach var="category1" items="${categories.keySet()}">
                                <li>
                                    <input type="radio" name="category1" value="${category1}"
                                           ${param.category1 == category1 ? 'checked' : ''}
                                           id="res_cat1_${category1}" />
                                    <label for="res_cat1_${category1}">${category1}</label>

                                    <ul class="subcategory ${param.category1 == category1 ? 'visible' : ''}">
                                        <c:forEach var="category2" items="${categories[category1].keySet()}">
                                            <li>
                                                <input type="radio" name="category2" value="${category2}"
                                                       ${param.category2 == category2 ? 'checked' : ''}
                                                       id="res_cat2_${category2}" />
                                                <label for="res_cat2_${category2}">${category2}</label>

                                                <ul class="subcategory ${param.category2 == category2 ? 'visible' : ''}">
                                                    <c:forEach var="category3" items="${categories[category1][category2]}">
                                                        <li>
                                                            <input type="radio" name="category3" value="${category3}"
                                                                   ${param.category3 == category3 ? 'checked' : ''}
                                                                   id="res_cat3_${category3}" />
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
                        <button type="submit" class="btn-category-search mt-3">카테고리 검색</button>
                    </form>

                    <!-- 사용자 검색 (메인과 동일) -->
                    <div class="user-search-form">
                        <form id="searchForm" action="<c:url value='/results' />" method="get">
                            <input type="text" 
                                   class="form-control" 
                                   id="queryInput"
                                   name="query" value="${param.query}"
                                   placeholder="검색어를 입력하세요">

                            <select id="sort" name="sort" class="form-control" onchange="applySort()">
                                <option value="sim"        ${param.sort == 'sim'        ? 'selected' : ''}>관련도순</option>
                                <option value="price_low"  ${param.sort == 'price_low'  ? 'selected' : ''}>가격 낮은 순</option>
                                <option value="price_high" ${param.sort == 'price_high' ? 'selected' : ''}>가격 높은 순</option>
                                <option value="date"       ${param.sort == 'date'       ? 'selected' : ''}>최신순</option>
                            </select>

                            <button type="submit" class="btn-user-search">검색</button>
                        </form>
                    </div>
                </div><!-- category-sidebar end -->
            </div><!-- col-md-3 end -->

            <!-- [오른쪽: 검색 결과 상품 목록] -->
            <div class="col-md-9 col-lg-10" data-aos="fade-up">
                <h2 class="section-title">검색 결과</h2>
                <h3 class="section-subtitle"></h3>

                <div class="row">
                    <c:choose>
                        <c:when test="${not empty searchResult.products}">
                            <c:forEach var="product" items="${searchResult.products}">
                                <div class="col-sm-6 col-md-4 col-lg-3 mb-4 d-flex" data-aos="fade-up">
                                    <div class="card w-100">
                                        <img src="${product.image}" class="card-img-top" alt="${product.name}">
                                        <div class="card-body">
                                            <!-- brand / mallName -->
                                            <c:choose>
                                                <c:when test="${product.brand != null && product.brand != '알 수 없음'}">
                                                    <p class="brand-or-mall">${product.brand}</p>
                                                </c:when>
                                                <c:otherwise>
                                                    <p class="brand-or-mall">${product.mallName}</p>
                                                </c:otherwise>
                                            </c:choose>
                                            <h5 class="card-title">${product.name}</h5>
                                            <p class="card-text">${product.price}</p>
                                            <a href="${product.link}" class="btn btn-primary mt-auto" 
                                               target="_blank" rel="noopener noreferrer">
                                                구매하기
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <p>검색 결과가 없습니다.</p>
                        </c:otherwise>
                    </c:choose>
                </div><!-- row end -->

                <!-- 페이지네이션 (메인과 동일) -->
                <div class="pagination">
                    <!-- 이전 버튼 -->
                    <c:if test="${startPage > 1}">
                        <c:url var="prevPageUrl" value="/results">
                            <c:param name="query" value="${query}" />
                            <c:param name="category1" value="${category1}" />
                            <c:param name="category2" value="${category2}" />
                            <c:param name="category3" value="${category3}" />
                            <c:param name="sort" value="${sort}" />
                            <c:param name="page" value="${startPage - 1}" />
                        </c:url>
                        <a href="${prevPageUrl}">이전</a>
                    </c:if>

                    <!-- 페이지 번호 -->
                    <c:forEach var="pageNum" begin="${startPage}" 
                              end="${startPage + 9 > totalPages ? totalPages : startPage + 9}">
                        <c:choose>
                            <c:when test="${pageNum == currentPage}">
                                <span class="active">${pageNum}</span>
                            </c:when>
                            <c:otherwise>
                                <c:url var="pageUrl" value="/results">
                                    <c:param name="query" value="${query}" />
                                    <c:param name="category1" value="${category1}" />
                                    <c:param name="category2" value="${category2}" />
                                    <c:param name="category3" value="${category3}" />
                                    <c:param name="sort" value="${sort}" />
                                    <c:param name="page" value="${pageNum}" />
                                </c:url>
                                <a href="${pageUrl}">${pageNum}</a>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <!-- 다음 버튼 -->
                    <c:if test="${endPage < totalPages}">
                        <c:url var="nextPageUrl" value="/results">
                            <c:param name="query" value="${query}" />
                            <c:param name="category1" value="${category1}" />
                            <c:param name="category2" value="${category2}" />
                            <c:param name="category3" value="${category3}" />
                            <c:param name="sort" value="${sort}" />
                            <c:param name="page" value="${endPage + 1}" />
                        </c:url>
                        <a href="${nextPageUrl}">다음</a>
                    </c:if>
                </div><!-- pagination end -->
            </div><!-- col-md-9 end -->
        </div><!-- row end -->
    </div><!-- container-fluid end -->
</div><!-- bodyWrapper end -->

<!-- 푸터 -->


<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<script>
  document.addEventListener('DOMContentLoaded', function() {
    AOS.init({
      duration: 800,
      easing: 'ease-in-out',
      once: true,
    });
  });

  function applySort() {
    const sortSelect = document.getElementById('sort');
    const sortValue = sortSelect.value;
    const params = new URLSearchParams(window.location.search);
    params.set('sort', sortValue);
    params.set('page', '1'); // 정렬 바꾸면 page=1
    window.location.search = params.toString();
  }

  /* 카테고리 라디오 다시 클릭시 해제, 하위 토글 (메인 동일) */
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
        } else if (subcategory) {
            subcategory.classList.remove('visible');
        }

        // 다른 부분 숨기기
        document.querySelectorAll('.category-list .subcategory').forEach(sub => {
            const parent = sub.closest('li');
            if (sub !== subcategory && !parent.contains(input)) {
                sub.classList.remove('visible');
            }
        });

        // 하위 레벨 자동 열기
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
