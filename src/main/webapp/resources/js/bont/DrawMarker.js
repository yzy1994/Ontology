function DrawMarker() {
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
	pathA.setAttributeNS(null, "d", "M2,2 L10,6 L2,10 L6,6 L2,2");
	pathA.setAttributeNS(null, "fill", "#000000");
	marker.appendChild(pathA);
	return marker;
}