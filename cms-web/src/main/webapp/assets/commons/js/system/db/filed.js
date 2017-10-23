/**
 * 数据库维护相关js
 */
var DataBase = {
	data: function() {
		columns = [{
			checkbox: true
		}, {
			field: 'dbCode',
			title: '编码'
		}, {
			field: 'dbName',
			title: '名称'
		}, , {
			field: 'driver',
			title: '驱动'
		}, {
			field: 'url',
			title: '链接地址'
		}, {
			field: 'remark',
			title: '备注'
		}, {
			field: 'createUser',
			title: '创建人'
		}, {
			field: 'createTime',
			title: '创建时间'
		}, {
			filed: 'menu',
			title: '菜单维护',
			formatter: menuHref
		}, {
			field: 'operate',
			title: '操作',
			formatter: initOperate
		}]
		Table.init("table", "system/db/database/data.htm", columns, DataBase.searchParam());
	},
	searchParam: function() {
		var temp = {
			dbCode: $("#dbCode").val(),
			dbName: $("#dbName").val()
		};
		return temp;
	},
	search: function() {
		Table.param = DataBase.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	del: function(val) {
		layer.confirm('您确认要删除选中的页面吗？', {
			btn: ['确认', '取消']
			// 按钮
		}, function() {
			$.ajax({
				url: "system/db/database/del.htm",
				type: "POST",
				data: {
					"dbCode": val
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
					layer.alert('删除失败，失败原因:' + JSON.stringify(result), function(index) {
						layer.close(index);
						$("#table").bootstrapTable('refresh');
					});
				}
			});
		});
	}
};