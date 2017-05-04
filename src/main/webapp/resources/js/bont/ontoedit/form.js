$(document).ready(function() {
	$('form#objOntLatForm').bind('submit', function() {
		ajaxSubmit(this);
		// window.location.reload();
	});
})
function ajaxSubmit(frm) {
	var ontinfo = {};
	ontinfo["name"] = $('#ontname').val();
	ontinfo["field"] = $('#ontfield').val();
	var str = JSON.stringify(ontinfo);
	console.log(str);
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
			}else{
				var input = {};
				input["ontname"] = $('#ontname').val();
				input["latname"] = "根节点";
				input["parentlatname"] = "root";
				input["latnote"] = "";
				var inputstr = JSON.stringify(input)
 				$.ajax({
 					url: ecEditUrl,
 			        type: "post",
 			        async: true,
 			        data: {
 			            inputStr: inputstr,
 			        },
 			        success: function(data){
 			        }
				})
			}
		}
	});
}