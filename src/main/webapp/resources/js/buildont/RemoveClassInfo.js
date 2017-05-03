$(document).ready(function() {
	$("#removeBT").click(function() {
		var fieldType=$("#fieldSel4").val();
		var ontType=$("#classSel4").val();
		var id = jQuery("#showDetail").jqGrid('getGridParam', 'selrow');
		if (id) {
			var ret = jQuery("#showDetail").jqGrid('getRowData', id);
		
		$.ajax({
			type : "post",
			async : true,
			url : "eveOnt_removeClsByEcn",
			data : {ecn:ret.ecn},
			datatype : "json",
			success : function(data) {
				console.log(data.ontInfoListStr);
				var ontInfoList=jQuery.parseJSON(data.ontInfoListStr);
				jQuery("#showDetail").jqGrid("clearGridData");
				for(var i=0;i<=ontInfoList.length;i++){
				jQuery("#showDetail").jqGrid('addRowData',i+1,ontInfoList[i]);
             	jQuery("#showDetail").jqGrid('setCell',i+1,0,i+1);
				jQuery("#showDetail").jqGrid('setCell',i+1,1,fieldType);
				jQuery("#showDetail").jqGrid('setCell',i+1,2,ontType);}
				
			}
		})
		}
		else {
				alert("Please select row");
			}
	})
})