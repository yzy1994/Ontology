	var setting = {
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

	var zNodes = [ {
		id : 11,
		pId : 1,
		name : "lable as denoter",
		keyword:"Denoter",
		t : "I am ordinary, just click on me"
	},  {
		id : 12,
		pId : 1,
		name : "label as means",
		keyword:"Means",
		t : "I am ordinary, just click on me"
	},{
		id : 13,
		pId : 1,
		name : "label as time",
		keyword:"Time",
		t : "I am ordinary, just click on me"
	}, {
		id : 14,
		pId : 1,
		name : "label as location",
		keyword:"Location",
		t : "I am ordinary, just click on me"
	}, {
		id : 15,
		pId : 1,
		name : "label as participant",
		keyword:"Participant",
		t : "I am ordinary, just click on me"
	}, {
		id : 16,
		pId : 1,
		name : "label as object",
		keyword:"Object",
		t : "I am ordinary, just click on me"
	}, {
		id : 17,
		pId : 1,
		name : "label as event",
		keyword:"Event",
		t : "I am ordinary, just click on me"
	}, {
		id : 18,
		pId : 1,
		name : "label as sentence",
		keyword:"Sentence",
		t : "I am ordinary, just click on me"
	}, {
		id : 19,
		pId : 1,
		name : "label as paragraph",
		keyword:"Paragraph",
		t : "I am ordinary, just click on me"
	}, {
		id : 20,
		pId : 1,
		name : "label as content",
		keyword:"Content",
		t : "I am ordinary, just click on me"
	}, {
		id : 21,
		pId : 1,
		name : "label as report time",
		keyword:"ReportTime",
		t : "I am ordinary, just click on me"
	}, {
		id : 22,
		pId : 1,
		name : "label as title",
		keyword:"Title",
		t : "I am ordinary, just click on me"
	}, {
		id : 23,
		pId : 1,
		name : "label as Body",
		keyword:"Body",
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
		var textShowStr=$('#textShow').val();
		var firstStr=textShowStr.substr(0,startIndexPub);
		var secondStr=elementBridge.get(treeNode.keyword);
		var thirdStr=selectStrPub;
		var fourStr=elementMap.get(secondStr);
		var fiveStr=textShowStr.substr(endIndexPub,textShowStr.length-endIndex);
		var resultStr=firstStr+secondStr+thirdStr+fourStr+fiveStr;
		$('#textShow').val(resultStr);		
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
		$.fn.zTree.init($("#labelTreeUl"), setting, zNodes);
	});