/**
 * 菜单组相关函数
 */
var MenuGroup = {
	Layer:{},
	columns: [{
		checkbox: true
	}, {
		field: 'code',
		title: '编码'
	}, {
		field: 'name',
		title: '名称'
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
			var html = "<a href='javascript:MenuGroup.openLayer(\"edit\");'>修改</a>  |  ";
			html += "<a href='javascript:MenuGroup.del(\""+code+"\")'>删除</a>";
			return html;
		}
	}],
	init: function() {
		MenuGroup.data();
	},
	data: function() {
		Table.init("table", "./data/system/menu/menu.group.json", MenuGroup.columns, MenuGroup.searchParam());
	},
	searchParam: function() {
		var temp = {
			name: $("#name").val()
		};
		return temp;
	},
	search: function() {
		Table.param = MenuGroup.searchParam();
		$("#table").bootstrapTable('refresh');
	},
	openLayer: function(type) {
		var url = "";
		if(type == 'add'){
			url="system/menu/group/addindex.htm";
		}else if(type =='edit'){
			url="system/menu/group/editindex.htm";
		}
		MenuGroup.Layer = layer.open({
			type: 2,
			area: ['500px', '250px'],
			fixed: true, //不固定
			maxmin: true,
			content: url
		});
	},
	closeLayer:function(){
		layer.close(MenuGroup.Layer);
	},
	add: function() {
		layer.close(MenuGroup.Layer);
		var param = $("#add").serializeArray();
		$.ajax({
			url: urlVal,
			type: "POST",
			data: param,
			dataType: "json",
			success: function(result) {
				layer.alert(result.message,function(){
					layer.close();
				});
			},
			error: function(result) {
				window.parent.location.href = UsePublic.ERROR_URL;
			}
		});
	},
	edit: function() {
		layer.confirm("是否确认编辑?", {
			btn: ['确认', '取消']
		}, function() {
			layer.close(MenuGroup.Layer);
			var param = $("#edit").serializeArray();
			$.ajax({
				url: urlVal,
				type: "POST",
				data: param,
				dataType: "json",
				success: function(result) {
					layer.alert(result.message,function(){
						layer.close();
					});
				},
				error: function(result) {
					window.parent.location.href = UsePublic.ERROR_URL;
				}
			});
		}, function() {
			layer.close();
		});
	},
	del: function(code) {
		var param = {"code":code};
		layer.confirm("是否确认删除?", {
			btn: ['确认', '取消']
		}, function() {
			$.ajax({
				url: urlVal,
				type: "POST",
				data: param,
				dataType: "json",
				success: function(result) {
					layer.alert(result.message,function(){
						layer.close();
					});
				},
				error: function(result) {
					window.parent.location.href = UsePublic.ERROR_URL;
				}
			});
		}, function() {
			layer.close();
		});
	}
};