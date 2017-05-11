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
<title>echarts demo</title>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>
<script src="//cdn.bootcss.com/jquery/2.2.3/jquery.js"></script>
<script type="text/javascript" src="resources/js/bont/ecGraph.js"></script>

</head>
<body>
	<div id="main" style="width: 1000px; height: 800px;"></div>
</body>
<script type="text/javascript">
	LoadECRelationGraph("突发事件本体","main");
</script>
</html>