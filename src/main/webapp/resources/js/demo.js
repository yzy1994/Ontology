$(document).ready(function() {
	var fadeTime = 100;
	var slideTime = 200;
	$('#display').click(function() {
		if ($("#objOntWin").is(":hidden")) {
			$('#objOntWin').fadeIn(fadeTime);
			$('#objOntReload').click();
		} else {
			$('#objOntWin').slideUp(slideTime);
		}
	});
});