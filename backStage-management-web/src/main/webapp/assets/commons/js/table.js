/**
 * 数据列表加载
 */
var Table = {
	/**
	 * url请求地址
	 */
	url : '',
	/**
	 * 加载列
	 */
	columns : [],
	/**
	 * url请求参数
	 */
	queryParams : {},
	init : function(table, tool, url, params, columns) {
		/**
		 * 参数赋值
		 */
		Table.url = url;
		Table.columns = columns;
		Table.queryParams = params;
		alert(2);
		/**
		 * 加载数据
		 */
		Table.setTableToUrl(table, tool);
		Table.setEvent(table);
	},
	/**
	 * url初始化数据表
	 */
	setTableToUrl : function(table, tool) {
		// 初始化Table
		$(table).bootstrapTable({
			url : Table.url, // 请求后台的URL（*）
			method : 'post', // 请求方式（*）
			toolbar : $(tool).attr("id"), // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : false, // 是否启用排序
			sortOrder : "asc", // 排序方式
			queryParams : Table.queryParams, // 传递参数（*）
			sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 10, // 每页的记录行数（*）
			pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
			search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : true,
			showColumns : true, // 是否显示所有的列
			showRefresh : true, // 是否显示刷新按钮
			minimumCountColumns : 1, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			height : 800, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "code", // 每一行的唯一标识，一般为主键列
			showToggle : true, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
			rowStyle : function(row, index) {
			},
			columns : Table.columns
		});
	},
	/**
	 * 加载表格显示列
	 * 
	 * @param {Object}
	 *            columns
	 */
	setColumns : function(columns) {
		Table.columns = columns;
	},
	setEvent : function(table) {
		$result = $("#examplebtTableEventsResult");
		$(table).on('all.bs.table', function(e, name, args) {
			console.log('Event:', name, ', Table:', args);
		})
		/**
		 * 单击选中行
		 */
		.on('click-row.bs.table', function(e, row, $element) {
			$result.text('Event: click-row.bs.table');
		})
		/**
		 * 双击选中行
		 */
		.on('dbl-click-row.bs.table', function(e, row, $element) {
			$result.text('Event: dbl-click-row.bs.table');
		})
		/**
		 * 排序
		 */
		.on('sort.bs.table', function(e, name, order) {
			$result.text('Event: sort.bs.table');
		})
		/**
		 * 选中一条记录
		 */
		.on('check.bs.table', function(e, row) {
			$result.text('Event: check.bs.table');
		})
		/**
		 * 取消选中的一条记录
		 */
		.on('uncheck.bs.table', function(e, row) {
			$result.text('Event: uncheck.bs.table');
		})
		/**
		 * 选中全部
		 */
		.on('check-all.bs.table', function(e) {
			$result.text('Event: check-all.bs.table');
		})
		/**
		 * 取消选中全部
		 */
		.on('uncheck-all.bs.table', function(e) {
			$result.text('Event: uncheck-all.bs.table');
		})
		/**
		 * 加载数据成功
		 */
		.on('load-success.bs.table', function(e, Table) {
			$result.text('Event: load-success.bs.table');
		})
		/**
		 * 加载数据失败
		 */
		.on('load-error.bs.table', function(e, status) {
			$result.text('Event: load-error.bs.table');
		}).on('column-switch.bs.table', function(e, field, checked) {
			$result.text('Event: column-switch.bs.table');
		})
		/**
		 * 分页
		 */
		.on('page-change.bs.table', function(e, size, number) {
			$result.text('Event: page-change.bs.table');
		})
		/**
		 * 查询
		 */
		.on('search.bs.table', function(e, text) {
			$result.text('Event: search.bs.table');
		});
	}
}