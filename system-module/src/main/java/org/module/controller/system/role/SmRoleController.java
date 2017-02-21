package org.module.controller.system.role;

import org.module.commons.helper.CodeHelper;
import org.module.dto.system.role.SmRoleDto;
import org.module.model.system.role.SmRole;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
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

	@RequestMapping("add")
	@ResponseBody
	public RootResult add(SmRole entity) {
		entity.setCode(CodeHelper.getUniqueCode("SR"));
		entity.setCreateUser("admin");
		return service.insertSelective(entity);
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(SmRole entity) {
		entity.setUpdateUser("admin");
		return service.updateByCode(entity);
	}

	@RequestMapping("detail")
	@ResponseBody
	public EntityResult getSmRole(String code) {
		EntityResult result = service.selectByCode(code);
		return result;
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}

}
