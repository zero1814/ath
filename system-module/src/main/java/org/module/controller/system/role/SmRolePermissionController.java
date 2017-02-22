package org.module.controller.system.role;

import org.module.result.DataResult;
import org.module.service.system.role.ISmRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String menuPersmissionSettingIndex(String menuCode) {
		return "jsp/system/role/permission/setting_permission";
	}

	@RequestMapping("setting_permission_data")
	@ResponseBody
	public DataResult settingPermissionData(String menuCode) {
		return service.getMenuPermission(menuCode);
	}
}
