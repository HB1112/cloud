/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.97
 * Generated at: 2024-12-11 07:59:15 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.springmvc.domain.member;
import com.springmvc.domain.board;
import com.springmvc.domain.comment;
import java.util.List;

public final class boardone_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/D:/cloud/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/Solocare/WEB-INF/lib/jstl-1.2.jar!/META-INF/fn.tld", Long.valueOf(1153352682000L));
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
    _jspx_imports_classes = new java.util.LinkedHashSet<>(6);
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.springmvc.domain.board");
    _jspx_imports_classes.add("com.springmvc.domain.member");
    _jspx_imports_classes.add("com.springmvc.domain.comment");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>게시글 상세보기</title>\r\n");
      out.write("<style>\r\n");
      out.write("    body {\r\n");
      out.write("        font-family: Arial, sans-serif;\r\n");
      out.write("        margin: 20px;\r\n");
      out.write("        background-color: #f5f5f5;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .post-container {\r\n");
      out.write("        background-color: #fff;\r\n");
      out.write("        border-radius: 8px;\r\n");
      out.write("        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\r\n");
      out.write("        padding: 20px;\r\n");
      out.write("        margin-bottom: 20px;\r\n");
      out.write("        width: 70%; /* 본문 영역 70% 차지 */\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .title {\r\n");
      out.write("        font-size: 24px;\r\n");
      out.write("        color: #333;\r\n");
      out.write("        margin-bottom: 10px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .meta-info {\r\n");
      out.write("        font-size: 14px;\r\n");
      out.write("        color: #999;\r\n");
      out.write("        margin-bottom: 15px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .meta-info span {\r\n");
      out.write("        margin-right: 15px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .content {\r\n");
      out.write("        font-size: 16px;\r\n");
      out.write("        color: #555;\r\n");
      out.write("        line-height: 1.6;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .actions {\r\n");
      out.write("        margin-top: 20px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .actions a {\r\n");
      out.write("        display: inline-block;\r\n");
      out.write("        margin-right: 10px;\r\n");
      out.write("        padding: 10px 15px;\r\n");
      out.write("        background-color: #007bff;\r\n");
      out.write("        color: white;\r\n");
      out.write("        text-decoration: none;\r\n");
      out.write("        border-radius: 5px;\r\n");
      out.write("        transition: background-color 0.3s;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .actions a:hover {\r\n");
      out.write("        background-color: #0056b3;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .delete-link {\r\n");
      out.write("        background-color: #dc3545; /* Red for delete */\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .delete-link:hover {\r\n");
      out.write("        background-color: #c82333;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    /* 댓글 스타일 */\r\n");
      out.write("    .comments-section {\r\n");
      out.write("        background-color: #fff;\r\n");
      out.write("        border-radius: 8px;\r\n");
      out.write("        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\r\n");
      out.write("        padding: 20px;\r\n");
      out.write("        width: 70%; /* 댓글 영역 70% 차지 */\r\n");
      out.write("        margin-top: 20px; /* 본문과의 간격 */\r\n");
      out.write("        display: none; /* 기본적으로 댓글 영역 숨김 */\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .comment {\r\n");
      out.write("        border-bottom: 1px solid #eee;\r\n");
      out.write("        padding: 10px 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .comment:last-child {\r\n");
      out.write("        border-bottom: none;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .comment-author {\r\n");
      out.write("        font-weight: bold;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .comment-date {\r\n");
      out.write("        font-size: 12px;\r\n");
      out.write("        color: #999;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .comment-form {\r\n");
      out.write("        margin-top: 20px;\r\n");
      out.write("        display: flex;\r\n");
      out.write("        flex-direction: column;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .comment-form textarea {\r\n");
      out.write("        width: 100%;\r\n");
      out.write("        height: 60px;\r\n");
      out.write("        margin-bottom: 10px;\r\n");
      out.write("        padding: 10px;\r\n");
      out.write("        border: 1px solid #ccc;\r\n");
      out.write("        border-radius: 4px;\r\n");
      out.write("        resize: none; /* 텍스트 영역 크기 조절 비활성화 */\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .comment-form button {\r\n");
      out.write("        align-self: flex-end;\r\n");
      out.write("        padding: 10px 15px;\r\n");
      out.write("        background-color: #007bff;\r\n");
      out.write("        color: white;\r\n");
      out.write("        border: none;\r\n");
      out.write("        border-radius: 5px;\r\n");
      out.write("        cursor: pointer;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .comment-form button:hover {\r\n");
      out.write("        background-color: #0056b3;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"post-container\">\r\n");
      out.write("        ");
 
            board board = (board) request.getAttribute("board"); // Model에서 board 객체 가져오기
            member mem = (member) request.getSession().getAttribute("mem");
            boolean isMatch = (mem != null) && mem.getId().equals(board.getId()); // 작성자 아이디 비교
        
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <h2 class=\"title\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.subject}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</h2>\r\n");
      out.write("        <div class=\"meta-info\">\r\n");
      out.write("            <span>작성자: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("            <span>작성일: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.regist_date}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("            <span>조회수: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.hit}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"content\" id=\"content\">\r\n");
      out.write("            <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.content}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        ");
 if (isMatch) { 
      out.write("\r\n");
      out.write("            <div class=\"actions\">         \r\n");
      out.write("                <a href=\"updateboard?num=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.num}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">게시글 수정</a>\r\n");
      out.write("                <a href=\"deleteboard?num=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.num}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("&category=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.category}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" \r\n");
      out.write("                   class=\"delete-link\" \r\n");
      out.write("                   onclick=\"return confirm('정말 삭제하시겠습니까?');\">게시글 삭제</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        ");
 } 
      out.write("\r\n");
      out.write("        <div>\r\n");
      out.write("            <button onclick=\"toggleComments()\">댓글 ▼</button>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write(" 	<div class=\"comments-section\" id=\"comments-section\">\r\n");
      out.write("	    <input type=\"hidden\" id=\"num\" name=\"num\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${board.num}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"> <!-- 항상 게시물 번호를 포함 -->\r\n");
      out.write("	    \r\n");
      out.write("	    <div id=\"comments\">\r\n");
      out.write("	        \r\n");
      out.write("	    </div>\r\n");
      out.write("	\r\n");
      out.write("	    <div class=\"comment-form\">\r\n");
      out.write("	        ");
 if (mem != null) { 
      out.write(" <!-- 로그인한 경우에만 댓글 추가 가능 -->\r\n");
      out.write("	            <form id=\"commentForm\">\r\n");
      out.write("	                <input type=\"hidden\" id=\"authorid\" name=\"authorid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${mem.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("	                <textarea id=\"commentcontent\" name=\"commentcontent\" required placeholder=\"댓글을 입력하세요\"></textarea>\r\n");
      out.write("	                <button type=\"submit\">댓글 추가</button>\r\n");
      out.write("	            </form>\r\n");
      out.write("	        ");
 } else { 
      out.write("\r\n");
      out.write("	            <p>댓글을 추가하려면 <a href=\"login\">로그인</a> 하세요.</p>\r\n");
      out.write("	        ");
 } 
      out.write("\r\n");
      out.write("	    </div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("	const contentElement = document.getElementById('content');\r\n");
      out.write("	const content = contentElement.innerHTML.replace(/\\n/g, '<br/>');\r\n");
      out.write("	contentElement.innerHTML = content;\r\n");
      out.write("	// 댓글 토글\r\n");
      out.write("	function toggleComments() {\r\n");
      out.write("	    const commentsSection = document.getElementById('comments-section');\r\n");
      out.write("	    if (commentsSection.style.display === \"none\" || commentsSection.style.display === \"\") {\r\n");
      out.write("	        commentsSection.style.display = \"block\"; // 댓글 영역 보이기\r\n");
      out.write("	    } else {\r\n");
      out.write("	        commentsSection.style.display = \"none\"; // 댓글 영역 숨기기\r\n");
      out.write("	    }\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	// 댓글 로딩\r\n");
      out.write("	document.addEventListener('DOMContentLoaded', function() {\r\n");
      out.write("	    loadComments(); // 페이지가 로드될 때 댓글 불러오기\r\n");
      out.write("	});\r\n");
      out.write("	// 댓글 로딩\r\n");
      out.write("    function loadComments() {\r\n");
      out.write("	    const boardnum = document.getElementById('num').value; \r\n");
      out.write("	\r\n");
      out.write("	    fetch('/Solocare/comments', {\r\n");
      out.write("	        method: 'POST',\r\n");
      out.write("	        headers: {\r\n");
      out.write("	            'Content-Type': 'application/json'\r\n");
      out.write("	        },\r\n");
      out.write("	        body: JSON.stringify({ boardnum: boardnum })\r\n");
      out.write("	    })\r\n");
      out.write("	    .then(response => response.json())\r\n");
      out.write("	    .then(comments => {\r\n");
      out.write("	        const commentsDiv = document.getElementById('comments');\r\n");
      out.write("	        commentsDiv.innerHTML = ''; // 기존 댓글 초기화\r\n");
      out.write("	\r\n");
      out.write("	        if (comments.length > 0) {\r\n");
      out.write("	            comments.forEach(comment => {\r\n");
      out.write("	                const newComment = document.createElement('div');\r\n");
      out.write("	                newComment.className = 'comment';\r\n");
      out.write("	                newComment.setAttribute('data-commentnum', comment.commentnum); // 댓글 번호 추가\r\n");
      out.write("	                console.log('댓글 번호:', comment.commentnum); // 콘솔로 댓글 번호 출력\r\n");
      out.write("	                // 댓글 내용 추가\r\n");
      out.write("	                const authorSpan = document.createElement('span');\r\n");
      out.write("	                authorSpan.className = 'comment-author';\r\n");
      out.write("	                authorSpan.textContent = comment.authorid;\r\n");
      out.write("	\r\n");
      out.write("	                const contentParagraph = document.createElement('p');\r\n");
      out.write("	                contentParagraph.textContent = comment.commentcontent;\r\n");
      out.write("	\r\n");
      out.write("	                const dateSpan = document.createElement('span');\r\n");
      out.write("	                dateSpan.className = 'comment-date';\r\n");
      out.write("	                dateSpan.textContent = comment.createdDate;\r\n");
      out.write("	\r\n");
      out.write("	                newComment.appendChild(authorSpan);\r\n");
      out.write("	                newComment.appendChild(contentParagraph);\r\n");
      out.write("	                newComment.appendChild(dateSpan);\r\n");
      out.write("	\r\n");
      out.write("	                // 수정 및 삭제 버튼 추가\r\n");
      out.write("	                ");
 if (mem != null) { 
      out.write("\r\n");
      out.write("	                    const currentUserId = '");
      out.print( mem.getId() );
      out.write("';\r\n");
      out.write("	                    if (currentUserId === comment.authorid) {\r\n");
      out.write("	                        const editButton = document.createElement('button');\r\n");
      out.write("	                        editButton.textContent = '수정';\r\n");
      out.write("	                        \r\n");
      out.write("	                        editButton.onclick = () => {\r\n");
      out.write("	                            editComment(comment.commentnum, comment.commentcontent); // 댓글 번호 사용\r\n");
      out.write("	                        };\r\n");
      out.write("	\r\n");
      out.write("	                        const deleteButton = document.createElement('button');\r\n");
      out.write("	                        deleteButton.textContent = '삭제';\r\n");
      out.write("	                        deleteButton.onclick = () => {\r\n");
      out.write("	                            if (confirm('정말 삭제하시겠습니까?')) {\r\n");
      out.write("	                                deleteComment(comment.commentnum); // 댓글 삭제 호출\r\n");
      out.write("	                            }\r\n");
      out.write("	                        };\r\n");
      out.write("	\r\n");
      out.write("	                        newComment.appendChild(editButton);\r\n");
      out.write("	                        newComment.appendChild(deleteButton);\r\n");
      out.write("	                    }\r\n");
      out.write("	                ");
 } 
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	                commentsDiv.appendChild(newComment);\r\n");
      out.write("	            });\r\n");
      out.write("	        } else {\r\n");
      out.write("	            commentsDiv.innerHTML = '<p>댓글이 없습니다.</p>';\r\n");
      out.write("	        }\r\n");
      out.write("	    })\r\n");
      out.write("	    .catch(err => {\r\n");
      out.write("	        console.error('Error:', err);\r\n");
      out.write("	        alert('댓글을 불러오는 중 오류가 발생했습니다.');\r\n");
      out.write("	    });\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("	// 댓글 추가 \r\n");
      out.write("	document.getElementById('commentForm').addEventListener('submit', function(event) {\r\n");
      out.write("	    event.preventDefault();\r\n");
      out.write("	\r\n");
      out.write("	    const boardnum = document.getElementById('num').value;\r\n");
      out.write("	    const authorid = document.getElementById('authorid').value;\r\n");
      out.write("	    const commentcontent = document.getElementById('commentcontent').value;\r\n");
      out.write("	\r\n");
      out.write("	    fetch('addComment', {\r\n");
      out.write("	        method: 'POST',\r\n");
      out.write("	        headers: {\r\n");
      out.write("	            'Content-Type': 'application/json'\r\n");
      out.write("	        },\r\n");
      out.write("	        body: JSON.stringify({\r\n");
      out.write("	            boardnum: boardnum,\r\n");
      out.write("	            authorid: authorid,\r\n");
      out.write("	            commentcontent: commentcontent\r\n");
      out.write("	        })\r\n");
      out.write("	    })\r\n");
      out.write("	    .then(response => response.json())\r\n");
      out.write("	    .then(data => {\r\n");
      out.write("	        if (data.success) {\r\n");
      out.write("	            loadComments(); // 댓글 추가 후 댓글 목록 다시 불러오기\r\n");
      out.write("	            document.getElementById('commentcontent').value = ''; // 텍스트 영역 초기화\r\n");
      out.write("	        } else {\r\n");
      out.write("	            alert('댓글 추가에 실패했습니다. 다시 시도해 주세요.');\r\n");
      out.write("	        }\r\n");
      out.write("	    })\r\n");
      out.write("	    .catch(err => {\r\n");
      out.write("	        console.error('Error:', err);\r\n");
      out.write("	        alert('댓글 추가 중 오류가 발생했습니다.');\r\n");
      out.write("	    });\r\n");
      out.write("	});\r\n");
      out.write("	\r\n");
      out.write("	// 댓글 수정\r\n");
      out.write("  	function editComment(commentnum, currentContent) {\r\n");
      out.write("	    // 댓글 요소 찾기\r\n");
      out.write("	    const commentElements = Array.from(document.querySelectorAll('.comment'));\r\n");
      out.write("	    const commentElement = commentElements.find(element => \r\n");
      out.write("	        element.getAttribute('data-commentnum') === String(commentnum)\r\n");
      out.write("	    );\r\n");
      out.write("	\r\n");
      out.write("	    if (!commentElement) {\r\n");
      out.write("	        console.error('Comment element not found for comment number:', commentnum);\r\n");
      out.write("	        return; // 댓글 요소가 없으면 함수 종료\r\n");
      out.write("	    }\r\n");
      out.write("	\r\n");
      out.write("	    const editForm = document.createElement('form');\r\n");
      out.write("	    editForm.className = 'edit-comment-form';\r\n");
      out.write("	\r\n");
      out.write("	    const editTextarea = document.createElement('textarea');\r\n");
      out.write("	    editTextarea.value = currentContent;\r\n");
      out.write("	    editTextarea.required = true;\r\n");
      out.write("	\r\n");
      out.write("	    const saveButton = document.createElement('button');\r\n");
      out.write("	    saveButton.textContent = '저장';\r\n");
      out.write("	    saveButton.type = 'submit';\r\n");
      out.write("	\r\n");
      out.write("	    const cancelButton = document.createElement('button');\r\n");
      out.write("	    cancelButton.textContent = '취소';\r\n");
      out.write("	    cancelButton.type = 'button';\r\n");
      out.write("	\r\n");
      out.write("	    // 원래의 자식 요소를 저장\r\n");
      out.write("	    const originalChildren = Array.from(commentElement.children);\r\n");
      out.write("	\r\n");
      out.write("	    // 폼에 요소 추가\r\n");
      out.write("	    editForm.appendChild(editTextarea);\r\n");
      out.write("	    editForm.appendChild(saveButton);\r\n");
      out.write("	    editForm.appendChild(cancelButton);\r\n");
      out.write("	\r\n");
      out.write("	    // 댓글 요소의 내용을 초기화하고 수정 폼 추가\r\n");
      out.write("	    commentElement.innerHTML = '';\r\n");
      out.write("	    commentElement.appendChild(editForm);\r\n");
      out.write("	\r\n");
      out.write("	    // 취소 버튼 클릭 이벤트 처리\r\n");
      out.write("	    cancelButton.addEventListener('click', () => {\r\n");
      out.write("	        commentElement.innerHTML = ''; // 수정 폼 제거\r\n");
      out.write("	        originalChildren.forEach(child => commentElement.appendChild(child)); // 원래의 자식 요소 복원\r\n");
      out.write("	    });\r\n");
      out.write("	\r\n");
      out.write("	    // 폼 제출 이벤트 처리\r\n");
      out.write("	    editForm.addEventListener('submit', function(event) {\r\n");
      out.write("	        event.preventDefault(); // 기본 제출 동작 방지\r\n");
      out.write("	\r\n");
      out.write("	        const updatedContent = editTextarea.value.trim();\r\n");
      out.write("	\r\n");
      out.write("	        fetch('updateComment', {\r\n");
      out.write("	            method: 'POST',\r\n");
      out.write("	            headers: {\r\n");
      out.write("	                'Content-Type': 'application/json'\r\n");
      out.write("	            },\r\n");
      out.write("	            body: JSON.stringify({\r\n");
      out.write("	                commentnum: commentnum,\r\n");
      out.write("	                commentcontent: updatedContent\r\n");
      out.write("	            })\r\n");
      out.write("	        })\r\n");
      out.write("	        .then(response => response.json())\r\n");
      out.write("	        .then(data => {\r\n");
      out.write("	            if (data.success) {\r\n");
      out.write("	                loadComments(); // 댓글 목록 갱신\r\n");
      out.write("	            } else {\r\n");
      out.write("	                alert(data.message || '댓글 수정에 실패했습니다. 다시 시도해 주세요.');\r\n");
      out.write("	            }\r\n");
      out.write("	        })\r\n");
      out.write("	        .catch(err => {\r\n");
      out.write("	            console.error('Error:', err);\r\n");
      out.write("	            alert('댓글 수정 중 오류가 발생했습니다.');\r\n");
      out.write("	        });\r\n");
      out.write("	    });\r\n");
      out.write("	}\r\n");
      out.write(" 	// 댓글 삭제\r\n");
      out.write("  	function deleteComment(commentnum) {\r\n");
      out.write("  	    fetch('/Solocare/deleteComment', {\r\n");
      out.write("  	        method: 'POST',\r\n");
      out.write("  	        headers: {\r\n");
      out.write("  	            'Content-Type': 'application/json'\r\n");
      out.write("  	        },\r\n");
      out.write("  	        body: JSON.stringify({ commentnum: commentnum }) // 댓글 번호를 요청 본문에 포함\r\n");
      out.write("  	    })\r\n");
      out.write("  	    .then(response => response.json())\r\n");
      out.write("  	    .then(data => {\r\n");
      out.write("  	        if (data.success) {\r\n");
      out.write("  	            loadComments(); // 댓글 삭제 후 댓글 목록 다시 불러오기\r\n");
      out.write("  	        } else {\r\n");
      out.write("  	            alert(data.message || '댓글 삭제에 실패했습니다. 다시 시도해 주세요.');\r\n");
      out.write("  	        }\r\n");
      out.write("  	    })\r\n");
      out.write("  	    .catch(err => {\r\n");
      out.write("  	        console.error('Error:', err);\r\n");
      out.write("  	        alert('댓글 삭제 중 오류가 발생했습니다.');\r\n");
      out.write("  	    });\r\n");
      out.write("  	}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("</script>\r\n");
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
