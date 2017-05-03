$(document).ready(function() {
	$("#searchButtonId5").click(function() {
		var fieldType=$("#fieldSel4").val();
		var ontType=$("#classSel4").val();
		// environ.envType = $("#classSel5").find("option:selected").text();
		$.ajax({
			type : "post",
			async : true,
			url : "eveOnt_searchOntInfo",
			data : {fieldType:fieldType,ontType:ontType},
			datatype : "json",
			success : function(data) {
				console.log(data.ontInfoListStr);
				var ontInfoList=jQuery.parseJSON(data.ontInfoListStr);
				jQuery("#showDetail").jqGrid("clearGridData");
				for(var i=0;i<=ontInfoList.length;i++){
					jQuery("#showDetail").jqGrid('addRowData',i+1,ontInfoList[i]);
					jQuery("#showDetail").jqGrid('setCell',i+1,0,i+1);
					jQuery("#showDetail").jqGrid('setCell',i+1,1,fieldType);
					jQuery("#showDetail").jqGrid('setCell',i+1,2,ontType);
				}
				
			}
		})
	})

})