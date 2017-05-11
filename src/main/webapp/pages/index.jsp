<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html>
<html>
<base href="<%=basePath%>">
<jsp:include page="/pages/common/header.jsp"></jsp:include>
<head>
<link rel="shortcut icon" href="resources/images/title.ico"
	type="image/x-icon" />
<meta charset="UTF-8">
<title>事件本体</title>
<link href="resources/css/index.css" rel="stylesheet">
<link href="resources/css/common.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div>
			<img id="titleImgId"
				src="resources/images/navigation_images/head-background1.png" />
		</div>
		<%-- <%@ include file="nav.html" %> --%>
		<jsp:include page="/pages/common/nav.jsp" />
		<div class="div3 w-1140">
			<div class="col-xs-3 m-t-20">
				<a href="pages/drawont/OntoEdit.jsp"><img class="img2"
					src="resources/images/navigation_images/list-icon1.png"></img></a>
				<div class="m-t-20">
					<p class="description">
						&emsp;&emsp;基于Web的事件本体在线建模工具，支持基于六要素（对象、动作、状态、时间、环境、语言表现）的事件类及类层次关系（事件类格）构建，后续版本将支持协同建模与众包开发模式。
					</p>
				</div>
			</div>
			<div class="col-xs-3 m-t-20">
				<a href="pages/label/label.jsp"><img class="img2"
					src="resources/images/navigation_images/list-icon2.png"></img></a>
				<div class="m-t-20">
					<p class="description">
						&emsp;&emsp;主要用于文本事件语料库的构建，支持基于Web方式的生语料编辑标注，并可远程下载上传。内嵌的半自动处理技术，可以提高标注效率。后续将支持基于机器学习的文本事件及事件要素自动抽取。
					</p><br>
				</div>
			</div>
			<div class="col-xs-3 m-t-20">
				<a href="pages/corpus_profile.jsp"><img class="img2"
					src="resources/images/navigation_images/list-icon3.png"></img></a>
				<div class="m-t-20">
					<p class="description">
						&emsp;&emsp;中文事件语料库是本课题组在对事件知识表示相关理论深入研究的基础上，经过多次更新升级形成的国内首个对外开放的中文事件语料库，它包括了两个子语料库：突发事件语料库（CEC
						Corpus，332篇语料）和环境污染突发事件语料库（CEEC Corpus，100篇语料）。
						</p>
				</div>
			</div>
			<div class="col-xs-3 m-t-20">
				<a href="referenceAction"><img class="img2"
					src="resources/images/navigation_images/list-icon4.png"></img></a>
				<div class="m-t-20">
					<p class="description">
						&emsp;&emsp;上海大学计算机学院事件本体研究团队是由刘宗田教授为领导，以教授、副教授、博士生和硕士生为研究主体的科研团队，是国内首个系统性研究基于事件的知识表示和本体理论的研究团队，团队自2009年开始开展事件本体相关的理论、算法、工具和应用研究。
					</p>
				</div>
			</div>

		</div>
		<jsp:include page="/pages/common/foot.jsp" />
	</div>
</body>
</html>