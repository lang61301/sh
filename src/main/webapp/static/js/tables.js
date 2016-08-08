var Tables = function($){
	
	function init($table, setting){
		setting = $.extend({
			//table的元素结构，将生成下方的表格信息，页面分割，单页行数
			"dom": "t<'row'<'col-md-2 col-sm-6'i><'col-md-3 col-sm-6'l><'col-md-7 col-sm-12'p>>",
			"language": {
				"aria": {
					"sortAscending": ": activate to sort column ascending",
					"sortDescending": ": activate to sort column descending"
				},
				"emptyTable": "暂无数据",
				"info": "显示 _START_ - _END_ 项，共 _TOTAL_ 条。",
				"infoEmpty": "未找到项目",
				"infoFiltered": "",
				"lengthMenu": "每页显示 _MENU_ 条",
				"search": "Search:",
				"zeroRecords": "No matching records found",
				"paginate": {
					"previous": "上一页",
					"next": "下一页",
					"last": "末页",
					"first": "首页"
				}
			},
			"fixedColumns": {
				"leftColumns": 1,
				"heightMatch": "none"
			},
			"ordering": false,
			"lengthMenu": [
				[10, 15, 20, 30],  //每页行数筛选器，-1为全部显示
				[10, 15, 20, 30]
			],
			"pageLength": 10
		}, setting)
		return $table.DataTable(setting);
	}
	
	return {
		initTable:init
	};
}($);