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
	field : 'menuName',
	title : '菜单名称'
}, {
	field : 'menuPermission',
	title : '权限名称',
	formatter : replaceRolePermissionPermissionFlagAble
}, {
	field : 'menuPermissionSetting',
	title : '权限设置'
} ];
var RolePermission = {
	data : function() {
		$("#table").bootstrapTable({
			url : "system/role/permission/data.htm", // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			dataType : "json",
			toolbar : $("#tools").attr("id"), // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : true, // 是否启用排序
			sortOrder : "desc", // 排序方式
			queryParams : RolePermission.initDataParam,// 传递参数（*）
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
	}
};