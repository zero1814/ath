/**
 * 系统模块-菜单组管理相关js操作
 */
/**
 * 列表显示字段
 */
var dataUrl = "system/menugroup/data.htm";
var columns = [ {
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
} ];
var params = {
	pageIndex : 0,
	pageSize : 10
};
var MenuGroup = {
	data : function() {
		var $table = $("#table");
		var $tool = $("#tools");
		Table.init($table, $tool, dataUrl, params, columns);
	}
};