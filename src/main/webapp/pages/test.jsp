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
<meta charset="UTF-8">
<title>svg demo</title>
<style type="text/css">
a
		{float:left;width:20px;height:20px;display:block;margin-left:5px;background:url(./resources/images/bont/ObjOnt.png) no-repeat;}
a.min{background-position:-29px 0;}
 a.min:hover{background-position:-29px -29px;}
 a.max{background-position:-60px 0;}
 a.max:hover{background-position:-60px -29px;}
a.revert{background-position:-149px 0;display:none;}
a.revert:hover{background-position:-149px -29px;}
 a.close{background-position:-89px 0;}
a.close:hover{background-position:-89px -29px;}
</style>
</head>
<body>
	<div id="test">
		<a class="min" href="javascript:;" title="最小化"></a> <a class="max"
			href="javascript:;" title="最大化"></a> <a class="revert"
			href="javascript:;" title="还原"></a> <a class="close"
			href="javascript:;" title="关闭"></a>
	</div>
</body>
</html>