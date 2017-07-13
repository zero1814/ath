/**
 * 数据表维护相关js
 */
var DbTable = {
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
		},{
			field : 'field',
			title : '查看字段',
			formatter:function(value, row, index){
				var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='system/db/field/index.htm?tableCode="+row.tableCode+"'>查看</a>";
				return html;
			}
		},{
			field : 'operate',
			title : '操作',
			formatter:function(value, row, index) {
				var code = row.tableCode;
				var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='DbTable.openEdit(\""+code+"\")'>编辑</a>";
				html += "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='DbTable.del(\"" + code + "\")'>删除</a>";
				return html;
			}
		} ];
		Table.init("table", "system/db/table/data.htm", columns, DbTable.searchParam());
	},
	searchParam : function() {
		var temp = {
			dbCode : $("#dbCode").val(),
			tableCode : $("#tableCode").val(),
			tableName : $("#tableName").val()
		};
		return temp;
	},
	search : function() {
		Table.param = DbTable.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	del : function(val) {
		layer.confirm('您确认要删除选中的页面吗？', {
			btn : [ '确认', '取消' ]
		// 按钮
		}, function() {
			$.ajax({
				url : "system/db/table/del.htm",
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
	}
};