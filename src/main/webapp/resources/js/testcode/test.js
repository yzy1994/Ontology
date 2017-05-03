$(document).ready(
		function() {
			var nodes = [];
			var links = [];
			var constMaxDepth = 4;
			var constMaxChildren = 3;
			var constMinChildren = 2;
			var constMaxRadius = 10;
			var constMinRadius = 2;
			var mainDom = document.getElementById('main');

			function rangeRandom(min, max) {
				return Math.random() * (max - min) + min;
			}

			function createRandomNode(depth) {
				var x = mainDom.clientWidth / 2 + (.5 - Math.random()) * 200;
				var y = (mainDom.clientHeight - 20) * depth
						/ (constMaxDepth + 1) + 20;
				var node = {
					name : 'NODE_' + nodes.length,
					value : rangeRandom(constMinRadius, constMaxRadius),
					// Custom properties
					id : nodes.length,
					depth : depth,
					initial : [ x, y ],
					fixY : true,
					category : depth === constMaxDepth ? 0 : 1
				}
				nodes.push(node);

				return node;
			}

			function forceMockThreeData() {
				var depth = 0;

				var rootNode = createRandomNode(0);
				rootNode.name = 'ROOT';
				rootNode.category = 2;

				function mock(parentNode, depth) {
					var nChildren = Math.round(rangeRandom(constMinChildren,
							constMaxChildren));

					for (var i = 0; i < nChildren; i++) {
						var childNode = createRandomNode(depth);
						links.push({
							source : parentNode.id,
							target : childNode.id,
							weight : 1
						});
						if (depth < constMaxDepth) {
							mock(childNode, depth + 1);
						}
					}
				}

				mock(rootNode, 1);
			}

			forceMockThreeData();
			console.log(nodes);
			console.log(links);
			var myChart = echarts.init(document.getElementById('main'));
			var option = {
				title : {
					text : 'Force',
					subtext : 'Force-directed tree',
					x : 'right',
					y : 'bottom'
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
					name : " ",
					roam : true,
					draggable : true,
					symbolSize : 100,
					lineStyle : {
						normal : {
							type : 'solid',
						},
					},
					layout : 'force',
					force : {
						edgeLength : 300,
						repulsion : 1000
					},
					label : {
						normal : {
							show : 'true',
							position : 'bottom',
							formatter : '{c}'
						}
					},
					minRadius : constMinRadius,
					maxRadius : constMaxRadius,
					nodes : nodes,
					links : links
				} ]
			};

			myChart.setOption(option);
		})