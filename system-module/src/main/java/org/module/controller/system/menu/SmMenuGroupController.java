package org.module.controller.system.menu;

import org.module.base.result.BaseResult;
import org.module.base.result.EntityResult;
import org.module.base.result.PageResult;
import org.module.controller.BaseController;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.helper.CodeHelper;
import org.module.model.system.menu.SmMenuGroup;
import org.module.service.system.menu.ISmMenuGroupService;
import org.module.system.factory.UserFactory;
import org.module.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/menu/group")
public class SmMenuGroupController extends BaseController {
	@Autowired
	private ISmMenuGroupService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/system/menu/group/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmMenuGroupDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("addindex")
	public String addIndex() {
		return "jsp/system/menu/group/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmMenuGroup entity) {
		entity.setCode(CodeHelper.getCode("SMG"));
		entity.setCreateUser(UserFactory.userInfo().getCode());
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == Constant.RESULT_SUCCESS) {
			model.addAttribute("entity", result.getEntity());
			return "jsp/system/menu/group/edit";
		} else if (result.getCode() == Constant.RESULT_NULL) {
			return NULL_URL;
		} else {
			return ERROR_URL;
		}
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmMenuGroup entity) {
		entity.setUpdateUser(UserFactory.userInfo().getCode());
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(String code) {
		return service.deleteByCode(code);
	}
}
