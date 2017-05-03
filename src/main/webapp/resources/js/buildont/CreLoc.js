function CreLoc(maxCount, rowCount) {
	var midLoc = Math.floor(maxCount / 2) + 1
	var locList = new Array();
	if (rowCount % 2 == 0) {
		step = rowCount / 2;
		for (k = 0; k < step; k++) {
			locList[k] = midLoc - (k + 1);
			locList[k + step] = midLoc + (k + 1);
		}
	} else {
		if (rowCount == 1) {
			locList[0] = midLoc;
		} else {
			locList[0] = midLoc;
			step = Math.floor((rowCount - 1) / 2);
			for (k = 1; k <= step; k++) {
				locList[k] = midLoc - k;
				locList[k + step] = midLoc + k;
			}
		}
	}
	return locList;
}