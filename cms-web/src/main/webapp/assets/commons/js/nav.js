var Nav = {
	init: function() {
		$.ajax({
			url: 'index/menus.htm',
			type: "get",
			data: {},
			dataType: "json",
			success: function(result) {
				if(result.code == 0) {
					var html = "<li class='nav-header'>";
					html += "<div class='dropdown profile-element'>";
					html += "<a data-toggle='dropdown' class='dropdown-toggle' href='#'>";
					html += "<span class='clear'>";
					html += "<span class='block m-t-xs' style='font-size: 20px;'>";
					html += "<i class='fa fa-area-chart'></i>";
					html += "<strong class='font-bold'>ATH</strong>";
					html += "</span>";
					html += "</span>";
					html += "</a>";
					html += "</div>";
					html += "<div class='logo-element'>ATH</div>";
					html += "</li>";
					html += Nav.draw(result.data);
					alert(html);
					$("#side-menu").html(html);
				} else {
					layer.alert(result.message);
				}
			},
			error: function(result) {
				layer.alert('加载参数列表失败，失败原因：' + JSON.stringify(result));
			}
		});
	},
	draw: function(data) {
		var html = "";
		for(var key in data) {
			html += "<li>";
			var obj = data[key];
			if(obj.childMenu) {
				html += "<a href='#'><i class='fa " + obj.icon + "'></i> <span class='nav-label'>" + obj.name + "</span><span class='fa arrow'></span></a>";
				html += "<ul>";
				html += Nav.draw(obj.childMenu);
				html += "</ul>";
			} else {
				html += "<a class='J_menuItem' href='" + obj.url + "'><i class='fa " + obj.icon + "'></i><span class='nav-label'>" + obj.name + "</span></a>";
			}
			html += "</li>";
		}
		return html;
	}
};