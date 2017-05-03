
$(document).ready(function(){	
	function removeLabel(textShow){
		var oldStr=document.getElementById(textShow).value;
		var textShowStr = oldStr.replace(/<.*?>/g,"");
		document.getElementById(textShow).value=textShowStr;
	}
	window.removeLabel=removeLabel;
	
})
	

