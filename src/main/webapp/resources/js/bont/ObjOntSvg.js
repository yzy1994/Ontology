var csgshowLayerList;
var csgsvgDiv;
var csgsvgElem;
var csgdefs;
var csgmarker;
var csgrgBrush;

$(document).ready(function() {
			$("#draggable").draggable();
			var showLayerList;
			var svgDiv = document.getElementById('objOntSvg');
			var svgElem = document.createElementNS(xmlns, "svg");
			var defs = document.createElementNS(xmlns, "defs");
			var marker = DrawMarker();
			var rgBrush = RGBrush();
			defs.appendChild(rgBrush);
			defs.appendChild(marker);
			svgElem.appendChild(defs);
			svgDiv.appendChild(svgElem);
			var rectclass = "drawrect";
			
			updateConceptList();
			for(var temp in conceptList){
				if(temp=="remove")
					continue;
				$('#envsConcept').append("<option value=\"" + temp + "\">"+ temp +"</option>");
			}

			$("#objOntAdd").click(function() {
				//$('img#addAttribute').show();
				$('img#addAttribute').hide();
				$("li#lisubmit").show();
				objDelStatusGV = "add";
				formRest();
				$('#dealObjOntLat').fadeIn(fadeTime);
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

			$('#objOntZoomout').click(
					function() {
						if (curZoomIndex > minZoomIndex) {
							curZoomIndex--;
						}
						var zoomMul = zoomMulList[curZoomIndex];
						svgElem.setAttributeNS(null, "viewBox", "0 0 "
								+ svgWidth * zoomMul + " " + svgHeight
								* zoomMul);
					})

			$('#objOntZoomin').click(
					function() {
						if (curZoomIndex < maxZoomIndex) {
							curZoomIndex++;
						}
						var zoomMul = zoomMulList[curZoomIndex];
						svgElem.setAttributeNS(null, "viewBox", "0 0 "
								+ svgWidth * zoomMul + " " + svgHeight
								* zoomMul);
					})

			$("#objOntReload").click(function() {
				console.log(objOntLatListGV.size());
				console.log(conceptListGV.size());
				var svgid = "svgId";
				objOntLatListGV.removeAll();
				cleanSVG();
				objOntLatListGV = queryOntLatList(whichOnt);
				showLayerList = createShowLayer(objOntLatListGV);
				// calculate the svg viewBox
				var maxCount = 0;
				for (var e = 0; e < showLayerList.size(); e++) {
					var tempLayer = showLayerList.get(e);
					if (tempLayer.size() > maxCount) {
						maxCount = tempLayer.size();
					}
				}
				
				initSVGView(showLayerList.size(), svgElem, maxCount,svgid);
				$('#showDivHide').fadeIn(fadeTime);
				$('#showDiv').slideDown(slideTime);
				for (var j = 0; j < showLayerList.size(); j++) {
					var tempLayer = showLayerList.get(j);
					var rowCount = tempLayer.size();
					var locList = CreLoc(maxCount, rowCount);
					var y = j * (blockHeight + yGrap) + startY;
					var showOrder = 0;
					for (var i = 0; i <= maxCount; i++) {
						var flag = 0;
						for (var m = 0; m < locList.length; m++) {
							if (i == locList[m]) {
								flag = 1;
								break;
							}
						}
						if (flag == 1) {
							var tempCls;
							for (var p = 0; p < tempLayer.size(); p++) {
								if (tempLayer.get(p).showOrder == showOrder) {
									tempCls = tempLayer.get(p);
									showOrder++;
									break;
								}
							}
							var drawOntLat = new DrawOntLat(tempCls);
							drawOntLat.locX = i * (blockWidth + xGrap);
							drawOntLat.locY = y;
							var g = drawOntLat.drawLat(rectclass);
							svgElem.appendChild(g);
						}
					}
				}
				drawLatLink(svgElem,objOntLatListGV,"svgId");
				
				console.log(objOntLatListGV.size());
				console.log(conceptListGV.size());
				
				//上下文菜单
				var options = {
					items : [ {
						header : '功能菜单'
					}, {
						text : '插入子事件类',
						onclick : function(eve){
							$('#eclatname').prop('readOnly',false);
							objDelStatusGV = 'add';
							var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
							var gList = svgElem.getElementsByTagName("g")
							var gid;
							for (var j = 0; j < gList.length; j++) {
								tempG = gList[j];
								if (tempG.firstChild.getAttribute('data-contextify-id') == dci) {
									gid = tempG.getAttribute("id");
									console.log(gid);
									break;
								}
							}
							formRest();
							$('#dealObjOntLat').fadeIn(fadeTime);
							$('#ecparentlatname').val(gid);
						}
					}, {
						text : '编辑事件类',
						onclick : function(eve) {
							objDelStatusGV = 'edit';
							var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
							var gList = svgElem.getElementsByTagName("g");
							showObjFormConParRewrite(gList,dci , "find");
							var gid;
							for (var j = 0; j < gList.length; j++) {
								tempG = gList[j];
								if (tempG.firstChild.getAttribute('data-contextify-id') == dci) {
									gid = tempG.getAttribute("id");
									console.log(gid);
									break;
								}
							}
							$('#ecname').text(gid);
							$('.ecname').text(gid);
						}
					}, {
						text : '删除事件类',
						onclick : function(eve) {
							var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
							var gList = svgElem.getElementsByTagName("g")
							var gid;
							for (var j = 0; j < gList.length; j++) {
								tempG = gList[j];
								if (tempG.firstChild.getAttribute('data-contextify-id') == dci) {
									gid = tempG.getAttribute("id");
									console.log(gid);
									break;
								}
							}
							delOntLatRewrite(gid,ELTN);
						}
					}, {
						text : '返回',
						onclick : function(eve) {
							$('#contextify-menu').attr('display','none');
							//console.log(eve.target.parentNode.parentNode.getAttribute('data-contextify-id'));
						}
					}, ]
				};
				$('.drawrect').contextify(options);
			});

			$("#objOntClean").click(function() {
				cleanSVG();
			})

			$("#objOntPrinter").click(
					function() {
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
			
			$('#eveOntWinClose').click(function(){
				$('#dealObjOntLat').fadeOut(fadeTime);
				$('#ecname').text('');
				formReset("actionElementForm");
				formReset("timeElementForm");
				formReset("envElementForm");
				formReset("assertElementForm");
				formReset("languageElementForm");
				
			})
			$('#objElementWinClose').click(function(){
				$('#objElementEdit').fadeOut(fadeTime);
				objnum=0;
				$('.form-col').remove();
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
	for (var j = 0; j <= maxGrand; j++) {
		var showLayer = new ShowLayer(j);
		var showOrder = 0;
		for (var k = 0; k < tempList.size(); k++) {
			var temp = tempList.get(k);
			if (temp.grand == j) {
				temp.setShowOrder(showOrder);
				showLayer.add(temp);
				showOrder++;
			}
		}
		showLayerList.add(showLayer);
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
				console.log(att);
				console.log(valu);
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
			// console.log("objOntOidStr" + objOntOidStr);
			var ontName;
			var input = {};
			input["ontname"] = preontname;
			input["collection"] = whichOnt;
			input["latsid"] = gid;
			var inputstr = JSON.stringify(input);
			var delurl = "objOntAction!deleteLatByMongo.action";
			console.log(delurl);
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

function initSVGView(size, svgElem, maxCount,svgid) {
	var maxLayerCount = size;
	// showLayerList.size();
	var maxSvgWidth = (blockWidth + xGrap) * maxCount + totalXGrap;
	var maxSvgHeight = (blockHeight + yGrap) * maxLayerCount + totalYGrap;
	if (maxSvgWidth > svgWidth)
		svgWidth = maxSvgWidth;
	if (maxSvgHeight > svgHeight)
		svgHeight = maxSvgHeight;
	svgElem.setAttributeNS(null, "viewBox", "0 0 " + svgWidth * orgZoomMul
			+ " " + svgHeight * orgZoomMul);
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
					console.log(lineA);
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
		/*
		 * objOntLat.latSid = temp.latSid; objOntLat.latName = temp.latName;
		 * objOntLat.parentSid = temp.parentSid; objOntLat.latNote =
		 * temp.latNote;
		 */
		objlat.latsid = (typeof (temp.latSid) == "undefined") ? temp.latsid
				: temp.latSid;
		objlat.latname = (typeof (temp.latName) == "undefined") ? temp.latname
				: temp.latName;
		objlat.parentlatname = (typeof (temp.parentSid) == "undefined") ? temp.parentlatname
				: temp.parentSid;
		objlat.latnote = (typeof (temp.latNote) == "undefined") ? temp.latnote
				: temp.latNote;
		/*objOntLat.peoElement = temp.peoElement;
		objOntLat.objElement = temp.objElement;
		objOntLat.envElement = temp.envElement;*/
		objOntLatListGV.add(objlat);
	}
	for (var j = 0; j < objOntLatListGV.size(); j++) {
		var tempecls = objOntLatListGV.get(j);
		var grand = getGrand(tempecls, objOntLatListGV, 0);
		tempecls.setGrand(grand);
	}
	return objOntLatListGV;
}

//编辑事件类
function showObjFormConParRewrite(gList , dci , objDelStatusGV)/*dci:data-contextify-id objDelStatusGV:'edit'/'find'*/ {
	ResetECInfo();
	$('#eclatname').prop('readOnly',true);
	
	var gid;
	for (var j = 0; j < gList.length; j++) {
		tempG = gList[j];
		if (tempG.firstChild.getAttribute('data-contextify-id') == dci) {
			gid = tempG.getAttribute("id");
			console.log(gid);
		}
	}
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
		/*updateTimeElement(objOntLat.latname);
		updateObjElement(objOntLat.latname);
		updateActionElement(objOntLat.latname);
		updateEnvElement(objOntLat.latname);
		updateLanElement(objOntLat.latname);
		updateAssertElement(objOntLat.latname);*/
		
		updateECInfo(objOntLat.latname);
		updateObjElement(objOntLat.latname);
		/*var objLatList = queryLatList("obj_ont_lat");
		var sval='';
		for(var i=0;i<objLatList.length;i++){
			var temp = objLatList[i];
			if(temp.evelatsid == objOntLat.latSid){
				sval += temp.latname;
			}
		}*/
		/*$('#leai').text(sval);*/
		
		$('#dealObjOntLat').fadeIn(fadeTime);
		/*$('label#leo').click(function(){
			$('#objElementEdit').show();
			$('#ecname').text(objOntLat.latname);
			$('#ecname').attr('evesid',objOntLat.latSid);
			
		})*/
		//时间要素编辑窗口
		$('label#let').click(function(){
			$('#timeElementEdit').css('height','300px');
			$('#timeElementEdit').show();
			$('#tecname').text(objOntLat.latname);
			$('#tecname').attr('evesid',objOntLat.latSid);
		})
		
		$('label#leo').click(function(){
			updateObjElement(objOntLat.latname);
			$('#objElementEdit').show();
			$('#aecname').text(objOntLat.latname);
			$('#aecname').attr('evesid',objOntLat.latSid);
			
		})
		
		$('label#lea').click(function(){
			$('#actionElementEdit').show();
			$('#ecname').text(objOntLat.latname);
			$('#ecname').attr('evesid',objOntLat.latSid);
		})
		
		$('label#lee').click(function(){
			//环境要素编辑窗口
			$('#envElementEdit').show();
			$('#ecname').text(objOntLat.latname);
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
function showConceptFormConPar(gList , dci , objDelStatusGV)/*dci:data-contextify-id objDelStatusGV:'edit'/'find'*/ {
	var gid;
	additionnum = 0;
	for (var j = 0; j < gList.length; j++) {
		tempG = gList[j];
		if (tempG.firstChild.getAttribute('data-contextify-id') == dci) {
			gid = tempG.getAttribute("id");
		}
	}
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
				console.log(data);
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
					console.log(pro);
					console.log(attr);
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
			}
			$("#objOntReload").click();
		}
	});
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

var cshowLayerList;
var csvgDiv;
var csvgElem;
var cdefs;
var crgBrush;

function InitconceptWin(){
	var svgid = "conceptSvg";
	var rectclass = "conceptrect";
	csvgDiv = document.getElementById('conceptSvgDiv');
	csvgElem = document.createElementNS(xmlns, "svg");
	cdefs = document.createElementNS(xmlns, "defs");
	cmarker = DrawMarker();
	crgBrush = RGBrush();
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
	
	$('#conceptZoomout').click(
					function() {
						if (curZoomIndex > minZoomIndex) {
							curZoomIndex--;
						}
						var zoomMul = zoomMulList[curZoomIndex];
						csvgElem.setAttributeNS(null, "viewBox", "0 0 "
								+ svgWidth * zoomMul + " " + svgHeight
								* zoomMul);
					})

	$('#conceptZoomin').click(function() {
		if (curZoomIndex < maxZoomIndex) {
			curZoomIndex++;
		}
		var zoomMul = zoomMulList[curZoomIndex];
		csvgElem.setAttributeNS(null, "viewBox", "0 0 "
				+ svgWidth * zoomMul + " " + svgHeight
					* zoomMul);
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
			
	$('#conceptReload').click(function(){
		console.log("Reload Concept");
		conceptListGV.removeAll();
		cleanSVGid(svgid);
		conceptListGV = queryConceptLatList();
		cshowLayerList = createShowLayer(conceptListGV);
		
		var maxCount = 0;
		for (var e = 0; e < cshowLayerList.size(); e++) {
			var tempLayer = cshowLayerList.get(e);
			if (tempLayer.size() > maxCount) {
				maxCount = tempLayer.size();
			}
		}
		initSVGView(cshowLayerList.size(), csvgElem, maxCount,svgid);
		
		for (var j = 0; j < cshowLayerList.size(); j++) {
			var tempLayer = cshowLayerList.get(j);
			var rowCount = tempLayer.size();
			var locList = CreLoc(maxCount, rowCount);
			var y = j * (blockHeight + yGrap) + startY;
			var showOrder = 0;
			for (var i = 0; i <= maxCount; i++) {
				var flag = 0;
				for (var m = 0; m < locList.length; m++) {
					if (i == locList[m]) {
						flag = 1;
						break;
					}
				}
				if (flag == 1) {
					var tempCls;
					for (var p = 0; p < tempLayer.size(); p++) {
						if (tempLayer.get(p).showOrder == showOrder) {
							tempCls = tempLayer.get(p);
							showOrder++;
							break;
						}
					}
					var drawOntLat = new DrawOntLat(tempCls);
					drawOntLat.locX = i * (blockWidth + xGrap);
					drawOntLat.locY = y;
					var g = drawOntLat.drawLat(rectclass);
					csvgElem.appendChild(g);
				}
			}
		}
		drawLatLink(csvgElem,conceptListGV,"conceptSvg");
		
		//上下文菜单
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
						if (tempG.firstChild.getAttribute('data-contextify-id') == dci) {
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
					showConceptFormConPar(gList, dci, "edit");
				}
			}, {
				text : '删除概念',
				onclick : function(eve) {
					console.log("删除概念")
					var dci=eve.target.parentNode.parentNode.getAttribute('data-contextify-id');
					var gList = csvgElem.getElementsByTagName("g")
					var gid;
					for (var j = 0; j < gList.length; j++) {
						tempG = gList[j];
						if (tempG.firstChild.getAttribute('data-contextify-id') == dci) {
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
		$('.conceptrect').contextify(conceptoptions);
	})
}

function queryConceptLatList() {
	var tempList;
	var list = new ArrayList();
	var url = "objOntAction!queryConceptLat.action";
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
	for (var i = 0; i < tempList.length; i++) {
		var temp = tempList[i];
		var concept = new ObjOntLat();
		concept.latname = temp.latname;
		concept.parentlatname = temp.parentlatname;
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
	console.log("create");
    additionnum++;
    idarray.push(additionnum);
    var liid = "li" + additionnum;
    var proid = "pro" + liid;
    var attid = "att" + liid;
    $('div#divproval').append("<li class=\"addli\" id=\"" + liid + "\"><input required=\"required\" id=\"" + proid + "\"><input required=\"required\" id=\"" + attid + "\"><img class=\"delattr\" id=\"" + liid + "\" src=\"resources/images/delete.png\"></img></li>");
    $('img#' + liid).click(function() {
        console.log("delete");
        $('li#' + liid).remove();
        var temp = liid.substr(liid.length - 1);
        var index = idarray.indexOf(parseInt(temp));
        idarray.remove(index);
    });
}

function addObj(){
	objnum++;
	console.log("addObjElement");
	$('#objFormItem').append("<div class=\"form-col\" id=\"col"+ objnum.toString() +"\"><ul><li class=\"objname\"></li><li>数量：</li><li><select name=\"amount\" id=\"sAmount"+objnum.toString()+"\"><option value=\"1\">1</option><option value=\"2\">2</option><option value=\"3\">3</option><option value=\"少许\">少许</option><option value=\"近半\">近半</option><option value=\"半\">半</option><option value=\"多半\">多半</option><option value=\"大量\">大量</option></select></li>"+
							"<li>所属概念：</li>"+
							"<li><select name=\"conceptsid\" id=\"sConcept"+objnum.toString()+"\"></select></li><li>语言称谓：</li><li><input name=\"lane\" id=\"iLE"+objnum.toString()+"\" type=\"text\"></li></ul></div>");
	/*for(var temp in conceptList){
		if(temp=="remove")
			continue;
		$('#sConcept'+objnum).append("<option value=\"" + temp + "\">"+ temp +"</option>");
	}*/
	for(var i=0;i<conceptListGV.size();i++){
		console.log(conceptListGV.size());
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
	console.log(preontname+" "+evelatname);
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
					console.log(temp);
					$("#sAmount"+objnum.toString()).val(temp["amount"]);
					var sc = "#sConcept"+objnum.toString();
					var scv = temp["conceptlatname"];
					console.log(sc+" "+scv);
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
				console.log(temp);
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
				console.log(temp);
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
				console.log(temp);
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
			console.log(data);
			if(data.resultStr!=""){
				var temp = $.parseJSON(data.resultStr);
				console.log(temp);
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
	
	console.log("Reload ConceptSubGraph");
	conceptSubGraphList.removeAll();
	cleanSVGid(svgid);
	conceptSubGraphList = queryConceptSubGraphList(conceptname);
	console.log(conceptSubGraphList);
	
	conceptListGV.removeAll();
	conceptListGV = queryConceptLatList();
	
	var maxCount = 0;
	initSVGView(10, csgsvgElem, maxCount,svgid);

	var x = 50;
	var y = 50;
	
	for(var i=0 ; i < conceptListGV.size();i++){
		console.log(conceptListGV.get(i).latname);
		if(conceptListGV.get(i).latname == conceptname){
			console.log(i);
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
		
	/*for(var i=0 ;i<conceptSubGraphList.size();i++){
		var temp = {};
		temp.latname = conceptSubGraphList.get(i).latname;
		temp.parentlatname = conceptSubGraphList.get(i).parentlatname;
		var drawOntLat = new DrawOntLat(temp);
		x += 100;
		drawOntLat.locX = x;
		drawOntLat.locY = y;
		var g = drawOntLat.drawLat(rectclass);
		csgsvgElem.appendChild(g);
	}*/
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
			console.log(actionstr);
			console.log(timestr);
			console.log(envstr);
			console.log(assertstr);
			console.log(lanstr);
			
			if(actionstr!=null){
				var temp = actionstr;
				$('#sDegree').val(temp.degree);
				$('#iTool').val(temp.tool);
				$('#iMethod').val(temp.method);
				$('label#leai').text("程度:"+temp.degree + " 工具:" + temp.tool+ " 方法:" +temp.method);	
			}
			if(timestr!=null){
				var temp = timestr;
				$('label#leti').append("开始时间:"+temp.start + " 延续时间:" + temp.length);
				$('#tsStart').val(temp.start);
				$('#tsLength').val(temp.length);
			}
			if(envstr!=null){
				var temp = envstr;
				$('#envsConcept').val(temp.conceptlatname);
				$('#iEnvlane').val(temp.envlane);
				$('label#leei').text("所属概念:"+temp.conceptlatname+" 语言表现:"+temp.envlane);
			}
			if(assertstr!=null){
				var temp = assertstr;
				$('#leasi').text("前置状态"+temp.prestate+"中间断言"+temp.massert+"后置状态"+temp.poststate);
				$('#iPrestate').val(temp.prestate);
				$('#iMassert').val(temp.massert);
				$('#iPoststate').val(temp.poststate);
			}
			if(lanstr!=null){
				var temp = lanstr;
				$('#lelei').text("触发词:"+temp.triggerwords+" 搭配:"+temp.collocation);
				$('#iTriggerWords').val(temp.triggerwords);
				$('#iCollocation').val(temp.collocation);
			}
		}
	})
}