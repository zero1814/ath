package org.module.controller.system.menu;

import org.module.model.system.menu.SmMenuPermission;
import org.module.result.DataResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("system/menu/permission/")
public class SmMenuPermissionController {

	@Autowired
	private ISmMenuPermissionService service;

	@RequestMapping("index")
	public String index() {
		return null;
	}

	@RequestMapping("data")
	public DataResult data() {
		return null;
	}

	@RequestMapping("add")
	public RootResult add(SmMenuPermission entity) {
		return service.insertSelective(entity);
	}

	@RequestMapping("edit")
	public RootResult edit(SmMenuPermission entity) {
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}
}
