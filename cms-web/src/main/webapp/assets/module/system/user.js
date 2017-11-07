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
			var html = "<a target='_self' href='javascript:User.edit();'>修改</a>  |  ";
			html += "<a href='javascript:User.del();'>删除</a>";
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
			name: $("#name").val(),
			groupCode: $("#groupCode").val()
		};
		return temp;
	},
	search: function() {
		Table.param = User.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	add: function() {
		layer.alert('执行添加方法');
	},
	edit: function() {
		layer.confirm("是否确认编辑?", {
			btn: ['确认', '取消']
		}, function() {
			layer.close();
			window.location.href='./html/system/user/edit.html';
		}, function() {
			layer.close();
		});
	},
	del: function() {
		layer.confirm("是否确认删除?", {
			btn: ['确认', '取消']
		}, function() {
			layer.close();
			layer.alert('执行删除方法',function(){
				window.location.href='./html/system/user/edit.html';
			});
		}, function() {
			layer.close();
		});
	}
};