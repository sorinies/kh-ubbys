/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.66
 * Generated at: 2021-06-23 16:18:59 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1624464603602L));
    _jspx_dependants.put("jar:file:/Users/sorinies/eclipse-workspace/kh-ubbys/ubbys/WebContent/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
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

      out.write('\n');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/header.jsp", out, false);
      out.write("\n");
      out.write("    <div class=\"p-5 mb-4 bg-primary bg-gradient\">\n");
      out.write("      <div class=\"container py-5\">\n");
      out.write("        <h1 class=\"display-5 fw-bold text-light\">Develop<br>Share<br>Discover</h1>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-md-8 list-apps\">\n");
      out.write("          <h2 class=\"mb-3\">recently_added_apps</h2>\n");
      out.write("          <div class=\"row\">\n");
      out.write("            <div class=\"col-6 mb-3\">\n");
      out.write("              <div class=\"card\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                  <img src=\"https://via.placeholder.com/150\" width=\"45\" height=\"45\" class=\"rounded-3 float-start me-2\" alt=\"\">\n");
      out.write("                  <button class=\"btn btn-outline-secondary btn-like float-end\"><i class=\"bi bi-heart\"></i> 123</button>\n");
      out.write("                  <h5 class=\"card-title\">이곳에 제목입력</h5>\n");
      out.write("                  <h6 class=\"card-subtitle mb-2 text-muted\">카테고리</h6>\n");
      out.write("            \n");
      out.write("                  <p class=\"card-text\">본문의 일부가 들어갑니다. FHD 해상도의 환경에서 두 줄을 출력할 수 있는 정도로 조정합니다.\n");
      out.write("                  </p>\n");
      out.write("                  <a href=\"#\" class=\"card-hashtag\">#해시태그</a>\n");
      out.write("                  <a href=\"#\" class=\"card-hashtag\">#해시태그</a>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-6 mb-3\">\n");
      out.write("              <div class=\"card\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                  <img src=\"https://via.placeholder.com/150\" width=\"45\" height=\"45\" class=\"rounded-3 float-start me-2\" alt=\"\">\n");
      out.write("                  <button class=\"btn btn-outline-secondary btn-like float-end\"><i class=\"bi bi-heart\"></i> 123</button>\n");
      out.write("                  <h5 class=\"card-title\">이곳에 제목입력</h5>\n");
      out.write("                  <h6 class=\"card-subtitle mb-2 text-muted\">카테고리</h6>\n");
      out.write("            \n");
      out.write("                  <p class=\"card-text\">본문의 일부가 들어갑니다. FHD 해상도의 환경에서 두 줄을 출력할 수 있는 정도로 조정합니다.\n");
      out.write("                  </p>\n");
      out.write("                  <a href=\"#\" class=\"card-hashtag\">#해시태그</a>\n");
      out.write("                  <a href=\"#\" class=\"card-hashtag\">#해시태그</a>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-6 mb-3\">\n");
      out.write("              <div class=\"card\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                  <img src=\"https://via.placeholder.com/150\" width=\"45\" height=\"45\" class=\"rounded-3 float-start me-2\" alt=\"\">\n");
      out.write("                  <button class=\"btn btn-outline-secondary btn-like float-end\"><i class=\"bi bi-heart\"></i> 123</button>\n");
      out.write("                  <h5 class=\"card-title\">이곳에 제목입력</h5>\n");
      out.write("                  <h6 class=\"card-subtitle mb-2 text-muted\">카테고리</h6>\n");
      out.write("            \n");
      out.write("                  <p class=\"card-text\">본문의 일부가 들어갑니다. FHD 해상도의 환경에서 두 줄을 출력할 수 있는 정도로 조정합니다.\n");
      out.write("                  </p>\n");
      out.write("                  <a href=\"#\" class=\"card-hashtag\">#해시태그</a>\n");
      out.write("                  <a href=\"#\" class=\"card-hashtag\">#해시태그</a>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-6 mb-3\">\n");
      out.write("              <div class=\"card\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                  <img src=\"https://via.placeholder.com/150\" width=\"45\" height=\"45\" class=\"rounded-3 float-start me-2\" alt=\"\">\n");
      out.write("                  <button class=\"btn btn-outline-secondary btn-like float-end\"><i class=\"bi bi-heart\"></i> 123</button>\n");
      out.write("                  <h5 class=\"card-title\">이곳에 제목입력</h5>\n");
      out.write("                  <h6 class=\"card-subtitle mb-2 text-muted\">카테고리</h6>\n");
      out.write("                  \n");
      out.write("                  <p class=\"card-text\">본문의 일부가 들어갑니다. FHD 해상도의 환경에서 두 줄을 출력할 수 있는 정도로 조정합니다.\n");
      out.write("                  </p>\n");
      out.write("                  <a href=\"#\" class=\"card-hashtag\">#해시태그</a>\n");
      out.write("                  <a href=\"#\" class=\"card-hashtag\">#해시태그</a>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("          <a href=\"#\" class=\"btn btn-outline-primary\">더 보기</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-md-4 list-sm-qna\">\n");
      out.write("          <h2 class=\"mb-3\">recently_added_qna</h2>\n");
      out.write("          <div class=\"list-group mb-3\">\n");
      out.write("            <a href=\"#\" class=\"list-group-item list-group-item-action\">\n");
      out.write("              <div class=\"d-flex w-100 justify-content-between\">\n");
      out.write("                <h5 class=\"mb-1\">List group item heading</h5>\n");
      out.write("              </div>\n");
      out.write("              <small>{작성자명}</small>\n");
      out.write("              <small><i class=\"bi bi-heart\"></i> 123</small>\n");
      out.write("              <small><i class=\"bi bi-chat\"></i> 123</small>\n");
      out.write("            </a>\n");
      out.write("            <a href=\"#\" class=\"list-group-item list-group-item-action\">\n");
      out.write("              <div class=\"d-flex w-100 justify-content-between\">\n");
      out.write("                <h5 class=\"mb-1\">List group item heading</h5>\n");
      out.write("              </div>\n");
      out.write("              <small>{작성자명}</small>\n");
      out.write("              <small><i class=\"bi bi-heart\"></i> 123</small>\n");
      out.write("              <small><i class=\"bi bi-chat\"></i> 123</small>\n");
      out.write("            </a>\n");
      out.write("            <a href=\"#\" class=\"list-group-item list-group-item-action\">\n");
      out.write("              <div class=\"d-flex w-100 justify-content-between\">\n");
      out.write("                <h5 class=\"mb-1\">List group item heading</h5>\n");
      out.write("              </div>\n");
      out.write("              <small>{작성자명}</small>\n");
      out.write("              <small><i class=\"bi bi-heart\"></i> 123</small>\n");
      out.write("              <small><i class=\"bi bi-chat\"></i> 123</small>\n");
      out.write("            </a>\n");
      out.write("            <a href=\"#\" class=\"list-group-item list-group-item-action\">\n");
      out.write("              <div class=\"d-flex w-100 justify-content-between\">\n");
      out.write("                <h5 class=\"mb-1\">List group item heading</h5>\n");
      out.write("              </div>\n");
      out.write("              <small>{작성자명}</small>\n");
      out.write("              <small><i class=\"bi bi-heart\"></i> 123</small>\n");
      out.write("              <small><i class=\"bi bi-chat\"></i> 123</small>\n");
      out.write("            </a>\n");
      out.write("            <a href=\"#\" class=\"list-group-item list-group-item-action\">\n");
      out.write("              <div class=\"d-flex w-100 justify-content-between\">\n");
      out.write("                <h5 class=\"mb-1\">List group item heading</h5>\n");
      out.write("              </div>\n");
      out.write("              <small>{작성자명}</small>\n");
      out.write("              <small><i class=\"bi bi-heart\"></i> 123</small>\n");
      out.write("              <small><i class=\"bi bi-chat\"></i> 123</small>\n");
      out.write("            </a>\n");
      out.write("          </div>\n");
      out.write("          <a href=\"#\" class=\"btn btn-outline-primary\">더 보기</a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/footer.jsp", out, false);
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
