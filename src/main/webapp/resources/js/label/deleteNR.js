function deleteNR( text){
//	var regStr=new RegExp("/r/n","g");
	var showStrTemp = text.replace(/[\r\n]/g,"");
	var temp=showStrTemp.replace(/[\"]/g,'\\\"');
	return temp;
}