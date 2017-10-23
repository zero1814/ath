/**
 * 数据表字段维护相关js
 */
var DbField = {
	data : function() {
		var columns = [ {
			checkbox : true
		}, {
			field : 'tableCode',
			title : '表名称'
		}, {
			field : 'fieldCode',
			title : '编码'
		}, {
			field : 'FieldName',
			title : '名称'
		}, {
			field : 'fieldType',
			title : '字段类型'
		},{
			field : 'fieldLength',
			title : '字段长度'
		},{
			field : 'isNullable',
			title : '是否可以为空',
			formatter:function(value, row, index){
				var html ="可以";
				if(value == 1){
					html="不可以";
				}
				return html;
			}
		},{
			field : 'fieldDefault',
			title : '字段默认值'			
		}, {
			field : 'fieldKey',
			title : '字段索引'			
		},{
			field : 'sortAdd',
			title : '添加排序'
		},{
			field : 'sortEdit',
			title : '编辑排序'
		},{
			field : 'sortChart',
			title : '列表排序'
		},{
			field : 'sortBook',
			title : '查看排序'
		},{
			field : 'sortInquery',
			title : '查询排序'
		},{
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
			field : 'operate',
			title : '操作',
			formatter:function(value, row, index) {
				var code = row.fieldCode;
				var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='DbField.openEdit(\""+code+"\")'>编辑</a>";
				html += "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='DbField.del(\"" + code + "\")'>删除</a>";
				return html;
			}
		}];
		Table.init("table", "system/db/field/data.htm", columns, DbField.searchParam());
	},
	searchParam : function() {
		var temp = {
			tableCode : $("#tableCode").val(),
			FieldCode : $("#FieldCode").val(),
			FieldName : $("#FieldName").val()
		};
		return temp;
	},
	search : function() {
		Table.param = DbField.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	del : function(val) {
		layer.confirm('您确认要删除选中的页面吗？', {
			btn : [ '确认', '取消' ]
		// 按钮
		}, function() {
			$.ajax({
				url : "system/db/field/del.htm",
				type : "POST",
				data : {
					"fieldCode" : val
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
					layer.alert(result.message, function(index) {
						layer.close(index);
						$("#table").bootstrapTable('refresh');
					});
				}
			});
		});
	}
};