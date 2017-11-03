package org.module.controller.system.menu;

import org.module.base.result.BaseResult;
import org.module.base.result.EntityResult;
import org.module.base.result.PageResult;
import org.module.controller.BaseController;
import org.module.dto.system.menu.SmMenuDto;
import org.module.helper.CodeHelper;
import org.module.model.system.menu.SmMenu;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/menu/")
public class SmMenuController extends BaseController {
	@Autowired
	private ISmMenuService service;

	@RequestMapping("index")
	public String index(ModelMap model) {
		model.addAttribute("groups", service.getMenuGroups());
		return "jsp/system/menu/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmMenuDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("addindex")
	public String addIndex(ModelMap model) {
		model.addAttribute("groups", service.getMenuGroups());
		model.addAttribute("pages", service.getPages());
		return "jsp/system/menu/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmMenu entity) {
		entity.setCode(CodeHelper.getCode("SM"));
		entity.setCreateUser("admin");
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex() {
		return "jsp/system/menu/edit";
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmMenu entity) {
		entity.setUpdateUser("test");
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(String code) {
		return service.deleteByCode(code);
	}
}
