<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- <!DOCTYPE html>-->
<html xmlns="http://www.w3.org/1999/xhtml">
<base href="<%=basePath%>">
<jsp:include page="../common/header.jsp"></jsp:include>
<head>
<link rel="shortcut icon" href="resources/images/title.ico"
	type="image/x-icon" />
<title>My JSP 'mjolnir.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="resources/css/common.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/label/label.css" />
<link href="resources/css/TabPanel.css" rel="stylesheet" type="text/css" />
<link href="resources/css/leftTab.css" rel="stylesheet" type="text/css" />
<link href="resources/css/zTreeStyle.css" rel="stylesheet"
	type="text/css" />
<link href="resources/css/jquery.autocomplete.css" rel="stylesheet"
	type="text/css" />
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="resources/js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="resources/js/label/label.js"></script>
<script type="text/javascript" src="resources/js/label/upload.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/ajaxfileupload.js"></script>


<script type="text/javascript"
	src="resources/js/plugs/TabPanel/Fader.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/TabPanel/TabPanel.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/TabPanel/Math.uuid.js"></script>
<!--lefttabpanel  -->
<script type="text/javascript" src="resources/js/label/leftTabPanel.js"></script>
<script type="text/javascript" src="resources/js/label/leftTab.js"></script>

<!--righttabpanel  -->
<script type="text/javascript" src="resources/js/label/rightTabPanel.js"></script>
<!-- print -->
<script type="text/javascript" src="resources/js/label/print.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/jquery.PrintArea.js"></script>

<!-- ztree -->
<script type="text/javascript"
	src="resources/js/plugs/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="resources/js/label/labelTree.js"></script>
<script type="text/javascript" src="resources/js/label/insertTree.js"></script>

<script type="text/javascript"
	src="resources/js/plugs/jquery.autocomplete.js"></script>
<script type="text/javascript">
	$(function() {

		var emails = [ {
			name : "Peter",
			to : "peter@pan.de"
		}, {
			name : "Molly",
			to : "molly@yahoo.com"
		}, {
			name : "Forneria",
			to : "live@japan.jp"
		}, {
			name : "Master <em>Sync</em>",
			to : "205bw@samsung.com"
		}, {
			name : "Dr. <strong>Tech</strong> de Log",
			to : "g15@logitech.com"
		}, {
			name : "Don Corleone",
			to : "don@vegas.com"
		}, {
			name : "Mc Chick",
			to : "info@donalds.org"
		}, {
			name : "Donnie Darko",
			to : "dd@timeshift.info"
		}, {
			name : "Quake The Net",
			to : "webmaster@quakenet.org"
		}, {
			name : "Dr. Write",
			to : "write@writable.com"
		}, {
			name : "GG Bond",
			to : "Bond@qq.com"
		}, {
			name : "Zhuzhu Xia",
			to : "zhuzhu@qq.com"
		} ];
		$("#").autocomplete(emails, {
			minChars : 0,//自动完成激活之前填入的最小字符    
			max : 12,//列表条目数           
			width : 400,//提示的宽度             
			scrollHeight : 300,//提示的高度      
			matchContains : true,//是否只要包含文本框里的就可以 
			autoFill : false,//自动填充             
			formatItem : function(data, i, max) {
				//格式化列表中的条目 row:条目对象,i:当前条目数,max:总条目数
				return i + '/' + max + ':"' + data.name + '"[' + data.to + ']';
			},
			formatMatch : function(data, i, max) {
				//配合formatItem使用，作用在于，由于使用了formatItem，所以条目中的内容有所改变，而我们要匹配的是原始的数据，所以用formatMatch做一个调整，使之匹配原始数据
				return data.name + data.to;
			},
			formatResult : function(data) {
				//定义最终返回的数据，比如我们还是要返回原始数据，而不是formatItem过的数据
				return data.to;
			}
		}).result(function(event, data, formatted) {
			alert(data.to);

		});
	});
</script>
<script>
	$(function() {
		var data2 = "the People's Republic of China".split(" ");
		$("#autocomplete2").autocomplete(data2, {
			minChars : 0
		}).result(function(event, data2, formatted) {
			alert(data2);
		});
	});
	function f_DL() {
		location.href = "upload!download.action?filePath=" + "eeeee.txt";
	}
</script>

<script type="text/javascript" src="resources/js/label/hashmap.js"></script>
<script type="text/javascript" src="resources/js/label/ArrayList.js"></script>
<script type="text/javascript" src="resources/js/label/getStrIndex.js"></script>
<script type="text/javascript" src="resources/js/label/imap.js"></script>
<script type="text/javascript" src="resources/js/plugs/insertContent.js"></script>
<script type="text/javascript"
	src="resources/js/plugs/jquery.selection.js"></script>
<script type="text/javascript" src="resources/js/label/judgeTag.js"></script>
<script type="text/javascript" src="resources/js/label/judgeLocation.js"></script>
<script type="text/javascript" src="resources/js/label/judgeElement.js"></script>
<script type="text/javascript" src="resources/js/label/getTagId.js"></script>
<script type="text/javascript" src="resources/js/label/copyText.js"></script>
<script type="text/javascript" src="resources/js/plugs/jquery.zclip.js"></script>
<link href="resources/css/lanrenzhijia.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="resources/js/label/validate.js"></script>
<script type="text/javascript" src="resources/js/label/removeLabel.js"></script>
<script type="text/javascript" src="resources/js/label/selectRange.js"></script>
</head>
<body>
	<div class="container">
		<div>
			<img id="titleImgId"
				src="resources/images/navigation_images/head-background2.png" />
		</div>
		<jsp:include page="/pages/common/nav.jsp" />
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
					<shiro:hasRole name="builder">
						<li id="newId">New</li>
					</shiro:hasRole>
					<shiro:hasRole name="builder">
						<li id="openId">Open</li>
					</shiro:hasRole>
					<shiro:hasRole name="builder">
						<li id="saveId">Save</li>
					</shiro:hasRole>
					<li id="remoteId">Open Remote</li>
					<!--  <li id="saveRTId">Save Remote</li>-->
					<li id="downloadId">download</li>
					<!-- <li id="printId">Print</li>
					<li id="exitId">Exit</li> -->
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
			<!--<table>
		<tr>
			<td><img id="newImgId" src="resources/images/new.png"></img></td>
			<td><img id="openImgId" src="resources/images/open.png"></img></td>
			<td><img id="saveImgId" src="resources/images/save.png"></img></td>
			<td><img id="printImgId" src="resources/images/print.png"></img>
			</td>
			<td><img src="resources/images/gap.png" class="gap"></img></td>
			<td><img id="cutImgId" src="resources/images/cut.png"></img></td>
			<td><img id="copy_input" class="copy" src="resources/images/copy.png"></img></td>
			<td><img id="pasteImgId" src="resources/images/paste.png"></img>
			</td>
			<td><img id="undoImgId" src="resources/images/undo.png"></img></td>
			<td><img id="undoImgId2" src="resources/images/undo.png"></img>
			</td>
			<td><img src="resources/images/gap.png" class="gap"></img></td>
			<td><img id="showImgId" src="resources/images/show.png"></img></td>
			<td><img src="resources/images/gap.png" class="gap"></img></td>
			<td><img id="checkImgId" src="resources/images/check.png"></img>
			</td>
			<td><img id="deleteImgId" src="resources/images/delete.png"></img>
			</td>
			<td>
        
			</td>
		</tr>
	</table>-->

			<shiro:hasRole name="builder">
				<img id="newImgId" src="resources/images/new.png"></img>
			</shiro:hasRole>
			<shiro:hasRole name="builder">
				<img id="openImgId" src="resources/images/open.png"></img>
			</shiro:hasRole>
			<shiro:hasRole name="builder">
				<img id="saveImgId" src="resources/images/save.png"></img>
			</shiro:hasRole>
			<img id="downloadImgId" src="resources/images/download.jpg"></img>
			<!-- <img id="printImgId" src="resources/images/print.png"></img>
			
			 <img src="resources/images/gap.png" class="gap"></img>
			<img id="cutImgId" src="resources/images/cut.png"></img>
			<img id="copy_input"  src="resources/images/copy.png"></img>
			<img id="pasteImgId" src="resources/images/paste.png"></img>
			
			<img id="undoImgId" src="resources/images/undo.png"></img>
			<img id="undoImgId2" src="resources/images/undo.png"></img>-->
			<img src="resources/images/gap.png" class="gap"></img> <img
				id="modelImgId" src="resources/images/manual.jpg"> <img
				src="resources/images/gap.png" class="gap"></img> <img
				id="showImgId" src="resources/images/show.png"></img> <img
				src="resources/images/gap.png" class="gap"></img> <img
				id="checkImgId" src="resources/images/check.png"></img> <img
				id="deleteImgId" src="resources/images/delete.png"></img>
			<!--  <input type="button" id="changeModel" value="手动模式"/> 
			<input type="button" id="downloadId2" value="下载文件"/>
			<input type=button value=保存 onclick="document.execCommand('SaveAs')"/>
			<input type="button" value="验证" onclick="validateXML('textShow')" />
			<input type="button" value="移除标签" onclick="removeLabel('textShow')" />
			<input type="checkbox"/>-->
		</div>
		<div>
			<hr class="hr1"></hr>

		</div>
		<div></div>
		<div id="leftDiv">
			<div class="leftTab">
				<div class="leftNav">
					<ul>
						<li><a href="javascript:void(0)" class="cur">Text</a></li>
						<li><a href="javascript:void(0)">Browser</a></li>
					</ul>
				</div>
				<div class="leftContainer">
					<div class="sub-con" id="textShowDivId">
						<textarea cols="150" rows="33" id="textShow"></textarea>
					</div>
				</div>
			</div>
		</div>
		<div id="rightDiv">
			<div id="rightTab"></div>
		</div>
		<div id="buttomDiv"></div>

		<div class="theme-popover" id="downloadDiv">
			<div class="theme-poptit">
				<a href="javascript:;" title="关闭" class="close">×</a>
				<h3>CEC语料文件下载</h3>
			</div>
			<div class="theme-popbod dform"
				style="overflow-y: auto; height: 250px; width: 500px;"
				id="corpusListId"></div>
		</div>
		<div class="theme-popover-mask" id="downloadDivHide"></div>



		<div class="theme-popover2" id="saveDiv">
			<div class="theme-poptit2">
				<h3>输入新建语料文件的名称</h3>
			</div>
			<div>
				<input type="text" id="saveTextId"> <input type="button"
					id="saveButtonId" align="middle" style="width: 60px;" value="保存" />
			</div>
		</div>
		<div class="theme-popover-mask" id="saveDivHide"></div>


		<!--  <div class="theme-popover" id="saveRTDiv">
     <div class="theme-poptit">
          <a href="javascript:;" title="关闭" class="close4" >×</a>
          <h3>输入保存的文件名(远程)</h3>
     </div>
     <div>
          <input type="text" id="saveRTTextId" style="width: 360px">
		  <input type="button" id="saveRTButtonId" align="middle" style="width: 100px;" value="保存"/>
	 </div>	
</div>
<div class="theme-popover-mask" id="saveRTDivHide"></div>-->



		<div class="theme-popover" id="openRTDiv">
			<div class="theme-poptit">
				<a href="javascript:;" title="关闭" class="close3">×</a>
				<h3>打开服务器语料文件</h3>
			</div>
			<div class="theme-popbod dform"
				style="overflow-y: auto; height: 250px; width: 500px;"
				id="fileTableId"></div>
		</div>
		<div class="theme-popover-mask" id="openRTDivHide"></div>


		<div class="theme-popover2" id="yesOrNoDiv">
			<div class="theme-poptit2">
				<h3>是否保存</h3>
			</div>
			<div>
				<input type="button" id="yesButtonId" align="middle"
					style="width: 100px;" value="是" /> <input type="button"
					id="noButtonId" align="middle" style="width: 100px;" value="否" />
			</div>
		</div>
		<div class="theme-popover-mask" id="yesOrNoDivHide"></div>


		<div class="theme-popover2" id="modelTipDiv">
			<div class="theme-poptit2">
				<a href="javascript:;" title="关闭" class="close6">×</a>
				<h3>模式切换提醒</h3>
			</div>
			<div>
				<h3>请在工具栏切换至手动模式</h3>
			</div>
		</div>
		<div class="theme-popover-mask" id="modelTipDivHide"></div>



		<div class="theme-popover2" id="findDiv">
			<div class="theme-poptit2">
				<a href="javascript:;" title="关闭" class="close7">×</a>
				<h3>请出入所要查询的字符</h3>
			</div>
			<div>
				<input type="text" id="findTextId" /> <input type="button"
					id="findButtonId" align="middle" style="width: 100px;" value="查找" />
			</div>
		</div>

		<div class="theme-popover2" id="replaceDiv">
			<div class="theme-poptit2">
				<a href="javascript:;" title="关闭" class="close8">×</a>
				<h3>请出入所要查询的字符</h3>
			</div>
			<div>
				<input type="text" id="oldTextId" />输入替换的字符 <input type="text"
					id="replaceTextId" />输入新字符 <input type="button"
					id="replaceButtonId" align="middle" style="width: 100px;"
					value="替换" />
			</div>
		</div>

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


		<!--start:
	<input type="text" id="start" size="3" /> end:
	<input type="text" id="end" size="3" />
	<br /> 所选字符：
	<textarea id="text" rows="8" cols="50"></textarea>
	<div id="aaaa">
		
	</div>
	  <a href="#none" class="cp-btn">点击复制单中的文本</a>
	        <a href="javascript:void(0)" 
            class="btn btn-default btn-block btn-clean">复&nbsp;&nbsp;制</a>
	
    <!--  <input value="复制" type="button" class="cp-btn" id="copy_input" align="middle"
	style="width: 100px; height: 30px">-->
		<!--  <input type="text" id="autocomplete" />
	<input type="text" id="autocomplete2" />
	<textarea cols="150" rows="35" id="textShow2" name="contactus"></textarea>-->
	</div>
</body>

</html>
