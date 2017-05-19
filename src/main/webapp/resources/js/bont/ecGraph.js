function LoadECRelationGraph(ontname,echartsDivId){
	var myChart = echarts.init(document.getElementById(echartsDivId));
	var input = {};
	input["ontname"] = ontname;
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
		}
	})
	
}
