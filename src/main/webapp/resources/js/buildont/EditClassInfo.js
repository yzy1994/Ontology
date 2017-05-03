$(document).ready(function() {
	jQuery("#editBT").click(function() {
		state="edit";
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
					
	              Reset();
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
						jQuery("#LangDetail").jqGrid('addRowData',i+1,langList[i]);}})
			
			$('#infoDivHide').fadeIn(fadeTime);
			$('#infoDiv').slideDown(slideTime);
			$('#saveClassBT').show();
			$("#eidIPT").attr("readonly",true);
			$("#ecnIPT").attr("readonly",true);
		} else {
			alert("Please select row");
		}

	})

})