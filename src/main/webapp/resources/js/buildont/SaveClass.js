$(document).ready(function() {
	$("#saveClassBT").click(function() {
		console.log("state is"+state);
		var eventCls = new EventCls();
		eventCls.eid = $("#eidIPT").val();
		eventCls.ecn = $("#ecnIPT").val();
		var ets = "";
		var fieldType=$("#fieldSel4").val();
		var ontType=$("#classSel4").val();

		$("#parentSlt option").each(function() {
			var txt = $(this).text(); // 获取option的内容
			ets += txt + ",";
		})
		eventCls.ets = ets;

		var objList = $("#ObjectDetail").jqGrid("getRowData");
		eventCls.objList = objList;
		var actionList = $("#ActionDetail").jqGrid("getRowData");
		eventCls.actionList = actionList;
		var assertList = $("#AssertDetail").jqGrid("getRowData");
		eventCls.assertList = assertList;
		var langList = $("#LangDetail").jqGrid("getRowData");
		eventCls.langList = langList;
		var environ = new Environ();
		environ.envType = $("#classSel5").find("option:selected").text();
		environ.ets = $("#classSel6").find("option:selected").text();
		eventCls.environ = environ;
		var time = new Time();
		time.timeType = $("#classSel7").find("option:selected").text();
		eventCls.time = time;
//		console.log(JSON.stringify(eventCls));
		 $.ajax({
		 type:"post",
		 async:false,
		 url:"eveOnt_saveCls",
		 data:{eventClsJson:JSON.stringify(eventCls),fieldType:fieldType,ontType:ontType,state:state},
		 datatype:"json",
		 success:function(data){
		 saveResult=true;
		 }
		 })

	})
})
