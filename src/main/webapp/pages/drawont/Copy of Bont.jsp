<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 	
<%
	String path = request.getContextPath();
	// 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量 
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	// 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。 
	pageContext.setAttribute("basePath", basePath);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<head>
<html xmlns="http://www.w3.org/1999/xhtml,http://www.w3.org/2000/svg">
<base href="<%=basePath%>">
<title>My JSP 'mjolnir.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="resources/css/common/Nav.css" />
<link rel="stylesheet" href="resources/css/bont/Bont.css" />
<link rel="stylesheet" href="resources/css/bont/ObjOntWin.css" />
<link rel="stylesheet" href="resources/css/bont/ObjOntLatForm.css" />
<link rel="stylesheet" href="resources/css/leftmenu/LeftMenu.css" />
<link rel="stylesheet" href="resources/css/tab/Tab.css" />
<link rel="stylesheet" href="resources/css/content/Content.css" />
<link rel="stylesheet" type="text/css" href="resources/css/bottom/Bottom.css"
	media="all">
<link rel="stylesheet"
	href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
<script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>

<script type="text/javascript" src="resources/js/svg.min.js"></script>
<script type="text/javascript" src="resources/js/svg.draggable.js"></script>


<script type="text/javascript" src="resources/js/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.svg.js"></script>
<script type="text/javascript" src="resources/js/jquery.svgdom.js"></script>
<script type="text/javascript" src="resources/js/jquery.svganim.js"></script>
<script type="text/javascript" src="resources/js/jquery.color.js"></script>
<script type="text/javascript" src="resources/js/common/NavMenu.js"></script>
<script type="text/javascript" src="resources/js/common/ArrayList.js"></script>
<script type="text/javascript" src="resources/js/common/Config.js"></script>
<script type="text/javascript" src="resources/js/common/ObjOntGV.js"></script>
<script type="text/javascript" src="resources/js/leftmenu/LeftMenu.js"></script>
<script type="text/javascript" src="resources/js/tab/Tab.js"></script>
<script type="text/javascript" src="resources/js/bont/ObjOntWin.js"></script>
<script type="text/javascript" src="resources/js/bont/ViewObjOnt.js"></script>
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

</head>
<body>
	<div class="main_div">
		<div id="nav_main">
			<div class="inner1">
				<div class="inner2">
					<div id="nav_main_bar">
						<ul>
							<li class="current">
								<div class="bm">
									<div class="inner">
										<div class="inner3">
											<div class="inner4">
												<a href="">首页<br>Home
												</a>
											</div>
										</div>
									</div>
								</div>
							</li>

							<li>
								<div class="bm">
									<div class="inner">
										<div class="inner3">
											<div class="inner4">
												<a href="">关于我们<br>About Us
												</a>
											</div>
										</div>
									</div>
								</div>
								<div class="lm">
									<div class="inner5">
										<div class="inner6">
											<ul>
												<li><a href="">朕智介绍&nbsp;Profile</a></li>
												<li><a href="">企业文化&nbsp;Culture</a></li>
												<li><a href="">企业环境&nbsp;Environment</a></li>
												<li><a href="">联系我们&nbsp;Contact</a></li>
												<li><a href="">合作伙伴&nbsp;Partners</a></li>
												<li><a href="">招贤纳士&nbsp;Jobs</a></li>
												<li class="clear"></li>
											</ul>
										</div>
									</div>
								</div>
							</li>

							<li>
								<div class="bm">
									<div class="inner">
										<div class="inner3">
											<div class="inner4">
												<a href="">产品中心<br>Products
												</a>
											</div>
										</div>
									</div>
								</div>
								<div class="lm">
									<div class="inner5">
										<div class="inner6">
											<ul>
												<li><a href="">金融信息&nbsp;Financial Info</a></li>
												<li><a href="">语音识别&nbsp;Speech Rec </a></li>
												<li><a href="">机器人&nbsp;Robot</a></li>
												<li><a href="">虚拟现实&nbsp;Virtual Reality</a></li>
												<li><a href="">大数据&nbsp;Big Data</a></li>
												<li><a href="">云计算&nbsp;Cloud Computing</a></li>
												<li class="clear"></li>
											</ul>
										</div>
									</div>
								</div>
							</li>
							<li>
								<div class="bm">
									<div class="inner">
										<div class="inner3">
											<div class="inner4">
												<a href="">新闻中心<br>News
												</a>
											</div>
										</div>
									</div>
								</div>
								<div class="lm">
									<div class="inner5">
										<div class="inner6">
											<ul>
												<li><a href="">最新新闻&nbsp;News</a></li>
												<li><a href="">精彩活动&nbsp;Activity</a></li>
												<li><a href="">欢乐相册&nbsp;Album</a></li>
												<li><a href="">视频中心&nbsp;Video</a></li>
												<li class="clear"></li>
											</ul>
										</div>
									</div>
								</div>
							</li>
							<li>
								<div class="bm">
									<div class="inner">
										<div class="inner3">
											<div class="inner4">
												<a href="">团队力量<br>Teachers
												</a>
											</div>
										</div>
									</div>
								</div>
								<div class="lm">
									<div class="inner5">
										<div class="inner6">
											<ul>
												<li><a href="">研发团队&nbsp;Research</a></li>
												<li><a href="">销售团队&nbsp;Sales</a></li>
												<li><a href="">管理团队&nbsp;Management</a></li>
												<li class="clear"></li>
											</ul>
										</div>
									</div>
								</div>
							</li>
							<li>
								<div class="bm">
									<div class="inner">
										<div class="inner3">
											<div class="inner4">
												<a href="">我们的会员<br>Members
												</a>
											</div>
										</div>
									</div>
								</div>
								<div class="lm">
									<div class="inner5">
										<div class="inner6">
											<ul>
												<li><a href="">我们的会员&nbsp;Our Members</a></li>
												<li><a href="">会员中心&nbsp;Login</a></li>
												<li><a href="">会员公告&nbsp;Notice</a></li>
												<li><a href="">会员活动&nbsp;Member Act</a></li>
												<li class="clear"></li>
											</ul>
										</div>
									</div>
								</div>
							</li>

							<li>
								<div class="bm">
									<div class="inner">
										<div class="inner3">
											<div class="inner4">
												<a href="">创始人专栏<br>Blog
												</a>
											</div>
										</div>
									</div>
								</div>
							</li>
							<li>
								<div class="bm">
									<div class="inner">
										<div class="inner3">
											<div class="inner4">
												<a href="">开发平台<br>Cheats
												</a>
											</div>
										</div>
									</div>
								</div>
								<div class="lm">
									<div class="inner5">
										<div class="inner6">
											<ul>
												<li><a href="">语音平台</a></li>
												<li><a href="">机器人平台</a></li>
												<li><a href="">云计算平台</a></li>
												<li><a href="">大数据平台</a></li>
												<li class="clear"></li>
											</ul>
										</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="container">

			<div class="leftsidebar_box">
				<div class="line"></div>
				<dl class="syetem_management">
					<dt>
						系统管理<img src="resources/images/leftmenu/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<a href="#">基本配置管理</a>
					</dd>
					<dd>
						<a href="#">操作管理</a>
					</dd>
				</dl>
				<dl class="system_log">
					<dt onClick="changeImage()">
						系统记录<img src="resources/images/leftmenu/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<label id="viewObjOnt">操作记录</label>
					</dd>
					<dd>
						<label>查询记录</label>
					</dd>
					<dd>
						<label>修改记录</label>
					</dd>
					<dd>
						<label>删除记录</label>
					</dd>
				</dl>
				<dl class="statistics">
					<dt>
						统计分析<img src="resources/images/leftmenu/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<label>事件统计</label>
					</dd>
					<dd class="first_dd">
						<label>参与者统计</label>
					</dd>
					<dd class="first_dd">
						<label>对象统计</label>
					</dd>
					<dd class="first_dd">
						<label>环境统计</label>
					</dd>
					<dd class="first_dd">
						<label>时间统计</label>
					</dd>
					<dd class="first_dd">
						<label>语言要素统计</label>
					</dd>
				</dl>
				<dl class="custom">
					<dt onClick="changeImage()">
						管理员管理<img src="resources/images/leftmenu/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<label>查看管理员信息</label>
					</dd>
					<dd>
						<label>增加管理员</label>
					</dd>
					<dd>
						<label>删除管理员</label>
					</dd>
					<dd>
						<label>修改管理员</label>
					</dd>
					<dd>
						<label>权限关系网</label>
					</dd>
				</dl>

				<dl class="channel">
					<dt>
						事件本体<img src="resources/images/leftmenu/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<label>查看本体</label>
					</dd>
					<dd>
						<label>编辑本体</label>
					</dd>
					<dd>
						<label>管理本体</label>
					</dd>
					<dd>
						<label>更新本体</label>
					</dd>
				</dl>

				<dl class="app">
					<dt onClick="changeImage()">
						参与者本体<img src="resources/images/leftmenu/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<label>查看本体</label>
					</dd>
					<dd>
						<label>编辑本体</label>
					</dd>
					<dd>
						<label>管理本体</label>
					</dd>
					<dd>
						<label>更新本体</label>
					</dd>
				</dl>

				<dl class="cloud">
					<dt>
						对象本体<img src="resources/images/leftmenu/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<label>查看本体</label>
					</dd>
					<dd>
						<label>编辑本体</label>
					</dd>
					<dd>
						<label>管理本体</label>
					</dd>
					<dd>
						<label>更新本体</label>
					</dd>
				</dl>



				<dl class="source">
					<dt>
						时间本体<img src="resources/images/leftmenu/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<label>查看本体</label>
					</dd>
					<dd>
						<label>编辑本体</label>
					</dd>
					<dd>
						<label>管理本体</label>
					</dd>
					<dd>
						<label>更新本体</label>
					</dd>
				</dl>
				<dl class="source">
					<dt>
						环境本体<img src="resources/images/leftmenu/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<label>查看本体</label>
					</dd>
					<dd>
						<label>编辑本体</label>
					</dd>
					<dd>
						<label>管理本体</label>
					</dd>
					<dd>
						<label>更新本体</label>
					</dd>
				</dl>
				<dl class="source">
					<dt>
						语言表现本体<img src="resources/images/leftmenu/select_xl01.png">
					</dt>
					<dd class="first_dd">
						<label>查看本体</label>
					</dd>
					<dd>
						<label>编辑本体</label>
					</dd>
					<dd>
						<label>管理本体</label>
					</dd>
					<dd>
						<label>更新本体</label>
					</dd>
				</dl>
			</div>
		</div>

		<div class="contentdiv">
			<div class="uldiv">
				<ul id="tabs">
					<li><a href="#" name="#tab1">事件</a></li>
					<li><a href="#" name="#tab2">参与者</a></li>
					<li><a href="#" name="#tab3">对象</a></li>
					<li><a href="#" name="#tab4">时间</a></li>
					<li><a href="#" name="#tab5">环境</a></li>
					<li><a href="#" name="#tab6">语言表现</a></li>
				</ul>
				<div>
					<div id="content">
						<div id="tab1">
							<h2>Lorem ipsum sit amet</h2>
							<p>Praesent risus nisi, iaculis nec condimentum vel, rhoncus
								vel dolor. Aenean nisi lectus, varius nec tempus id, dapibus non
								quam.</p>
							<p>Suspendisse ac libero mauris. Cras lacinia porttitor urna,
								vitae molestie libero posuere et. Mauris turpis tortor, mollis
								non vulputate sit amet, rhoncus vitae purus.</p>
							<h3>Pellentesque habitant</h3>
							<p>Vestibulum ante ipsum primis in faucibus orci luctus et
								ultrices posuere cubilia curae.</p>
						</div>
						<div id="tab2">
							<h2>Vivamus fringilla suscipit justo</h2>
							<p>Aenean dui nulla, egestas sit amet auctor vitae, facilisis
								id odio. Donec dictum gravida feugiat.</p>
							<p>Class aptent taciti sociosqu ad litora torquent per
								conubia nostra, per inceptos himenaeos. Cras pretium elit et
								erat condimentum et volutpat lorem vehicula</p>

							<p>Morbi tincidunt pharetra orci commodo molestie. Praesent
								ut leo nec dolor tempor eleifend.</p>
						</div>
						<div id="tab3">
							<h2>Phasellus non nibh</h2>
							<p>Non erat laoreet ullamcorper. Pellentesque magna metus,
								feugiat eu elementum sit amet, cursus sed diam. Curabitur
								posuere porttitor lorem, eu malesuada tortor faucibus sed.</p>
							<h3>Duis pulvinar nibh vel urna</h3>
							<p>Donec purus leo, porttitor eu molestie quis, porttitor sit
								amet ipsum. Class aptent taciti sociosqu ad litora torquent per
								conubia nostra, per inceptos himenaeos. Donec accumsan ornare
								elit id imperdiet.</p>
							<p>Suspendisse ac libero mauris. Cras lacinia porttitor urna,
								vitae molestie libero posuere et.</p>
						</div>
						<div id="tab4">
							<h2>Cum sociis natoque penatibus</h2>
							<p>Magnis dis parturient montes, nascetur ridiculus mus.
								Nullam ac massa quis nisi porta mollis venenatis sit amet urna.
								Ut in mauris velit, sed bibendum turpis.</p>
							<p>Nam ornare vulputate risus, id volutpat elit porttitor
								non. In consequat nisi vel lectus dapibus sodales. Pellentesque
								habitant morbi tristique senectus et netus et malesuada fames ac
								turpis egestas. Praesent bibendum sagittis libero.</p>
							<h3>Imperdiet sem interdum nec</h3>
							<p>Mauris rhoncus tincidunt libero quis fringilla.</p>
						</div>
						<div id="tab5">
							<h2>Cum sociis natoque penatibus</h2>
							<p>Magnis dis parturient montes, nascetur ridiculus mus.
								Nullam ac massa quis nisi porta mollis venenatis sit amet urna.
								Ut in mauris velit, sed bibendum turpis.</p>
							<p>Nam ornare vulputate risus, id volutpat elit porttitor
								non. In consequat nisi vel lectus dapibus sodales. Pellentesque
								habitant morbi tristique senectus et netus et malesuada fames ac
								turpis egestas. Praesent bibendum sagittis libero.</p>
							<h3>Imperdiet sem interdum nec</h3>
							<p>Mauris rhoncus tincidunt libero quis fringilla.</p>
						</div>
						<div id="tab6">
							<h2>Cum sociis natoque penatibus</h2>
							<p>Magnis dis parturient montes, nascetur ridiculus mus.
								Nullam ac massa quis nisi porta mollis venenatis sit amet urna.
								Ut in mauris velit, sed bibendum turpis.</p>
							<p>Nam ornare vulputate risus, id volutpat elit porttitor
								non. In consequat nisi vel lectus dapibus sodales. Pellentesque
								habitant morbi tristique senectus et netus et malesuada fames ac
								turpis egestas. Praesent bibendum sagittis libero.</p>
							<h3>Imperdiet sem interdum nec</h3>
							<p>Mauris rhoncus tincidunt libero quis fringilla.</p>
						</div>
					</div>
				</div>
			</div>


		</div>


		<div data-role="widget" data-widget="nav4" class="nav4">
			<nav>
			<div id="nav4_ul" class="nav_4">
				<ul class="box">
					<li><a href="javascript:;" class=""><span>关于我们</span></a>
						<dl>
							<dd>
								<a href="#"><span>电话</span></a>
							</dd>
							<dd>
								<a href="#"><span>地址</span></a>
							</dd>
							<dd>
								<a href="#"><span>在线客服</span></a>
							</dd>
							<dd>
								<a href="#"><span>在线QQ</span></a>
							</dd>
						</dl></li>
					<li><a href="javascript:;" class=""><span>电商</span></a>
						<dl>
							<dd>
								<a href="#"><span>微信会员卡</span></a>
							</dd>
							<dd>
								<a href="#"><span>微社区</span></a>
							</dd>
							<dd>
								<a href="#"><span>微投票</span></a>
							</dd>
							<dd>
								<a href="#"><span>微调研</span></a>
							</dd>
						</dl></li>
					<li><a href="javascript:;" class="on"><span>会员专区</span></a>
						<dl>
							<dd>
								<a href="#"><span>微商城</span></a>
							</dd>
							<dd>
								<a href="#"><span>微餐饮</span></a>
							</dd>
							<dd>
								<a href="#"><span>微团购</span></a>
							</dd>
							<dd>
								<a href="#"><span>微汽车</span></a>
							</dd>
						</dl></li>
				</ul>
			</div>
			</nav>
			<div id="nav4_masklayer" class="masklayer_div on">&nbsp;</div>
			<script src="resources/js/bottom/Bottom.js"></script>
			<script type="text/javascript">
				Bottom.bindClick(document.getElementById("nav4_ul")
						.querySelectorAll("li>a"), document
						.getElementById("nav4_masklayer"));
			</script>
		</div>


		<div id="objOntWin">
			<div class="title">
				<h2>对象本体编辑窗口</h2>
				<div>
					<a class="min" href="javascript:;" title="最小化"></a> <a class="max"
						href="javascript:;" title="最大化"></a> <a class="revert"
						href="javascript:;" title="还原"></a> <a class="close"
						href="javascript:;" title="关闭"></a>
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
					<shiro:hasRole name="builder"> <img id="objOntAdd" src="resources/images/common/add.png"> </shiro:hasRole>
					
					<img src="resources/images/common/gap.png" class="gap"></img> 
					
					<shiro:hasRole name="builder"><img id="objOntDel" src="resources/images/common/del.png"> </shiro:hasRole>
					
					<img src="resources/images/common/gap.png" class="gap"></img> 
					
					<shiro:hasRole name="builder"><img id="objOntEdit" src="resources/images/common/edit.png"> </shiro:hasRole>
					<img
						src="resources/images/common/gap.png" class="gap"></img> <img
						id="objOntFind" src="resources/images/common/find.png"> <img
						src="resources/images/common/gap.png" class="gap"></img> <img
						id="objOntZoomout" src="resources/images/common/zoomout.png"> <img
						src="resources/images/common/gap.png" class="gap"></img> <img
						id="objOntZoomin" src="resources/images/common/zoomin.png"> <img
						src="resources/images/common/gap.png" class="gap"></img> <img
						id="objOntReload" src="resources/images/common/reload.png"> <img
						src="resources/images/common/gap.png" class="gap"></img> <img
						id="objOntClean" src="resources/images/common/save.png">
						<img
						id="objOntPrinter" src="resources/images/common/printer.png">
				</div>
				<div id="objOntSvg"></div>
			</div>
		</div>

		<div class="dealObjOntLat-popover" id="dealObjOntLat">
			<div class="dealObjOntLat-poptit">
				<a href="javascript:;" title="关闭" class="close">×</a>
				<h3 id="showTitle">对象格操作</h3>
			</div>
			<div>
				<form id="objOntLatForm" class="contact_form"
					action="objOntAction!createObjOntLat.action" method="post"
					name="contact_form">
					<ul>
						<li><label for="objLatSid">对象格编号:</label> <input
							name="objLatSid" type="text" placeholder="o1" required="required"
							id="objLatSid"></li>

						<li><label for="objLatName">对象格名称:</label> <input
							name="objLatName" type="text" placeholder="参与者"
							required="required" id="objLatName"> <span
							class="form_hint">正确格式为：parti</span></li>

						<li><label for="objParentSid">父对象格编号:</label> <input
							name="objParentSid" type="text" placeholder="o1,o2,o3"
							required="required" id="objParentSid"> <span
							class="form_hint">正确格式为：o1,o2,o3</span></li>

						<li><label for="objLatNote" id="noteLB">备注:</label> <textarea
								name="objLatNote" cols="40" rows="6" placeholder="可以添加对象格的详细描述"
								required="required" id="objLatNote"></textarea></li>

						<li>
							<button class="submit" type="submit" id="saveObj">保存</button>
							<button class="submit" type="reset" id="restObj">重置</button> <input
							name="objOid" type="text" id="objOid" style="display: none">
						</li>

					</ul>
				</form>
			</div>
		</div>
		<div class="dealObjOntLat-popover-mask" id="dealObjOntLatHide"></div>


	</div>

</body>
</html>