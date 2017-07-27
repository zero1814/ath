/**
 * 用户店铺相关函数 
 */
var Store ={
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
			field: 'status.name',
			title: '状态'
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
		}];
		Table.init("table", "user/store/data.htm", columns, Store.searchParam());
	},
	searchParam: function() {
		var temp = { name: $("#name").val() };
		return temp;
	},
	add: function() {
		var param = $("#addFrm").serializeArray();
		$.ajax({
			url: 'user/store/add.htm',
			type: "POST",
			data: param,
			dataType : "json",
			success: function(result) {
				if(result.code == 0) {
					layer.alert('添加成功', function(index) {
						window.parent.location.href="user/store/index.htm";
					});
				} else {
					layer.alert(result.message);
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
				url: "user/store/edit.htm",
				type: "POST",
				data: param,
				dataType : "json",
				success: function(result) {
					if(result.code == 0) {
						layer.alert('编辑成功', function(index) {
							window.parent.location.href="user/store/index.htm";
						});
					} else {
						layer.alert(result.message);
					}
				},
				error: function(result) {
					layer.alert('编辑失败，失败原因:' + JSON.stringify(result),function(index){
						window.parent.location.href="user/store/index.htm";
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
				url: "user/store/del.htm",
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
}
