function getStrIndex(parentStr,sonStr){
	var parentLength=parentStr.length;
	var sonLength=sonStr.length;
	var indexList = new ArrayList();
	if((parentLength>sonLength)&&(sonLength>0)){
		for(var i=0;i<parentLength;i++){
			var startIndex=parentStr.indexOf(sonStr,i);
			if(startIndex>=0){
				var tempPairIndex=[startIndex,startIndex+sonLength];
//				console.log(tempPairIndex);
				indexList.add(tempPairIndex);
				i=startIndex+sonLength-1;
				}
			else{
				break;
			}
		}
		
		
	}
	
	return indexList;
	
	
}