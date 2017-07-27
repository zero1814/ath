/**
 * 商品参数相关函数 
 */
var Define = {
		Layer:'',
		init : function() {
			$.ajax({
				url : 'product/define/tree.htm',
				type : "get",
				data : {},
				dataType : "json",
				success : function(result) {
					if (result.code == 0) {
						var tree = [{text:result.treeText,nodes:result.data}];
						Tree.init("treeview",false,tree,function(event, node) {
							if(node.code){
								if(node.code == "0"){
									var url = "product/define/addindex.htm?code=0";
									$("#m_iframe").attr('src', url);
								}else{
									var url = "product/define/detail.htm?code=" + node.code;
									$("#m_iframe").attr('src', url);
								}
							}else{
								var url = "product/define/addindex.htm?code=0&group="+result.treeCode;
								$("#m_iframe").attr('src', url);
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
				area: ['450px', '220px'], //宽高
				content: $("#" + layerDivId)
			});
		},
		closeLayer: function() {
			if(Define.Layer) {
				layer.close(Define.Layer);
			}
		},
		add:function(groupCode){
			var param = $("#addFrm").serializeArray();
			$.ajax({
				url: "product/define/add.htm",
				type: "POST",
				data: param,
				dataType : "json",
				success: function(result) {
					layer.alert(result.message, function() {
						layer.close(Define.Layer);
						window.parent.location.href="product/define/index.htm?groupCode="+groupCode;
					});
				},
				error: function(result) {
					layer.alert('添加失败，失败原因:' + JSON.stringify(result),function(index){
						layer.close(index);
						window.parent.location.href="product/define/index.htm?groupCode="+$("#groupCode").val();
					});
				}
			});
		},
		edit:function(){
			layer.confirm('您确认要编辑选中的菜单吗？', {
				btn: ['确认', '取消']
				// 按钮
			}, function() {
				var param = $("#editFrm").serializeArray();
				$.ajax({
					url: "product/define/edit.htm",
					type: "POST",
					data: param,
					dataType : "json",
					success: function(result) {
						if(result.code == 0) {
							layer.alert('编辑成功', function(index) {
								layer.close(index);
								window.parent.location.href="product/define/index.htm?groupCode="+$("#groupCode").val();
							});
						} else {
							layer.alert(result.message, function(index) {
								layer.close(index);
								window.parent.location.href="product/define/index.htm?groupCode="+$("#groupCode").val();
							});
						}
					},
					error: function(result) {
						layer.alert('编辑失败，失败原因:' + JSON.stringify(result),function(index){
							layer.close(index);
							window.parent.location.href="product/define/index.htm?groupCode="+$("#groupCode").val();
						});
					}
				});
			});
		},
		del:function(code,group){
			layer.confirm('您确认要删除选中的菜单吗？', {
				btn: ['确认', '取消']
				// 按钮
			}, function() {
				$.ajax({
					url: "product/define/del.htm",
					type: "POST",
					data: {"code":code},
					dataType : "json",
					success: function(result) {
						if(result.code == 0) {
							layer.alert('删除成功', function(index) {
								layer.close(index);
								window.parent.location.href="product/define/index.htm?groupCode="+group;
							});
						} else {
							layer.alert(result.message, function(index) {
								layer.close(index);
								window.parent.location.href="product/define/index.htm?groupCode="+group;
							});
						}
					},
					error: function(result) {
						layer.alert('删除失败，失败原因:' + JSON.stringify(result),function(index){
							layer.close(index);
							window.parent.location.href="product/define/index.htm?groupCode="+group;
						});
					}
				});
			});
		}
}
