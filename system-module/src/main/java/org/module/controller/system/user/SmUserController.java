package org.module.controller.system.user;

import org.module.base.result.BaseResult;
import org.module.base.result.EntityResult;
import org.module.base.result.PageResult;
import org.module.dto.system.user.SmUserDto;
import org.module.helper.PropHelper;
import org.module.helper.system.CodeHelper;
import org.module.model.system.user.SmUser;
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

	public EntityResult register(SmUser entity) {
		String code = CodeHelper.getCode(PropHelper.getConfig("system.user.code_prefix"));
		entity.setCode(code);
		return service.insertSelective(entity);
	}

	@RequestMapping("login")
	public EntityResult login(String userName, String password) {
		return service.login(userName, password);
	}

	@RequestMapping("index")
	public String inex() {
		return "";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmUserDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("add_index")
	public String addIndex() {
		return null;
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmUser entity) {
		String code = CodeHelper.getCode(PropHelper.getConfig("system.code.user"));
		entity.setCode(code);
		return service.insertSelective(entity);
	}

	@RequestMapping("edit_index")
	public String editIndex() {
		return null;
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmUser entity) {
		return service.updateByCode(entity);
	}

	public BaseResult del(String code) {
		return service.deleteByCode(code);
	}
}
