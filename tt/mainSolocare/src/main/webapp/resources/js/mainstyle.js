   // 스크롤 시 네비게이션 바 고정 처리
    window.onscroll = function() {fixNav()};

    var navbar = document.querySelector('.navbar');
    var sticky = navbar.offsetTop;

    function fixNav() {
        if (window.pageYOffset >= sticky) {
            navbar.classList.add("fixed-nav");
        } else {
            navbar.classList.remove("fixed-nav");
        }
    }

    // 로고 클릭 시 메인 페이지로 이동
    document.getElementById('logo').addEventListener('click', function() {
        window.location.href = 'home';  // 메인 페이지 경로
    });
    
    const slides = document.querySelectorAll('.slide');
    let currentSlide = 0;

    function showNextSlide() {
      slides[currentSlide].style.transform = 'translateX(-100%)';
      currentSlide = (currentSlide + 1) % slides.length;
      slides[currentSlide].style.transform = 'translateX(0)';
    }

    setInterval(showNextSlide, 3000); // 3초마다 전환