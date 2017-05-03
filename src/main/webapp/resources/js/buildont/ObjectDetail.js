jQuery("#ObjectDetail").jqGrid({
	datatype: "local",
    
   	colNames:['序号','角色号', '父类名称','模糊数量','对象类型','语法类型','备注'],
   	colModel:[
   	   	{name:'id',index:'id', width:55,editable:true,editoptions:{readonly:false,size:10},formoptions:{ rowpos:1, label: "序号", elmprefix:"(*)"},editrules:{required:true,number:true}},
   		{name:'eon',index:'eon', width:90,editable:true,editoptions:{size:25}, formoptions:{ rowpos:2, label: "角色号", elmprefix:"(*)"},editrules:{required:true}},  	
   		{name:'etds',index:'etds', width:60,align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:3,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},	
//   		{name:'etds',index:'etds',width:70,
//			editable: true,
//			edittype:"select",
//			editoptions:{dataUrl:'', defaultValue:'Intime'},
//			formoptions:{ rowpos:3,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }
//		},
   		{name:'fnv',index:'fnv', width:60,align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:4,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
 		{name:'objType',index:'objType', width:60,
   			align:"right",
   			editable:true,
   			edittype:"select",
   			editoptions:{value:"Object:Object;Participant:Participant", defaultValue:'Object'},
   			formoptions:{ rowpos:5,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
 		{name:'gramRoleType',index:'gramRoleType', width:60,
   				align:"right",
   				editable:true,
   				edittype:"select",
   	   			editoptions:{value:"subject:subject;object:object", defaultValue:'subject'},
   	   			formoptions:{ rowpos:6,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
   		{name:'note',index:'note', width:100, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"20"}, formoptions:{ rowpos:7,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }}		
   	],
   	rowNum:10,
   	rowList:[10,20,30],
   	pager: '#ObjectDetailPage',
   	sortname: 'id',
    viewrecords: true,
    sortorder: "desc",
//    caption:"事件类查询结果",
    editurl:"comOnt",
	height:100
});

jQuery("#ObjectDetail").jqGrid('navGrid','#ObjectDetailPage',
{view:true}, //options
{jqModal:true,checkOnUpdate:true,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true, bottominfo:"Fields marked with (*) are required"}, // edit options
{jqModal:true,checkOnUpdate:true,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true,bottominfo:"Fields marked with (*) are required"}, // add options
{reloadAfterSubmit:false,jqModal:false, closeOnEscape:true}, // del options
{closeOnEscape:true}, // search options
{navkeys: [true,38,40], height:250,jqModal:false,closeOnEscape:true} // view options
);