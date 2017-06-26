function DrawOntLat(ontLat) {
	var locX;
	var locY;

	DrawOntLat.prototype.drawLat = function(rectclass,BrushId) {
		var g = this.drawLatGro(ontLat.latname, ontLat.oid, this.locX,
				this.locY, "fal",rectclass);
		var textStr = ontLat.latname;
		var num = textStr.length;
		var len = num * fontsize;
		var recwid = Math.round(len + widSup);

		var drawLatRec = this.drawLatRec(recwid, recHei, rx, ry, latStroke,
				"url(" + objOntUrl + "#"+ BrushId +")", this.locX, this.locY,rectclass);
		
		
		// var drawLatRec = this.drawLatRec(recwid, recHei, rx, ry, latStroke,
		// "red", this.locX, this.locY);
		var devX = Math.floor((recwid - len) / 2);
		var devY = Math.floor((recHei - fontsize) / 2 + fontsize) - 1;
		var text = this.drawLatText(this.locX, this.locY, devX, devY, textStr);

		var devNodeX = recwid * 0.5;
		var devNodeY = recHei;

		var topLinkNode = this.drawLatLinkNode(devNodeX + this.locX, this.locY,
				radius, topCir);
		var botLinkNode = this.drawLatLinkNode(devNodeX + this.locX, this.locY
				+ recHei, radius, botCir);
		var eventData = {
			"devX" : devX,
			"devY" : devY,
			"devNodeX" : devNodeX,
			"devNodeY" : devNodeY
		};
		g.appendChild(drawLatRec);
		g.appendChild(text);
		g.appendChild(topLinkNode);
		g.appendChild(botLinkNode);
		drawLatRec.addEventListener("mousedown", function(eve) {
			drag(eve, eventData)
		});
		drawLatRec.addEventListener("dblclick", select);
		return g;
	}
	DrawOntLat.prototype.drawLatGro = function(id, oid, locX, locY, isSel,rectclass) {
		var g = document.createElementNS(xmlns, "g");
		g.setAttribute("id", id);
		g.setAttribute("oid", oid);
		g.setAttribute("x", locX);
		g.setAttribute("y", locY);
		g.setAttribute("isSel", isSel);
		g.setAttribute("class", rectclass);
		return g;
	}
	DrawOntLat.prototype.drawLatText = function(locX, locY, devX, devY, content) {
		var text = document.createElementNS(xmlns, "text");
		text.setAttributeNS(null, "fill", "black");
		text.setAttributeNS(null, "font-family", "Verdana");
		text.setAttributeNS(null, "font-size", fontsize);
		text.textContent = content;
		text.setAttribute("x", locX + devX);
		text.setAttribute("y", locY + devY);
		return text;
	}
	DrawOntLat.prototype.drawLatRec = function(width, height, rx, ry, stroke,
			fill, locX, locY,rectclass) {
		var rect = document.createElementNS(xmlns, "rect");
		//rect.setAttribute("class",rectclass);
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
	DrawOntLat.prototype.drawLatLinkNode = function(locX, locY, radius, type) {
		var circle = document.createElementNS(xmlns, "circle");
		circle.setAttribute("stroke", "black");
		circle.setAttribute("fill", "black");
		circle.setAttribute("cx", locX);
		circle.setAttribute("cy", locY);
		circle.setAttribute("r", radius);
		circle.setAttribute("type", type);
		circle.setAttribute("opacity","0");
		return circle;
	}
}

function drag(eve, eventData) {
	if (!eve)
		eve = window.event;
	var tar = eve.target;
	var devX2 = eventData.devX;
	var devY2 = eventData.devY;
	var devNodeX = eventData.devNodeX;
	var devNodeY = eventData.devNodeY;
	var doc = document;
	var tarPar = tar.parentNode;
	var x = eve.layerX ? eve.layerX : eve.offsetX;
	var y = eve.layerY ? eve.layerY : eve.offsetY;
	var oriX = tarPar.getAttribute("x");
	var oriY = tarPar.getAttribute("y");
	var devX = x - oriX;
	var devY = y - oriY;
	if (tar.setCapture)
		tar.setCapture();
	else if (window.captureEvents)
		window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP);
	doc.onmousemove = function(eve) {
		if (!eve)
			eve = window.event;
		var tx = eve.layerX - devX - oriX;
		var ty = eve.layerY - devY - oriY;
		tarPar.setAttribute("x", tx + parseInt(oriX));
		tarPar.setAttribute("y", ty + parseInt(oriY));
		var childList = tarPar.childNodes;
		for (var i = 0; i < childList.length; i++) {
			var tempChild = childList[i];
			var tempLocX;
			var tempLocY;
			if (tempChild.tagName == "circle") {
				tempChild.setAttribute("cx", tx + parseInt(oriX) + devNodeX);
				if (tempChild.getAttribute("type") == botCir) {
					tempChild
							.setAttribute("cy", ty + parseInt(oriY) + devNodeY);
				} else {
					tempChild.setAttribute("cy", ty + parseInt(oriY));
				}
			} else if (tempChild.tagName == "text") {
				tempChild.setAttribute("x", tx + parseInt(oriX) + devX2);
				tempChild.setAttribute("y", ty + parseInt(oriY) + devY2);
			} else {
				tempChild.setAttribute("x", tx + parseInt(oriX));
				tempChild.setAttribute("y", ty + parseInt(oriY));
			}
		}
		var parId = tarPar.getAttribute("id");
		var startLineList = new ArrayList();
		var endLineList = new ArrayList();
		// change the loc of connection
		for (var j = 0; j < conLineList.size(); j++) {
			var conLine = conLineList.get(j);
			var startId = conLine.getAttribute("startId");
			var endId = conLine.getAttribute("endId");
			if (startId == parId) {
				startLineList.add(conLine);
			} else if (endId == parId) {
				endLineList.add(conLine);
			}
		}
		for (var m = 0; m < startLineList.size(); m++) {
			var tempStartLine = startLineList.get(m);
			tempStartLine.setAttribute("x1", tx + parseInt(oriX) + devNodeX);
			tempStartLine.setAttribute("y1", ty + parseInt(oriY) + devNodeY);
		}
		for (var n = 0; n < endLineList.size(); n++) {
			var tempEndLine = endLineList.get(n);
			tempEndLine.setAttribute("x2", tx + parseInt(oriX) + devNodeX);
			tempEndLine.setAttribute("y2", ty + parseInt(oriY));
		}

	};

	doc.onmouseup = function() {
		if (tar.releaseCapture)
			tar.releaseCapture();
		else if (window.captureEvents)
			window.captureEvents(Event.MOUSEMOVE | Event.MOUSEUP);
		doc.onmousemove = null;
		doc.onmouseup = null;
	};
};

function select(eve) {
	var tar = eve.target;
	var tarPar = tar.parentNode;
	var isSel = tarPar.getAttribute("isSel");
	if (isSel == "fal") {
		tar.setAttribute("stroke", latSelStroke);
		tarPar.setAttribute("isSel", "tru");
	} else {
		tar.setAttribute("stroke", latStroke);
		tarPar.setAttribute("isSel", "fal");
	}

}

function DrawLatG(id, oid, locX, locY, isSel) {
	var g = document.createElementNS(xmlns, "g");
	g.setAttribute("id", id);
	g.setAttribute("oid", oid);
	g.setAttribute("x", locX);
	g.setAttribute("y", locY);
	g.setAttribute("isSel", isSel);
	return g;
}
function DrawLatRec(width, height, rx, ry, stroke,
		fill, locX, locY) {
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