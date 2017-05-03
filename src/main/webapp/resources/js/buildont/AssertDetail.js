jQuery("#AssertDetail").jqGrid({
	datatype: "local",
    
   	colNames:['序号','断言类型','角色号','事件类名称','角色状态','备注'],
   	colModel:[
   	   	   	{name:'id',index:'id', width:55,editable:true,editoptions:{readonly:false,size:10},formoptions:{ rowpos:1, label: "序号", elmprefix:"(*)"},editrules:{required:true,number:true}},
       {name:'atype',index:'atype', width:90,
			editable: true,
			edittype:"select",
			editoptions:{value:"pp:pp;mp:mp;ap:ap", defaultValue:'Intime'},
  		   formoptions:{ rowpos:2, label: "断言类型", elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;"},
        },  
		{name:'eon',index:'eon', width:100,align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:3,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
		{name:'ecn',index:'ecn', width:100,align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:4,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
   		
//   		{name:'eon',index:'eon',width:70,
//			editable: true,
//			edittype:"select",
//			editoptions:{dataUrl:'test.txt', defaultValue:'Intime'},
//			formoptions:{ rowpos:3,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }
//		},
//   		{name:'ecn',index:'ecn', width:60,align:"right",
//			editable: true,
//			edittype:"select",
//			editoptions:{dataUrl:'test.txt', defaultValue:'Intime'},
//			formoptions:{ rowpos:4,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
 		{name:'state',index:'state', width:100,align:"right",editable:true,editoptions:{size:10}, formoptions:{ rowpos:5,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }},
   		{name:'note',index:'note', width:100, sortable:false,editable: true,edittype:"textarea", editoptions:{rows:"2",cols:"20"}, formoptions:{ rowpos:6,elmprefix:"&nbsp;&nbsp;&nbsp;&nbsp;" }}		
   	],
   	rowNum:10,
   	rowList:[10,20,30],
   	pager: '#AssertDetailPage',
   	sortname: 'id',
    viewrecords: true,
    sortorder: "desc",
//    caption:"伴随动作事件", 
    editurl:"comOnt",
	height:100
});
var mydata = [
{id:"1",atype:"o1",eon:"car",ecn:"some",state:"paiticipant",note:"note3"},
{id:"1",atype:"o1",eon:"car",ecn:"some",state:"paiticipant",note:"note3"},
{id:"1",atype:"o1",eon:"car",ecn:"some",state:"paiticipant",note:"note3"},
{id:"1",atype:"o1",eon:"car",ecn:"some",state:"paiticipant",note:"note3"},
];
for(var i=0;i<=mydata.length;i++)
jQuery("#AssertDetail").jqGrid('addRowData',i+1,mydata[i]);
jQuery("#AssertDetail").jqGrid('navGrid','#AssertDetailPage',
{view:true}, //options
{jqModal:true,checkOnUpdate:true,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true, bottominfo:"Fields marked with (*) are required"}, // edit options
{jqModal:true,checkOnUpdate:true,savekey: [true,13], navkeys: [true,38,40], checkOnSubmit : true, reloadAfterSubmit:false, closeOnEscape:true,bottominfo:"Fields marked with (*) are required"}, // add options
{reloadAfterSubmit:false,jqModal:false, closeOnEscape:true}, // del options
{closeOnEscape:true}, // search options
{navkeys: [true,38,40], height:250,jqModal:false,closeOnEscape:true} // view options
);