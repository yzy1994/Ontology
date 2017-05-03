function getTagId(objectStr, regStr, mouseIndex){	
	var testStr = objectStr.substr(0,mouseIndex);	
	var tagGrounpNum=testStr.split(regStr).length-1;
	return tagGrounpNum;
}