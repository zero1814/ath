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
		field: 'flagAble',
		title: '状态',
		formatter: function(value, row, index) {
			var html = "";
			if(value == 0) {
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
			var code = row.code;
			var html = "<a target='_self' href='system/menu/page/detail.htm?code="+code+"'>查看</a>";
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
		var param = $("#add").serializeArray();
		$.ajax({
			url: "system/menu/page/add.htm",
			type: "POST",
			data: param,
			dataType: "json",
			success: function(result) {
				if(result.code == UsePublic.SUCCESS){
					layer.alert(result.message,function(index){
						window.location.href = "system/menu/page/index.htm";
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
				url: "system/menu/page/edit.htm",
				type: "POST",
				data: param,
				dataType: "json",
				success: function(result) {
					if(result.code == UsePublic.SUCCESS){
						layer.alert(result.message,function(index){
							window.location.href = "system/menu/page/index.htm";
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
	del: function(code) {
		var param = {"code":code};
		layer.confirm("是否确认删除?", {
			btn: ['确认', '取消']
		}, function(index) {
			$.ajax({
				url: "system/menu/page/del.htm",
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