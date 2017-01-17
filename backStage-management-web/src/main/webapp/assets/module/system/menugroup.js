/**
 * 系统模块-菜单组管理相关js操作
 */
/**
 * 列表显示字段
 */
var dataUrl = "system/menugroup/data.htm";
var columns = [ {
	field : 'code',
	title : '编码'
}, {
	field : 'name',
	title : '名称'
}, {
	field : 'create_user',
	title : '创建人'
}, {
	field : 'create_time',
	title : '创建时间'
}, {
	field : 'update_user',
	title : '修改人'
}, {
	field : 'update_time',
	title : '修改时间'
} ];
var params = {};
var MenuGroup = {
	data : function(table) {
		var $table = $("#table");
		var $tool = $("#tools");
		Table.init($table, $tool, dataUrl, params, columns);
	}
};