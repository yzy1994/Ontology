$(function() {
	var originalCur = $("#nav_main li.current");
	$("#nav_main li").mousemove(function(){
		$("#nav_main li").removeClass("current");	
		$(this).addClass("current");		
		$(this).children(".lm").show().animate({left : 15,top : 40}, "fast");
	});
	$("#nav_main li").mouseleave(function(){
		$(this).removeClass("current");	
		$(this).children(".lm").stop(true,true).animate({left:0,top:0},100,function(){
			$(this).hide();
		});
		originalCur.addClass("current");
	});
});