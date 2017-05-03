function RGBrush() {
	var rgbrush = document.createElementNS(xmlns, "radialGradient");
	rgbrush.setAttribute("id", "rgBrush");
	rgbrush.setAttribute("cx", "50%");
	rgbrush.setAttribute("cy", "50%");
	rgbrush.setAttribute("r", "50%");
	rgbrush.setAttribute("fx", "50%");
	rgbrush.setAttribute("fy", "50%");
	// Light color
	var stop1 = document.createElementNS(xmlns, "stop");
	stop1.setAttribute("offset", "0%");
	stop1.setAttribute("style", "stop-color:rgb(" + latLigColor
			+ ");stop-opacity:0");
	// Deep color
	var stop2 = document.createElementNS(xmlns, "stop");
	stop2.setAttribute("offset", "100%");
	stop2.setAttribute("style", "stop-color:rgb(" + latDeeColor
			+ ");stop-opacity:1");
	rgbrush.appendChild(stop1);
	rgbrush.appendChild(stop2);
	return rgbrush;
}