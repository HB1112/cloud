/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-26 00:41:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.club;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myclubDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/menu.jsp", Long.valueOf(1735173565156L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1731463723702L));
    _jspx_dependants.put("jar:file:/D:/cloud/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Solocare/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
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

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

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
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>내 클럽</title>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<nav class=\"navbar navbar-expand-lg navbar-light fixed-top\">\r\n");
      out.write("         ");
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
      out.write("\r\n");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-light fixed-top\" style=\"font-family: 'Montserrat', sans-serif;\">\r\n");
      out.write("    <a class=\"navbar-brand\" href=\"/Solocare/home\">Solo Care</a>\r\n");
      out.write("    <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarNav\" aria-controls=\"navbarNav\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("        <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("    </button>\r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarNav\">\r\n");
      out.write("        <ul class=\"navbar-nav\">\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/Solocare/search\">쇼핑</a>\r\n");
      out.write("            </li>\r\n");
      out.write("             <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/Solocare/club/board\">동호회</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item dropdown\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/Solocare/community\">커뮤니티</a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item dropdown\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/Solocare/policy\">정책</a>\r\n");
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
      out.write("                <a href=\"/Solocare/infocheck\" class=\"nav-link\">내 정보</a>\r\n");
      out.write("                <a href=\"/Solocare/logout\" class=\"nav-link\">로그아웃</a>\r\n");
      out.write("                <a href=\"/Solocare/list\" class=\"nav-link\">일정관리</a>\r\n");
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
      out.write("    </nav>\r\n");
      out.write("    \r\n");
      out.write("    <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/club/myclub\" method=\"post\" style=\"display: inline;\">\r\n");
      out.write("	    <input type=\"hidden\" name=\"id\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mem.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"> <!-- 세션에서 가져온 멤버 ID로 설정 -->\r\n");
      out.write("	    <button type=\"submit\" class=\"btn btn-warning\">내 동호회</button>\r\n");
      out.write("	</form>\r\n");
      out.write("	<h2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("	<p>회장: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubLeader}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("	<p>설명: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubDescription}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("	<p>카테고리: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubCategory}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("	<p>위치: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.region}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.district}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("	<p>회원 수: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.count}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(" 명</p>\r\n");
      out.write("		\r\n");
      out.write("	");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<form action=\"community\" method=\"get\" style=\"display: inline;\">\r\n");
      out.write("	    <input type=\"hidden\" name=\"clubNum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"> <!-- 세션에서 가져온 멤버 ID로 설정 -->\r\n");
      out.write("	    <button type=\"submit\" class=\"btn btn-success\">동호회 커뮤니티</button> <!-- 세션 ID를 포함한 버튼 -->\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	<a href=\"clubcalendar/search/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">동호회 일정</a>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/club/selfcancelMember\" method=\"post\" style=\"display:inline;\">\r\n");
      out.write("	    <input type=\"hidden\" name=\"memberId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mem.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("	    <input type=\"hidden\" name=\"clubNum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("	    <button type=\"submit\" class=\"btn btn-danger btn-sm\">탈퇴</button>\r\n");
      out.write("	</form>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
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

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/views/club/myclubDetail.jsp(26,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mem.id == club.clubLeader}", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" <!-- 클럽 리더의 ID와 비교 -->\r\n");
        out.write("        <form action=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write("/club/update/");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write("\" method=\"get\">\r\n");
        out.write("            <input type=\"hidden\" name=\"clubNum\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write("\"/>\r\n");
        out.write("            <input type=\"submit\" value=\"동호회 수정 및 삭제\" class=\"btn btn-info\"/>\r\n");
        out.write("        </form>\r\n");
        out.write("        \r\n");
        out.write("        <form action=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write("/club/membercheck\" method=\"get\">\r\n");
        out.write("            <input type=\"hidden\" name=\"clubNum\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${club.clubNum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
        out.write("\"/>\r\n");
        out.write("            <input type=\"submit\" value=\"멤버관리\" class=\"btn btn-primary\"/>\r\n");
        out.write("        </form>\r\n");
        out.write("    ");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
