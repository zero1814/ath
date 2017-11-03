/**
 * 菜单相关函数
 */
var Menu = {
	columns: [{
		checkbox: true
	}, {
		field: 'code',
		title: '编码'
	}, {
		field: 'name',
		title: '名称'
	}, {
		field: 'parent.name',
		title: '父级名称'
	}, {
		field: 'group.name',
		title: '分组名称'
	}, {
		field: 'icon',
		title: '图标'
	}, {
		field: 'flagAble',
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
			var html = "<a href='./html/system/menu/detail.html'>查看</a>";
			return html;
		}
	}, {
		field: 'operate',
		title: '操作',
		formatter: function(value, row, index) {
			var html = "<a target='_self' href='system/menu/editindex.htm'>修改</a>  |  ";
			html += "<a href='javascript:Menu.del();'>删除</a>";
			return html;
		}
	}],
	init: function() {
		Menu.data();
	},
	data: function() {
		Table.init("table", "system/menu/data.htm", Menu.columns, Menu.searchParam());
	},
	searchParam: function() {
		var temp = {
			name: $("#name").val(),
			groupCode: $("#groupCode").val()
		};
		return temp;
	},
	search: function() {
		Table.param = Menu.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	menuInit: function() {
		$.ajax({
			url: './data/system/menu/menu.json',
			type: "GET",
			dataType: "json",
			success: function(result) {
				var html = "<option value=''>--请选择--</option>";
				for(var key in result) {
					var obj = result[key];
					html += "<option value='" + obj.code + "'>" + obj.name + "</option>";
				}
				$("#parentCode").html(html);
			},
			error: function(result) {
				window.parent.location.href = UsePublic.ERROR_URL;
			}
		});
	},
	groupInit: function() {
		$.ajax({
			url: './data/system/menu/menu.group.json',
			type: "GET",
			dataType: "json",
			success: function(result) {
				var html = "<option value=''>--请选择--</option>";
				for(var key in result) {
					var obj = result[key];
					html += "<option value='" + obj.code + "'>" + obj.name + "</option>";
				}
				$("#groupCode").html(html);
			},
			error: function(result) {
				window.parent.location.href = UsePublic.ERROR_URL;
			}
		});
	},
	pageInit: function() {
		$.ajax({
			url: './data/system/menu/page.json',
			type: "GET",
			dataType: "json",
			success: function(result) {
				var html = "<option value=''>--请选择--</option>";
				for(var key in result) {
					var obj = result[key];
					html += "<option value='" + obj.code + "'>" + obj.name + "</option>";
				}
				$("#pageCode").html(html);
			},
			error: function(result) {
				window.parent.location.href = UsePublic.ERROR_URL;
			}
		});
	},
	add: function() {
		layer.alert('执行添加方法');
	},
	edit: function() {
		layer.confirm("是否确认编辑?", {
			btn: ['确认', '取消']
		}, function() {
			layer.close();
			layer.alert("编辑成功",function(){
				window.location.href='./html/system/menu/index.html';
			});
		}, function() {
			layer.close();
		});
	},
	del: function() {
		layer.confirm("是否确认删除?", {
			btn: ['确认', '取消']
		}, function() {
			layer.close();
			layer.alert('执行删除方法', {
				icon: 1
			},function(){
				window.location.href='./html/system/menu/index.html';
			});
		}, function() {
			layer.close();
		});
	}
};