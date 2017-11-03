package org.module.controller.system.menu;

import org.module.base.result.BaseResult;
import org.module.base.result.EntityResult;
import org.module.base.result.PageResult;
import org.module.dto.system.menu.SmMenuDto;
import org.module.dto.system.menu.SmPageDto;
import org.module.model.system.menu.SmMenu;
import org.module.service.system.menu.ISmMenuGroupService;
import org.module.service.system.menu.ISmMenuService;
import org.module.service.system.menu.ISmPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/menu/")
public class SmMenuController {
	@Autowired
	private ISmMenuService service;
	@Autowired
	private ISmMenuGroupService groupService;
	@Autowired
	private ISmPageService pageService;

	@RequestMapping("index")
	public String index(ModelMap model) {
		return "jsp/system/menu/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmMenuDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("add_index")
	public String addIndex() {
		return "jsp/system/menu/add";
	}
	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmMenu entity) {
		return service.insertSelective(entity);
	}

	@RequestMapping("edit_index")
	public String editIndex() {
		return "jsp/system/menu/edit";
	}
	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmMenu entity) {
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(String code) {
		return service.deleteByCode(code);
	}
}
