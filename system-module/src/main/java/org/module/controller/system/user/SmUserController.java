package org.module.controller.system.user;

import org.module.helper.commons.CodeHelper;
import org.module.model.system.user.SmUser;
import org.module.result.EntityResult;
import org.module.service.system.user.ISmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/user/")
public class SmUserController {

	@Autowired
	private ISmUserService service;

	@RequestMapping("login")
	@ResponseBody
	public EntityResult login(String userName, String password) {
		return service.login(userName, password);
	}

	@RequestMapping("register")
	@ResponseBody
	public EntityResult register(SmUser entity) {
		entity.setCode(CodeHelper.getUniqueCode("SU"));
		entity.setCreateUser("register");
		return service.register(entity);
	}

}
