var whichOnt;
var conceptList = [];
var role = "";
preontname="";
$(document).ready(function() {
		//conceptListGV = queryConceptLatList();
		$("#objOntWin").css('top','20%');
		$("#objOntWin").css('left','20%')
		var fadeTime = 100;
		var slideTime = 200;
		//-
		whichOnt = ELTN;
		$('#objOntReload').click();
		//-
		whichOnt = CTN;
		$('#conceptReload').click();
		//-
		
		for(var temp in conceptList){
			if(temp=="remove")
				continue;
			$('#envsConcept').append("<option value=\"" + temp + "\">"+ temp +"</option>");
		}
		
		$('#ontname').text("\""+preontname+"\"");
		
		$('#user-guide').click(function(){
			$('.guide-article').show();
		})
		
		$("#about_ontology").click(function(){
			window.location.href="tool/about_ontology.html"; 
		})
		
		
		
		$(".viewOnt").click(function(){
			role = "notbuilder";
			ecNotEditable();
			conceptNotEditable();
		})
		$(".editOnt").click(function(){
			role = "builder";
		})
		
		$("#ObjOnt").click(function() {
			whichOnt = 'obj_ont_lat';
			$('li#liconcept').show();
			if ($("#objOntWin").is(":hidden")) {
				// $("#objOnt").show();
				//$('#objOntReload').click();
				$('#objOntWin').fadeIn(fadeTime);
			} else {
				// $("#objOnt").hide();
				$('#objOntWin').slideUp(slideTime);
			}
		});
		$("#EveOnt").click(function() {
			whichOnt = ELTN;
			$('#conceptSvgWin').slideUp(slideTime);
			$('#ecRelationWin').slideUp(slideTime);
			$('li#liconcept').hide();
			if ($("#objOntWin").is(":hidden")) {
				$('#objOntWin').fadeIn(fadeTime);
			} else {
				$('#objOntWin').slideUp(slideTime);
			}
		});

		$('#Concept').click(function() {
			whichOnt = CTN;
			$('#objOntWin').slideUp(slideTime);
			$('#ecRelationWin').slideUp(slideTime);
			$('li#liconcept').hide();
			if ($("#conceptSvgWin").is(":hidden")) {
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
		
		$('#ecRelation').click(function(){
			$('#objOntWin').slideUp(slideTime);
			$('#conceptSvgWin').slideUp(slideTime);
			if($('#ecRelationWin').is(":hidden")){
				$('#ecRelationWin').fadeIn(fadeTime);
			}else{
				$('#ecRelationWin').slideUp(slideTime);
			}
		})
		
		$('#ecRelationWinClose').click(function(){
			$('#ecRelationWin').hide();
		})
		$('#objOntWinClose').click(function(){
			$('#objOntWin').hide();
		})
		
		$('.max').click(function(){
			$('.max').hide();
			$('.revert').show();
			$('#objOntWin').css('top','0');
			$('#objOntWin').css('left','0');
			$('#objOntWin').css('width',screen.width);
			$('#objOntWin').css('height',screen.height);
			$('#objOntSvg').css('width',screen.width-30);
			$('#objOntSvg').css('height',screen.height-270);
		})
		
		$('.revert').click(function(){
			$('.max').show();
			$('.revert').hide();
			$('#objOntWin').css('top','20%');
			$('#objOntWin').css('left','20%');
			$('#objOntWin').css('width','1002px');
			$('#objOntWin').css('height','560px');
			$('#objOntSvg').css('width','990px');
			$('#objOntSvg').css('height','460px');
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