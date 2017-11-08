var UserRole={
		columns: [{
			checkbox: true
		},{
			field: 'name',
			title: '名称'
		}, {
			field: 'enName',
			title: '英文简称'
		}, {
			field: 'status',
			title: '状态',
			formatter: function(value, row, index) {
				var html = "";
				if(row.status == 0) {
					html = "可用";
				} else {
					html = "不可用";
				}
				return html;
			}
		},{
			field: 'detail',
			title: '查看',
			formatter: function(value, row, index) {
				var html = "<a href=''>查看</a>";
				return html;
			}
		},{
			field: 'operate',
			title: '操作',
			formatter: function(value, row, index) {
				var code = row.code;
				html += "<a href='javascript:UserRole.del(\""+code+"\");'>删除</a>";
				return html;
			}
		}],
		init: function() {
			UserRole.data();
		},
		data: function() {
			Table.init("table", "system/user/role/data.htm", UserRole.columns, UserRole.searchParam());
		},
		searchParam: function() {
			var temp = {
				name: $("#name").val()
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
			return;
			$.ajax({
				url: "system/user/role/add.htm",
				type: "POST",
				data: param,
				dataType: "json",
				success: function(result) {
					if(result.code == UsePublic.SUCCESS){
						layer.alert(result.message,function(index){
							window.location.href = "system/user/index.htm";
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