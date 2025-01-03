/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-30 01:02:28 UTC
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
      out.write("<html lang=\"en\">\r\n");
      out.write("	<head>\r\n");
      out.write("		<title>Solocare</title>\r\n");
      out.write("		<meta charset=\"utf-8\" />\r\n");
      out.write("		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, user-scalable=no\" />\r\n");
      out.write("		<link rel=\"stylesheet\" href=\"resources/css/main.css\" />\r\n");
      out.write("		<noscript><link rel=\"stylesheet\" href=\"resources/css/noscript.css\" /></noscript>\r\n");
      out.write("	</head>\r\n");
      out.write("	<body class=\"landing is-preload\">\r\n");
      out.write("\r\n");
      out.write("		<!-- Page Wrapper -->\r\n");
      out.write("			<div id=\"page-wrapper\">\r\n");
      out.write("\r\n");
      out.write("				<!-- Header -->\r\n");
      out.write("					<header id=\"header\" class=\"alt\">\r\n");
      out.write("						<h1><a href=\"index.html\">solocare</a></h1>\r\n");
      out.write("						<nav id=\"nav\">\r\n");
      out.write("							<ul>\r\n");
      out.write("								<li class=\"special\">\r\n");
      out.write("									<a href=\"#menu\" class=\"menuToggle\"><span>Menu</span></a>\r\n");
      out.write("									<div id=\"menu\">\r\n");
      out.write("										<ul>\r\n");
      out.write("											<li><a href=\"/Solocare/home\">Home</a></li>\r\n");
      out.write("											<li><a href=\"/Solocare/search\">쇼핑</a></li>\r\n");
      out.write("											<li><a href=\"/Solocare/club/board\">동호회</a></li>\r\n");
      out.write("											<li><a href=\"/Solocare/community\">커뮤니티</a></li>\r\n");
      out.write("											<li><a href=\"/Solocare/policy\">정책</a></li>\r\n");
      out.write("										</ul>\r\n");
      out.write("									</div>\r\n");
      out.write("								</li>\r\n");
      out.write("							</ul>\r\n");
      out.write("						</nav>\r\n");
      out.write("					</header>\r\n");
      out.write("\r\n");
      out.write("				<!-- Banner -->\r\n");
      out.write("					<section id=\"banner\">\r\n");
      out.write("						\r\n");
      out.write("						<div class=\"inner\">\r\n");
      out.write("							<h2>solocare</h2>\r\n");
      out.write("							<p>1인 가구를 위한 맞춤형 솔루션<br />\r\n");
      out.write("								솔로케어와 함께 새로운 라이프스타일을 경험해 보세요<br /></p>\r\n");
      out.write("							<ul class=\"actions special\">\r\n");
      out.write("								<li><a href=\"login\" class=\"button primary\">솔로케어 시작하기</a></li>\r\n");
      out.write("							</ul>\r\n");
      out.write("						</div>\r\n");
      out.write("					</section>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("		<!-- Scripts -->\r\n");
      out.write("			<script src=\"resources/js/jquery.min.js\"></script>\r\n");
      out.write("			<script src=\"resources/js/jquery.scrollex.min.js\"></script>\r\n");
      out.write("			<script src=\"resources/js/jquery.scrolly.min.js\"></script>\r\n");
      out.write("			<script src=\"resources/js/browser.min.js\"></script>\r\n");
      out.write("			<script src=\"resources/js/breakpoints.min.js\"></script>\r\n");
      out.write("			<script src=\"resources/js/util.js\"></script>\r\n");
      out.write("			<script src=\"resources/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <!-- Scroll Top -->\r\n");
      out.write("  <a href=\"#\" id=\"scroll-top\" class=\"scroll-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
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
