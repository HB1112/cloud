/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-24 05:47:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.club;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class clubregist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/menu.jsp", Long.valueOf(1735005451750L));
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
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>동호회 등록</title>\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\r\n");
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
      out.write("                <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"policyDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n");
      out.write("                    정책 지원 \r\n");
      out.write("                </a>\r\n");
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
      out.write("    <h1>동호회 등록</h1>\r\n");
      out.write("    <form name=\"newClub\" action=\"regist\" method=\"post\">\r\n");
      out.write("        <div>\r\n");
      out.write("            <label>회원 아이디:</label>\r\n");
      out.write("            <input name=\"clubLeader\" type=\"text\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mem.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" readonly>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <label>동호회명:</label>\r\n");
      out.write("            <input name=\"clubName\" type=\"text\" required>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <label>동호회 설명:</label>\r\n");
      out.write("            <textarea name=\"clubDescription\" required></textarea>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <label for=\"clubCategory\">동호회 카테고리:</label>\r\n");
      out.write("            <select name=\"clubCategory\" id=\"clubCategory\" required>\r\n");
      out.write("                <option value=\"\">선택하세요</option>\r\n");
      out.write("                <option value=\"스포츠 및 e스포츠\">스포츠 및 e스포츠</option>\r\n");
      out.write("                <option value=\"자기개발\">자기개발</option>\r\n");
      out.write("                <option value=\"봉사 및 사회적 활동\">봉사 및 사회적 활동</option>\r\n");
      out.write("                <option value=\"문화 및 예술\">문화 및 예술</option>\r\n");
      out.write("                <option value=\"여행 및 탐험\">여행 및 탐험</option>\r\n");
      out.write("            </select>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <label>동호회 활동 지역:</label>\r\n");
      out.write("            <select name=\"region\" id=\"sido1\"></select>\r\n");
      out.write("			<select name=\"district\" id=\"gugun1\"></select>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div>\r\n");
      out.write("            <button type=\"submit\">등록</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </form>\r\n");
      out.write("</body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("    var area0 = [\"시/도 선택\", \"서울특별시\", \"인천광역시\", \"대전광역시\", \"광주광역시\", \"대구광역시\", \"울산광역시\", \"부산광역시\", \"경기도\", \"강원도\", \"충청북도\", \"충청남도\", \"전라북도\", \"전라남도\", \"경상북도\", \"경상남도\", \"제주특별자치도\"];\r\n");
      out.write("    var area1 = [\"강남구\", \"강동구\", \"강북구\", \"강서구\", \"관악구\", \"광진구\", \"구로구\", \"금천구\", \"노원구\", \"도봉구\", \"동대문구\", \"동작구\", \"마포구\", \"서대문구\", \"서초구\", \"성동구\", \"성북구\", \"송파구\", \"양천구\", \"영등포구\", \"용산구\", \"은평구\", \"종로구\", \"중구\", \"중랑구\"];\r\n");
      out.write("    var area2 = [\"계양구\", \"남구\", \"남동구\", \"동구\", \"부평구\", \"서구\", \"연수구\", \"중구\", \"강화군\", \"옹진군\"];\r\n");
      out.write("    var area3 = [\"대덕구\", \"동구\", \"서구\", \"유성구\", \"중구\"];\r\n");
      out.write("    var area4 = [\"광산구\", \"남구\", \"동구\", \"북구\", \"서구\"];\r\n");
      out.write("    var area5 = [\"남구\", \"달서구\", \"동구\", \"북구\", \"서구\", \"수성구\", \"중구\", \"달성군\"];\r\n");
      out.write("    var area6 = [\"남구\", \"동구\", \"북구\", \"중구\", \"울주군\"];\r\n");
      out.write("    var area7 = [\"강서구\", \"금정구\", \"남구\", \"동구\", \"동래구\", \"부산진구\", \"북구\", \"사상구\", \"사하구\", \"서구\", \"수영구\", \"연제구\", \"영도구\", \"중구\", \"해운대구\", \"기장군\"];\r\n");
      out.write("    var area8 = [\"고양시\", \"과천시\", \"광명시\", \"광주시\", \"구리시\", \"군포시\", \"김포시\", \"남양주시\", \"동두천시\", \"부천시\", \"성남시\", \"수원시\", \"시흥시\", \"안산시\", \"안성시\", \"안양시\", \"양주시\", \"오산시\", \"용인시\", \"의왕시\", \"의정부시\", \"이천시\", \"파주시\", \"평택시\", \"포천시\", \"하남시\", \"화성시\", \"가평군\", \"양평군\", \"여주군\", \"연천군\"];\r\n");
      out.write("    var area9 = [\"강릉시\", \"동해시\", \"삼척시\", \"속초시\", \"원주시\", \"춘천시\", \"태백시\", \"고성군\", \"양구군\", \"양양군\", \"영월군\", \"인제군\", \"정선군\", \"철원군\", \"평창군\", \"홍천군\", \"화천군\", \"횡성군\"];\r\n");
      out.write("    var area10 = [\"제천시\", \"청주시 상당구\", \"청주시 서원구\", \"청주시 흥덕구\", \"청주시 청원구\", \"충주시\", \"괴산군\", \"단양군\", \"보은군\", \"영동군\", \"옥천군\", \"음성군\", \"증평군\", \"진천군\"];\r\n");
      out.write("    var area11 = [\"계룡시\", \"공주시\", \"논산시\", \"보령시\", \"서산시\", \"아산시\", \"천안시 동남구\", \"천안시 서북구\", \"금산군\", \"당진시\", \"부여군\", \"서천군\", \"청양군\", \"태안군\", \"홍성군\"];\r\n");
      out.write("    var area12 = [\"군산시\", \"김제시\", \"남원시\", \"익산시\", \"전주시 완산구\", \"전주시 덕진구\", \"정읍시\", \"고창군\", \"무주군\", \"부안군\", \"순창군\", \"완주군\", \"임실군\", \"장수군\", \"진안군\"];\r\n");
      out.write("    var area13 = [\"광양시\", \"나주시\", \"목포시\", \"순천시\", \"여수시\", \"강진군\", \"고흥군\", \"곡성군\", \"구례군\", \"담양군\", \"무안군\", \"보성군\", \"신안군\", \"영광군\", \"영암군\", \"완도군\", \"장성군\", \"장흥군\", \"진도군\", \"함평군\", \"해남군\", \"화순군\"];\r\n");
      out.write("    var area14 = [\"경산시\", \"경주시\", \"구미시\", \"김천시\", \"문경시\", \"상주시\", \"안동시\", \"영주시\", \"영천시\", \"포항시 남구\", \"포항시 북구\", \"고령군\", \"군위군\", \"봉화군\", \"성주군\", \"영덕군\", \"영양군\", \"예천군\", \"울릉군\", \"울진군\", \"의성군\", \"청도군\", \"청송군\", \"칠곡군\"];\r\n");
      out.write("    var area15 = [\"거제시\", \"김해시\", \"밀양시\", \"사천시\", \"양산시\", \"진주시\", \"창원시 의창구\", \"창원시 성산구\", \"창원시 마산합포구\", \"창원시 마산회원구\", \"창원시 진해구\", \"통영시\", \"거창군\", \"고성군\", \"남해군\", \"산청군\", \"의령군\", \"창녕군\", \"하동군\", \"함안군\", \"함양군\", \"합천군\"];\r\n");
      out.write("    var area16 = [\"서귀포시\", \"제주시\"];\r\n");
      out.write("\r\n");
      out.write("    // 시/도 선택 박스 초기화 (value를 지역 이름으로 설정)\r\n");
      out.write("    $(\"select[name=region]\").append(area0.map(function(item) {\r\n");
      out.write("        return \"<option value='\" + item + \"'>\" + item + \"</option>\";\r\n");
      out.write("    }));\r\n");
      out.write("\r\n");
      out.write("    // 시/도 선택시 구/군 설정\r\n");
      out.write("    $(\"select[name=region]\").change(function() {\r\n");
      out.write("        var regionName = $(this).val();\r\n");
      out.write("        var $gugun = $(\"select[name=district]\");\r\n");
      out.write("        $gugun.empty().append(\"<option value=''>구/군 선택</option>\"); // 초기화\r\n");
      out.write("\r\n");
      out.write("        // 선택된 시/도에 맞는 구/군 배열\r\n");
      out.write("        var index = area0.indexOf(regionName); // 지역 이름으로 인덱스 찾기\r\n");
      out.write("        var selectedArea = eval(\"area\" + index);\r\n");
      out.write("        if (selectedArea) {\r\n");
      out.write("            selectedArea.forEach(function(item) {\r\n");
      out.write("                $gugun.append(\"<option value='\" + item + \"'>\" + item + \"</option>\");\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    });\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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