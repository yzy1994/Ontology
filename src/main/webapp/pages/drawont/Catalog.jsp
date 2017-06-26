<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<base href="<%=basePath%>">
<jsp:include page="../common/header.jsp"></jsp:include>
<head>
<link rel="shortcut icon" href="resources/images/title.ico"
	type="image/x-icon" />
<html xmlns="http://www.w3.org/1999/xhtml">
<title>本体的添加与删除页面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" href="resources/css/buildont/label.css" />
<link href="resources/css/TabPanel.css" rel="stylesheet" type="text/css" />
<link href="resources/css/leftTab.css" rel="stylesheet" type="text/css" />
<link href="resources/css/zTreeStyle.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css/jquery.autocomplete.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css/buildont/ShowOnt.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css/bont/ontoedit/ontoedit.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="resources/css/bont/Bont.css" />
<link rel="stylesheet" href="resources/css/bont/ObjOntLatForm.css" />
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/css/index.css" rel="stylesheet">
<link href="resources/css/common.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/zTreeStyle/zTreeStyle.css" />


<script type="text/javascript" src="resources/js/common/ArrayList.js"></script>
<script type="text/javascript" src="resources/js/common/ObjOntGV.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
<script type="text/javascript" src="resources/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="resources/js/bont/DraggableWin.js"></script>
<script type="text/javascript" src="resources/js/bont/ontoedit/load.js"></script>
<script type="text/javascript"
	src="resources/js/bont/ontoedit/addont.js"></script>
<script type="text/javascript" src="resources/js/bont/ontoedit/form.js"></script>
<script type="text/javascript"
	src="resources/js/zTree/jquery.ztree.all.js"></script>
<script type="text/javascript" src="resources/js/bont/Catalog.js"></script>
</head>

<body style="padding-left:20px;padding-top:20px;">
	<h3>事件层次图目录结构</h1>
	<div class="content_wrap">
		<div class="zTreeDemoBackground left">
			<ul id="ec_Catalog" class="ztree"></ul>
		</div>

	</div>
</body>

</html>
