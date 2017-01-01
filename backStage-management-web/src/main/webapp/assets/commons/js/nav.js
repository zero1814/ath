/**
 * 左侧菜单栏
 */
var Nav = {
	init: function() {

	},
	setNav: function() {
		$.ajax({
			url: "assets/data/menu.json",
			type: "POST",
			dataType:"json", 
			success: function(data) {
				alert(data);
			},
			error: function(data) {
				alert(JSON.stringify(data));
			}
		});
	}
}