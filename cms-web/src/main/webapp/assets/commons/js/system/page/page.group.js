var PageGroup = {
	Layer: '',
	data: function() {
		var columns = [{
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
			title:'页面维护',
			formatter: pageHref
		}, {
			field: 'operate',
			title: '操作',
			formatter: initOperate
		}];
		Table.init("table", "system/page/group/data.htm", columns, PageGroup.searchParam());
	},
	searchParam: function() {
		var temp = { name: $("#name").val() };
		return temp;
	},
	search: function() {
		Table.param = PageGroup.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	openLayer: function(titleVal, url) {
		PageGroup.Layer = layer.open({
			type: 2,
			title: titleVal,
			skin: 'layui-layer-lan', //加上边框
			area: ['450px', '280px'], //宽高
			content: [url, 'no']
		});
	},
	closeLayer: function() {
		if(parent.PageGroup.Layer) {
			parent.layer.close(parent.PageGroup.Layer);
		}
	},
	openAdd:function(){
		PageGroup.openLayer("添加","system/page/group/addindex.htm");
	},
	openEdit: function(val) {
		layer.confirm('您确定要修改此条数据吗？', {
			btn: ['确定', '取消'] //按钮
		}, function(index) {
			layer.close(index);
			PageGroup.openLayer("编辑","system/page/group/editindex.htm?code="+val);
		}, function(index) {
			layer.close(index);
		});
	},
	add: function() {
		var param = $("#addFrm").serializeArray();
		$.ajax({
			url: 'system/page/group/add.htm',
			type: "POST",
			data: param,
			dataType : "json",
			success: function(result) {
				if(result.code == 0) {
					layer.alert('添加成功', function(index) {
						parent.$("#table").bootstrapTable('refresh');
						parent.layer.close(parent.PageGroup.Layer);
					});
				} else {
					layer.alert(result.message, function(index) {
						parent.$("#table").bootstrapTable('refresh');
						parent.layer.close(PageGroup.Layer);
					});
				}
			},
			error: function(result) {
				layer.alert('添加失败，失败原因:' + JSON.stringify(result));
			}
		});
	},
	edit: function() {
		var param = $("#editFrm").serializeArray();
		layer.confirm('您确认要编辑选中的菜单吗？', {
			btn: ['确认', '取消']
			// 按钮
		}, function() {
			var param = $("#editFrm").serializeArray();
			$.ajax({
				url: "system/page/group/edit.htm",
				type: "POST",
				data: param,
				dataType : "json",
				success: function(result) {
					if(result.code == 0) {
						layer.alert('编辑成功', function(index) {
							parent.$("#table").bootstrapTable('refresh');
							parent.layer.close(parent.PageGroup.Layer);
						});
					} else {
						layer.alert(result.message, function(index) {
							parent.$("#table").bootstrapTable('refresh');
							parent.layer.close(parent.PageGroup.Layer);
						});
					}
				},
				error: function(result) {
					layer.alert('编辑失败，失败原因:' + JSON.stringify(result),function(index){
						parent.layer.close(parent.PageGroup.Layer);
						window.parent.location.href="system/page/index.htm?groupCode="+group;
					});
				}
			});
		});
	},
	del: function(val) {
		layer.confirm('您确认要删除选中的页面吗？', {
			btn: ['确认', '取消']
			// 按钮
		}, function() {
			$.ajax({
				url: "system/page/group/del.htm",
				type: "POST",
				data: {"code":val},
				dataType : "json",
				success: function(result) {
					if(result.code == 0) {
						layer.alert('删除成功', function(index) {
							layer.close(index);
							$("#table").bootstrapTable('refresh');
						});
					} else {
						layer.alert(result.message, function(index) {
							layer.close(index);
							$("#table").bootstrapTable('refresh');
						});
					}
				},
				error: function(result) {
					layer.alert('删除失败，失败原因:' + JSON.stringify(result),function(index){
						layer.close(index);
						$("#table").bootstrapTable('refresh');
					});
				}
			});
		});
	}
};
function pageHref(value, row, index) {
	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='system/page/index.htm?groupCode="+row.code+"'>维护</a>";
	return html;
}
function initOperate(value, row, index) {
	var code = row.code;
	var html = "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='PageGroup.openEdit(\""+code+"\")'>编辑</a>";
	html += "<a style='margin:10px;' class='btn btn-info btn-sm' href='javacript:void(0)' onclick='PageGroup.del(\"" + code + "\")'>删除</a>";
	return html;
}