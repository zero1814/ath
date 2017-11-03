package org.module.controller.system.menu;

import org.module.base.result.BaseResult;
import org.module.base.result.DataResult;
import org.module.base.result.EntityResult;
import org.module.base.result.PageResult;
import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.service.system.menu.ISmMenuGroupService;
import org.module.service.system.menu.ISmMenuService;
import org.module.util.Constant;
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

	@RequestMapping("index")
	public String index(ModelMap model) {
		DataResult result = groupService.findDataAll();
		if (result.getCode() == Constant.RESULT_SUCCESS) {
			model.addAttribute("groups", result.getData());
		}
		return "jsp/system/menu/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmMenuDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("addindex")
	public String addIndex() {
		return "jsp/system/menu/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmMenu entity) {
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
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
