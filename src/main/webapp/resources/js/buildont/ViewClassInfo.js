$(document).ready(function() {
	jQuery("#detailBT").click(function() {

		Reset();
		var id = jQuery("#showDetail").jqGrid('getGridParam', 'selrow');
		if (id) {
			var ret = jQuery("#showDetail").jqGrid('getRowData', id);
			$.ajax({
				type : "post",
				async : false,
				url : "eveOnt_searchClsByEcn",
				data : {ecn:ret.ecn},
				datatype : "json",
				success : function(data) {
					console.log(data.eventClsJson);
					var eventClsJson=new EventCls();
					 eventClsJson=jQuery.parseJSON(data.eventClsJson);
				  $("#eidIPT").val(eventClsJson.eid);
				  $("#ecnIPT").val(eventClsJson.ecn);
					var objList = eventClsJson.objList;
					for(var i=0;i<=objList.length;i++)
						jQuery("#ObjectDetail").jqGrid('addRowData',i+1,objList[i]);
					var actionList = eventClsJson.actionList;
					for(var i=0;i<=actionList.length;i++)
						jQuery("#ActionDetail").jqGrid('addRowData',i+1,actionList[i]);
					var assertList = eventClsJson.assertList;
					for(var i=0;i<=assertList.length;i++)
						jQuery("#AssertDetail").jqGrid('addRowData',i+1,assertList[i]);
					var langList = eventClsJson.langList;
					for(var i=0;i<=langList.length;i++)
						jQuery("#LangDetail").jqGrid('addRowData',i+1,langList[i]);
//					var environ = new Environ();
//					environ.envType = $("#classSel5").find("option:selected").text();
//					environ.ets = $("#classSel6").find("option:selected").text();
//					eventCls.environ = environ;
//					var time = new Time();
//					time.timeType = $("#classSel7").find("option:selected").text();
//					eventCls.time = time;
//					jQuery("#showDetail").jqGrid("clearGridData");
//					for(var i=0;i<=ontInfoList.length;i++)
//						jQuery("#showDetail").jqGrid('addRowData',i+1,ontInfoList[i]);
//					saveResult = true;
					
				}
			})

$('#infoDivHide').fadeIn(fadeTime);
$('#infoDiv').slideDown(slideTime);

$('#saveClassBT').hide();
		} else {
			alert("Please select row");
		}
	});
})