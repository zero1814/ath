/**
 * 系统相关-菜单相关-菜单管理
 */
var columnsArray = [ {
	checkbox : true
}, {
	field : 'code',
	title : '编码'
}, {
	field : 'name',
	title : '名称'
}, {
	field : 'createUser',
	title : '创建人'
}, {
	field : 'createTime',
	title : '创建时间'
}, {
	field : 'updateUser',
	title : '修改人'
}, {
	field : 'updateTime',
	title : '修改时间'
}, {
	field : 'operation',
	title : '操作',
	formatter : operation
} ];
var MenuGroup = {
	Layer : "",
	/**
	 * 加载表数据
	 */
	data : function() {
		$("#table").bootstrapTable({
			url : "system/menugroup/data.htm", // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			dataType : "json",
			toolbar : "toolbar", // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : true, // 是否启用排序
			sortOrder : "desc", // 排序方式
			queryParams : MenuGroup.initDataParam, // 传递参数（*）
			queryParamsType : "limit",
			sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 10, // 每页的记录行数（*）
			pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
			search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : false,
			showColumns : true, // 是否显示所有的列
			showRefresh : true, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			height : 800, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "code", // 每一行的唯一标识，一般为主键列
			showToggle : false, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
			columns : columnsArray
		});
	},
	initDataParam : function(params) {
		var tmp = $("#searchFrm").serializeArray();
		if (tmp) {
			tmp.pageNumber = params.pageNumber;
			tmp.pageSize = params.limit;
		} else {
			tmp = {
				pageNumber : params.pageNumber,
				pageSize : params.limit
			};
		}
		return tmp;
	},
	openLayer : function(obj) {
		MenuGroup.Layer = layer.open({
			// 基本层类型
			// 0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
			type : 1,
			// 标题
			title : "添加菜单权限",
			// 关闭按钮
			closeBtn : 1,
			// 宽高
			area : [ '500px', '300px' ],
			// 样式类名
			skin : 'layui-layer-lan',
			// 是否点击遮罩关闭
			shadeClose : false,
			// 内容
			content : $(obj)
		});
	},
	closeLayer : function() {
		if (MenuGroup.Layer) {
			layer.close(MenuGroup.Layer);
		}
	},
	add : function() {
		var param = {
			name : $("#addName").val()
		}
		$.ajax({
			url : "system/menugroup/add.htm",
			type : "POST",
			data : param,
			success : function(result) {
				result = JSON.parse(result);
				if (result.code == 0) {
					layer.close(MenuGroup.addLayer);
					layer.alert('添加成功', function(index) {
						layer.close(index);
						$('#table').bootstrapTable('refresh');
					});
				}
			},
			error : function(result) {
				layer.alert('添加失败');
			}
		});
	},
	openEdit:function(code,name,flagAble){
		$("#editCode").val(code);
		$("#editName").val(name);
		$("#editFlagAble").val();
		MenuGroup.openLayer($('#editLayer'));
	},
	edit : function() {
		layer.confirm('您确定要编辑选中菜单组吗？', {
			btn : [ '确定', '取消' ]
		// 按钮
		}, function() {
			var param = {
				code : $("#editCode").val(),
				name : $("#editName").val()
			};
			$.ajax({
				url : "system/menugroup/edit.htm",
				type : "POST",
				data : param,
				success : function(result) {
					result = JSON.parse(result);
					if (result.code == 0) {
						layer.close(MenuGroup.Layer);
						layer.alert('编辑成功', function(index) {
							layer.close(index);
							$('#table').bootstrapTable('refresh');
						});
					}
				},
				error : function(result) {
					layer.alert('编辑失败');
				}
			});
		}, function() {
			layer.close(MenuGroup.editLayer);
		});
	},
	del : function(codeVal) {
		layer.confirm('您确定要删除选中菜单组吗？', {
			btn : [ '确定', '取消' ]
		// 按钮
		}, function() {
			var param = {
				code : codeVal
			}
			$.ajax({
				url : "system/menugroup/del.htm",
				type : "POST",
				data : param,
				success : function(result) {
					result = JSON.parse(result);
					if (result.code == 0) {
						layer.alert('删除成功', function(index) {
							layer.close(index);
							$('#table').bootstrapTable('refresh');
						});
					}
				},
				error : function(result) {
					layer.alert('删除失败');
				}
			});
		});
	}
};

/**
 * 操作相关跳转或脚本
 * 
 * @param {Object}
 *            value
 * @param {Object}
 *            row
 * @param {Object}
 *            index
 */
function operation(value, row, index) {
	var code = row.code;
	var name = row.name;
	var flagAble = row.flagAble;
	var html = '<div style="text-align: center;">';
	html += '<a onclick="MenuGroup.openEdit(\''+code+'\',\''+name+'\','+flagAble+');" style="margin: 5px;" class="btn btn-info btn-sm"><i class="fa fa-pencil"></i> 编辑 </a> ';
	html += '<a onclick="MenuGroup.del(\''+code+'\');" style="margin: 5px;" class="btn btn-info btn-sm"><i class="fa fa-trash-o"></i> 删除 </a> ';
	html += '</div>';
	return html;
}