/**
 * 数据列表加载
 */
var Data = {
	init: function(table, tool) {
		this.setData(table, tool);
		this.setEvent(table);
	},
	/**
	 * 初始化数据表
	 * @param {Object} table
	 * @param {Object} tool
	 */
	setData: function(table, tool) {
		$(table).bootstrapTable({
			url: "demo/bootstrap_table_test.json",
			ajax: "",
			ajaxOptions: {},
			pagination: true,
			showRefresh: true,
			showToggle: false,
			showColumns: true,
			iconSize: 'outline',
			toolbar: $(tool).attr("id"),
			icons: {
				refresh: 'glyphicon-repeat',
				columns: 'glyphicon-list'
			}
		});
	},
	setEvent: function(table) {
		$result = $("#examplebtTableEventsResult");
		$(table).on('all.bs.table', function(e, name, args) {
				console.log('Event:', name, ', data:', args);
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
			.on('load-success.bs.table', function(e, data) {
				$result.text('Event: load-success.bs.table');
			})
			/**
			 * 加载数据失败
			 */
			.on('load-error.bs.table', function(e, status) {
				$result.text('Event: load-error.bs.table');
			})
			.on('column-switch.bs.table', function(e, field, checked) {
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