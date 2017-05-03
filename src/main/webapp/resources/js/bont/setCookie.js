function getParam() {
	isFound = false;
	var durl = decodeURIComponent(this.location);
	var surl = durl.substring(durl.indexOf("?")+9,durl.length);
	return surl;
}
$(document).ready(function() {
	var ontname = getParam();
	ontname="突发事件本体";
	console.log(ontname);
	$.cookie('ontname',ontname);
	$("dl.cloud").hide();
	$("dl.statistics").hide();
	$("dl.syetem_management").hide();
	
	var url="mainOntAction!queryOntInfoByName.action";
	var tempList;
	$.ajax({
		url : url,
		type : "post",
		async : false,
		data : {inputStr:ontname},
		success : function(data) {
			tempList = $.parseJSON(data.resultStr);
		}
	})
	var element = tempList.element;
	var elementlist = element.split(",");
	for(var i=0;i<elementlist.length;i++){
		$("#"+elementlist[i]).show();
	}
})
