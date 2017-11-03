var Define = {
	tree: function(id) {
		$.ajax({
			url: './data/system/define.json',
			type: "get",
			data: {},
			dataType: "json",
			success: function(result) {
				Tree.init(id, false, result);
			},
			error: function(result) {
				alert(JSON.stringify(result));
			}
		});
	}
}