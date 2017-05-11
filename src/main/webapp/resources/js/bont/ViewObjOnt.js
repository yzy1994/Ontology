var whichOnt;
var conceptList = [];
var role = "";
preontname="突发事件本体";
$(document).ready(function() {
			conceptListGV = queryConceptLatList();
			updateConceptList();
			preontname = $.cookie('ontname');

			var fadeTime = 100;
			var slideTime = 200;
			$("label.viewOnt").click(function(){
				role = "notbuilder";
				ecNotEditable();
				conceptNotEditable();
			})
			$("label.editOnt").click(function(){
				role = "builder";
			})
			
			$("label#ObjOnt").click(function() {
				whichOnt = 'obj_ont_lat';
				$('li#liconcept').show();
				if ($("#objOntWin").is(":hidden")) {
					// $("#objOnt").show();
					$('#objOntReload').click();
					$('#objOntWin').fadeIn(fadeTime);
				} else {
					// $("#objOnt").hide();
					$('#objOntWin').slideUp(slideTime);
				}
			});
			$("label#EveOnt").click(function() {
				whichOnt = ELTN;
				$('li#liconcept').hide();
				$('#objOntWin > div.title > h2').text('事件类层次图');
				$('#objOntWin').css("top","100px");
				$('#objOntWin').css("left","100px");
				
				/*
				 * $('li#peopleElement').show(); $('li#objElement').show();
				 * $('li#envElement').show();
				 */
				if ($("#objOntWin").is(":hidden")) {
					// $("#objOnt").show();
					$('#objOntReload').click();
					$('#objOntWin').fadeIn(fadeTime);
				} else {
					// $("#objOnt").hide();
					$('#objOntWin').slideUp(slideTime);
				}
			});

			$('label#Concept').click(function() {
				whichOnt = CTN;
				$('li#liconcept').hide();
				if ($("#conceptSvgWin").is(":hidden")) {
					$('#conceptReload').click();
					$('#conceptReload').click();
					$('#conceptSvgWin').fadeIn(fadeTime);
				} else {
					$('#conceptSvgWin').slideUp(slideTime);
				}
			})

			/*var tempList = queryLatList("concept");
			for (var i = 0; i < tempList.length; i++) {
				var temp = tempList[i];
				$('select#objConcept').append(
						"<option value=\"" + temp.latname + "\">"
								+ temp.latname + "</option>");
			}*/
			/* <option value="audi">Audi</option> */
			
			$('label#ecRelation').click(function(){
				$('#ecRelationWin').show();
			})
			
			$('#ecRelationWinClose').click(function(){
				$('#ecRelationWin').hide();
			})			
			
});


function queryLatList(ontname) {
	var input = {};
	input["ontname"] = preontname;
	input["collection"] = ontname;
	var tempList;
	var inputstr = JSON.stringify(input);
	var url = "objOntAction!queryLatByMongo.action";
	$.ajax({
		url : url,
		type : "post",
		async : false,
		data : {
			inputStr : inputstr
		},
		success : function(data) {
			tempList = $.parseJSON(data.resultStr);
		}
	})
	return tempList;
}