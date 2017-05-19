package org.module.controlle.cms;

import java.util.List;

import org.module.model.system.menu.SmMenu;
import org.module.result.DataResult;
import org.module.service.cms.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@Autowired
	private IndexService service;

	/**
	 * 
	 * 方法: index <br>
	 * 描述: 初始化加载页 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年4月10日 上午9:54:00
	 * 
	 * @return
	 */
	/**
	 * 方法: index <br>
	 * 描述: TODO <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月19日 上午8:26:58
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("index")
	@ResponseBody
	public String index(ModelMap model) {
		List<SmMenu> menus = service.initMenus();
		model.addAttribute("menus", menus);
		return "index";
	}

	/**
	 * 
	 * 方法: subIndex <br>
	 * 描述: iframe内嵌加载首页 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年4月10日 上午10:23:37
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("subindex")
	public String subIndex(ModelMap model) {
		return null;
	}
}
