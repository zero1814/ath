package org.module.controller.system.user;

import org.module.base.result.BaseResult;
import org.module.base.result.EntityResult;
import org.module.base.result.PageResult;
import org.module.dto.system.user.SmRoleDto;
import org.module.model.system.user.SmRole;
import org.module.service.system.user.ISmRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class SmRoleController {

	@Autowired
	private ISmRoleService service;

	@RequestMapping("index")
	public String inex() {
		return "";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmRoleDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("add_index")
	public String addIndex() {
		return null;
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmRole entity) {
		return service.insertSelective(entity);
	}

	@RequestMapping("edit_index")
	public String editIndex() {
		return "";
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmRole entity) {
		return service.updateByCode(entity);
	}

	public BaseResult del(String code) {
		return service.deleteByCode(code);
	}

}
