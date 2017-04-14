var User = {
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
			field: 'operate',
			title: '操作',
			formatter: initOperate
		}]
		Table.init("table", "data/json/system/user/user.json", columns, User.searchParam());
	},
	searchParam: function() {
		var temp = { name: $("#name").val() };
		return temp;
	},
	search: function() {
		Table.param = User.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	openLayer: function(titleVal, layerDivId) {
		User.Layer = layer.open({
			type: 1,
			title: titleVal,
			skin: 'layui-layer-lan', //加上边框
			area: ['450px', '180px'], //宽高
			content: $("#" + layerDivId)
		});
	},
	closeLayer: function() {
		if(User.Layer) {
			layer.close(User.Layer);
		}
	},
	openEdit: function(val) {
		layer.confirm('您确定要修改此条数据吗？', {
			btn: ['确定', '取消'] //按钮
		}, function(index) {
			layer.close(index);
			User.openLayer('编辑', 'editDiv');
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

function initOperate(value, row, index) {

	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='User.openEdit()'>编辑</a>";
	html += "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='User.del(\"" + value + "\")'>删除</a>";
	return html;
}

function initFlagAble(value, row, index) {
	var html = '';
	if(value == 0) {
		html = '可用';
	} else {
		html = '不可用';
	}
	return html;
}