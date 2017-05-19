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
<!--  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
 <!DOCTYPE html>
 <html xmlns="http://www.w3.org/1999/xhtml">-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<base href="<%=basePath%>">
<jsp:include page="../common/header.jsp"></jsp:include>
<head>
<link rel="shortcut icon" href="resources/images/title.ico"
	type="image/x-icon" />
<html xmlns="http://www.w3.org/1999/xhtml">
<title>可视化本体构建工具</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="resources/css/index.css" />
<link href="resources/css/common.css" rel="stylesheet">
<link rel="stylesheet" href="resources/css/common/Nav.css" />
<link rel="stylesheet" href="resources/css/bont/ObjOntWin.css" />
<link rel="stylesheet" href="resources/css/bont/ObjOntLatForm.css" />
<link rel="stylesheet" href="resources/css/leftmenu/LeftMenu.css" />
<link rel="stylesheet" href="resources/css/tab/Tab.css" />
<link rel="stylesheet" href="resources/css/content/Content.css" />
<link rel="stylesheet" type="text/css"
	href="resources/css/bottom/Bottom.css" media="all">
<link rel="stylesheet" href="resources/css/bont/Bont.css" />

<script type="text/javascript" src="resources/js/svg.min.js"></script>
<script type="text/javascript" src="resources/js/svg.draggable.js"></script>
<script src="//cdn.bootcss.com/jquery/2.2.3/jquery.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.svg.js"></script>
<script type="text/javascript" src="resources/js/jquery.svgdom.js"></script>
<script type="text/javascript" src="resources/js/jquery.svganim.js"></script>
<script type="text/javascript" src="resources/js/jquery.color.js"></script>
<script type="text/javascript" src="resources/js/jquery.cookie.js"></script>
<script type="text/javascript" src="resources/js/common/NavMenu.js"></script>
<script type="text/javascript" src="resources/js/common/ArrayList.js"></script>
<script type="text/javascript" src="resources/js/common/Config.js"></script>
<script type="text/javascript" src="resources/js/common/ObjOntGV.js"></script>
<script type="text/javascript" src="resources/js/leftmenu/LeftMenu.js"></script>
<script type="text/javascript" src="resources/js/tab/Tab.js"></script>
<script type="text/javascript" src="resources/js/bont/setCookie.js"></script>

<script type="text/javascript" src="resources/js/bont/ObjOntWin.js"></script>
<script type="text/javascript" src="resources/js/bont/ObjOntSvg.js"></script>
<script type="text/javascript" src="resources/js/bont/EventCls.js"></script>
<script type="text/javascript" src="resources/js/bont/Time.js"></script>
<script type="text/javascript" src="resources/js/bont/Obj.js"></script>
<script type="text/javascript" src="resources/js/bont/Lang.js"></script>
<script type="text/javascript" src="resources/js/bont/Assert.js"></script>
<script type="text/javascript" src="resources/js/bont/Environ.js"></script>
<script type="text/javascript" src="resources/js/bont/ShowLayer.js"></script>
<script type="text/javascript" src="resources/js/bont/CreLoc.js"></script>
<script type="text/javascript" src="resources/js/bont/DrawOntLat.js"></script>
<script type="text/javascript" src="resources/js/bont/DrawMarker.js"></script>
<script type="text/javascript" src="resources/js/bont/RGBrush.js"></script>
<script type="text/javascript" src="resources/js/bont/DrawConLine.js"></script>
<script type="text/javascript" src="resources/js/bont/ObjOntLatForm.js"></script>
<script type="text/javascript" src="resources/js/bont/ObjOntLat.js"></script>
<script type="text/javascript" src="resources/js/canvg.js"></script>
<script type="text/javascript" src="resources/js/rgbcolor.js"></script>
<script type="text/javascript" src="resources/js/bont/ViewObjOnt.js"></script>
<script type="text/javascript" src="resources/js/bont/Dictionary.js"></script>

<script src="resources/js/jquery.contextify.js" type="text/javascript"></script>


</head>
<body>
	<div class="container">
		<div>
			<img id="titleImgId"
				src="resources/images/navigation_images/head-background2.png" />
		</div>
		<jsp:include page="/pages/common/nav.jsp" />
		<div class="row m-t-20 clearfix">
			<div class="col-xs-3">
				<div class="leftsidebar_box">
					<!-- <div class="line"></div> -->
					<dl class="channel">
						<shiro:lacksRole name="builder">
							<dt id="EveOnt" class="viewOnt">查看事件类层次图</dt>
						</shiro:lacksRole>
						<shiro:hasRole name="builder">
							<dt id="EveOnt" class="editOnt">编辑事件类层次图</dt>
						</shiro:hasRole>
					</dl>

					<dl class="system_log" id="概念">
						<shiro:lacksRole name="builder">
							<dt id="Concept" class="viewOnt">查看概念层次图</dt>
						</shiro:lacksRole>
						<shiro:hasRole name="builder">
							<dt id="Concept" class="editOnt">编辑概念层次图</dt>
						</shiro:hasRole>
					</dl>

					<dl class="cloud">
						<dt id="ecRelation">非分类关系图</dt>
					</dl>



				</div>
			</div>
			<div class="col-xs-9">
				<div>
					<ul id="myTab" class="nav nav-tabs">
						<li class="active"><a href="#tab0" data-toggle="tab">操作指南</a></li>
						<li><a href="#tab1" data-toggle="tab">关于事件本体</a></li>
					</ul>
					<div id="myTabContent" class="tab-content clearfix list-wrap">
						<div class="tab-pane fade in active m-t-20" id="tab0">
							<div class="artical-title">
								当前操作的本体: <i><span class="ontname"></span></i>
							</div>
							<hr>
							<div class="artical-title">编辑事件类层次图</div>
							<div class="markdown">创建（修改）事件类，建立事件类之间的层次关系（上下位关系）。</div>
							<div class="artical-title">编辑概念层次图</div>
							<div class="markdown">建立事件本体中的概念，并且建立概念之间的层次关系，事件类中包含的人物、对象（物体）、地点都属于概念。</div>
							<div class="artical-title">非分类关系图</div>
							<div class="markdown">建立事件本体中事件类之间的非分类关系，例如事件类和事件类之间的因果关系、跟随关系、组成关系、并发关系等。</div>
							<div class="artical-title">其他</div>
							<div class="markdown">正在开发中。。。</div>
						</div>
						<div class="tab-pane fade m-t-20" id="tab1">
							<img id="EOimg" src="resources/images/bont/EO.png" />
							<div class="artical-title">事件</div>
							<div class="markdown">
								事件指在某个特定的时间和环境下发生的、由若干角色参与、表现出若干动作特征的一件事情形式上，
								事件可表示为e，定义为一个六元组：e一(A，O，T，V，P，L)其中，事件六元组中的元素称为事件要素，
								分别表示动作、对象、时间、环境、断言、语言表现。</div>
							<div class="artical-title">对象要素</div>
							<div class="markdown">对象是事件的主要参与者，是事件中的主导作用者或被改变者。
								对象可分为主体和客体。主体是主导者，是事件中的主角，有时是事 件的制造者或期望事件发生者客体是事件中的被动者。按照分工，
								事件中的对象分为不同的角色，例如“选举”事件，其中有主持组织 者、监票者、投票者、候选人、当选者、落选者。事件的对象一般是
								第一实体，但也可能又是事件，也可能是关系。还有的事件的对象是 有关联的事件集合。对于特定的事件类，对象是有约束的，例如选举
								事件的组织者可以是人或组织。利用这些约束，可以判断句子中的主 语或宾语。其他要素也有约束，也可以利用。</div>
							<div class="artical-title">时间要素</div>
							<div class="markdown">每个事件都必须发生在一个时间段内。事件有开始、发展、
								结束。时间段由绝对时间表示，也可以用相对时间表示，也就是 用另一个事件的时问的相对偏差表示。</div>
							<div class="artical-title">环境要素</div>
							<div class="markdown">任何事件必然发生在一定的环境中。环境由多
								个实体按照特定的关系组成。例如“上课”事件的环 境有教室，教室内有黑板、讲台、课桌、椅子等，
								这些东西是有序存在的。环境要素中的实体与对象 要素中的实体都是事件涉及的，还有动作要素中的
								工具。为什么有的属于对象要素、有的属于环境要 素、有的属于动作要素?关键在于它们在事件中的
								地位和作用。环境要素中的实体是相对静止的，在 事件中几乎是不变的，或者虽然变化，但并不重要。
								而动作要素的工具中的实体是运动的，是对事件的 实施有重要作用的。对象要素中的实体是最重要的，
								或者是事件的主角，或者是事件的驱动者，或者是 事件的主要被改变者。</div>
							<div class="artical-title">语言表现要素</div>
							<div class="markdown">将事件与语言分离有很多优点。事件是客观的，
								本来就不依赖于语言。语言是人类为了交流各自知道 的事件发生而创造出来的符号表示，因而事件就有了
								语言特性。交流和思考离不开语言，然而很多研究工 作往往将它们混为一谈。混为一谈的研究方法容易把
								问题搞复杂。事件的语言表现是随着语言的变化而变 化的。同一个事件，对于不同的语言有不同的表现，
								即使对于同一个语言，也会有不同的表现。语言表现 的主要内容是核心词。核心词是对于事件的称谓、对
								于事件中各角色的称谓、对时问和环境的描述格式、 对各要素结合的描述格式。语言表现可以用文法表示，
								也可以用规则表示，或用模板表示。</div>
							<div class="artical-title">断言要素</div>
							<div class="markdown">断言描述的是事件的作用。前置条件表示的是事件发生
								之前的状态特点，也是事件发生的条件。中间断言表示事件 进行过程中的状态特点，也就是在开始后和结束前各状态共
								同的特点。后置条件是事件结束状态的特点。</div>
							<div class="artical-title">动作要素</div>
							<div class="markdown">
								动作要素描述事件的变化过程及其特征，是对程度，方式，方法，工具等的描述，例如快慢，使用什么，根据什么等等。</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/pages/common/foot.jsp" />
	</div>

	<div id="buttomDiv"></div>

	<div id="objOntWin">
		<div class="title draggable" id="objOntWinTitle">
			<h3>
				<i><span class="ontname"></span></i>事件类层次图
				<h3>
					<div>
						<a class="min" href="javascript:;" title="最小化"></a> <a class="max"
							href="javascript:;" title="最大化"></a> <a class="revert"
							href="javascript:;" title="还原"></a> <a class="close"
							href="javascript:;" id="objOntWinClose" title="关闭"></a>
					</div>
		</div>
		<div class="resizeL"></div>
		<div class="resizeT"></div>
		<div class="resizeR"></div>
		<div class="resizeB"></div>
		<div class="resizeLT"></div>
		<div class="resizeTR"></div>
		<div class="resizeBR"></div>
		<div class="resizeLB"></div>
		<div class="content">
			<div class="objOntToolMenu">
				<shiro:hasRole name="builder">
					<img id="objOntAdd" class="usefulimg"
						src="resources/images/common/add.png">
				</shiro:hasRole>

				<img src="resources/images/common/gap.png" class="gap"></img>

				<%--<shiro:hasRole name="builder">
					<img id="objOntDel" src="resources/images/common/del.png">
				</shiro:hasRole>

				<img src="resources/images/common/gap.png" class="gap"></img>

				<shiro:hasRole name="builder">
					<img id="objOntEdit" src="resources/images/common/edit.png">
				</shiro:hasRole>

				<img src="resources/images/common/gap.png" class="gap"></img> <img
					id="objOntFind" src="resources/images/common/find.png"> <img
					src="resources/images/common/gap.png" class="gap"> --%>
				</img> <img id="objOntZoomout" class="usefulimg"
					src="resources/images/common/zoomout.png"> <img
					src="resources/images/common/gap.png" class="gap"></img> <img
					id="objOntZoomin" class="usefulimg"
					src="resources/images/common/zoomin.png"> <img
					src="resources/images/common/gap.png" class="gap"></img> <img
					id="objOntReload" class="usefulimg"
					src="resources/images/common/reload.png"> <img
					src="resources/images/common/gap.png" class="gap"></img>
				<!-- <img
					id="objOntClean" src="resources/images/common/save.png"> -->
				<img id="objOntPrinter" class="usefulimg"
					src="resources/images/common/printer.png">
			</div>
			<div id="objOntSvg"></div>
		</div>
	</div>

	<div class="dealObjOntLat-popover" id="dealObjOntLat">
		<div class="dealObjOntLat-poptit">
			<a href="javascript:;" title="关闭" id="eveOntWinClose" class="close">×</a>
			<div id="eveTitle" class="draggable">
				<h3>事件类操作</h3>
			</div>
		</div>
		<div>
			<form id="objOntLatForm" class="contact_form" method="post"
				name="contact_form" action="" target="nm_iframe">
				<ul>
					<!-- <li id="lisid" class="lielement"><label for="objLatSid">事件类编号:</label>
						<input name="objLatSid" type="text" placeholder="o1"
						required="required" id="objLatSid"></li> -->

					<li id="liname" class="lielement"><label for="eclatname">事件类名称:</label>
						<input name="eclatname" type="text" required="required"
						id="eclatname"></li>

					<li id="liparent" class="lielement"><label
						for="ecparentlatname">父类名称:</label> <input name="ecparentlatname"
						type="text" required="required" id="ecparentlatname"> <span
						class="form_hint">正确格式为：latname1,latname2,latname3</span></li>

					<li id="linote" class="lielement"><label for="eclatnote"
						id="noteLB">备注:</label> <input value="note.." name="eclatnote"
						type="text" required="required" id="eclatnote"></li>

					<li id="liea" class="lielement"><label id="lea">动作要素:</label>
						<label id="leai" style="width: 300px;"></label></li>
					<li id="lieo" class="lielement"><label id="leo">对象要素:</label>
						<label id="leoi" style="width: 300px;"></label></li>
					<li id="liet" class="lielement"><label id="let">时间要素:</label>
						<label id="leti" style="width: 300px;"></label></li>
					<li id="liee" class="lielement"><label id="lee">环境要素:</label>
						<label id="leei" style="width: 300px;"></label></li>
					<li id="lieas" class="lielement"><label id="leas">断言要素:</label>
						<label id="leasi" style="width: 300px;"></label></li>
					<li id="liele" class="lielement"><label id="lele">语言表现要素:</label>
						<label id="lelei" style="width: 300px;"></label></li>
					<li id="lisubmit">
						<button class="submit" type="submit" id="saveObj">保存</button>
						<button class="submit" type="reset" id="resetObj">重置</button> <input
						name="objOid" type="text" id="objOid" style="display: none">
					</li>

				</ul>
			</form>
		</div>
	</div>

	<div class="dealObjOntLat-popover" id="actionElementEdit">
		<div class="dealObjOntLat-poptit">
			<a href="javascript:;" title="关闭" id="actionElementWinClose"
				class="close">×</a>
			<div id="actionTitle" class="draggable">
				<h3 id="showTitle">
					<i><span id="aecname" class="ecname"></span></i>事件类动作要素编辑
				</h3>
			</div>
		</div>
		<div>
			<form class="contact_form" id="actionElementForm" method="post"
				action="" target="nm_iframe">
				<div id="actionFormItem">
					<ul>
						<li class="lielement"><label>程度:</label> <select
							name="degree" id="sDegree">
								<option value="缓缓">缓缓</option>
								<option value="平缓">平缓</option>
								<option value="激烈">激烈</option>
								<option value="剧烈">剧烈</option>
						</select></li>

						<li class="lielement"><label>使用工具:</label> <input name="tool"
							type="text" required="required" id="iTool"></li>

						<li class="lielement"><label>使用方法:</label> <input
							name="method" type="text" required="required" id="iMethod"></li>
					</ul>
				</div>
				<li id="lisubmit">
					<button class="submit" type="submit" id="saveAction">保存</button>
					<button class="submit" type="reset" id="resetAction">重置</button>
				</li>
			</form>
		</div>
	</div>

	<div class="dealObjOntLat-popover" id="objElementEdit">
		<div class="dealObjOntLat-poptit">
			<a href="javascript:;" title="关闭" id="objElementWinClose"
				class="close">×</a>
			<div id="objTitle" class="draggable">
				<h3 id="showTitle">
					<i><span class="ecname"></span></i>事件类对象要素编辑
				</h3>
			</div>
		</div>
		<div>
			<form id="objElementForm" method="post" action="" target="nm_iframe">
				<div class="h-24">
					<div class="w-550 h-24"></div>
					<img src="resources/images/bont/left_arrow.png" id="removeobj"></img>
					<img src="resources/images/bont/right_arrow.png" id="addobj"></img>
				</div>
				<div id="objFormItem">
					<!-- <div class="form-col">
						<ul>
							<li>数量：</li>
							<li><select name="amount" id="sAmount">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="少许">少许</option>
									<option value="近半">近半</option>
									<option value="半">半</option>
									<option value="多半">多半</option>
									<option value="大量">大量</option>
							</select></li>
							<li>所属概念：</li>
							<li><select name="conceptsid" id="sConcept">
							</select></li>
							<li>语言称谓：</li>
							<li><input name="lane" id="iLE1" type="text"></li>
						</ul>
					</div> -->
				</div>
				<li id="lisubmit">
					<button class="submit" type="submit" id="saveObj">保存</button>
					<button class="submit" type="reset" id="resetObj">重置</button> <input
					name="objOid" type="text" id="objOid" style="display: none">
				</li>
			</form>
		</div>
	</div>

	<div class="dealObjOntLat-popover" id="timeElementEdit">
		<div class="dealObjOntLat-poptit">
			<a href="javascript:;" title="关闭" id="timeElementWinClose"
				class="close">×</a>
			<div id="timeTitle" class="draggable">
				<h3 id="showTitle">
					<i><span class="ecname"></span></i>事件类时间要素编辑
				</h3>
			</div>
		</div>
		<div>
			<form id="timeElementForm" method="post" action="" target="nm_iframe">
				<div id="timeFormItem">
					<ul>
						<li><label>起始时间：</label> <select name="start" id="tsStart">
								<option value="任意">任意</option>
								<option value="某类时间约束">某类时间约束</option>
						</select></li>
						<li><lable>延续长度：</lable> <select name="length" id="tsLength">
								<option value="几分钟">几分钟</option>
								<option value="几秒钟">几秒钟</option>
								<option value="几小时">几小时</option>
								<option value="几天">几天</option>
								<option value="几周">几周</option>
								<option value="几月">几月</option>
								<option value="几年">几年</option>
								<option value="几世纪">几世纪</option>
						</select></li>
					</ul>
				</div>
				<li id="lisubmit">
					<button class="submit" type="submit" id="saveObj">保存</button>
					<button class="submit" type="reset" id="resetObj">重置</button> <input
					name="objOid" type="text" id="objOid" style="display: none">
				</li>
			</form>
		</div>
	</div>

	<!-- 环境要素编辑窗口 -->
	<div class="dealObjOntLat-popover" id="envElementEdit">
		<div class="dealObjOntLat-poptit">
			<a href="javascript:;" title="关闭" id="envElementWinClose"
				class="close">×</a>
			<div id="envTitle" class="draggable">
				<h3 id="showTitle">
					<i><span id="ecname" class="ecname"></span></i>事件类环境要素编辑
				</h3>
			</div>
		</div>
		<div>
			<form id="envElementForm" class="contact_form" method="post"
				action="" target="nm_iframe">
				<div id="objFormItem">
					<li><label>所属概念：</label><select name="conceptsid"
						id="envsConcept">
					</select></li>
					<li><label>语言表现：</label> <input type="text" id="iEnvlane"
						required="required"></li>
				</div>
				<li id="lisubmit">
					<button class="submit" type="submit" id="saveEnv">保存</button>
					<button class="submit" type="reset" id="resetEnv">重置</button>
				</li>
			</form>
		</div>
	</div>

	<!-- 事件类断言要素编辑 -->
	<div class="dealObjOntLat-popover" id="assertElementEdit">
		<div class="dealObjOntLat-poptit">
			<a href="javascript:;" title="关闭" id="assertElementWinClose"
				class="close">×</a>
			<div id="assertTitle" class="draggable">
				<h3 id="showTitle">
					<i><span id="ecname" class="ecname"></span></i>事件类断言要素编辑
				</h3>
			</div>
		</div>
		<div>
			<form id="assertElementForm" class="contact_form" method="post"
				action="" target="nm_iframe">
				<div id="assertFormItem">
					<ul>
						<li class="lielement"><label>前置状态:</label> <input
							name="prestate" type="text" required="required" id="iPrestate"></li>

						<li class="lielement"><label>中间断言:</label> <input
							name="massert" type="text" required="required" id="iMassert"></li>

						<li class="lielement"><label>后置状态:</label> <input
							name="poststate" type="text" required="required" id="iPoststate"></li>

					</ul>
				</div>
				<li id="lisubmit">
					<button class="submit" type="submit" id="saveAssert">保存</button>
					<button class="submit" type="reset" id="resetAssert">重置</button>
				</li>
			</form>
		</div>
	</div>

	<!-- 事件类语言表现要素编辑 -->
	<div class="dealObjOntLat-popover" id="languageElementEdit">
		<div class="dealObjOntLat-poptit">
			<a href="javascript:;" title="关闭" id="languageElementWinClose"
				class="close">×</a>
			<div id="languageTitle" class="draggable">
				<h3 id="showTitle">
					<i><span id="ecname" class="ecname"></span></i>事件类语言表现要素编辑
				</h3>
			</div>
		</div>
		<div>
			<form id="languageElementForm" class="contact_form" method="post"
				action="" target="nm_iframe">
				<div id="languageFormItem">
					<ul>
						<li class="lielement"><label>触发词集合:</label> <input
							name="language" type="text" required="required"
							id="iTriggerWords"></li>
						<li class="lielement"><label> 搭配:</label> <input
							name="language" type="text" required="required" id="iCollocation"></li>
					</ul>
				</div>
				<li id="lisubmit">
					<button class="submit" type="submit" id="saveLanguage">保存</button>
					<button class="submit" type="reset" id="resetLanguage">重置</button>
				</li>
			</form>
		</div>
	</div>

	<div id="conceptSvgWin" class="conceptSvgWinc">
		<div class="title draggable" id="conceptWinTitle">
			<h3>
				<i><span class="ontname"></span></i>概念层次图
			</h3>
			<div>
				<a id="conceptSvgWinClose" class="conceptSvgWinClosec"
					href="javascript:;" title="关闭"></a>
			</div>

		</div>
		<div class="content">
			<div class="objOntToolMenu">
				<shiro:hasRole name="builder">
					<img id="conceptAdd" class="usefulimg"
						src="resources/images/common/add.png">
				</shiro:hasRole>

				<img src="resources/images/common/gap.png" class="gap"></img>
				<%-- 
				<shiro:hasRole name="builder">
					<img id="conceptDel" src="resources/images/common/del.png">
				</shiro:hasRole>

				<img src="resources/images/common/gap.png" class="gap"></img>

				<shiro:hasRole name="builder">
					<img id="conceptEdit" src="resources/images/common/edit.png">
				</shiro:hasRole>

				<img src="resources/images/common/gap.png" class="gap"></img> <img
					id="conceptFind" src="resources/images/common/find.png"> <img
					src="resources/images/common/gap.png" class="gap"> --%>
				</img> <img id="conceptZoomout" class="usefulimg"
					src="resources/images/common/zoomout.png"> <img
					src="resources/images/common/gap.png" class="gap"></img> <img
					id="conceptZoomin" class="usefulimg"
					src="resources/images/common/zoomin.png"> <img
					src="resources/images/common/gap.png" class="gap"></img> <img
					id="conceptReload" class="usefulimg"
					src="resources/images/common/reload.png"> <img
					src="resources/images/common/gap.png" class="gap"></img>
				<!-- <img
					id="conceptClean" src="resources/images/common/save.png">  -->
				<img id="conceptPrinter" class="usefulimg"
					src="resources/images/common/printer.png">
			</div>
		</div>
		<div id="conceptSvgDiv"></div>
	</div>

	<div class="dealObjOntLat-popover" id="conceptEditWin">
		<div class="dealObjOntLat-poptit">
			<a href="javascript:;" title="关闭" id="conceptEditWinClose"
				class="close">×</a>
			<div id="conceptTitle" class="draggable">
				<h3>概念编辑窗口</h3>
			</div>
		</div>
		<div>
			<form id="conceptEditForm" class="contact_form" method="post"
				target="nm_iframe" action="">
				<ul>
					<!-- <li id="lisid" class="lielement"><label for="latsid">概念编号:</label>
						<input name="latsid" type="text" placeholder="c1"
						required="required" id="conceptlatsid"></li> -->

					<li id="liname" class="lielement"><label for="latname">概念名称:</label>
						<input name="latname" type="text" required="required"
						id="conceptlatname"></li>

					<li id="liparent" class="lielement"><label
						for="cparentlatname">父概念名:</label> <input name="parentsid"
						type="text" required="required" id="conceptparentlatname">
						<span class="form_hint">正确格式为：c1,c2,c3</span></li>
					<div id="divproval"></div>

					<li id="lisubmit">
						<button class="submit" type="submit" id="saveConcept">保存</button>
						<button class="submit" type="reset" id="resetConcept">重置</button>
						<img src="resources/images/add.png" id="conceptimgadd" />
					</li>

				</ul>
			</form>
		</div>
	</div>

	<div class="conceptSvgWinc" id="conceptSubgraphWin">
		<div class="title draggable" id="conceptSubgraphWinTitle">
			<h3>概念子图</h3>
			<div>
				<a id="conceptSubgraphWinClose" class="conceptSvgWinClosec"
					href="javascript:;" title="关闭"></a>
			</div>
		</div>
		<div id="conceptSubGraphSvgDiv"></div>
	</div>

	<div class="conceptSvgWinc" id="ecRelationWin">
		<div class="title draggable" id="ecRelationTitle">
			<h3>
				<i><span class="ontname"></span></i>非分类关系图
			</h3>
			<div>
				<a id="ecRelationWinClose" class="conceptSvgWinClosec"
					href="javascript:;" title="关闭"></a>
			</div>
		</div>
		<div style="width: 1000px; height: 500px; overflow: auto;">
			<div style="width: 200px; float: left;" class="m-t-20">
				<img width="200px" src="resources/images/bont/legend.png" />
			</div>
			<div id="main" class="m-t-20"
				style="width: 770px; height: 600px; float: left;"></div>
		</div>
	</div>
	<div id="hint">
		<dl>
			<dt>
				<span class="arrow"></span>
			</dt>
			<dd class="hint-text" id="hint-text"></dd>
		</dl>
	</div>

	<div class="dealObjOntLat-popover" id="addECWin">
		<div class="dealObjOntLat-poptit">
			<a href="javascript:;" title="关闭" id="addECWinClose" class="close">×</a>
			<div id="addECWinTitle" class="draggable">
				<h3>新建事件类</h3>
			</div>
		</div>
		<div>
			<form id="addECForm" class="contact_form" method="post"
				name="contact_form" action="" target="nm_iframe">
				<ul>
					<!-- <li id="lisid" class="lielement"><label for="objLatSid">事件类编号:</label>
						<input name="objLatSid" type="text" placeholder="o1"
						required="required" id="objLatSid"></li> -->
					<li id="liname" class="lielement"><label for="eclatname">事件类名称:</label>
						<input name="eclatname" type="text" required="required"
						id="addeclatname"></li>
					<li id="liparent" class="lielement"><label
						for="ecparentlatname">父类名称:</label> <input name="ecparentlatname"
						type="text" required="required" id="addecparentlatname"> <span
						class="form_hint">正确格式为：latname1,latname2,latname3</span></li>
					<li id="linote" class="lielement"><label for="eclatnote"
						id="noteLB">备注:</label> <input value="note.." name="eclatnote"
						type="text" required="required" id="addeclatnote"></li>
					<li id="lisubmit">
						<button class="submit" type="submit" id="saveObj">保存</button>
						<button class="submit" type="reset" id="resetObj">重置</button> <input
						name="objOid" type="text" id="objOid" style="display: none">
					</li>

				</ul>
			</form>
		</div>
	</div>

	<iframe id="id_iframe" name="nm_iframe" style="display: none;"></iframe>

</body>
<script src="https://cdn.bootcss.com/echarts/3.5.4/echarts.min.js"></script>
<script type="text/javascript" src="resources/js/bont/ecGraph.js"></script>
<script type="text/javascript">
	LoadECRelationGraph("突发事件本体", "main");
	//$('#objOntReload').click();
</script>
</html>
