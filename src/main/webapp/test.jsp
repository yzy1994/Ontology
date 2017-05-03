<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<shiro:user><input type="button" value="登陆用户"/></shiro:user>
	<shiro:guest><input type="button" value="游客"/></shiro:guest>
	<shiro:hasRole name="builder"><input type="button" value="builder"/></shiro:hasRole>
	<shiro:hasRole name="normal_user"><input type="button" value="normal_user"/></shiro:hasRole>
	<input type="file" />
</body>
</html>