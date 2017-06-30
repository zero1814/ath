package org.module.controller.cms;

import java.util.List;

import org.module.helper.commons.CodeHelper;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.user.SmUser;
import org.module.result.EntityResult;
import org.module.service.cms.IndexService;
import org.module.service.system.user.ISmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@Autowired
	private IndexService service;
	@Autowired
	private ISmUserService userService;

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

	@RequestMapping("login")
	@ResponseBody
	public EntityResult login(String userName, String password) {
		return userService.login(userName, password);
	}

	@RequestMapping("register")
	@ResponseBody
	public EntityResult register(SmUser entity) {
		entity.setCode(CodeHelper.getUniqueCode("SU"));
		return userService.register(entity);
	}
}
