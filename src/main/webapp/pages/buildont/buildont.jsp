<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>  	
<!--  %
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%-->
<%
	String path = request.getContextPath();
	// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
	pageContext.setAttribute("basePath", basePath);
%>
<!--  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 <!DOCTYPE html>
 <html xmlns="http://www.w3.org/1999/xhtml">-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<head>
<html xmlns="http://www.w3.org/1999/xhtml">
<base href="<%=basePath%>">
<title>My JSP 'mjolnir.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet"
	href="resources/css/buildont/label.css" />
<link href="resources/css/TabPanel.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/leftTab.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/zTreeStyle.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/jquery.autocomplete.css"
	rel="stylesheet" type="text/css" />
<link href="resources/css/buildont/ShowOnt.css"
	rel="stylesheet" type="text/css" />


<link rel="stylesheet" type="text/css" media="screen"
	href="resources/jqGrid/jquery-ui-1.7.2.custom.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/jqGrid/css/ui.jqgrid.css">
<link rel="stylesheet" type="text/css" media="screen"
	href="resources/jqGrid/plugins/ui.multiselect.css">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript"
	src="resources/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript"
	src="resources/js/d3.v3.min.js"></script>
<script type="text/javascript"
	src="resources/js/buildont/buildont.js"></script>
<script type="text/javascript"
	src="resources/js/buildont/CreLoc.js"></script>
<script type="text/javascript"
	src="resources/js/buildont/EventCls.js"></script>
<script type="text/javascript"
	src="resources/js/buildont/ShowOnt.js"></script>
<script type="text/javascript"
	src="resources/js/buildont/ShowLayer.js"></script>
<script type="text/javascript"
	src="resources/js/buildont/OntNodeDeal.js"></script>
<script type="text/javascript"
	src="resources/js/buildont/AddClassInfo.js"></script>
<script type="text/javascript"
	src="resources/js/buildont/ParentSelect.js"></script>
<script type="text/javascript"
	src="resources/js/buildont/ViewClassInfo.js"></script>
<script type="text/javascript"
	src="resources/js/buildont/EditClassInfo.js"></script>
<script type="text/javascript"
	src="resources/js/buildont/Reset.js"></script>
		
<script type="text/javascript"
	src="resources/js/buildont/Action.js"></script>	
<script type="text/javascript"
	src="resources/js/buildont/Assert.js"></script>	
<script type="text/javascript"
	src="resources/js/buildont/Object.js"></script>
<script type="text/javascript"
	src="resources/js/buildont/Lang.js"></script>	
<script type="text/javascript"
	src="resources/js/buildont/Time.js"></script>	
<script type="text/javascript"
	src="resources/js/buildont/Environ.js"></script>			
		
<script type="text/javascript"
	src="resources/js/buildont/SaveClass.js"></script>
	<script type="text/javascript"
	src="resources/js/buildont/SearchClassInfo.js"></script>

		<script type="text/javascript"
	src="resources/js/buildont/RemoveClassInfo.js"></script>
<script type="text/javascript"
	src="resources/js/project/upload.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/ajaxfileupload.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/TabPanel/Fader.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/TabPanel/TabPanel.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/TabPanel/Math.uuid.js"></script>

<script type="text/javascript"
	src="resources/js/plugs/canvg.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/rgbcolor.js"></script>

<!--lefttabpanel  -->
<script type="text/javascript"
	src="resources/js/project/leftTabPanel.js"></script>
<script type="text/javascript"
	src="resources/js/project/leftTab.js"></script>

<!--righttabpanel  -->
<script type="text/javascript"
	src="resources/js/project/rightTabPanel.js"></script>
<!-- print -->
<script type="text/javascript"
	src="resources/js/project/print.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/jquery.PrintArea.js"></script>

<!-- ztree -->
<script type="text/javascript"
	src="resources/js/plugs/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript"
	src="resources/js/project/labelTree.js"></script>
<script type="text/javascript"
	src="resources/js/project/insertTree.js"></script>

<script type="text/javascript"
	src="resources/js/plugs/jquery.autocomplete.js"></script>


<!-- <script src="resources/jqGrid/js/jquery.js"
	type="text/javascript"></script> -->
<script
	src="resources/jqGrid/js/jquery-ui-custom.min.js"
	type="text/javascript"></script>
<script src="resources/jqGrid/js/jquery.layout.js"
	type="text/javascript"></script>
<script
	src="resources/jqGrid/js/i18n/grid.locale-en.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$.jgrid.no_legacy_api = true;
	$.jgrid.useJSON = true;
</script>
<script
	src="resources/jqGrid/plugins/ui.multiselect.js"
	type="text/javascript"></script>
<script src="resources/jqGrid/js/jquery.jqGrid.js"
	type="text/javascript"></script>
<script
	src="resources/jqGrid/js/jquery.jqGrid.min.js"
	type="text/javascript"></script>
<script
	src="resources/jqGrid/plugins/jquery.tablednd.js"
	type="text/javascript"></script>
<script
	src="resources/jqGrid/plugins/jquery.contextmenu.js"
	type="text/javascript"></script>



<script>
	function f_DL() {
		location.href = "upload!download.action?filePath=" + "eeeee.txt";
	}
</script>

<script type="text/javascript"
	src="resources/js/project/hashmap.js"></script>
<script type="text/javascript"
	src="resources/js/project/ArrayList.js"></script>
<script type="text/javascript"
	src="resources/js/project/getStrIndex.js"></script>
<script type="text/javascript"
	src="resources/js/project/imap.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/insertContent.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/jquery.selection.js"></script>
<script type="text/javascript"
	src="resources/js/project/judgeTag.js"></script>
<script type="text/javascript"
	src="resources/js/project/judgeLocation.js"></script>
<script type="text/javascript"
	src="resources/js/project/judgeElement.js"></script>
<script type="text/javascript"
	src="resources/js/project/getTagId.js"></script>
<script type="text/javascript"
	src="resources/js/project/copyText.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/jquery.zclip.js"></script>
<!--  <link href="resources/css/lanrenzhijia.css"
	rel="stylesheet" type="text/css" />-->
<script type="text/javascript"
	src="resources/js/project/validate.js"></script>
<script type="text/javascript"
	src="resources/js/project/removeLabel.js"></script>
<script type="text/javascript"
	src="resources/js/project/selectRange.js"></script>


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


		<img id="newImgId" src="resources/images/new.png"></img>
		<img id="openImgId"
			src="resources/images/open.png"></img> <img
			id="saveImgId" src="resources/images/save.png"></img>
		<img id="downloadImgId"
			src="resources/images/download.jpg"></img> <img
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
	<div >
		<div class="theme-popover12" id="dealDiv">
		<div class="theme-poptit" style="border-top: 1px solid;">
			
			<h3 style="border-bottom: 1px solid;text-align:center;">事件类的相关操作</h3>
			<span class="selectLable"
				>领域选择</span> <select
				id="fieldSel4" class="selectOption" style="margin-left: 50px;">
				<option value="emergency">突发事件领域</option>
				<option value="2">财经领域</option>
			</select> <span class="selectLable" style="margin-left: 50px;">本体类型选择</span> <select
				id="classSel4" class="selectOption" style="margin-left: 50px;">
				<option value="event">事件本体</option>
				<option value="2">对象本体</option>
			</select> <br></br> <input type="button" class="selectLable"
				id="searchButtonId5" align="middle"
				 value="查找" /> <input
				type="button" class="selectLable" id="detailBT" align="middle"
				style="width: 50px; margin-left: 50px;" value="详情查看" /> 
				<shiro:hasRole name="builder">
				<input
				type="button" class="selectLable" id="addBT" align="middle"
				style="width: 50px; margin-left: 50px;" value="增加" /> </shiro:hasRole>
				<shiro:hasRole name="builder">
				<input
				type="button" class="selectLable" id="editBT" align="middle"
				style="width: 50px; margin-left: 50px;" value="编辑" /> </shiro:hasRole>
				<shiro:hasRole name="builder">
				<input
				type="button" class="selectLable" id="removeBT" align="middle"
				style="width: 50px; margin-left: 50px;" value="删除" /> </shiro:hasRole>
		</div>
		<div class="theme-popbod dform12" >

			<table id="showDetail" tabindex="0" cellspacing="0" cellpadding="0"
				border="0" role="grid" aria-multiselectable="false"
				aria-labelledby="gbox_navgrid4" class="ui-jqgrid-btable"
				style="width: 800px;">
				<tbody>
					<tr class="jqgfirstrow" role="row" style="height: auto">
						<td role="gridcell" style="height: 0px; width: 53px;">
			</table>
			<div id="showDetailPage"></div>

			<script
				src="resources/js/buildont/ShowDetail.js"
				type="text/javascript">
				
			</script>
		</div>
	</div>

	
	</div>

	<div id="buttomDiv" ></div>




	<div class="theme-popover" id="saveDiv"
		style="width: 300px; height: 230px; left: 60%;">
		<div class="theme-poptit">
			<a href="javascript:;" title="关闭" class="close">×</a>
			<h3>请输入事件及相关类的名称</h3>
		</div>
		<div>
			<select id="fieldSel" class="selectOption">
				<option value="1">突发事件领域</option>
				<option value="2">财经领域</option>
			</select> <span class="selectLable">领域选择</span> <br></br> <select
				id="classSel" class="selectOption">
				<option value="1">事件本体</option>
				<option value="2">对象本体</option>
			</select> <span class="selectLable">本体类型选择</span> <br></br> <input type="text"
				id="classNameId" align="middle" style="width: 100px;"
				class="selectOption" /> <span class="selectLable"
				style="margin-left: 50px;">类名称</span> <br></br> <input type="text"
				id="classIdId" align="middle" style="width: 100px;"
				class="selectOption" /> <span class="selectLable"
				style="margin-left: 60px;">类ID</span> <br></br> <input type="button"
				class="selectLable" id="saveButtonId" align="middle"
				style="width: 60px; margin-left: 120px;" value="保存" />
		</div>
	</div>
	<div class="theme-popover-mask" id="saveDivHide"></div>


	<div class="theme-popover" id="openRTDiv">
		<div class="theme-poptit">
			<a href="javascript:;" title="关闭" class="close">×</a>
			<h3 style="border-bottom: 1px solid;">打开服务器事件及相关要素类</h3>
			<span class="selectLable"
				style="position: relative; margin-left: 60px;">领域选择</span> <select
				id="fieldSel2" class="selectOption">
				<option value="1">突发事件领域</option>
				<option value="2">财经领域</option>
			</select> <span class="selectLable">本体类型选择</span> <select id="classSel2"
				class="selectOption">
				<option value="1">事件本体</option>
				<option value="2">对象本体</option>
			</select> <input type="button" class="selectLable" id="searchButtonId"
				align="middle" style="width: 60px;" value="查找" />
		</div>
		<div class="theme-popbod dform"
			style="overflow-y: auto; height: 250px; width: 500px;"
			id="fileTableId"></div>
	</div>
	<div class="theme-popover-mask" id="openRTDivHide"></div>


	<div class="theme-popover" id="downloadDiv">
		<div class="theme-poptit">
			<a href="javascript:;" title="关闭" class="close">×</a>
			<h3>服务器事件及相关要素类文件下载</h3>
			<span class="selectLable"
				style="position: relative; margin-left: 60px;">领域选择</span> <select
				id="fieldSel3" class="selectOption">
				<option value="1">突发事件领域</option>
				<option value="2">财经领域</option>
			</select> <span class="selectLable">本体类型选择</span> <select id="classSel3"
				class="selectOption">
				<option value="1">事件本体</option>
				<option value="2">对象本体</option>
			</select> <input type="button" class="selectLable" id="searchButtonId3"
				align="middle" style="width: 60px;" value="查找" />
		</div>
		<div class="theme-popbod dform"
			style="overflow-y: auto; height: 250px; width: 500px;"
			id="corpusListId"></div>
	</div>
	<div class="theme-popover-mask" id="downloadDivHide"></div>










	<div class="theme-popover" id="infoDiv"
		style="width: 1200px; height: 650px; top: 35%; left: 30%; overflow-x: auto;">
		<div class="theme-poptit" style="border-top: 1px solid;">
			<a href="javascript:;" title="关闭" class="close2">×</a>

			<h3 style="border-bottom: 1px solid;">事件类的详细操作</h3>
		</div>
		<input type="button" class="selectLable" id="saveClassBT"
			align="middle" style="width: 60px; margin-left: 1030px;" value="保存" />
		<div class="theme-popbod dform">


			<table border="1" style="overflow-x: auto;">


				<tr>

					<td style="width: 500px;">
						<div style="overflow-x: auto; width: 500px;">
							<span class="selectLable" style="margin-left: 10px;">事件类ID</span>
							<input id="eidIPT" type="text" align="middle"
								style="width: 50px; margin-left: 10px;" /> <span
								class="selectLable"
								style="position: relative; margin-left: 10px;">事件类名称</span> <input
							id="ecnIPT"	type="text" class="selectLable" align="middle"
								style="width: 50px; margin-left: 10px;" /> <br></br>
							<fieldset style="left: 10px;">
								<legend style="text-align: left;">父类选择</legend>
								<table border="0">
									<form onSubmit="allSelect()">
										<tr>
											<td><select name="possible" size="4" MULTIPLE width=200
												style="width: 200px">
												    <option value="0">突发事件</option>
													<option value="1">地震</option>
													<option value="2">火灾</option>
													<option value="3">交通事故</option>
													<option value="4">恐怖袭击</option>
													<option value="5">食物中毒</option>
											</select></td>
											<td><a href="javascript:copyToList('possible','chosen')">添加至右方-->



											</a><a href="javascript:copyToList('chosen','possible')"><--添加至左方</a></td>
											<td><select id="parentSlt" name="chosen" size="4" MULTIPLE width=200
												style="width: 200px;">
													<option value="temp">从左边选择你的地区</option>
											</select></td>
										</tr>
									</form>
								</table>
							</fieldset>
						</div>
					</td>

					<td>
											<div style="overflow-x: auto; width: 500px;">
							<fieldset style="margin-left: 10px;">
								<legend style="text-align: left;">环境要素</legend>
								<label>环境类型</label>
								<select id="classSel5" class="selectOption">
									<option value="1">虚拟环境</option>
									<option value="2">地理区域</option>
								</select>
								<label>继承类</label>
								<select id="classSel6" class="selectOption">
									<option value="1">高速公路</option>
									<option value="2">北京郊区</option>
								</select>
							</fieldset>
						</div>
					
						<div style="overflow-x: auto; width: 500px;">
							<fieldset style="margin-left: 10px;">
								<legend style="text-align: left;">时间要素</legend>
								<label>时间类型</label>
				<select id="classSel7" class="selectOption">
									<option value="1">确切时间</option>
									<option value="2">模糊时间</option>
								</select>
							</fieldset>
						</div>
					
					</td>
				</tr>
				<tr>
					<td>
						<div style="overflow-x: auto; width: 500px;">
							<fieldset>
								<legend style="text-align: left;">对象要素</legend>
								<table id="ObjectDetail" tabindex="0" cellspacing="0"
									cellpadding="0" border="0" role="grid"
									aria-multiselectable="false" aria-labelledby="gbox_navgrid4"
									class="ui-jqgrid-btable" style="width: 657px;">
									<tbody>
										<tr class="jqgfirstrow" role="row" style="height: auto">
											<td role="gridcell" style="height: 0px; width: 53px;">
								</table>
								<div id="ObjectDetailPage"></div>

								<script
									src="resources/js/buildont/ObjectDetail.js"
									type="text/javascript">
									
								</script>
							</fieldset>
						</div>
					</td>

					<td>
						<div style="overflow-x: auto; width: 500px;">
							<fieldset style="margin-left: 10px;">
								<legend style="text-align: left;">动作要素</legend>
								<table id="ActionDetail" tabindex="0" cellspacing="0"
									cellpadding="0" border="0" role="grid"
									aria-multiselectable="false" aria-labelledby="gbox_navgrid4"
									class="ui-jqgrid-btable" style="width: 657px;">
									<tbody>
										<tr class="jqgfirstrow" role="row" style="height: auto">
											<td role="gridcell" style="height: 0px; width: 53px;">
								</table>
								<div id="ActionDetailPage"></div>

								<script
									src="resources/js/buildont/ActionDetail.js"
									type="text/javascript">
									
								</script>
							</fieldset>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div style="overflow-x: auto; width: 500px;">
							<fieldset>
								<legend style="text-align: left;">断言要素</legend>
								<table id="AssertDetail" tabindex="0" cellspacing="0"
									cellpadding="0" border="0" role="grid"
									aria-multiselectable="false" aria-labelledby="gbox_navgrid4"
									class="ui-jqgrid-btable" style="width: 657px;">
									<tbody>
										<tr class="jqgfirstrow" role="row" style="height: auto">
											<td role="gridcell" style="height: 0px; width: 53px;">
								</table>
								<div id="AssertDetailPage"></div>

								<script
									src="resources/js/buildont/AssertDetail.js"
									type="text/javascript">
									
								</script>
							</fieldset>
						</div>
					</td>

					<td>
						<div style="overflow-x: auto; width: 500px;">
							<fieldset style="margin-left: 10px;">
								<legend style="text-align: left;">语言表现要素</legend>
								<table id="LangDetail" tabindex="0" cellspacing="0"
									cellpadding="0" border="0" role="grid"
									aria-multiselectable="false" aria-labelledby="gbox_navgrid4"
									class="ui-jqgrid-btable" style="width: 657px;">
									<tbody>
										<tr class="jqgfirstrow" role="row" style="height: auto">
											<td role="gridcell" style="height: 0px; width: 53px;">
								</table>
								<div id="LangDetailPage"></div>

								<script
									src="resources/js/buildont/LangDetail.js"
									type="text/javascript">
									
								</script>
							</fieldset>
						</div>
					</td>
				</tr>
			</table>

			<table id="infoTB" tabindex="0" cellspacing="0" cellpadding="0"
				border="0" role="grid" aria-multiselectable="false"
				aria-labelledby="gbox_navgrid4" class="ui-jqgrid-btable"
				style="width: 657px;">
				<tbody>
					<tr class="jqgfirstrow" role="row" style="height: auto">
						<td role="gridcell" style="height: 0px; width: 53px;">
			</table>
			<div id="infoPage"></div>
		</div>
	</div>
	<div class="theme-popover-mask" id="infoDivHide"></div>


	<div id="hiddenDiv">
		<iframe id="fra"></iframe>
		<table id="fileTable">
			<tr>
				<td width="70%"><input type="file" name="upload"
					id="file_upload" style="width: 360px"></td>
				<td colspan="2" align="right"><input value="UPLOAD"
					type="button" id="btn_upload" align="middle"
					style="width: 100px; height: 30px"></td>
			</tr>
		</table>
	</div>


	<div class="ShowOnt-popover" id="showDiv">
		<div class="ShowOnt-poptit" id="showSonDiv">
			<a href="javascript:;" title="关闭" class="close">×</a>
			<h3 id="showTitle">事件类图形展示</h3>
			<span class="selectLable"
				style="position: relative; margin-left: 60px;">领域选择</span> <select
				id="fieldSel4" class="selectOption">
				<option value="1">突发事件领域</option>
				<option value="2">财经领域</option>
			</select> <span class="selectLable">本体类型选择</span> <select id="classSel4"
				class="selectOption">
				<option value="1">事件本体</option>
				<option value="2">对象本体</option>
			</select> <input type="button" class="selectLable" id="searchButtonId4"
				align="middle" style="width: 60px;" value="查找" /> <input value="放大"
				type="button" class="cp-btn" id="zoomIn" align="middle"
				style="width: 100px; height: 20px; margin-left: 60px;"> <input
				value="缩小" type="button" class="cp-btn" id="zoomOut" align="middle"
				style="width: 100px; height: 20px"> <input value="截图"
				type="button" class="cp-btn" id="cutImg" align="middle"
				style="width: 100px; height: 20px">
		</div>
		<div class="ShowOnt-svg" id="svgDiv"></div>
	</div>
	<div class="ShowOnt-popover-mask" id="showDivHide"></div>


</body>

</html>
