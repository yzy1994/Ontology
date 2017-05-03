	var setting2 = {
		data : {
			key : {
				title : "t"
			},
			simpleData : {
				enable : true
			}
		},
		callback : {
			beforeClick : beforeClick,
			onClick : onClick
		}
	};

	var zNodes2 = [ {
		id : 20,
		pId : 1,
		name : "<xml version=\"1.0\" encoding=\"utf-8\" ?>",
		t : "I am ordinary, just click on me"
	},{
		id : 21,
		pId : 1,
		name : "type=",
		t : "I am ordinary, just click on me"
	}, {
		id : 22,
		pId : 1,
		name : "eid=\"e\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 23,
		pId : 1,
		name : "did=\"d\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 24,
		pId : 1,
		name : "sid=\"s\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 25,
		pId : 1,
		name : "oid=\"o\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 26,
		pId : 1,
		name : "tid=\"t\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 27,
		pId : 1,
		name : "lid=\"l\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 28,
		pId : 1,
		name : "mid=\"m\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 29,
		pId : 1,
		name : "polarity=\"negative\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 30,
		pId : 1,
		name : "type=\"origin\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 31,
		pId : 1,
		name : "type=\"method\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 32,
		pId : 1,
		name : "type=\"tool\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 33,
		pId : 1,
		name : "type=\"destination\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 34,
		pId : 1,
		name : "type=\"absTime\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 35,
		pId : 1,
		name : "type=\"relTime\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 36,
		pId : 1,
		name : "type=\"timeInterval\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 37,
		pId : 1,
		name : "====================",
		t : "I am ordinary, just click on me"
	}, {
		id : 38,
		pId : 1,
		name : "type=\"emergency\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 39,
		pId : 1,
		name : "type=\"thoughtevent\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 40,
		pId : 1,
		name : "type=\"movement\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 41,
		pId : 1,
		name : "type=\"statement\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 42,
		pId : 1,
		name : "type=\"absTime\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 43,
		pId : 1,
		name : "type=\"action\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 44,
		pId : 1,
		name : "type=\"operation\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 45,
		pId : 1,
		name : "type=\"stateChange\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 46,
		pId : 1,
		name : "type=\"perception\"",
		t : "I am ordinary, just click on me"
	}, {
		id : 47,
		pId : 1,
		name : "====================",
		t : "I am ordinary, just click on me"
	}, {
		id : 48,
		pId : 1,
		name : "<eRelation relType=\"Causal\" cause_eid=\"e\" effect_eid=\"e\"/>",
		t : "I am ordinary, just click on me"
	}, {
		id : 49,
		pId : 1,
		name : "<eRelation relType=\"Accompany\" accompanya_eid=\"e\" accompanyb_eid=\"e\"/>",
		t : "I am ordinary, just click on me"
	}, {
		id : 50,
		pId : 1,
		name : "<eRelation relType=\"Follow\" bevent_eid=\"e\" aevent_eid=\"e\"/>",
		t : "I am ordinary, just click on me"
	}, {
		id : 51,
		pId : 1,
		name : "<eRelation relType=\"Composite\" fevent_eid=\"e\" sevent_eids=\"e\"/>",
		t : "I am ordinary, just click on me"
	}, {
		id : 52,
		pId : 1,
		name : "<eRelation relType=\"Thoughtcontent\" thoughtevent_eid=\"e\" thoughtcontent_eids=\"e\"/>",
		t : "I am ordinary, just click on me"
	}];

	var log, className = "dark";
	function beforeClick(treeId, treeNode, clickFlag) {
		className = (className === "dark" ? "" : "dark");
		showLog("[ " + getTime() + " beforeClick ]&nbsp;&nbsp;" + treeNode.name);
		return (treeNode.click != false);
	}
	function onClick(event, treeId, treeNode, clickFlag) {
		if(modelState==0){
		$('#textShow').insertContent(treeNode.name);
		showLog("[ "
				+ getTime()
				+ " onClick ]&nbsp;&nbsp;clickFlag = "
				+ clickFlag
				+ " ("
				+ (clickFlag === 1 ? "single selected"
						: (clickFlag === 0 ? "<b>cancel selected</b>"
								: "<b>multi selected</b>")) + ")");
		}else{
			$('#modelTipDivHide').fadeIn(100);
			$('#modelTipDiv').slideDown(200);
		}
	}
	function showLog(str) {
		if (!log)
			log = $("#log");
		log.append("<li class='"+className+"'>" + str + "</li>");
		if (log.children("li").length > 8) {
			log.get(0).removeChild(log.children("li")[0]);
		}
	}
	function getTime() {
		var now = new Date(), h = now.getHours(), m = now.getMinutes(), s = now
				.getSeconds();
		return (h + ":" + m + ":" + s);
	}

	$(document).ready(function() {
		$.fn.zTree.init($("#insertTreeUl"), setting2, zNodes2);
	});