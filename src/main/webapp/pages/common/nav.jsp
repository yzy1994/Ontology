<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<div class="header-bottom w-1140">
	<ul id="webmenu" class="first-menu">
		<li><a href="pages/index.jsp">首页</a></li>
		<li><a href="pages/drawont/OntoEdit.jsp">事件本体本体构建工具</a></li>
		<li><a href="pages/label/label.jsp">文本事件标注工具</a></li>
		<li><a href="pages/corpus_profile.jsp">中文事件语料库</a></li>
		<li><a href="pages/reference.jsp">事件本体研究团队</a></li>
		<shiro:guest>
			<li><a href="pages/login/Login.jsp">登录</a></li>
		</shiro:guest>
		<shiro:hasRole name="builder">
			<li><a href="userAction2!logout.action">登出</a></li>
		</shiro:hasRole>
	</ul>
</div>