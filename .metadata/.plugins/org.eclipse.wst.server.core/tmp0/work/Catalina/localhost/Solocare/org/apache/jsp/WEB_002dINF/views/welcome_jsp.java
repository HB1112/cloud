/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-19 00:40:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class welcome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/footer.jsp", Long.valueOf(1733214436000L));
    _jspx_dependants.put("/WEB-INF/views/menu.jsp", Long.valueOf(1734507750087L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>솔로케어(SoloCare)</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Noto+Sans:wght@400;500;700&family=Noto+Serif:wght@400;700&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\" rel=\"stylesheet\">\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("   <style>\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: 'Noto Sans', sans-serif;\r\n");
      out.write("        }\r\n");
      out.write("        .navbar {\r\n");
      out.write("            background-color: white; \r\n");
      out.write("            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);\r\n");
      out.write("        }\r\n");
      out.write("        .navbar-brand {\r\n");
      out.write("            font-family: 'Noto Serif', serif;\r\n");
      out.write("            font-size: 1.8rem;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            color: #005B96;\r\n");
      out.write("            transition: transform 0.3s ease;\r\n");
      out.write("        }\r\n");
      out.write("        .navbar-brand:hover {\r\n");
      out.write("            transform: scale(1.1);\r\n");
      out.write("        }\r\n");
      out.write("        .navbar-nav .nav-link {\r\n");
      out.write("            margin: 0 15px;\r\n");
      out.write("            color: #005B96; \r\n");
      out.write("            font-weight: 500;\r\n");
      out.write("            transition: all 0.3s ease;\r\n");
      out.write("        }\r\n");
      out.write("        .navbar-nav .nav-link:hover {\r\n");
      out.write("            color: #FFD700; \r\n");
      out.write("            transform: translateY(-3px);\r\n");
      out.write("        }\r\n");
      out.write("        .dropdown-menu {\r\n");
      out.write("            background: #f8f9fa; \r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\r\n");
      out.write("        }\r\n");
      out.write("        .dropdown-item {\r\n");
      out.write("            color: #005B96; \r\n");
      out.write("            font-weight: 500;\r\n");
      out.write("        }\r\n");
      out.write("        .dropdown-item:hover {\r\n");
      out.write("            background: #005B96; \r\n");
      out.write("            color: white; \r\n");
      out.write("        }\r\n");
      out.write("        .search {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            margin-left: auto; /* 오른쪽 끝으로 붙이기 */\r\n");
      out.write("        }\r\n");
      out.write("        .search input {\r\n");
      out.write("            border-radius: 30px;\r\n");
      out.write("            border: 2px solid #005B96; \r\n");
      out.write("            margin-right: 10px; /* 검색창과 버튼 사이 간격 */\r\n");
      out.write("        }\r\n");
      out.write("        .search button {\r\n");
      out.write("            color: white;\r\n");
      out.write("            background: #005B96; \r\n");
      out.write("            border-radius: 50%;\r\n");
      out.write("            border: none;\r\n");
      out.write("            padding: 5px 10px;\r\n");
      out.write("        }\r\n");
      out.write("        .user-links {\r\n");
      out.write("        	display : flex;\r\n");
      out.write("            margin-left: 20px; /* 로그인/회원가입 간격 */\r\n");
      out.write("        }\r\n");
      out.write("        .main-content {\r\n");
      out.write("            margin-top: 80px; /* 내비게이션 바 높이에 맞춰 여백 추가 */\r\n");
      out.write("        }\r\n");
      out.write("        .navbar-collapse {\r\n");
      out.write("		    display: flex;\r\n");
      out.write("		    justify-content: space-between; /* 양쪽 끝으로 배치 */\r\n");
      out.write("		    width: 100%; /* 전체 너비 사용 */\r\n");
      out.write("		}\r\n");
      out.write("    </style>\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light fixed-top\" style=\"font-family: 'Montserrat', sans-serif;\">\r\n");
      out.write("    <a class=\"navbar-brand\" href=\"/Solocare/home\">Solo Care</a>\r\n");
      out.write("    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("    </button>\r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n");
      out.write("        <ul class=\"navbar-nav\">\r\n");
      out.write("            <li class=\"nav-item dropdown\">\r\n");
      out.write("                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"shoppingDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                    쇼핑 \r\n");
      out.write("                </a>\r\n");
      out.write("                <div class=\"dropdown-menu\" aria-labelledby=\"shoppingDropdown\">\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"search\">1인 가구 맞춤 가전 제품</a>\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">1인 가구 맞춤 식자재</a>\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">보안 제품 추천</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item dropdown\">\r\n");
      out.write("                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"homeCareDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                    커뮤니티 \r\n");
      out.write("                </a>\r\n");
      out.write("                <div class=\"dropdown-menu\" aria-labelledby=\"homeCareDropdown\">\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"board?category=tip&page=1\">정보 공유 (집 꾸미기, 생활 팁)</a>\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"tradeboard\">중고거래</a>\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"club/board\">동호회</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item dropdown\">\r\n");
      out.write("                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"safetyHealthDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                    건강 케어 \r\n");
      out.write("                </a>\r\n");
      out.write("                <div class=\"dropdown-menu\" aria-labelledby=\"safetyHealthDropdown\">\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">간단한 홈트레이닝 영상 제공</a>\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">건강 데이터 통합 관리</a>\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">집 주변 약국 운영시간, 야간운영? 정보</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item dropdown\">\r\n");
      out.write("                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"policyDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                    정책 지원 \r\n");
      out.write("                </a>\r\n");
      out.write("                <div class=\"dropdown-menu\" aria-labelledby=\"policyDropdown\">\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">사회성 증진 프로그램</a>\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">지원 혜택</a>\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">응급 대처 가이드</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item dropdown\">\r\n");
      out.write("                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"serviceDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                    편의 서비스 \r\n");
      out.write("                </a>\r\n");
      out.write("                <div class=\"dropdown-menu\" aria-labelledby=\"serviceDropdown\">\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">정기 구독 식품, 청소, 심부름</a>\r\n");
      out.write("                    <a class=\"dropdown-item\" href=\"#\">안심 귀가 루트 추천</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("        ");

            if (request.getSession().getAttribute("mem") != null) {
        
      out.write("\r\n");
      out.write("            <div class=\"user-links\">\r\n");
      out.write("                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mem.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("님 환영합니다</p>\r\n");
      out.write("                <a href=\"infocheck\" class=\"nav-link\">내 정보</a>\r\n");
      out.write("                <a href=\"logout\" class=\"nav-link\">로그아웃</a>\r\n");
      out.write("                <a href=\"list\" class=\"nav-link\">일정관리</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        ");

            } else {
        
      out.write("\r\n");
      out.write("            <div class=\"user-links\">\r\n");
      out.write("                <a href=\"/Solocare/login\" class=\"nav-link\">로그인</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        ");

            }
        
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- 메인 콘텐츠 -->\r\n");
      out.write("<div class=\"main-content\">\r\n");
      out.write("    <div>\r\n");
      out.write("        <h1>솔로 라이프의 모든 것</h1>\r\n");
      out.write("        <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/login\">솔로케어 시작하기</a> <!-- 로그인 폼으로 연결 -->\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <h5>쇼핑</h5>\r\n");
      out.write("            <p>1인가구 맞춤 제품(냉장고, 가전 등) 및 식자재 정보.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <h5>커뮤니티</h5>\r\n");
      out.write("            <p>정보 공유, 공동구매 및 동호회 관리.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <h5>건강 케어</h5>\r\n");
      out.write("            <p>홈트레이닝 영상 및 건강 데이터 관리.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <h5>정책 지원</h5>\r\n");
      out.write("            <p>사회성 증진 프로그램 및 지원 혜택 정보.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <h5>편의 서비스</h5>\r\n");
      out.write("            <p>정기 구독 서비스 및 루트 추천.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("    <!-- 푸터 -->\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<link href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("<footer class=\"bg-light text-dark pt-3 pb-3\">\r\n");
      out.write("    <div class=\"container text-center\">\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("            <div class=\"col-md-4\">\r\n");
      out.write("                <h5 style=\"font-family: 'Montserrat', sans-serif; font-size: 1.2rem;\">솔로케어 소개</h5>\r\n");
      out.write("                <p style=\"font-size: 0.9rem;\">솔로케어는 1인 가구를 위한 다양한 정보와 서비스를 제공합니다.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-4\">\r\n");
      out.write("                <h5 style=\"font-family: 'Montserrat', sans-serif; font-size: 1.2rem;\">연락처</h5>\r\n");
      out.write("                <p style=\"font-size: 0.9rem;\">이메일: support@solocare.com</p>\r\n");
      out.write("                <p style=\"font-size: 0.9rem;\">전화: 123-456-7890</p>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-md-4\">\r\n");
      out.write("                <h5 style=\"font-family: 'Montserrat', sans-serif; font-size: 1.2rem;\">소셜 미디어</h5>\r\n");
      out.write("                <a href=\"#\" class=\"text-dark\" style=\"font-size: 0.9rem;\"><i class=\"fab fa-facebook-f\"></i> 페이스북</a><br>\r\n");
      out.write("                <a href=\"#\" class=\"text-dark\" style=\"font-size: 0.9rem;\"><i class=\"fab fa-twitter\"></i> 트위터</a><br>\r\n");
      out.write("                <a href=\"#\" class=\"text-dark\" style=\"font-size: 0.9rem;\"><i class=\"fab fa-instagram\"></i> 인스타그램</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <hr class=\"my-3\">\r\n");
      out.write("        <p style=\"font-size: 0.8rem;\">© 2024 솔로케어. 모든 권리 보유.</p>\r\n");
      out.write("    </div>\r\n");
      out.write("</footer>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("        // 드롭다운 메뉴 토글 기능\r\n");
      out.write("        document.getElementById('shoppingDropdown').onclick = function() {\r\n");
      out.write("            var dropdown = document.getElementById('dropdownMenu');\r\n");
      out.write("            dropdown.style.display = dropdown.style.display === 'none' || dropdown.style.display === '' ? 'block' : 'none';\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        document.getElementById('communityDropdown').onclick = function() {\r\n");
      out.write("            var communityDropdown = document.getElementById('communityMenu');\r\n");
      out.write("            communityDropdown.style.display = communityDropdown.style.display === 'none' || communityDropdown.style.display === '' ? 'block' : 'none';\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        document.getElementById('healthDropdown').onclick = function() {\r\n");
      out.write("            var healthDropdown = document.getElementById('healthMenu');\r\n");
      out.write("            healthDropdown.style.display = healthDropdown.style.display === 'none' || healthDropdown.style.display === '' ? 'block' : 'none';\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        document.getElementById('policyDropdown').onclick = function() {\r\n");
      out.write("            var policyDropdown = document.getElementById('policyMenu');\r\n");
      out.write("            policyDropdown.style.display = policyDropdown.style.display === 'none' || policyDropdown.style.display === '' ? 'block' : 'none';\r\n");
      out.write("        };\r\n");
      out.write("\r\n");
      out.write("        document.getElementById('serviceDropdown').onclick = function() {\r\n");
      out.write("            var serviceDropdown = document.getElementById('serviceMenu');\r\n");
      out.write("            serviceDropdown.style.display = serviceDropdown.style.display === 'none' || serviceDropdown.style.display === '' ? 'block' : 'none';\r\n");
      out.write("        };\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
