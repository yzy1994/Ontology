function DrawConLine(startId, endId,svgId) {
//	console.log("startId"+startId);
//	console.log("endId"+endId);
	var beginG = document.getElementById(startId);
	if(beginG!=null){
		var btoLinkNode = beginG.childNodes[3];
		var svgdiv = document.getElementById(svgId);
		var endG = svgdiv.getElementById(endId);
		var topLinkNode = endG.childNodes[2];
		var startX = btoLinkNode.getAttribute("cx");
		var startY = btoLinkNode.getAttribute("cy");
		var endX = topLinkNode.getAttribute("cx");
		var endY = topLinkNode.getAttribute("cy");
		var lineA = document.createElementNS(xmlns, "line");
		lineA.setAttribute("startId", startId);
		lineA.setAttribute("endId", endId);
		lineA.setAttribute("x1", startX);
		lineA.setAttribute("y1", startY);
		lineA.setAttribute("x2", endX);
		lineA.setAttribute("y2", endY);
		lineA.setAttribute("stroke", "red");
		lineA.setAttribute("stroke-width", "1.5");
		lineA.setAttribute("marker-end", "url(" + objOntUrl + "#arrow)");
		conLineList.add(lineA);
		return lineA;
	}else
		return null;
}