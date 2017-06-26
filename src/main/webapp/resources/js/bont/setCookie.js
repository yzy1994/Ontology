function getParam() {
	isFound = false;
	var durl = decodeURIComponent(this.location);
	var surl = durl.substring(durl.indexOf("?")+9,durl.length);
	return surl;
}
$(document).ready(function() {
	var ontname = getParam();
	$.cookie('ontname');
})
