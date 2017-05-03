<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 	    
<%
	String path = request.getContextPath();
	// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
	pageContext.setAttribute("basePath", basePath);
%>    
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="resources/css/navigation.css" rel="stylesheet">
</head>
<body>
<div>
<img id="titleImgId"
				src="resources/images/navigation_images/head-background2.png" />
</div>
<div class="div3">
<div >
<p class="loginP">
<shiro:guest><a href="pages/login/Login.jsp">登陆</a></shiro:guest>
</p>
</div>
<table>
<tr>
<td>
<div class="item"> 
<img  class="img2" src="resources/images/navigation_images/VisualBuild.png"></img>
<p class="hrefclass"><a  href="pages/drawont/OntoEdit.jsp">可视化本体构建工具主要用来构建事件本体中的各种格结构，例如事件格、对象格、环境格。同时可以通过该工具建立这些格之间的相互关系，包括事件关系，事件与要素之间的关系等。</a><br></p>
</div>
</td>
<td>
<div class="item"> 
<img class="img2" src="resources/images/navigation_images/TextBuild.png"></img>
<p class="hrefclass"><a href="pages/buildont/buildont.jsp">文本编辑构建工具主要用来构建事件本体中的事件类，对象类，环境类等。同时可以通过该工具构建实际的事件实例，并对实例中的事件以及要素的详细属性进行描述分析，能够有效的提高构建的效率。</a><br></p>
</div>
</td>
<td>
<div class="item"> 
<img class="img2" src="resources/images/navigation_images/SemiLabel.png"></img>
<p class="hrefclass"><a href="pages/label/label.jsp">半自动标注工具主要用来标注事件本体语料库，该工具基于WEB技术，任何有网络的地方，都可以对生语料进行编辑标注，并可远程下载上传。内嵌的半自动处理技术，可以极大提高标注效率。</a><br></p>
</div>
</td>
</tr>
</table>
</div>
<div class="div4">
</div>
</body>
</html>