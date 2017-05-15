<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
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

<link href="resources/css/index.css" rel="stylesheet">
<link href="resources/css/common.css" rel="stylesheet">


<script type="text/javascript" src="resources/js/common/ArrayList.js"></script>
<script type="text/javascript" src="resources/js/common/ObjOntGV.js"></script>
<script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="resources/js/bont/ontoedit/load.js"></script>
<script type="text/javascript"
	src="resources/js/bont/ontoedit/addont.js"></script>
<script type="text/javascript" src="resources/js/bont/ontoedit/form.js"></script>
<script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
<script type="text/javascript" src="resources/js/ajaxfileupload.js"></script>
</head>
<body>
	<div class="container">
		<div>
			<img id="titleImgId"
				src="resources/images/navigation_images/head-background2.png" />
		</div>

		<jsp:include page="/pages/common/nav.jsp" />

		<div class="list-wrap m-t-20 h-600 w-1140">
			<b class="top-title">本体管理</b>

			<div class="ontform m-t-20">
				<shiro:hasRole name="builder"><button type="button" class="button  btn-success" id="addOnt">新建本体</button>
				<button type="button" class="button  btn-success" id="importo">导入本体</button></shiro:hasRole>
			</div>
			<!-- <input
						type="file" name="file" id="file" /> <label class="newOnt"
						id="importOnt">导入本体</label> -->
			<div class="ontform m-t-20">
				<table class="table table-hover ">
					<tbody id="tbo">
						<tr class="success">
							<td>本体名称</td>
							<td>应用领域</td>
							<td>操作</td>
						</tr>
						<s:iterator value="ontlist" id="r" status="st">
							<tr>
								<td><a class="bont" id="<s:property escape="0" value="name"/>" href="pages/drawont/Bont.jsp" >
										<s:property escape="0" value="name" />
									</a>
								</td>
								<td>
									<s:property escape="0" value="field"/>
								</td>
								<td>
									<shiro:hasRole name="builder"><button type="button" class="button  btn-danger delbtn" id="<s:property escape="0" value="name"/>">删除本体</button></shiro:hasRole>
									&nbsp
									<button type="button" class="button  btn-primary exportbtn" id="<s:property escape="0" value="name"/>">导出本体</button>
									&nbsp
									<button type="button" class="button  btn-info infobtn" id="<s:property escape="0" value="name"/>">编辑本体</button>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>

		<div class="dealObjOntLat-popover" id="dealObjOntLat"
			style="width: 400px; height: 280px; display: block;">
			<div class="dealObjOntLat-poptit">
				<a href="javascript:;" title="关闭" class="close" id="dealclose">×</a>
				<h3 id="showTitle">创建本体</h3>
			</div>
			<div>
				<form id="objOntLatForm" class="contact_form" method="post"
					name="contact_form">
					<ul>
						<li id="liname"><label for="ontname">本体名称:</label> <input
							name="ontname" type="text" placeholder="o1" required="required"
							id="ontname"></li>

						<li id="lifield"><label for="ontfield">应用领域:</label> <input
							name="ontfield" type="text" placeholder="参与者" required="required"
							id="ontfield"></li>

						<button class="submit" type="submit" id="saveOnt">保存</button>
						<button class="submit" type="reset" id="resetOnt">重置</button>
						</li>

					</ul>
				</form>
			</div>
		</div>

		<div class="dealObjOntLat-popover" id="delalert"
			style="width: 400px; height: 280px; display: block;">
			<div class="dealObjOntLat-poptit">
				<a href="javascript:;" title="关闭" class="close" id="dclose">×</a>
				<h3>对话框</h3>
			</div>
			<div>
				<p>确定要删除这个本体吗?</p>
			</div>
			<form id="delOntForm" class="contact_form" method="post"
				name="contact_form">
				<li>
					<button class="submit" type="submit" id="delsubmit">确定</button>
					<button class="submit" type="input" id="delcancel">取消</button>
				</li>
			</form>
		</div>
		<jsp:include page="/pages/common/foot.jsp" />
	</div>
</body>

</html>
