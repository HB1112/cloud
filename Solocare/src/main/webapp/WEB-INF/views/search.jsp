<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SoloCare</title>
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
            scroll-behavior: smooth;
            line-height: 1.6;
        }

        .menu-logo {
            font-weight: 700;
            font-size: 1.5rem;
            color: #333;
            letter-spacing: -0.5px;
        }
        .menu-links a {
            color: #333;
            margin-left: 20px;
            text-decoration: none;
            font-size: 0.95rem;
            transition: color 0.2s;
        }
        .menu-links a:hover {
            color: #000;
        }

  
        #heroSection {
            height: 80vh; 
            position: relative; 
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
            color: #333;
            overflow: hidden; 
        }

        #heroSection::before {
            content: "";
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-image: url('${pageContext.request.contextPath}/resources/images/shop.jpg');
            background-size: cover; 
            background-position: center; 
            opacity: 0.5;
            z-index: -1; 
        }

        .hero-content {
            max-width: 600px;
            margin: 0 auto;
            position: relative; 
            z-index: 1; 
        }

        .hero-content h1 {
            font-size: 3rem;
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
		.btn-hero,
		.btn-hero:focus,
		.btn-hero:active,
		.btn-hero:hover,
		.btn-hero:visited {
		    display: inline-block;
		    padding: 12px 24px;
		    background: #D3D3D3;
		    color: #000000; 
		    text-decoration: none;
		    border-radius: 6px;
		    font-size: 1rem;
		    transition: background 0.3s, transform 0.3s, box-shadow 0.3s, color 0.3s;
		    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
		}
		
		.btn-hero:hover {
		    background: #E0E0E0; 
		    color: #000000; /
		    transform: translateY(-2px);
		    box-shadow: 0 6px 12px rgba(0, 0, 0, 0.2);
		}

        @keyframes fadeInDown {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes fadeInUp {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
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
            appearance: none;
            width: 0; height: 0;
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
        .btn-category-search,
        .btn-user-search {
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
        .btn-category-search:hover, .btn-user-search:hover {
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

        .card-grid {
            margin-left: 0; 
            margin-right: 0; 
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
        .card-brand {
            font-size: 0.85rem;
            color: #666;
            margin-bottom: 4px;
        }
        .card-product-name {
            font-size: 1rem;
            font-weight: 600;
            margin-bottom: 6px;
            color: #000;
        }
        .card-price {
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
            font-weight: 700; /* 폰트 두께 증가 */
            font-size: 1.5rem; /* 폰트 크기 증가 */
            margin: 24px 0 12px;
            letter-spacing: -0.3px;
            color: #2c3e50; /* 색상 변경 */
        }
        .section-subtitle {
            font-weight: 500;
            font-size: 1.1rem; /* 폰트 크기 증가 */
            margin: 0 0 16px;
            color: #34495e; /* 색상 변경 */
        }

        /* 반응형 디자인 */
        @media (max-width: 768px) {
            #menuWrapper {
                padding: 0 20px;
                height: 56px;
            }

            #heroSection {
                height: 60vh;
            }

            .hero-content h1 {
                font-size: 2.5rem;
            }

            .hero-content p {
                font-size: 1rem;
            }

            .btn-hero {
                padding: 10px 20px;
                font-size: 0.9rem;
            }

            .category-sidebar {
                padding: 15px;
            }

            .section-title {
                font-size: 1.3rem;
            }

            .section-subtitle {
                font-size: 1rem;
            }
        }
    </style>
</head>

<body>

<div>
    <%@ include file = "navbar.jsp" %>
</div>

<div id="heroSection">
    <div class="hero-content" data-aos="fade-up">
        <a href="#bodyWrapper" class="btn-hero">살펴보기</a>
    </div>
</div>

<!-- 본문 -->
<div id="bodyWrapper">
    <div class="container-fluid main-container">
        <div class="row">
            <!-- 왼쪽: 사이드바 (sticky) -->
            <div class="col-md-3 col-lg-2">
                <div class="category-sidebar" data-aos="fade-right">
                    <h4>카테고리</h4>
                    <!-- 카테고리 폼 -->
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

                        <button type="submit" class="btn-category-search">카테고리 검색</button>
                    </form>

                    <!-- 사용자 검색 -->
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

            <!-- 오른쪽: 상품 목록 -->
            <div class="col-md-9 col-lg-10" data-aos="fade-up">
                <h2 class="section-title">추천 상품</h2>
                <h3 class="section-subtitle">가구/인테리어</h3>

                <div class="row card-grid">
                    <c:forEach var="product" items="${interiorProducts}">
                        <div class="col-sm-6 col-md-4 col-lg-3 mb-4 d-flex" data-aos="fade-up">
                            <div class="card w-100">
                                <img src="${product.image}" class="card-img-top" alt="${product.name}">
                                <div class="card-body">
                                    <c:choose>
                                        <c:when test="${product.brand != null && product.brand != '알 수 없음'}">
                                            <p class="card-brand">${product.brand}</p>
                                        </c:when>
                                        <c:otherwise>
                                            <p class="card-brand">${product.mallName}</p>
                                        </c:otherwise>
                                    </c:choose>
                                    <p class="card-product-name">${product.name}</p>
                                    <p class="card-price">${product.price}</p>
                                    <a href="${product.link}" class="btn btn-primary mt-auto" target="_blank">
                                        구매하기
                                    </a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

                <h3 class="section-subtitle">식품</h3>
                <div class="row card-grid">
                    <c:forEach var="product" items="${foodProducts}">
                        <div class="col-sm-6 col-md-4 col-lg-3 mb-4 d-flex" data-aos="fade-up">
                            <div class="card w-100">
                                <img src="${product.image}" class="card-img-top" alt="${product.name}">
                                <div class="card-body">
                                    <c:choose>
                                        <c:when test="${product.brand != null && product.brand != '알 수 없음'}">
                                            <p class="card-brand">${product.brand}</p>
                                        </c:when>
                                        <c:otherwise>
                                            <p class="card-brand">${product.mallName}</p>
                                        </c:otherwise>
                                    </c:choose>
                                    <p class="card-product-name">${product.name}</p>
                                    <p class="card-price">${product.price}</p>
                                    <a href="${product.link}" class="btn btn-primary mt-auto" target="_blank">
                                        구매하기
                                    </a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div><!-- col-md-9 end -->
        </div><!-- row end -->
    </div><!-- container-fluid end -->
</div><!-- bodyWrapper end -->

<!-- 푸터 -->
<footer class="mt-4">
    <%@ include file="footer.jsp" %>
</footer>

<!-- AOS 라이브러리 JS -->
<script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script>
<!-- AOS 초기화 -->
<script>
  document.addEventListener('DOMContentLoaded', function() {
    AOS.init({
      duration: 800, 
      easing: 'ease-in-out',
      once: true,
    });
  });

  function applySort() {
    document.getElementById('searchForm').submit();
  }

  /* 카테고리 라디오 다시 클릭 시 해제 & 하위 토글 */
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
