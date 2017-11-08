/**
 * 系统用户相关函数
 */
var User = {
	columns: [{
		checkbox: true
	}, {
		field: 'code',
		title: '编码'
	}, {
		field: 'userName',
		title: '用户名'
	}, {
		field: 'realName',
		title: '真实姓名'
	},{
		field: 'phone',
		title: '手机号'
	},  {
		field: 'email',
		title: '邮箱'
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
		field: 'role',
		title: '角色',
		formatter: function(value, row, index) {
			var html = "<a href='system/user/role/index.htm?code="+row.code+"'>设置</a>";
			return html;
		}
	},{
		field: 'detail',
		title: '查看',
		formatter: function(value, row, index) {
			var html = "<a href='./html/system/user/detail.html'>查看</a>";
			return html;
		}
	}, {
		field: 'operate',
		title: '操作',
		formatter: function(value, row, index) {
			var code = row.code;
			var html = "<a target='_self' href='system/user/editindex.htm?code="+code+"'>修改</a>  |  ";
			html += "<a href='javascript:User.del(\""+code+"\");'>删除</a>";
			return html;
		}
	}],
	init: function() {
		User.data();
	},
	data: function() {
		Table.init("table", "system/user/data.htm", User.columns, User.searchParam());
	},
	searchParam: function() {
		var temp = {
			name: $("#userName").val(),
			phone: $("#phone").val(),
			status: $("#status").val(),
			realName:$("#realName").val()
		};
		return temp;
	},
	search: function() {
		Table.param = User.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	add: function() {
		var param = $("#add").serializeArray();
		$.ajax({
			url: "system/user/add.htm",
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
	edit: function() {
		layer.confirm("是否确认编辑?", {
			btn: ['确认', '取消']
		}, function(index) {
			layer.close(index);
			var param = $("#edit").serializeArray();
			$.ajax({
				url: "system/user/edit.htm",
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
		}, function(index) {
			layer.close(index);
		});
	},
	del: function() {
		var param = {"code":code};
		layer.confirm("是否确认删除?", {
			btn: ['确认', '取消']
		}, function(index) {
			$.ajax({
				url: "system/user/del.htm",
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
};