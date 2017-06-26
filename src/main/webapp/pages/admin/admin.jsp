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
<head>
<link rel="shortcut icon" href="resources/images/title.ico"
	type="image/x-icon" />
<meta charset="UTF-8">
<title>事件本体后台管理</title>
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="resources/css/index.css" rel="stylesheet">
<link href="resources/css/common.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<img id="titleImgId"
			src="resources/images/navigation_images/head-background1.png" />
		<div class="list-wrap w-1140">
			<table class="table table-bordered m-t-20">
				<tr>
					<th><h3>后台管理</h3></th>
				</tr>
				<tr>
					<th><a href="ecRelationAction!queryList">事件本体关系管理</a></th>
				</tr>
				
				<tr>
					<th><a href="userEditCommentAction!queryList">用户修改意见管理</a></th>
				</tr>
			</table>
		</div>
		
		<jsp:include page="/pages/common/foot.jsp" />
	</div>
</body>
</html>