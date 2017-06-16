/**
 * 页面显示列表相关函数
 */
var PageTableColumn = {
	Layer: '',
	data: function() {
		columns = [{
			checkbox: true
		}, {
			field: 'code',
			title: '编码'
		}, {
			field: 'field',
			title: '字段名称'
		}, {
			field: 'title',
			title: '标题'
		},{
			field: 'formatter',
			title: '函数'
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
			field: 'operate',
			title: '操作',
			formatter: initOperate
		}]
		Table.init("table", "system/page/table/column/data.htm", columns, PageTableColumn.searchParam());
	},
	searchParam: function() {
		var temp = {
			name: $("#name").val(),
			tableCode:$("#tableCode").val()
		};
		return temp;
	},
	search: function() {
		Table.param = PageTableColumn.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	openLayer: function(titleVal, url) {
		PageTableColumn.Layer = layer.open({
			type: 2,
			title: titleVal,
			skin: 'layui-layer-lan', // 加上边框
			area: ['480px', '380px'], // 宽高
			content: [url, 'no']
		});
	},
	closeLayer: function() {
		if(parent.PageTableColumn.Layer) {
			parent.layer.close(parent.PageTableColumn.Layer);
		}
	},
	openAdd: function() {
		PageTableColumn.openLayer("添加", "system/page/table/column/addindex.htm?tableCode="+$("#tableCode").val());
	},
	openEdit: function(val) {
		layer.confirm('您确定要修改此条数据吗？', {
			btn: ['确定', '取消']
			// 按钮
		}, function(index) {
			layer.close(index);
			PageTableColumn.openLayer("编辑", "system/page/table/column/editindex.htm?code="+val);
		}, function(index) {
			layer.close(index);
		});
	},
	add: function() {
		var param = $("#addFrm").serializeArray();
		$.ajax({
			url: 'system/page/table/column/add.htm',
			type: "POST",
			data: param,
			dataType: "json",
			success: function(result) {
				if(result.code == 0) {
					layer.alert('添加成功', function(index) {
						layer.close(index);
						parent.$("#table").bootstrapTable('refresh');
						parent.layer.close(parent.PageTableColumn.Layer);
					});
				} else {
					parent.layer.alert(result.message, function(index) {
						parent.layer.close(index);
						parent.$("#table").bootstrapTable('refresh');
						parent.layer.close(PageTableColumn.Layer);
					});
				}
			},
			error: function(result) {
				parent.layer.alert('添加失败，失败原因:' + JSON.stringify(result));
			}
		});
	},
	edit: function() {
		var param = $("#editFrm").serializeArray();
		layer.confirm(
				'您确认要编辑选中的菜单吗？', {
					btn: ['确认', '取消']
					// 按钮
				},
				function() {
					var param = $("#editFrm").serializeArray();
					$.ajax({
							url: "system/page/table/column/edit.htm",
							type: "POST",
							data: param,
							dataType: "json",
							success: function(result) {
								if(result.code == 0) {
									layer.alert('编辑成功',function(index) {
										layer.close(index);
										parent.$("#table").bootstrapTable('refresh');
										parent.layer.close(parent.PageTableColumn.Layer);
									});
								} else {
									layer.alert(result.message,function(index) {
										parent.layer.close(index);
										parent.$("#table").bootstrapTable('refresh');
										parent.layer.close(parent.PageTableColumn.Layer);
									});
								}
							},
							error: function(result) {
								layer.alert('编辑失败，失败原因:' +JSON.stringify(result),function(index) {
									parent.layer.close(index);
									parent.layer.close(parent.PageTableColumn.Layer);
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
				url: "system/page/table/column/del.htm",
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
							parent.layer.close(index);
							$("#table").bootstrapTable('refresh');
						});
					}
				},
				error: function(result) {
					layer.alert('删除失败，失败原因:' + JSON.stringify(result),
						function(index) {
							parent.layer.close(index);
							$("#table").bootstrapTable('refresh');
						});
				}
			});
		});
	}
};
function initOperate(value, row, index) {
	var code = row.code;
	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='PageTableColumn.openEdit(\""+code+"\")'>编辑</a>";
	html += "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='PageTableColumn.del(\"" + code + "\")'>删除</a>";
	return html;
}