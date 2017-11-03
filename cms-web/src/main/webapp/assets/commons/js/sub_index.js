var Index = {
	orderChart: function() {
		$.ajax({
			url: 'echarts/order/data.htm',
			type: "GET",
			dataType: "json",
			success: function(result) {
				var orderoption = {
						title: {
							text: '交易量汇总',
							subtext: '订单统计'
						},
						tooltip: {
							trigger: 'axis'
						},
						legend: {
							data: ['订单总量', '实际成交量', '失效订单量']
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
						series: result
					};
					var orderChart = echarts.init(document.getElementById("order"), 'macarons');
					orderChart.setOption(orderoption);
					$(window).resize(orderChart.resize);
			},
			error: function(result) {
				window.parent.location.href = UsePublic.ERROR_URL;
			}
		});
	},
	userChart: function() {
		$.ajax({
			url: 'echarts/user/data.htm',
			type: "GET",
			dataType: "json",
			success: function(result) {
				var useroption = {
					title: {
						text: '用户在线汇总',
						subtext: '用户统计'
					},
					tooltip: {
						trigger: 'axis'
					},
					legend: {
						data: ['用户总数', '老用户', '新增用户']
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
					series: result
				};
				var userChart = echarts.init(document.getElementById("user"), 'macarons');
				userChart.setOption(useroption);
				$(window).resize(userChart.resize);
			
			},
			error: function(result) {
				window.parent.location.href = UsePublic.ERROR_URL;
			}
		});
	}
};