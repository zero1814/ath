package org.module.controller.system.role;

import org.module.dto.system.menu.SmMenuPermissionDto;
import org.module.result.PageResult;
import org.module.service.system.role.ISmRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

@Controller
@RequestMapping("system/role/permission/")
public class SmRolePermissionController {

	@Autowired
	private ISmRolePermissionService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/system/role/permission/index";
	}

	@RequestMapping("menus")
	@ResponseBody
	public JSONArray getMenus() {
		return service.getMenus();
	}

	@RequestMapping("setting_permission_index")
	public String menuPersmissionSettingIndex(ModelMap model, String menuCode) {
		model.addAttribute("menuCode", menuCode);
		return "jsp/system/role/permission/setting_permission";
	}

	@RequestMapping("setting_permission_data")
	@ResponseBody
	public PageResult settingPermissionData(SmMenuPermissionDto dto) {
		return service.getMenuPermission(dto);
	}
}
