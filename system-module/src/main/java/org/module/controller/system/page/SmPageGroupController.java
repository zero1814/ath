package org.module.controller.system.page;

import org.module.dto.system.page.SmPageGroupDto;
import org.module.factory.UserFactory;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.page.SmPageGroup;
import org.module.model.system.user.SmUser;
import org.module.result.EntityResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.page.ISmPageGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/page/group/")
public class SmPageGroupController {

	@Autowired
	private ISmPageGroupService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/system/page/group/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmPageGroupDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("addindex")
	public String addIndex() {
		return "jsp/system/page/group/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public RootResult add(SmPageGroup entity) {
		RootResult result = new RootResult();
		SmUser user = UserFactory.instance().userInfo();
		if (user != null) {
			entity.setCode(CodeHelper.getUniqueCode("SPG"));
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
			return "jsp/system/page/group/edit";
		} else {
			return "jsp/error/404";
		}
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(SmPageGroup entity) {
		RootResult result = new RootResult();
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
	public RootResult del(String code) {
		RootResult result = new RootResult();
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
