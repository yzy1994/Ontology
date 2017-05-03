function DrawFoldOpen(locX, locY, pointsArray) {
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