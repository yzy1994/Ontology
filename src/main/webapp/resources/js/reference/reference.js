$(document).ready(function(){
	researcherlist = queryList(researcherFindUrl);
	paperlist = queryList(paperFindUrl);
	for(var i=0;i<researcherlist.length;i++){
		var temp = researcherlist[i];
		$('dl#researchers').append("<dd class=\"item col-xs-12\"><img src=\""+temp.picpath+"\"class=\"img\"><div class=\"detail\">"+temp.resume+"</div></dd>");
	}
	
	for(var i=0;i<paperlist.length;i++){
		var temp = paperlist[i];
		$('dl#ontologypapers').append("<dd class=\"paper col-xs-12\"> <a href=\""+temp.path+"\">"+temp.pname+"</a></dd>");
	}
})

function queryList(acturl){
	var tempList;
	$.ajax({
		url: acturl,
		method: "post",
		async: false,
		data:{
		},
		success: function(data){
			tempList = $.parseJSON(data.resultStr);
		}
	})
	return tempList;
}