var Define = {
	initTree: function() {
		$.ajax({
			url: 'system/define/data.htm',
			type: "get",
			data: {},
			dataType: "json",
			success: function(result) {
				if(result.code == 0) {
					$('#treeview').treeview({
						levels: 1,
						data: result.data,
						onNodeSelected: function(event, node) {
							alert(JSON.stringify(node));
							var url = "system/define/detail.htm?code="+node.code;
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
	add:function(){
		
	}
};