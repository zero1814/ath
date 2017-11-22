package org.module.controller.system.menu;

import org.module.commons.controller.BaseController;
import org.module.commons.helper.CodeHelper;
import org.module.commons.result.BaseResult;
import org.module.commons.result.EntityResult;
import org.module.commons.result.PageResult;
import org.module.commons.util.Constant;
import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.service.system.menu.ISmMenuService;
import org.module.system.factory.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/menu/")
public class SmMenuController extends BaseController {
	@Autowired
	private ISmMenuService service;

	@RequestMapping("index")
	public String index(ModelMap model) {
		model.addAttribute("groups", service.getMenuGroups());
		return "jsp/system/menu/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmMenuDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("addindex")
	public String addIndex(ModelMap model) {
		/**
		 * 分组
		 */
		model.addAttribute("groups", service.getMenuGroups());
		/**
		 * 可用页面
		 */
		model.addAttribute("pages", service.getPages());
		/**
		 * 父级菜单
		 */
		model.addAttribute("menus", service.findAbleAddChildMenu());
		return "jsp/system/menu/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmMenu entity) {
		entity.setCode(CodeHelper.getCode("SM"));
		entity.setCreateUser(UserFactory.userInfo().getCode());
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == Constant.RESULT_SUCCESS) {
			model.addAttribute("entity", result.getEntity());
			/**
			 * 分组
			 */
			model.addAttribute("groups", service.getMenuGroups());
			/**
			 * 可用页面
			 */
			model.addAttribute("pages", service.getPages());
			/**
			 * 父级菜单
			 */
			model.addAttribute("menus", service.findAbleAddChildMenu());
			return "jsp/system/menu/edit";
		} else if (result.getCode() == Constant.RESULT_NULL) {
			return NULL_URL;
		} else {
			return ERROR_URL;
		}
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmMenu entity) {
		String userCode = UserFactory.userInfo().getCode();
		entity.setUpdateUser(userCode);
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(String code) {
		return service.deleteByCode(code);
	}
}
