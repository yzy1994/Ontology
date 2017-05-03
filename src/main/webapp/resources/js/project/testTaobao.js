$(document).ready(function(){
	
	$("#deleteBT").click(function(){
	var oldStr=$("#textShow2").val();
	var result=	deleteNR(oldStr);
	$("#textShow2").val(result);
	})
	
})