jQuery("#LangDetail").jqGrid({
	datatype: "local",
    
   	colNames:['序号','语言表现类型','要素属性1','要素属性值1','要素属性2','要素属性值2','备注'],
   	colModel:[
   	   	{name:'id',index:'id', width:55,editable:true,editoptions:{readonly:false,size:10},formoptions:{ rowpos:1, label: "序号", elmprefix:"(*)"},editrules:{required:true,number:true}},
   		{name:'langtype',index:'langtype', width:90,editable:true,editoptions:{size:25}, formoptions:{ rowpos:2, label: "语言表现类型", elmprefix:"(*)"},editrules:{required:true}},  	
   		{name:'arg1',index:'arg1', width:60,align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:3,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
 		{name:'arg1value',index:'arg1value', width:100,align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:4,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
   		{name:'arg2',index:'arg2', width:60,align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:5,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
 		{name:'arg2value',index:'arg2value', width:100,align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:6,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
   		{name:'note',index:'note', width:100, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"20"}, formoptions:{ rowpos:7,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }}		
   	],
   	rowNum:10,
   	rowList:[10,20,30],
   	pager: '#LangDetailPage',
   	sortname: 'id',
    viewrecords: true,
    sortorder: "desc",
//    caption:"语言表现要素", 
    editurl:"comOnt",
	height:100
});
var mydata = [
{id:"1",langtype:"o1",arg1:"car",arg1value:"some",arg2:"paiticipant",arg2value:"paiticipant",note:"note3"},
{id:"1",langtype:"o1",arg1:"car",arg1value:"some",arg2:"paiticipant",arg2value:"paiticipant",note:"note3"},
{id:"1",langtype:"o1",arg1:"car",arg1value:"some",arg2:"paiticipant",arg2value:"paiticipant",note:"note3"},
{id:"1",langtype:"o1",arg1:"car",arg1value:"some",arg2:"paiticipant",arg2value:"paiticipant",note:"note3"},
{id:"1",langtype:"o1",arg1:"car",arg1value:"some",arg2:"paiticipant",arg2value:"paiticipant",note:"note3"},
{id:"1",langtype:"o1",arg1:"car",arg1value:"some",arg2:"paiticipant",arg2value:"paiticipant",note:"note3"},
];
for(var i=0;i<=mydata.length;i++)
jQuery("#LangDetail").jqGrid('addRowData',i+1,mydata[i]);
jQuery("#LangDetail").jqGrid('navGrid','#LangDetailPage',
{view:true}, //options
{jqModal:true,checkOnUpdate:true,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true, bottominfo:"Fields marked with (*) are required"}, // edit options
{jqModal:true,checkOnUpdate:true,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true,bottominfo:"Fields marked with (*) are required"}, // add options
{reloadAfterSubmit:false,jqModal:false, closeOnEscape:true}, // del options
{closeOnEscape:true}, // search options
{navkeys: [true,38,40], height:250,jqModal:false,closeOnEscape:true} // view options
);