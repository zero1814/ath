package org.module.controller.system.menu;

import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.result.DataResult;
import org.module.result.PageResult;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/menugroup")
public class SmMenuGroupController {

	@Autowired
	public ISmMenuGroupService service;

	@RequestMapping("index")
	public String index() {
		return null;
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmMenuGroupDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("menus")
	@ResponseBody
	public DataResult getMenus() {
		String userCode = "";
		return service.getMenuData(userCode);
	}
}
