package org.module.controller.system.menu;

import org.module.commons.annotation.obj.Object;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.menu.SmMenu;
import org.module.result.DataResult;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/menu/")
@Object(name = "系统菜单控制器", description = "系统菜单前台交互相关操作")
public class SmMenuController {

	@Autowired
	private ISmMenuService service;

	@RequestMapping("index")
	public String index(String groupCode, ModelMap model) {
		model.addAttribute("groupCode", groupCode);
		return "jsp/system/menu/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public DataResult data(String groupCode) {
		return service.tree(groupCode);
	}

	/**
	 * 
	 * 方法: detail <br>
	 * 描述: 获取菜单信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月22日 上午10:58:08
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("detail")
	public String detail(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("menu", result.getEntity());
		} else {
			model.addAttribute("menu", new SmMenu());
		}
		return "jsp/system/menu/detail";
	}

	@RequestMapping("addindex")
	public String addIndex(String code, String group, ModelMap model) {
		model.addAttribute("parentCode", code);
		model.addAttribute("groupCode", group);
		return "jsp/system/menu/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public RootResult add(SmMenu entity) {
		entity.setCode(CodeHelper.getUniqueCode("SM"));
		entity.setCreateUser("admin");
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex(ModelMap model, String code) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("menu", result.getEntity());
		} else {
			model.addAttribute("menu", new SmMenu());
		}
		return "jsp/system/menu/edit";
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(SmMenu entity) {
		entity.setUpdateUser("admin");
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}

	/**
	 * 
	 * 方法: permission <br>
	 * 描述: 添加权限页 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月26日 上午9:11:54
	 * 
	 * @param code
	 * @param model
	 * @return
	 */
	@RequestMapping("permission")
	@ResponseBody
	public DataResult permission(String code) {
		return service.menusPermission(code);
	}
}
