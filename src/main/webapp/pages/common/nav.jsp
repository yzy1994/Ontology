<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<div class="header-bottom w-1140">
	<ul id="webmenu" class="first-menu">
		<li><a href="index.html">首页</a></li>
		<li><a href="tool/ontoedit.html">事件本体本体构建工具</a></li>
		<li><a href="tool/label.html">文本事件标注工具</a></li>
		<li><a href="corpus.html">中文事件语料库</a></li>
		<li><a href="reference.html">事件本体研究团队</a></li>
		<shiro:guest>
			<li><a href="pages/login/Login.jsp">登录</a></li>
		</shiro:guest>
		<shiro:authenticated>
			<li><a href="userAction2!logout.action">登出</a></li>
		</shiro:authenticated>
	</ul>
</div>