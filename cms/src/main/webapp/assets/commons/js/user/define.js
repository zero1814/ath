/**
 * 用户-参数相关函数 
 */
var Define = {
	init: function(group) {
		$.ajax({
			url: 'user/define/tree.htm',
			type: "get",
			data: {},
			dataType: "json",
			success: function(result) {
				if(result.code == 0) {
					var tree = [{
						text: result.treeText,
						nodes: result.data
					}];
					Tree.init("treeview", false, tree, function(event, node) {
						if(node.code) {
							if(node.code == "0") {
								var url = "user/define/addindex.htm?code=0&group=" + node.groupCode;
								$("#m_iframe").attr('src', url);
							} else {
								var url = "user/define/detail.htm?code=" + node.code;
								$("#m_iframe").attr('src', url);
							}
						} else {
							var url = "user/define/addindex.htm?code=0&group=" + result.treeCode;
							$("#m_iframe").attr('src', url);
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
	}
};