function Reset(){
	  $("#eidIPT").val("");
	  $("#ecnIPT").val("");
	  $("#classSel5").get(0).selectedIndex=0
	  $("#classSel6").get(0).selectedIndex=0;
	  $("#classSel7 option:first").prop("selected",'selected');
	jQuery("#ObjectDetail").jqGrid("clearGridData");
	jQuery("#ActionDetail").jqGrid("clearGridData");
	jQuery("#AssertDetail").jqGrid("clearGridData");
	jQuery("#LangDetail").jqGrid("clearGridData");
	
	
}