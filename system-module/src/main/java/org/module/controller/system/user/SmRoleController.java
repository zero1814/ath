package org.module.controller.system.user;

import org.module.base.result.BaseResult;
import org.module.base.result.EntityResult;
import org.module.base.result.PageResult;
import org.module.controller.BaseController;
import org.module.dto.system.user.SmRoleDto;
import org.module.helper.CodeHelper;
import org.module.helper.PropHelper;
import org.module.model.system.user.SmRole;
import org.module.service.system.user.ISmRoleService;
import org.module.system.factory.UserFactory;
import org.module.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/user/role/")
public class SmRoleController extends BaseController {

	@Autowired
	private ISmRoleService service;

	@RequestMapping("index")
	public String inex() {
		return "jsp/system/user/role/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmRoleDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("addindex")
	public String addIndex() {
		return "jsp/system/user/role/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmRole entity) {
		String code = CodeHelper.getCode(PropHelper.getConfig("system.role.code_prefix"));
		entity.setCode(code);
		entity.setCreateUser(UserFactory.userInfo().getCode());
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == Constant.RESULT_SUCCESS) {
			model.addAttribute("entity", result.getEntity());
			return "jsp/system/user/role/edit";
		} else if (result.getCode() == Constant.RESULT_NULL) {
			return NULL_URL;
		} else {
			return ERROR_URL;
		}
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmRole entity) {
		entity.setUpdateUser(UserFactory.userInfo().getCode());
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(String code) {
		return service.deleteByCode(code);
	}

}
