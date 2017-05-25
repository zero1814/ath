var Define = {
	Layer : '',
	init : function() {
		$.ajax({
			url : 'system/define/data.htm',
			type : "get",
			data : {},
			dataType : "json",
			success : function(result) {
				if (result.code == 0) {
					var tree = [{code:"0",text:'参数配置',nodes:result.data}];
					$('#treeview').treeview(
							{
								levels : 1,
								data : tree,
								onNodeSelected : function(event, node) {
									if(node.code != "0"){
										var url = "system/define/detail.htm?code="
											+ node.code;
										$("#P_iframe").attr('src', url);										
									}
								}
							});
				} else {
					layer.alert(result.message);
				}
			},
			error : function(result) {
				layer.alert('加载参数列表失败，失败原因：' + JSON.stringify(result));
			}
		});
	},
	openLayer: function(titleVal, layerDivId) {
		Define.Layer = layer.open({
			type: 1,
			title: titleVal,
			skin: 'layui-layer-lan', //加上边框
			area: ['450px', '240px'], //宽高
			content: $("#" + layerDivId)
		});
	},
	closeLayer: function() {
		if(Define.Layer) {
			layer.close(Define.Layer);
		}
	},
	openAdd:function(){
		Define.openLayer("添加子项","addDiv");
	},
	add : function() {
		var param = $("#addFrm").serializeArray();
		$.ajax({
			url: "system/define/add.htm",
			type: "POST",
			data: param,
			success: function(result) {
				result = JSON.parse(result);
				if(result.code == 0) {
					layer.alert('添加成功', function(index) {
						layer.close(index);
						window.parent.location.href="system/define/index.htm";
					});
				} else {
					layer.alert(result.message, function(index) {
						layer.close(index);
						window.parent.location.href="system/define/index.htm";
					});
				}
			},
			error: function(result) {
				layer.alert('添加失败，失败原因:' + JSON.stringify(result),function(index){
					layer.close(index);
					window.parent.location.href="system/define/index.htm";
				});
			}
		});
	},
	openEdit:function(){
		Define.openLayer("编辑页面","editDiv");
	},
	edit:function(){
		layer.confirm('您确认要编辑选中的数据吗？', {
			btn: ['确认', '取消']
			// 按钮
		}, function() {
			var param = $("#editFrm").serializeArray();
			$.ajax({
				url: "system/define/edit.htm",
				type: "POST",
				data: param,
				success: function(result) {
					result = JSON.parse(result);
					if(result.code == 0) {
						layer.alert('编辑成功', function(index) {
							layer.close(index);
							window.parent.location.href="system/define/index.htm";
						});
					} else {
						layer.alert(result.message, function(index) {
							layer.close(index);
							window.parent.location.href="system/define/index.htm";
						});
					}
				},
				error: function(result) {
					layer.alert('编辑失败，失败原因:' + JSON.stringify(result),function(index){
						layer.close(index);
						window.parent.location.href="system/define/index.htm";
					});
				}
			});
		});
	},
	del:function(code){
		layer.confirm('您确认要删除选中的数据吗？', {
			btn: ['确认', '取消']
			// 按钮
		}, function() {
			$.ajax({
				url: "system/define/del.htm",
				type: "POST",
				data: {"code":code},
				success: function(result) {
					result = JSON.parse(result);
					if(result.code == 0) {
						layer.alert('删除成功', function(index) {
							layer.close(index);
							window.parent.location.href="system/define/index.htm";
						});
					} else {
						layer.alert(result.message, function(index) {
							layer.close(index);
							window.parent.location.href="system/define/index.htm";
						});
					}
				},
				error: function(result) {
					layer.alert('删除失败，失败原因:' + JSON.stringify(result),function(index){
						layer.close(index);
						window.parent.location.href="system/define/index.htm";
					});
				}
			});
		});
	}
};