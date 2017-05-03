$(document).ready(function() {
	$("#addBT").click(function(){
		$('#infoDivHide').fadeIn(fadeTime);
		$('#infoDiv').slideDown(slideTime);
		Reset();
		$('#saveClassBT').show();
		state="add";
	})
})