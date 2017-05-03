function judgeTag(objectStr,mouseIndex , tagStart, tagEnd, noUseTag) {
	var startTagIndex = objectStr.lastIndexOf(tagStart, mouseIndex);
	var startTagIndex2 = objectStr.lastIndexOf(tagEnd, mouseIndex - 1);
	var endTagIndex = objectStr.indexOf(tagEnd, mouseIndex);
	var endTagIndex2 = objectStr.indexOf(tagStart, mouseIndex);
//	console.log("mouseIndex   " + mouseIndex);
//	console.log("startTagIndex   " + startTagIndex);
//	console.log("startTagIndex2   " + startTagIndex2);
//	console.log("endTagIndex   " + endTagIndex);
//	console.log("endTagIndex2   " + endTagIndex2);
	if (startTagIndex > startTagIndex2 && startTagIndex > -1
			&& endTagIndex > -1 && startTagIndex < endTagIndex &&(endTagIndex2 == -1 || endTagIndex < endTagIndex2)) {
            //重要		    
			// var tagGrounpNum=objectStr.split(/<.*?>/).length-1;
			// alert(tagGrounpNum);
			var noUseTagIndex = objectStr.indexOf(noUseTag, startTagIndex);
			if (noUseTagIndex > startTagIndex && noUseTagIndex < endTagIndex) {
				return {start:startTagIndex,end:endTagIndex,result:0};
			} else {
				return  {start:startTagIndex,end:endTagIndex,result:1};
			}
	
	} else {
		return {start:startTagIndex,end:endTagIndex,result:2};
	}
}