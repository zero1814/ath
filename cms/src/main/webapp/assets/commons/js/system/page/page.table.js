/**
 * 页面显示列表相关函数
 */
var PageTable = {
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
			field: 'page.name',
			title: '页面名称'
		}, {
			field: 'createUser',
			title: '创建人'
		}, {
			field: 'createTime',
			title: '创建时间'
		},{
			field: 'updateUser',
			title: '最后修改人'			
		},{
			field: 'updateTime',
			title: '最后时间'
		},{
			field: 'settingColumn',
			title: '显示字段',
			formatter: settingColumn			
		},{
			field: 'operate',
			title: '操作',
			formatter: initOperate
		}]
		Table.init("table", "system/page/table/data.htm", columns, PageTable
			.searchParam());
	},
	searchParam: function() {
		var temp = {
			name: $("#name").val(),
			tableCode:$("#tableCode").val()
		};
		return temp;
	},
	search: function() {
		Table.param = PageTable.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	openLayer: function(titleVal, url) {
		PageTable.Layer = layer.open({
			type: 2,
			title: titleVal,
			skin: 'layui-layer-lan', // 加上边框
			area: ['480px', '380px'], // 宽高
			content: [url, 'no']
		});
	},
	closeLayer: function() {
		if(parent.PageTable.Layer) {
			parent.layer.close(parent.PageTable.Layer);
		}
	},
	openAdd: function() {
		PageTable.openLayer("添加", "system/page/table/addindex.htm");
	},
	openEdit: function(val) {
		layer.confirm('您确定要修改此条数据吗？', {
			btn: ['确定', '取消']
			// 按钮
		}, function(index) {
			layer.close(index);
			PageTable.openLayer("编辑", "system/page/table/editindex.htm?code=" +
				val);
		}, function(index) {
			layer.close(index);
		});
	},
	add: function() {
		var param = $("#addFrm").serializeArray();
		$.ajax({
			url: 'system/page/table/add.htm',
			type: "POST",
			data: param,
			dataType: "json",
			success: function(result) {
				if(result.code == 0) {
					layer.alert('添加成功', function(index) {
						parent.$("#table").bootstrapTable('refresh');
						parent.layer.close(parent.PageTable.Layer);
					});
				} else {
					layer.alert(result.message, function(index) {
						parent.$("#table").bootstrapTable('refresh');
						parent.layer.close(PageTable.Layer);
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
		layer
			.confirm(
				'您确认要编辑选中的菜单吗？', {
					btn: ['确认', '取消']
					// 按钮
				},
				function() {
					var param = $("#editFrm").serializeArray();
					$.ajax({
							url: "system/page/table/edit.htm",
							type: "POST",
							data: param,
							dataType: "json",
							success: function(result) {
								if(result.code == 0) {
									layer.alert('编辑成功',function(index) {
										parent.$("#table").bootstrapTable('refresh');
										parent.layer.close(parent.PageTable.Layer);
									});
								} else {
									layer.alert(result.message,function(index) {
										parent.$("#table").bootstrapTable('refresh');
										parent.layer.close(parent.PageTable.Layer);
									});
								}
							},
							error: function(result) {
								layer.alert('编辑失败，失败原因:' +JSON.stringify(result),function(index) {
									parent.layer.close(parent.PageTable.Layer);
									window.parent.location.href = "system/menu/index.htm?groupCode=" +group;
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
				url: "system/page/table/del.htm",
				type: "POST",
				data: {
					"code": val
				},
				dataType: "json",
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
					layer.alert('删除失败，失败原因:' + JSON.stringify(result),
						function(index) {
							layer.close(index);
							$("#table").bootstrapTable('refresh');
						});
				}
			});
		});
	}
};
function settingColumn(value, row, index){
	var code = row.code;
	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='system/page/table/column/index.htm?tableCode="+code+"'>设置</a>";
	return html;
}
function initOperate(value, row, index) {
	var code = row.code;
	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='PageTable.openEdit(\""+code+"\")'>编辑</a>";
	html += "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='PageTable.del(\"" + code + "\")'>删除</a>";
	return html;
}