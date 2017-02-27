/**
 * 角色权限相关
 */
/**
 * 列表显示字段
 */
var columnsArray = [ {
	field : 'name',
	title : '名称'
}, {
	field : 'permissionName',
	title : '权限类型'
}, {
	field : 'setting',
	title : '是否启用',
	formatter : initSettingPermisionHtml
} ];
var RolePermission = {
	initMenus : function() {
		$.ajax({
			url : "system/role/permission/menus.htm",
			type : "POST",
			data : {},
			success : function(result) {
				result = JSON.parse(result);
				if (result) {
					$('#menus').treeview({
						data : result,
						multiSelect : false, //
						onNodeSelected : function(event, node) {
							$("#menuCode").val(node.code);
							$('#table').bootstrapTable('refresh');
							setTimeout("drawSwitch()", 100 )
						}
					});
				} else {
					layer.alert(result.message);
				}
			},
			error : function(result) {
				layer.alert('加载菜单权限列表失败');
			}
		});
	},
	/**
	 * 加载菜单权限列表
	 */
	menuPermissionData : function() {
		$("#table").bootstrapTable({
			url : "system/role/permission/setting_permission_data.htm", // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			dataType : "json",
			toolbar : $("#tools").attr("id"), // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : true, // 是否启用排序
			sortOrder : "desc", // 排序方式
			queryParams : RolePermission.initMenuPermissionDataParam,// 传递参数（*）
			queryParamsType : "limit",
			sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 10, // 每页的记录行数（*）
			pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
			search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : false,
			showRefresh : true, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			height : 500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "code", // 每一行的唯一标识，一般为主键列
			showToggle : false, // 是否显示详细视图和列表视图的切换按钮
			showCheckbox : false,
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
			columns : columnsArray
		});
	},
	initMenuPermissionDataParam : function(params) {
		var tmp = {
			flagAble : 0,
			menuCode : $("#menuCode").val()
		};
		if (tmp) {
			tmp.pageNumber = params.offset + 1;
			tmp.pageSize = params.limit;
		} else {
			tmp = {
				pageNumber : params.offset + 1,
				pageSize : params.limit
			};
		}
		return tmp;
	}
};
/**
 * 初始化权限设置html
 * 
 * @param value
 * @param row
 * @param index
 * @returns {String}
 */
function initSettingPermisionHtml(value, row, index) {
	var html = "<input code=\"" + row.code + "\" type=\"checkbox\" class=\"js-switch\" />";
//	var html = "<div  class=\"switch switch-mini\">";
//		html +="<input name=\"menu.permission\" code=\""+row.code+"\" type=\"checkbox\" />";
//		html +="</div>";
	return html;
}

function drawSwitch(){
	var elems = Array.prototype.slice.call(document.querySelectorAll('.js-switch'));
	elems.forEach(function(html) {
	  var switchery = new Switchery(html);
	});
}