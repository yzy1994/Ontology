function LoadECRelationGraph(ontname,echartsDivId){
	var myChart = echarts.init(document.getElementById(echartsDivId));
	var input = {};
	input["ontname"] = ontname;
	var inputstr = JSON.stringify(input);
	$.ajax({
		url : "echartsAction!getChartData.action",
		type : "post",
		async : false,
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
						repulsion : 1000,
						gravity : 0.1,
						edgeLength : 80,
					},
					symbol : 'roundRect',
					symbolSize : [80,40],
					lineStyle:{
						normal : {
							color: '#000000',
			                width: 1,
			                opacity: 1
						}
					},
					roam : true,
					draggable : true,
					label : {
						normal : {
							show : true
						}
					},
					edgeSymbol : [ 'pin', 'arrow' ],
					edgeSymbolSize : [ 10, 15 ],
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
		}
	})
	
}
