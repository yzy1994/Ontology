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
				<shiro:hasRole name="builder">
					<button type="button" class="button  btn-success" id="addOnt">新建本体</button>
					<button type="button" class="button  btn-success" id="importo">导入本体</button>
				</shiro:hasRole>
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
								<td><s:property escape="0" value="name" /></td>
								<td><s:property escape="0" value="field" /></td>
								<td><shiro:hasRole name="builder">
										<button type="button" class="button  btn-danger delbtn"
											id="<s:property escape="0" value="name"/>">删除本体</button>
									&nbsp
									<button type="button" class="button  btn-info editbtn"
											id="<s:property escape="0" value="name"/>">编辑本体</button>
									&nbsp
									</shiro:hasRole> <shiro:lacksRole name="builder">
										<button type="button" class="button  btn-info infobtn"
											id="<s:property escape="0" value="name"/>">查看本体</button>
									&nbsp
									</shiro:lacksRole>
									<button type="button" class="button  btn-primary exportbtn"
										id="<s:property escape="0" value="name"/>">导出本体</button></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>

		<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">新建事件本体</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" role="form" id="ontInfoForm">
							<div class="form-group">
								<label for="name" class="col-sm-2 control-label">本体名称:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="name"
										placeholder="ontology name">
								</div>
							</div>
							<div class="form-group">
								<label for="field" class="col-sm-2 control-label">应用领域:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="field"
										placeholder="field">
								</div>
							</div>
							<div class="form-group">
								<label for="latname" class="col-sm-2 control-label">顶层事件类:</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="latname"
										placeholder="latname">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-8 col-sm-10">
									<button type="reset" class="button btn-info">重置</button>
									&nbsp
									<button type="submit" class="button btn-success">提交</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="removeModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">×</span>
						</button>
						<h4 class="modal-title">对话框</h4>
					</div>
					<div class="modal-body">
						<h5>确定要删除这个本体吗?</h5>
					</div>
					<div class="modal-footer">
						<button type="button" class="button btn-info" data-dismiss="modal">取消</button>
						&nbsp<button type="button" class="button btn-primary" id="delsubmit">确定</button>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/pages/common/foot.jsp" />
	</div>
</body>

</html>
