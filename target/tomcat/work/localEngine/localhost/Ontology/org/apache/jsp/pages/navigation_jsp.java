package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class navigation_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fguest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshiro_005fguest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshiro_005fguest.release();
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("   \r\n");
      out.write(" \t    \r\n");

	String path = request.getContextPath();
	// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
	pageContext.setAttribute("basePath", basePath);

      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<link href=\"resources/css/navigation.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div>\r\n");
      out.write("<img id=\"titleImgId\" src=\"resources/images/title.png\"/>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"div3\">\r\n");
      out.write("<div >\r\n");
      out.write("<p class=\"loginP\">\r\n");
      if (_jspx_meth_shiro_005fguest_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("</p>\r\n");
      out.write("</div>\r\n");
      out.write("<table>\r\n");
      out.write("<tr>\r\n");
      out.write("<td>\r\n");
      out.write("<div class=\"item\"> \r\n");
      out.write("<img  class=\"img2\" src=\"resources/images/navigation_images/VisualBuild.png\"></img>\r\n");
      out.write("<p class=\"hrefclass\"><a  href=\"pages/drawont/Bont.jsp\">可视化本体构建工具主要用来构建事件本体中的各种格结构，例如事件格、对象格、环境格。同时可以通过该工具建立这些格之间的相互关系，包括事件关系，事件与要素之间的关系等。</a><br></p>\r\n");
      out.write("</div>\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.write("<div class=\"item\"> \r\n");
      out.write("<img class=\"img2\" src=\"resources/images/navigation_images/TextBuild.png\"></img>\r\n");
      out.write("<p class=\"hrefclass\"><a href=\"pages/buildont/buildont.jsp\">文本编辑构建工具主要用来构建事件本体中的事件类，对象类，环境类等。同时可以通过该工具构建实际的事件实例，并对实例中的事件以及要素的详细属性进行描述分析，能够有效的提高构建的效率。</a><br></p>\r\n");
      out.write("</div>\r\n");
      out.write("</td>\r\n");
      out.write("<td>\r\n");
      out.write("<div class=\"item\"> \r\n");
      out.write("<img class=\"img2\" src=\"resources/images/navigation_images/SemiLabel.png\"></img>\r\n");
      out.write("<p class=\"hrefclass\"><a href=\"pages/label/label.jsp\">半自动标注工具主要用来标注事件本体语料库，该工具基于WEB技术，任何有网络的地方，都可以对生语料进行编辑标注，并可远程下载上传。内嵌的半自动处理技术，可以极大提高标注效率。</a><br></p>\r\n");
      out.write("</div>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("<div class=\"div4\">\r\n");
      out.write("</div>\r\n");
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

  private boolean _jspx_meth_shiro_005fguest_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:guest
    org.apache.shiro.web.tags.GuestTag _jspx_th_shiro_005fguest_005f0 = (org.apache.shiro.web.tags.GuestTag) _005fjspx_005ftagPool_005fshiro_005fguest.get(org.apache.shiro.web.tags.GuestTag.class);
    _jspx_th_shiro_005fguest_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fguest_005f0.setParent(null);
    int _jspx_eval_shiro_005fguest_005f0 = _jspx_th_shiro_005fguest_005f0.doStartTag();
    if (_jspx_eval_shiro_005fguest_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<a href=\"pages/login/Login.jsp\">登陆</a>");
        int evalDoAfterBody = _jspx_th_shiro_005fguest_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fguest_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fguest.reuse(_jspx_th_shiro_005fguest_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fguest.reuse(_jspx_th_shiro_005fguest_005f0);
    return false;
  }
}
