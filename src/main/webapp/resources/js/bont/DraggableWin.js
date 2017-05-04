//可拖拽元素div 窗口div
function letWinDraggable(wt, w) {
	$('#' + wt).mousedown(function(event) {
		var isMove = true;
		var abs_x = event.pageX - $('#' + w).offset().left;
		var abs_y = event.pageY - $('#' + w).offset().top;
		$(document).mousemove(function(event) {
			if (isMove) {
				var obj = $('#' + w);
				obj.css({
					'left' : event.pageX - abs_x,
					'top' : event.pageY - abs_y
				});
			}
		}).mouseup(function() {
			isMove = false;
		});
	});
}