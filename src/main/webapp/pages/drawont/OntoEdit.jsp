<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<head>
<html xmlns="http://www.w3.org/1999/xhtml">
<base href="<%=basePath%>">
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

<link rel="stylesheet" type="text/css" media="screen"
	href="resources/css/jquery-ui-min.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/jqGrid/css/ui.jqgrid.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/jqGrid/plugins/ui.multiselect.css">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link href="resources/css/bont/ontoedit/ontoedit.css" rel="stylesheet"
	type="text/css" />
<link rel="stylesheet" href="resources/css/bont/Bont.css" />

<link rel="stylesheet" href="resources/css/bont/ObjOntLatForm.css" />

<script type="text/javascript" src="resources/js/bont/ObjOntSvg.js"></script>

<script type="text/javascript" src="resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="resources/js/bont/ontoedit/load.js"></script>
<script type="text/javascript"
	src="resources/js/bont/ontoedit/addont.js"></script>
<script type="text/javascript" src="resources/js/bont/ontoedit/form.js"></script>
<script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
<script type="text/javascript" src="resources/js/ajaxfileupload.js"></script>
</head>
<body>
	<div>
		<img id="titleImgId"
			src="resources/images/buildont/titleTextBuild.png"
			style="vertical-align: bottom;" />
	</div>
	<div class="navv">
		<!--nav-->
		<!--导航条-->
		<ul class="nav-main">
			<li id="li-1">File<span></span></li>
			<li id="li-2">Edit<span></span></li>
			<li id="li-3">Tools<span></span></li>
			<li id="li-4">Format<span></span></li>
			<li id="li-5">Help<span></span></li>
			<li id="li-6">Contact Us<span></span></li>
		</ul>
		<div id="box-1" class="hidden-box hidden-loc-file">
			<ul>
				<li id="newId">New</li>
				<li id="remoteId">Open Remote</li>
				<li id="downloadId">download</li>
				<li id="testId">showOnt</li>
				<li id="OntNodeDeal">new ontnode</li>
			</ul>
		</div>
		<!--隐藏盒子-->
		<div id="box-2" class="hidden-box hidden-loc-edit">
			<ul>
				<!--<li>Undo</li>
					<li>Redo</li>
					<li>Cut</li>
					<li>Copy</li>
					<li>Paste</li>
					
					<li id="nextId">Find Next</li>-->
				<li id="findId">Find</li>
				<li id="replaceId">Replace</li>
				<!--<li>Select All</li>-->
			</ul>
		</div>
		<div id="box-3" class="hidden-box hidden-loc-tools">
			<ul>
				<li id="checkId">Check XML File</li>
				<li id="deleteId">Remove All Label</li>
			</ul>
		</div>
		<div id="box-4" class="hidden-box hidden-loc-format">
			<ul>
				<!-- <li>AutoWrap</li>
					<li>Font(F)</li>
					<li>OnTop</li> -->
				<li id="showId">Format File</li>
				<li id="readOnlyId"><input type="checkbox" id="readOnlyCBId" />Read
					Only</li>

			</ul>
		</div>
		<div id="box-5" class="hidden-box hidden-loc-help">
			<ul>
				<li>About</li>
			</ul>
		</div>
		<div id="box-6" class="hidden-box hidden-loc-contact">
			<ul>
				<li>Email</li>
				<li>TelePhone</li>
				<li>Address</li>
			</ul>
		</div>
	</div>
	<div>
		<hr class="hr1"></hr>
	</div>
	<div>


		<img id="newImgId" src="resources/images/new.png"></img> <img
			id="openImgId" src="resources/images/open.png"></img> <img
			id="saveImgId" src="resources/images/save.png"></img> <img
			id="downloadImgId" src="resources/images/download.jpg"></img> <img
			src="resources/images/gap.png" class="gap"></img> <img
			id="modelImgId" src="resources/images/manual.jpg"> <img
			src="resources/images/gap.png" class="gap"></img> <img id="showImgId"
			src="resources/images/show.png"></img> <img
			src="resources/images/gap.png" class="gap"></img> <img
			id="checkImgId" src="resources/images/check.png"></img> <img
			id="deleteImgId" src="resources/images/delete.png"></img>
	</div>
	<div>
		<hr class="hr1"></hr>

	</div>
	<div>
		<div class="theme-popover12" id="dealDiv">
			<div class="theme-poptit" style="border-top: 1px solid;">
				<h3 style="border-bottom: 1px solid; text-align: center;">本体的相关操作</h3>
				<br /> <label class="newOnt" id="newOnt">新建本体</label> <input
					type="file" name="file" id="file" /> <label
					class="newOnt" id="importOnt">导入本体</label>
			</div>
			<div class="theme-popbod ontform">

				<table id="showDetail" tabindex="0" cellspacing="0" cellpadding="0"
					border="0" role="grid" aria-multiselectable="false"
					aria-labelledby="gbox_navgrid4" text-align="left"
					style="width: 800px;">
					<tbody id="tbo">
						<tr>
							<td>本体名称</td>
							<td>应用领域</td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>


	</div>
	<div id="buttomDiv"></div>
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

					<li id="lielement"><label for="element">本体要素：</label> <label
						class="formcheckbox"><input class="formcheckbox"
							name="element" type="checkbox" value="参与者">参与者</label> <label
						class="formcheckbox"><input class="formcheckbox"
							name="element" type="checkbox" value="环境">环境</label> <label
						class="formcheckbox"><input class="formcheckbox"
							name="element" type="checkbox" value="对象">对象</label></li>
					<li>
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
</body>

</html>
