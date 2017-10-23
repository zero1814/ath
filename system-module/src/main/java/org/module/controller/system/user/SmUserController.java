package org.module.controller.system.user;

import org.module.base.result.BaseResult;
import org.module.base.result.EntityResult;
import org.module.base.result.PageResult;
import org.module.dto.system.user.SmUserDto;
import org.module.model.system.user.SmUser;
import org.module.service.system.user.ISmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("system/user/")
public class SmUserController {

	@Autowired
	private ISmUserService service;

	public String inex() {
		return "";
	}

	public PageResult data(SmUserDto dto) {
		return service.findEntityToPage(dto);
	}

	public String addIndex() {
		return null;
	}

	public EntityResult add(SmUser entity) {
		return service.insertSelective(entity);
	}

	public String editIndex() {
		return null;
	}

	public EntityResult edit(SmUser entity) {
		return service.updateByCode(entity);
	}

	public BaseResult del(String code) {
		return service.deleteByCode(code);
	}
}
