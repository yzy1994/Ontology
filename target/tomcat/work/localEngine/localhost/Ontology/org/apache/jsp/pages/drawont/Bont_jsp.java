package org.apache.jsp.pages.drawont;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Bont_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.release();
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
      out.write("\r\n");
      out.write("<!--  %\r\n");
      out.write("\tString path = request.getContextPath();\r\n");
      out.write("\tString basePath = request.getScheme() + \"://\"\r\n");
      out.write("\t\t\t+ request.getServerName() + \":\" + request.getServerPort()\r\n");
      out.write("\t\t\t+ path + \"/\";\r\n");
      out.write("%-->\r\n");

	String path = request.getContextPath();
	// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
	pageContext.setAttribute("basePath", basePath);

      out.write("\r\n");
      out.write("<!--  <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write(" <!DOCTYPE html>\r\n");
      out.write(" <html xmlns=\"http://www.w3.org/1999/xhtml\">-->\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\" >\r\n");
      out.write("<head>\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<title>My JSP 'mjolnir.jsp' starting page</title>\r\n");
      out.write("<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("<meta http-equiv=\"expires\" content=\"0\">\r\n");
      out.write("<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"resources/css/bont/label.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/common/Nav.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/bont/Bont.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/bont/ObjOntWin.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/bont/ObjOntLatForm.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/leftmenu/LeftMenu.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/tab/Tab.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" href=\"resources/css/content/Content.css\" />\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/bottom/Bottom.css\"\r\n");
      out.write("\tmedia=\"all\">\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("\thref=\"//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css\">\r\n");
      out.write("<script src=\"//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/svg.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/svg.draggable.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/jquery-1.11.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/jquery-ui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/jquery.svg.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/jquery.svgdom.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/jquery.svganim.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/jquery.color.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/common/NavMenu.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/common/ArrayList.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/common/Config.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/common/ObjOntGV.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/leftmenu/LeftMenu.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/tab/Tab.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/ObjOntWin.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/ViewObjOnt.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/ObjOntSvg.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/EventCls.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/Time.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/Obj.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/Lang.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/Assert.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/Environ.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/ShowLayer.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/CreLoc.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/DrawOntLat.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/DrawMarker.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/RGBrush.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/DrawConLine.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/ObjOntLatForm.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/bont/ObjOntLat.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/canvg.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"resources/js/rgbcolor.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<img id=\"titleImgId\"\r\n");
      out.write("\t\t\tsrc=\"resources/images/bont/titleVisualBuild.png\"\r\n");
      out.write("\t\t\tstyle=\"vertical-align: bottom;\" />\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"navv\">\r\n");
      out.write("\t\t<!--nav-->\r\n");
      out.write("\t\t<!--导航条-->\r\n");
      out.write("\t\t<ul class=\"nav-main\">\r\n");
      out.write("\t\t\t<li id=\"li-1\">File<span></span></li>\r\n");
      out.write("\t\t\t<li id=\"li-2\">Edit<span></span></li>\r\n");
      out.write("\t\t\t<li id=\"li-3\">Tools<span></span></li>\r\n");
      out.write("\t\t\t<li id=\"li-4\">Format<span></span></li>\r\n");
      out.write("\t\t\t<li id=\"li-5\">Help<span></span></li>\r\n");
      out.write("\t\t\t<li id=\"li-6\">Contact Us<span></span></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t<div id=\"box-1\" class=\"hidden-box hidden-loc-file\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li id=\"newId\">New</li>\r\n");
      out.write("\t\t\t\t<li id=\"remoteId\">Open Remote</li>\r\n");
      out.write("\t\t\t\t<li id=\"downloadId\">download</li>\r\n");
      out.write("\t\t\t\t<li id=\"testId\">showOnt</li>\r\n");
      out.write("\t\t\t\t<li id=\"OntNodeDeal\">new ontnode</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--隐藏盒子-->\r\n");
      out.write("\t\t<div id=\"box-2\" class=\"hidden-box hidden-loc-edit\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<!--<li>Undo</li>\r\n");
      out.write("\t\t\t\t\t<li>Redo</li>\r\n");
      out.write("\t\t\t\t\t<li>Cut</li>\r\n");
      out.write("\t\t\t\t\t<li>Copy</li>\r\n");
      out.write("\t\t\t\t\t<li>Paste</li>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<li id=\"nextId\">Find Next</li>-->\r\n");
      out.write("\t\t\t\t<li id=\"findId\">Find</li>\r\n");
      out.write("\t\t\t\t<li id=\"replaceId\">Replace</li>\r\n");
      out.write("\t\t\t\t<!--<li>Select All</li>-->\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"box-3\" class=\"hidden-box hidden-loc-tools\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li id=\"checkId\">Check XML File</li>\r\n");
      out.write("\t\t\t\t<li id=\"deleteId\">Remove All Label</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"box-4\" class=\"hidden-box hidden-loc-format\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<!-- <li>AutoWrap</li>\r\n");
      out.write("\t\t\t\t\t<li>Font(F)</li>\r\n");
      out.write("\t\t\t\t\t<li>OnTop</li> -->\r\n");
      out.write("\t\t\t\t<li id=\"showId\">Format File</li>\r\n");
      out.write("\t\t\t\t<li id=\"readOnlyId\"><input type=\"checkbox\" id=\"readOnlyCBId\" />Read\r\n");
      out.write("\t\t\t\t\tOnly</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"box-5\" class=\"hidden-box hidden-loc-help\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>About</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"box-6\" class=\"hidden-box hidden-loc-contact\">\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>Email</li>\r\n");
      out.write("\t\t\t\t<li>TelePhone</li>\r\n");
      out.write("\t\t\t\t<li>Address</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<hr class=\"hr1\"></hr>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<img id=\"newImgId\"  src=\"resources/images/new.png\"></img> <img\r\n");
      out.write("\t\t\tid=\"openImgId\" src=\"resources/images/open.png\"></img> <img\r\n");
      out.write("\t\t\tid=\"saveImgId\" src=\"resources/images/save.png\"></img> <img\r\n");
      out.write("\t\t\tid=\"downloadImgId\"  src=\"resources/images/download.jpg\"></img> <img\r\n");
      out.write("\t\t\tsrc=\"resources/images/gap.png\" class=\"gap\"></img> <img\r\n");
      out.write("\t\t\tid=\"modelImgId\" src=\"resources/images/manual.jpg\"> <img\r\n");
      out.write("\t\t\tsrc=\"resources/images/gap.png\" class=\"gap\"></img> <img id=\"showImgId\"\r\n");
      out.write("\t\t\tsrc=\"resources/images/show.png\"></img> <img\r\n");
      out.write("\t\t\tsrc=\"resources/images/gap.png\" class=\"gap\"></img> <img\r\n");
      out.write("\t\t\tid=\"checkImgId\" src=\"resources/images/check.png\"></img> <img\r\n");
      out.write("\t\t\tid=\"deleteImgId\" src=\"resources/images/delete.png\"></img>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<hr class=\"hr1\"></hr>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("<div class=\"middleDiv\">\t\t\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"leftsidebar_box\">\r\n");
      out.write("\t\t\t\t<div class=\"line\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<dl class=\"channel\">\r\n");
      out.write("\t\t\t\t\t<dt>\r\n");
      out.write("\t\t\t\t\t\t事件本体<img src=\"resources/images/leftmenu/select_xl01.png\">\r\n");
      out.write("\t\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t\t<dd class=\"first_dd\">\r\n");
      out.write("\t\t\t\t\t\t<label>查看本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>编辑本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>管理本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>更新本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<dl class=\"syetem_management\">\r\n");
      out.write("\t\t\t\t\t<dt onClick=\"changeImage()\">\r\n");
      out.write("\t\t\t\t\t\t参与者本体<img src=\"resources/images/leftmenu/select_xl01.png\">\r\n");
      out.write("\t\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t\t<dd class=\"first_dd\">\r\n");
      out.write("\t\t\t\t\t\t<label>查看本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>编辑本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>管理本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>更新本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<dl class=\"cloud\">\r\n");
      out.write("\t\t\t\t\t<dt>\r\n");
      out.write("\t\t\t\t\t\t对象本体<img src=\"resources/images/leftmenu/select_xl01.png\">\r\n");
      out.write("\t\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t\t<dd class=\"first_dd\">\r\n");
      out.write("\t\t\t\t\t\t<label id=\"viewObjOnt\">查看本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>编辑本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>管理本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>更新本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<dl class=\"source\">\r\n");
      out.write("\t\t\t\t\t<dt>\r\n");
      out.write("\t\t\t\t\t\t时间本体<img src=\"resources/images/leftmenu/select_xl01.png\">\r\n");
      out.write("\t\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t\t<dd class=\"first_dd\">\r\n");
      out.write("\t\t\t\t\t\t<label>查看本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>编辑本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>管理本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>更新本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t<dl class=\"statistics\">\r\n");
      out.write("\t\t\t\t\t<dt>\r\n");
      out.write("\t\t\t\t\t\t环境本体<img src=\"resources/images/leftmenu/select_xl01.png\">\r\n");
      out.write("\t\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t\t<dd class=\"first_dd\">\r\n");
      out.write("\t\t\t\t\t\t<label>查看本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>编辑本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>管理本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>更新本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t<dl class=\"system_log\">\r\n");
      out.write("\t\t\t\t\t<dt>\r\n");
      out.write("\t\t\t\t\t\t语言表现本体<img src=\"resources/images/leftmenu/select_xl01.png\">\r\n");
      out.write("\t\t\t\t\t</dt>\r\n");
      out.write("\t\t\t\t\t<dd class=\"first_dd\">\r\n");
      out.write("\t\t\t\t\t\t<label>查看本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>编辑本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>管理本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t<label>更新本体</label>\r\n");
      out.write("\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t</dl>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"contentdiv\">\r\n");
      out.write("\t\t\t<div class=\"uldiv\">\r\n");
      out.write("\t\t\t\t<ul id=\"tabs\">\r\n");
      out.write("\t\t\t\t    <li><a href=\"#\" name=\"#tab0\">事件本体</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" name=\"#tab1\">事件</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" name=\"#tab2\">参与者</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" name=\"#tab3\">对象</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" name=\"#tab4\">时间</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" name=\"#tab5\">环境</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"#\" name=\"#tab6\">语言表现</a></li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t\t\t\t<div id=\"tab0\">\r\n");
      out.write("\t\t\t\t\t\t\t<img id=\"EOimg\" src=\"resources/images/bont/EO.png\" />\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"tab1\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>事件</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<p>事件指在某个特定的时间和环境下发生的、由若干角色参与、表现出若干动作特征的一件事情形式上，\r\n");
      out.write("\t\t\t\t\t\t\t事件可表示为e，定义为一个六元组：e一(A，O，T，V，P，L)其中，事件六元组中的元素称为事件要素，\r\n");
      out.write("\t\t\t\t\t\t\t分别表示动作、对象、时间、环境、断言、语言表现。</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"tab2\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>参与者要素</h2>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"tab3\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>对象要素</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<p>对象是事件的主要参与者，是事件中的主导作用者或被改变者。\r\n");
      out.write("\t\t\t\t\t\t\t对象可分为主体和客体。主体是主导者，是事件中的主角，有时是事\r\n");
      out.write("\t\t\t\t\t\t\t件的制造者或期望事件发生者客体是事件中的被动者。按照分工，\r\n");
      out.write("\t\t\t\t\t\t\t事件中的对象分为不同的角色，例如“选举”事件，其中有主持组织\r\n");
      out.write("\t\t\t\t\t\t\t者、监票者、投票者、候选人、当选者、落选者。事件的对象一般是\r\n");
      out.write("\t\t\t\t\t\t\t第一实体，但也可能又是事件，也可能是关系。还有的事件的对象是\r\n");
      out.write("\t\t\t\t\t\t\t有关联的事件集合。对于特定的事件类，对象是有约束的，例如选举\r\n");
      out.write("\t\t\t\t\t\t\t事件的组织者可以是人或组织。利用这些约束，可以判断句子中的主\r\n");
      out.write("\t\t\t\t\t\t\t语或宾语。其他要素也有约束，也可以利用。</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"tab4\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>事件要素</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<p>每个事件都必须发生在一个时间段内。事件有开始、发展、\r\n");
      out.write("\t\t\t\t\t\t\t结束。时间段由绝对时间表示，也可以用相对时间表示，也就是\r\n");
      out.write("\t\t\t\t\t\t\t用另一个事件的时问的相对偏差表示。</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"tab5\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>环境要素</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<p>任何事件必然发生在一定的环境中。环境由多\r\n");
      out.write("\t\t\t\t\t\t\t个实体按照特定的关系组成。例如“上课”事件的环\r\n");
      out.write("\t\t\t\t\t\t\t境有教室，教室内有黑板、讲台、课桌、椅子等，\r\n");
      out.write("\t\t\t\t\t\t\t这些东西是有序存在的。环境要素中的实体与对象\r\n");
      out.write("\t\t\t\t\t\t\t要素中的实体都是事件涉及的，还有动作要素中的\r\n");
      out.write("\t\t\t\t\t\t\t工具。为什么有的属于对象要素、有的属于环境要\r\n");
      out.write("\t\t\t\t\t\t\t素、有的属于动作要素?关键在于它们在事件中的\r\n");
      out.write("\t\t\t\t\t\t\t地位和作用。环境要素中的实体是相对静止的，在\r\n");
      out.write("\t\t\t\t\t\t\t事件中几乎是不变的，或者虽然变化，但并不重要。\r\n");
      out.write("\t\t\t\t\t\t\t而动作要素的工具中的实体是运动的，是对事件的\r\n");
      out.write("\t\t\t\t\t\t\t实施有重要作用的。对象要素中的实体是最重要的，\r\n");
      out.write("\t\t\t\t\t\t\t或者是事件的主角，或者是事件的驱动者，或者是\r\n");
      out.write("\t\t\t\t\t\t\t事件的主要被改变者。</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t<div id=\"tab6\">\r\n");
      out.write("\t\t\t\t\t\t\t<h2>语言表现要素</h2>\r\n");
      out.write("\t\t\t\t\t\t\t<p>将事件与语言分离有很多优点。事件是客观的，\r\n");
      out.write("\t\t\t\t\t\t\t本来就不依赖于语言。语言是人类为了交流各自知道\r\n");
      out.write("\t\t\t\t\t\t\t的事件发生而创造出来的符号表示，因而事件就有了\r\n");
      out.write("\t\t\t\t\t\t\t语言特性。交流和思考离不开语言，然而很多研究工\r\n");
      out.write("\t\t\t\t\t\t\t作往往将它们混为一谈。混为一谈的研究方法容易把\r\n");
      out.write("\t\t\t\t\t\t\t问题搞复杂。事件的语言表现是随着语言的变化而变\r\n");
      out.write("\t\t\t\t\t\t\t化的。同一个事件，对于不同的语言有不同的表现，\r\n");
      out.write("\t\t\t\t\t\t\t即使对于同一个语言，也会有不同的表现。语言表现\r\n");
      out.write("\t\t\t\t\t\t\t的主要内容是核心词。核心词是对于事件的称谓、对\r\n");
      out.write("\t\t\t\t\t\t\t于事件中各角色的称谓、对时问和环境的描述格式、\r\n");
      out.write("\t\t\t\t\t\t\t对各要素结合的描述格式。语言表现可以用文法表示，\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t也可以用规则表示，或用模板表示。</p>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\t\r\n");
      out.write("\t\r\n");
      out.write("<div id=\"buttomDiv\" ></div>\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("<div id=\"objOntWin\">\r\n");
      out.write("\t\t\t<div class=\"title\">\r\n");
      out.write("\t\t\t\t<h2>对象本体编辑窗口</h2>\r\n");
      out.write("\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t<a class=\"min\" href=\"javascript:;\" title=\"最小化\"></a> <a class=\"max\"\r\n");
      out.write("\t\t\t\t\t\thref=\"javascript:;\" title=\"最大化\"></a> <a class=\"revert\"\r\n");
      out.write("\t\t\t\t\t\thref=\"javascript:;\" title=\"还原\"></a> <a class=\"close\"\r\n");
      out.write("\t\t\t\t\t\thref=\"javascript:;\" title=\"关闭\"></a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"resizeL\"></div>\r\n");
      out.write("\t\t\t<div class=\"resizeT\"></div>\r\n");
      out.write("\t\t\t<div class=\"resizeR\"></div>\r\n");
      out.write("\t\t\t<div class=\"resizeB\"></div>\r\n");
      out.write("\t\t\t<div class=\"resizeLT\"></div>\r\n");
      out.write("\t\t\t<div class=\"resizeTR\"></div>\r\n");
      out.write("\t\t\t<div class=\"resizeBR\"></div>\r\n");
      out.write("\t\t\t<div class=\"resizeLB\"></div>\r\n");
      out.write("\t\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t\t<div class=\"objOntToolMenu\">\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_shiro_005fhasRole_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<img src=\"resources/images/common/gap.png\" class=\"gap\"></img> \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_shiro_005fhasRole_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<img src=\"resources/images/common/gap.png\" class=\"gap\"></img> \r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_shiro_005fhasRole_005f2(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\t\t\t\t\t<img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"resources/images/common/gap.png\" class=\"gap\"></img> <img\r\n");
      out.write("\t\t\t\t\t\tid=\"objOntFind\" src=\"resources/images/common/find.png\"> <img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"resources/images/common/gap.png\" class=\"gap\"></img> <img\r\n");
      out.write("\t\t\t\t\t\tid=\"objOntZoomout\" src=\"resources/images/common/zoomout.png\"> <img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"resources/images/common/gap.png\" class=\"gap\"></img> <img\r\n");
      out.write("\t\t\t\t\t\tid=\"objOntZoomin\" src=\"resources/images/common/zoomin.png\"> <img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"resources/images/common/gap.png\" class=\"gap\"></img> <img\r\n");
      out.write("\t\t\t\t\t\tid=\"objOntReload\" src=\"resources/images/common/reload.png\"> <img\r\n");
      out.write("\t\t\t\t\t\tsrc=\"resources/images/common/gap.png\" class=\"gap\"></img> <img\r\n");
      out.write("\t\t\t\t\t\tid=\"objOntClean\" src=\"resources/images/common/save.png\">\r\n");
      out.write("\t\t\t\t\t\t<img\r\n");
      out.write("\t\t\t\t\t\tid=\"objOntPrinter\" src=\"resources/images/common/printer.png\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"objOntSvg\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"dealObjOntLat-popover\" id=\"dealObjOntLat\">\r\n");
      out.write("\t\t\t<div class=\"dealObjOntLat-poptit\">\r\n");
      out.write("\t\t\t\t<a href=\"javascript:;\" title=\"关闭\" class=\"close\">×</a>\r\n");
      out.write("\t\t\t\t<h3 id=\"showTitle\">对象格操作</h3>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<form id=\"objOntLatForm\" class=\"contact_form\"\r\n");
      out.write("\t\t\t\t\taction=\"objOntAction!createObjOntLat.action\" method=\"post\"\r\n");
      out.write("\t\t\t\t\tname=\"contact_form\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><label for=\"objLatSid\">对象格编号:</label> <input\r\n");
      out.write("\t\t\t\t\t\t\tname=\"objLatSid\" type=\"text\" placeholder=\"o1\" required=\"required\"\r\n");
      out.write("\t\t\t\t\t\t\tid=\"objLatSid\"></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li><label for=\"objLatName\">对象格名称:</label> <input\r\n");
      out.write("\t\t\t\t\t\t\tname=\"objLatName\" type=\"text\" placeholder=\"参与者\"\r\n");
      out.write("\t\t\t\t\t\t\trequired=\"required\" id=\"objLatName\"> <span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form_hint\">正确格式为：parti</span></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li><label for=\"objParentSid\">父对象格编号:</label> <input\r\n");
      out.write("\t\t\t\t\t\t\tname=\"objParentSid\" type=\"text\" placeholder=\"o1,o2,o3\"\r\n");
      out.write("\t\t\t\t\t\t\trequired=\"required\" id=\"objParentSid\"> <span\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"form_hint\">正确格式为：o1,o2,o3</span></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li><label for=\"objLatNote\" id=\"noteLB\">备注:</label> <textarea\r\n");
      out.write("\t\t\t\t\t\t\t\tname=\"objLatNote\" cols=\"40\" rows=\"6\" placeholder=\"可以添加对象格的详细描述\"\r\n");
      out.write("\t\t\t\t\t\t\t\trequired=\"required\" id=\"objLatNote\"></textarea></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<li>\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"submit\" type=\"submit\" id=\"saveObj\">保存</button>\r\n");
      out.write("\t\t\t\t\t\t\t<button class=\"submit\" type=\"reset\" id=\"restObj\">重置</button> <input\r\n");
      out.write("\t\t\t\t\t\t\tname=\"objOid\" type=\"text\" id=\"objOid\" style=\"display: none\">\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"dealObjOntLat-popover-mask\" id=\"dealObjOntLatHide\"></div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_shiro_005fhasRole_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasRole
    org.apache.shiro.web.tags.HasRoleTag _jspx_th_shiro_005fhasRole_005f0 = (org.apache.shiro.web.tags.HasRoleTag) _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.get(org.apache.shiro.web.tags.HasRoleTag.class);
    _jspx_th_shiro_005fhasRole_005f0.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasRole_005f0.setParent(null);
    // /pages/drawont/Bont.jsp(414,5) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasRole_005f0.setName("builder");
    int _jspx_eval_shiro_005fhasRole_005f0 = _jspx_th_shiro_005fhasRole_005f0.doStartTag();
    if (_jspx_eval_shiro_005fhasRole_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write(" <img id=\"objOntAdd\" src=\"resources/images/common/add.png\"> ");
        int evalDoAfterBody = _jspx_th_shiro_005fhasRole_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasRole_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f0);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasRole_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasRole
    org.apache.shiro.web.tags.HasRoleTag _jspx_th_shiro_005fhasRole_005f1 = (org.apache.shiro.web.tags.HasRoleTag) _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.get(org.apache.shiro.web.tags.HasRoleTag.class);
    _jspx_th_shiro_005fhasRole_005f1.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasRole_005f1.setParent(null);
    // /pages/drawont/Bont.jsp(418,5) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasRole_005f1.setName("builder");
    int _jspx_eval_shiro_005fhasRole_005f1 = _jspx_th_shiro_005fhasRole_005f1.doStartTag();
    if (_jspx_eval_shiro_005fhasRole_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<img id=\"objOntDel\" src=\"resources/images/common/del.png\"> ");
        int evalDoAfterBody = _jspx_th_shiro_005fhasRole_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasRole_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f1);
    return false;
  }

  private boolean _jspx_meth_shiro_005fhasRole_005f2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  shiro:hasRole
    org.apache.shiro.web.tags.HasRoleTag _jspx_th_shiro_005fhasRole_005f2 = (org.apache.shiro.web.tags.HasRoleTag) _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.get(org.apache.shiro.web.tags.HasRoleTag.class);
    _jspx_th_shiro_005fhasRole_005f2.setPageContext(_jspx_page_context);
    _jspx_th_shiro_005fhasRole_005f2.setParent(null);
    // /pages/drawont/Bont.jsp(422,5) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_shiro_005fhasRole_005f2.setName("builder");
    int _jspx_eval_shiro_005fhasRole_005f2 = _jspx_th_shiro_005fhasRole_005f2.doStartTag();
    if (_jspx_eval_shiro_005fhasRole_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("<img id=\"objOntEdit\" src=\"resources/images/common/edit.png\"> ");
        int evalDoAfterBody = _jspx_th_shiro_005fhasRole_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_shiro_005fhasRole_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fshiro_005fhasRole_0026_005fname.reuse(_jspx_th_shiro_005fhasRole_005f2);
    return false;
  }
}
