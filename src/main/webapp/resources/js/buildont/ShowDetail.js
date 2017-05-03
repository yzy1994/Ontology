jQuery("#showDetail").jqGrid({
	datatype: "local",

   	colNames:['序号','领域类型', '本体类型', '事件类号','事件类名','创建时间','创建者'],
   	colModel:[
   		{name:'id',index:'id', width:55,editable:false,editoptions:{readonly:true,size:10}},   	
   		{name:'fieldType',index:'fieldType', width:90,editable:true,editoptions:{size:25}, formoptions:{ rowpos:1, label: "Name", elmprefix:"(*)"},editrules:{required:true}},
   		{name:'ontType',index:'ontType', width:60, align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:2,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;"}},
   		{name:'eid',index:'eid', width:60, align:"right",editable:true,editoptions:{size:10},formoptions:{ rowpos:3,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;"}},
   		{name:'ecn',index:'ecn', width:60,align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:4,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
		{name:'creatTime',index:'creatTime', width:80,
			editable:true,
			editoptions:{size:12,
				dataInit:function(el){
					$(el).datepicker({dateFormat:'yy-mm-dd'});
				},
				defaultValue: function(){
					var currentTime = new Date();
					var month = parseInt(currentTime.getMonth() + 1);
					month = month <= 9 ? "0"+month : month;
					var day = currentTime.getDate();
					day = day <= 9 ? "0"+day : day;
					var year = currentTime.getFullYear();
					return year+"-"+month + "-"+day;				
				}
			},
			formoptions:{ rowpos:5, elmprefix:"(*)",elmsuffix:"  yyyy-mm-dd" },
			editrules:{required:true}
		},

		{name:'author',index:'author',width:70,
			editable: true,
			edittype:"select",
			editoptions:{dataUrl:'test.txt', defaultValue:'Intime'},
			formoptions:{ rowpos:7,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }
		}
   	],
   	rowNum:10,
   	rowList:[10,20,30],
   	pager: '#showDetailPage',
   	sortname: 'id',
    viewrecords: true,
    sortorder: "desc",
//    caption:"事件类查询结果",
	height:210
});


jQuery("#showDetail").jqGrid('navGrid','#showDetailPage', 
{edit : false,add : false,del : false,view:false,search:false,refresh:false},//options
{jqModal:true,checkOnUpdate:true,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true, bottominfo:"Fields marked with (*) are required"}, // edit options
{jqModal:true,checkOnUpdate:true,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true,bottominfo:"Fields marked with (*) are required"}, // add options
{reloadAfterSubmit:false,jqModal:false, closeOnEscape:true}, // del options
{closeOnEscape:true}, // search options
{navkeys: [true,38,40], height:250,jqModal:false,closeOnEscape:true} // view options
);