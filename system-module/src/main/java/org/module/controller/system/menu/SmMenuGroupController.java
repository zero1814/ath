package org.module.controller.system.menu;

import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/menu/group/")
public class SmMenuGroupController {

	@Autowired
	private ISmMenuGroupService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/system/menu/group";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmMenuGroupDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("add")
	@ResponseBody
	public RootResult add(SmMenuGroup entity) {
		entity.setCode(CodeHelper.getUniqueCode("SMG"));
		entity.setCreateUser("add");
		return service.insertSelective(entity);
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(SmMenuGroup entity) {
		entity.setUpdateUser("edit");
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}

}
