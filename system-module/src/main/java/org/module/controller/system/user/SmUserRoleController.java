package org.module.controller.system.user;

import org.module.base.result.BaseResult;
import org.module.base.result.DataResult;
import org.module.base.result.PageResult;
import org.module.dto.system.user.SmRoleDto;
import org.module.dto.system.user.SmUserRoleDto;
import org.module.service.system.user.ISmRoleService;
import org.module.service.system.user.ISmUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/user/role/")
public class SmUserRoleController {

	@Autowired
	private ISmUserRoleService service;
	@Autowired
	private ISmRoleService roleService;

	@RequestMapping("index")
	public String index(String code, ModelMap model) {
		model.addAttribute("userCode", code);
		return "jsp/system/user/role/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public DataResult data(SmUserRoleDto dto) {
		return service.findUserRoleData(dto);
	}

	@RequestMapping("addindex")
	public String addIndex(String userCode, ModelMap model) {
		model.addAttribute("userCode", userCode);
		return "jsp/system/user/role/add";
	}

	@RequestMapping("add/data")
	@ResponseBody
	public PageResult addData(SmRoleDto dto) {
		return roleService.findEntityToPage(dto);
	}

	@RequestMapping("add")
	@ResponseBody
	public BaseResult add() {
		return null;
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(SmUserRoleDto dto) {
		return service.deleteUserRole(dto);
	}
}
