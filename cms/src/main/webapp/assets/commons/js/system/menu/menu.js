var Menu = {
	Layer:'',
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
							if(node.code == "0"){
								var url = "system/menu/addindex.htm?code=0&group="+node.groupCode;
								$("#m_iframe").attr('src', url);
							}else{
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
	},
	openLayer: function(titleVal, layerDivId) {
		Menu.Layer = layer.open({
			type: 1,
			title: titleVal,
			skin: 'layui-layer-lan', //加上边框
			area: ['450px', '220px'], //宽高
			content: $("#" + layerDivId)
		});
	},
	closeLayer: function() {
		if(Menu.Layer) {
			layer.close(Menu.Layer);
		}
	},
	add:function(group){
		var param = $("#addFrm").serializeArray();
		$.ajax({
			url: "system/menu/add.htm",
			type: "POST",
			data: param,
			success: function(result) {
				result = JSON.parse(result);
				if(result.code == 0) {
					layer.confirm('添加成功，是否为菜单设置权限？', {
						// 按钮
						btn: ['是', '否']
					}, function() {
						window.location.href="system/menu/permission.htm?code="+result.entity.code;
					},function(){
						layer.close(Menu.Layer);
						window.parent.location.href="system/menu/index.htm?groupCode="+group;
					});
				} else {
					layer.alert(result.message, function() {
						layer.close(Menu.Layer);
						window.parent.location.href="system/menu/index.htm?groupCode="+group;
					});
				}
			},
			error: function(result) {
				layer.alert('添加失败，失败原因:' + JSON.stringify(result),function(index){
					layer.close(index);
					window.parent.location.href="system/menu/index.htm?groupCode="+group;
				});
			}
		});
	},
	edit:function(code){
		layer.confirm('您确认要编辑选中的菜单吗？', {
			btn: ['确认', '取消']
			// 按钮
		}, function() {
			var param = $("#editFrm").serializeArray();
			$.ajax({
				url: "system/menu/edit.htm",
				type: "POST",
				data: param,
				success: function(result) {
					result = JSON.parse(result);
					if(result.code == 0) {
						layer.alert('编辑成功', function(index) {
							layer.close(index);
							window.parent.location.href="system/menu/index.htm?groupCode="+group;
						});
					} else {
						layer.alert(result.message, function(index) {
							layer.close(index);
							window.parent.location.href="system/menu/index.htm?groupCode="+group;
						});
					}
				},
				error: function(result) {
					layer.alert('编辑失败，失败原因:' + JSON.stringify(result),function(index){
						layer.close(index);
						window.parent.location.href="system/menu/index.htm?groupCode="+group;
					});
				}
			});
		});
	},
	del:function(code,group){
		layer.confirm('您确认要删除选中的菜单吗？', {
			btn: ['确认', '取消']
			// 按钮
		}, function() {
			$.ajax({
				url: "system/menu/del.htm",
				type: "POST",
				data: {"code":code},
				success: function(result) {
					result = JSON.parse(result);
					if(result.code == 0) {
						layer.alert('删除成功', function(index) {
							layer.close(index);
							window.parent.location.href="system/menu/index.htm?groupCode="+group;
						});
					} else {
						layer.alert(result.message, function(index) {
							layer.close(index);
							window.parent.location.href="system/menu/index.htm?groupCode="+group;
						});
					}
				},
				error: function(result) {
					layer.alert('删除失败，失败原因:' + JSON.stringify(result),function(index){
						layer.close(index);
						window.parent.location.href="system/menu/index.htm?groupCode="+group;
					});
				}
			});
		});
	}
}