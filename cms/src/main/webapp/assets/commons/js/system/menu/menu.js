var Menu = {
	init : function(group) {
		$.ajax({
			url : 'system/menu/data.htm',
			type : "get",
			data : {groupCode:group},
			dataType : "json",
			success : function(result) {
				if (result.code == 0) {
					$('#treeview').treeview({
						levels : 1,
						data : result.data,
						onNodeSelected : function(event, node) {
							if(node.code != "0"){
								var url = "system/menu/detail.htm?code=" + node.code;
								$("#m_iframe").attr('src', url);								
							}
						}
					});
				} else {
					layer.alert(result.message);
				}
			},
			error : function(result) {
				layer.alert('加载参数列表失败，失败原因：' + JSON.stringify(result));
			}
		});
	}
}