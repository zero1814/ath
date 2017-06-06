package org.module.controller.system.page;

import org.module.dto.system.page.SmPageGroupDto;
import org.module.model.system.page.SmPageGroup;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmPageGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/page/group/")
public class SmPageGroupController {

	@Autowired
	private ISmPageGroupService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/system/page/group";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmPageGroupDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmPageGroup entity) {
		entity.setCreateUser("add");
		return service.insertSelective(entity);
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmPageGroup entity) {
		entity.setUpdateUser("edit");
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}
}
