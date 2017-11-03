		var orderChart = echarts.init(document.getElementById("order"));
		var orderoption = {
			title: {
				text: '交易量汇总',
				subtext: '订单统计'
			},
			tooltip: {
				trigger: 'axis'
			},
			legend: {
				data: ['订单总数', '实付订单总数', '退单总数', '失效订单']
			},
			toolbox: {
				show: true,
				feature: {
					magicType: {
						show: true,
						type: ['line', 'bar']
					},
					restore: {
						show: true
					},
					saveAsImage: {
						show: true
					}
				}
			},
			calculable: true,
			xAxis: [{
				type: 'category',
				boundaryGap: false,
				data: ['201701', '201702', '201703', '201704', '201705', '201706', '201707', '201708', '201709',
					'201710', '201711', '201712'
				]
			}],
			yAxis: [{
				type: 'value',
				axisLabel: {
					formatter: '{value} 万/单'
				}
			}],
			itemStyle: {
				normal: {
					label: {
						show: false
					},
					labelLine: {
						show: false
					}
				}
			},
			series: [{
					name: '订单总数',
					type: 'line',
					data: [11, 11, 15, 13, 12, 13, 10, 32, 55, 11, 11, 32],
					markPoint: {
						data: [{
								type: 'max',
								name: '最大值'
							},
							{
								type: 'min',
								name: '最小值'
							}
						]
					}
				},
				{
					name: '实付订单总数',
					type: 'line',
					data: [2, 1, 15, 12, 22, 12, 133, 44, 51, 22, 31, 32],
					markPoint: {
						data: [{
								type: 'max',
								name: '最大值'
							},
							{
								type: 'min',
								name: '最小值'
							}
						]
					}
				},
				{
					name: '退单总数',
					type: 'line',
					data: [0, 3, 1, 3, 1, 1, 0, 2, 3, 1, 4, 2],
					markPoint: {
						data: [{
								type: 'max',
								name: '最大值'
							},
							{
								type: 'min',
								name: '最小值'
							}
						]
					}
				}, {
					name: '失效订单',
					type: 'line',
					data: [0, 3, 1, 3, 1, 1, 0, 2, 3, 1, 4, 2],
					markPoint: {
						data: [{
								type: 'max',
								name: '最大值'
							},
							{
								type: 'min',
								name: '最小值'
							}
						]
					}
				}
			]
		};
		orderChart.setOption(orderoption);
		$(window).resize(orderChart.resize);
