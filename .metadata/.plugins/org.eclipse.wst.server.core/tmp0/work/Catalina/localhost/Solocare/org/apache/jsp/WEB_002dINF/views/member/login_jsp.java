/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-24 02:36:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\r\n");
      out.write("    <title>로그인</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: 'Arial', sans-serif;\r\n");
      out.write("            background-color: #eaf8ff;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            height: 100vh;\r\n");
      out.write("        }\r\n");
      out.write("        .form-container {\r\n");
      out.write("            background: #fff;\r\n");
      out.write("            padding: 50px;\r\n");
      out.write("            border-radius: 15px;\r\n");
      out.write("            box-shadow: 0 8px 12px rgba(0, 0, 0, 0.1);\r\n");
      out.write("            width: 400px;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        .form-container h1 {\r\n");
      out.write("            font-size: 32px;\r\n");
      out.write("            margin-bottom: 30px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            color: #333;\r\n");
      out.write("        }\r\n");
      out.write("        .form-group {\r\n");
      out.write("            margin-bottom: 25px;\r\n");
      out.write("        }\r\n");
      out.write("        .form-group label {\r\n");
      out.write("            display: block;\r\n");
      out.write("            margin-bottom: 8px;\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            color: #555;\r\n");
      out.write("        }\r\n");
      out.write("        .form-group input {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 15px;\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        .form-group input:focus {\r\n");
      out.write("            border-color: #007bff;\r\n");
      out.write("            outline: none;\r\n");
      out.write("        }\r\n");
      out.write("        .form-actions {\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: space-between;\r\n");
      out.write("            gap: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        .form-actions button {\r\n");
      out.write("            flex: 1;\r\n");
      out.write("            padding: 15px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("        }\r\n");
      out.write("        .form-actions .login-btn {\r\n");
      out.write("            background-color: #00bfff;\r\n");
      out.write("            color: white;\r\n");
      out.write("        }\r\n");
      out.write("        .form-actions .cancel-btn {\r\n");
      out.write("            background-color: #ff6347;\r\n");
      out.write("            color: white;\r\n");
      out.write("        }\r\n");
      out.write("        .form-actions button:hover {\r\n");
      out.write("            opacity: 0.9;\r\n");
      out.write("        }\r\n");
      out.write("        .link {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin-top: 15px;\r\n");
      out.write("        }\r\n");
      out.write("        .link a {\r\n");
      out.write("            color: #007bff;\r\n");
      out.write("            text-decoration: none;\r\n");
      out.write("        }\r\n");
      out.write("        .link a:hover {\r\n");
      out.write("            text-decoration: underline;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	\r\n");
      out.write("    <div class=\"form-container\">\r\n");
      out.write("        <h1>로그인</h1>\r\n");
      out.write("        ");

			String error = (String)request.getAttribute("error");
			System.out.println("로그인 에러 : "+error);
			if (error != null) {
				out.println("<div class='alert alert-danger'>");
				out.println("아이디와 비밀번호를 확인해 주세요");
				out.println("</div>");
			}
			
		
      out.write("\r\n");
      out.write("		");
 
		    String emailCheckError = (String) request.getAttribute("emailCheckError");
		    System.out.println("이메일 인증 에러 : " + emailCheckError);
		    if (emailCheckError != null) {
		
      out.write("\r\n");
      out.write("		    <div class='alert alert-warning'>\r\n");
      out.write("		        ");
      out.print( emailCheckError );
      out.write("\r\n");
      out.write("		    </div>\r\n");
      out.write("		");
 
		    } 
		
      out.write("\r\n");
      out.write("        <form action=\"login\" method=\"post\">\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"username\">아이디</label>\r\n");
      out.write("                <input type=\"text\" id=\"id\" name=\"id\" placeholder=\"아이디 입력\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-group\">\r\n");
      out.write("                <label for=\"password\">비밀번호</label>\r\n");
      out.write("                <input type=\"password\" id=\"pw\" name=\"pw\" placeholder=\"비밀번호 입력\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-actions\">\r\n");
      out.write("                <button type=\"submit\" class=\"login-btn\">로그인</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("        <div class=\"link\">\r\n");
      out.write("            <p><a href=\"addmember\">회원가입</a></p>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
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
