package org.module.controller.system.menu;

import java.util.ArrayList;
import java.util.List;

import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.model.system.menu.SmMenuGroup;
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
		return "jsp/system/menugroup/index";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("data")
	@ResponseBody
	public List<SmMenuGroup> data(SmMenuGroupDto dto) {
		PageResult result = service.findEntityToPage(dto);
		List<SmMenuGroup> list = new ArrayList<SmMenuGroup>();
		if (result.getCode() == 0) {
			list = (List<SmMenuGroup>) result.getData();
		}
		return list;
	}

	@RequestMapping("menus")
	@ResponseBody
	public DataResult getMenus() {
		String userCode = "";
		return service.getMenuData(userCode);
	}
}
