var MenuPermission = {
	Layer: '',
	openLayer: function(titleVal, layerDivId) {
		MenuPermission.Layer = layer.open({
			type: 1,
			title: titleVal,
			skin: 'layui-layer-lan', //加上边框
			area: ['450px', '260px'], //宽高
			content: $("#" + layerDivId)
		});
	},
	closeLayer: function() {
		if(MenuPermission.Layer) {
			layer.close(MenuPermission.Layer);
		}
	},
	openEdit: function(val) {
		layer.confirm('您确定要修改此条数据吗？', {
			btn: ['确定', '取消'] //按钮
		}, function(index) {
			layer.close(index);
			MenuPermission.openLayer('编辑', 'editDiv');
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
	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='MenuPermission.openEdit()'>编辑</a>";
	html += "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='MenuPermission.del(\"" + value + "\")'>删除</a>";
	return html;
}