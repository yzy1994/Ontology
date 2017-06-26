$(document).ready(function() {
	$('.sidebar-toggle').click(function() {
		if ($('.sidebar').css('display') == 'block') {
			$('.sidebar').hide();
			$('body').css('padding-left', '0');
			$('#sidebar-line-last').css('transform', 'none');
			$('#sidebar-line-last').css('top', '0px');
			$('#sidebar-line-middle').css('opacity', '1');
			$('#sidebar-line-first').css('transform', 'none');
			$('#sidebar-line-first').css('top', '0px');
		}

		else{
			$('.sidebar').show();
			$('body').css('padding-left', '260px');
			$('#sidebar-line-last').css('transform', 'rotateZ(-45deg)');    
			$('#sidebar-line-last').css('top', '-5px');
			$('#sidebar-line-middle').css('opacity', '0');
			$('#sidebar-line-first').css('transform', 'rotateZ(45deg)');
			$('#sidebar-line-first').css('top', '5px');
		}
	})
})