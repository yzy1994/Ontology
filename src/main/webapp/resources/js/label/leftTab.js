$(document).ready(function(){ 
var intervalID; 
var curLi; 
$(".leftNav li a").mouseover(function(){ 
curLi=$(this); 
intervalID=setInterval(onMouseOver,250);//��������ʱ����һ������ʱ�Ż��л����������ֹ�û�������Ĳ��� 
}); 
function onMouseOver(){ 
$(".cur-sub-con").removeClass("cur-sub-con"); 
$(".sub-con").eq($(".leftNav li a").index(curLi)).addClass("cur-sub-con"); 
$(".cur").removeClass("cur"); 
curLi.addClass("cur"); 
} 
$(".leftNav li a").mouseout(function(){ 
clearInterval(intervalID); 
}); 

$(".leftNav li a").click(function(){//�����Ҳ�����л� 
clearInterval(intervalID); 
$(".cur-sub-con").removeClass("cur-sub-con"); 
$(".sub-con").eq($(".leftNav li a").index(curLi)).addClass("cur-sub-con"); 
$(".cur").removeClass("cur"); 
curLi.addClass("cur"); 
}); 
}); 