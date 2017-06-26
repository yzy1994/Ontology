$(document).ready(function(){
	$('#dealObjOntLat').hide();
	$('#delalert').hide();
	$('button#addOnt').click(function(){
		$('#addModal').modal();
		$('#ontname').prop('readOnly',false);
	})
	
	var path = document.URL;
	var projectpath = document.location.pathname.substring(1);
	var projectname = projectpath.substring(0,projectpath.indexOf("/"));
	var base = path.substring(0,path.indexOf(document.location.pathname))
	
	$('.infobtn').click(function(){
		$.cookie('role','notbuilder');
		$.cookie('ontname',this.id);
		window.location.href=(base + "/" + projectname +'/tool/bont.html');
	})
	
	$('.editbtn').click(function(){
		$.cookie('role','builder');
		console.log(this.id);
		$.cookie('ontname',this.id);
		window.location.href=(base + "/" + projectname +'/tool/bont.html');
	})
	
	//导出本体
	$('button.exportbtn').click(function(){
		var ontname = this.id;
		var url= "filedownload.action"+"?ontname="+ ontname;
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
	
	
	$('button.delbtn').click(function(){
		delontname=this.id;
		if(delontname=="突发事件本体"){
			alert("不能删除系统默认本体")
			return ;
		}
		$('#removeModal').modal();
	})
	
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
