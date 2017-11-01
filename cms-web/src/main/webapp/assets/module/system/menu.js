/**
 * 菜单相关函数
 */
var Menu = {
	init : function() {
		Menu.data();
	},
	columns : [ {
		title : "全选",
		field : "select",
		checkbox : true,
		width : 20,// 宽度
		align : "center",// 水平
		valign : "middle"// 垂直
	}, {
		title : "编码",
		field : "code",
		align : "center",// 水平
		valign : "middle"// 垂直
	}, {
		title : "名称",
		field : "name",
		sortable : true,// 是否可排序
		order : "desc"// 默认排序方式
	}, {
		title : "所属分组",
		field : "groupName",
		align : "center",// 水平
		valign : "middle",// 垂直
		sortable : true,// 是否可排序
		order : "desc"// 默认排序方式
	}, {
		title : "创建人",
		field : "createUser",
		align : "center",// 水平
		valign : "middle",// 垂直
		sortable : true,// 是否可排序
		order : "desc"// 默认排序方式
	}, {
		title : "创建时间",
		field : "createTime",
		align : "center",// 水平
		valign : "middle",// 垂直
		sortable : true,// 是否可排序
		order : "desc"// 默认排序方式
	}, {
		title : "修改人",
		field : "updateUser",
		align : "center",// 水平
		valign : "middle",// 垂直
		sortable : true,// 是否可排序
		order : "desc"// 默认排序方式
	}, {
		title : "修改时间",
		field : "updateTime",
		align : "center",// 水平
		valign : "middle",// 垂直
		sortable : true,// 是否可排序
		order : "desc"// 默认排序方式
	}, {
		title : "操作",
		field : "operation",
		align : "center",// 水平
		valign : "middle",// 垂直
		formatter : 'Menu.operation',// 对本列数据做格式化
	} ],
	data : function() {
		Table.init("table", "data/json/system/user/user.json", Menu.columns,
				Menu.searchParam());
	},
	searchParam : function() {
		var temp = {
			name : $("#name").val()
		};
		return temp;
	},
	search : function() {
		Table.param = Role.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	add : function() {
	},
	edit : function() {
	},
	del : function() {
	},
	sel : function() {
	},
	operation : function(value, row, index) {
		var html ="<a>修改</a>";
		html+="<a>删除</a>";
		return "";
	}
};