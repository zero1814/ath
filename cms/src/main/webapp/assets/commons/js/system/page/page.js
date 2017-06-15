/**
 * 页面相关js函数
 */
var Page = {
	Layer:'',
	init : function(group) {
		$.ajax({
			url : 'system/page/tree.htm',
			type : "get",
			data : {groupCode:group},
			dataType : "json",
			success : function(result) {
				if (result.code == 0) {
					var tree = [{text:result.treeName,nodes:result.data}];
					Tree.init("treeview",false,tree,function(event, node) {
						if(node.code){
							if(node.code == "0"){
								var url = "system/page/addindex.htm?code=0&group="+node.groupCode;
								$("#m_iframe").attr('src', url);
							}else{
								var url = "system/page/detail.htm?code=" + node.code;
								$("#m_iframe").attr('src', url);
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
		Page.Layer = layer.open({
			type: 1,
			title: titleVal,
			skin: 'layui-layer-lan', // 加上边框
			area: ['450px', '220px'], // 宽高
			content: $("#" + layerDivId)
		});
	},
	closeLayer: function() {
		if(Page.Layer) {
			layer.close(Page.Layer);
		}
	},
	add:function(group){
		var param = $("#addFrm").serializeArray();
		$.ajax({
			url: "system/page/add.htm",
			type: "POST",
			data: param,
			dataType : "json",
			success: function(result) {
				if(result.code == 0) {
					layer.confirm('添加成功，是否为菜单设置权限？', {
						// 按钮
						btn: ['是', '否']
					}, function() {
						window.location.href="system/page/permission.htm?code="+result.entity.code;
					},function(){
						layer.close(Page.Layer);
						window.parent.location.href="system/page/index.htm?groupCode="+group;
					});
				} else {
					layer.alert(result.message, function() {
						layer.close(Page.Layer);
						window.parent.location.href="system/page/index.htm?groupCode="+group;
					});
				}
			},
			error: function(result) {
				layer.alert('添加失败，失败原因:' + JSON.stringify(result),function(index){
					layer.close(index);
					window.parent.location.href="system/page/index.htm?groupCode="+group;
				});
			}
		});
	},
	edit:function(group){
		layer.confirm('您确认要编辑选中的页面吗？', {
			btn: ['确认', '取消']
			// 按钮
		}, function() {
			var param = $("#editFrm").serializeArray();
			$.ajax({
				url: "system/page/edit.htm",
				type: "POST",
				data: param,
				dataType : "json",
				success: function(result) {
					if(result.code == 0) {
						layer.alert('编辑成功', function(index) {
							layer.close(index);
							window.parent.location.href="system/page/index.htm?groupCode="+group;
						});
					} else {
						layer.alert(result.message, function(index) {
							layer.close(index);
							window.parent.location.href="system/page/index.htm?groupCode="+group;
						});
					}
				},
				error: function(result) {
					layer.alert('编辑失败，失败原因:' + JSON.stringify(result),function(index){
						layer.close(index);
						window.parent.location.href="system/page/index.htm?groupCode="+group;
					});
				}
			});
		});
	},
	del:function(code,group){
		layer.confirm('您确认要删除选中的页面吗？', {
			btn: ['确认', '取消']
			// 按钮
		}, function() {
			$.ajax({
				url: "system/page/del.htm",
				type: "POST",
				data: {"code":code},
				dataType : "json",
				success: function(result) {
					if(result.code == 0) {
						layer.alert('删除成功', function(index) {
							layer.close(index);
							window.parent.location.href="system/page/index.htm?groupCode="+group;
						});
					} else {
						layer.alert(result.message, function(index) {
							layer.close(index);
							window.parent.location.href="system/page/index.htm?groupCode="+group;
						});
					}
				},
				error: function(result) {
					layer.alert('删除失败，失败原因:' + JSON.stringify(result),function(index){
						layer.close(index);
						window.parent.location.href="system/page/index.htm?groupCode="+group;
					});
				}
			});
		});
	}
}