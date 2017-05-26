package org.module.controller.cms;

import java.util.List;

import org.module.model.system.menu.SmMenu;
import org.module.service.cms.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	private IndexService service;

	/**
	 * 方法: index <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月19日 上午8:26:58
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("index")
	public String index(ModelMap model) {
		List<SmMenu> menus = service.initMenus();
		model.addAttribute("menus", menus);
		return "index";
	}

	@RequestMapping("subindex")
	public String index() {
		return "jsp/index";
	}
}
