/**
 * 系统角色相关函数
 */
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
		title: '权限',
		formatter: function(value, row, index) {
			var html = "<a href='./html/system/user/role/detail.html'>查看</a>";
			return html;
		}
	}, {
		field: 'operate',
		title: '操作',
		formatter: function(value, row, index) {
			var html = "<a target='_self' href='./html/system/user/role/edit.html'>修改</a>  |  ";
			html += "<a href='javascript:void(0)'>删除</a>";
			return html;
		}
	}],
	init: function() {
		Role.data();
	},
	data: function() {
		Table.init("table", "./data/system/user/role.json", Role.columns, Role.searchParam());
	},
	searchParam: function() {
		var temp = {
			name: $("#name").val(),
			groupCode: $("#groupCode").val()
		};
		return temp;
	},
	search: function() {
		Table.param = Role.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	add: function() {
		layer.alert('执行添加方法');
	},
	edit: function() {
		layer.confirm("是否确认编辑?", {
			btn: ['确认', '取消']
		}, function() {
			layer.msg('执行编辑方法', {
				icon: 1
			});
			layer.close();
		}, function() {
			layer.close();
		});
	},
	del: function() {
		layer.confirm("是否确认删除?", {
			btn: ['确认', '取消']
		}, function() {
			layer.alert('执行删除方法', {
				icon: 1
			});
			layer.close();
		}, function() {
			layer.close();
		});
	}
};