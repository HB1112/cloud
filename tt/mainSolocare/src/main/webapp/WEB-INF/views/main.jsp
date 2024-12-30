<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="navbar.jsp" %>  <!-- 네비게이션 바 포함 -->
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Solocare - 메인 페이지</title>
    <link rel="stylesheet" href="resources/css/mainpage.css" />
    <link rel="stylesheet" href="https://unpkg.com/aos@2.3.1/dist/aos.css"> 
    <script src="https://unpkg.com/aos@2.3.1/dist/aos.js"></script> 
    <style>
		.produce {
		  padding: 80px 0;
		  background: #fff;
		}
		
		.container {
		  max-width: 1200px;
		  margin: 0 auto;
		  padding: 0 20px;
		}
		
		.section-title {
		  font-size: 2.5rem;
		  text-align: center;
		  margin-bottom: 40px;
		  opacity: 0;
		  transform: translateY(20px);
		  animation: fadeInUp 0.8s ease forwards;
		}
		
		.intro-text {
		  font-size: 1.4rem;
		  line-height: 1.8;
		  text-align: center;
		  word-break: keep-all;
		}
		
		.intro-text br {
		  display: block;
		  content: "";
		  margin: 10px 0;
		}
		
		.highlight {
		  color: #3b82f6;
		  font-weight: 600;
		}
		
		/* 각 줄에 대한 애니메이션 클래스 */
		.animate-text {
		  opacity: 0;
		  transform: translateY(20px);
		  display: inline-block;
		}
		
		.animate-text.visible {
		  animation: fadeInUp 0.8s ease forwards;
		}
		
		/* 애니메이션 키프레임 */
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
	</style>
</head>
<body>
	<!-- 메인배너 -->
	<div class="slider">
        <div class="slide active">
            <div class="overlay"></div>
            <h1 class="slogan">혼자여도 함께, 1인 가구의 새로운 시작!</h1>
        </div>
        <div class="slide">
            <div class="overlay"></div>
            <h1 class="slogan">간편한 쇼핑, 취미 동호회, 커뮤니티 소통이 한곳에!</h1>
        </div>
    </div>

	<!-- 소개글 -->
	
	<section class="produce">
	  <div class="container">
	    <h2 class="section-title">소개</h2>
	    <p class="intro-text">
	      <span class="animate-text" style="animation-delay: 0.2s">
	        <span class="highlight">솔로케어</span>는 1인 가구의 생활 편의를 높이기 위해 설계된 <span class="highlight">맞춤형 플랫폼</span>입니다.
	      </span><br>
	      <span class="animate-text" style="animation-delay: 0.4s">
	        생활 정보, 맞춤 쇼핑몰, 지원 혜택을 통합 제공하여,
	      </span><br>
	      <span class="animate-text" style="animation-delay: 0.6s">
	        1인 가구가 보다 편리하고 풍요로운 삶을 누릴 수 있도록 지원합니다.
	      </span><br>
	      <span class="animate-text" style="animation-delay: 0.8s">
	        또한, 커뮤니티 기능을 통해 사용자 간의 소통을 촉진하며,
	      </span><br>
	      <span class="animate-text" style="animation-delay: 1s">
	        정부 지원 혜택 정보를 쉽게 활용할 수 있도록 돕습니다.
	      </span>
	    </p>
	  </div>
	</section>

	<!-- 서비스 -->
     <section class="service-section">
        <div class="container"
        	 data-aos="zoom-in"
        	 data-aos-duration="1000">
            <h2 class="section-title">서비스</h2>
            <div class="service-grid">
                <!-- Card 1 -->
                <div class="service-card"
                	 data-aos="zoom-in"
        			 data-aos-duration="2000">
                    <div class="card-image-container">
                        <img src="./resources/images/room2.jpg" alt="shop" class="card-image">
                        <div class="card-overlay">
                            <div class="overlay-content">
                                <h3 class="overlay-title">쇼핑</h3>
                                <p class="overlay-description">1인 가구에 적합한 상품이나 간편식 등을 추천하여 효율적인 쇼핑을 지원합니다.</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-content">
                        <h3 class="card-title">쇼핑</h3>
                        <p class="card-description">소개그으으으을</p>
                    </div>
                </div>

                <!-- Card 2 -->
                <div class="service-card"
                	 data-aos="zoom-in"
        			 data-aos-duration="2000"	>
                    <div class="card-image-container">
                        <img src="./resources/images/room2.jpg" alt="group" class="card-image">
                        <div class="card-overlay">
                            <div class="overlay-content">
                                <h3 class="overlay-title">동호회</h3>
                                <p class="overlay-description">취미나 관심사를 기반으로 한 동호회를 통해 외로움을 줄이고 새로운 친구를 사귈 수 있는 기회를 제공합니다.</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-content">
                        <h3 class="card-title">동호회</h3>
                        <p class="card-description">소개그으으으을</p>
                    </div>
                </div>

                <!-- Card 3 -->
                <div class="service-card"
                	 data-aos="zoom-in"
        			 data-aos-duration="2000">
                    <div class="card-image-container">
                        <img src="./resources/images/room2.jpg" alt="comu" class="card-image">
                        <div class="card-overlay">
                            <div class="overlay-content">
                                <h3 class="overlay-title">커뮤니티</h3>
                                <p class="overlay-description">서로 소통하고 경험을 공유할 수 있는 온라인 커뮤니티를 제공합니다.</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-content">
                        <h3 class="card-title">커뮤니티</h3>
                        <p class="card-description">소개그으으으을</p>
                    </div>
                </div>

                <!-- Card 4 -->
                <div class="service-card"
                	 data-aos="zoom-in"
        			 data-aos-duration="2000">
                    <div class="card-image-container">
                        <img src="./resources/images/room2.jpg" alt="poli" class="card-image">
                        <div class="card-overlay">
                            <div class="overlay-content">
                                <h3 class="overlay-title">정책</h3>
                                <p class="overlay-description">1인 가구를 위한 정부 정책이나 지원 프로그램에 대한 정보를 쉽게 접근할 수 있도록 안내합니다.</p>
                            </div>
                        </div>
                    </div>
                    <div class="card-content">
                        <h3 class="card-title">정책</h3>
                        <p class="card-description">소개그으으으을</p>
                    </div>
                </div>
            </div>
        </div>
    </section>
   	 <script src="resources/js/script.js"></script>
   	 <script>
		const observerOptions = {
		  threshold: 0.5,
		  rootMargin: "0px"
		};
		
		const observer = new IntersectionObserver((entries) => {
		  entries.forEach(entry => {
		    if (entry.isIntersecting) {
		      entry.target.classList.add('visible');
		    }
		  });
		}, observerOptions);
		
		
		document.querySelectorAll('.animate-text').forEach(element => {
		  observer.observe(element);
		});
	</script>
   	 <script> AOS.init();</script>
   	 
   	<!-- 푸터 -->
	<footer class="footer">
    <div class="container">
        <p>&copy; 2024 솔로케어. 모든 권리 보유.</p>
    </div>
</footer>
</body>
</html>