/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-24 08:53:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class policy_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("    <title>청년정책 데이터 AJAX 요청</title>\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("    <style>\r\n");
      out.write("        .pagination {\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        .pagination button {\r\n");
      out.write("            margin: 0 5px;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <h1>청년정책 데이터</h1>\r\n");
      out.write("    <div id=\"dataContainer\"></div>\r\n");
      out.write("    <div class=\"pagination\" id=\"paginationContainer\"></div> <!-- 페이징 버튼 컨테이너 -->\r\n");
      out.write("    \r\n");
      out.write("    <script>\r\n");
      out.write("        var currentPage = 1; // 현재 페이지 변수 초기화\r\n");
      out.write("        var totalPages = 0; // 전체 페이지 수\r\n");
      out.write("\r\n");
      out.write("        $(document).ready(function() {\r\n");
      out.write("            loadData(currentPage); // 페이지 로드 시 데이터 요청\r\n");
      out.write("\r\n");
      out.write("            function loadData(page) {\r\n");
      out.write("                $.ajax({\r\n");
      out.write("                    url: 'https://api.odcloud.kr/api/15117002/v1/uddi:989ab5fe-3649-4d45-8c1e-ed392f2080f9?page=' + page + '&perPage=10&serviceKey=2HBVdwEZTtGnvTZdf6lb%2B4iUIsEdlrxSXhxYwdikwp1HL3VaUR2swjsfFP3qaJiijEn2NeWFX9gXIlnWRVR8AQ%3D%3D', // 요청 URL\r\n");
      out.write("                    method: 'GET',\r\n");
      out.write("                    dataType: 'json', // 응답 데이터 타입\r\n");
      out.write("                    success: function(data) {\r\n");
      out.write("                        $('#dataContainer').empty(); // 데이터 컨테이너 초기화\r\n");
      out.write("                        \r\n");
      out.write("                        // 데이터가 존재할 경우\r\n");
      out.write("                        if (data.data.length > 0) {\r\n");
      out.write("                            $.each(data.data, function(index, item) {\r\n");
      out.write("                                $('#dataContainer').append('<p>' + item.사업명 + ': ' + item.사업내용 + '</p>'); // 데이터 출력\r\n");
      out.write("                            });\r\n");
      out.write("                            \r\n");
      out.write("                            // 전체 페이지 수 계산 (예시로 전체 데이터 수에 기반하여 계산)\r\n");
      out.write("                            totalPages = Math.ceil(data.totalCount / 10); // totalCount는 API에서 제공하는 전체 데이터 수\r\n");
      out.write("                            renderPagination(); // 페이지 번호 렌더링\r\n");
      out.write("                        } else {\r\n");
      out.write("                            $('#dataContainer').html('<p>데이터가 없습니다.</p>');\r\n");
      out.write("                            $('#paginationContainer').empty(); // 페이지 버튼 초기화\r\n");
      out.write("                        }\r\n");
      out.write("                    },\r\n");
      out.write("                    error: function(xhr, status, error) {\r\n");
      out.write("                        $('#dataContainer').html('<p>데이터를 불러오는 데 실패했습니다.</p>');\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            function renderPagination() {\r\n");
      out.write("                $('#paginationContainer').empty(); // 기존 페이지 버튼 초기화\r\n");
      out.write("                for (var i = 1; i <= totalPages; i++) {\r\n");
      out.write("                    $('#paginationContainer').append('<button class=\"page-button\" data-page=\"' + i + '\">' + i + '</button>');\r\n");
      out.write("                }\r\n");
      out.write("\r\n");
      out.write("                // 페이지 버튼 클릭 이벤트\r\n");
      out.write("                $('.page-button').click(function() {\r\n");
      out.write("                    currentPage = $(this).data('page'); // 클릭한 페이지 번호 저장\r\n");
      out.write("                    loadData(currentPage); // 해당 페이지 데이터 요청\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
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
