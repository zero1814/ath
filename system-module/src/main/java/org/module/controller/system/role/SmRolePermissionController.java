package org.module.controller.system.role;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("system/role/permission/")
public class SmRolePermissionController {


	@RequestMapping("index")
	public String index(ModelMap model,String roleCode) {
		model.addAttribute("roleCode", roleCode);
		return "jsp/system/role/permission";
	}
}
