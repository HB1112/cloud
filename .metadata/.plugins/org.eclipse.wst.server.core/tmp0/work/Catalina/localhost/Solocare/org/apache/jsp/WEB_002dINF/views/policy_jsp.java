/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-30 08:18:14 UTC
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

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/navbar.jsp", Long.valueOf(1735546355478L));
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
      out.write("<title>정책 검색</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-3.6.0.min.js\"></script>\r\n");
      out.write("<script src=\"https://kit.fontawesome.com/70c60afc84.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/policy.css\" />\r\n");
      out.write("<script>\r\n");
      out.write("    $(document).ready(function() {\r\n");
      out.write("        var selectedBizTypes = []; // 선택된 정책 분야\r\n");
      out.write("        var selectedRegions = []; // 선택된 지역\r\n");
      out.write("        var currentPageIndex = 1; // 현재 페이지 인덱스\r\n");
      out.write("        var itemsPerPage = 10; // 페이지당 항목 수\r\n");
      out.write("        var totalPageCount; // 전체 페이지 수\r\n");
      out.write("		\r\n");
      out.write("     	// 모달 관련 함수\r\n");
      out.write("        function showModal(content) {\r\n");
      out.write("            $('#policyModal .modal-body').html(content);\r\n");
      out.write("            $('#policyModal').fadeIn(300);\r\n");
      out.write("        }\r\n");
      out.write("     	// 모달 닫기\r\n");
      out.write("        $(document).on('click', '.close-modal', function() {\r\n");
      out.write("            $('#policyModal').fadeOut(300);\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        // 모달 외부 클릭 시 닫기\r\n");
      out.write("        $(window).click(function(event) {\r\n");
      out.write("            if (event.target == document.getElementById('policyModal')) {\r\n");
      out.write("                $('#policyModal').fadeOut(300);\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("        \r\n");
      out.write("        // 전체 정책 목록 로드 함수\r\n");
      out.write("        function loadAllPolicies(pageIndex = 1) {\r\n");
      out.write("            var query = $('#searchInput').val();\r\n");
      out.write("\r\n");
      out.write("            var params = {\r\n");
      out.write("                query: query,\r\n");
      out.write("                srchPolyBizSecd: selectedRegions.length > 0 ? selectedRegions.join(',') : '',\r\n");
      out.write("                bizTycdSel: selectedBizTypes.length > 0 ? selectedBizTypes.join(',') : '',\r\n");
      out.write("                pageIndex: pageIndex\r\n");
      out.write("            };\r\n");
      out.write("\r\n");
      out.write("            console.log('AJAX 요청 파라미터:', params); // 디버깅용\r\n");
      out.write("\r\n");
      out.write("            $.ajax({\r\n");
      out.write("                url: '/Solocare/policy/search',\r\n");
      out.write("                type: 'GET',\r\n");
      out.write("                data: params,\r\n");
      out.write("                contentType: 'application/json;charset=UTF-8',\r\n");
      out.write("                success: function(response) {\r\n");
      out.write("                    try {\r\n");
      out.write("                        var data = (typeof response === 'string') ? JSON.parse(response) : response;\r\n");
      out.write("                        if (!data || !data.youthPolicyList || !data.youthPolicyList.youthPolicy) {\r\n");
      out.write("                            $('#result').html('<p>검색 결과가 없습니다.</p>');\r\n");
      out.write("                            return;\r\n");
      out.write("                        }\r\n");
      out.write("                        displayPolicies(data);\r\n");
      out.write("                        totalPageCount = Math.ceil(data.youthPolicyList.totalCnt / itemsPerPage);\r\n");
      out.write("                        setupPagination();\r\n");
      out.write("                    } catch (e) {\r\n");
      out.write("                        console.error('Error:', e);\r\n");
      out.write("                        $('#result').html('<p>데이터 처리 중 오류가 발생했습니다: ' + e.message + '</p>');\r\n");
      out.write("                    }\r\n");
      out.write("                },\r\n");
      out.write("                error: function(xhr, status, error) {\r\n");
      out.write("                    $('#result').html('<p>오류가 발생했습니다. 상태: ' + status + ', 메시지: ' + error + '</p>');\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("     	// 페이지네이션 설정 함수\r\n");
      out.write("        function setupPagination() {\r\n");
      out.write("            var paginationHtml = '';\r\n");
      out.write("            var pageGroupSize = 10; // 한 번에 표시할 페이지 수\r\n");
      out.write("            var startPage = Math.floor((currentPageIndex - 1) / pageGroupSize) * pageGroupSize + 1; // 시작 페이지\r\n");
      out.write("            var endPage = Math.min(startPage + pageGroupSize - 1, totalPageCount); // 끝 페이지\r\n");
      out.write("\r\n");
      out.write("            // 이전 버튼\r\n");
      out.write("            if (startPage > 1) {\r\n");
      out.write("                paginationHtml += '<button class=\"page-button\" data-page=\"' + (startPage - 1) + '\">이전</button>';\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            // 페이지 번호 버튼\r\n");
      out.write("            for (var i = startPage; i <= endPage; i++) {\r\n");
      out.write("                paginationHtml += '<button class=\"page-button' + (i === currentPageIndex ? ' active' : '') + '\" data-page=\"' + i + '\">' + i + '</button>';\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            // 다음 버튼\r\n");
      out.write("            if (endPage < totalPageCount) {\r\n");
      out.write("                paginationHtml += '<button class=\"page-button\" data-page=\"' + (endPage + 1) + '\">다음</button>';\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            $('#pagination').html(paginationHtml); // 페이지 버튼 추가\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        // 페이지 버튼 클릭 시 해당 페이지 데이터 요청\r\n");
      out.write("        $(document).on('click', '.page-button', function() {\r\n");
      out.write("            currentPageIndex = $(this).data('page'); // 클릭된 페이지 인덱스\r\n");
      out.write("            loadAllPolicies(currentPageIndex); // 조건과 함께 호출\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        // 검색 버튼 클릭 이벤트\r\n");
      out.write("        $('#searchButton').click(function() {\r\n");
      out.write("            currentPageIndex = 1; // 검색 시 페이지를 첫 페이지로 초기화\r\n");
      out.write("            loadAllPolicies(currentPageIndex); // 검색 조건과 함께 호출\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        // 정책 목록 표시 함수\r\n");
      out.write("        function displayPolicies(data) {\r\n");
      out.write("            var policies = data.youthPolicyList.youthPolicy;\r\n");
      out.write("            if (!policies) {\r\n");
      out.write("                $('#result').html('<p>검색 결과가 없습니다.</p>');\r\n");
      out.write("                return;\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            if (!Array.isArray(policies)) {\r\n");
      out.write("                policies = [policies];\r\n");
      out.write("            }\r\n");
      out.write("\r\n");
      out.write("            var html = '<table class=\"policy-board\">';\r\n");
      out.write("            html += '<thead><tr>';\r\n");
      out.write("            html += '<th>번호</th>';\r\n");
      out.write("            html += '<th>정책명</th>';\r\n");
      out.write("            html += '<th>지역</th>';\r\n");
      out.write("            html += '<th>신청기간</th>';\r\n");
      out.write("            html += '</tr></thead><tbody>';\r\n");
      out.write("\r\n");
      out.write("            policies.forEach(function(policy) {\r\n");
      out.write("                html += '<tr>';\r\n");
      out.write("                html += '<td>' + policy.rnum + '</td>';\r\n");
      out.write("                html += '<td><div class=\"policy-title\" onclick=\"showPolicyDetail(' + \r\n");
      out.write("                        JSON.stringify(policy).replace(/\"/g, '&quot;') + ')\">' + \r\n");
      out.write("                        policy.polyBizSjnm + '</div></td>';\r\n");
      out.write("                html += '<td>' + getRegionName(policy.polyBizSecd) + '</td>';\r\n");
      out.write("                html += '<td>' + formatPeriod(policy.rqutPrdCn) + '</td>';\r\n");
      out.write("                html += '</tr>';\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("            html += '</tbody></table>';\r\n");
      out.write("            $('#result').html(html);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        // 상세 정보 표시 함수\r\n");
      out.write("        function createDetailItem(label, value) {\r\n");
      out.write("            if (!value || value === 'null') return '';\r\n");
      out.write("            return '<div class=\"detail-item\"><strong>' + label + ':</strong> ' + value + '</div>';\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        // 지역 코드 변환 함수\r\n");
      out.write("        function getRegionName(code) {\r\n");
      out.write("            const regionCodes = {\r\n");
      out.write("                '003002001': '서울', \r\n");
      out.write("                '003002002': '부산', \r\n");
      out.write("                '003002003': '대구',\r\n");
      out.write("                '003002004': '인천', \r\n");
      out.write("                '003002005': '광주', \r\n");
      out.write("                '003002006': '대전',\r\n");
      out.write("                '003002007': '울산', \r\n");
      out.write("                '003002008': '경기', \r\n");
      out.write("                '003002009': '강원',\r\n");
      out.write("                '003002010': '충북', \r\n");
      out.write("                '003002011': '충남', \r\n");
      out.write("                '003002012': '전북',\r\n");
      out.write("                '003002013': '전남', \r\n");
      out.write("                '003002014': '경북', \r\n");
      out.write("                '003002015': '경남',\r\n");
      out.write("                '003002016': '제주', \r\n");
      out.write("                '003002017': '세종'\r\n");
      out.write("            };\r\n");
      out.write("            return regionCodes[code.substring(0, 9)] || '기타';\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        // 신청기간 포맷팅 함수\r\n");
      out.write("        function formatPeriod(period) {\r\n");
      out.write("            if (!period || period === 'null') return '-';\r\n");
      out.write("            return period.split('\\r')[0];\r\n");
      out.write("        }\r\n");
      out.write("		\r\n");
      out.write("    	 // 초기 상태 설정: 전체 버튼 선택\r\n");
      out.write("        $('.selection-button-part[data-value=\"\"]').addClass('selected');\r\n");
      out.write("        $('.selection-button-region[data-value=\"\"]').addClass('selected');\r\n");
      out.write("\r\n");
      out.write("        // 정책 분야 버튼 클릭 이벤트\r\n");
      out.write("        $('.selection-button-part').click(function() {\r\n");
      out.write("            var value = $(this).data('value');\r\n");
      out.write("\r\n");
      out.write("            // 전체 버튼 클릭 시\r\n");
      out.write("            if (value === \"\") {\r\n");
      out.write("                // 다른 정책 분야 버튼 선택 해제\r\n");
      out.write("                $('.selection-button-part').not(this).removeClass('selected');\r\n");
      out.write("                selectedBizTypes = []; // 선택된 정책 분야 초기화\r\n");
      out.write("                $(this).addClass('selected'); // 전체 버튼 선택 상태 유지\r\n");
      out.write("            } else {\r\n");
      out.write("                // 전체 버튼 선택 해제\r\n");
      out.write("                $('.selection-button-part[data-value=\"\"]').removeClass('selected');\r\n");
      out.write("\r\n");
      out.write("                // 선택 상태 토글\r\n");
      out.write("                $(this).toggleClass('selected');\r\n");
      out.write("                if ($(this).hasClass('selected')) {\r\n");
      out.write("                    selectedBizTypes.push(value);\r\n");
      out.write("                } else {\r\n");
      out.write("                    selectedBizTypes = selectedBizTypes.filter(function(v) { return v !== value; });\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        // 지역 버튼 클릭 이벤트\r\n");
      out.write("        $('.selection-button-region').click(function() {\r\n");
      out.write("            var value = $(this).data('value');\r\n");
      out.write("\r\n");
      out.write("            // 전체 버튼 클릭 시\r\n");
      out.write("            if (value === \"\") {\r\n");
      out.write("                // 다른 지역 버튼 선택 해제\r\n");
      out.write("                $('.selection-button-region').not(this).removeClass('selected');\r\n");
      out.write("                selectedRegions = []; // 선택된 지역 초기화\r\n");
      out.write("                $(this).addClass('selected'); // 전체 버튼 선택 상태 유지\r\n");
      out.write("            } else {\r\n");
      out.write("                // 전체 버튼 선택 해제\r\n");
      out.write("                $('.selection-button-region[data-value=\"\"]').removeClass('selected');\r\n");
      out.write("\r\n");
      out.write("                // 선택 상태 토글\r\n");
      out.write("                $(this).toggleClass('selected');\r\n");
      out.write("                if ($(this).hasClass('selected')) {\r\n");
      out.write("                    selectedRegions.push(value);\r\n");
      out.write("                } else {\r\n");
      out.write("                    selectedRegions = selectedRegions.filter(function(v) { return v !== value; });\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("\r\n");
      out.write("        // 페이지 로딩 시 전체 정책 목록 요청\r\n");
      out.write("        loadAllPolicies();\r\n");
      out.write("        \r\n");
      out.write("    });\r\n");
      out.write(" 	// 정책 상세 정보 표시 함수\r\n");
      out.write("    function showPolicyDetail(policy) {\r\n");
      out.write("        var detailHtml = '<div class=\"detail-grid\">';\r\n");
      out.write("        detailHtml += createDetailItem('정책 소개', formatText(policy.polyItcnCn));\r\n");
      out.write("        detailHtml += createDetailItem('지원 내용', formatText(policy.sporCn));\r\n");
      out.write("        detailHtml += createDetailItem('지원 규모', formatText(policy.sporScvl));\r\n");
      out.write("        detailHtml += createDetailItem('신청 자격', formatText(policy.prcpCn));\r\n");
      out.write("        detailHtml += createDetailItem('연령', formatText(policy.ageInfo));\r\n");
      out.write("        detailHtml += createDetailItem('전공', formatText(policy.majrRqisCn));\r\n");
      out.write("        detailHtml += createDetailItem('취업상태', formatText(policy.empmSttsCn));\r\n");
      out.write("        detailHtml += createDetailItem('신청 방법', formatText(policy.rqutProcCn));\r\n");
      out.write("        if (policy.rqutUrla && policy.rqutUrla !== 'null') {\r\n");
      out.write("            detailHtml += createDetailItem('신청 링크', '<a href=\"' + policy.rqutUrla + '\" target=\"_blank\">바로가기</a>');\r\n");
      out.write("        }\r\n");
      out.write("        detailHtml += createDetailItem('문의처', formatText(policy.cherCtpcCn));\r\n");
      out.write("        detailHtml += '</div>';\r\n");
      out.write("        \r\n");
      out.write("        $('#policyModal .modal-body').html(detailHtml);\r\n");
      out.write("        $('#policyModal').fadeIn(300);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write(" 	// 상세 정보 아이템 생성 함수\r\n");
      out.write("    function createDetailItem(label, value) {\r\n");
      out.write("        if (!value || value === 'null') return '';\r\n");
      out.write("        return '<div class=\"detail-item\"><strong>' + label + ':</strong><div class=\"detail-value\">' + value + '</div></div>';\r\n");
      out.write("    }\r\n");
      out.write(" 	// 텍스트 포맷팅 함수\r\n");
      out.write("    function formatText(text) {\r\n");
      out.write("        if (!text || text === 'null') return '';\r\n");
      out.write("        return text\r\n");
      out.write("            .replace(/\\r\\n/g, '<br/>') // \\r\\n을 <br/>로 변환\r\n");
      out.write("            .replace(/\\n/g, '<br/>') // \\n을 <br/>로 변환\r\n");
      out.write("            .replace(/\\r/g, '<br/>') // \\r을 <br/>로 변환\r\n");
      out.write("            .replace(/○/g, '<br/>○') // ○ 앞에 줄바꿈 추가\r\n");
      out.write("            .replace(/\\s{2,}/g, ' '); // 여러 개의 공백을 하나로 통일\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    \r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\" />\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("  <title>솔로케어</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <link\r\n");
      out.write("    rel=\"stylesheet\"\r\n");
      out.write("    href=\"https://cdn.jsdelivr.net/gh/orioncactus/pretendard@v1.3.9/dist/web/static/pretendard.min.css\"\r\n");
      out.write("  />\r\n");
      out.write("  <link\r\n");
      out.write("    href=\"https://webfontworld.github.io/gmarket/GmarketSans.css\"\r\n");
      out.write("    rel=\"stylesheet\"\r\n");
      out.write("  />\r\n");
      out.write("\r\n");
      out.write("  <link\r\n");
      out.write("    href=\"https://fonts.googleapis.com/css2?family=Montserrat:wght@700&display=swap\"\r\n");
      out.write("    rel=\"stylesheet\"\r\n");
      out.write("  />\r\n");
      out.write("\r\n");
      out.write("  <style>\r\n");
      out.write("    :root {\r\n");
      out.write("      --font-pretendard: 'Pretendard', -apple-system, BlinkMacSystemFont, system-ui,\r\n");
      out.write("        Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo',\r\n");
      out.write("        'Noto Sans KR', 'Malgun Gothic', sans-serif;\r\n");
      out.write("      --font-gmarket: 'GmarketSans', sans-serif;\r\n");
      out.write("      --font-montserrat: 'Montserrat', sans-serif; \r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    body {\r\n");
      out.write("      margin: 0;\r\n");
      out.write("      font-family: var(--font-pretendard);\r\n");
      out.write("      letter-spacing: -0.01em;\r\n");
      out.write("      padding-top: 70px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .custom-nav {\r\n");
      out.write("      position: fixed;\r\n");
      out.write("      top: 0;\r\n");
      out.write("      left: 0;\r\n");
      out.write("      width: 100%;\r\n");
      out.write("      z-index: 1000;\r\n");
      out.write("      display: flex;\r\n");
      out.write("      align-items: center;\r\n");
      out.write("      justify-content: space-between;\r\n");
      out.write("      background-color: rgba(255, 255, 255, 0.8);\r\n");
      out.write("      backdrop-filter: saturate(180%) blur(10px);\r\n");
      out.write("      border-bottom: none;\r\n");
      out.write("      box-shadow: none;\r\n");
      out.write("      padding: 10px 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    /* 로고 */\r\n");
      out.write("    .custom-nav .logo {\r\n");
      out.write("      flex: 0 0 auto; \r\n");
      out.write("    }\r\n");
      out.write("    .custom-nav .logo a {\r\n");
      out.write("      font-family: var(--font-montserrat);\r\n");
      out.write("      font-weight: 700;\r\n");
      out.write("      font-size: 32px;\r\n");
      out.write("      color: #000;\r\n");
      out.write("      text-decoration: none;\r\n");
      out.write("      letter-spacing: -0.02em;\r\n");
      out.write("      transition: opacity 0.3s ease;\r\n");
      out.write("    }\r\n");
      out.write("    .custom-nav .logo a:hover {\r\n");
      out.write("      opacity: 0.7;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .custom-nav .menu {\r\n");
      out.write("      margin: 0 auto; \r\n");
      out.write("      display: flex;\r\n");
      out.write("      align-items: center;\r\n");
      out.write("      gap: 60px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .custom-nav .menu a {\r\n");
      out.write("      text-decoration: none;\r\n");
      out.write("      color: #333;\r\n");
      out.write("      font-size: 16px;\r\n");
      out.write("      font-weight: 500;\r\n");
      out.write("      transition: color 0.2s ease, opacity 0.2s ease;\r\n");
      out.write("      opacity: 0.9;\r\n");
      out.write("    }\r\n");
      out.write("    .custom-nav .menu a:hover {\r\n");
      out.write("      color: #000;\r\n");
      out.write("      opacity: 1;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    /* 드롭다운 (서브메뉴) 공통 */\r\n");
      out.write("    .custom-nav .menu-item {\r\n");
      out.write("      position: relative;\r\n");
      out.write("    }\r\n");
      out.write("    .custom-nav .menu-item .dropdown {\r\n");
      out.write("      position: absolute;\r\n");
      out.write("      top: calc(100% + 10px);\r\n");
      out.write("      left: 50%;\r\n");
      out.write("      transform: translateX(-50%);\r\n");
      out.write("      min-width: 220px;\r\n");
      out.write("\r\n");
      out.write("      background-color: rgba(255, 255, 255, 0.95);\r\n");
      out.write("      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.08);\r\n");
      out.write("      border-radius: 10px;\r\n");
      out.write("      border: 1px solid rgba(0, 0, 0, 0.05);\r\n");
      out.write("\r\n");
      out.write("      visibility: hidden;\r\n");
      out.write("      opacity: 0;\r\n");
      out.write("      transition: visibility 0s, opacity 0.4s ease, transform 0.4s ease;\r\n");
      out.write("      transform: translate(-50%, 20px);\r\n");
      out.write("\r\n");
      out.write("      display: flex;\r\n");
      out.write("      flex-direction: column;\r\n");
      out.write("      padding: 8px 0;\r\n");
      out.write("      white-space: nowrap;\r\n");
      out.write("      z-index: 9999;\r\n");
      out.write("    }\r\n");
      out.write("    .custom-nav .menu-item:hover .dropdown {\r\n");
      out.write("      visibility: visible;\r\n");
      out.write("      opacity: 1;\r\n");
      out.write("      transform: translate(-50%, 0);\r\n");
      out.write("    }\r\n");
      out.write("    .custom-nav .menu-item .dropdown a {\r\n");
      out.write("      display: block;\r\n");
      out.write("      padding: 12px 20px;\r\n");
      out.write("      font-size: 14px;\r\n");
      out.write("      color: #333;\r\n");
      out.write("      text-decoration: none;\r\n");
      out.write("      transition: background-color 0.2s ease;\r\n");
      out.write("      border-radius: 6px;\r\n");
      out.write("    }\r\n");
      out.write("    .custom-nav .menu-item .dropdown a:hover {\r\n");
      out.write("      background-color: rgba(0, 0, 0, 0.04);\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .custom-nav .submenu {\r\n");
      out.write("      position: relative;\r\n");
      out.write("    }\r\n");
      out.write("    .custom-nav .submenu .dropdown {\r\n");
      out.write("      top: 0;\r\n");
      out.write("      left: 100%;\r\n");
      out.write("      transform: translateX(10px);\r\n");
      out.write("      min-width: 130px;\r\n");
      out.write("      margin-left: 2px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .custom-nav .user-actions {\r\n");
      out.write("      flex: 0 0 auto;\r\n");
      out.write("      display: flex;\r\n");
      out.write("      align-items: center;\r\n");
      out.write("      gap: 15px;\r\n");
      out.write("    }\r\n");
      out.write("    .custom-nav .user-actions .welcome {\r\n");
      out.write("      margin-right: 10px;\r\n");
      out.write("      font-size: 15px;\r\n");
      out.write("      font-weight: 500;\r\n");
      out.write("      color: #333;\r\n");
      out.write("      opacity: 0.9;\r\n");
      out.write("    }\r\n");
      out.write("    .custom-nav .user-actions a {\r\n");
      out.write("      text-decoration: none;\r\n");
      out.write("      color: #000;\r\n");
      out.write("      font-weight: 600;\r\n");
      out.write("      font-size: 14px;\r\n");
      out.write("      padding: 8px 16px;\r\n");
      out.write("      border: none;\r\n");
      out.write("      border-radius: 8px;\r\n");
      out.write("      background-color: #f1f1f1;\r\n");
      out.write("      transition: background-color 0.2s ease, color 0.2s ease;\r\n");
      out.write("    }\r\n");
      out.write("    .custom-nav .user-actions a:hover {\r\n");
      out.write("      background-color: #ddd;\r\n");
      out.write("      color: #000;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

    
    boolean isLoggedIn = request.getSession().getAttribute("mem") != null;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"custom-nav\">\r\n");
      out.write("  <!-- 로고 -->\r\n");
      out.write("  <div class=\"logo\">\r\n");
      out.write("    <a href=\"/Solocare/home\">SoloCare</a>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <!-- 메뉴 -->\r\n");
      out.write("  <div class=\"menu\">\r\n");
      out.write("    <a href=\"/Solocare/search\">쇼핑</a>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"menu-item\">\r\n");
      out.write("      <a href=\"#\">동호회</a>\r\n");
      out.write("      <div class=\"dropdown\">\r\n");
      out.write("        <a href=\"/Solocare/club/list\">\r\n");
      out.write("          동호회 목록<br><span>다양한 동호회를 한눈에 확인</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"/Solocare/club/myclub?id=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mem.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("          내 동호회<br><span>내가 속한 동호회 확인</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"menu-item\">\r\n");
      out.write("      <a href=\"#\">커뮤니티</a>\r\n");
      out.write("      <div class=\"dropdown\">\r\n");
      out.write("        <a href=\"/Solocare/board?category=tip&page=1\">\r\n");
      out.write("          정보공유<br><span>생활 팁과 유용한 정보 공유</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <a href=\"/Solocare/board?category=free\">\r\n");
      out.write("          자유 게시판<br><span>자유롭게 의견과 경험을 나누는 공간</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <div class=\"submenu\">\r\n");
      out.write("          <a href=\"#\">\r\n");
      out.write("            중고 거래<br><span>필요 없는 물품을 거래하는 공간</span>\r\n");
      out.write("          </a>\r\n");
      out.write("          <div class=\"dropdown\">\r\n");
      out.write("            <a href=\"/Solocare/board?category=sell\">판매</a>\r\n");
      out.write("		        <a href=\"/Solocare/board?category=buy\">구매</a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <a href=\"/Solocare/policy\">정책</a>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <!-- 사용자 액션 -->\r\n");
      out.write("  <div class=\"user-actions\">\r\n");
      out.write("    ");
 if (isLoggedIn) { 
      out.write("\r\n");
      out.write("      <div class=\"welcome\">\r\n");
      out.write("        ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mem.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("님\r\n");
      out.write("      </div>\r\n");
      out.write("      <a href=\"/Solocare/infocheck\">내정보</a>\r\n");
      out.write("	    <a href=\"/Solocare/logout\">로그아웃</a>\r\n");
      out.write("	    <a href=\"/Solocare/list\">일정관리</a>\r\n");
      out.write("    ");
 } else { 
      out.write("\r\n");
      out.write("      <a href=\"/Solocare/login\" class=\"nav-link\">로그인</a>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("  </div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("    <div class=\"search-container\">\r\n");
      out.write("        <h1>청년 정책 검색</h1>\r\n");
      out.write("        <div class=\"search-controls\">\r\n");
      out.write("            <div class=\"search-input-container\">\r\n");
      out.write("                <h3><i class=\"fa-solid fa-magnifying-glass\"></i> 정책 이름 및 내용 </h3>\r\n");
      out.write("                <input type=\"text\" id=\"searchInput\" placeholder=\"정책 이름 및 내용 검색\">\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div>\r\n");
      out.write("                <h3><i class=\"fa-solid fa-magnifying-glass\"></i> 정책 분야 </h3>\r\n");
      out.write("                <button class=\"selection-button-part\" data-value=\"\">전체 분야</button> <!-- 전체 분야 추가 -->\r\n");
      out.write("                <button class=\"selection-button-part\" data-value=\"023010\">일자리 분야</button>\r\n");
      out.write("                <button class=\"selection-button-part\" data-value=\"023020\">주거 분야</button>\r\n");
      out.write("                <button class=\"selection-button-part\" data-value=\"023030\">교육 분야</button>\r\n");
      out.write("                <button class=\"selection-button-part\" data-value=\"023040\">복지.문화 분야</button>\r\n");
      out.write("                <button class=\"selection-button-part\" data-value=\"023050\">참여.권리 분야</button>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div>\r\n");
      out.write("                <div>\r\n");
      out.write("                    <h3><i class=\"fa-solid fa-magnifying-glass\"></i> 지역</h3>\r\n");
      out.write("                </div>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"\">전체 지역</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002001\">서울</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002002\">부산</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002003\">대구</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002004\">인천</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002005\">광주</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002006\">대전</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002007\">울산</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002008\">경기</button><p>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002009\">강원</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002010\">충북</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002011\">충남</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002012\">전북</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002013\">전남</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002014\">경북</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002015\">경남</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002016\">제주</button>\r\n");
      out.write("                <button class=\"selection-button-region\" data-value=\"003002017\">세종</button>\r\n");
      out.write("            </div>\r\n");
      out.write("            <button id=\"searchButton\">검색</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"result\">\r\n");
      out.write("    \r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"pagination\" class=\"pagination-controls\"></div> <!-- 페이지네이션 추가 -->\r\n");
      out.write("    <!-- 모달 추가 -->\r\n");
      out.write("    <div id=\"policyModal\" class=\"modal\">\r\n");
      out.write("        <div class=\"modal-content\">\r\n");
      out.write("            <span class=\"close-modal\">&times;</span>\r\n");
      out.write("            <div class=\"modal-body\"></div>\r\n");
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
