var MenuGroup = {
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
			field: 'createUser',
			title: '创建人'
		}, {
			field: 'createTime',
			title: '创建时间'
		},{
			filed:'menu',
			title:'菜单维护',
			formatter: menuHref
		}, {
			field: 'operate',
			title: '操作',
			formatter: initOperate
		}]
		Table.init("table", "system/menu/group/data.htm", columns, MenuGroup.searchParam());
	},
	searchParam: function() {
		var temp = { name: $("#name").val() };
		return temp;
	},
	search: function() {
		Table.param = MenuGroup.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	openLayer: function(titleVal, layerDivId) {
		MenuGroup.Layer = layer.open({
			type: 1,
			title: titleVal,
			skin: 'layui-layer-lan', //加上边框
			area: ['450px', '180px'], //宽高
			content: $("#" + layerDivId)
		});
	},
	closeLayer: function() {
		if(MenuGroup.Layer) {
			layer.close(MenuGroup.Layer);
		}
	},
	openEdit: function(val) {
		layer.confirm('您确定要修改此条数据吗？', {
			btn: ['确定', '取消'] //按钮
		}, function(index) {
			layer.close(index);
			MenuGroup.openLayer('编辑', 'editDiv');
		}, function(index) {
			layer.close(index);
		});
	},
	add: function() {
		var url = '';
		var param = {};
		var type = 'div';
		UsePublic.add(url, param, type);
	},
	edit: function() {
		var url = '';
		var param = {};
		var type = 'div';
		UsePublic.edit(url, param, 'div');
	},
	del: function(val) {
		var url = '';
		var param = {};
		var type = 'div';
		UsePublic.del(url, param, type);
	}
};
function menuHref(value, row, index) {
	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='system/menu/index.htm?groupCode="+row.code+"'>维护</a>";
	return html;
}
function initOperate(value, row, index) {
	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='MenuGroup.openEdit()'>编辑</a>";
	html += "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='MenuGroup.del(\"" + value + "\")'>删除</a>";
	return html;
}