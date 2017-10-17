package org.module.controller.system.menu;

import org.module.base.result.BaseResult;
import org.module.base.result.EntityResult;
import org.module.base.result.PageResult;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.helper.CodeHelper;
import org.module.model.system.menu.SmMenuGroup;
import org.module.model.system.user.SmUser;
import org.module.service.system.menu.ISmMenuGroupService;
import org.module.system.factory.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/menu/group/")
public class SmMenuGroupController {

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
	public BaseResult add(SmMenuGroup entity) {
		BaseResult result = new BaseResult();
		SmUser user = UserFactory.instance().userInfo();
		if (user != null) {
			entity.setCode(CodeHelper.getUniqueCode("SMG"));
			entity.setCreateUser(user.getCode());
			result = service.insertSelective(entity);
		} else {
			result.setCode(-1);
			result.setMessage("用户尚未登录");
		}
		return result;
	}

	@RequestMapping("editindex")
	public String editIndex(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("group", result.getEntity());
			return "jsp/system/menu/group/edit";
		} else {
			return "jsp/error/404";
		}
	}

	@RequestMapping("edit")
	@ResponseBody
	public BaseResult edit(SmMenuGroup entity) {
		BaseResult result = new BaseResult();
		SmUser user = UserFactory.instance().userInfo();
		if (user != null) {
			entity.setUpdateUser(user.getCode());
			result = service.updateByCode(entity);
		} else {
			result.setCode(-1);
			result.setMessage("用户尚未登录");
		}
		return result;
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(String code) {
		BaseResult result = new BaseResult();
		SmUser user = UserFactory.instance().userInfo();
		if (user != null) {
			result = service.deleteByCode(code);
		} else {
			result.setCode(-1);
			result.setMessage("用户尚未登录");
		}
		return result;
	}

}
