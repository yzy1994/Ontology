jQuery("#ActionDetail").jqGrid({
	datatype: "local",
    
   	colNames:['序号','动作事件序号','事件类名','动作事件组号','动作事件组类型','备注'],
   	colModel:[
   	   	   	{name:'id',index:'id', width:55,editable:true,editoptions:{readonly:false,size:10},formoptions:{ rowpos:1, label: "序号", elmprefix:"(*)"},editrules:{required:true,number:true}},
   		{name:'aecfn',index:'aecfn', width:90,editable:true,editoptions:{size:25}, formoptions:{ rowpos:2, label: "动作事件序号", elmprefix:"(*)"},editrules:{required:true,number:true}},  
   		{name:'ecn',index:'ecn', width:60,align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:3,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
//   		{name:'ecn',index:'ecn',width:70,
//			editable: true,
//			edittype:"select",
//			editoptions:{dataUrl:'test.txt', defaultValue:'Intime'},
//			formoptions:{ rowpos:3,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }
//		},
   		{name:'aecrn',index:'aecrn', width:60,align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:4,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
   		{name:'aecrnType',index:'aecrnType', width:60,align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:5,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
   		{name:'note',index:'note', width:100, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"20"}, formoptions:{ rowpos:6,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }}
	
   	],
   	rowNum:10,
   	rowList:[10,20,30],
   	pager: '#ActionDetailPage',
   	sortname: 'id',
    viewrecords: true,
    sortorder: "desc",
//    caption:"断言要素", 
    editurl:"comOnt",
    weight:400,
	height:100
});
var mydata = [
{id:"1",aecfn:"o1",ecn:"car",aecrn:"some",aecrnType:"paiticipant",note:"note3"},
{id:"1",aecfn:"o1",ecn:"car",aecrn:"some",aecrnType:"paiticipant",note:"note3"},
{id:"1",aecfn:"o1",ecn:"car",aecrn:"some",aecrnType:"paiticipant",note:"note3"},
{id:"1",aecfn:"o1",ecn:"car",aecrn:"some",aecrnType:"paiticipant",note:"note3"},
];
for(var i=0;i<=mydata.length;i++)
jQuery("#ActionDetail").jqGrid('addRowData',i+1,mydata[i]);
jQuery("#ActionDetail").jqGrid('navGrid','#ActionDetailPage',
{view:true}, //options
{jqModal:true,checkOnUpdate:true,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true, bottominfo:"Fields marked with (*) are required"}, // edit options
{jqModal:true,checkOnUpdate:true,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true,bottominfo:"Fields marked with (*) are required"}, // add options
{reloadAfterSubmit:false,jqModal:false, closeOnEscape:true}, // del options
{closeOnEscape:true}, // search options
{navkeys: [true,38,40], height:250,jqModal:false,closeOnEscape:true} // view options
);