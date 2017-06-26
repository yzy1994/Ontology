<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/admin/ecr.js"></script>
</head>
<body>
	<div class="container">
		<div>
			<img id="titleImgId"
				src="resources/images/navigation_images/head-background1.png" />
		</div>
		<div class="list-wrap w-1140 m-t-20">
			<h3>修改意见管理</h3>
			<table class="table table-bordered m-t-20">
				<thead>
					<tr role="row">
						<th>事件类名</th>
						<th>用户名</th>
						<th>Comment</th>
						<th>本体名</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="commentList" id="r" status="st">
						<tr role="row">
							<th><s:property escape="0" value="latname" /></th>
							<th><s:property escape="0" value="username" /></th>
							<th><s:property escape="0" value="comment" /></th>
							<th><s:property escape="0" value="ontname" /></th>
							<th>
								<%-- <button class="btn btn-info editecr" type="button" data-toggle="modal" data-target="#myModal" id="<s:property escape="0" value="ecrid" />">修改</button>
								<button class="btn btn-danger deleteecr" type="button" onclick="window.location.href='ecRelationAction!deleteECRelation?ecrid=<s:property escape="0" value="ecrid" />'">删除</button> --%>
							</th>
						</tr>
					</s:iterator>
				</tbody>
			</table>
			<div>
				<s:property escape="0" value="pagerCode"/>
			</div>

		</div>

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">新建事件类关系</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" role="form" id="ecr_form">
							<div class="form-group">
								<label for="rid" class="col-sm-2 control-label">rid:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="rid"
										placeholder="输入关系ID">
								</div>
							</div>
							<div class="form-group">
								<label for="source" class="col-sm-2 control-label">source:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="source"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="target" class="col-sm-2 control-label">target:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="target"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<label for="ontname" class="col-sm-2 control-label">ontname:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="ontname"
										placeholder="">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-8 col-sm-10">
									<button type="reset" class="btn btn-info">重置</button>
									<button type="submit" class="btn btn-success">提交</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/pages/common/foot.jsp" />
	</div>
</body>
</html>