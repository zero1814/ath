var UserRole={
		columns: [{
			field: 'name',
			title: '名称'
		}, {
			field: 'enName',
			title: '英文简称'
		},{
			field: 'createUser',
			title: '创建人'
		}, {
			field: 'createTime',
			title: '创建时间'
		},{
			field:'operate',
			title:'操作'
		}],
		init: function() {
			UserRole.data();
		},
		data: function() {
			Table.init("table", "system/user/role/data.htm", UserRole.columns, UserRole.searchParam());
		},
		searchParam: function() {
			var temp = {
				name: $("#name").val(),
				userCode:$("#userCode").val()
			};
			return temp;
		},
		search: function() {
			Table.param = UserRole.searchParam();
			$("#table").bootstrapTable('refresh');
		},
		batchAdd: function() {
			var codes = new Array();
			var rows = $("#table").bootstrapTable('getSelections');
			if (rows.length== 0) { 
			    layer.alert("请先选择要添加的角色!"); 
			    return; 
			}else{
				for(var key in rows){
					codes.push(rows[key].code);
				}
			}
			var param = {
					userCode:$("#userCode").val(),
					roleCode:codes.join(",")
			}
			$.ajax({
				url: "system/user/role/add.htm",
				type: "POST",
				data: param,
				dataType: "json",
				success: function(result) {
					if(result.code == UsePublic.SUCCESS){
						layer.alert(result.message,function(index){
							window.location.href = "system/user/role/index.htm";
							layer.close(index);
						});
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
		del: function() {
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
						window.parent.location.href = UsePublic.ERROR_URL;
					}
				});
			}, function(index) {
				layer.close(index);
			});
		}
}
var Role = {
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
		}],
		init: function() {
			Role.data();
		},
		data: function() {
			Table.init("role", "system/user/role/add/data.htm", Role.columns, Role.searchParam());
		},
		searchParam: function() {
			var temp = {
				code: $("#code").val(),
				name: $("#name").val(),
				status:"0"
			};
			return temp;
		},
		search: function() {
			Table.param = Role.searchParam();
			$("#role").bootstrapTable('refresh');
		}
}