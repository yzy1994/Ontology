var idarray = new Array();
var addition;
var additionnum;
var objnum;
$(document).ready(function() {
	//事件类操作表单提交
    $('#objOntLatForm').bind('submit',function() {
        ajaxSubmit(this, sucDeal);
        return false;
    });
    
    //概念编辑
    $('#conceptEditForm').bind('submit',function(){
    	conceptEditSubmit(this);
    	return false;
    });
    
    //要素编辑
    $('#timeElementForm').bind('submit',function(){
    	timeElementSubmit(this);
    	return false;
    });
    
    
    $('#objElementForm').bind('submit',function(){
    	objEditSubmit(this);
    	$('#objElementWinClose').click();
    	return false;
    });

    $('#actionElementForm').bind('submit',function(){
    	actionEditSubmit(this);
    	$('#actionElementWinClose').click();
    	return false;
    })
    
    $('#envElementForm').bind('submit',function(){
    	envEditSubmit(this);
    	$('#envElementWinClose').click();
    	return false;
    })
    
    $('#assertElementForm').bind('submit',function(){
    	assertEditSubmit(this);
    	$('#assertElementWinClose').click();
    	return false;
    })
    
    $('#languageElementForm').bind('submit',function(){
    	languageEditSubmit(this);
    	$('#languageElementWinClose').click();
    	return false;
    })
});

// 将form转为AJAX提交
function ajaxSubmit(frm, sucDeal) {
    var act=ecEditUrl;
  
    var input = {};
    input["ontname"] = preontname;
    input["collection"] = whichOnt;
    input["latname"] = $("#eclatname").val()
    input["parentlatname"]=$("#ecparentlatname").val();
    input["latnote"]=$("#eclatnote").val();
    var inputstr = JSON.stringify(input);
    console.log(inputstr);

    $.ajax({
        url: act,
        type: frm.method,
        async: true,
        data: {
            inputStr: inputstr,
        },
        success: function(data){
        	$('#dealObjOntLat').hide();
        	$('#objOntReload').click();
        }
    });
}
function sucDeal(data) {
    if (data.resultStr == "成功插入" || data.resultStr == "upsuc") {
        $('#dealObjOntLat').fadeOut(fadeTime);
        $('#dealObjOntLatHide').slideUp(slideTime);
        objDelStatusGV = "none";
        formRest();
        $("#objOntReload").click();
    } else {
        alert("失败增加格");
        $('#dealObjOntLat').fadeOut(fadeTime);
        $('#dealObjOntLatHide').slideUp(slideTime);
        objDelStatusGV = "none";
        formRest();
        $("#objOntReload").click();
    }
}

/*
 * function errDeal(XMLHttpRequest, textStatus, errorThrown) {
 * console.log("失败增加格"); alert(XMLHttpRequest.status);
 * alert(XMLHttpRequest.readyState); alert(textStatus); }
 */
// 将form中的值转换为键值对。

function getFormJson(frm) {
    addition = {};
    var objOntLat = {};
    addition = JSON.stringify(addition);
    var array = $(frm).serializeArray();
    console.log(array);
    $.each(array,function() {
        var proName = lowerFirstLetter(this.name.substring(3));
        if (objDelStatusGV == "add") {
            if (proName != "oid") {
                if (proName == 'peoElement' || proName == 'objElement' || proName == 'envElement') {
                    if (typeof(objOntLat[proName]) == 'undefined') objOntLat[proName] = this.value;
                    else objOntLat[proName] += "," + this.value;
                } else {
                    objOntLat[proName] = this.value;
                }
            }
        }
        if (objDelStatusGV == "edit") {
            if (proName == 'peoElement' || proName == 'objElement' || proName == 'envElement') {
                if (typeof(objOntLat[proName]) == 'undefined') objOntLat[proName] = this.value;
                else objOntLat[proName] += "," + this.value;
            } else {
                objOntLat[proName] = this.value;
            }
        }
    });
    return JSON.stringify(objOntLat);
}

// toLowerCase
function lowerFirstLetter(str) {
    return str.replace(/\b\w+\b/g,
    function(word) {
        return word.substring(0, 1).toLowerCase() + word.substring(1);
    });
}
Array.prototype.remove = function(from, to) {
    var rest = this.slice((to || from) + 1 || this.length);
    this.length = from < 0 ? this.length + from: from;
    return this.push.apply(this, rest);
};
function isexist(a, array) {
    for (var i = 0; i < array.length; i++) {
        if (array[i] == a) return true;
    }
    return false;
}

function timeElementSubmit(frm) {
    var act = timeElementEditUrl;
    var input = {};
    input["ontname"] = preontname;
    input["evelatname"] = $('#tecname').text();
    input["start"]=$('#tsStart').val();
    input["length"]=$('#tsLength').val();
    var inputstr = JSON.stringify(input);
    console.log(inputstr);
    $.ajax({
        // url : frm.action,
        url: act,
        type: frm.method,
        async: true,
        data: {
            inputStr: inputstr,
        },
        success: function(data){
        	console.log(data);
        	if(data.operateMsg!='suc'){
        		alert('出错了！');
            	$('#timeElementEdit').hide();
        		formReset("timeElementForm");
        	}
        	else{
        		$('#timeElementEdit').hide();
        		formReset("timeElementForm");
        		updateTimeElement($("#tecname").text())
        	}
        }
    });
}

function Submit(frm) {
    var inputStr = getFormJson(frm);
    var act = timeElementEditUrl;
    var input = {};
    input["ontname"] = preontname;
    input["evelatsid"] = $("#tecname").attr('evesid');
    input["start"]=$('#tsStart').val();
    input["length"]=$('#tsLength').val();
    var inputstr = JSON.stringify(input);
    console.log(inputstr);
    $.ajax({
        // url : frm.action,
        url: act,
        type: frm.method,
        async: true,
        data: {
            inputStr: inputstr,
        },
        success: function(data){
        	console.log(data);
        	if(data.operateMsg!='suc'){
        		alert('出错了！');
            	$('#timeElementEdit').hide();
        		formReset("timeElementForm");
        	}
        	else{
        		$('#timeElementEdit').hide();
        		formReset("timeElementForm");
        		updateTimeElement($("#tecname").attr('evesid'))
        	}
        }
    });
}

function conceptEditSubmit(frm){
	var formitem = {};
	/*formitem["latsid"]=$('#conceptlatsid').val();*/
	formitem["latname"]=$('#conceptlatname').val();
	formitem["parentlatname"]=$('#conceptparentlatname').val();
	for(var i=0; i<idarray.length;i++){
		formitem[$('#proli'+idarray[i].toString()).val()]=$('#attli'+idarray[i].toString()).val();
	}
	var inputstr = JSON.stringify(formitem);
    $.ajax({
    	url : conceptUpsertUrl,
    	type : "post",
    	async : false,
    	data:{
    		inputStr : inputstr
    	},
    	success: function(data){
    		$("#conceptEditWinClose").click();
    		$('#conceptReload').click();
    	}
    });
}
function objEditSubmit(frm){
	console.log(objnum);
	var input = {};
	input["ontname"]=preontname;
	input["evelatname"] = $('#ecname').text();
	var inputstr = JSON.stringify(input);
	$.ajax({
		url: objElementDelUrl,
		type: "post",
		async: false,
		data:{
			inputStr:inputstr
		},
		success:function(data){
			console.log("del");
		}
	});
	for(var i=1;i<=objnum;i++){
		var formitem ={};
		formitem["ontname"]=preontname;
		formitem["evelatname"]= $('#ecname').text();
		var samount = "#sAmount"+i.toString();
		console.log(samount);
		formitem["amount"]=$(samount).val();
		formitem["conceptlatname"]=$("#sConcept"+i.toString()).val();
		formitem["lane"]=$("#iLE"+i.toString()).val();
		console.log(formitem);
		var inputstr = JSON.stringify(formitem);
		$.ajax({
			url: objElementEditUrl,
			type: "post",
			async: false,
			data:{
				inputStr:inputstr
			},
			success:function(data){
				console.log("edit obj element");
			}
		})
	}
	updateObjElement($('#ecname').text());
}

function actionEditSubmit(frm){
    var input = {};
    input["ontname"] = preontname;
    input["evelatname"] = $('#ecname').text();
    input["degree"] = $('#sDegree').val();
    input["tool"] = $('#iTool').val();
    input["method"] = $("#iMethod").val();
    var inputstr = JSON.stringify(input);
    console.log(inputstr);
    $.ajax({
        url: actionElementEditUrl,
        type: "post",
        async: false,
        data: {
            inputStr: inputstr,
        },
        success: function(data){
        	console.log(data);
        	formReset("actionElementForm");
    		updateActionElement($("#ecname").text());
        }
    });
}

function envEditSubmit(frm){
	var input = {};
	input["ontname"] = preontname;
    input["evelatname"] = $('#ecname').text();
    input["conceptlatname"] = $('#envsConcept').val();
    input["envlane"] = $('#iEnvlane').val();
    var inputstr = JSON.stringify(input);
    $.ajax({
    	url: envElementEditUrl,
    	type: "post",
    	async: false,
    	data:{
    		inputStr:inputstr,
    	},
    	success:function(data){
    		formReset("envElementForm");
    		updateEnvElement($('#ecname').text());
    	}
    })
}

function assertEditSubmit(frm){
	var input = {};
	input["ontname"] = preontname;
    input["evelatname"] = $('#ecname').text();
    input["prestate"] = $('#iPrestate').val();
	input["massert"] = $('#iMassert').val();
	input["poststate"] = $('#iPoststate').val();
	var inputstr = JSON.stringify(input);
	$.ajax({
    	url: assertElementEditUrl,
    	type: "post",
    	async: false,
    	data:{
    		inputStr:inputstr,
    	},
    	success:function(data){
    		//...
    		formReset("assertElementForm");
    		updateAssertElement($('#ecname').text());
    	}
    })
}

function languageEditSubmit(frm){
	var input = {};
	input["ontname"] = preontname;
    input["evelatname"] = $('#ecname').text();
    input["triggerwords"] = $('#iTriggerWords').val();
    input["collocation"] = $('#iCollocation').val();
    var inputstr = JSON.stringify(input);
    $.ajax({
    	url: languageElementEditUrl,
    	type: "post",
    	async: false,
    	data:{
    		inputStr:inputstr,
    	},
    	success:function(data){
    		//...
    		formReset("languageElementForm");
    		updateLanElement($('#ecname').text());
    	}
    })
}