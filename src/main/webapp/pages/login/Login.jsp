<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>	
<%
	String path = request.getContextPath();
	// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
	pageContext.setAttribute("basePath", basePath);
	String username = request.getParameter("username");//用request得到 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<head>
<link rel="shortcut icon" href="resources/images/title.ico" type="image/x-icon" />
<html xmlns="http://www.w3.org/1999/xhtml,http://www.w3.org/2000/svg">
<base href="<%=basePath%>">
<title>My JSP 'mjolnir.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="resources/css/login/Main.css" />
<link rel="stylesheet" href="resources/css/login/Login.css" />
<script type="text/javascript" src="resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="resources/js/login/Login.js"></script>
<script type="text/javascript" src="resources/js/login/UserInfo.js"></script>
</head>
<body>
	<div>
		
		<div class="centerLogin"
			style="background-image: url(resources/images/login/login.png);">
			<ul class="login">
				<form action="userAction2!login.action" method="post">
					<p>${message }</p>
					<li><span class="left">用户名：</span> <span style=""> <input
							id="username" name="username" type="text" class="txt" />
					</span></li>
					<li><span class="left">密 码： </span> <span style=""> <input
							id="password" name="password" type="password" class="txt" />
					</span></li>
			</ul>
			<img id="loginBT" class="btn" src="resources/images/login/btnlogin.gif" /> 
			<input id="submitBt" type="submit" value="提交">
			</form>
		</div>
	</div>
</body>
</html>