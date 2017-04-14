var Param = {
	initTree: function() {
		$.ajax({
			url: 'data/json/system/system/param.json',
			type: "get",
			data: {},
			dataType: "json",
			success: function(result) {
				//result = JSON.parse(result);
				if(result.code == 0) {
					$('#treeview').treeview({
						levels: 1,
						data: result.data,
						onNodeSelected: function(event, node) {
							var url = "html/system/system/param_detail.html";
							$("#P_iframe").attr('src', url);
						}
					});
				} else {
					layer.alert(result.message);
				}
			},
			error: function(result) {
				layer.alert('加载参数列表失败，失败原因：' + JSON.stringify(result));
			}
		});
	},
	initData: function() {

	}
};