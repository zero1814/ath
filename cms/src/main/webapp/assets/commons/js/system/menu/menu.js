var Menu = {
	Layer: '',
	data: function() {
		columns = [{
			checkbox: true
		}, {
			field: 'code',
			title: '编码'
		}, {
			field: 'name',
			title: '名称'
		}, {
			field: 'parentName',
			title: '父级菜单'
		}, {
			field: 'groupName',
			title: '菜单组'
		}, {
			field: 'flagAble',
			title: '是否可用',
			formatter: initFlagAble
		}, {
			field: 'createUser',
			title: '创建人'
		}, {
			field: 'createTime',
			title: '创建时间'
		}, {
			field: 'permisson',
			title: '权限',
			formatter:settingPermission
		},{
			field: 'operate',
			title: '操作',
			formatter: initOperate
		}]
		Table.init("table", "system/menu/data.htm", columns, Menu.searchParam());
	},
	searchParam: function() {
		var temp = { name: $("#name").val() };
		return temp;
	},
	search: function() {
		Table.param = Menu.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	openLayer: function(titleVal, layerDivId) {
		Menu.Layer = layer.open({
			type: 1,
			title: titleVal,
			skin: 'layui-layer-lan', //加上边框
			area: ['450px', '180px'], //宽高
			content: $("#" + layerDivId)
		});
	},
	closeLayer: function() {
		if(Menu.Layer) {
			layer.close(Menu.Layer);
		}
	},
	openEdit: function(val) {
		layer.confirm('您确定要修改此条数据吗？', {
			btn: ['确定', '取消'] //按钮
		}, function(index) {
			layer.close(index);
			Menu.openLayer('编辑', 'editDiv');
		}, function(index) {
			layer.close(index);
		});
	},
	add: function() {

	},
	edit: function() {

	},
	del: function(val) {
		layer.confirm('您确定要删除此条数据吗？', {
			btn: ['确定', '取消'] //按钮
		}, function(index) {
			layer.close(index);
			layer.alert("删除成功!", function(index) {
				layer.close(index);
			})
		}, function(index) {
			layer.close(index);
		});
	}
};

/**
 * 初始化操作类
 * @param {Object} value
 * @param {Object} row
 * @param {Object} index
 */
function initOperate(value, row, index) {
	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='Menu.openEdit()'>编辑</a>";
	html += "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='Menu.del(\"" + value + "\")'>删除</a>";
	return html;
}

/**
 * 初始化是否可用列
 * @param {Object} value
 * @param {Object} row
 * @param {Object} index
 */
function initFlagAble(value, row, index) {
	var html = '';
	if(value == 0) {
		html = '可用';
	} else {
		html = '不可用';
	}
	return html;
}
/**
 * 初始化权限配置列表
 * @param {Object} value
 * @param {Object} row
 * @param {Object} index
 */
function settingPermission(value, row, index){
	var html ="<a class='btn btn-info btn-sm' href='javascript:void(0)'>设置</a>";
	return html;
}
