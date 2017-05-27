var MenuPermission = {
	Layer: '',
	openLayer: function(titleVal, layerDivId) {
		MenuPermission.Layer = layer.open({
			type: 1,
			title: titleVal,
			skin: 'layui-layer-lan', //加上边框
			area: ['450px', '260px'], //宽高
			content: $("#" + layerDivId)
		});
	},
	closeLayer: function(menuCode) {
		if(parent.Menu.Layer) {
			layer.close(parent.Menu.Layer);
			parent.window.location.href="system/menu/detail.htm?code="+menuCode;
		}
	},
	openEdit: function(val) {
		layer.confirm('您确认要编辑选中的菜单吗', {
			btn: ['确定', '取消'] //按钮
		}, function(index) {
			layer.close(index);
			MenuPermission.openLayer('编辑', 'editDiv');
		}, function(index) {
			layer.close(index);
		});
	},
	add: function(menuCode) {
		var param = $("#addPermissionFrm").serializeArray();
		$.ajax({
			url: "system/menu/permission/add.htm",
			type: "POST",
			data: param,
			dataType : "json",
			success: function(result) {
				if(result.code == 0) {
					layer.alert('添加成功', function(index) {
						layer.close(parent.Menu.Layer);
						parent.window.location.href="system/menu/detail.htm?code="+menuCode;
					});
				} else {
					layer.alert(result.message, function() {
						layer.close(parent.Menu.Layer);
						parent.window.location.href="system/menu/detail.htm?code="+menuCode;
					});
				}
			},
			error: function(result) {
				layer.alert('添加失败，失败原因:' + JSON.stringify(result),function(index){
					layer.close(parent.Menu.Layer);
					window.location.href="system/menu/detail.htm?code="+menuCode;
				});
			}
		});
	},
	edit: function(menuCode) {
		var param = $("#editPermissionFrm").serializeArray();
		$.ajax({
			url: "system/menu/permission/edit.htm",
			type: "POST",
			data: param,
			dataType : "json",
			success: function(result) {
				if(result.code == 0) {
					layer.alert("编辑成功", function(index) {
						layer.close(parent.Menu.Layer);
						parent.window.location.href="system/menu/detail.htm?code="+menuCode;
					});
				} else {
					layer.alert(result.message, function() {
						layer.close(parent.Menu.Layer);
						parent.window.location.href="system/menu/detail.htm?code="+menuCode;
					});
				}
			},
			error: function(result) {
				layer.alert("编辑失败，失败原因:" + JSON.stringify(result),function(index){
					layer.close(parent.Menu.Layer);
					window.location.href="system/menu/detail.htm?code="+menuCode;
				});
			}
		});
	},
	del: function(val) {
		layer.confirm('您确定要删除此条数据吗？', {
			btn: ['确定', '取消'] //按钮
		}, function(index) {
			layer.close(index);
			layer.alert("删除成功!", function(index) {
				layer.close(index);
			})
		}, function(index) {
			layer.close(index);
		});
	}
};

function initOperate(value, row, index) {
	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='MenuPermission.openEdit()'>编辑</a>";
	html += "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='MenuPermission.del(\"" + value + "\")'>删除</a>";
	return html;
}