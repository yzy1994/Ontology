function CreLoc(maxCount, rowCount) {
	var midLoc;
	var locList = new Array();
	if (maxCount % 2 == 0) {
		midLoc = Math.floor(maxCount / 2)-1;
	
		if (rowCount==maxCount){
			for(var i=0;i<rowCount;i++){
				locList[i]=i;
			}
		}
		else if (rowCount % 2 == 0) {
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
	} else {
		//奇数
		midLoc = Math.floor(maxCount / 2);
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
	}
//	console.log("%%%" + midLoc);
//	console.log("%maxCount%%" + maxCount);
//	console.log("%rowCount%%" + rowCount);
	return locList;
}