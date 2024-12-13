/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-13 01:46:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class addmember_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>회원가입</title>\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script> <!-- jQuery 포함 -->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div>\r\n");
      out.write("    <h2>회원가입</h2>\r\n");
      out.write("</div>\r\n");
      out.write("<form name=\"newMember\" action=\"addMember\" method=\"post\">\r\n");
      out.write("    <div class=\"mb-3 row\">\r\n");
      out.write("        <label class=\"col-sm-2\">아이디</label>\r\n");
      out.write("        <div class=\"col-sm-3\">\r\n");
      out.write("            <input id=\"id\" name=\"id\" type=\"text\" class=\"form-control\" placeholder=\"아이디\" required>\r\n");
      out.write("            <button id=\"check\" type=\"button\">아이디 조회</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"mb-3 row\">\r\n");
      out.write("        <label class=\"col-sm-2\">비밀번호</label>\r\n");
      out.write("        <div class=\"col-sm-3\">\r\n");
      out.write("            <input name=\"pw\" type=\"password\" class=\"form-control\" placeholder=\"비밀번호\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"mb-3 row\">\r\n");
      out.write("        <label class=\"col-sm-2\">성명</label>\r\n");
      out.write("        <div class=\"col-sm-3\">\r\n");
      out.write("            <input name=\"name\" type=\"text\" class=\"form-control\" placeholder=\"이름\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"mb-3 row\">\r\n");
      out.write("        <label class=\"col-sm-2\">이메일</label>\r\n");
      out.write("        <div class=\"col-sm-10\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-sm-4\">\r\n");
      out.write("                    <input type=\"text\" name=\"email\" maxlength=\"50\" class=\"form-control\" placeholder=\"이메일\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("                @\r\n");
      out.write("                <div class=\"col-sm-3\">\r\n");
      out.write("                    <select name=\"mailDomain\" class=\"form-select\">\r\n");
      out.write("                        <option value=\"naver.com\">naver.com</option>\r\n");
      out.write("                        <option value=\"daum.net\">daum.net</option>\r\n");
      out.write("                        <option value=\"gmail.com\">gmail.com</option>\r\n");
      out.write("                        <option value=\"nate.com\">nate.com</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"mb-3 row\">\r\n");
      out.write("        <label class=\"col-sm-2\">성별</label>\r\n");
      out.write("        <div class=\"col-sm-2\">\r\n");
      out.write("            <input name=\"gender\" type=\"radio\" value=\"남\" required> 남 \r\n");
      out.write("            <input name=\"gender\" type=\"radio\" value=\"여\"> 여\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"mb-3 row\">\r\n");
      out.write("        <label class=\"col-sm-2\">생일</label>\r\n");
      out.write("        <div class=\"col-sm-10\">\r\n");
      out.write("            <div class=\"row\">\r\n");
      out.write("                <div class=\"col-sm-2\">\r\n");
      out.write("                    <input type=\"text\" name=\"birthyy\" maxlength=\"4\" class=\"form-control\" placeholder=\"년(4자)\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-sm-2\">\r\n");
      out.write("                    <select name=\"birthmm\" class=\"form-select\" required>\r\n");
      out.write("                        <option value=\"\">월</option>\r\n");
      out.write("                        <option value=\"01\">1</option>\r\n");
      out.write("                        <option value=\"02\">2</option>\r\n");
      out.write("                        <option value=\"03\">3</option>\r\n");
      out.write("                        <option value=\"04\">4</option>\r\n");
      out.write("                        <option value=\"05\">5</option>\r\n");
      out.write("                        <option value=\"06\">6</option>\r\n");
      out.write("                        <option value=\"07\">7</option>\r\n");
      out.write("                        <option value=\"08\">8</option>\r\n");
      out.write("                        <option value=\"09\">9</option>\r\n");
      out.write("                        <option value=\"10\">10</option>\r\n");
      out.write("                        <option value=\"11\">11</option>\r\n");
      out.write("                        <option value=\"12\">12</option>\r\n");
      out.write("                    </select>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-sm-2\">\r\n");
      out.write("                    <input type=\"text\" name=\"birthdd\" maxlength=\"2\" class=\"form-control\" placeholder=\"일\" required>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"mb-3 row\">\r\n");
      out.write("        <label class=\"col-sm-2\">전화번호</label>\r\n");
      out.write("        <div class=\"col-sm-3\">\r\n");
      out.write("            <input name=\"phone\" type=\"text\" class=\"form-control\" placeholder=\"전화번호\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"mb-3 row\">\r\n");
      out.write("        <label class=\"col-sm-2\">주소</label>\r\n");
      out.write("        <div class=\"col-sm-5\">\r\n");
      out.write("            <input name=\"address\" type=\"text\" class=\"form-control\" placeholder=\"주소\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"mb-3 row\">\r\n");
      out.write("        <div class=\"col-sm-offset-2 col-sm-10\">\r\n");
      out.write("            <input type=\"submit\" class=\"btn btn-primary\" value=\"등록\"> \r\n");
      out.write("            <input type=\"reset\" class=\"btn btn-primary\" value=\"취소\" onclick=\"reset()\">\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</form>\r\n");
      out.write("<script>\r\n");
      out.write("    var btn = document.querySelector(\"#check\");\r\n");
      out.write("    console.log(btn);\r\n");
      out.write("    btn.addEventListener(\"click\", idcheck);\r\n");
      out.write("\r\n");
      out.write("    function idcheck() {\r\n");
      out.write("        console.log(\"아이디 체크 실행\");\r\n");
      out.write("        var inputdata = document.querySelector(\"#id\").value;\r\n");
      out.write("        console.log(inputdata);\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            url: \"/Solocare/idcheck\", \r\n");
      out.write("            type: \"post\",\r\n");
      out.write("            data: JSON.stringify({ id: inputdata }), \r\n");
      out.write("            contentType: \"application/json\", \r\n");
      out.write("            success: function(data) {\r\n");
      out.write("                if(data === \"exists\") {\r\n");
      out.write("                    alert(\"이미 존재하는 아이디입니다.\");\r\n");
      out.write("                } else {\r\n");
      out.write("                    alert(\"사용 가능한 아이디입니다.\");\r\n");
      out.write("                }\r\n");
      out.write("                console.log(data);\r\n");
      out.write("            },\r\n");
      out.write("            error: function(xhr, status, error) {\r\n");
      out.write("                alert(\"아이디 조회 실패: \" + xhr.responseText);\r\n");
      out.write("                console.error(\"Error: \" + error);\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
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
