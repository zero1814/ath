/**
 * 数据库维护相关js
 */
var DataBase = {
	data : function() {
		var columns = [ {
			checkbox : true
		}, {
			field : 'dbCode',
			title : '编码'
		}, {
			field : 'dbName',
			title : '名称'
		}, {
			field : 'remark',
			title : '描述'
		}, {
			field : 'createUser',
			title : '创建人'
		}, {
			field : 'createTime',
			title : '创建时间'
		}, {
			field : 'updateUser',
			title : '最后修改人'
		}, {
			field : 'updateTime',
			title : '最后修改时间'
		} ,{
			field : 'table',
			title : '查看表',
			formatter:function(value, row, index){
				var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='system/db/table/index.htm?dbCode="+row.dbCode+"'>查看</a>";
				return html;
			}
		},{
			field : 'operate',
			title : '操作',
			formatter:function(value, row, index) {
				var code = row.dbCode;
				var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='DataBase.openEdit(\""+code+"\")'>编辑</a>";
				html += "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='DataBase.del(\"" + code + "\")'>删除</a>";
				return html;
			}
		}];
		Table.init("table", "system/db/database/data.htm", columns, DataBase
				.searchParam());
	},
	searchParam : function() {
		var temp = {
			dbCode : $("#dbCode").val(),
			dbName : $("#dbName").val()
		};
		return temp;
	},
	search : function() {
		Table.param = DataBase.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	del : function(val) {
		layer.confirm('您确认要删除选中的页面吗？', {
			btn : [ '确认', '取消' ]
		// 按钮
		}, function() {
			$.ajax({
				url : "system/db/database/del.htm",
				type : "POST",
				data : {
					"dbCode" : val
				},
				dataType : "json",
				success : function(result) {
					if (result.code == 0) {
						layer.alert(result.message, function(index) {
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
				error : function(result) {
					layer.alert(result.message,
							function(index) {
								layer.close(index);
								$("#table").bootstrapTable('refresh');
							});
				}
			});
		});
	},
	sync : function() {
		$.ajax({
			url : "system/db/database/sync.htm",
			type : "POST",
			data : {},
			dataType : "json",
			success : function(result) {
				if (result.code == 0) {
					layer.alert(result.message, function(index) {
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
			error : function(result) {
				layer.alert(result.message, function(
						index) {
					layer.close(index);
					$("#table").bootstrapTable('refresh');
				});
			}
		});
	}
};