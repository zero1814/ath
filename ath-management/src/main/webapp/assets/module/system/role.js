/**
 * 系统模块-菜单组管理相关js操作
 */
/**
 * 列表显示字段
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
	field : 'flagAble',
	title : '是否可用',
	formatter : replaceRolePermissionFlagAble
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
	field : 'rolePermission',
	title : '权限',
	formatter : openRolePermission
}, {
	field : 'editRole',
	title : '编辑',
	formatter : openEdit
}, {
	field : 'delRole',
	title : '删除',
	formatter : openDelLayer
} ];
var Role = {
	addLayer : '',
	editLayer : '',
	data : function() {
		$("#table").bootstrapTable({
			url : "system/role/data.htm", // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			dataType : "json",
			toolbar : $("#tools").attr("id"), // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : true, // 是否启用排序
			sortOrder : "desc", // 排序方式
			queryParams : Role.initDataParam,// 传递参数（*）
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
		var tmp = UsePublic.formToJSON($("#searchFrm"));
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
	search : function() {
		$('#table').bootstrapTable('refresh');
	},
	/**
	 * 打开添加页面弹出层
	 */
	openAdd : function() {
		Role.addLayer = layer.open({
			// 基本层类型
			// 0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
			type : 1,
			// 标题
			title : "添加角色",
			// 关闭按钮
			closeBtn : 1,
			// 宽高
			area : [ '600px', '400px' ],
			// 样式类名
			skin : 'layui-layer-lan',
			// 是否点击遮罩关闭
			shadeClose : false,
			// 内容
			content : $('#addRole')
		});
	},
	closeAdd : function() {
		if (Role.addLayer) {
			layer.close(Role.addLayer);
		}
	},
	add : function() {
		var param = {
			name : $("#addName").val(),
			flagAble : $("#addFlagAble").val(),
			intro : $("#addIntro").val()
		};
		layer.close(Role.addLayer);
		$.ajax({
			url : "system/role/add.htm",
			type : "POST",
			data : param,
			success : function(result) {
				result = JSON.parse(result);
				if (result.code == 0) {
					layer.alert('添加成功', function(index) {
						layer.close(index);
						layer.confirm('您是否要为角色添加权限？', {
							btn : [ '确定', '取消' ]
						// 按钮
						}, function() {
							window.open("system/role/permission/index.htm",
									"_self");
						});
					}, function() {
						layer.close(index);
						$('#table').bootstrapTable('refresh');
					});
				} else {
					layer.alert(result.message);
				}
			},
			error : function(result) {
				layer.alert('添加失败');
			}
		});
	},
	/**
	 * 打开添加页面弹出层
	 */
	openEdit : function(codeVal) {
		$("#editCode").val(codeVal);
		$.ajax({
			url : "system/role/detail.htm",
			type : "POST",
			data : {
				code : codeVal
			},
			success : function(result) {
				result = JSON.parse(result);
				if(result.code == 0){
					var obj = result.entity;
					$("#editName").val(obj.name);
					$("#editFlagAble").val(obj.flagAble);
					$("#editIntro").val(obj.intro);
					Role.editLayer = layer.open({
						// 基本层类型
						// 0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）
						type : 1,
						// 标题
						title : "编辑角色",
						// 关闭按钮
						closeBtn : 1,
						// 宽高
						area : [ '600px', '400px' ],
						// 样式类名
						skin : 'layui-layer-lan',
						// 是否点击遮罩关闭
						shadeClose : false,
						// 内容
						content : $('#editRole')
					});
				}else{
					layer.alert(result.code+":"+result.message);
				}
			},
			error : function(result) {
				layer.alert('编辑失败');
			}
		});
	},
	closeEdit : function() {
		if (Role.editLayer) {
			layer.close(Role.editLayer);
		}
	},
	edit : function() {
		layer.confirm('您确定要编辑选中角色吗？', {
			btn : [ '确定', '取消' ]
		// 按钮
		}, function() {
			var param = {
				code : $("#editCode").val(),
				name : $("#editName").val(),
				flagAble : $("#editFlagAble").val(),
				intro : $("#editIntro").val()
			};
			layer.close(Role.editLayer);
			$.ajax({
				url : "system/role/edit.htm",
				type : "POST",
				data : param,
				success : function(result) {
					result = JSON.parse(result);
					if (result.code == 0) {
						layer.alert('编辑成功', function(index) {
							layer.close(index);
							$('#table').bootstrapTable('refresh');
						});
					} else {
						layer.alert(result.message);
					}
				},
				error : function(result) {
					layer.alert('编辑失败');
				}
			});
		});
	},
	del : function(codeVal) {
		layer.confirm('您确定要删除选中角色吗？', {
			btn : [ '确定', '取消' ]
		// 按钮
		}, function() {
			var param = {
				code : codeVal
			}
			$.ajax({
				url : "system/role/del.htm",
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
	},
	selParentRoles : function() {
		var param = {
			groupCode : $("#groupCode").val()
		};
		var parentCode = $("#parentCode_tmp").val();
		$.ajax({
			url : "system/role/getparentRoles.htm",
			type : "POST",
			data : param,
			success : function(result) {
				result = JSON.parse(result);
				if (result.code == 0) {
					var html = "<option value=''>请选择</option>";
					var data = result.data;
					if (data.length > 0) {
						for (var i = 0; i < data.length; i++) {
							var parentRole = data[i];
							html += "<option value='" + parentRole.code + "'";
							if (parentCode == parentRole.code) {
								html += " selected='selected' ";
							}
							html += " >" + parentRole.name + "</option>";
						}
					}
					$("#parentCode").html(html);
				} else {
					layer.alert(result.message);
				}
			},
			error : function(result) {
				layer.alert('删除失败');
			}
		});
	}
};
function openRolePermission(value, row, index) {
	var html = "";
	if (row.flagAble == 0) {
		var code = row.code;
		var url = "system/role/permission/index.htm?RoleCode=" + code;
		html = '<a href="' + url + '" class="btn btn-info">设置</a>';
	}
	return html;
}
/**
 * 替换菜单是否可用文本
 * 
 * @param value
 * @param row
 * @param index
 * @returns
 */
function replaceRolePermissionFlagAble(value, row, index) {
	if (value == 0) {
		return "可用";
	} else {
		return "不可用";
	}
}
/**
 * 打开编辑页面
 * 
 * @param codeVal
 */
function openEdit(value, row, index) {
	var html ="<a href='javascript:void(0)' ";
	html += "class='btn btn-info'  onclick='Role.openEdit(\""+row.code+"\");' >";
	html +="编辑</a>";
	return html;
}
/**
 * 打开删除操作layer
 * 
 * @param value
 * @param row
 * @param index
 * @returns {String}
 */
function openDelLayer(value, row, index) {
	var codeVal = row.code;
	var html = "<a href='javascript:void(0)' onclick='Role.del(\"" + codeVal
			+ "\")' class='btn btn-info'>删除</a>";
	return html;
}