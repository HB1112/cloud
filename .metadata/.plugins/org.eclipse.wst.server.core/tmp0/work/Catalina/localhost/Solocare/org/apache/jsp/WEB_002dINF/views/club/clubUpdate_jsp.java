/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-30 07:28:51 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.club;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class clubUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/navbar.jsp", Long.valueOf(1735529449647L));
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>동호회 정보 수정</title>\r\n");
      out.write("<style>\r\n");
      out.write("        /* CSS 코드 여기 삽입 */\r\n");
      out.write("        body {\r\n");
      out.write("            background-color: #f8f9fa; /* 배경 색상 */\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            font-family: 'Noto Sans', sans-serif; /* 폰트 설정 */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        h2 {\r\n");
      out.write("            text-align: center; /* 중앙 정렬 */\r\n");
      out.write("            margin: 20px 0; /* 여백 */\r\n");
      out.write("            color: #333; /* 색상 */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        form {\r\n");
      out.write("            max-width: 600px; /* 최대 너비 설정 */\r\n");
      out.write("            margin: 30px auto; /* 중앙 정렬 */\r\n");
      out.write("            padding: 20px; /* 패딩 */\r\n");
      out.write("            background-color: white; /* 배경 색상 */\r\n");
      out.write("            border-radius: 8px; /* 모서리 둥글게 */\r\n");
      out.write("            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 그림자 효과 */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        label {\r\n");
      out.write("            display: block; /* 라벨을 블록으로 설정 */\r\n");
      out.write("            margin-bottom: 5px; /* 아래쪽 여백 */\r\n");
      out.write("            font-weight: bold; /* 글씨 굵게 */\r\n");
      out.write("            color: #555; /* 글씨 색상 */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"text\"],\r\n");
      out.write("        textarea {\r\n");
      out.write("            width: 100%; /* 너비 100% */\r\n");
      out.write("            padding: 10px; /* 패딩 */\r\n");
      out.write("            border: 1px solid #ccc; /* 테두리 */\r\n");
      out.write("            border-radius: 4px; /* 모서리 둥글게 */\r\n");
      out.write("            box-sizing: border-box; /* 박스 사이징 */\r\n");
      out.write("            margin-bottom: 15px; /* 아래쪽 여백 */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"submit\"] {\r\n");
      out.write("            padding: 10px 15px; /* 버튼 패딩 */\r\n");
      out.write("            border: none; /* 테두리 없음 */\r\n");
      out.write("            border-radius: 4px; /* 모서리 둥글게 */\r\n");
      out.write("            cursor: pointer; /* 커서 포인터 */\r\n");
      out.write("            font-size: 16px; /* 글씨 크기 */\r\n");
      out.write("            transition: background-color 0.3s ease; /* 배경색 변화 효과 */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"submit\"]:nth-of-type(1) {\r\n");
      out.write("            background-color: #007bff; /* 수정 완료 버튼 색상 */\r\n");
      out.write("            color: white; /* 글씨 색상 */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"submit\"]:nth-of-type(2) {\r\n");
      out.write("            background-color: #dc3545; /* 삭제 버튼 색상 */\r\n");
      out.write("            color: white; /* 글씨 색상 */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"submit\"]:nth-of-type(1):hover {\r\n");
      out.write("            background-color: #0056b3; /* 수정 버튼 호버 색상 */\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        input[type=\"submit\"]:nth-of-type(2):hover {\r\n");
      out.write("            background-color: #c82333; /* 삭제 버튼 호버 색상 */\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<title>솔로케어</title>\r\n");
      out.write("\r\n");
      out.write("<!-- 폰트 추가 -->\r\n");
      out.write("<link rel=\"stylesheet\" as=\"style\" crossorigin href=\"https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css\" />\r\n");
      out.write("<link href=\"https://webfontworld.github.io/gmarket/GmarketSans.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("	:root {\r\n");
      out.write("	  --font-pretendard: 'Pretendard', -apple-system, BlinkMacSystemFont, system-ui, Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo', 'Noto Sans KR', 'Malgun Gothic', sans-serif;\r\n");
      out.write("	  --font-gmarket: 'GmarketSans', sans-serif;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	body {\r\n");
      out.write("	  margin: 0;\r\n");
      out.write("	  font-family: var(--font-pretendard);\r\n");
      out.write("	  letter-spacing: -0.01em;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav {\r\n");
      out.write("	  background-color: #fff;\r\n");
      out.write("	  padding: 17px 19px;\r\n");
      out.write("	  display: flex;\r\n");
      out.write("	  align-items: center;\r\n");
      out.write("	  justify-content: center; \r\n");
      out.write("	  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);\r\n");
      out.write("	  position: sticky;\r\n");
      out.write("	  top: 0;\r\n");
      out.write("	  z-index: 1000;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .logo {\r\n");
      out.write("	  margin-right: auto;\r\n");
      out.write("	  font-family: var(--font-gmarket);\r\n");
      out.write("	  font-weight: bold;\r\n");
      out.write("	  font-size: 35px;\r\n");
      out.write("	  letter-spacing: -0.02em;\r\n");
      out.write("	  position: absolute;\r\n");
      out.write("	  left: 20px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .logo a {\r\n");
      out.write("	  text-decoration: none;\r\n");
      out.write("	  color: #3b82f6;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu {\r\n");
      out.write("	  display: flex;\r\n");
      out.write("	  gap: 50px;\r\n");
      out.write("	  align-items: center;\r\n");
      out.write("	  justify-content: center;\r\n");
      out.write("	  font-size: 20px;\r\n");
      out.write("	  flex-grow: 1;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu a {\r\n");
      out.write("	  text-decoration: none;\r\n");
      out.write("	  color: #000;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item {\r\n");
      out.write("	  position: relative;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item > a {\r\n");
      out.write("	  text-decoration: none;\r\n");
      out.write("	  color: #333;\r\n");
      out.write("	  font-size: 20px;\r\n");
      out.write("	  font-weight: 500;\r\n");
      out.write("	  padding: 8px 16px;\r\n");
      out.write("	  display: block;\r\n");
      out.write("	  transition: color 0.2s ease;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item > a:hover {\r\n");
      out.write("	  color: #3b82f6;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item .dropdown {\r\n");
      out.write("	  position: absolute;\r\n");
      out.write("	  top: 100%;\r\n");
      out.write("	  left: 50%;\r\n");
      out.write("	  transform: translateX(-50%);\r\n");
      out.write("	  background-color: #fff;\r\n");
      out.write("	  box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);\r\n");
      out.write("	  border: 1px solid #eee;\r\n");
      out.write("	  border-radius: 8px;\r\n");
      out.write("	  z-index: 1000;\r\n");
      out.write("	  padding: 8px 0;\r\n");
      out.write("	  min-width: 200px;\r\n");
      out.write("	  visibility: hidden;\r\n");
      out.write("	  opacity: 0;\r\n");
      out.write("	  transition: all 0.2s ease;\r\n");
      out.write("	  display: flex;\r\n");
      out.write("	  flex-direction: column;\r\n");
      out.write("	  white-space: nowrap;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item .dropdown a {\r\n");
      out.write("	  padding: 12px 20px;\r\n");
      out.write("	  color: #333;\r\n");
      out.write("	  text-decoration: none;\r\n");
      out.write("	  font-size: 14px;\r\n");
      out.write("	  line-height: 1.5;\r\n");
      out.write("	  transition: all 0.2s ease;\r\n");
      out.write("	  display: block;\r\n");
      out.write("	  width: 100%;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item .dropdown a span {\r\n");
      out.write("	  display: block;\r\n");
      out.write("	  font-size: 12px;\r\n");
      out.write("	  color: #777;\r\n");
      out.write("	  margin-top: 4px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item .dropdown a:hover {\r\n");
      out.write("	  background-color: #f8f9fa;\r\n");
      out.write("	  color: #3b82f6;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item:hover .dropdown {\r\n");
      out.write("	  visibility: visible;\r\n");
      out.write("	  opacity: 1;\r\n");
      out.write("	  transform: translateX(-50%) translateY(0);\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item .submenu {\r\n");
      out.write("	  position: relative; \r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item .submenu .dropdown {\r\n");
      out.write("	  position: absolute;\r\n");
      out.write("	  top: 0; \r\n");
      out.write("	  left: 140%; /* 오른쪽으로 이동시키기 위해 값을 증가시킴 */\r\n");
      out.write("	  transform: translateX(0); \r\n");
      out.write("	  visibility: hidden; \r\n");
      out.write("	  opacity: 0; \r\n");
      out.write("	  transition: all 0.2s ease;\r\n");
      out.write("	  background-color: #fff;\r\n");
      out.write("	  box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1);\r\n");
      out.write("	  border: 1px solid #eee;\r\n");
      out.write("	  border-radius: 8px;\r\n");
      out.write("	  z-index: 1000;\r\n");
      out.write("	  padding: 8px 0;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item .submenu .dropdown a {\r\n");
      out.write("	  padding: 12px 20px;\r\n");
      out.write("	  color: #333;\r\n");
      out.write("	  text-decoration: none;\r\n");
      out.write("	  font-size: 14px;\r\n");
      out.write("	  line-height: 1.5;\r\n");
      out.write("	  transition: all 0.2s ease;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item .submenu:hover .dropdown {\r\n");
      out.write("	  visibility: visible;\r\n");
      out.write("	  opacity: 1;\r\n");
      out.write("	  transform: translateX(0);\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item .submenu-item a {\r\n");
      out.write("	  margin-right: 10px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	@keyframes fadeInDown {\r\n");
      out.write("	  from {\r\n");
      out.write("	    opacity: 0;\r\n");
      out.write("	    transform: translateX(-50%) translateY(-10px);\r\n");
      out.write("	  }\r\n");
      out.write("	  to {\r\n");
      out.write("	    opacity: 1;\r\n");
      out.write("	    transform: translateX(-50%) translateY(0);\r\n");
      out.write("	  }\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item:hover .dropdown {\r\n");
      out.write("	  animation: fadeInDown 0.2s ease forwards;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.nav .menu-item .dropdown a:not(:last-child) {\r\n");
      out.write("	  border-bottom: 1px solid #f0f0f0;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.user-actions {\r\n");
      out.write("	  display: flex;\r\n");
      out.write("	  align-items: center;\r\n");
      out.write("	  position: absolute;\r\n");
      out.write("	  right: 20px;\r\n");
      out.write("	  gap: 15px;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.user-actions .welcome {\r\n");
      out.write("	  font-size: 16px;\r\n");
      out.write("	  font-weight: 500;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.user-actions a {\r\n");
      out.write("	  text-decoration: none;\r\n");
      out.write("	  color: #3b82f6;\r\n");
      out.write("	  font-weight: 600;\r\n");
      out.write("	  font-size: 15px;\r\n");
      out.write("	  padding: 8px 16px;\r\n");
      out.write("	  border: 1px solid #3b82f6;\r\n");
      out.write("	  border-radius: 6px;\r\n");
      out.write("	  transition: all 0.2s ease;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	.user-actions a:hover {\r\n");
      out.write("	  background-color: #3b82f6;\r\n");
      out.write("	  color: #fff;\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	@keyframes fadeIn {\r\n");
      out.write("	  from {\r\n");
      out.write("	    opacity: 0;\r\n");
      out.write("	    transform: translateY(-10px);\r\n");
      out.write("	  }\r\n");
      out.write("	  to {\r\n");
      out.write("	    opacity: 1;\r\n");
      out.write("	    transform: translateY(0);\r\n");
      out.write("	  }\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

	boolean isLoggedIn = request.getSession().getAttribute("mem") != null;
	
      out.write("\r\n");
      out.write("	<div class=\"nav\">\r\n");
      out.write("	  <div class=\"logo\">\r\n");
      out.write("	  <a href=\"/Solocare/home\">Solocare</a>\r\n");
      out.write("	  </div>\r\n");
      out.write("	  <div class=\"menu\">\r\n");
      out.write("	    <a href=\"/Solocare/search\">쇼핑</a>\r\n");
      out.write("	    <div class=\"menu-item\">\r\n");
      out.write("		  <a href=\"#\">동호회</a>\r\n");
      out.write("		  <div class=\"dropdown\">\r\n");
      out.write("		    <a href=\"/Solocare/club/list\">동호회 목록<br><span>다양한 동호회를 한눈에 확인</span></a>\r\n");
      out.write("		    <a href=\"/Solocare/club/myclub?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mem.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">내 동호회<br><span>내가 속한 동호회 확인</span></a>\r\n");
      out.write("		  </div>\r\n");
      out.write("		</div>\r\n");
      out.write("	    <div class=\"menu-item\">\r\n");
      out.write("		  <a href=\"#\">커뮤니티</a>\r\n");
      out.write("		  <div class=\"dropdown\">\r\n");
      out.write("		    <a href=\"/Solocare/board?category=tip&page=1\">정보공유<br><span>생활 팁과 유용한 정보 공유</span></a>\r\n");
      out.write("		    <a href=\"/Solocare/board?category=free\">자유 게시판<br><span>자유롭게 의견과 경험을 나누는 공간</span></a>\r\n");
      out.write("		    <div class=\"submenu\">\r\n");
      out.write("		      <a href=\"#\">중고 거래<br><span>필요 없는 물품을 거래하는 공간</span></a>\r\n");
      out.write("		      <div class=\"dropdown\">\r\n");
      out.write("		        <a href=\"/Solocare/board?category=sell\">판매</a>\r\n");
      out.write("		        <a href=\"/Solocare/board?category=buy\">구매</a>\r\n");
      out.write("		      </div>\r\n");
      out.write("		    </div>\r\n");
      out.write("		  </div>\r\n");
      out.write("		</div>\r\n");
      out.write("	    <a href=\"/Solocare/policy\">정책</a>\r\n");
      out.write("	  </div>\r\n");
      out.write("	  <div class=\"user-actions\">\r\n");
      out.write("	    ");
 if (isLoggedIn) { 
      out.write("\r\n");
      out.write("	      <div class=\"welcome\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mem.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("님</div>\r\n");
      out.write("	      <a href=\"/Solocare/infocheck\">내정보</a>\r\n");
      out.write("	      <a href=\"/Solocare/logout\">로그아웃</a>\r\n");
      out.write("	      <a href=\"/Solocare/list\">일정관리</a>\r\n");
      out.write("	    ");
 } else { 
      out.write("\r\n");
      out.write("	      <a href=\"/Solocare/login\" class=\"nav-link\">로그인</a>\r\n");
      out.write("	    ");
 } 
      out.write("\r\n");
      out.write("	  </div>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("	<h2>동호회 정보 수정</h2>\r\n");
      out.write("	<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/club/update/submit\" method=\"post\">\r\n");
      out.write("	    <input type=\"hidden\" name=\"clubNum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"/>\r\n");
      out.write("	    <label for=\"clubName\">클럽 이름:</label>\r\n");
      out.write("	    <input type=\"text\" id=\"clubName\" name=\"clubName\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" required/><br/>\r\n");
      out.write("	    \r\n");
      out.write("	    <label for=\"clubLeader\">회장:</label>\r\n");
      out.write("	    <input type=\"text\" id=\"clubLeader\" name=\"clubLeader\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubLeader}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly/><br/>\r\n");
      out.write("	    \r\n");
      out.write("	    <label for=\"clubDescription\">설명:</label>\r\n");
      out.write("	    <textarea id=\"clubDescription\" name=\"clubDescription\" required>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubDescription}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</textarea><br/>\r\n");
      out.write("	    \r\n");
      out.write("	    <input type=\"hidden\" id=\"clubCategory\" name=\"clubCategory\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubCategory}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" required/><br/>\r\n");
      out.write("	    <input type=\"submit\" value=\"수정\"/>\r\n");
      out.write("	</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
