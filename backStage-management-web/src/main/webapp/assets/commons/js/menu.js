/**
 * 左侧菜单栏
 */
var Nav = {
	// 菜单集合
	title : "随时帮-后台管理",
	// 首页链接
	index_href : "",
	data : "",
	/**
	 * 初始化加载
	 */
	init : function() {
		var html = Nav.drawNav();
		$("#nav").html(html);
	},
	/**
	 * 获取菜单数据集合
	 */
	setNav : function() {
		$.ajax({
			url : "demo/nav.json",
			type : "POST",
			dataType : "json",
			success : function(result) {
				if(result.code == 0){
					Nav.data = result.data;					
				}else{
					alert(result.message);
				}
			},
			error : function(error) {
				alert(JSON.stringify(error));
			}
		});
	},
	/**
	 * 绘制左侧菜单栏
	 */
	drawNav : function() {
		var html = "<div class=\"nav-close\"><i class=\"fa fa-times-circle\"></i></div>";
		html += "<div class=\"sidebar-collapse\">";
		html += "<ul class=\"nav\" id=\"side-menu\">";
		html += Nav.drawHearder();
		html += "<li>";
		html += "<a class=\"J_menuItem\" href=\"" + Nav.index_href + "\">";
		html += "<i class=\"fa fa-home\"></i>";
		html += "<span class=\"nav-label\">主页</span>";
		html += "</a>";
		html += "</li>";
		html += Nav.drawMenuGroup();
		html += "</ul>";
		return html;
	},
	/**
	 * 左侧菜单栏标题头
	 */
	drawHearder : function() {
		var html = "<li class=\"nav-header\">";
		html += "<div class=\"dropdown profile-element\">";
		html += "<a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"index.htm\">";
		html += "<span class=\"clear\">";
		html += "<span class=\"block m-t-xs\" style=\"font-size:18px;\">";
		html += "<i class=\"fa fa-area-chart\"></i>";
		html += "<strong class=\"font-bold\">" + Nav.title + "</strong>";
		html += "</span>";
		html += "</span>";
		html += "</a>";
		html += "</div>";
		html += "<div class=\"logo-element\">" + Nav.title + "</div>";
		html += "</li>";
		return html;
	},
	/**
	 * 绘制左侧菜单栏菜单组
	 */
	drawMenuGroup : function() {
		Nav.setNav();
		var html = "";
		if (Nav.data) {
			for (var i = 0; i < Nav.data.length > 0; i++) {
				var group = Nav.data[i];
				html += "<li class=\"hidden-folded padder m-t m-b-sm text-muted text-xs\">";
				html += "<span class=\"ng-scope\">" + group.name + "</span>";
				if (group.menus) {
					html += Nav.drawMenu(group.menus);
				}
			}
		}
		html += "</li>";
		return html;
	},
	/**
	 * 绘制左侧菜单栏
	 * 
	 * @param {Object}
	 *            menu
	 */
	drawMenu : function(menus) {
		var html = "";
		if (menus) {
			for (var i = 0; i < menus.length; i++) {
				var menu = menus[i];
				html += "<li>";
				html += "<a href=\"" + menu.href + "\">";
				if (menu.parent_code == '0') {
					html += "<i class=\"fa fa fa-bar-chart-o\"></i>";
				}
				html += "<span class=\"nav-label\">" + menu.name + "</span>";
				if (menu.items.length > 0) {
					html += "<span class=\"fa arrow\"></span>";
				}
				html += "</a>";
				if (menu.items.length > 0) {
					if (menu.parent_code == '0') {
						html += "<ul class=\"nav nav-second-level\">";
					} else {
						html += "<ul class=\"nav nav-third-level\">";
					}
					html += Nav.drawMenu(menu.items);
					html += "</ul>";
				}
				html += "</li>"
			}
		}
		return html;
	}
}