package org.apache.jsp.pages.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\t\r\n");

	String path = request.getContextPath();
	// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
	pageContext.setAttribute("basePath", basePath);
	String username = request.getParameter("username");//用request得到 

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\" >\r\n");
      out.write("<head>\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml,http://www.w3.org/2000/svg\">\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<title>My JSP 'mjolnir.jsp' starting page</title>\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/login/Main.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/login/Login.css\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/login/Login.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/login/UserInfo.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"centerLogin\"\r\n");
      out.write("\t\t\tstyle=\"background-image: url(resources/images/login/login.png);\">\r\n");
      out.write("\t\t\t<ul class=\"login\">\r\n");
      out.write("\t\t\t\t<form action=\"userAction2!login.action\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("\t\t\t\t\t<li><span class=\"left\">用户名：</span> <span style=\"\"> <input\r\n");
      out.write("\t\t\t\t\t\t\tid=\"username\" name=\"username\" type=\"text\" class=\"txt\" />\r\n");
      out.write("\t\t\t\t\t</span></li>\r\n");
      out.write("\t\t\t\t\t<li><span class=\"left\">密 码： </span> <span style=\"\"> <input\r\n");
      out.write("\t\t\t\t\t\t\tid=\"password\" name=\"password\" type=\"password\" class=\"txt\" />\r\n");
      out.write("\t\t\t\t\t</span></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<img id=\"loginBT\" class=\"btn\" src=\"resources/images/login/btnlogin.gif\" /> \r\n");
      out.write("\t\t\t<input id=\"submitBt\" type=\"submit\" value=\"提交\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
