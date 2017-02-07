package org.module.controller.system.menu;

import org.module.commons.annotation.obj.Object;
import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/menu/")
@Object(name = "系统菜单控制器", description = "系统菜单前台交互相关操作")
public class SmMenuController {

	@Autowired
	private ISmMenuService service;

	@RequestMapping("index")
	public String index() {
		return null;
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmMenuDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("addindex")
	public String addIndex() {
		return null;
	}

	@RequestMapping("add")
	@ResponseBody
	public RootResult add(SmMenu entity) {
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	@ResponseBody
	public String editIndex() {
		return null;
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(SmMenu entity) {
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}
}
