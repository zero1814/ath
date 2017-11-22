package org.module.controller.system.user;

import org.module.commons.result.BaseResult;
import org.module.commons.result.PageResult;
import org.module.dto.system.user.SmRoleDto;
import org.module.dto.system.user.SmUserRoleDto;
import org.module.model.system.user.SmUserRole;
import org.module.service.system.user.ISmRoleService;
import org.module.service.system.user.ISmUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

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
	public PageResult data(SmUserRoleDto dto) {
		PageResult result = service.findEntityToPage(dto);
		System.out.println(JSON.toJSON(result));
		return result;
	}

	@RequestMapping("addindex")
	public String addIndex(String userCode, ModelMap model) {
		model.addAttribute("userCode", userCode);
		return "jsp/system/user/role/add";
	}

	@RequestMapping("add/data")
	@ResponseBody
	public PageResult addData(SmRoleDto dto) {
		PageResult result = roleService.findEntityToPage(dto);
		return result;
	}

	@RequestMapping("add")
	@ResponseBody
	public BaseResult add(SmUserRole entity) {
		return service.batchInsert(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(SmUserRoleDto dto) {
		return service.deleteUserRole(dto);
	}
}
