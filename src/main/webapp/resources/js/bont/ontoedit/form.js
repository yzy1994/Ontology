$(document).ready(function() {
	$('form#objOntLatForm').bind('submit', function() {
		ajaxSubmit(this);
		// window.location.reload();
	});
})
function ajaxSubmit(frm) {
	var array = $(frm).serializeArray();
	var ontinfo = {};
	ontinfo["ontname"] = "";
	ontinfo["ontfield"] = "";
	ontinfo["element"] = "";
	$.each(array, function() {
		var labname = this.name;
		if (labname == "element") {
			ontinfo[labname] += this.value + ",";
		}
		if (labname == "ontname") {
			labname = "name";
			ontinfo[labname] = this.value;
		}
		if (labname == "ontfield") {
			labname = "field";
			ontinfo[labname] = this.value;
		}
	});
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
			}
		}
	});
}