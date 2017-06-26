var xTreeId = "#ec_Catalog";
var xConceptTreeId = "#c_Catalog";

var setting_builder = {
	view : {
		addHoverDom : addHoverDom,
		removeHoverDom : removeHoverDom,
		selectedMulti : false
	},
	edit : {
		enable : true,
		editNameSelectAll : true,
		showRemoveBtn : showRemoveBtn
	},
	data : {
		simpleData : {
			enable : true
		}
	},
	callback : {
		beforeDrag : beforeDrag,
		beforeEditName : beforeEditName,
		beforeRemove : beforeRemove,
		onRemove : onRemove,
	}
};

var setting_user = {
	view : {
		selectedMulti : false
	},
	edit : {
		enable : true,
		editNameSelectAll : true,
		showRemoveBtn : false
	},
	data : {
		simpleData : {
			enable : true
		}
	},
	callback : {
		beforeEditName : beforeEditName
	}
}

var setting_concept_user = {
		view : {
			selectedMulti : false
		},
		edit : {
			enable : true,
			editNameSelectAll : true,
			showRemoveBtn : false
		},
		data : {
			simpleData : {
				enable : true
			}
		},
		callback : {
			beforeEditName : EditConcept
		}
	}

var log, className = "dark";
function beforeDrag(treeId, treeNodes) {
	return false;
}

// 编辑功能回调函数
function beforeEditName(treeId, treeNode) {
	className = (className === "dark" ? "" : "dark");
	console.log("编辑" + treeNode.name + "节点");
	showObjFormConParRewrite(treeNode.name, "find");
	// updateCatalog();
	return false;
}

// 删除功能回调函数
function beforeRemove(treeId, treeNode) {
	className = (className === "dark" ? "" : "dark");
	var zTree = $.fn.zTree.getZTreeObj(xTreeId);
	zTree.selectNode(treeNode);
	return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
}
function onRemove(e, treeId, treeNode) {
	console.log("删除节点" + treeNode.name);
	delOntLatRewrite(treeNode.name, ELTN);
	$("#objOntReload").click();
}
function showRemoveBtn(treeId, treeNode) {
	return !treeNode.isParent;
}

var newCount = 1;
function addHoverDom(treeId, treeNode) {
	var sObj = $("#" + treeNode.tId + "_span");
	if (treeNode.editNameFlag || $("#addBtn_" + treeNode.tId).length > 0)
		return;
	var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
			+ "' title='add node' onfocus='this.blur();'></span>";
	sObj.after(addStr);
	var btn = $("#addBtn_" + treeNode.tId);
	if (btn)
		btn.bind("click", function() {
			$('#objOntAdd').click();
		});
};

function removeHoverDom(treeId, treeNode) {
	$("#addBtn_" + treeNode.tId).unbind().remove();
};

function EditConcept(treeId,treeNode) {
	
}

function selectAll() {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.setting.edit.editNameSelectAll = $("#selectAll").attr("checked");
}

$(document).ready(function() {
	updateCatalog();
	//updateConceptCatalog();
});

function updateCatalog() {
	var input = {};
	input["ontname"] = preontname;
	var inputstr = JSON.stringify(input);
	$.ajax({
		url : "objOntAction!queryECInzTreeData",
		type : "post",
		async : true,
		data : {
			inputStr : inputstr,
		},
		success : function(data) {
			var zTreeNodes = JSON.parse(data.resultStr);
			var setting = ($.cookie('role')=='builder') ? setting_builder : setting_user;
			$.fn.zTree.init($(xTreeId), setting, zTreeNodes);
		}
	})
}

function updateConceptCatalog() {
	var input = {};
	input["ontname"] = "Concept";
	var inputstr = JSON.stringify(input);
	$.ajax({
		url : "objOntAction!queryECInzTreeData",
		type : "post",
		async : true,
		data : {
			inputStr : inputstr,
		},
		success : function(data) {
			var zTreeNodes = JSON.parse(data.resultStr);
			var setting = setting_user;
			$.fn.zTree.init($(xConceptTreeId), setting, zTreeNodes);
		}
	})
}