function LoadECRelationGraph(ontname,echartsDivId){
	var myChart = echarts.init(document.getElementById(echartsDivId));
	var input = {};
	input["ontname"] = ontname;
	input["latname"] = "";
	var inputstr = JSON.stringify(input);
	$.ajax({
		url : "echartsAction!getChartData.action",
		type : "post",
		async : true,
		data : {
			inputStr : inputstr
		},
		success : function(data) {
			var option = {
				title : {
					text : ''
				},
				tooltip : {
					trigger : 'item',
					formatter : '{a}{b} {c}'
				},
				toolbox : {
					show : true,
					feature : {
						restore : {
							show : true
						},
						magicType : {
							show : true,
							type : [ 'force', 'chord' ]
						},
						saveAsImage : {
							show : true
						}
					}
				},
				series : [ {
					type : 'graph',
					layout : 'force',
					force : {
						repulsion : 600,
						gravity : 0.1,
						edgeLength : 80,
					},
					symbol : 'roundRect',
					symbolSize : [48,28],
					lineStyle:{
						normal : {
							color: '#000',
			                width: 1,
			                opacity: 1
						}
					},
					label:{
						normal :{
							show: true,
							offset: [0,-2],
							textStyle: {
								color: "#000",
								fontStyle: 'normal',
								fontSize: 10
							},
						}
					},
					roam : true,
					draggable : true,
					edgeSymbol : [ 'pin', 'arrow' ],
					edgeSymbolSize : [ 10, 15 ],
					itemStyle:{
						normal:{
							color: {
								type: 'radial',
							    x: 0.5,
							    y: 0.5,
							    r: 1,
							    colorStops: [{
							        offset: 0, color: '#fff' // color at 0% position
							    }, {
							        offset: 1, color: 'rgb(58,179,251)' // color at 100% position
							    }],
							    globalCoord: false // false by default
							},
						}
					},
					edgeLabel : {
						normal : {
							textStyle : {
								fontSize : 20
							}
						}
					},
					data : JSON.parse(data.nodes),
					// links: [],
					links : JSON.parse(data.links),
				} ]
			};
			myChart.setOption(option, true);
			var options = {
					items : [{
						header : '功能菜单'
					},
					{
						text : '添加事件类关系',
						onclick : function(eve){
							$('#myModal').modal();
						}
					},],
					action: "contextmenu",
			};
			$('#main').contextify(options);
		}
	})
}
$('#ecr_form').bind('submit',function() {
	if($('#rid').val()==""||$('#source').val()==""||$('#target').val()==""||$('#ontname').val()==""){
		alert('请将表单填写完整!!')
	}else{
		input = {};
		input["ecrid"] = 0;
		input["rid"]=$('#rid').val();
		input["target"]=$('#target').val();
		input["source"]=$('#source').val();
		input["ontname"]=$('#ontname').val();
		console.log(input);
		inputstr = JSON.stringify(input);
		$.ajax({
			url: "ecRelationAction!upsertECRelation",
	        type: "post",
	        async: true,
	        data: {
	            inputStr: inputstr,
	        },
	        success: function(data){
	        	LoadECRelationGraph(preontname, "main");
	        	$('#rid').val('');
	        	$('#source').val('');
	        	$('#target').val('');
	        	$('#myModal').modal('hide');
	        }
		})
	}
	return false;
});
$(document).ready(function(){
	$('#ontname').val(preontname);
	LoadECRelationGraph(preontname, "main");
})