/**
 * 页面相关函数
 */
var Page = {
	columns: [{
		checkbox: true
	}, {
		field: 'code',
		title: '编码'
	}, {
		field: 'name',
		title: '名称'
	}, {
		field: 'parentCode',
		title: '父级编码'
	}, {
		field: 'url',
		title: 'url地址'
	}, {
		field: 'param',
		title: '参数信息'
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
			var html = "<a href='./html/system/menu/page/detail.html'>查看</a>";
			return html;
		}
	}, {
		field: 'operate',
		title: '操作',
		formatter: function(value, row, index) {
			var code = row.code;
			var html = "<a target='_self' href='system/menu/page/editindex.htm?code="+code+"'>修改</a>  |  ";
			html += "<a href='javascript:Page.del(\""+code+"\");'>删除</a>";
			return html;
		}
	}],
	init: function() {
		Page.data();
	},
	data: function() {
		Table.init("table", "system/menu/page/data.htm", Page.columns, Page.searchParam());
	},
	searchParam: function() {
		var temp = {
			name: $("#name").val(),
			groupCode: $("#groupCode").val()
		};
		return temp;
	},
	search: function() {
		Table.param = Page.searchParam();
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