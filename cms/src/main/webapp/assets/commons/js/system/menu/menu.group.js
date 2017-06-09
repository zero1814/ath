var MenuGroup = {
	Layer: '',
	data: function() {
		columns = [{
			checkbox: true
		}, {
			field: 'code',
			title: '编码'
		}, {
			field: 'name',
			title: '名称'
		}, {
			field: 'createUser',
			title: '创建人'
		}, {
			field: 'createTime',
			title: '创建时间'
		},{
			filed:'menu',
			title:'菜单维护',
			formatter: menuHref
		}, {
			field: 'operate',
			title: '操作',
			formatter: initOperate
		}]
		Table.init("table", "system/menu/group/data.htm", columns, MenuGroup.searchParam());
	},
	searchParam: function() {
		var temp = { name: $("#name").val() };
		return temp;
	},
	search: function() {
		Table.param = MenuGroup.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	openLayer: function(titleVal, layerDivId) {
		MenuGroup.Layer = layer.open({
			type: 1,
			title: titleVal,
			skin: 'layui-layer-lan', //加上边框
			area: ['450px', '180px'], //宽高
			content: $("#" + layerDivId)
		});
	},
	closeLayer: function() {
		if(MenuGroup.Layer) {
			layer.close(MenuGroup.Layer);
		}
	},
	openEdit: function(val) {
		layer.confirm('您确定要修改此条数据吗？', {
			btn: ['确定', '取消'] //按钮
		}, function(index) {
			layer.close(index);
			MenuGroup.openLayer('编辑', 'editDiv');
		}, function(index) {
			layer.close(index);
		});
	},
	add: function() {
		var param = $("#addFrm").serializeArray();
		$.ajax({
			url: 'system/menu/group/add.htm',
			type: "POST",
			data: param,
			dataType : "json",
			success: function(result) {
				if(result.code == 0) {
					layer.alert('添加成功', function(index) {
						layer.close(MenuGroup.Layer);
						$("#table").bootstrapTable('refresh');
					});
				} else {
					layer.alert(result.message, function(index) {
						layer.close(MenuGroup.Layer);
						$("#table").bootstrapTable('refresh');
					});
				}
			},
			error: function(result) {
				layer.alert('添加失败，失败原因:' + JSON.stringify(result));
			}
		});
	},
	edit: function() {
		var param = $("#editFrm").serializeArray();
		layer.confirm('您确认要编辑选中的菜单吗？', {
			btn: ['确认', '取消']
			// 按钮
		}, function() {
			var param = $("#editFrm").serializeArray();
			$.ajax({
				url: "system/menu/group/edit.htm",
				type: "POST",
				data: param,
				dataType : "json",
				success: function(result) {
					if(result.code == 0) {
						layer.alert('编辑成功', function() {
							layer.close(MenuGroup.Layer);
							$("#table").bootstrapTable('refresh');
						});
					} else {
						layer.alert(result.message, function(index) {
							layer.close(MenuGroup.Layer);
							$("#table").bootstrapTable('refresh');
						});
					}
				},
				error: function(result) {
					layer.alert('编辑失败，失败原因:' + JSON.stringify(result),function(index){
						layer.close(MenuGroup.Layer);
						window.parent.location.href="system/menu/index.htm?groupCode="+group;
					});
				}
			});
		});
	},
	del: function(val) {
		layer.confirm('您确认要删除选中的页面吗？', {
			btn: ['确认', '取消']
			// 按钮
		}, function() {
			$.ajax({
				url: "system/menu/group/del.htm",
				type: "POST",
				data: {"code":val},
				dataType : "json",
				success: function(result) {
					if(result.code == 0) {
						layer.alert('删除成功', function(index) {
							layer.close(index);
							$("#table").bootstrapTable('refresh');
						});
					} else {
						layer.alert(result.message, function(index) {
							layer.close(index);
							$("#table").bootstrapTable('refresh');
						});
					}
				},
				error: function(result) {
					layer.alert('删除失败，失败原因:' + JSON.stringify(result),function(index){
						layer.close(index);
						$("#table").bootstrapTable('refresh');
					});
				}
			});
		});
	}
};
function menuHref(value, row, index) {
	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='system/menu/index.htm?groupCode="+row.code+"'>维护</a>";
	return html;
}
function initOperate(value, row, index) {
	var code = row.code;
	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='MenuGroup.openEdit()'>编辑</a>";
	html += "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='MenuGroup.del(\"" + code + "\")'>删除</a>";
	return html;
}