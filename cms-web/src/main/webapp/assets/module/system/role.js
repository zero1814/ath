/**
 * 系统角色相关函数
 */
var Role = {
		Layer:{},
		columns: [{
			checkbox: true
		}, {
			field: 'code',
			title: '编码'
		}, {
			field: 'enName',
			title: '英文简称'
		}, {
			field: 'name',
			title: '名称'
		},{
			field: 'status',
			title: '状态',
			formatter:function(value, row, index){
				var html = "可用";
				if(value ==1){
					html = "不可用";
				}
				return html;
			}
		}, {
			field: 'createUser',
			title: '创建人'
		}, {
			field: 'createTime',
			title: '创建时间'
		}, {
			field: 'updateUser',
			title: '修改人'
		}, {
			field: 'updateTime',
			title: '修改时间'
		}, {
			field: 'operate',
			title: '操作',
			formatter: function(value, row, index) {
				var code = row.code;
				var html = "<a href='javascript:Role.openLayer(\"edit\",\""+code+"\");'>修改</a>  |  ";
				html += "<a href='javascript:Role.del(\""+code+"\")'>删除</a>";
				return html;
			}
		}],
		init: function() {
			Role.data();
		},
		data: function() {
			Table.init("table", "system/user/role/data.htm", Role.columns, Role.searchParam());
		},
		searchParam: function() {
			var temp = {
				code: $("#code").val(),
				name: $("#name").val()
			};
			return temp;
		},
		search: function() {
			Table.param = Role.searchParam();
			$("#table").bootstrapTable('refresh');
		},
		openLayer: function(type,code) {
			var url = "";
			if(type == 'add'){
				url="system/user/role/addindex.htm";
			}else if(type =='edit'){
				url="system/user/role/editindex.htm?code="+code;
			}
			Role.Layer = layer.open({
				type: 2,
				area: ['500px', '400px'],
				fixed: true, //不固定
				maxmin: true,
				content: url
			});
		},
		closeLayer:function(){
			if(parent.Role.Layer) {
				parent.layer.close(parent.Role.Layer);
			}
		},
		add: function() {
			var param = $("#add").serializeArray();
			$.ajax({
				url: "system/user/role/add.htm",
				type: "POST",
				data: param,
				dataType: "json",
				success: function(result) {
					if(result.code == UsePublic.SUCCESS){
						layer.alert(result.message,function(index){
							Role.closeLayer();
							layer.close(index);
						});	
						parent.$("#table").bootstrapTable('refresh');
					}else if(result.code == UsePublic.NULL){
						window.parent.location.href = UsePublic.NULL_URL;
					}else{
						window.parent.location.href = UsePublic.ERROR_URL;
					}
				},
				error: function(result) {
					window.parent.location.href = UsePublic.ERROR_URL;
				}
			});
		},
		edit: function() {
			layer.confirm("是否确认编辑?", {
				btn: ['确认', '取消']
			}, function(index) {
				layer.close(index);
				var param = $("#edit").serializeArray();
				$.ajax({
					url: "system/user/role/edit.htm",
					type: "POST",
					data: param,
					dataType: "json",
					success: function(result) {
						if(result.code == UsePublic.SUCCESS){
							layer.alert(result.message,function(index){
								Role.closeLayer();
								layer.close(index);
							});
							parent.$("#table").bootstrapTable('refresh');
						}else if(result.code == UsePublic.NULL){
							window.parent.location.href = UsePublic.NULL_URL;
						}else{
							window.parent.location.href = UsePublic.ERROR_URL;
						}
					},
					error: function(result) {
						window.parent.location.href = UsePublic.ERROR_URL;
					}
				});
			}, function(index) {
				layer.close(index);
			});
		},
		del: function(code) {
			var param = {"code":code};
			layer.confirm("是否确认删除?", {
				btn: ['确认', '取消']
			}, function(index) {
				$.ajax({
					url: "system/user/role/del.htm",
					type: "POST",
					data: param,
					dataType: "json",
					success: function(result) {
						if(result.code == UsePublic.SUCCESS){
							layer.alert(result.message,function(index){
								$("#table").bootstrapTable('refresh');
								layer.close(index);
							});
						}else if(result.code == UsePublic.NULL){
							window.parent.location.href = UsePublic.NULL_URL;
						}else{
							window.parent.location.href = UsePublic.ERROR_URL;
						}
					},
					error: function(result) {
						alert(JSON.stringify(result));
						window.parent.location.href = UsePublic.ERROR_URL;
					}
				});
			}, function(index) {
				layer.close(index);
			});
		}
};