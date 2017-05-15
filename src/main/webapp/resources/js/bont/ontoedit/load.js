$(document).ready(function(){
	/*var templist;
	var delontname="";
	var elements ={};
	$.ajax({
		url : "mainOntAction!queryOntInfo.action",
		type : "post",
		async : false,
		data : {},
		success : function(data) {
			templist = $.parseJSON(data.resultStr);
		}
	});
	for (var i = 0; i < templist.length; i++) {
		var temp = templist[i];
		$("tbody#tbo").append("<tr><td><a class=\"bont\" id="+temp.name+" href=\"pages/drawont/Bont.jsp\">"+temp.name+"</a></td><td>"+temp.field+"</td>" +
				"<td><button type=\"button\" class=\"button  btn-danger delbtn\" id=\""+temp.name+"\">删除本体</button>"
				+"&nbsp<button type=\"button\" class=\"button  btn-primary exportbtn\" id=\""+temp.name+"\">导出本体</button>&nbsp<button type=\"button\" class=\"button  btn-info infobtn\" id=\""+temp.name+"\">编辑本体<button></td>"+"</tr>");
		elements[temp.name]=temp.element;
	}*/
	
	$('#dealObjOntLat').hide();
	$('#delalert').hide();
	$('button#addOnt').click(function(){
		$('#dealObjOntLat').show();
		$('#ontname').prop('readOnly',false);
	})
	
	$('button.infobtn').click(function(){
		document.getElementById(this.id).click();
	})
	
	//导出本体
	$('button.exportbtn').click(function(){
		var ontname = this.id;
		var url= "filedownload.action"+"?ontname="+ ontname;
		/*$.ajax({
			url : url,
			type : "post",
			async : false,
			data : "",
			success : function(data) {
			}
		});*/
		var form = $("<form>");
		form.attr("style","display:none");
		form.attr("target","");
		form.attr("method","post");
		form.attr("action",url);
		var input1 = $("<input>");
		input1.attr("type","hidden");
		input1.attr("name","strZipPath");
		$("body").append(form);
		form.append(input1);
		form.submit();
		form.remove();
	})

	$('button#dialog-link').click(function(){
		$('#delalert').show();
	});
	
	$('a#dclose').click(function(){
		$('#delalert').hide();
	})
	$('#delcancel').click(function(){
		$('a#dclose').click();
	})
	$('#delsubmit').click(function(){
		$.ajax({
			url : "mainOntAction!delOnt.action",
			type : "post",
			async : false,
			data : {ontname:delontname},
			success : function(data) {
				
			}
		});
		
		var input = {};
		input["ontname"]=delontname;
		var inputstr = JSON.stringify(input);
		$.ajax({
			url : "objOntAction!removeECByOntname.action",
			type : "post",
			async : true,
			data : {
				inputStr : inputstr
			},
			success : function(data){}
		});
		
		$('a#dclose').click();
		window.location.reload();
	})
	
	$('a.bont').click(function(){
		$.cookie('ontname',this.id);
	})
	
	$('button.delbtn').click(function(){
		delontname=this.id;
		if(delontname=="突发事件本体"){
			alert("不能删除系统默认本体")
			return ;
		}
		$('#delalert').show();	
	})
	
	$('')
	
	$('#importo').click(function(){
		alert('请选择文件');
	})
	
	$('label#importOnt').click(function(){
		if($("input#file").val()==""){
			alert('请选择文件!!')
		}else{
			ajaxFileUpload();
		}
	})
	
	function ajaxFileUpload(){
		 $.ajaxFileUpload
         (
             {
                 url: 'mainOntAction!importOnt.action',
                 secureuri:false,
                 fileElementId: 'file',
                 dataType: 'json', 
                 success: function (data, status){
                	 alert("导入成功");
                	 window.location.reload();
                 },
                 error:function(data,status,e){  
                     window.location.reload();
                }
             }
         )
	}
});
