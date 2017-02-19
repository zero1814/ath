package org.module.controller.system.role;

import org.module.dto.system.role.SmRoleDto;
import org.module.result.PageResult;
import org.module.service.system.role.ISmRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/role/")
public class SmRoleController {

	@Autowired
	private ISmRoleService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/system/role/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmRoleDto dto) {
		return service.findEntityToPage(dto);
	}

}
