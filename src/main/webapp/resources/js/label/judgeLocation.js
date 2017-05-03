function judgeLocation(objectStr,mouseIndex){
	var lastStr=objectStr.substr(mouseIndex-1,1);
	var nextStr=objectStr.substr(mouseIndex,1);
    if(" "==lastStr||">"==nextStr){
    	return true;
    }
    else{
    	return false;
    }
}