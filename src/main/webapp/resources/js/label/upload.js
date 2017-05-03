$(document).ready(function() {
var flag=0;
$("#openImgId").click(function(){ 
	fileStatusPub=1;
	if($('#textShow').val()!=""){	
		$('#yesOrNoDivHide').fadeIn(100);
		$('#yesOrNoDiv').slideDown(200);                        
     }else{
    	 $("#file_upload").trigger("click");
     }
	flag=1;	
});
//http://www.360doc.com/content/12/1102/11/7851074_245255767.shtml
$("#file_upload").live('change',function(){
	$("#btn_upload").trigger("click");
}); 
//判断其中任意一个文本框的值是否被修改
//绑定事件
//为界面上的所有元素添加focusin和focusout事件，
//用于判断用户是否修改了该值
//function bindEvent() {
//	var temp;
//	$("#span_upload,#gg,#hth,#zs,#zl").bind({
//				focusin : function() {
//					// 取得当前元素的id
//					// alert(this.id);
//					// alert("获得焦点时的值是："+$(this).val());
//					temp = $.trim($(this).val());
//				},
//				focusout : function() {
//					// alert("失去焦点时的值是："+$(this).val());
//					var lastValue = $.trim($(this).val());
//					var yh = $.trim($("#yh").val());
//					if (yh) {
//						if (temp != lastValue && null != lastValue
//								&& "" != lastValue) {
//							 alert("值改变了！");
//							$("#jg").val("异常");
//							$("#jg").css({
//										"color" : "red"
//									});
//						}
//					}// else {
//					// alert("没有变!");
//					// $("#jg").val("正常");
//					// }
//				}
//			});
//}
$("html").die().live("keydown",function(event){    
        if(event.keyCode==13){
        	alert("enter");
        	   var data2 = "the People's Republic of China".split(" ");     
        	     $("#autocomplete2").autocomplete(data2,{minChars:0}).result(function(event,data2,formatted){            alert(data2);        });
           //这里添加要处理的逻辑
        
        }
       
});  

$("#btn_upload").click(function(){     
    	$("#loading").ajaxStart(function(){       
    		$(this).show();// 开始上传
    		}).ajaxComplete(function(){            
    			$(this).hide();// 上传结束
    			});                 
    	$.ajaxFileUpload({            
    		url:"upload",// 文件上传服务器请求Action
    		secureuri:true,// 安全提交，默认为false
    		fileElementId:"file_upload",// 文件类型的id
    		dataType:"json",// 返回值类型
    		success:function(data){// 服务器响应成功
//    			alert(data);
    			fileNamePub=data.uploadFileName;
    			   $.ajax({           
    				   url: data.showFilePath,   
    				   dataType: 'text',       
    				   success: function(data) {    					  
    					   $("#textShow").val(data); 
    					   }       
    			   });
    			
    			$("#span_title2").text(data.message).css("color","red");              
    			$("#upload_result").show();           
    			$(this).attr("src","/FESWork/img/right2.png");            },          
    			error:function(data){// 服务器响应失败
    				$("#span_title2").text(data.message).css("color","red");        
    				}     
    			})     
    				return false;    });
 })
