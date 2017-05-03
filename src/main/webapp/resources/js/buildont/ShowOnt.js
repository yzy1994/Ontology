var fontsize = 15;
var reg = new RegExp("_");
var fadeTime = 100;
var slideTime = 200;
// svg arg start
var xmlns = "http://www.w3.org/2000/svg";
var xmlns2 = "http://www.w3.org/1999/xhtml";
var svgWidth = 1200;
var svgHeight = 520;
var totalXGrap = 100;
var totalYGrap = 100;
// svg arg end

// rext arg start
var startY = 50;
var blockWidth = 80;
var blockHeight = 36;
var xGrap = 20;
var yGrap = 50;
var rx = 10;
var ry = 10;
var micY = 8;
var stroke = "orange";
var fill = "orange";
// rect arg end

// zoom arg start
var zoomMulList = [ 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1, 1.1, 1.2,
		1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2.0 ];
var orgZoomIndex = 9;
var curZoomIndex = 9;
var maxZoomIndex = 19;
var minZoomIndex = 0;
var orgZoomMul = zoomMulList[orgZoomIndex];
// zoom arg end
// toplinkNode arg start
var yTopOffset = 2;
var xTopOffset = 40;
var topRadius = 2;
// toplinkNode arg end
// toplinkNode arg start
var yBotOffset = 34;
var xBotOffset = 40;
var botRadius = 2;
// toplinkNode arg end

// flod arg start
var pointsArray = [ 10, 15, 17, 15, 17, 8, 23, 8, 23, 15, 30, 15, 30, 21, 23,
		21, 23, 28, 17, 28, 17, 21, 10, 21 ];
// flod arg end
// text arg start
var yTextOffset = 23;
// text arg end
$(document)
		.ready(
				function() {
					var eclsList = createShowNode();
					var showLayerList = createShowLayer(eclsList);
					var svgDiv = document.getElementById('svgDiv');
					var svgElem = document.createElementNS(xmlns, "svg");
					// calculate the svg viewBox
					var maxCount = 0;
					for (e = 0; e < showLayerList.size(); e++) {
						var tempLayer = showLayerList.get(e);
						if (tempLayer.size() > maxCount) {
							maxCount = tempLayer.size();
						}
					}
					var maxLayerCount = showLayerList.size();
					var maxSvgWidth = (blockWidth + xGrap) * maxCount
							+ totalXGrap;
					var maxSvgHeight = (blockHeight + yGrap) * maxLayerCount
							+ totalYGrap;
					if (maxSvgWidth > svgWidth)
						svgWidth = maxSvgWidth;
					if (maxSvgHeight > svgHeight)
						svgHeight = maxSvgHeight;
					// calculate the svg viewBox

					$("#testId")
							.click(
									function() {

										$('#showDivHide').fadeIn(fadeTime);
										$('#showDiv').slideDown(slideTime);

										svgElem.setAttributeNS(null, "viewBox",
												"0 0 " + svgWidth * orgZoomMul
														+ " " + svgHeight
														* orgZoomMul);
										svgElem.setAttributeNS(null, "width",
												svgWidth);
										svgElem.setAttributeNS(null, "id",
												"svgId");
										svgElem.setAttributeNS(null, "height",
												svgHeight);
										svgElem.style.display = "inline";

										var defs = document.createElementNS(
												xmlns, "defs");
										var marker = createMarker();
										defs.appendChild(marker);
										svgElem.appendChild(defs);

										for (j = 0; j < showLayerList.size(); j++) {
											var tempLayer = showLayerList
													.get(j);
											var rowCount = tempLayer.size();
											var locList = CreLoc(maxCount,
													rowCount);
											var y = j * (blockHeight + yGrap)
													+ startY;
											// alert(locList.toString());
											var showOrder = 0;
											for (i = 0; i <= maxCount; i++) {
												var flag = 0;
												for (m = 0; m < locList.length; m++) {
													if (i == locList[m]) {
														flag = 1;
														break;
													}
												}
												if (flag == 1) {
													var tempCls;
													for (p = 0; p < tempLayer
															.size(); p++) {
														if (tempLayer.get(p).showOrder == showOrder) {
															tempCls = tempLayer
																	.get(p);
															showOrder++;
															break;
														}
													}

													var g = document
															.createElementNS(
																	xmlns, "g");
													g.setAttribute("id",
															tempCls.eid);
													g.addEventListener(
															"dblclick", clinkG);

													var baseX = i
															* (blockWidth + xGrap);
													/*
													 * content
													 */
													var showRect = createShowRect(
															blockWidth,
															blockHeight, rx,
															ry, stroke, fill,
															baseX, y);
													/*
													 * top linkNode
													 */
													var locX1 = baseX
															+ xTopOffset;
													var locY1 = y + yTopOffset;

													var topLinkNode = createLinkNode(
															locX1, locY1,
															topRadius);
													/*
													 * bottom linkNode
													 */
													var locX = baseX
															+ xBotOffset;
													var locY = y + yBotOffset;

													var botLinkNode = createLinkNode(
															locX, locY,
															botRadius);

													var flodOpen = createFoldOpen(
															baseX, y,
															pointsArray);

													var ecn = createText(baseX,
															y, tempCls.ecn);
													// alert(tempCls.ecn);
													tempCls.setLinkNode(locX1,
															locY1, locX, locY);
													g.appendChild(showRect);
													g.appendChild(ecn);
													g.appendChild(botLinkNode);
													g.appendChild(topLinkNode);
													g.appendChild(flodOpen);
													svgElem.appendChild(g);
												}
											}
											svgDiv.appendChild(svgElem);
										}
										/*
										 * add the line for the node which has
										 * link
										 */
										for (f = 0; f < eclsList.size(); f++) {
											var temp = eclsList.get(f);
											if (temp.eid != "a1") {
												var parentList = temp.ets
														.split(reg);
												for (z = 0; z < parentList.length; z++) {
													var lineA = createMarkerLine(
															parentList[z],
															temp.eid);
													svgElem.appendChild(lineA);
												}
											}
										}
										// 30
										// alert(svgElem.x.animVal.value);
										// alert(text.offsetWidth);
										// 20
									});

					$("#zoomOut").click(
							function() {
								if (curZoomIndex < maxZoomIndex) {
									curZoomIndex++;
								}
								var zoomMul = zoomMulList[curZoomIndex];
								svgElem.setAttributeNS(null, "viewBox", "0 0 "
										+ svgWidth * zoomMul + " " + svgHeight
										* zoomMul);

							});
					$("#zoomIn").click(
							function() {
								if (curZoomIndex > minZoomIndex) {
									curZoomIndex--;
								}
								var zoomMul = zoomMulList[curZoomIndex];
								svgElem.setAttributeNS(null, "viewBox", "0 0 "
										+ svgWidth * zoomMul + " " + svgHeight
										* zoomMul);

							});

					$("#cutImg").click(
							function() {
								var svgDiv = document.getElementById('svgDiv');
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
								saveWindow.document.write("<img src='"
										+ svgImage + "' alt='from canvas'/>");
							});
					$('.ShowOnt-poptit .close').click(function() {
						$('.ShowOnt-popover').fadeOut(fadeTime);
						$('.ShowOnt-popover-mask').slideUp(slideTime);

					})
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
function createLinkNode(locX, locY, radius) {
	var circle = document.createElementNS(xmlns, "circle");
	circle.setAttribute("stroke", "orange");
	circle.setAttribute("fill", "orange");
	circle.setAttribute("cx", locX);
	circle.setAttribute("cy", locY);
	circle.setAttribute("r", radius);
	return circle;
}
function createFoldOpen(locX, locY, pointsArray) {
	var lx1 = locX + pointsArray[0];
	var ly1 = locY + pointsArray[1];
	var lx2 = locX + pointsArray[2];
	var ly2 = locY + pointsArray[3];
	var lx3 = locX + pointsArray[4];
	var ly3 = locY + pointsArray[5];
	var lx4 = locX + pointsArray[6];
	var ly4 = locY + pointsArray[7];
	var lx5 = locX + pointsArray[8];
	var ly5 = locY + pointsArray[9];
	var lx6 = locX + pointsArray[10];
	var ly6 = locY + pointsArray[11];
	var lx7 = locX + pointsArray[12];
	var ly7 = locY + pointsArray[13];
	var lx8 = locX + pointsArray[14];
	var ly8 = locY + pointsArray[15];
	var lx9 = locX + pointsArray[16];
	var ly9 = locY + pointsArray[17];
	var lx10 = locX + pointsArray[18];
	var ly10 = locY + pointsArray[19];
	var lx11 = locX + pointsArray[20];
	var ly11 = locY + pointsArray[21];
	var lx12 = locX + pointsArray[22];
	var ly12 = locY + pointsArray[23];
	var polygon = document.createElementNS(xmlns, "polygon");
	// polygon.setAttributeNS(null,
	// "points","10 15 17 15 17 8 23 8 23 15 30 15 30 21 23 21 23 28 17 28 17 21
	// 10 21");
	polygon.setAttribute("points", lx1 + " " + ly1 + " " + lx2 + " " + ly2
			+ " " + lx3 + " " + ly3 + " " + lx4 + " " + ly4 + " " + lx5 + " "
			+ ly5 + " " + lx6 + " " + ly6 + " " + lx7 + " " + ly7 + " " + lx8
			+ " " + ly8 + " " + lx9 + " " + ly9 + " " + lx10 + " " + ly10 + " "
			+ lx11 + " " + ly11 + " " + lx12 + " " + ly12);
	polygon.setAttribute("stroke", "green");
	polygon.setAttribute("fill", "green");
	polygon.setAttribute("opacity", "0");
	return polygon;
}
function createShowRect(width, height, rx, ry, stroke, fill, locX, locY) {
	var rect = document.createElementNS(xmlns, "rect");
	rect.setAttribute("width", width);
	rect.setAttribute("height", height);
	rect.setAttribute("rx", rx);
	rect.setAttribute("ry", ry);
	rect.setAttribute("stroke", stroke);
	rect.setAttribute("fill", fill);
	rect.setAttribute("x", locX);
	rect.setAttribute("y", locY);
	return rect;
}
function createMarker() {
	var marker = document.createElementNS(xmlns, "marker");
	marker.setAttribute("id", "arrow");
	marker.setAttribute("markerUnits", "strokeWidth");
	marker.setAttribute("markerWidth", "8");
	marker.setAttribute("markerHeight", "8");
	marker.setAttribute("viewBox", "0 0 12 12");
	marker.setAttribute("refX", "6");
	marker.setAttribute("refY", "6");
	marker.setAttribute("orient", "auto");
	var pathA = document.createElementNS(xmlns, "path");
	pathA.setAttributeNS(null,"d", "M2,2 L10,6 L2,10 L6,6 L2,2");
	pathA.setAttributeNS(null,"fill", "#000000");
	marker.appendChild(pathA);
	return marker;
}
function createMarkerLine(startId, endId) {
	var beginG = document.getElementById(startId);
	var btoLinkNode = beginG.childNodes[2];
	var endG = document.getElementById(endId);
	var topLinkNode = endG.childNodes[3];
	var startX = btoLinkNode.getAttribute("cx");
	var startY = btoLinkNode.getAttribute("cy");
	var endX = topLinkNode.getAttribute("cx");
	var endY = topLinkNode.getAttribute("cy");
	var lineA = document.createElementNS(xmlns, "line");
	lineA.setAttribute("x1", startX);
	lineA.setAttribute("y1", startY);
	lineA.setAttribute("x2", endX);
	lineA.setAttribute("y2", endY);
	lineA.setAttribute("stroke", "red");
	lineA.setAttribute("stroke-width", "1.5");
	lineA.setAttribute("marker-end", "url(#arrow)");
	return lineA;
}
function createText(locX, locY, content) {
	var text = document.createElementNS(xmlns, "text");
	text.setAttributeNS(null, "fill", "black");
	text.setAttributeNS(null, "font-family", "microsoft yahei");
	text.setAttributeNS(null, "font-size", fontsize);
	text.textContent = content;
	var len = text.textContent.length;
	var micX;
	micX = (blockWidth - len * fontsize) / 2;
	text.setAttribute("x", locX + micX);
	text.setAttribute("y", locY + yTextOffset);
	return text;
}
function getGrand(ecls, eclsList, grand) {
	// alert(eclsList.size());
	if (ecls.ets == "root") {
		return grand;
	} else {

		var parentList = ecls.ets.split(reg);
		grand++;
		var tempEcls;
		for (i = 0; i < eclsList.size(); i++) {
			if (eclsList.get(i).eid == parentList[0]) {
				tempEcls = eclsList.get(i);
				break;
			}
		}
		return getGrand(tempEcls, eclsList, grand);
	}

}
function createShowNode() {
	var eclsList = new ArrayList();
	var a1 = new EventCls("a1", "突发事件", "root");
	var b1 = new EventCls("b1", "地震", "a1");
	var b2 = new EventCls("b2", "火灾", "a1");
	var b3 = new EventCls("b3", "食物中毒", "a1");
	var b4 = new EventCls("b4", "恐怖袭击", "a1");
	var b5 = new EventCls("b5", "交通事故", "a1");
	var b6 = new EventCls("b6", "环境污染", "a1");
	var b7 = new EventCls("b7", "环境污染1", "a1");
	var b8 = new EventCls("b8", "环境污染2", "a1");
	var b9 = new EventCls("b9", "恐怖袭击", "a1");
	var b10 = new EventCls("b10", "交通事故", "a1");
	var b11 = new EventCls("b11", "环境污染", "a1");
	var b12 = new EventCls("b12", "环境污染1", "a1");
	var b13 = new EventCls("b13 ", "环境污染2", "a1");
	var c1 = new EventCls("c1", "倒坍", "b1_b2_b4");

	var c2 = new EventCls("c2", "伤亡", "b1_b2_b3_b4_b5");
	var d1 = new EventCls("d1", "伤亡", "c2");
	var e1 = new EventCls("e1", "伤亡", "d1");
	var f1 = new EventCls("f1", "伤亡", "e1");
	var g1 = new EventCls("g1", "伤亡", "f1");
	var h1 = new EventCls("h1", "伤亡", "g1");
	var i1 = new EventCls("i1", "伤亡", "h1");
	var k1 = new EventCls("k1", "伤亡", "i1");
	// alert(c2.ets);
	eclsList.add(a1);
	eclsList.add(b1);
	eclsList.add(b2);
	eclsList.add(b3);
	eclsList.add(b4);
	eclsList.add(b5);
	eclsList.add(b6);
	eclsList.add(b7);
	eclsList.add(b8);
	eclsList.add(b9);
	eclsList.add(b10);
	eclsList.add(b11);
	eclsList.add(b12);
	eclsList.add(b13);
	eclsList.add(c1);
	eclsList.add(c2);
	eclsList.add(d1);
	eclsList.add(e1);
	eclsList.add(f1);
	eclsList.add(g1);
	eclsList.add(h1);
	eclsList.add(i1);
	eclsList.add(k1);
	for (u = 0; u < eclsList.size(); u++) {
		var tempecls = eclsList.get(u);
		var grand = getGrand(tempecls, eclsList, 0);
		tempecls.setGrand(grand);
		// alert(tempecls.grand);
	}
	return eclsList;
}
function createShowLayer(eclsList) {
	var showLayerList = new ArrayList();
	var maxGrand = 0;
	for (i = 0; i < eclsList.size(); i++) {
		var tempecls = eclsList.get(i);
		if (tempecls.grand > maxGrand)
			maxGrand = tempecls.grand;
	}
	for (j = 0; j <= maxGrand; j++) {
		var showLayer = new ShowLayer(j);
		var showOrder = 0;
		for (k = 0; k < eclsList.size(); k++) {
			var temp = eclsList.get(k);
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