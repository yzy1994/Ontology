//ecSvg
var ecSvgHeight = 600;
var ecSvgWidth = 1200;
var ecSvgZoomIndex = 9;
var ecShowLayerList;
var ecBrushId = "ecBrush";
var ecSvgId = "svgId";

//conceptSvg
var cSvgId = "conceptSvg";
var cSvgHeight = 600;
var cSvgWidth = 1200;
var cSvgZoomIndex = 9;
var csgshowLayerList;
var csgsvgDiv;
var csgsvgElem;
var csgdefs;
var csgmarker;
var csgrgBrush;
var cBrushId = "crgBrush";

$(document).ready(function() {
	$("#draggable").draggable();
	role = $.cookie('role');
	preontname = $.cookie('ontname');
	$('.ontname').text("\""+preontname+"\"");
	var showLayerList;
	var svgDiv = document.getElementById('objOntSvg');
	var svgElem = document.createElementNS(xmlns, "svg");
	var defs = document.createElementNS(xmlns, "defs");
	var marker = DrawMarker();
	var rgBrush = RGBrush(ecBrushId);
	defs.appendChild(rgBrush);
	defs.appendChild(marker);
	svgElem.appendChild(defs);
	svgDiv.appendChild(svgElem);
	var rectclass = "drawrect";
	
	//img:hover显示提示信息
	$('.usefulimg').hover(function(){
		$('#hint').show();
		$('#hint').css('left',event.pageX-50);
		$('#hint').css('top',event.pageY+5);
		
	},function(){
		$('#hint').hide();
	})
	
	$('#objOntAdd').hover(function(){
		$('#hint-text').text("插入事件类");
	})
	$('.zoomoutImg').hover(function(){
		$('#hint-text').text("放大层次图");
	})
	$('.zoominImg').hover(function(){
		$('#hint-text').text("缩小层次图");
	})
	$('.reloadImg').hover(function(){
		$('#hint-text').text("刷新层次图");
	})
	$('.printImg').hover(function(){
		$('#hint-text').text("下载层次图");
	})
	$('#conceptAdd').hover(function(){
		$('#hint-text').text("插入概念");
	})
	$('.saveImg').hover(function(){
		$('#hint-text').text("保存层次图位置");
	})
	//
	
	$("#objOntAdd").click(function() {
		//$('img#addAttribute').show();
		$('img#addAttribute').hide();
		$("li#lisubmit").show();
		objDelStatusGV = "add";
		formReset("addECForm");
		$('#addECWin').fadeIn(fadeTime);
		$('#dealObjOntLatHide').slideDown(slideTime);
	})
	
	$("#objOntDel").click(function(eve) {
		objDelStatusGV = "del";
		var gList = svgElem.getElementsByTagName("g");
		showObjFormConPar(gList, objDelStatusGV);
	})

	$('#objOntEdit').click(function() {
		$('img#addAttribute').show();
		objDelStatusGV = "edit";
		$("li#lisubmit").show();
		var gList = svgElem.getElementsByTagName("g");
		showObjFormConPar(gList, objDelStatusGV);
	})
	$('#objOntFind').click(function() {
		$('img#addAttribute').hide();
		objDelStatusGV = "find";
		$("li#lisubmit").hide();
		var gList = svgElem.getElementsByTagName("g");
		showObjFormConPar(gList, objDelStatusGV);
		$("img.delattr").hide();
	})

	$('#objOntZoomout').click(function() {
		if (ecSvgZoomIndex > minZoomIndex) {
			ecSvgZoomIndex--;
		}
		var zoomMul = zoomMulList[ecSvgZoomIndex];
		svgElem.setAttributeNS(null, "viewBox", "0 0 "
				+ ecSvgWidth * zoomMul + " " + ecSvgHeight
				* zoomMul);
		svgElem.setAttributeNS(null, "width" , ecSvgWidth/zoomMul);
		svgElem.setAttributeNS(null, "height" , ecSvgHeight/zoomMul);
	})

	$('#objOntZoomin').click(function() {
		if (ecSvgZoomIndex < maxZoomIndex) {
			ecSvgZoomIndex++;
		}
		var zoomMul = zoomMulList[ecSvgZoomIndex];
		svgElem.setAttributeNS(null, "viewBox", "0 0 "
				+ ecSvgWidth * zoomMul + " " + ecSvgHeight
				* zoomMul);
		svgElem.setAttributeNS(null, "width" , ecSvgWidth/zoomMul);
		svgElem.setAttributeNS(null, "height" , ecSvgHeight/zoomMul);
	})
	
	//保存层次图节点位置
	$('#objOntSaver').click(function(){
		var ecNodeList = $('#'+ecSvgId).children("g");
		var nodeArray = new Array();
		for(var i=0;i<ecNodeList.length;i++){
			var t = ecNodeList.get(i);
			var node = new Object();
			node["latname"] = t.getAttribute("id");
			node["x"] = parseInt(t.getAttribute("x"));
			nodeArray.push(node);
		}
		
		var input = new Object();
		input["ontname"] = preontname;
		input["nodes"] = nodeArray;
		var inputstr = JSON.stringify(input);
		
		$.ajax({
			url : "objOntAction!UpdateECX.action",
			type : "post",
			async : false,
			data : {
				inputStr : inputstr
			},
			success : function(data) {
				tempList = $.parseJSON(data.objOntLatListStr);
			}
		})
	})

	$("#objOntReload").click(function() {
		var svgid = ecSvgId;
		objOntLatListGV.removeAll();
		cleanSVG();
		objOntLatListGV = queryOntLatList(whichOnt);
		ecShowLayerList = createShowLayer(objOntLatListGV);
		// calculate the svg viewBox
		var maxCount = 0;
		for (var e = 0; e < ecShowLayerList.size(); e++) {
			var tempLayer = ecShowLayerList.get(e);
			if (tempLayer.size() > maxCount) {
				maxCount = tempLayer.size();
			}
		}
		maxx = 0;
		for(var i = 0; i < objOntLatListGV.size(); i++) {
			if(maxx < objOntLatListGV.get(i).x)
				maxx = objOntLatListGV.get(i).x;
		}
		
		
		var maxLayerCount = ecShowLayerList.size();
		// showLayerList.size();
		var maxSvgWidth = maxx * 1.3;
		var maxSvgHeight = ((blockHeight + yGrap) * maxLayerCount + totalYGrap) *1.1;
		if (maxSvgWidth > ecSvgWidth)
			ecSvgWidth = maxSvgWidth;
		if (maxSvgHeight > ecSvgHeight)
			ecSvgHeight = maxSvgHeight;
		
		initSVGView(ecShowLayerList.size(), svgElem, maxCount,svgid,ecSvgWidth,ecSvgHeight);
		$('#showDivHide').fadeIn(fadeTime);
		$('#showDiv').slideDown(slideTime);
		
		DrawLat(svgElem,ecShowLayerList,maxCount,rectclass,ecBrushId);
		drawLatLink(svgElem,objOntLatListGV,ecSvgId);
		
		//上下文菜单
		if(role == "builder"){
			var options = {
					items : [ {
						header : '功能菜单'
					}, 
					{
						text : '插入子事件类',
						onclick : function(eve){
							$('#eclatname').prop('readOnly',false);
							objDelStatusGV = 'add';
							var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
							var gList = svgElem.getElementsByTagName("g")
							var gid;
							for (var j = 0; j < gList.length; j++) {
								tempG = gList[j];
								if (tempG.getAttribute('data-contextify-id') == dci) {
									gid = tempG.getAttribute("id");
									break;
								}
							}
							formReset("addECForm")
							$('#addECWin').fadeIn(fadeTime);
							console.log(gid);
							$('#addecparentlatname').val(gid);
						}
					}, {
						text : '编辑事件类',
						onclick : function(eve) {
							objDelStatusGV = 'edit';
							var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
							var gList = svgElem.getElementsByTagName("g");
							var latname = getLatName(gList, dci);
							showObjFormConParRewrite(latname, "find");
						}
					}, {
						text : '删除事件类',
						onclick : function(eve) {
							var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
							var gList = svgElem.getElementsByTagName("g")
							var gid;
							for (var j = 0; j < gList.length; j++) {
								tempG = gList[j];
								if (tempG.getAttribute('data-contextify-id') == dci) {
									gid = tempG.getAttribute("id");
									break;
								}
							}
							delOntLatRewrite(gid,ELTN);
						}
					}, {
						text : '显示非分类关系',
						onclick : function(eve) {
							var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
							var gList = svgElem.getElementsByTagName("g");
							var latname = getLatName(gList, dci);
							DisplayECRelationship(preontname,latname);
						}
					}, {
						text : '返回',
						onclick : function(eve) {
							$('#contextify-menu').attr('display','none');
						}
					}, ]
				};
		}
		else{
			var options = {
				items : [ {
					header : '功能菜单'
				}, 
				{
					text : '查看事件类',
					onclick : function(eve) {
						objDelStatusGV = 'edit';
						var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
						var gList = svgElem.getElementsByTagName("g");
						var latname = getLatName(gList, dci);
						console.log(latname);
						showObjFormConParRewrite(latname, "find");
					}
				}, {
					text : '添加修改建议',
					onclick : function(eve) {
						var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
						var gList = svgElem.getElementsByTagName("g");
						var gid;
						for (var j = 0; j < gList.length; j++) {
							tempG = gList[j];
							if (tempG.getAttribute('data-contextify-id') == dci) {
								gid = tempG.getAttribute("id");
							}
						}
						
						$('#commentLatname').val(gid);
						$('#commentModal').modal();
					}
				},
				{
					text : '返回',
					onclick : function(eve) {
						$('#contextify-menu').attr('display','none');
					}
				},  
						
				]
			};
			
		}
		$('.drawrect').contextify(options);
	});


	$("#objOntPrinter").click(function() {
		var svgDiv = document.getElementById('objOntSvg');
		var svgHtml = svgDiv.innerHTML;
		var canvasDiv = document.createElement('div');
		canvasDiv.setAttribute("width", svgWidth);
		canvasDiv.setAttribute("height", svgHeight);
		var canvas = document.createElement('canvas');
		canvas.setAttribute("id", "canvasId");
		canvas.setAttribute("width", svgWidth);
		canvas.setAttribute("height", svgHeight);
		canvasDiv.appendChild(canvas);
		canvg(canvas, svgHtml);
		var svgImage = canvas.toDataURL("image/png");
		var saveWindow = window.open('about:blank',
				'image from canvas');
		saveWindow.document.write("<img src='" + svgImage
				+ "' alt='from canvas'/>");
	});
	
	$('#addECWinClose').click(function(){
		$('#addECWin').fadeOut(fadeTime);
	})
	
	$('#eveOntWinClose').click(function(){
		$('#dealObjOntLat').fadeOut(fadeTime);
		$('#ecname').text('');
		ResetECInfo();
		formReset("actionElementForm");
		formReset("timeElementForm");
		formReset("envElementForm");
		formReset("assertElementForm");
		formReset("languageElementForm");
		
	})
	$('#objElementWinClose').click(function(){
		$('#objElementEdit').fadeOut(fadeTime);
	})
	$('#timeElementWinClose').click(function(){
		$('#timeElementEdit').fadeOut(fadeTime);
	})
	$('#actionElementWinClose').click(function(){
		$('#actionElementEdit').fadeOut(fadeTime);
	})
	
	$('#envElementWinClose').click(function(){
		$('#envElementEdit').fadeOut(fadeTime);
	})
	
	$('#assertElementWinClose').click(function(){
		$('#assertElementEdit').fadeOut(fadeTime);
	})
	
	$('#languageElementWinClose').click(function(){
		$('#languageElementEdit').fadeOut(fadeTime);
	})
	
	InitconceptWin();
	
	$('#conceptimgadd').click(function(){
		addProVal();
	})
	
	$('#addobj').click(function(){
		addObj();
	})
	
	$('#removeobj').click(function(){
		removeObj();
	})
	
	InitConceptSubGraph();
			
})

function clinkG() {
	var g = this;
	var p = g.childNodes[2];
	var flag = p.getAttribute("opacity");
	if (flag == 1) {
		p.setAttribute("opacity", "0");
	} else {
		p.setAttribute("opacity", "1");
	}
}

function getGrand(objOntLat, objOntLatList, grand) {
	if (objOntLat.parentlatname == "root") {
		return grand;
	} else {
		var parentList = objOntLat.parentlatname.split(reg);
		grand++;
		var temp;
		for (i = 0; i < objOntLatList.size(); i++) {
			if (objOntLatList.get(i).latname == parentList[0]) {
				temp = objOntLatList.get(i);
				break;
			}
		}
		return getGrand(temp, objOntLatList, grand);
	}
}

function queryAllObjOntLatList() {
	var tempList;
	$.ajax({
		url : "objOntAction!queryAllObjOntLatList.action",
		type : "post",
		async : false,
		data : {},
		success : function(data) {
			tempList = $.parseJSON(data.objOntLatListStr);
		}
	})
	for (var i = 0; i < tempList.length; i++) {
		var temp = tempList[i];
		var objOntLat = new ObjOntLat();
		objOntLat.oid = temp.oid;
		objOntLat.latSid = temp.latSid;
		objOntLat.latName = temp.latName;
		objOntLat.parentSid = temp.parentSid;
		objOntLat.latNote = temp.latNote;
		objOntLatListGV.add(objOntLat);
	}
	for (var j = 0; j < objOntLatListGV.size(); j++) {
		var tempecls = objOntLatListGV.get(j);
		var grand = getGrand(tempecls, objOntLatListGV, 0);
		tempecls.setGrand(grand);
	}
	return objOntLatListGV;
}

function createShowLayer(tempList) {
	var showLayerList = new ArrayList();
	var maxGrand = 0;
	for (var i = 0; i < tempList.size(); i++) {
		var tempecls = tempList.get(i);
		if (tempecls.grand > maxGrand)
			maxGrand = tempecls.grand;
	}
	
	for(var j=0;j<=maxGrand;j++){
		var showLayer = new ShowLayer(j);
		showLayerList.add(showLayer);
	}
	var rootList = new ArrayList();
	
	for(var j=0;j<tempList.size();j++){
		if(tempList.get(j).parentlatname == "root")
			rootList.add(tempList.get(j));
	}

	var showOrder = 0;
	
	for(var j=0;j<rootList.size();j++){
		var root = rootList.get(j);
		var layerList = new Array();
		for(var k=0;k<=maxGrand;k++){
			layerList[k] = new ShowLayer(k);
		}
		layerList[0].add(root);
		for (var l = 0; l < layerList.length; l++) {
			for (var n = 0; n < layerList[l].size(); n++) {
				temp = layerList[l].get(n);
				if (!showLayerList.get(l).contains(temp)) {
					temp.setShowOrder(showOrder);
					showLayerList.get(l).add(temp);
					showOrder++;
				}
				for (var m = 0; m < tempList.size(); m++) {
					if (l == maxGrand)
						continue;
					/*if (tempList.get(m).parentlatname == temp.latname)
						layerList[l + 1].add(tempList.get(m));*/
					var parents = tempList.get(m).parentlatname.split(",");
						if(parents[0]==temp.latname){
								layerList[l + 1].add(tempList.get(m));
						}
							
				}
			}
		}
	}
	return showLayerList;
}

function showObjFormConPar(gList, objDelStatusGV) {
	$('li.addli').remove();
	var tempG;
	var count = 0;
	var gid;
	for (var j = 0; j < gList.length; j++) {
		tempG = gList[j];
		if (tempG.getAttribute("isSel") == "tru") {
			count++;
			gid = tempG.getAttribute("id");
		}
	}
	if (count == 0) {
		alert("please select drawOntLat");
	} else if (count > 1) {
		alert("select only one drawOntLat");
	} else if (count == 1) {
		if (objDelStatusGV == "find" || objDelStatusGV == "edit") {
			var id = gid;
			var objOntLat;
			for (i = 0; i < objOntLatListGV.size(); i++) {
				var tempObjOntLat = objOntLatListGV.get(i);
				if (tempObjOntLat.latSid == id) {
					objOntLat = tempObjOntLat;
					break;
				}
			}
			formRest();
			$('#objOid').val(objOntLat.oid);
			$('#objLatSid').val(objOntLat.latSid);
			$('#objLatName').val(objOntLat.latName);
			$('#objParentSid').val(objOntLat.parentSid);
			$('#objLatNote').val(objOntLat.latNote);

			$('#dealObjOntLat').fadeIn(fadeTime);
			$('#dealObjOntLatHide').slideDown(slideTime);

			var ajaxurl = "objOntAction!queryLatBySid.action";
			var input = {};
			input["ontname"] = preontname;
			input["collection"] = whichOnt;
			input["latsid"] = objOntLat.latSid;
			var inputstr = JSON.stringify(input);
			var resultList;
			$.ajax({
				url : ajaxurl,
				type : "post",
				async : false,
				data : {
					inputStr : inputstr
				},
				success : function(data) {
					resultList = $.parseJSON(data.additionStr);
				}
			})
			additionnum = 0;
			var keyarray = new Array();
			for ( var item in resultList)
				keyarray.push(item);
			for (var i = 0; i < keyarray.length; i++) {
				var sheight = $('#dealObjOntLat').css("height");
				sheight = String(parseInt(sheight.slice(0, -2)) + 60) + "px";
				$('#dealObjOntLat').css("height", sheight);
				additionnum++;
				var att = keyarray[i];
				var valu = resultList[keyarray[i]];
				var liid = "li" + additionnum;
				idarray.push(additionnum);
				var proid = "pro" + liid;
				var attid = "att" + liid;
				$('li#linote')
						.after(
								"<li class = \"addli\" id=\""
										+ liid
										+ "\"><input required=\"required\" id=\""
										+ proid
										+ "\"><input required=\"required\" id=\""
										+ attid
										+ "\"><img class=\"delattr\" id=\""
										+ liid
										+ "\" src=\"resources/images/delete.png\"></img></li>");
				$('img#' + liid).click(function() {
					console.log("delete");
					$('li#' + liid).remove();
					var temp = liid.substr(liid.length - 1);
					var index = idarray.indexOf(parseInt(temp));
					idarray.remove(index);
				});
				$("input#" + proid).val(att);
				$("input#" + attid).val(valu);
			}
		} else if (objDelStatusGV == "del") {
			var ontName;
			var input = {};
			input["ontname"] = preontname;
			input["collection"] = whichOnt;
			input["latsid"] = gid;
			var inputstr = JSON.stringify(input);
			var delurl = "objOntAction!deleteLatByMongo.action";
			$.ajax({
				url : delurl,
				type : "post",
				async : true,
				data : {
					inputStr : inputstr
				},
				success : function(data) {
					objDelStatusGV = "none";
					$("#objOntReload").click();
				}
			});
		}
	}
}

function cleanSVG() {
	$("#svgId").find("g").remove();
	$("#svgId").find("line").remove();
}

function cleanSVGid(svgid) {
	$("#"+svgid).find("g").remove();
	$("#"+svgid).find("line").remove();
}

function initSVGView(size, svgElem, maxCount,svgid,svgWidth,svgHeight) {
	svgElem.setAttributeNS(null, "viewBox", "0 0 " + svgWidth
			+ " " + svgHeight);
	svgElem.setAttributeNS(null, "width", svgWidth);
	svgElem.setAttributeNS(null, "id", svgid);
	svgElem.setAttributeNS(null, "height", svgHeight);
	svgElem.style.display = "inline";
}

function drawLatLink(svgElem,list,svgId) {
	/*
	 * add the line for the node which has link
	 */
	for (var f = 0; f < list.size(); f++) {
		var temp = list.get(f);
		if (temp.parentSid != "root") {
			var parentList = temp.parentlatname.split(reg);
			for (var z = 0; z < parentList.length; z++) {
				if(parentList[z]=="root") continue;
				var lineA = DrawConLine(parentList[z], temp.latname,svgId);
				if(typeof lineA != "undefined" && lineA != null){
					svgElem.appendChild(lineA);
				}
			}
		}
	}
}

function formRest() {
	var form = document.getElementById('objOntLatForm');
	form.reset();
}

function formReset(formid) {
	var form = document.getElementById(formid);
	form.reset();
}


function queryOntLatList(whichont) {
	var input = {};
	if(whichOnt==ELTN){
		url = ecFindUrl;
	}else{
		url = conceptFindUrl;
	}
	input["ontname"] = preontname;
	var tempList;
	var inputstr = JSON.stringify(input);
	$.ajax({
		url : url,
		type : "post",
		async : false,
		data : {
			inputStr : inputstr
		},
		success : function(data) {
			tempList = $.parseJSON(data.resultStr);
		}
	})
	for (var i = 0; i < tempList.length; i++) {
		var temp = tempList[i];
		var objlat = new ObjOntLat();
		
		objlat.latsid = (typeof (temp.latSid) == "undefined") ? temp.latsid
				: temp.latSid;
		objlat.latname = (typeof (temp.latName) == "undefined") ? temp.latname
				: temp.latName;
		objlat.parentlatname = (typeof (temp.parentSid) == "undefined") ? temp.parentlatname
				: temp.parentSid;
		objlat.latnote = (typeof (temp.latNote) == "undefined") ? temp.latnote
				: temp.latNote;
		objlat.x = temp.x;
		
		objOntLatListGV.add(objlat);
	}
	for (var j = 0; j < objOntLatListGV.size(); j++) {
		var tempecls = objOntLatListGV.get(j);
		var grand = getGrand(tempecls, objOntLatListGV, 0);
		tempecls.setGrand(grand);
	}
	return objOntLatListGV;
}

function getLatName(gList, dci){
	$('#eclatname').prop('readOnly',true);
	var latname;
	for (var j = 0; j < gList.length; j++) {
		tempG = gList[j];
		if (tempG.getAttribute('data-contextify-id') == dci) {
			latname = tempG.getAttribute("id");
		}
	}
	return latname;
}

//编辑事件类
function showObjFormConParRewrite(latname , objDelStatusGV)/*dci:data-contextify-id objDelStatusGV:'edit'/'find'*/ {
	gid = latname
	
	$('#ecname').text(gid);
	$('.ecname').text(gid);
	
	$('li.addli').remove();
	if (objDelStatusGV == "find" || objDelStatusGV == "edit") {
		var id = gid;
		var objOntLat;
		for (i = 0; i < objOntLatListGV.size(); i++) {
			var tempObjOntLat = objOntLatListGV.get(i);
			if (tempObjOntLat.latname == id) {
				objOntLat = tempObjOntLat;
				break;
			}
		}
		formRest();
		//$('#objOid').val(objOntLat.oid);
		$('#eclatname').val(objOntLat.latname);
		$('#ecparentlatname').val(objOntLat.parentlatname);
		$('#eclatnote').val(objOntLat.latnote);
		
		updateECInfo(objOntLat.latname);
		
		$('#dealObjOntLat').fadeIn(fadeTime);
		//时间要素编辑窗口
		$('label#let').click(function(){
			$('#timeElementEdit').css('height','300px');
			$('#timeElementEdit').show();
			$('#tecname').attr('evesid',objOntLat.latSid);
		})
		
		$('label#leo').click(function(){
			$('#objElementEdit').show();
			$('#aecname').attr('evesid',objOntLat.latSid);
			
		})
		
		$('label#lea').click(function(){
			$('#actionElementEdit').show();
			$('#ecname').attr('evesid',objOntLat.latSid);
		})
		
		$('label#lee').click(function(){
			//环境要素编辑窗口
			$('#envElementEdit').show();
			$('#ecname').attr('evesid',objOntLat.latSid);
		})
		
		$('label#leas').click(function(){
			$('#assertElementEdit').show();
		})
		
		$('label#lele').click(function(){
			$('#languageElementEdit').show();
		})
	} 
}

//编辑概念格
function showConceptFormConPar(latname , objDelStatusGV)/*dci:data-contextify-id objDelStatusGV:'edit'/'find'*/ {
	var gid = latname
	if (objDelStatusGV == "find" || objDelStatusGV == "edit") {
		var id = gid;
		var objOntLat;
		for (i = 0; i < conceptListGV.size(); i++) {
			var tempObjOntLat = conceptListGV.get(i);
			if (tempObjOntLat.latname == id) {
				objOntLat = tempObjOntLat;
				break;
			}
		}
		formReset("conceptEditForm");
		//$('#conceptlatsid').val(objOntLat.latSid);
		$('#conceptlatname').val(objOntLat.latname);
		$('#conceptparentlatname').val(objOntLat.parentlatname);
		
		//特征-特征值
		var acturl = queryLatUrl;
		var input={};
		input["collection"]=CTN;
		input["ontname"]=preontname;
		input["latname"]=objOntLat.latname;
		inputstr = JSON.stringify(input);
		
		$.ajax({
			url: acturl,
			type: "post",
			async: false,
			data:{
				inputStr : inputstr
			},
			success:function(data){
				var resultList = $.parseJSON(data.additionStr);
				additionnum = 0;
				var keyarray = new Array();
				for ( var item in resultList)
					keyarray.push(item);
				for (var i = 0; i < keyarray.length; i++) {
					if(keyarray[i]=="parentlatname")
						continue;
					addProVal();
					var pro = keyarray[i];
					var attr = resultList[keyarray[i]];
					$("#proli"+additionnum.toString()).val(pro);
					$("#attli"+additionnum.toString()).val(attr);
				}
			}
		})
		
		$('#conceptEditWin').fadeIn(fadeTime);
	} 
}
function delOntLatRewrite(gid,collectionName){
	var acturl;
	if(collectionName==CTN)
		acturl = conceptDelUrl;
	else
		acturl = ecDelurl;
	var input={};
	input["ontname"]=preontname;
	input["collection"] = collectionName;
	input["latname"] = gid;
	var inputstr = JSON.stringify(input);
	$.ajax({
		url : acturl,
		type : "post",
		async : true,
		data : {
			inputStr: inputstr
		},
		success : function(data) {
			if(data.operateMsg=="existcn"){
				alert("该节点存在子节点,不能删除");
			}else{
				$("#objOntReload").click();
			}
		}
	});
	input = {};
	input["userip"]=userIP;
	input["appversion"]=appVersion;
	input["latname"]=gid;
	input["operation"]="del";
	inputstr = JSON.stringify(input);
	$.ajax({
		url : "objOntAction!insertRecord.action",
		type : "post",
		async : true,
		data : {
			inputStr : inputstr
		},
		success : function(data){
			return;
		}
	})
}
function updateTimeElement(evelatname){
	$('label#leti').text('');
	var input = {};
	input["ontname"]=preontname;
	input["evelatname"]=evelatname;
	var inputstr = JSON.stringify(input);
	$.ajax({
		url : timeElementFindUrl,
		type : "post",
		async : false,
		data : {
			inputStr : inputstr
		},
		success : function(data) {
			if(data.resultStr!=""){
				var temp = $.parseJSON(data.resultStr);
				$('label#leti').append("开始时间:"+temp.start + " 延续时间:" + temp.length);
				$('#tsStart').val(temp.start);
				$('#tsLength').val(temp.length);
			}else{
				
			}
		}
	})
}


function InitconceptWin(){
	var svgid = "conceptSvg";
	var rectclass = "conceptrect";
	csvgDiv = document.getElementById('conceptSvgDiv');
	csvgElem = document.createElementNS(xmlns, "svg");
	cdefs = document.createElementNS(xmlns, "defs");
	cmarker = DrawMarker();
	crgBrush = RGBrush(cBrushId);
	cdefs.appendChild(crgBrush);
	cdefs.appendChild(cmarker);
	csvgElem.appendChild(cdefs);
	csvgDiv.appendChild(csvgElem);
		
	$('#conceptSvgWinClose').click(function(){
		$('#conceptSvgWin').hide();
	})
	
	$('#conceptEditWinClose').click(function(){
		$('#conceptEditWin').hide();
		$('.delattr').click();
	})
	
	$('#conceptZoomout').click(function() {
		if (cSvgZoomIndex > minZoomIndex) {
			cSvgZoomIndex--;
		}
		var zoomMul = zoomMulList[cSvgZoomIndex];
		csvgElem.setAttributeNS(null, "viewBox", "0 0 "
				+ cSvgWidth * zoomMul + " " + cSvgHeight
				* zoomMul);
		csvgElem.setAttributeNS(null, "height", cSvgHeight / zoomMul); 
		csvgElem.setAttributeNS(null, "width", cSvgWidth / zoomMul); 
	})

	$('#conceptZoomin').click(function() {
		if (cSvgZoomIndex < maxZoomIndex) {
			cSvgZoomIndex++;
		}
		var zoomMul = zoomMulList[cSvgZoomIndex];
		csvgElem.setAttributeNS(null, "viewBox", "0 0 "
				+ cSvgWidth * zoomMul + " " + cSvgHeight
					* zoomMul);
		csvgElem.setAttributeNS(null, "height", cSvgHeight / zoomMul); 
		csvgElem.setAttributeNS(null, "width", cSvgWidth / zoomMul); 
	})
	
	$("#conceptPrinter").click(function() {
			var svgDiv = document.getElementById('conceptSvgDiv');
			var svgHtml = svgDiv.innerHTML;
			var canvasDiv = document.createElement('div');
			canvasDiv.setAttribute("width", svgWidth);
			canvasDiv.setAttribute("height", svgHeight);
			var canvas = document.createElement('canvas');
			canvas.setAttribute("id", "canvasId");
			canvas.setAttribute("width", svgWidth);
			canvas.setAttribute("height", svgHeight);
			canvasDiv.appendChild(canvas);
			canvg(canvas, svgHtml);
			var svgImage = canvas.toDataURL("image/png");
			var saveWindow = window.open('about:blank',
					'image from canvas');
			saveWindow.document.write("<img src='" + svgImage
					+ "' alt='from canvas'/>");
	});
	
	$('#conceptAdd').click(function(){
		$('#conceptlatname').prop('readOnly',false);
		addition=0;
		objDelStatusGV = 'add';
		formReset("conceptEditForm");
		$('#conceptEditWin').show();
	})
	
	$('#conceptSaver').click(function(){
		var ecNodeList = $('#'+cSvgId).children("g");
		var nodeArray = new Array();
		for(var i=0;i<ecNodeList.length;i++){
			var t = ecNodeList.get(i);
			var node = new Object();
			node["latname"] = t.getAttribute("id");
			node["x"] = parseInt(t.getAttribute("x"));
			nodeArray.push(node);
		}
		
		var input = new Object();
		input["nodes"] = nodeArray;
		var inputstr = JSON.stringify(input);
		
		$.ajax({
			url : "objOntAction!UpdateConceptX.action",
			type : "post",
			async : false,
			data : {
				inputStr : inputstr
			},
			success : function(data) {
				tempList = $.parseJSON(data.objOntLatListStr);
			}
		})
	})
			
	$('#conceptReload').click(function(){
		conceptListGV.removeAll();
		cleanSVGid(svgid);
		conceptListGV = queryConceptLatList();
		cshowLayerList = createShowLayer(conceptListGV);
		
		maxx = 0;
		for(var i = 0; i < conceptListGV.size(); i++) {
			if(maxx < conceptListGV.get(i).x)
				maxx = conceptListGV.get(i).x;
		}
		
		var maxCount = 0;
		for (var e = 0; e < cshowLayerList.size(); e++) {
			var tempLayer = cshowLayerList.get(e);
			if (tempLayer.size() > maxCount) {
				maxCount = tempLayer.size();
			}
		}
		
		var maxLayerCount = cshowLayerList.size();
		// showLayerList.size();
		var maxSvgWidth = maxx * 1.3;
		var maxSvgHeight = ((blockHeight + yGrap) * maxLayerCount + totalYGrap) *1.1;
		if (maxSvgWidth > cSvgWidth)
			cSvgWidth = maxSvgWidth;
		if (maxSvgHeight > cSvgHeight)
			cSvgHeight = maxSvgHeight;
		
		initSVGView(cshowLayerList.size(), csvgElem, maxCount,"conceptSvg",cSvgWidth,cSvgHeight);
		
		DrawLat(csvgElem,cshowLayerList,maxCount,rectclass,cBrushId);
		
		drawLatLink(csvgElem,conceptListGV,"conceptSvg");
		
		//上下文菜单
		if(role=="builder"){
			var conceptoptions = {
					items : [ {
						header : '功能菜单'
					}, {
						text : '插入子概念',
						onclick : function(eve){
							$('#conceptlatname').prop('readOnly',false);
							addition=0;
							objDelStatusGV = 'add';
							var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
							var gList = csvgElem.getElementsByTagName("g")
							var gid;
							for (var j = 0; j < gList.length; j++) {
								tempG = gList[j];
								if (tempG.getAttribute('data-contextify-id') == dci) {
									gid = tempG.getAttribute("id");
									break;
								}
							}
							formReset("conceptEditForm");
							$('#conceptparentlatname').val(gid);
							$('#conceptEditWin').show();
						}
					}, {
						text : '编辑概念',
						onclick : function(eve) {
							$('#conceptlatname').prop('readOnly',true);
							objDelStatusGV = 'edit';
							var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
							var gList = csvgElem.getElementsByTagName("g");
							latname = getLatName(gList, dci);
							showConceptFormConPar(latname , "edit");
						}
					}, {
						text : '删除概念',
						onclick : function(eve) {
							var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
							var gList = csvgElem.getElementsByTagName("g")
							var gid;
							for (var j = 0; j < gList.length; j++) {
								tempG = gList[j];
								if (tempG.getAttribute('data-contextify-id') == dci) {
									gid = tempG.getAttribute("id");
									console.log(gid);
									break;
								}
							}
							delOntLatRewrite(gid,CTN);
							$('#conceptReload').click();
						}
					}, {
						text : '返回',
						onclick : function(eve) {
							$('#contextify-menu').attr('display','none');
						}
					}, ]
				};
		}else{
			var conceptoptions = {
					items : [ {
						header : '功能菜单'
					}, {
						text : '查看概念',
						onclick : function(eve) {
							$('#conceptlatname').prop('readOnly',true);
							objDelStatusGV = 'edit';
							var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
							var gList = csvgElem.getElementsByTagName("g");
							latname = getLatName(gList, dci);
							showConceptFormConPar(latname, "edit");
						}
					}, {
						text : '返回',
						onclick : function(eve) {
							$('#contextify-menu').attr('display','none');
						}
					}, ]
				};
		}
		
		$('.conceptrect').contextify(conceptoptions);
	})
}

function queryConceptLatList() {
	var tempList;
	var list = new ArrayList();
	var url = conceptFindUrl;
	$.ajax({
		url : url,
		type : "post",
		async : false,
		data : {
		},
		success : function(data) {
			//if(data.operateMsg=="No Concept")
			if(data.resultStr!=""){
				tempList = $.parseJSON(data.resultStr);
			}
		}
	})
	conceptList = [];
	for(var i=0;i<tempList.length;i++){
		temp = tempList[i];
		conceptList[temp.latname]=temp.parentlatname;
	}
	for (var i = 0; i < tempList.length; i++) {
		var temp = tempList[i];
		var concept = new ObjOntLat();
		concept.latname = temp.latname;
		concept.parentlatname = temp.parentlatname;
		concept.x = temp.x;
		list.add(concept);
	}
	for (var j = 0; j < list.size(); j++) {
		var tempecls = list.get(j);
		var grand = getGrand(tempecls, list, 0);
		tempecls.setGrand(grand);
	}
	return list;
}

function addProVal(){
	if($('#divproval').children().length>=4)
		return;
    additionnum++;
    idarray.push(additionnum);
    var liid = "li" + additionnum;
    var proid = "pro" + liid;
    var attid = "att" + liid;
    $('div#divproval').append("<li class=\"addli\" id=\"" + liid + "\"><input class=\"cpro\" required=\"required\" id=\"" + proid + "\"><input required=\"required\" class=\"cval\" id=\"" + attid + "\"><img class=\"delattr\" id=\"" + liid + "\" src=\"resources/images/delete.png\"></img></li>");
    $('img#' + liid).click(function() {
        $('li#' + liid).remove();
        var temp = liid.substr(liid.length - 1);
        var index = idarray.indexOf(parseInt(temp));
        idarray.remove(index);
    });
}

function addObj(){
	objnum++;
	$('#objFormItem').append("<div class=\"form-col\" id=\"col"+ objnum.toString() +"\"><ul><li class=\"objname\"></li><li>数量：</li><li><select name=\"amount\" class=\"sActAmout\" id=\"sAmount"+objnum.toString()+"\"><option value=\"1\">1</option><option value=\"2\">2</option><option value=\"3\">3</option><option value=\"少许\">少许</option><option value=\"近半\">近半</option><option value=\"半\">半</option><option value=\"多半\">多半</option><option value=\"大量\">大量</option></select></li>"+
							"<li>所属概念：</li>"+
							"<li><select name=\"conceptsid\" class=\"sActConcept\" id=\"sConcept"+objnum.toString()+"\"></select></li><li>语言称谓：</li><li><input name=\"lane\" class=\"iActLE\" id=\"iLE"+objnum.toString()+"\" type=\"text\"></li></ul></div>");
	for(var i=0;i<conceptListGV.size();i++){
		$('#sConcept'+objnum).append("<option value=\"" + conceptListGV.get(i).latname + "\">"+ conceptListGV.get(i).latname +"</option>");
	}
	
	$($($('#col'+objnum).children("ul").get(0)).children("li").get(0)).text('对象'+objnum.toString());
	
	/*$('#sConcept'+objnum).hover(function(){
		reloadConceptSubGraph($('#sConcept'+objnum).val());
	})*/
}
function removeObj(){
	if(objnum<=1)
		return;
	$("#col"+objnum.toString()).remove();
	objnum--;
}

function updateObjElement(evelatname){
	objnum=0;
	$('.form-col').remove();
	var input = {};
	input["ontname"]=preontname;
	input["evelatname"]=evelatname;
	var leoival = "";
	var inputstr=JSON.stringify(input);
	$.ajax({
		url: objElementFindUrl,
		type: "post",
		async: false,
		data:{
			inputStr:inputstr,
		},
		success:function(data){
			if(data.operateMsg == "finded"){
				var tempList = $.parseJSON(data.resultStr);
				for(var i=0;i<tempList.length;i++){
					addObj();
					var temp = tempList[i];
					$("#sAmount"+objnum.toString()).val(temp["amount"]);
					var sc = "#sConcept"+objnum.toString();
					var scv = temp["conceptlatname"];
					$("#sConcept"+objnum.toString()).val(scv);
					$("#iLE"+objnum.toString()).val(temp["lane"]);
					leoival += " 对象"+objnum.toString()+": "+ scv;
				}
			}
			else{
				addObj();
			}
		}
	})
	$('#leoi').text(leoival);
	if(objnum==0){
		addObj();
	}
}

function updateActionElement(evelatname){
	var input = {};
	input["ontname"]=preontname;
	input["evelatname"]=evelatname;
	var inputstr=JSON.stringify(input);
	$.ajax({
		url : actionElementFindUrl,
		type : "post",
		async : false,
		data:{
			inputStr:inputstr,
		},
		success:function(data){
			if(data.resultStr!=""){
				var temp = $.parseJSON(data.resultStr);
				$('#sDegree').val(temp.degree);
				$('#iTool').val(temp.tool);
				$('#iMethod').val(temp.method);
				$('label#leai').text("程度:"+temp.degree + " 工具:" + temp.tool+ " 方法:" +temp.method);	
			}
		}
	})
}
function updateEnvElement(evelatname){
	var input = {};
	input["ontname"]=preontname;
	input["evelatname"]=evelatname;
	var inputstr=JSON.stringify(input);
	$.ajax({
		url : envElementFindUrl,
		type : "post",
		async : false,
		data:{
			inputStr:inputstr,
		},
		success:function(data){
			if(data.resultStr!=""){
				var temp = $.parseJSON(data.resultStr);
				$('#envsConcept').val(temp.conceptlatname);
				$('#iEnvlane').val(temp.envlane);
				$('label#leei').text(temp.conceptlatname+temp.envlane);
			}
		}
	})
}

function updateLanElement(evelatname){
	var input = {};
	input["ontname"]=preontname;
	input["evelatname"]=evelatname;
	var inputstr=JSON.stringify(input);
	$.ajax({
		url : languageElementFindUrl,
		type : "post",
		async : false,
		data:{
			inputStr:inputstr,
		},
		success:function(data){
			if(data.resultStr!=""){
				var temp = $.parseJSON(data.resultStr);
				$('#lelei').text(temp.triggerwords+temp.collocation);
				$('#iTriggerWords').val(temp.triggerwords);
				$('#iCollocation').val(temp.collocation);
			}
		}
	})
}

function updateAssertElement(evelatname){
	var input = {};
	input["ontname"]=preontname;
	input["evelatname"]=evelatname;
	var inputstr=JSON.stringify(input);
	$.ajax({
		url : assertElementFindUrl,
		type : "post",
		async : false,
		data:{
			inputStr:inputstr,
		},
		success:function(data){
			if(data.resultStr!=""){
				var temp = $.parseJSON(data.resultStr);
				$('#leasi').text("前置状态"+temp.prestate+"中间断言"+temp.massert+"后置状态"+temp.poststate);
				$('#iPrestate').val(temp.prestate);
				$('#iMassert').val(temp.massert);
				$('#iPoststate').val(temp.poststate);
			}
		}
	})
}

function updateConceptList(){
	conceptList = [];
	var clist = queryConceptList();
	conceptList = [];
	for(var i=0;i<clist.length;i++){
		temp = clist[i];
		conceptList[temp.latname]=temp.parentlatname;
	}
}

function queryConceptList(){
	var tempList;
	$.ajax({
		url: conceptFindUrl,
		type: "post",
		async: false,
		data:{
		},
		success:function(data){
			tempList = $.parseJSON(data.resultStr);
		}
	});
	return tempList;
}

function InitConceptSubGraph(){
	csgsvgDiv = document.getElementById('conceptSubGraphSvgDiv');
	csgsvgElem = document.createElementNS(xmlns, "svg");
	csgdefs = document.createElementNS(xmlns, "defs");
	csgmarker = DrawMarker();
	csgrgBrush = RGBrush();
	csgdefs.appendChild(csgrgBrush);
	csgdefs.appendChild(csgmarker);
	csgsvgElem.appendChild(csgdefs);
	csgsvgDiv.appendChild(csgsvgElem);
	
	$('#conceptSubgraphWinClose').click(function(){
		$('#conceptSubgraphWin').hide();
	})
	
}

function reloadConceptSubGraph(conceptname){
	
	var svgid = "conceptSubGraphSvg";
	var rectclass = "csgrect";
	
	if(!($('#conceptSubgraphWin').css('display')=='block')){
		$('#conceptSubgraphWin').show();
	}else{
		return;
	}
	
	conceptSubGraphList.removeAll();
	cleanSVGid(svgid);
	conceptSubGraphList = queryConceptSubGraphList(conceptname);
	
	conceptListGV.removeAll();
	conceptListGV = queryConceptLatList();
	
	var maxCount = 0;
	initSVGView(10, csgsvgElem, maxCount,svgid);

	var x = 50;
	var y = 50;
	
	for(var i=0 ; i < conceptListGV.size();i++){
		if(conceptListGV.get(i).latname == conceptname){
			var conceptParentList = conceptListGV.get(i).parentlatname.split(",");
			for(var z=0;z<conceptParentList.length;z++){
				var ontname = {};
				for(var j=0 ; j < conceptListGV.size();j++){
					if(conceptListGV.get(j).latname == conceptParentList[z]){
						ontname =  conceptListGV.get(j);
						break;
					}
				}
				
				var drawOntLat = new DrawOntLat(ontname);
				drawOntLat.locX = x;
				drawOntLat.locY = y;
				var g = drawOntLat.drawLat(rectclass);
				csgsvgElem.appendChild(g);
				x+=100;
			}
			x=50;
			y+=50;
			
			var drawOntLat = new DrawOntLat(conceptListGV.get(i));
			drawOntLat.locX = x;
			drawOntLat.locY = y;
			var g = drawOntLat.drawLat(rectclass);
			csgsvgElem.appendChild(g);
			
			x=50;
			y+=50;
			break;
		}
		
	}
	for(var i=0 ; i < conceptListGV.size();i++){
		if(conceptListGV.get(i).parentlatname == conceptname){
			
			var drawOntLat = new DrawOntLat(conceptListGV.get(i));
			drawOntLat.locX = x;
			drawOntLat.locY = y;
			var g = drawOntLat.drawLat(rectclass);
			csgsvgElem.appendChild(g);
			x+=50;
		}
	}
		
	drawLatLink(csgsvgElem,conceptSubGraphList,"conceptSubGraphSvg");
}

//
function queryConceptSubGraphList(conceptname){
	var t;
	for(var temp in conceptList){
		if(temp==conceptname){
			t={};
			t.latname = temp;
			t.parentlatname = conceptList[temp];
			conceptSubGraphList.add(t);
			var conceptParent = conceptList[temp].split();
			for(var i=0;i<conceptParent.length;i++){
				t={};
				t.latname = conceptParent[i];
				t.parentlatname = conceptList[conceptParent[i]];
				conceptSubGraphList.add(t);
			}
		}
		
		if(conceptList[temp] == conceptname){
			t={};
			t.latname = temp;
			t.parentlatname = conceptList[temp];
			conceptSubGraphList.add(t);
		}
	}
	return conceptSubGraphList
}

function ResetECInfo(){
	$('#leai').text("");
	$('#leoi').text("");
	$('#leti').text("");
	$('#leei').text("");
	$('#leasi').text("");
	$('#lelei').text("");
}

function updateECInfo(latname){
	var input = {};
	input["ontname"] = preontname;
	input["evelatname"] = latname;
	var inputstr = JSON.stringify(input);
	$.ajax({
		url : ecInfoEditUrl,
		type : "post",
		async : false,
		data : {
			inputStr : inputstr
		},
		success : function(data) {
			var actionstr = $.parseJSON(data.actInfo);
			var timestr = $.parseJSON(data.timeInfo);
			var envstr = $.parseJSON(data.envInfo);
			var assertstr = $.parseJSON(data.assertInfo);
			var lanstr = $.parseJSON(data.lanInfo);
			
			if(actionstr!=null){
				var temp = actionstr;
				$('#sDegree').val(temp.degree);
				$('#iTool').val(temp.tool);
				$('#iMethod').val(temp.method);
				$('label#leai').text("程度:"+temp.degree + " 工具:" + temp.tool+ " 方法:" +temp.method);	
			}else{
				$('#leai').text('无约束');
			}
			if(timestr!=null){
				var temp = timestr;
				$('label#leti').append("开始时间:"+temp.start + " 延续时间:" + temp.length);
				$('#tsStart').val(temp.start);
				$('#tsLength').val(temp.length);
			}else{
				$('#leti').text('无约束');
			}
			if(envstr!=null){
				var temp = envstr;
				$('#envsConcept').val(temp.conceptlatname);
				$('#iEnvlane').val(temp.envlane);
				$('label#leei').text("所属概念:"+temp.conceptlatname+" 语言表现:"+temp.envlane);
			}else{
				$('#leei').text('无约束');
			}
			if(assertstr!=null){
				var temp = assertstr;
				$('#leasi').text("前置状态"+temp.prestate+"中间断言"+temp.massert+"后置状态"+temp.poststate);
				$('#iPrestate').val(temp.prestate);
				$('#iMassert').val(temp.massert);
				$('#iPoststate').val(temp.poststate);
			}else{
				$('#leasi').text('无约束');
			}
			if(lanstr!=null){
				var temp = lanstr;
				$('#lelei').text("触发词:"+temp.triggerwords+" 搭配:"+temp.collocation);
				$('#iTriggerWords').val(temp.triggerwords);
				$('#iCollocation').val(temp.collocation);
			}else{
				$('#lelei').text('无约束');
			}
			$('.form-col').remove();
			objnum=0;
			if(data.objInfo!=""){
				var tempList = $.parseJSON(data.objInfo);
				var leoival ="";
				for(var i=0;i<tempList.length;i++){
					addObj();
					var temp = tempList[i];
					$("#sAmount"+objnum.toString()).val(temp["amount"]);
					var sc = "#sConcept"+objnum.toString();
					var scv = temp["conceptlatname"];
					$("#sConcept"+objnum.toString()).val(scv);
					$("#iLE"+objnum.toString()).val(temp["lane"]);
					leoival += " 对象"+objnum.toString()+": "+ scv;
				}
				$('#leoi').text(leoival);
			}else{
				$('#leoi').text("无约束");
			}
			
			if(objnum==0){
				addObj();
			}
		}
	})
}

function ecNotEditable(){
	$('#ecparentlatname').prop('readOnly',true);
	$('#eclatnote').prop('readOnly',true);
	$('.submit').hide();
	
	$('#sDegree').prop('readOnly',true);
	$('#iTool').prop('readOnly',true);
	$('#iMethod').prop('readOnly',true);
	
	$('.sActConcept').prop('readOnly',true);
	$('.sActAmout').prop('readOnly',true);
	$('.iActLE').prop('readOnly',true);
	
	$('#tsStart').prop('readOnly',true);
	$('#tsLength').prop('readOnly',true);
	
	$('#envsConcept').prop('readOnly',true);
	$('#iEnvlane').prop('readOnly',true);
	
	$('#iPrestate').prop('readOnly',true);
	$('#iMassert').prop('readOnly',true);
	$('#iPoststate').prop('readOnly',true);
	
	$('#iTriggerWords').prop('readOnly',true);
	$('#iCollocation').prop('readOnly',true);
	
	$('#removeobj').hide();
	$('#addobj').hide();
	
	$('.btn-info').hide();
}

function conceptNotEditable(){
	$('#conceptparentlatname').prop('readOnly',true);
	$('.cpro').prop('readOnly',true);
	$('.cval').prop('readOnly',true);
	$('#conceptimgadd').hide();
}

function NewCreLoc(maxCount, rowCount) {
	var midLoc = Math.floor(maxCount / 2) + 1
	var locList = new Array();
	var step = 1;
	var count = maxCount;
	while(rowCount < count/2){
		count /= 2;
		step *= 2;
	}
	
	for(var i = 0 ;i< rowCount ;i++){
		locList[i] = step * (i+1);
	}
	if(rowCount == 1)
		locList[0] = midLoc;
	
	return locList;
}

function DrawLat(svgElem,showLayerList,maxCount,rectclass,BrushId){
	for(var l=0;l<showLayerList.size();l++){
		var tempLayer = showLayerList.get(l)
		var rowCount = tempLayer.size();
		var locList = NewCreLoc(maxCount, rowCount);
		var y = l * (blockHeight + yGrap) + startY;
		for(var m=0;m<tempLayer.size();m++){
			var tempCls = tempLayer.get(m);
			var drawOntLat = new DrawOntLat(tempCls);
			if(typeof(tempCls.x)=="undefined") {
				drawOntLat.locX = 50;
			}
			else drawOntLat.locX = tempCls.x;
			drawOntLat.locY = y;
			var g = drawOntLat.drawLat(rectclass,BrushId);
			svgElem.appendChild(g);
		}
	}
}

function DisplayECRelationship(ontname,latname){
	var input = {};
	input["ontname"] = ontname;
	input["latname"] = latname;
	inputstr = JSON.stringify(input);
	var myChart = echarts.init(document.getElementById('main'));
	$.ajax({
		url: "echartsAction!getChartData.action",
        type: "post",
        async: false,
        data: {
            inputStr: inputstr,
        },
        success : function(data) {
			var option = {
				title : {
					text : ''
				},
				tooltip : {
					trigger : 'item',
					formatter : '{a}{b} {c}'
				},
				toolbox : {
					show : true,
					feature : {
						restore : {
							show : true
						},
						magicType : {
							show : true,
							type : [ 'force', 'chord' ]
						},
						saveAsImage : {
							show : true
						}
					}
				},
				series : [ {
					type : 'graph',
					layout : 'force',
					force : {
						repulsion : 600,
						gravity : 0.1,
						edgeLength : 80,
					},
					symbol : 'roundRect',
					symbolSize : [48,28],
					lineStyle:{
						normal : {
							color: '#000',
			                width: 1,
			                opacity: 1
						}
					},
					label:{
						normal :{
							show: true,
							offset: [0,-2],
							textStyle: {
								color: "#000",
								fontStyle: 'normal',
								fontSize: 10
							},
						}
					},
					roam : true,
					draggable : true,
					edgeSymbol : [ 'pin', 'arrow' ],
					edgeSymbolSize : [ 10, 15 ],
					itemStyle:{
						normal:{
							color: {
								type: 'radial',
							    x: 0.5,
							    y: 0.5,
							    r: 1,
							    colorStops: [{
							        offset: 0, color: '#fff' // color at 0% position
							    }, {
							        offset: 1, color: 'rgb(58,179,251)' // color at 100% position
							    }],
							    globalCoord: false // false by default
							},
						}
					},
					edgeLabel : {
						normal : {
							textStyle : {
								fontSize : 20
							}
						}
					},
					data : JSON.parse(data.nodes),
					// links: [],
					links : JSON.parse(data.links),
				} ]
			};
			myChart.setOption(option, true);
			$('#ecRelationWin').show();
		}
	})
}