package org.module.controller.system;

import org.module.base.result.EntityResult;
import org.module.base.result.TreeResult;
import org.module.model.system.SmDefine;
import org.module.service.system.ISmDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("system/code")
public class SmDefineController {

	@Autowired
	private ISmDefineService service;

	public EntityResult add(SmDefine entity) {
		return service.insertSelective(entity);
	}

	public TreeResult tree() {
		return null;
	}
}
