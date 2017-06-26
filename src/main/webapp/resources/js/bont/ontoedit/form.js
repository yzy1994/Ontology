$(document).ready(function() {
	$('form#ontInfoForm').bind('submit', function() {
		
		ajaxSubmit(this);
		// window.location.reload();
	});
})
function ajaxSubmit(frm) {
	var ontinfo = {};
	ontinfo["name"] = $('#name').val();
	ontinfo["field"] = $('#field').val();
	ontinfo["topec"] = $('#latname').val();
	var str = JSON.stringify(ontinfo);
	//console.log(str);
	$.ajax({
		url : "mainOntAction!addOnt.action",
		type : "post",
		async : false,
		data : {
			inputStr : str
		},
		success : function(data) {
			if(data.resultStr=="existed"){
				alert("本体已存在！")
			}
		}
	});
}