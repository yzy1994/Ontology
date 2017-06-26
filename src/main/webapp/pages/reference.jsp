<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
<title>事件本体研究团队</title>
<link href="resources/css/index.css" rel="stylesheet">
<link href="resources/css/common.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div>
			<img id="titleImgId"
				src="resources/images/navigation_images/head-background2.png" />
		</div>
		<jsp:include page="/pages/common/nav.jsp" />
		<div>
			<div class="w-1140 m-t-20">
				<div class="list-wrap">
					<b class="top-title">事件本体研究团队</b>
					<dl class="items clearfix" id="researchers">
						<!-- <dd class="item col-xs-12">
							<img src="http://cms.shu.edu.cn/Portals/390/lzt-1.jpg" class="img">
							<div class="detail">刘宗田（1946—），男，1982 年于北京航空航天大学计算机科学与工程系获得硕士学位，现为上海大学计算机
工程与科学学院教授、博士生导师，主要研究领域为人工智能，软件工程等。</div>
						</dd>  -->
						<s:iterator value="rlist" id="r" status="st">
							<dd class="item col-xs-12">
								<img src="<s:property escape="0" value="picpath"/>" class="img"/>
								<div class="detail"><s:property escape="0" value="resume"/></div>
							</dd>
						</s:iterator>
					</dl>
				</div>
			</div>

			<div class="list-wrap w-1140 m-t-20">
				<b class="top-title">主要研究项目：</b>
				<dl id="ontologyitems" class="items clearfix">
					<dd class="col-xs-12">
						<p>1. 国家自然科学基金面上项目，61273328，事件本体形式化方法中的几个重要问题，2013/01-2016/12</p>
					</dd>
					<dd class="col-xs-12">
						<p>2. 国家自然科学基金青年项目，61305053，基于描述逻辑的事件推理关键问题研究，2014/01-2016/12</p>
					</dd>
					<dd class="col-xs-12">
						<p>3. 国家自然科学基金面上项目，60975033，事件本体模型与应用技术，2011/01-2013/12</p>
					</dd>
					<dd class="col-xs-12">
						<p>4. 国家自然科学基金面上项目，60575035，面向本体的形式概念分析扩展模型和算法，
							2006/01-2008/12</p>
					</dd>
					<dd class="col-xs-12">
						<p>5. 国家自然科学基金面上项目，60275022，分布式概念格数学模型及算法研究，
							2003/01-2005/12</p>
					</dd>
				</dl>
			</div>

			<div id="divpaper" class="w-1140 m-t-20">
				<div class="list-wrap">
					<b class="top-title">主要发表论文：</b>
					<dl id="ontologypapers" class="items clearfix">
						<!-- <dd class="paper col-xs-12">
							<a href="./paper/2009/面向事件的本体研究.pdf">刘宗田, 黄美丽, 周文,等.
								面向事件的本体研究[J]. 计算机科学, 2009, 36(11):189-192.</a>
						</dd> -->
						<s:iterator value="plist" id="p" status="st">
							<dd class="paper col-xs-12">
								<a href="http://47.92.7.239/ontology/<s:property escape="0" value="path"/>"><s:property escape="0" value="pname"/></a>
							</dd>
						</s:iterator>
					</dl>
				</div>
			</div>

		</div>
		<jsp:include page="/pages/common/foot.jsp" />
	</div>
</body>
</html>